package com.lemon.testcases;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.lemon.base.BasePage;

import aj.org.objectweb.asm.Type;

public class LoginTest extends BasePage{


	@BeforeTest
	public void setUp() throws MalformedURLException, InterruptedException {
		//前置准备--进入到登录页面
		tap("主页页面","我的柠檬");
		tap("主页页面", "点击头像登录");
	}

	@Test(priority=2)
	public void testLoginSuccess() throws InterruptedException {
		type("登录页面", "手机号码输入框", "13323234545");
		type("登录页面", "密码输入框","234545");
		tap("登录页面", "登录按钮");
		//TODO 断言
	}

	@Test(priority=1)
	public void testLoginFailure() throws InterruptedException {
		type("登录页面", "手机号码输入框", "14425253434");
		type("登录页面", "密码输入框","123456");
		tap("登录页面", "登录按钮");
		//TODO 断言
	}


}
