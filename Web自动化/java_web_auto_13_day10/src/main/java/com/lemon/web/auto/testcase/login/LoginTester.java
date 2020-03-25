package com.lemon.web.auto.testcase.login;

import org.dom4j.DocumentException;
import org.testng.annotations.Test;

import com.lemon.web.auto.base.BaseTester;
import com.lemon.web.auto.base.CaseDataProvider;

/**
 * 登录的测试类
 * @author happy
 *
 */
public class LoginTester extends BaseTester {
	
	@Override
	protected String getCurrentPageName() {
		return "登录页面";
	}
	
	// 反向测试用例
	@Test(dataProvider = "dp", dataProviderClass = CaseDataProvider.class)
	public void login_failure_test_case(LoginFailureData failData) throws DocumentException {
		to("login_url");
		type("手机号码输入框",failData.getPhone());
		type("密码输入框",failData.getPassword());
		click("登录按钮");
		//断言提示信息元素的内容不为空，并且和期望值相等
		assertElementTextEquals("提示信息元素",failData.getExpectedTips());//需要什么数据
	}

	// 正向测试用例
	@Test(enabled=false,dataProvider = "dp", dataProviderClass = CaseDataProvider.class)
	public void login_success_test_case(LoginSuccessData successData) {
		to("login_url");
		type("手机号码输入框",successData.getPhone());
		type("密码输入框",successData.getPassword());
		click("登录按钮");
		assertPageUrlContains(successData.getPartialUrl());
	}

}
