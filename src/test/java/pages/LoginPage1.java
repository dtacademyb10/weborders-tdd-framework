package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Driver;

public class LoginPage1 {

    // Page class created by using traditional Page Object Model approach

    // Encapsulation
       private WebElement username =  Driver.getDriver().findElement(By.id("ctl00_MainContent_username"));
       private WebElement password =  Driver.getDriver().findElement(By.name("ctl00$MainContent$password"));
       private WebElement button =  Driver.getDriver().findElement(By.className("button"));



       public void enterUsername(String username){
           this.username.sendKeys(username);
       }
        public void enterPassword(String password){
            this.password.sendKeys(password);
        }

        public void clickLoginButton(){
        button.click();
        }







}
