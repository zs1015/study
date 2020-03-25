package com.zs.auto.day03_1015.test1;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DriverCommand;

public class WebDriverTest1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        
        // manage()获取Options--浏览器菜单操作对象：：比如开业完成cookie的设置
        /*driver.get("http://120.78.128.25:8765");
        Options options = driver.manage();//  
        options.addCookie(new Cookie("fengwoo","qu6fv29hc6fe032o0vraahkm07"));
        options.addCookie(new Cookie("remember_me","13825161923"));
        driver.get("http://120.78.128.25:8765/Member/index.html");*/
        
        // timeouts():超时驱动对象
        //driver.manage().timeouts().implicitlyWait(time, unit)//隐式等待（元素没加载出来）
        
        // 窗口最大化
        driver.manage().window().maximize();
        
        
        
        // 切换窗口:driver.switchTo()
        // driver.switchTo().frame(index)
        // driver.switchTo().window(nameOrHandle);
        // driver.switchTo().alert();
        
        Thread.sleep(3000);
        driver.quit();
    }

}
