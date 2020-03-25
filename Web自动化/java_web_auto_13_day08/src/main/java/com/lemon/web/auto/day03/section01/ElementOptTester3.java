package com.lemon.web.auto.day03.section01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementOptTester3 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://120.78.128.25:8765/Index/login.html");
		driver.findElement(By.name("phone")).sendKeys("13333333333");
		driver.findElement(By.name("password")).sendKeys("123456");
//		driver.findElement(By.className("btn-special")).click();
//		driver.findElement(By.className("btn-special")).submit();
		driver.findElement(By.name("login-form")).submit();
		Thread.sleep(5000);
		driver.quit();
	}
}
