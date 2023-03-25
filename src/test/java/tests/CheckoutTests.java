package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import utils.Driver;

public class CheckoutTests extends TestBase {

    @Test
    public void checkoutPositive() {


        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.getFied1().sendKeys("John");
        checkoutPage.getFied2().sendKeys("Does");
        checkoutPage.getFied3().sendKeys("4");
        checkoutPage.getFied4().sendKeys("23.56");
        checkoutPage.clickCheckoutButton();

        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Your order summary below: "));

    }

}


