package com.tutorialsninja.qa.testcases;

import com.tutorialsninja.qa.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RegisterTest extends Base {
    WebDriver driver;

    @BeforeMethod
    public void  SetupBroser(){
       driver= InitializeBrowserAndOpenApplication("chrome");
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();

    }
    @AfterMethod
    public void TearDown(){
        driver.quit();
    }
    @Test
    public void VerifyUrl(){

    }
}
