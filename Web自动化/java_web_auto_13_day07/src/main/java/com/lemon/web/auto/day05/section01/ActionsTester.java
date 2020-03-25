package com.lemon.web.auto.day05.section01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsTester {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.baidu.com/");
		
		WebElement input = driver.findElement(By.id("kw"));
		WebElement button = driver.findElement(By.id("su"));

		Actions actions = new Actions(driver);//创建Action对象
//		Thread.sleep(2000);
//		actions.sendKeys(input, "您好").perform();//键盘输入
//		Thread.sleep(2000);
//		actions.moveToElement(button).perform();//移动鼠标并点击
//		Thread.sleep(2000);
//		actions.click().perform();//点击
		
		//链式调用
		actions.sendKeys(input,"柠檬班").moveToElement(button).click().perform();;

		
		Thread.sleep(5000);
		driver.quit();
	}
}
