package com.lemon.web.auto.day05.section02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginTester {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = WebAutoUtils.getDriver("Chrome","2.x");
		driver.get("http://www.baidu.com");
		driver.findElement(By.id("kw")).sendKeys("柠檬班软件测试");

		Thread.sleep(5000);
		driver.quit();
	}

}
