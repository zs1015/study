package com.lemon.web.auto.day08.section01.testcase.login;

import java.util.Map;

import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.lemon.web.auto.day08.section01.base.BaseTester;
import com.lemon.web.auto.day08.section01.pojo.Locator;
import com.lemon.web.auto.day08.section01.util.LocatorUtils;

/**
 * 1:硬编码：我们的元素定位方式和值的维护比较麻烦 --》分离--》系统性的管理起来！！
 * 		1）把这元素用一个单独类管理起来：http://www.lemfix.com/topics/1   一定要去看，这是selenium提出来的po的思想
 * 		2）彻底分离：保存到容易编辑的文件中：xml--》通过xml来描述页面的元素：元素的描述、定位的方式、定位的值、是否要等待可点击、等待时间
 * 2：api侵入 ：by
 * @author happy
 *
 */
public class LoginTester_01 extends BaseTester {
	// 反向测试用例
	@Test(dataProvider = "dp1", dataProviderClass = LoginDataProvider.class)
	public void login_failure_test_case(LoginFailData failData) throws DocumentException {
		
		to("login_url");
//		type(By.id("mobilephone"), failData.getPhone());
//		type(By.id("password"), failData.getPassword());
//		click(By.id("login"));
//		String actual = getElementTextNotNull(By.className("tips"));

		//读取所有页面的元素定位信息
//		Map<String, Map<String, Locator>> allPagesMap = LocatorUtils.readXml();
//		Locator phoneLocator= allPagesMap.get("登录页面").get("手机号码输入框");
//		Locator pwdLocator= allPagesMap.get("登录页面").get("密码输入框");
//		Locator loginLocator= allPagesMap.get("登录页面").get("登录按钮");
//		Locator tipsLocator= allPagesMap.get("登录页面").get("提示信息元素");
		
		Locator phoneLocator= LocatorUtils.getLocatorByPageNameAndLocatorName("登录页面", "手机号码输入框");
		Locator pwdLocator= LocatorUtils.getLocatorByPageNameAndLocatorName("登录页面", "密码输入框");
		Locator loginLocator= LocatorUtils.getLocatorByPageNameAndLocatorName("登录页面", "登录按钮");
		Locator tipsLocator= LocatorUtils.getLocatorByPageNameAndLocatorName("登录页面", "提示信息元素");

		type(phoneLocator, failData.getPhone());		
		type(pwdLocator, failData.getPassword());
		click(loginLocator);
//		String actual = getElementTextNotNull(tipsLocator);
//		Assert.assertEquals(actual, failData.getExpectedTips());
	}

	// 正向测试用例
	@Test(enabled=false,dataProvider = "dp2", dataProviderClass = LoginDataProvider.class)
	public void login_success_test_case(LoginSuccessData successData) {
		to("login_url");
		type(By.id("mobilephone"), successData.getPhone());
		type(By.id("password"), successData.getPassword());
		click(By.id("login"));
		Assert.assertTrue(currentPageUrlContains(successData.getPartialUrl()));
	}

}
