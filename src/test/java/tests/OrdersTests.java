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
import utils.SeleniumUtils;

public class OrdersTests extends TestBase{



    @Test (groups = {"smoke"})
    public void deleteSelectedButtonTest(){


        LoginPage loginPage = new LoginPage();

        loginPage.enterUsername(ConfigReader.getProperty("username"));
        loginPage.enterPassword(ConfigReader.getProperty("password"));
        loginPage.clickLoginButton();

        AllOrdersPage allOrdersPage = new AllOrdersPage();
        allOrdersPage.clickCheckAll();
        allOrdersPage.clickDeleteSelected();
        SeleniumUtils.waitForVisibility(allOrdersPage.getMessage(), 5);

        Assert.assertTrue(allOrdersPage.getMessage().isDisplayed());



    }
}
