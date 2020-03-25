package com.lemon.web.auto.day06.section02.testcase.register;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.lemon.web.auto.day06.section02.base.BaseTester;

public class RegisterTester extends BaseTester {

	@Test(dataProvider = "dp1", dataProviderClass = RegisterDataProvider.class)
	public void test_case(String mobliePhone, String password, String pwdConfirm, String verifyCode,
			String expectedTips) {
		to("register_url");
		type(By.id("mobilephone"), mobliePhone);
		type(By.id("password"), password);
		type(By.id("pwdconfirm"), pwdConfirm);
		type(By.id("verifycode"), verifyCode);
		click(By.id("signup-button"));
		String actual = getText(By.className("tips"));
		Assert.assertEquals(actual, expectedTips);
	}

}
