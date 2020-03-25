package com.zs.auto.day02_1012.section;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * xpath:一个描述页面元素位置信息的路径， 元素坐标 xml
 * 
 * (1)  //*[contains(@name,'wd')]
 * (2)  //*[text()='hao123'] 完整匹配：有空格会报错的  
 *      //*[contains(text(),'o12')] 两个方法一起使用
 */
public class FindElementestByXpath {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("disable-infobars");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.get("https://www.baidu.com");
        // 8.Xpath
        // （1）绝对路径（）缺点：页面会变，导致dom结构发生变化，导致写的脚本没法正常执行
        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[3]/a"));
        System.out.println(element.getAttribute("class"));
        // （2）相对路径：灵活、方便、耦合性低
        /**
         *  // 匹配指定节点，不考虑它们的位置（/绝对路径：需要从根节点开始查找）
         *  . 当前层
         *  * 通配符，匹配任意元素节点
         *  @ 选择属性
         *  [] 表达式  
         *  
         */
        // driver.findElement(By.xpath("//input[@class='s_ipt']")).sendKeys("111");
        // driver.findElement(By.xpath("//span[1]/input")).sendKeys("111");
        // driver.findElement(By.xpath("//*[contains(@name,'wd')]")).sendKeys("111");
        // driver.findElement(By.xpath("//*[text()='新闻']")).click();
        driver.findElement(By.xpath("//*[contains(text(),'o12')]")).click();
        Thread.sleep(3000);
        driver.quit();
    }

}
