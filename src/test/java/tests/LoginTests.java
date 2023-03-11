package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class LoginTests extends TestBase {


    @Test
    public void positiveLogin(){

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(ConfigReader.getProperty("username"));
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys(ConfigReader.getProperty("password"));
        driver.findElement(By.className("button")).click();
        Assert.assertEquals(driver.getTitle(), "Web Orders");

    }


}
