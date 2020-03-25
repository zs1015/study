package com.lemon.web.auto.day07.section01.testcase.register;

import org.testng.annotations.DataProvider;

import com.lemon.web.auto.day07.section01.testcase.login.LoginFailData;
import com.lemon.web.auto.day07.section01.testcase.login.LoginSuccessData;
import com.lemon.web.auto.day07.section01.util.DataProviderUtils;

public class RegisterDataProvider2 {
	// 反向测试用例的数据提供者
	@DataProvider
	public static Object[][] dp1() {
		return DataProviderUtils.getData("/testcase/register/register.xlsx", 0, LoginFailData.class);
	}

	// 正向测试用例的数据提供者
	@DataProvider
	public static Object[][] dp2() {
		return DataProviderUtils.getData("/testcase/register/register.xlsx", 1, LoginSuccessData.class);
	}
}
