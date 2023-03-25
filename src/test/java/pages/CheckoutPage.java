package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage {

    @FindBy(xpath = "")
    public WebElement fied1;
    @FindBy(xpath = "")
    public WebElement fied2;
    @FindBy(xpath = "")
    public WebElement fied3;
    @FindBy(xpath = "")
    public WebElement fied4;
    @FindBy(xpath = "")
    public WebElement checkoutButton;


    public WebElement getFied1() {
        return fied1;
    }

    public WebElement getFied2() {
        return fied2;
    }

    public WebElement getFied3() {
        return fied3;
    }

    public WebElement getFied4() {
        return fied4;
    }

    public WebElement getCheckoutButton() {
        return checkoutButton;
    }

    public void clickCheckoutButton() {
      checkoutButton.click();
    }
}
