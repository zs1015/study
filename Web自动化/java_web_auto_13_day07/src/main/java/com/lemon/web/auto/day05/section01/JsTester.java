package com.lemon.web.auto.day05.section01;

import org.openqa.selenium.chrome.ChromeDriver;

public class JsTester {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://lemon.ke.qq.com/");
		
		//document.body.scrollHeight 可滚动的高度document.body.scrollHeight
		String js = "window.scroll(0,document.body.scrollHeight);";
		driver.executeScript(js);
		Thread.sleep(5000);
		driver.quit();
	}
}
