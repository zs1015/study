package com.lemon.web.auto.day04.section01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTester_5 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/login.html");
//		driver.findElement(By.id("mobilephone")).sendKeys("13888888888");
//		;
//		driver.findElement(By.id("password")).sendKeys("123456");
//		driver.findElement(By.id("login")).click();
//		// 点击排课管理
//		driver.findElement(By.id("class-manage")).click();
//
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//当元素可点击的时候
//		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("一周排课")));
		driver.get("http://www.baidu.com");
		
		//期望条件：id为kw元素，value属性值包含hello的时候
//		ExpectedConditions.attributeContains(By.id("kw"), "value", "hello");
		//期望条件：当页面上id为kw的元素的数量小于5个的时候
		
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.id("kw"), 5));
		System.out.println("-------------------------------------------");
//		ExpectedConditions.textMatches(locator, pattern)
//		ExpectedConditions.titleContains("百度一下");
		//点击一周排课
//		element.click();

		Thread.sleep(5000);
		driver.quit();
	}
}
