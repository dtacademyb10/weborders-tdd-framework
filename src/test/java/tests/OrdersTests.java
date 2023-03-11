package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllOrdersPage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.Driver;

public class OrdersTests extends TestBase{



    @Test
    public void deleteSelectedButtonTest(){


        LoginPage loginPage = new LoginPage();

        loginPage.enterUsername(ConfigReader.getProperty("username"));
        loginPage.enterPassword(ConfigReader.getProperty("password"));
        loginPage.clickLoginButton();

        AllOrdersPage allOrdersPage = new AllOrdersPage();
        allOrdersPage.clickCheckAll();
        allOrdersPage.clickDeleteSelected();

        Assert.assertTrue(allOrdersPage.getMessage().isDisplayed());



    }
}
