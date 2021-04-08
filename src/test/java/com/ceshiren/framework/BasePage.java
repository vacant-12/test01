package com.ceshiren.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;

public class BasePage {
    static BasePage instance=null;
    HashMap<String,BasePage> pages = new HashMap<>();
    WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public BasePage() {
    }

    public static BasePage getInstance() {
        if(instance==null){
            instance=new BasePage();
        }
        return instance;
    }

    void click(By by){
        driver.findElement(by).click();
    }
    void sendKeys(By by,String content){
        driver.findElement(by).sendKeys(content);
    }

    void poInit(String name,String className){
        try {
            BasePage pageClass = (BasePage)Class.forName(className).getDeclaredConstructor().newInstance();
            pages.put(name,pageClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    BasePage getPO(String name ){
        return pages.get(name);
    }

    void stepRun(String method){
        Method methodJava = Arrays.stream(this.getClass().getMethods())
                .filter(m->m.getName().equals(method))
                .findFirst().get();
        try {
            methodJava.invoke(this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
