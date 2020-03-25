package com.lemon.web.auto.testcase.register;

import org.testng.annotations.Test;

import com.lemon.web.auto.base.BaseTester;
import com.lemon.web.auto.base.CaseDataProvider;


/**
 * 日志：log4j
 * 报告：allure、reportng、extentreportng
 * UI层面测试：错误截图 --》先自己去尝试
 * @author happy
 *
 */
public class RegisterTester extends BaseTester {
	@Override
	protected String getCurrentPageName() {
		return "注册页面";
	}
	
	//手机号码输入框   密码输入框这些仅仅元素的描述信息，是我们执行测试用例的关键的信息
	//之所以能这样去使用，是我们不断封装的一个结果--》【关键字驱动框架】
	@Test(dataProvider = "dp", dataProviderClass = CaseDataProvider.class)
	public void register_failure_test_case(RegisterFailureData failureData) {
		to("register_url");
		type("手机号码输入框", failureData.getPhone());
		type("密码输入框", failureData.getPassword());
		type("重复密码输入框", failureData.getPwdConfirm());
		type("验证码", failureData.getVerifyCode());
		click("注册按钮");
		
		//通用检查点，通用的断言、统一的验证方法
		assertElementTextEquals("提示信息元素", failureData.getExpectedTips());
		
	}



}
