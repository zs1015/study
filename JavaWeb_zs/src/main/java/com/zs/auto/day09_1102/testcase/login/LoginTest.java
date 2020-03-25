package com.zs.auto.day09_1102.testcase.login;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.dom4j.DocumentException;import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import com.zs.auto.day09_1102.base.Base;
import com.zs.auto.day09_1102.base.CaseDataProvider;
/**
 * 登录的测试类
 * @author Administrator
 */
public class LoginTest extends Base {
    
    @Override
    protected String getCurrentPageName() {
        return this.pageName ="登录页面";
        
    }
    
    @Test(dataProvider = "dp", dataProviderClass = CaseDataProvider.class)
    public void login_fail_case(LoginFailData loginFailData) throws IOException, DocumentException {
        to("login_url");
        // 完美
        /*sendKeys("登录页面", "手机号码输入框", loginFailData.getMobilephone());
        sendKeys("登录页面", "密码输入框", loginFailData.getPassword());
        click("登录页面", "登录按钮");*/
        sendKeys("手机号码输入框", loginFailData.getMobilephone());
        sendKeys( "密码输入框", loginFailData.getPassword());
        click( "登录按钮");
        /*//截图
        TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
        //FILE:文件截屏;;BASE64:可以保存到数据库;;BYTES:二进制字节码文件
        //截屏为一个文件,目前在堆内存中一个对象,源文件
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        //目标文件
        File destFile = new File("D:\\a.jpg");
        FileUtils.copyFile(srcFile, destFile);*/
        
        assertElementTextEquals("提示信息元素", loginFailData.getExpectedTips());
        // String actual = getElementNotnull("提示信息元素");
        // Assert.assertEquals(actual, loginFailData.getExpectedTips());
    }

    @Test(enabled=false,dataProvider = "dp", dataProviderClass = CaseDataProvider.class)
    public void login_success_case(LoginSuccessData loginSuccessData) throws IOException {
        to("login_url");
        sendKeys("手机号码输入框", loginSuccessData.getMobilephone());
        sendKeys("密码输入框", loginSuccessData.getPassword());
        click("登录按钮");
        asssertPageUrlContains(loginSuccessData.getPratiaUrl());

    }

    
    
}
