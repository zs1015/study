package com.lemon.web.auto.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.lemon.web.auto.pojo.Locator;
import com.lemon.web.auto.util.LocatorUtils;
import com.lemon.web.auto.util.PropertiesFileUtils;
import com.lemon.web.auto.util.WebAutoUtils;

/**
 * 基础测试类 测试数据决定了测试结果
 * 在自动化测试领域，提倡测试数据分离，即测试用例和测试数据是分开的，通过在一套测试用例上执行多套测试数据，从而提高测试效率
 * 通过将测试数据存储到excel、csv、xml、甚至数据库，利用TestNG的数据提供者特性，完成数据驱动
 * 
 * 
 * @author happy
 *
 */
public abstract class BaseTester {

	// 子类对应页面的名称
	// private String pageName;

	// 提供一个模板方法交给子类去实现，指定页面名称
	protected abstract String getCurrentPageName();

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

	public String getCurrentPageUrl() {
		return driver.getCurrentUrl();
	}

	/**
	 * 通过locator对象组装一个by对象
	 * 
	 * @param locator
	 * @return
	 */
	public By getByWithLocator(Locator locator) {
		String type = locator.getType();// 定位的方式：id,name,cssSelector，xpath...
		String value = locator.getValue();// 定位的值:phone password
		// 通过type和value得到一个by对象
		By by = null;
		if ("id".equalsIgnoreCase(type)) {
			by = By.id(value);
		} else if ("name".equalsIgnoreCase(type)) {
			by = By.name(value);
		} else if ("tagName".equalsIgnoreCase(type)) {
			by = By.tagName(value);
		} else if ("linkText".equalsIgnoreCase(type)) {
			by = By.linkText(value);
		} else if ("partialLinkText".equalsIgnoreCase(type)) {
			by = By.partialLinkText(value);
		} else if ("cssSelector".equalsIgnoreCase(type)) {
			by = By.cssSelector(value);
		} else if ("className".equalsIgnoreCase(type)) {
			by = By.className(value);
		} else if ("xpath".equalsIgnoreCase(type)) {
			by = By.xpath(value);
		} else {
			throw new RuntimeException("没有这种定位方式！！！");
		}
		return by;
	}

	/**
	 * 直到当前页面url包含了partailUrl才返回true
	 * 
	 * @param partailUrl
	 * @return
	 */
	public Boolean currentPageUrlContains(String partailUrl) {
		// 智能等待
		WebDriverWait wait = new WebDriverWait(driver, 5);
		return wait.until(ExpectedConditions.urlContains(partailUrl));
	}

	/**
	 * 默认智能等待5s的找元素的方法
	 * 
	 * @param by
	 * @return
	 */
	protected WebElement getElement(By by) {
		return getElement(by, 5L);
	}

	/**
	 * 默认智能等待5s的找元素的方法
	 * 
	 * @param by
	 * @return
	 */
	protected WebElement getElement(Locator locator) {
		return getElement(locator, 5L);
	}

	protected WebElement getElement(String pageName, String locatorName) {
		
		Locator locator = LocatorUtils.getLocatorByPageNameAndLocatorName(pageName, locatorName);
		return getElement(locator, 5L);
	}

