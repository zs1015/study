package com.lemon.web.auto.day06.section01.bak;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.lemon.web.auto.day06.section01.util.WebAutoUtils;

public class RegisterTester3 {
	WebDriver driver = null;

	@BeforeClass
	public void beforeClass() {
		driver = WebAutoUtils.getDriver("Chrome", "2.x");
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
	
	 @DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { "", "", "", "", "用户名不能为空" },
	      new Object[] { "lemon", "", "", "", "非法的手机号" },
	      new Object[] { "13888888888", "", "", "", "密码不能为空" },
	      new Object[] { "13888888888", "12345", "", "", "密码长度至少为6位" },
	      new Object[] { "13888888888", "123456", "", "", "重复密码不能为空" },
	      new Object[] { "13888888888", "123456", "12345", "", "密码不一致" },
	      new Object[] { "13888888888", "123456", "123456", "", "验证码不能为空" },
	    };
	  }
	
	@Test(dataProvider="dp")
	public void test_case(String mobliePhone,String password,String pwdConfirm,String verifyCode,String expectedTips) {
		driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/register.html");
		driver.findElement(By.id("mobilephone")).sendKeys(mobliePhone);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("pwdconfirm")).sendKeys(pwdConfirm);
		driver.findElement(By.id("verifycode")).sendKeys(verifyCode);
		driver.findElement(By.id("signup-button")).click();
		String actual = driver.findElement(By.className("tips")).getText();
		Assert.assertEquals(actual, expectedTips);
	}
}
