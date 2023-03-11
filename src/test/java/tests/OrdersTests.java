package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class OrdersTests extends TestBase{


    @Test
    public void deleteSelectedButtonTest(){

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(ConfigReader.getProperty("username"));
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys(ConfigReader.getProperty("password"));
        driver.findElement(By.className("button")).click();

        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        driver.findElement(By.name("ctl00$MainContent$btnDelete")).click();

        Assert.assertTrue(driver.getPageSource().contains("List of orders is empty."));

    }
}
