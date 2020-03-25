package com.lemon.web.auto.day06.section01.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.lemon.web.auto.day06.section01.util.WebAutoUtils;

/**
 * 基础测试类
 * 
 * @author happy
 *
 */
public class BaseTester {
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

	/**
	 * 点击元素
	 * 
	 * @param by
	 *            元素定位器（Locator）
	 */
	protected void click(By by) {
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
		driver.findElement(by).sendKeys(content);
	}
	
	/**
	 * 获取元素的文本
	 * @param by 元素的定位器
	 * @return
	 */
	protected String getText(By by) {
		return driver.findElement(by).getText();
	}

}
