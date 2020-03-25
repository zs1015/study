package com.zs.auto.day06_1026.section1.beifen.section1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.zs.auto.day06_1026.section1.utils.WebAutoUtils;

public class RegisterTest_beifen1 {
    WebDriver driver = null;

    @BeforeClass
    public void beforeClass() {
        // 执行用例前,先创建driver
        String browserName = "Chrome";
        driver = WebAutoUtils.getDriver(browserName, "2.x");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
    @DataProvider
    public Object[][] data(){
        return new Object[][]{
            new Object[] {"","","","","用户名不能为空"},
            new Object[] {"abcd","","","","非法的手机号"},
            new Object[] {"13555550000","","","","密码不能为空"},
            new Object[] {"13555550000","12345","","","密码长度至少为6位"},
            new Object[] {"13555550000","123456","","","重复密码不能为空"},
            new Object[] {"13555550000","123456","22222","","密码不一致"},
            new Object[] {"13555550000","123456","123456","","验证码不能为空"},
        };
    }
    
    @Test(dataProvider = "data")
    public void case_test(String mobilephone, String password, String pwdconfirm, String verifycode, String expectedTips) {
        driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/register.html");
        driver.findElement(By.id("mobilephone")).sendKeys(mobilephone);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("pwdconfirm")).sendKeys(pwdconfirm);
        driver.findElement(By.id("verifycode")).sendKeys(verifycode);// 万能验证码:LM19
        driver.findElement(By.id("signup-button")).click();
        String actual = driver.findElement(By.className("tips")).getText();
        Assert.assertEquals(actual, expectedTips);
    }
    /*
     * @Test public void case2() {
     * driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/register.html")
     * ; driver.findElement(By.id("mobilephone")).sendKeys("lemon");
     * driver.findElement(By.id("password")).sendKeys("");
     * driver.findElement(By.id("pwdconfirm")).sendKeys("");
     * driver.findElement(By.id("verifycode")).sendKeys("");// 万能验证码:LM19
     * driver.findElement(By.id("signup-button")).click(); String actual =
     * driver.findElement(By.className("tips")).getText(); String expected =
     * "非法的手机号"; Assert.assertEquals(actual, expected); }
     * 
     * @Test public void case3() {
     * driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/register.html")
     * ; driver.findElement(By.id("mobilephone")).sendKeys("13666666666");
     * driver.findElement(By.id("password")).sendKeys("");
     * driver.findElement(By.id("pwdconfirm")).sendKeys("");
     * driver.findElement(By.id("verifycode")).sendKeys("");// 万能验证码:LM19
     * driver.findElement(By.id("signup-button")).click(); String actual =
     * driver.findElement(By.className("tips")).getText(); String expected =
     * "密码不能为空"; Assert.assertEquals(actual, expected); }
     * 
     * @Test public void case4() {
     * driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/register.html")
     * ; driver.findElement(By.id("mobilephone")).sendKeys("13666666666");
     * driver.findElement(By.id("password")).sendKeys("12345");
     * driver.findElement(By.id("pwdconfirm")).sendKeys("");
     * driver.findElement(By.id("verifycode")).sendKeys("");// 万能验证码:LM19
     * driver.findElement(By.id("signup-button")).click(); String actual =
     * driver.findElement(By.className("tips")).getText(); String expected =
     * "密码长度至少为6位"; Assert.assertEquals(actual, expected); }
     * 
     * @Test public void case5() {
     * driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/register.html")
     * ; driver.findElement(By.id("mobilephone")).sendKeys("13666666666");
     * driver.findElement(By.id("password")).sendKeys("123456");
     * driver.findElement(By.id("pwdconfirm")).sendKeys("");
     * driver.findElement(By.id("verifycode")).sendKeys("");// 万能验证码:LM19
     * driver.findElement(By.id("signup-button")).click(); String actual =
     * driver.findElement(By.className("tips")).getText(); String expected =
     * "重复密码不能为空"; Assert.assertEquals(actual, expected); }
     * 
     * @Test public void case6() {
     * driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/register.html")
     * ; driver.findElement(By.id("mobilephone")).sendKeys("13666666666");
     * driver.findElement(By.id("password")).sendKeys("123456");
     * driver.findElement(By.id("pwdconfirm")).sendKeys("12345");
     * driver.findElement(By.id("verifycode")).sendKeys("");// 万能验证码:LM19
     * driver.findElement(By.id("signup-button")).click(); String actual =
     * driver.findElement(By.className("tips")).getText(); String expected =
     * "密码不一致"; Assert.assertEquals(actual, expected); }
     */
}
