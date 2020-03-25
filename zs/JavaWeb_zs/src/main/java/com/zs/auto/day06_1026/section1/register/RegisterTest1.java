package com.zs.auto.day06_1026.section1.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.zs.auto.day06_1026.section1.utils.WebAutoUtils;

public class RegisterTest1 {
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

    @Test(dataProvider = "dataZ",dataProviderClass = RegisterDataProvider.class)
    public void case_test(String mobilephone, String password, String pwdconfirm, String verifycode,
            String expectedTips) {
        driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/register.html");
        driver.findElement(By.id("mobilephone")).sendKeys(mobilephone);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("pwdconfirm")).sendKeys(pwdconfirm);
        driver.findElement(By.id("verifycode")).sendKeys(verifycode);// 万能验证码:LM19
        driver.findElement(By.id("signup-button")).click();
        String actual = driver.findElement(By.className("tips")).getText();
        Assert.assertEquals(actual, expectedTips);
    }

}
