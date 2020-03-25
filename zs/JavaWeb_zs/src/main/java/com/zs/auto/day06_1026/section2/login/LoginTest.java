package com.zs.auto.day06_1026.section2.login;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.zs.auto.day06_1026.section2.base.Base;

public class LoginTest extends Base {

    @Test(dataProvider = "dataF", dataProviderClass = LoginDataProvider.class)
    public void case_test(String mobilephone, String password, String expectedTips) throws IOException {
        // to("http://test.lemonban.com/lmcanon_web_auto/mng/login.html");
        // driver.findElement(By.id("mobilephone")).sendKeys(mobilephone);
        // driver.findElement(By.id("password")).sendKeys(password);
        // driver.findElement(By.id("login")).click();
        // String actual = driver.findElement(By.className("tips")).getText();

        to("login_url");
        sendKeys(By.id("mobilephone"), mobilephone);
        sendKeys(By.id("password"), password);
        click(By.id("login"));
        String actual = getText(By.className("tips"));
        Assert.assertEquals(actual, expectedTips);
    }

    // @Test
     public void case_test1() {
     driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/login.html");
     driver.findElement(By.id("mobilephone")).sendKeys("13566667777");
     driver.findElement(By.id("password")).sendKeys("12345");
     driver.findElement(By.id("login")).click();
     String actual = driver.findElement(By.className("tips")).getText();
     String exString = "账号信息错误";
     Assert.assertEquals(actual, exString);
     }
//    public static void main(String[] args) throws IOException {
//        Properties properties = new Properties();
//        properties.load(LoginTest.class.getResourceAsStream("/properties/test.properties"));
//        System.out.println(properties.getProperty("login_url"));
//    }
}
