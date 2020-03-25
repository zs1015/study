package com.lemon.web.auto.day08.section01.testcase.login;

import java.util.Map;

import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.lemon.web.auto.day08.section01.base.BaseTester;
import com.lemon.web.auto.day08.section01.pojo.Locator;
import com.lemon.web.auto.day08.section01.util.LocatorUtils;

public class LoginTester extends BaseTester {
	// 反向测试用例
	@Test(dataProvider = "dp1", dataProviderClass = LoginDataProvider.class)
	public void login_failure_test_case(LoginFailData failData) throws DocumentException {
		to("login_url");
		type("登录页面", "手机号码输入框",failData.getPhone());
		type("登录页面", "密码输入框",failData.getPassword());
		click("登录页面","登录按钮");
//		String actual = getElementTextNotNull(tipsLocator);
//		Assert.assertEquals(actual, failData.getExpectedTips());
	}

	// 正向测试用例
	@Test(enabled=false,dataProvider = "dp2", dataProviderClass = LoginDataProvider.class)
	public void login_success_test_case(LoginSuccessData successData) {
		to("login_url");
		type(By.id("mobilephone"), successData.getPhone());
		type(By.id("password"), successData.getPassword());
		click(By.id("login"));
		Assert.assertTrue(currentPageUrlContains(successData.getPartialUrl()));
	}

}
