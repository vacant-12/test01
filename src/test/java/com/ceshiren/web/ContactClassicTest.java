package com.ceshiren.web;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class ContactClassicTest {

    public static WebDriver driver;

/*    @Test
    public void seleniumTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://ceshiren.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#search-button")).click();
        driver.findElement(By.cssSelector("#search-term")).sendKeys("selenium");
    }*/

    public static void needLoginIn() throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        Thread.sleep(15000);
        Set<Cookie> cookies = driver.manage().getCookies();
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.writeValue(new File("cookies.yaml"),cookies);
    }

    @BeforeAll
    public static void beforeAll() throws IOException, InterruptedException {
        File file = new File("cookies.yaml");
        if(file.exists()){

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        driver.manage().window().maximize();

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        TypeReference typeReference = new TypeReference<List<HashMap<String, Object>>>() {
        };
        List<HashMap<String, Object>> cookies = (List<HashMap<String, Object>>) mapper.readValue(file, typeReference);
        System.out.println(cookies);

        cookies.forEach(cookieMap->{
            driver.manage().addCookie(new Cookie(cookieMap.get("name").toString(),cookieMap.get("value").toString()));
        });
        driver.navigate().refresh();

        }else{
            needLoginIn();
        }
    }

    @Test
    void contackAdd(){
        //driver.findElement(By.cssSelector("[node-type=addmember]")).click();
        driver.findElement(By.linkText("添加成员")).click();
        driver.findElement(By.name("username")).sendKeys("test003");
        driver.findElement(By.name("acctid")).sendKeys("test003");
        driver.findElement(By.name("mobile")).sendKeys("15012340002");
        driver.findElement(By.linkText("保存")).click();
    }

    //封装操作
    void contackAdd2(){
        //driver.findElement(By.cssSelector("[node-type=addmember]")).click();
        click(By.linkText("添加成员"));
        sendKeys(By.name("username"),"test003");
        sendKeys(By.name("acctid"),"test003");
        sendKeys(By.name("mobile"),"15012340002");
        click(By.linkText("保存"));
    }


    @Test
    void search(){

    }
    @Test
    void departmentSearch(){
        click(By.id("menu_contacts"));
        sendKeys(By.id("memberSearchInput"),"测试开发部");
        //搜索太快，这里的点击借住隐式等待元素出现
        click(By.cssSelector(".ww_icon_AddMember"));
        String content = driver.findElement(By.cssSelector(".js_party_info")).getText();
        System.out.println(content);
        assertTrue(content.contains("无任何成员"));

    }

    void click(By by){
        driver.findElement(by).click();
    }
    void sendKeys(By by,String content){
        driver.findElement(by).sendKeys(content);
    }

}
