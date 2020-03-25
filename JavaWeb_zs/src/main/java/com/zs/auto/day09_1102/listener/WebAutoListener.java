package com.zs.auto.day09_1102.listener;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.zs.auto.day09_1102.base.Base;

/**
 * 监听器,当执行失败用例的时候,触发
 * 1.需要继承TestListenerAdapter,
 * 2.重写其onTestFailure方法
 *  其中还有很多监听方法重写
 * @author Administrator
 *
 */
public class WebAutoListener extends TestListenerAdapter {

    // 当执行测试用例失败的时候
    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
        System.out.println("#######################");
        // 截图
        /*TakesScreenshot takesScreenshot = (TakesScreenshot) Base.getDriver();
        // FILE:文件截屏;;BASE64:可以保存到数据库;;BYTES:二进制字节码文件
        // 截屏为一个文件,目前在堆内存中一个对象,源文件
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        // 目标文件
        File destFile = new File("D:\\"+System.currentTimeMillis()+".jpg");
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
