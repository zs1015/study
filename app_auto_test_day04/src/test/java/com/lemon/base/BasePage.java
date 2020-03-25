package com.lemon.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.lemon.pojo.Locator;
import com.lemon.pojo.Page;
import com.lemon.util.XmlUtil;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.bytebuddy.jar.asm.tree.analysis.Value;

/**
 * @Title: BasePage.java
 * @Description: TODO(描述)
 * @author 歪歪欧巴
 * @date 2019年11月21日
 * @Copyright:湖南省零檬信息技术有限公司. All rights reserved.
 */
public class BasePage {

	public AndroidDriver driver;
	//日志对象
	private Logger logger = Logger.getLogger(BasePage.class);

	@BeforeSuite
	@Parameters({ "deviceName", "platformName", "appPackage", "appActivity", "automationName", "appiumIP",
			"appiumPort" })
	public void setUp(String deviceName, String platformName, String appPackage, String appActivity,
			String automationName, String appiumIP, String appiumPort) throws MalformedURLException {
		logger.info("==================测试套件开始执行===================");
		// 打开测试App
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		// 这四个配置必不可少
		// 1、deviceName：选择哪一台设备进行测试
		desiredCapabilities.setCapability("deviceName", deviceName);
		// 2、因为Appium同时支持android&ios，需要指明测试哪一个
		desiredCapabilities.setCapability("platformName", platformName);
		// 3、测试App包名，选择哪一个APP进行测试
		desiredCapabilities.setCapability("appPackage", appPackage);
		// 4、App启动，相当于式大门，启动App
		desiredCapabilities.setCapability("appActivity", appActivity);
		// 5、设置自动化测试引擎位uiautomator2
		desiredCapabilities.setCapability("automationName", automationName);
		//Appium通讯节点
		URL remoteUrl = new URL("http://"+appiumIP+":"+appiumPort+"/wd/hub");
		driver = new AndroidDriver(remoteUrl, desiredCapabilities);
		logger.info("==================打开测试App===================");
		logger.info("当前项目的配置:"+driver.getCapabilities());
	}


	/**
	 * 对sendKey方法二次封装
	 * @param pageDesc
	 * @param locatorDesc
	 * @param data
	 */
	public void type(String pageDesc, String locatorDesc, String data){
		//做日志
		logger.info("在页面【"+pageDesc+"】找到元素【"+locatorDesc+"】输入数据【"+data+"】");
		getElement(pageDesc, locatorDesc).sendKeys(data);
	}
	
	/**
	 * 对click方法做的二次封装
	 * @param pageDesc
	 * @param locatorDesc
	 */
	public void tap(String pageDesc, String locatorDesc){
		//做日志
		logger.info("在页面【"+pageDesc+"】找到元素【"+locatorDesc+"】点击");
		getElement(pageDesc, locatorDesc).click();
	}
	
	/**
	 * 封装的智能等待，在UI库里面找到对应的元素
	 * @param pageDesc
	 * @param locatorDesc
	 * @return
	 */
	public WebElement getElement(String pageDesc, String locatorDesc){
		for (Page page : XmlUtil.listPage) {
			//1、通过页面的关键字找到page标签
			if(page.getPageDesc().equals(pageDesc)){
				List<Locator> listLocator = page.getListLocator();
				for (Locator locator : listLocator) {
					if(locator.getLocatorDesc().equals(locatorDesc)){
						//得到元素的定位方式、定位值
						String locatorBy = locator.getLocatorBy();
						String locatorValue = locator.getLocatorValue();
						//1、实例化WebDriverWait对象
						WebDriverWait wait = new WebDriverWait(driver, 5);
						//2、until--直到满足。。。条件为止
						WebElement webElement = wait.until(new ExpectedCondition<WebElement>() {

							@Override
							public WebElement apply(WebDriver arg0) {
								// TODO Auto-generated method stub
								//根据UI库元素的定位方式方式去用对应的定位API
								return getElementBy(locatorBy,locatorValue);
							}
						});
						return webElement;
					}
				}
			}
		}
		return null;
	}
	
