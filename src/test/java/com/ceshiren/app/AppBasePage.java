package com.ceshiren.app;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;


public class AppBasePage {

    public AppiumDriver driver;

    public AppBasePage(AppiumDriver driver) {
        this.driver = driver;
    }

    public AppBasePage() {
    }

    void click(By by){
        driver.findElement(by).click();
    }
    void sendKeys(By by,String content){
        driver.findElement(by).sendKeys(content);
    }
}