	/**
	 * 
	 * @param by
	 * @param timeOutInSeconds
	 * @return
	 */
	protected WebElement getElement(By by, Long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		// 匿名内部类型
		WebElement element = wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver input) {
				return driver.findElement(by);// dom结构中存在
			}
		});
		return element;
	}

	/**
	 * 
	 * @param by
	 * @param timeOutInSeconds
	 * @return
	 */
	protected WebElement getElement(Locator locator, Long timeOutInSeconds) {
		
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		// 通过locator得到by对象
		By by = this.getByWithLocator(locator);
		// 匿名内部类型
		WebElement element = wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver input) {
				return driver.findElement(by);// dom结构中存在
			}
		});
		return element;
	}

	/**
	 * 智能等待去获取元素的文本：只有当元素文本长度大于0时才返回
	 * 
	 * toast：当toast：当页面某个元素的文本出现：登录失败！！
	 * 
	 * @param by
	 * @return
	 */
	// 期望条件是，等待的元素的文本不为空（元素的文本的长度大于0）
	public String getElementTextNotNull(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 5L);
		String elementText = wait.until(new ExpectedCondition<String>() {
			@Override
			public String apply(WebDriver input) {
				System.out.println("------------------------");
				// 先获取这个元素
				WebElement element = driver.findElement(by);
				// 如果元素不为空，并且元素的文本不为空，然后元素文本长度大于0
				// 真正能返回非空是当下面的条件满足的时候
				if (element != null && element.getText() != null && element.getText().length() > 0) {
					return element.getText();
				}
				return null;
			}
		});

		return elementText;
	}

	public String getElementTextNotNull(String pageName, String locatorName) {
		Locator locator = LocatorUtils.getLocatorByPageNameAndLocatorName(pageName, locatorName);
		By by = this.getByWithLocator(locator);
		return getElementTextNotNull(by);
	}

	public String getElementTextNotNull(String locatorName) {
		return getElementTextNotNull(this.getCurrentPageName(), locatorName);
	}

	// FIXME
	private String getElementTextNotNull(Locator locator) {
		// TODO Auto-generated method stub
		return null;
	}

	protected WebElement getElementToBeClickable(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	/**
	 * 打开某个页面
	 * 
	 * @param urlKey
	 *            url对应的属性名称
	 */
	protected void to(String urlKey) {
//		logger
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
		// 显示等待
		getElement(by).click();
	}

	protected void click(Locator locator) {
		// 显示等待
		getElement(locator).click();
	}

	/**
	 * 点击指定页面的对应元素
	 * 
	 * @param pageName
	 *            页面的名称
	 * @param locatorName
	 *            元素的名称
	 */
	protected void click(String pageName, String locatorName) {
		// 显示等待
		getElement(pageName, locatorName).click();
	}

	/**
	 * 点击当前页面的指定元素
	 * 
	 * @param locatorName
	 *            元素的名称
	 */
	public void click(String locatorName) {
		click(this.getCurrentPageName(), locatorName);
	}

	/**
	 * 输入内容
	 * 
	 * @param by
	 *            元素定位器
	 * @param content
	 *            要输入的内容
	 */
	@Deprecated
	protected void type(By by, String content) {
		// 显示等待
		getElement(by).sendKeys(content);
	}

	/**
	 * 输入内容
	 * 
	 * @param locator
	 *            元素定位器
	 * @param content
	 *            内如
	 */
	protected void type(Locator locator, String content) {
		getElement(locator).sendKeys(content);
	}

	protected void type(String pageName, String locatorName, String content) {
		//
		getElement(pageName, locatorName).sendKeys(content);
	}

	//元素的名称--》关键字
	public void type(String keyword, String content) {
		//
		type(this.getCurrentPageName(), keyword, content);
	}

	/**
	 * 获取元素的文本
	 * 
	 * @param by
	 *            元素的定位器
	 * @return
	 */
	protected String getText(By by) {
		// 显示等待
		return getElement(by).getText();
	}

	/**
	 * 获取元素的文本
	 * 
	 * @param by
	 *            元素的定位器
	 * @return
	 */
	protected String getText(Locator locator) {
		// 显示等待
		return getElement(locator).getText();
	}

	/**
	 * 获取指定页面的指定元素的文本
	 * @param pageName
	 * @param locatorName
	 * @return
	 */
	protected String getText(String pageName, String locatorName) {
		// 显示等待
		return getElement(pageName, locatorName).getText();
	}
	
	/**
	 * 获取当前页面某个元素的文本
	 * @param locatorName 元素文本
	 * @return
	 */
	protected String getText( String locatorName) {
		return getText(this.getCurrentPageName(), locatorName);
	}

	// 通用的断言方法-----------------------------------------------------------------------------------------
	/**
	 * 这些方法很多地方都会用！！！
	 * 断言当前页面的某个元素的文本不为空，并且和期望值相等
	 * 
	 * @param locatorName 元素名称
	 * @param expectedText 元素期望的文本
	 */
	protected void assertElementTextEquals(String locatorName, String expectedText) {
		assertElementTextEquals(this.getCurrentPageName(), locatorName, expectedText);
	}

	/**
	 * 断言指定页面的某个元素的文本不为空，并且和期望值相等
	 * 
	 * @param pageName 指定的页面的名称
	 * @param locatorName 元素的名称
	 * @param expectedText 期望的文本
	 */
	protected void assertElementTextEquals(String pageName, String locatorName, String expectedText) {
		String actual = getElementTextNotNull(pageName, locatorName);
		Assert.assertEquals(actual, expectedText);
	}
	
	/**
	 * 断言当前页面包含某部分url
	 * @param partialUrl
	 */
	protected void assertPageUrlContains(String partialUrl){
		Assert.assertTrue(currentPageUrlContains(partialUrl));
	}
	
	// assertTextPresent：断言页面元素文本值为某文本
	protected void assertTextPresent(String pageName,String locatorName,String expectedText){
		//TODO
	}
	// assertPartialTextPresent：断言指定页面元素文本值包含某文本
	protected void assertPartialTextPresent(String pageName,String locatorName,String expectedText){
		String actualText = getElement(pageName, locatorName).getText();
		Assert.assertTrue(actualText.contains(expectedText));
	}
	//断言指定页面元素文本值包含某文本
	protected void assertPartialTextPresent(String locatorName,String expectedText){
		assertPartialTextPresent(this.getCurrentPageName(), locatorName, expectedText);
	}
	
	// assertElementEditable：断言某元素可编辑
	protected void assertElementEditable(String pageName,String locatorName){
		WebElement element = getElement(pageName, locatorName);
		Assert.assertTrue(element.isEnabled());
	}
	protected void assertElementEditable(String locatorName){
		assertElementEditable(this.getCurrentPageName(), locatorName);
	}
	// assertElementNotEditable：断言某元素不可编辑
	// assertURLContains：断言当前URL包含
	// assertTextNotPresent
	// assertTextNotPresentPrecesion
	// assertElementAttributeValueEquals
	// assertElementAttributeValueNotEquals
	// assertAlertTextContains

}
