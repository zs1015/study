package com.zs.auto.day06_1026.section1.login;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.zs.auto.day06_1026.section1.base.Base;

public class LoginTest extends Base {

    @Test(dataProvider = "dataF", dataProviderClass = LoginDataProvider.class)
    public void case_test(String mobilephone, String password, String expectedTips) {
        driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/login.html");
        // driver.findElement(By.id("mobilephone")).sendKeys(mobilephone);
        // driver.findElement(By.id("password")).sendKeys(password);
        // driver.findElement(By.id("login")).click();
        // String actual = driver.findElement(By.className("tips")).getText();
        
        sendKeys(By.id("mobilephone"), mobilephone);
        sendKeys(By.id("password"), password);
        click(By.id("login"));
        String actual = getText(By.className("tips"));
        Assert.assertEquals(actual, expectedTips);
    }
    // @Test
    // public void case_test1() {
    // driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/login.html");
    // driver.findElement(By.id("mobilephone")).sendKeys("13566667777");
    // driver.findElement(By.id("password")).sendKeys("12345");
    // driver.findElement(By.id("login")).click();
    // String actual = driver.findElement(By.className("tips")).getText();
    // Assert.assertEquals(actual, "账号信息错误");
    // }

}
