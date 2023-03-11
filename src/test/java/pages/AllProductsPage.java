package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class AllProductsPage {


    public AllProductsPage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }

    public List<WebElement> getHeaderElements() {
        return headerElements;
    }

    @FindBy (xpath = "//table[@class='ProductsTable']//tr[1]//th")
    private List<WebElement> headerElements;




}
