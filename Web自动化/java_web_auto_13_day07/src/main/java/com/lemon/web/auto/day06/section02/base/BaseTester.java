package com.lemon.web.auto.day06.section02.base;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	 * 默认智能等待5s的找元素的方法
	 * @param by
	 * @return
	 */
	protected WebElement getElement(By by){
		return getElement(by, 5L);
	}
	
	/**
	 * 
	 * @param by
	 * @param timeOutInSeconds
	 * @return
	 */
	protected WebElement getElement(By by,Long timeOutInSeconds){
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		//匿名内部类型
		WebElement element = wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver input) {
				return driver.findElement(by);//dom结构中存在
			}
		});
		return element;
	}
	
	protected WebElement getElementToBeClickable(By by){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.elementToBeClickable(by));
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
		getElement(by).click();
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
		getElement(by).sendKeys(content);
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
		return getElement(by).getText();
	}

}
