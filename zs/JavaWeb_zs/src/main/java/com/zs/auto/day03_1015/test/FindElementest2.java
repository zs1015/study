package com.zs.auto.day03_1015.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FindElementest2 {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("disable-infobars");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.get("https://www.baidu.com");
       WebElement input = driver.findElement(By.id("kw"));
       System.out.println(input.getTagName());
       System.out.println(input.getAttribute("class"));
       String text = driver.findElement(By.id("cp")).getText();
       System.out.println(text);
       
//       isDisplayed（）：元素是否显示
//       8.isEnabled（）：元素是否生效
//       9.isSelected（）元素是否被选择（选中）   radio、checkbox
       System.out.println(input.isDisplayed());
       System.out.println(input.isEnabled());
       System.out.println(input.isSelected());
       
        Thread.sleep(3000);
        driver.quit();
    }

}
