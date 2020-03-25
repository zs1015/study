package com.lemon.testcases;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.lemon.base.BasePage;

import aj.org.objectweb.asm.Type;

public class LoginTest extends BasePage {

	@BeforeClass
	public void setUp() throws MalformedURLException, InterruptedException {
		// 前置准备--进入到登录页面
		tap("主页页面", "我的柠檬");
		tap("主页页面", "点击头像登录");
	}

	@Test(priority = 2)
	public void testLoginSuccess() throws InterruptedException {
		type("登录页面", "手机号码输入框", "13323234545");
		type("登录页面", "密码输入框", "234545");
		tap("登录页面", "登录按钮");
		Thread.sleep(3000);
		//断言 -- 判断跳转的页面是否为主页页面
		String expectedValue = getActivityNameByPageDesc("主页页面");
		String actualValue = getCurrentActivity();
		Assert.assertEquals(actualValue, expectedValue);
	}

	@Test(priority = 1,dataProvider="getLoginFailureDatas")
	public void testLoginFailure(String mobilephone, String password, String tips) throws InterruptedException {
		type("登录页面", "手机号码输入框", mobilephone);
		type("登录页面", "密码输入框", password);
		tap("登录页面", "登录按钮");
		// 断言 -- toast提示信息做断言
		String expectedValue = tips;
		String actualValue = getToastTips(tips);
		Assert.assertEquals(actualValue, expectedValue);
	}

	@DataProvider
	public Object[][] getLoginFailureDatas(){
		Object[][] objects = {{"13323234545","123456","错误的账号信息"},
				{"","123456","手机号码或密码不能为空"},{"1332323454","123456","手机号码格式不正确"},
				{"","","手机号码或密码不能为空"}};
		return objects;
	}

}
