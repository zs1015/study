package com.lemon.web.auto.day06.section01.testcase.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.lemon.web.auto.day06.section01.util.WebAutoUtils;

public class LoginTester2 {
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

	@Test(dataProvider = "dp1", dataProviderClass = LoginDataProvider.class)
	public void test_case(String mobliePhone, String password, String expectedTips) {
		driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/login.html");
		driver.findElement(By.id("mobilephone")).sendKeys(mobliePhone);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login")).click();
		String actual = driver.findElement(By.className("tips")).getText();
		Assert.assertEquals(actual, expectedTips);
	}
}
