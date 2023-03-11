package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;
import utils.Driver;

public class LoginTests extends TestBase {


    @Test
    public void positiveLogin(){

        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys(ConfigReader.getProperty("username"));
        Driver.getDriver().findElement(By.name("ctl00$MainContent$password")).sendKeys(ConfigReader.getProperty("password"));
        Driver.getDriver().findElement(By.className("button")).click();
        Assert.assertEquals( Driver.getDriver().getTitle(), "Web Orders");

    }


}
