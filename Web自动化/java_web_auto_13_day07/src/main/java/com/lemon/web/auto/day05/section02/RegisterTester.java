package com.lemon.web.auto.day05.section02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterTester {
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

	@Test
	public void test_case_1() {
		driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/register.html");
		driver.findElement(By.id("mobilephone")).sendKeys("");
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.id("pwdconfirm")).sendKeys("");
		driver.findElement(By.id("verifycode")).sendKeys("");
		driver.findElement(By.id("signup-button")).click();
		String actual = driver.findElement(By.className("tips")).getText();
		String expected = "用户名不能为空";
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void test_case_2() {
		driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/register.html");
		driver.findElement(By.id("mobilephone")).sendKeys("lemon");
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.id("pwdconfirm")).sendKeys("");
		driver.findElement(By.id("verifycode")).sendKeys("");
		driver.findElement(By.id("signup-button")).click();
		String actual = driver.findElement(By.className("tips")).getText();
		String expected = "非法的手机号";
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void test_case_3() {
		driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/register.html");
		driver.findElement(By.id("mobilephone")).sendKeys("13888888888");
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.id("pwdconfirm")).sendKeys("");
		driver.findElement(By.id("verifycode")).sendKeys("");
		driver.findElement(By.id("signup-button")).click();
		String actual = driver.findElement(By.className("tips")).getText();
		String expected = "密码不能为空";
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void test_case_4() {
		driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/register.html");
		driver.findElement(By.id("mobilephone")).sendKeys("13888888888");
		driver.findElement(By.id("password")).sendKeys("12345");
		driver.findElement(By.id("pwdconfirm")).sendKeys("");
		driver.findElement(By.id("verifycode")).sendKeys("");
		driver.findElement(By.id("signup-button")).click();
		String actual = driver.findElement(By.className("tips")).getText();
		String expected = "密码长度至少为6位";
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void test_case_5() {
		driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/register.html");
		driver.findElement(By.id("mobilephone")).sendKeys("13888888888");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("pwdconfirm")).sendKeys("");
		driver.findElement(By.id("verifycode")).sendKeys("");
		driver.findElement(By.id("signup-button")).click();
		String actual = driver.findElement(By.className("tips")).getText();
		String expected = "重复密码不能为空";
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void test_case_6() {
		driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/register.html");
		driver.findElement(By.id("mobilephone")).sendKeys("13888888888");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("pwdconfirm")).sendKeys("12345");
		driver.findElement(By.id("verifycode")).sendKeys("");
		driver.findElement(By.id("signup-button")).click();
		String actual = driver.findElement(By.className("tips")).getText();
		String expected = "密码不一致";
		Assert.assertEquals(actual, expected);
	}
}
