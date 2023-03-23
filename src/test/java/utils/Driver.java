package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {


    // This class uses Singleton Design pattern which ensures that during the execution of any test
    // there is going to be only a single active browser, it prevents the multiple browser initialization issue common in test frameworks
    private static ThreadLocal<WebDriver> drivers =  new ThreadLocal<>();

    private Driver(){} //to prevent instantiation

    public static synchronized WebDriver getDriver(){


        String browser = System.getProperty("browser"); // read the browser value from the command line

        if (browser == null){ // if no browser is passed from cmd
            browser = ConfigReader.getProperty("browser"); // read the browser from config.properties
        }


        if(drivers.get() == null) { // check if the driver is initialized

           // if not, initialize using the value from properties file
            switch (browser) {
                case "chrome":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    drivers.set(new ChromeDriver(options));
                    break;
                case "headlessChrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--remote-allow-origins=*");
                    chromeOptions.addArguments("--headless");
                    drivers.set(new ChromeDriver(chromeOptions));
                    break;
                case "edge":
                    drivers.set(new EdgeDriver());
                    break;
                case "headlessEdge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--headless");
                    drivers.set(new EdgeDriver(edgeOptions));
                    break;
                case "firefox":
                    drivers.set(new FirefoxDriver());
                    break;
                case "headlessFirefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--headless");
                    drivers.set(new FirefoxDriver(firefoxOptions));
                    break;
                case "safari":
                    drivers.set(new SafariDriver());
                    break;
                default:
                    throw new RuntimeException("Unsupported browser");


            }

        }

        return  drivers.get(); // if already initialized previously, return this initialized object
    }


    public synchronized static void quitDriver(){

         if(drivers.get() != null){  // if the driver is active
             drivers.get().quit();  // quit the driver
             drivers.remove();  // set the driver variable value to null because next initialization of driver checks if it is null
         }

    }


}
