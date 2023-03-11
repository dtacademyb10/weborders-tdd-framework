package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {


    // This class uses Singleton Design pattern which ensures that during the execution of any test, ther is going to be
    // only a single browser open
    private static WebDriver driver;

    private Driver(){} //to prevent instantiation

    public static WebDriver getDriver(){

        String browser = ConfigReader.getProperty("browser");

        if(driver == null) { // check if the driver is initialized

           // if not, initialize using the value from properties file
            switch (browser) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
                default:
                    throw new RuntimeException("Unsupported browser");


            }

        }

        return driver; // if already initialized previously, return this initialized object
    }


    public static void quitDriver(){

         if(driver != null){
             driver.quit();
             driver = null;
         }

    }


}
