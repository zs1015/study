package com.lemon.web.auto.day06.section01.testcase.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.lemon.web.auto.day06.section01.base.BaseTester;
import com.lemon.web.auto.day06.section01.util.WebAutoUtils;

/**
 * 单元测试类--》单元测试
 * 
 * @author happy
 *
 */
public class LoginTester extends BaseTester {

	@Test(dataProvider = "dp1", dataProviderClass = LoginDataProvider.class)
	public void test_case(String mobliePhone, String password, String expectedTips) {
		driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/login.html");
		type(By.id("mobilephone"), mobliePhone);
		type(By.id("password"), password);
		click(By.id("login"));
		String actual = getText(By.className("tips"));
		Assert.assertEquals(actual, expectedTips);
	}
}
