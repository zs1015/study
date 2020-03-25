package com.zs.auto.day03_1015.test1;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DriverCommand;

public class WebDriverTest {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("disable-infobars");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.get("http://www.baidu.com");// 阻塞的，没加载完不会进行下一步
        // Navigation.to(String)
        System.out.println(driver.getCurrentUrl());// 当前网址URL
        System.out.println(driver.getTitle());// 标题
        // System.out.println(driver.getPageSource());//源代码
        // Thread.sleep(2000);
        // driver.findElement(By.partialLinkText("把百度设为")).click();
        // driver.close();// 关闭当前窗口
        //
        // driver.get("http://120.78.128.25:8765/loan/finance.html");
        // System.out.println(driver.findElements(By.className("invest-unit")).size());

        System.out.println(driver.getWindowHandle());// 获取当前窗口句柄（窗口的ID，唯一标识符）
        driver.findElement(By.partialLinkText("把百度设为")).click();
        System.out.println(driver.getWindowHandle());// 获取当前窗口句柄（窗口的ID，唯一标识符）

        // 返回所有驱动对象打开页面的句柄
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {

            System.out.println(windowHandle);
        }
        Thread.sleep(3000);
        driver.quit();
    }

}
