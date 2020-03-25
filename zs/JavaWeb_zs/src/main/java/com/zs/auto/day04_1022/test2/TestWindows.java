package com.zs.auto.day04_1022.test2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestWindows {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.baidu.com");
        driver.findElement(By.partialLinkText("京公网")).click();
        // Thread.sleep(3000);
        // 打开新的Windows窗口，需要切换窗口driver.switchTo().window()
        // driver.findElement(By.partialLinkText("公共查询")).click();// 报错
        // 已经打开了第二个窗口
        // 第一个窗口的句柄
        String firstHandle = driver.getWindowHandle();// 第一个窗口的句柄
        // 想获取第二个句柄，使用set接收所有句柄，再换为arrayList
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> handles = new ArrayList<String>(windowHandles);
        String secondHandle = handles.get(1);
        driver.switchTo().window(secondHandle);
        Thread.sleep(3000);
        driver.findElement(By.partialLinkText("公共查询")).click();

        // 切回去：：两种方式
        // driver.switchTo().window(firstHandle);
        driver.switchTo().window(handles.get(0));
        Thread.sleep(3000);
        driver.findElement(By.partialLinkText("hao123")).click();

        Thread.sleep(3000);
        driver.quit();
    }

}
