package com.zs.auto.day07_1029.login;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.zs.auto.day07_1029.base.Base;

public class LoginTest extends Base {

    // enabled=false,失效
    @Test(dataProvider = "login_fail_case", dataProviderClass = LoginDataProvider.class)
    public void login_fail_case(LoginFailData loginFailData) throws IOException {
        to("login_url");
        sendKeys(By.id("mobilephone"), loginFailData.getMobilephone());
        sendKeys(By.id("password"), loginFailData.getPassword());
        click(By.id("login"));
        String actual = getElementNotnull(By.className("tips"));
        Assert.assertEquals(actual, loginFailData.getExpectedTips());
    }

    @Test(dataProvider = "login_success_case", dataProviderClass = LoginDataProvider.class)
    public void login_success_case(LoginSuccessData loginSuccessData) throws IOException {
        to("login_url");
        sendKeys(By.id("mobilephone"), loginSuccessData.getMobilephone());
        sendKeys(By.id("password"), loginSuccessData.getPassword());
        click(By.id("login"));
        // 登录成功后跳转页面(可能还没跳转到主页,就断言错误,可以硬性等待,也可以智能等待
        String actualUrl = getCurrent();
        // Assert.assertEquals(actualUrl, expectedTips);
        Assert.assertTrue(actualUrl.contains(loginSuccessData.getPratiaUrl()));
        Assert.assertTrue(currentContainsPratiaUrl(loginSuccessData.getPratiaUrl()));
    }
}
