package com.lemon.web.auto.day06.section01.testcase.register;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.lemon.web.auto.day06.section01.base.BaseTester;

public class RegisterTester3 extends BaseTester{

	@Test(dataProvider = "dp1", dataProviderClass = RegisterDataProvider.class)
	public void test_case(String mobliePhone, String password, String pwdConfirm, String verifyCode,
			String expectedTips) {
		driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/register.html");
		//提供一个简单的方法来输入内容
		//提供一个简单的方法来点击元素
		//提供一个简单的方法来获取元素文本
//		driver.findElement(By.id("mobilephone")).sendKeys(mobliePhone);
//		driver.findElement(By.id("password")).sendKeys(password);
//		driver.findElement(By.id("pwdconfirm")).sendKeys(pwdConfirm);
//		driver.findElement(By.id("verifycode")).sendKeys(verifyCode);
//		driver.findElement(By.id("signup-button")).click();
		type(By.id("mobilephone"), mobliePhone);
		type(By.id("password"), password);
		type(By.id("pwdconfirm"), pwdConfirm);
		type(By.id("verifycode"), verifyCode);
		click(By.id("signup-button"));
		String actual = getText(By.className("tips"));
		
		Assert.assertEquals(actual, expectedTips);
	}
	
	
}
