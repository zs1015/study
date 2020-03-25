package com.zs.auto.day08_1031.login;

import java.io.IOException;

import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.zs.auto.day08_1031.base.Base;
import com.zs.auto.day08_1031.pojo.Locator;
import com.zs.auto.day08_1031.utils.LocatorUtils;

public class LoginTest extends Base {

    @Test(dataProvider = "login_fail_case", dataProviderClass = LoginDataProvider.class)
    public void login_fail_case(LoginFailData loginFailData) throws IOException, DocumentException {
        to("login_url");
        // Locator phone =
        // LocatorUtils.getLocatorsByPageNameAndLocatorName("登录页面", "手机号码输入框");
        // Locator password =
        // LocatorUtils.getLocatorsByPageNameAndLocatorName("登录页面", "密码输入框");
        // Locator login =
        // LocatorUtils.getLocatorsByPageNameAndLocatorName("登录页面", "登录按钮");
        // Locator tips =
        // LocatorUtils.getLocatorsByPageNameAndLocatorName("登录页面", "提示信息元素");
        // sendKeys(phone, loginFailData.getMobilephone());
        // sendKeys(password, loginFailData.getMobilephone());
        // click(login);
        
        //完美
        sendKeys("登录页面", "手机号码输入框", loginFailData.getMobilephone());
        sendKeys("登录页面", "密码输入框", loginFailData.getPassword());
        getText("登录页面", "提示信息元素");
        click("登录页面", "登录按钮");
        
        // String actual = getElementNotnull(tips);
        // Assert.assertEquals(actual, loginFailData.getExpectedTips());
    }

    @Test(enabled = false, dataProvider = "login_success_case", dataProviderClass = LoginDataProvider.class)
    public void login_success_case(LoginSuccessData loginSuccessData) throws IOException {
        to("login_url");
        sendKeys(By.id("mobilephone"), loginSuccessData.getMobilephone());
        sendKeys(By.id("password"), loginSuccessData.getPassword());
        click(By.id("login"));
        Assert.assertTrue(currentContainsPratiaUrl(loginSuccessData.getPratiaUrl()));
    }
}
