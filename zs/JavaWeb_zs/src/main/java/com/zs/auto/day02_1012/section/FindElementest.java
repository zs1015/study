package com.zs.auto.day02_1012.section;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FindElementest {
    // 1.单个：findElement()
    // 2. 多个：findElements()
    // 复合样式不允许；如： （bg s_btn） 中间有空格
    /**
     * linkText 完整超链接文本要注意前后的空格 可以改成使用部分匹配partialLinkText()
     */
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("disable-infobars");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.get("https://www.baidu.com");
        // 1.id
        // WebElement element = driver.findElement(By.id("kw"));
        // System.out.println(element.getAttribute("maxlength"));
        // 2.name // 如果要找的元素大于1，则可以用findElements()找
        // List<WebElement> elements = driver.findElements(By.name("wd"));
        // System.out.println(elements.size());
        // 3.tagName： 找a标签
        // List<WebElement> tagNames = driver.findElements(By.tagName("a"));
        // for (WebElement tagName : tagNames) {
        // System.out.println(tagName.getAttribute("href"));
        // }
        // 4.className
        // WebElement element = driver.findElement(By.className("s_ipt"));
        // element.sendKeys("你好");
        // WebElement element1 = driver.findElement(By.className("bg s_btn"));//
        // 会报错
        // WebElement element1 = driver.findElement(By.className("s_btn"));
        // System.out.println(element1.getAttribute("value"));
        // 5.linkText 完整超链接文本
        // driver.findElement(By.linkText("hao123")).click();
        // 6.partialLinkText 部分超链接文本（模糊查找）
        driver.findElement(By.partialLinkText("o12")).click();
        // driver.findElement(By.id("su")).click();
        Thread.sleep(7000);
        driver.quit();
    }

}
