package com.zs.auto.day07_1029.login;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.zs.auto.day07_1029.base.Base;

public class LoginTest1 extends Base {

    // enabled=false,失效
    @Test(enabled = false, dataProvider = "data_fail", dataProviderClass = LoginDataProvider.class)
    public void case_test_fail(String mobilephone, String password, String expectedTips) throws IOException {
        to("login_url");
        sendKeys(By.id("mobilephone"), mobilephone);
        sendKeys(By.id("password"), password);
        click(By.id("login"));
        String actual = getElementNotnull(By.className("tips"));
        Assert.assertEquals(actual, expectedTips);
    }

    @Test(dataProvider = "data_success", dataProviderClass = LoginDataProvider.class)
    public void case_test_success(String mobilephone, String password, String partialUrl) throws IOException {
        to("login_url");
        sendKeys(By.id("mobilephone"), mobilephone);
        sendKeys(By.id("password"), password);
        click(By.id("login"));
        // 登录成功后跳转页面
        String actualUrl = getCurrent();
        // Assert.assertEquals(actualUrl, expectedTips);
        Assert.assertTrue(actualUrl.contains(partialUrl));
    }
}
