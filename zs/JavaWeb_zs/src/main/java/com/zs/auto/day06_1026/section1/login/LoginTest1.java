package com.zs.auto.day06_1026.section1.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.zs.auto.day06_1026.section1.utils.WebAutoUtils;

public class LoginTest1 {
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
        Thread.sleep(3000);
        driver.close();
    }

    @Test(dataProvider = "dataF", dataProviderClass = LoginDataProvider.class)
    public void case_test(String mobilephone, String password, String expectedTips) {
        driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/login.html");
        driver.findElement(By.id("mobilephone")).sendKeys(mobilephone);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login")).click();
        String actual = driver.findElement(By.className("tips")).getText();
        Assert.assertEquals(actual, expectedTips);
    }
    //@Test
    public void case_test1() {
        driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/login.html");
        driver.findElement(By.id("mobilephone")).sendKeys("13566667777");
        driver.findElement(By.id("password")).sendKeys("12345");
        driver.findElement(By.id("login")).click();
        String actual = driver.findElement(By.className("tips")).getText();
        Assert.assertEquals(actual, "账号信息错误");
    }

}