	public WebElement getElementBy(String locatorBy, String locatorValue){
		if(locatorBy.equals("ID")){
			return driver.findElement(By.id(locatorValue));
		}else if(locatorBy.equals("AccessibilityId")){
			return driver.findElementByAccessibilityId(locatorValue);
		}else if(locatorBy.equals("TEXT")){
			return driver.findElementByAndroidUIAutomator("new UiSelector().text("+locatorValue+")");
		}else if(locatorBy.equals("XPATH")){
			return driver.findElement(By.xpath(locatorValue));
		}
		return null;
	}
	
	/**
	 * 通用的向上滑动方法
	 */
	public void swipeUp() {
		// 怎么获取滑动的起始点、终止点、滑动时间
		// 起始点--》屏幕宽度的1/2位置 高度 1/4位置
		int screenX = driver.manage().window().getSize().getWidth();
		int screenY = driver.manage().window().getSize().getHeight();
		int startx = screenX / 2;
		int starty = screenY * 3 / 4;
		int endx = screenX / 2;
		int endy = screenY / 4;
		int duration = 500;

		// 把原始的坐标转换成PointOption类型
		PointOption startPoint = PointOption.point(startx, starty);
		PointOption endPoint = PointOption.point(endx, endy);

		// 把时间转换成WaitOptions类型(二次转换)
		WaitOptions waitOptions = WaitOptions.waitOptions(Duration.ofMillis(500));
		// 1、初始化触摸动作对象
		TouchAction touchAction = new TouchAction(driver);
		// appium converts press-wait-moveto-release to a swipe action
		touchAction.press(startPoint).waitAction(waitOptions).moveTo(endPoint).release();
		touchAction.perform();
	}

	/**
	 * 通用的向下滑动方法
	 */
	public void swipeDown() {
		// 怎么获取滑动的起始点、终止点、滑动时间
		// 起始点--》屏幕宽度的1/2位置 高度 1/4位置
		int screenX = driver.manage().window().getSize().getWidth();
		int screenY = driver.manage().window().getSize().getHeight();
		int startx = screenX / 2;
		int starty = screenY / 4;
		int endx = screenX / 2;
		int endy = screenY * 3 / 4;
		int duration = 500;

		// 把原始的坐标转换成PointOption类型
		PointOption startPoint = PointOption.point(startx, starty);
		PointOption endPoint = PointOption.point(endx, endy);

		// 把时间转换成WaitOptions类型(二次转换)
		WaitOptions waitOptions = WaitOptions.waitOptions(Duration.ofMillis(500));
		// 1、初始化触摸动作对象
		TouchAction touchAction = new TouchAction(driver);
		// appium converts press-wait-moveto-release to a swipe action
		touchAction.press(startPoint).waitAction(waitOptions).moveTo(endPoint).release();
		touchAction.perform();
	}
	
	/**
	 * 在滑动列表当去找元素
	 */
	public void findElementInList(String text){
		logger.info("在滑动列表中去找到元素【"+text+"】");
		String pageSource = "";
		// 2、滑动找元素
		// 当滑动到底部的时候也找不到元素，终止循环
		while (true) {
			// 每间隔滑动一次
			pageSource = driver.getPageSource();
			if (pageSource.contains(text)) {
				driver.findElementByAndroidUIAutomator("new UiSelector().text(\""+text+"\")").click();
				break;
			}
			swipeUp();
			String newPageSource = driver.getPageSource();
			// 页面滑动之后没有任何变化--滑动到了底部
			if (newPageSource.equals(pageSource)) {
				break;
			}
		}
	}

	@AfterSuite
	public void tearDown() {
		// 关闭测试App并且关闭驱动
		logger.info("===================测试套件结束=====================");
		driver.quit();
	}

}
