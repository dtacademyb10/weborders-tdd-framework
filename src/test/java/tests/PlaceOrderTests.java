package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AllOrdersPage;
import pages.LoginPage;
import pages.PlaceOrderPage;
import utils.SeleniumUtils;

public class PlaceOrderTests extends TestBase{


    @Test
    public void testPlaceOrder() throws InterruptedException {

        LoginPage loginPage = new LoginPage();
        loginPage.login();

        new AllOrdersPage().clickOnLink("Order");

        PlaceOrderPage placeOrderPage = new PlaceOrderPage();

        placeOrderPage.chooseProduct(PlaceOrderPageConstants.MY_MONEY);

        SeleniumUtils.waitFor(5);

        placeOrderPage.enterQuantity(20);

        placeOrderPage.clickOnCalculateButton();

        Assert.assertEquals(placeOrderPage.getTotalValue(), 1840);



    }




}
