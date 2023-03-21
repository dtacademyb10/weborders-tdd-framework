package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class AllOrdersPage {

    public AllOrdersPage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }
    @FindBy(id="ctl00_MainContent_btnCheckAll")
    private WebElement checkAllButton;
    @FindBy(name="ctl00$MainContent$btnDelete")
    private WebElement deleteSelectedButton;

    @FindBy(id="ctl00_MainContent_orderMessage")
    private WebElement message;





    public WebElement getMessage() {
        return message;
    }

    public void clickCheckAll(){
        checkAllButton.click();
    }

    public void clickDeleteSelected(){
        deleteSelectedButton.click();
    }

    public void clickOnLink(String linkText){
        String xpath = "//a[.='"+linkText+"']";
        Driver.getDriver().findElement(By.xpath(xpath)).click();
    }

}
