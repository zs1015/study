package com.lemon.web.auto.day04.section01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTester_4 {

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
		/**
		 *  1.the function returns neither null nor false, 当这个方法返回了既不是null也不是false
			2.the function throws an unignored exception, 这个方法抛出了一个不可忽略的异常
			3.the timeout expires, 超时
			4.the current thread is interrupted 当这个线程被打断时

		 */
	/*	WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver input) {
				System.out.println("---------------------------------");
				return driver.findElement(By.linkText("一周排课111"));
			}
		});*/
		
		/*WebDriverWait wait2 = new WebDriverWait(driver, 10);
		Boolean isDisplayed = wait2.until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver input) {
				System.out.println("---------------------------------");
				return driver.findElement(By.linkText("一周排课111")).isDisplayed();//当页面显示这个元素的时候
			}
		});*/
		/*WebDriverWait wait2 = new WebDriverWait(driver, 10);
		Boolean isDisplayed = wait2.until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver input) {
				System.out.println("---------------------------------");
				return driver.findElement(By.linkText("一周排课111")).isEnabled();//当元素有效的时候 
			}
		});*/
		
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		Boolean flag = wait2.until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver input) {
//				return driver.findElement(By.linkText("aaaa")).getAttribute("value").equals("Hello World");
				//期望条件：当id为kw的元素value属性值为你好的时候
				return driver.findElement(By.id("kw")).getAttribute("value").equals("你好");
			}
		});
		
//		element.click();
		
		Thread.sleep(5000);
		driver.quit();
	}
}
