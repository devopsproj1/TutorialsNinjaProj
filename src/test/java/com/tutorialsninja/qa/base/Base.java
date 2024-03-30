package com.tutorialsninja.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Base {
    WebDriver driver;
    public  WebDriver  InitializeBrowserAndOpenApplication(String browserName){
        if (browserName.equals("chrome"))
        {
            driver=new ChromeDriver();
        } else if (browserName.equals("firefox"))
        {
            driver=new FirefoxDriver();
        } else if (browserName.equals("edge"))
        {
           driver =new EdgeDriver();
        } else if (browserName.equals("safari"))
        {
            driver =new SafariDriver();
        }
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        return driver;


    }
}
