package com.lemon.web.auto.day07.section01.testcase.login;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.lemon.web.auto.day07.section01.base.BaseTester;

/**
 * 单元测试类--》单元测试
 * 
 * @author happy
 * * 		反向测试用例方法名：login_failure_test_case
 * 		正向测试用例方法名：login_success_test_case
 */

public class LoginTester extends BaseTester {
	// enabled=false,:让测试用例失效，不执行

	// 反向测试用例
	@Test(dataProvider = "dp", dataProviderClass = LoginDataProvider.class)
	public void login_failure_test_case(LoginFailData failData) {
		to("login_url");
		type(By.id("mobilephone"), failData.getPhone());
		type(By.id("password"), failData.getPassword());
		click(By.id("login"));
		String actual = getElementTextNotNull(By.className("tips"));
		Assert.assertEquals(actual, failData.getExpectedTips());
	}

	// 正向测试用例
	@Test(dataProvider = "dp", dataProviderClass = LoginDataProvider.class)
	public void login_success_test_case(LoginSuccessData successData) {
		to("login_url");
		type(By.id("mobilephone"), successData.getPhone());
		type(By.id("password"), successData.getPassword());
		click(By.id("login"));
		String url = getCurrentPageUrl();
		Assert.assertTrue(url.contains(successData.getPartialUrl()));
	}

}
