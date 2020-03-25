package com.lemon.web.auto.day03.section01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementOptTester2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.baidu.com");
/*		WebElement input = driver.findElement(By.id("kw"));
		// getTagName()
		// 获取元素的的标签名
		String tagName = input.getTagName();
		System.out.println(tagName);
		// getAttribute(属性名)
		// 根据属性名获取元素属性值
		System.out.println(input.getAttribute("autocomplete"));
		// getText()
		// 获取当前元素的文本值
		System.out.println(driver.findElement(By.id("cp")).getText());
		*/
		WebElement input = driver.findElement(By.id("kw"));
		// isDisplayed()
		// 查看元素是否显示
		System.out.println(input.isDisplayed());
		// isEnabled()：登录面板的需求：如果用户名和密码输入不完整，或者格式不符合，那么登录按钮不能被点击
		// 查看元素是否启用(可编辑)
		System.out.println(input.isEnabled());
		// isSelected()
		// 查看元素是否被选中
		System.out.println(input.isSelected());//radio、checkbox
		Thread.sleep(5000);
		driver.quit();
	}
}
