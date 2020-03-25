package com.zs.auto.day05_1024.test2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterTest {
    WebDriver driver = null;

    @BeforeClass
    public void beforeClass() {
        // 执行用例前,先创建driver
        String browserName = "Chrome";
        driver = WebAutoUtils.getDriver(browserName, "2.x");

    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void case1() throws InterruptedException {
        driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/register.html");
        driver.findElement(By.id("mobilephone")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("pwdconfirm")).sendKeys("");
        driver.findElement(By.id("verifycode")).sendKeys("");// 万能验证码:LM19
        driver.findElement(By.id("signup-button")).click();
        String actual = driver.findElement(By.className("tips")).getText();
        String expected = "用户名不能为空";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void case2() throws InterruptedException {
        driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/register.html");
        driver.findElement(By.id("mobilephone")).sendKeys("lemon");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("pwdconfirm")).sendKeys("");
        driver.findElement(By.id("verifycode")).sendKeys("");// 万能验证码:LM19
        driver.findElement(By.id("signup-button")).click();
        String actual = driver.findElement(By.className("tips")).getText();
        String expected = "非法的手机号";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void case3() throws InterruptedException {
        driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/register.html");
        driver.findElement(By.id("mobilephone")).sendKeys("13666666666");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("pwdconfirm")).sendKeys("");
        driver.findElement(By.id("verifycode")).sendKeys("");// 万能验证码:LM19
        driver.findElement(By.id("signup-button")).click();
        String actual = driver.findElement(By.className("tips")).getText();
        String expected = "密码不能为空";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void case4() throws InterruptedException {
        driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/register.html");
        driver.findElement(By.id("mobilephone")).sendKeys("13666666666");
        driver.findElement(By.id("password")).sendKeys("12345");
        driver.findElement(By.id("pwdconfirm")).sendKeys("");
        driver.findElement(By.id("verifycode")).sendKeys("");// 万能验证码:LM19
        driver.findElement(By.id("signup-button")).click();
        String actual = driver.findElement(By.className("tips")).getText();
        String expected = "密码长度至少为6位";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void case5() throws InterruptedException {
        driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/register.html");
        driver.findElement(By.id("mobilephone")).sendKeys("13666666666");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("pwdconfirm")).sendKeys("");
        driver.findElement(By.id("verifycode")).sendKeys("");// 万能验证码:LM19
        driver.findElement(By.id("signup-button")).click();
        String actual = driver.findElement(By.className("tips")).getText();
        String expected = "重复密码不能为空";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void case6() throws InterruptedException {
        driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/register.html");
        driver.findElement(By.id("mobilephone")).sendKeys("13666666666");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("pwdconfirm")).sendKeys("12345");
        driver.findElement(By.id("verifycode")).sendKeys("");// 万能验证码:LM19
        driver.findElement(By.id("signup-button")).click();
        String actual = driver.findElement(By.className("tips")).getText();
        String expected = "密码不一致";
        Assert.assertEquals(actual, expected);
    }

}
