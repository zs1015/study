package com.lemon.web.auto.testcase.register;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.lemon.web.auto.base.BaseTester;
import com.lemon.web.auto.base.CaseDataProvider;

public class RegisterTester extends BaseTester {

	
	@Test(dataProvider = "dp", dataProviderClass = CaseDataProvider.class)
	public void register_failure_test_case(RegisterFailureData failureData) {
		to("register_url");
//		type(By.id("mobilephone"), failureData.getPhone());
//		type(By.id("password"), failureData.getPassword());
//		type(By.id("pwdconfirm"), failureData.getPwdConfirm());
//		type(By.id("verifycode"), failureData.getVerifyCode());
//		click(By.id("signup-button"));
		
		type(By.id("mobilephone"), failureData.getPhone());
		type(By.id("password"), failureData.getPassword());
		type(By.id("pwdconfirm"), failureData.getPwdConfirm());
		type(By.id("verifycode"), failureData.getVerifyCode());
		click(By.id("signup-button"));
		
//		String actual = getText(By.className("tips"));
//		Assert.assertEquals(actual, failureData.getExpectedTips());
	}

}
