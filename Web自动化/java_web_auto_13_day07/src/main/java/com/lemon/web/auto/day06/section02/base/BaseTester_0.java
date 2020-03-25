package com.lemon.web.auto.day06.section02.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.lemon.web.auto.day06.section02.util.PropertiesFileUtils;
import com.lemon.web.auto.day06.section02.util.WebAutoUtils;

/**
 * 基础测试类
 * 
 * @author happy
 *
 */
public class BaseTester_0 {
	protected static WebDriver driver = null;

	@BeforeSuite
	public void beforeSuite() {
		driver = WebAutoUtils.getDriver("Chrome", "2.x");
	}

	@AfterSuite
	public void afterSuite() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

	protected WebElement getElement(By by){
		return driver.findElement(by);
	}
	
	/**
	 * 打开某个页面
	 * @param urlKey url对应的属性名称
	 */
	protected void to(String urlKey) {
		String url = PropertiesFileUtils.getUrl(urlKey);
		driver.get(url);
	}

	/**
	 * 点击元素
	 * 
	 * @param by
	 *            元素定位器（Locator）
	 */
	protected void click(By by) {
		//显示等待
		driver.findElement(by).click();
	}

	/**
	 * 输入内容
	 * 
	 * @param by
	 *            元素定位器
	 * @param content
	 *            要输入的内容
	 */
	protected void type(By by, String content) {
		//显示等待
		driver.findElement(by).sendKeys(content);
	}

	/**
	 * 获取元素的文本
	 * 
	 * @param by
	 *            元素的定位器
	 * @return
	 */
	protected String getText(By by) {
		//显示等待
		return driver.findElement(by).getText();
	}

}
