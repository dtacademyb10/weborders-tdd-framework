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


    @Test(dataProvider = "products")

    public void testPlaceOrderDataProvider(String productType, int quantity, int total){

        LoginPage loginPage = new LoginPage();
        loginPage.login();

        new AllOrdersPage().clickOnLink("Order");

        PlaceOrderPage placeOrderPage = new PlaceOrderPage();

        placeOrderPage.chooseProduct(productType);

        placeOrderPage.enterQuantity(quantity);

        placeOrderPage.clickOnCalculateButton();

        Assert.assertEquals(placeOrderPage.getTotalValue(), total);



    }

   @DataProvider  (name = "products")
    public Object[][] getData(){

        return new Object[][] {
                {PlaceOrderPageConstants.MY_MONEY, 20, 1840},
                {PlaceOrderPageConstants.MY_MONEY, 1, 100},
                {PlaceOrderPageConstants.MY_MONEY, 11, 1012},
                {PlaceOrderPageConstants.FAMILY_ALBUM, 100, 6800},
                {PlaceOrderPageConstants.FAMILY_ALBUM, 555, 37740},
                {PlaceOrderPageConstants.SCREEN_SAVER, 999, 17982}
        };
    }

}
