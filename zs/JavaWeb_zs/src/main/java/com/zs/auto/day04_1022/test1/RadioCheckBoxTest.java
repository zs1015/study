package com.zs.auto.day04_1022.test1;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioCheckBoxTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // driver.get("file:///E:/ningmengban/Web%E8%87%AA%E5%8A%A8%E5%8C%96/%E7%89%B9%E6%AE%8A%E5%85%83%E7%B4%A0%E5%AE%9A%E4%BD%8D%E5%92%8C%E6%93%8D%E4%BD%9C%E9%9D%99%E6%80%81%E9%A1%B5%E9%9D%A2/%E5%8D%95%E9%80%89%E5%A4%9A%E9%80%89%E6%A1%86/radio.html");
        driver.get(
                "file:///E:/ningmengban/Web%E8%87%AA%E5%8A%A8%E5%8C%96/%E7%89%B9%E6%AE%8A%E5%85%83%E7%B4%A0%E5%AE%9A%E4%BD%8D%E5%92%8C%E6%93%8D%E4%BD%9C%E9%9D%99%E6%80%81%E9%A1%B5%E9%9D%A2/%E5%8D%95%E9%80%89%E5%A4%9A%E9%80%89%E6%A1%86/checkbox.html");
        Thread.sleep(3000);

        // radio单选框
        // List<WebElement> elements = driver.findElements(By.name("sex"));
        // elements.get(1).click();
        // for (WebElement webElement : elements) {
        // System.out.println(webElement.isSelected());
        // }

        // checkbox多选框
        List<WebElement> elements = driver.findElements(By.name("subject"));
        // 点击第二个和第四个
        elements.get(1).click();
        Thread.sleep(3000);
//        elements.get(3).click();
        
        driver.findElement(By.cssSelector("input[value='Sport']")).click();;
        for (WebElement webElement : elements) {
            //元素是的被选中
            System.out.println(webElement.isSelected());
        }
        Thread.sleep(3000);
        driver.quit();
    }

}
