package com.ceshiren.app;

import com.ceshiren.web.ContactPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class NewMainPage extends AppBasePage{


    void login() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("deviceName", "ceshiren.com");
        capabilities.setCapability("appPackage", "com.tencent.wework");
        capabilities.setCapability("appActivity", ".launch.LaunchSplashActivity");
        capabilities.setCapability("noReset", "true");
        driver = new AppiumDriver<>(
                new URL("http://0.0.0.0:4723/wd/hub"),
                capabilities);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        new WebDriverWait(driver, 60,1)
                .until(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='通讯录']")));

    }



    public NewMainPage() throws MalformedURLException {
        this.login();
    }

    public NextPage nextPage(){

        click(By.xpath("//*[@text='通讯录']"));
        return new NextPage(driver);
    }

}
