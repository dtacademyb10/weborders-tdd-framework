package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllOrdersPage;
import pages.AllProductsPage;
import pages.LoginPage;
import utils.SeleniumUtils;

import java.util.Arrays;
import java.util.List;

public class AllProductsTests extends  TestBase{


    @Test
    public void testProductsTableHeader() throws InterruptedException {

        new LoginPage().login();

        new AllOrdersPage().clickOnLink("View all products");

        List<String> expected = Arrays.asList("Product name","Price","Discount");

        AllProductsPage allProductsPage = new AllProductsPage();

        List<WebElement> headerElements = allProductsPage.getHeaderElements();

        List<String> actual = SeleniumUtils.getElementsText(headerElements);

        Assert.assertEquals(actual, expected);


    }



}
