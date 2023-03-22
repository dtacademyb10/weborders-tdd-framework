package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigReader;
import utils.Driver;

public class LoginTests extends TestBase {


    @Test (groups = {"smoke"})
    public void positiveLoginPageObjectModel(){

        logger.info("Navigating to Login Page");
        LoginPage loginPage = new LoginPage();
        logger.info("Entering th username");
        loginPage.enterUsername(ConfigReader.getProperty("usernamedsd"));
        logger.info("Entering the password");
        loginPage.enterPassword(ConfigReader.getProperty("password"));
        logger.info("Clicking login button");
        loginPage.clickLoginButton();

        Assert.assertEquals( Driver.getDriver().getTitle(), "Web Orders");




    }

    @Test
    public void positiveLoginBadStyle(){

        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys(ConfigReader.getProperty("username"));
        Driver.getDriver().findElement(By.name("ctl00$MainContent$password")).sendKeys(ConfigReader.getProperty("password"));
        Driver.getDriver().findElement(By.className("button")).click();
        Assert.assertEquals( Driver.getDriver().getTitle(), "Web Orders");

    }

    @Test (groups = {"smoke"})
    public void negativeLogin(){


        LoginPage loginPage = new LoginPage();
        loginPage.enterPassword("dssd");
        loginPage.enterUsername("dsds");
        loginPage.clickLoginButton();
        Assert.assertNotEquals( Driver.getDriver().getTitle(), "Web Orders");

    }

    @Test
    public void negativeLogin2(){

        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();

        throw new SkipException("Test is not ready"); // to explicitly skip the test rather than executing and having the result as a failure


    }


}
