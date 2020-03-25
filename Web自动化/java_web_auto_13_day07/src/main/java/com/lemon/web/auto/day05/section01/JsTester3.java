package com.lemon.web.auto.day05.section01;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JsTester3 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.baidu.com/");
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		
		//document.body.scrollHeight 可滚动的高度document.body.scrollHeight
		String js = "$('#kw').val('柠檬班软件测试');";
		executor.executeScript(js);
		
		Thread.sleep(5000);
		driver.quit();
	}
}
