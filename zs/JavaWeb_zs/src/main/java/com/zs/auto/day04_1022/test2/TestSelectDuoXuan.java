package com.zs.auto.day04_1022.test2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestSelectDuoXuan {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        // WebDriverWait wait = new WebDriverWait(driver, 10)
        driver.manage().window().maximize();
        driver.get(
                "file:///E:/ningmengban/Web%E8%87%AA%E5%8A%A8%E5%8C%96/%E7%89%B9%E6%AE%8A%E5%85%83%E7%B4%A0%E5%AE%9A%E4%BD%8D%E5%92%8C%E6%93%8D%E4%BD%9C%E9%9D%99%E6%80%81%E9%A1%B5%E9%9D%A2/select/mult-select.html");

        WebElement sWebElement = driver.findElement(By.id("m-select"));
        // 多选下拉框
        Select select = new Select(sWebElement);// 获取一个select对象
        System.out.println(select.isMultiple());// 是否为多选
        Thread.sleep(3000);
        select.selectByIndex(2);// 根据索引选中
        select.selectByValue("6");// 根据value值选中
        select.selectByVisibleText("mysql"); // 根据外边显示的文本值选中
        List<WebElement> options = select.getAllSelectedOptions();// 获取所有已经选择的选项
        for (WebElement option : options) {
            System.out.println(option.getAttribute("value") + "," + option.getText());
        }
        Thread.sleep(3000);
        select.deselectAll();// 删除所有选择

        Thread.sleep(3000);
        driver.quit();
    }

}
