package com.zs.auto.day09_1102.testcase.register;

import org.testng.annotations.Test;

import com.zs.auto.day09_1102.base.Base;
import com.zs.auto.day09_1102.base.CaseDataProvider;

public class RegisterTest extends Base {

    @Override
    protected String getCurrentPageName() {
        return this.pageName = "注册页面";
    }

    @Test(dataProvider = "dp", dataProviderClass = CaseDataProvider.class)
    public void register_fail_case(RegisterFailData failData) {
        to("register_url");
        // sendKeys(By.id("mobilephone"), failData.getMobilephone());
        // sendKeys(By.id("password"), failData.getPassword());
        // sendKeys(By.id("pwdconfirm"), failData.getPwdconfirm());
        // sendKeys(By.id("verifycode"), failData.getVerifycode());
        // click(By.id("signup-button"));
        // String actual = getText(By.className("tips"));

        sendKeys("手机号码输入框", failData.getMobilephone());
        sendKeys("密码输入框", failData.getPassword());
        sendKeys("重复密码输入框", failData.getPwdconfirm());
        sendKeys("验证码", failData.getVerifycode());
        click("注册按钮");
        assertElementTextEquals("提示信息元素", failData.getExpectedTips());
    }

}
