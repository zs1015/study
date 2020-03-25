package com.zs.auto.day06_1026.section2.register;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.zs.auto.day06_1026.section2.base.Base;

public class RegisterTest extends Base {

    @Test(dataProvider = "dataZ", dataProviderClass = RegisterDataProvider.class)
    public void case_test(String mobilephone, String password, String pwdconfirm, String verifycode,
            String expectedTips) {
        // to("http://test.lemonban.com/lmcanon_web_auto/mng/register.html");
        // driver.findElement(By.id("mobilephone")).sendKeys(mobilephone);
        // driver.findElement(By.id("password")).sendKeys(password);
        // driver.findElement(By.id("pwdconfirm")).sendKeys(pwdconfirm);
        // driver.findElement(By.id("verifycode")).sendKeys(verifycode);//
        // String actual = driver.findElement(By.className("tips")).getText();
        to("register_url");
        sendKeys(By.id("mobilephone"), mobilephone);
        sendKeys(By.id("password"), password);
        sendKeys(By.id("pwdconfirm"), pwdconfirm);
        sendKeys(By.id("verifycode"), verifycode);
        click(By.id("signup-button"));
        String actual = getText(By.className("tips"));
        Assert.assertEquals(actual, expectedTips);
    }

}
