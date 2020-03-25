package com.zs.auto.day05_1024.test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestAction {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        Actions action = new Actions(driver);
        // driver.manage().window().maximize();
        // driver.get("https://www.baidu.com");
        // WebElement input = driver.findElement(By.id("kw"));
        // WebElement su = driver.findElement(By.id("su"));
        // // action.sendKeys(input, "你好").perform();
        // // action.click(su).perform();
        // // 链式调用
        // action.sendKeys(input, "你好").moveToElement(su).click().perform();

        // 拖拽节点鼠标事件----http://www.treejs.cn/v3/demo/cn/exedit/drag.html
        driver.get("http://www.treejs.cn/v3/demo/cn/exedit/drag.html");
        WebElement element1 = driver.findElement(By.id("treeDemo_4_a"));
        WebElement element2 = driver.findElement(By.id("treeDemo_8_span"));
        // 链式调用：：：移到元素1上，点击，按住不放，移到到2，松开
        action.moveToElement(element1).clickAndHold().moveToElement(element2).release().perform();

        Thread.sleep(2000);
        driver.quit();
    }

}
