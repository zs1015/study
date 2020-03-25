package com.zs.auto.day04_1022.test1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///E:/ningmengban/Web%E8%87%AA%E5%8A%A8%E5%8C%96/%E7%89%B9%E6%AE%8A%E5%85%83%E7%B4%A0%E5%AE%9A%E4%BD%8D%E5%92%8C%E6%93%8D%E4%BD%9C%E9%9D%99%E6%80%81%E9%A1%B5%E9%9D%A2/%E6%A8%A1%E6%80%81%E6%A1%86/alert.html");
        driver.findElement(By.id("abtn")).click();
        //driver.switchTo() 切换到一个目标定位器，再切换至alert框
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();// 获取警告框的文本
        System.out.println(text);
        Thread.sleep(3000);
        alert.accept();//点击确认按钮
//        alert.dismiss();// dianji 取消
        Thread.sleep(3000);
        driver.quit();
    }

}
