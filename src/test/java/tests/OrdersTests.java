package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;
import utils.Driver;

public class OrdersTests extends TestBase{



    @Test
    public void deleteSelectedButtonTest(){


        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys(ConfigReader.getProperty("username"));
        Driver.getDriver().findElement(By.name("ctl00$MainContent$password")).sendKeys(ConfigReader.getProperty("password"));
        Driver.getDriver().findElement(By.className("button")).click();

        Driver.getDriver().findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        Driver.getDriver().findElement(By.name("ctl00$MainContent$btnDelete")).click();

        Assert.assertTrue( Driver.getDriver().getPageSource().contains("List of orders is empty."));

    }
}
