package com.lemon.web.auto.day06.section02.testcase.login;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.lemon.web.auto.day06.section02.base.BaseTester;

/**
 * 单元测试类--》单元测试
 * 
 * @author happy
 *
 */
public class LoginTester extends BaseTester {

	@Test(dataProvider = "dp1", dataProviderClass = LoginDataProvider.class)
	public void test_case(String mobliePhone, String password, String expectedTips) {
		to("login_url");
		type(By.id("mobilephone"), mobliePhone);
		type(By.id("password"), password);
		click(By.id("login"));
		String actual = getText(By.className("tips"));
		Assert.assertEquals(actual, expectedTips);
	}
	
	public static void main(String[] args) throws IOException {
		Properties properties = new Properties();
		properties.load(LoginTester.class.getResourceAsStream("/url.properties"));
		System.out.println(properties.getProperty("login_url"));
	}
}
