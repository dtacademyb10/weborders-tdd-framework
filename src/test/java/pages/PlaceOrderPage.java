package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.Driver;

public class PlaceOrderPage {

    public PlaceOrderPage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }


    @FindBy (id = "ctl00_MainContent_fmwOrder_ddlProduct")
    private WebElement dropdownBox;

    @FindBy (id = "ctl00_MainContent_fmwOrder_txtQuantity")
    private WebElement quantityField;


    @FindBy (id = "ctl00_MainContent_fmwOrder_txtTotal")
    private WebElement totalField;

    @FindBy (xpath = "//input[@value='Calculate']")
    private WebElement calculateButton;


    public int getTotalValue(){
        return Integer.parseInt(totalField.getAttribute("value"));
    }


    public void clickOnCalculateButton(){
        calculateButton.click();
    }
    public void chooseProduct(String product){
        new Select(dropdownBox).selectByVisibleText(product);
    }

    public void enterQuantity(int quantity){
        quantityField.clear();
        quantityField.sendKeys(String.valueOf(quantity));
    }



}
