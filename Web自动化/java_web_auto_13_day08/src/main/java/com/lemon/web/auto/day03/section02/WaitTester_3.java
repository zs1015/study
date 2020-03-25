package com.lemon.web.auto.day03.section02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTester_3 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/login.html");
		driver.findElement(By.id("mobilephone")).sendKeys("13888888888");
		;
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("login")).click();
		// 点击排课管理
		driver.findElement(By.id("class-manage")).click();
		
		//延时等待3：智能等待，显式等待
		//直到找到一周排课元素
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver input) {
				System.out.println("---------------------------------");
				return driver.findElement(By.linkText("一周排课111"));
			}
		});
		
		element.click();
		
		Thread.sleep(5000);
		driver.quit();
	}
}
