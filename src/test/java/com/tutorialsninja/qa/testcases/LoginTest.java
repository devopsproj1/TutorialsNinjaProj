package com.tutorialsninja.qa.testcases;



import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.utils.utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest extends Base {

  WebDriver driver;



    @AfterMethod
    public  void TearDown(){
        driver.quit();
    }
    @BeforeMethod
    public  void  BrowserSetup(){
        InitializeBrowserAndOpenApplication("chrome");
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
    }

    @Test(priority = 0,dataProvider = "validCredentials")
    public  void verifyLoginWithValidCredentials(String email,String password) {

        driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys(email);
         driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys(password);
         driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
         Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/ul[1]/li[1]/a")).isDisplayed());

}

   @Test(priority = 1,dataProvider = "validCredentials")
    public  void verifyLoginWithInValidCredentials() {

    driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys(utilities.GetDateText());
    driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("125");
    driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
    String Warning=driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText();
    String actWarn="Warning: No match for E-Mail Address and/or Password.";
    Assert.assertEquals(Warning,actWarn);

}
@Test(priority = 2,dataProvider = "validCredentials")
public void verifyLoginWithValidEmailWithInvalidPassword(){


    driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys(utilities.GetDateText());
    driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("1345");
    driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
    String Warning=driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText();
    String actWarn="Warning: No match for E-Mail Address and/or Password.";
    Assert.assertEquals(Warning,actWarn);


}
    @Test(priority = 3)
    public void verifyLoginWithInValidEmailWithvalidPassword(){



        driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys(utilities.GetDateText());
        driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("1235");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
        String Warning=driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText();
        String actWarn="Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(Warning,actWarn);


    }
    @Test(priority = 4)
    public void verifyLoginWithNoCredentials(){

        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("");
        driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
        String Warning=driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText();
        String actWarn="Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(Warning,actWarn);


    }

}
