package com.lemon.web.auto.day05.section01;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsTester2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.treejs.cn/v3/demo/cn/exedit/drag.html");
		
		WebElement element1 = driver.findElement(By.id("treeDemo_4_a"));
		WebElement element2 = driver.findElement(By.id("treeDemo_8_span"));
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		actions.moveToElement(element1).clickAndHold().moveToElement(element2).release().perform();
/*		Thread.sleep(3000);
		actions.moveToElement(element1).perform();
		Thread.sleep(3000);
		actions.clickAndHold().perform();
		Thread.sleep(3000);
		actions.moveToElement(element2);
		Thread.sleep(3000);
		actions.release().perform();*/
		Thread.sleep(5000);
		driver.quit();
	}
}
