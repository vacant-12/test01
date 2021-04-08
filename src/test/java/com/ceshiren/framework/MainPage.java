package com.ceshiren.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainPage extends BasePage{
    public MainPage(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://ceshiren.com/");
    }
    public SearchPage search(){
        return new SearchPage(driver);
    }
}