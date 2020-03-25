package com.lemon.web.auto.day04.section02;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectTester {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/login.html");
		driver.findElement(By.id("mobilephone")).sendKeys("13888888888");
		;
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("login")).click();
		Thread.sleep(2000);
		// 点击排课管理
		driver.findElement(By.id("class-manage")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("一周排课")).click();
		Thread.sleep(5000);
//		切换方式：
//		iframe的索引，在页面中的位置
//		driver.switchTo().frame(index)
//		iframe的name或id
//		driver.switchTo().frame(id)
//		driver.switchTo().frame(name)
//		iframe WebElement
//		driver.switchTo().frame(WebElement)
//		回到默认内容页面(否则会找不到元素)
//		driver.switchTo().defaultContent()
		WebElement iframeElement = driver.findElement(By.cssSelector("iframe[src='class-plan-list.html']"));
		//切换
		driver.switchTo().frame(iframeElement);
		//选择下拉框中间的haha
//		driver.findElement(By.cssSelector("option[value=\"1272\"]")).click();
		// Select select = new Select(WebElement element)
		Select select = new Select(driver.findElement(By.name("teacher")));
		// Select对象常用api
		// select.getOptions()：获取所有选项
//		List<WebElement> options = select.getOptions();
//		for (WebElement option : options) {
//			System.out.println(option.getAttribute("value")+","+option.getText());
//		}
		// select.selectByIndex(index);根据索引选中对应的元素
		Thread.sleep(2000);
		select.selectByIndex(2);
		Thread.sleep(2000);
		// select.selectByValue(value);选择指定value值对应的选项
		select.selectByValue("1273");
		Thread.sleep(2000);
		// select.selectByVisibleText(text);选中文本值对应的选项
		select.selectByVisibleText("mypetter");
		// select.isMultiple();判断是不是多选的选择框
		System.out.println(select.isMultiple());
		// select.deselectAll();取消所有选中的选项(只能用在multi-select中，否则报错)
		// 案例：登录app后台->习题管理->习题管理->操作领域下拉框
		
		
		Thread.sleep(5000);
		driver.quit();
	}
}
