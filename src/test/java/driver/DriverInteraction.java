package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverInteraction {

    public static WebDriver initialize(String browsertype){

        WebDriver driver = null;
        switch (browsertype){

            case "Chrome":
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;

            case "Firefox":
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;

            default:
                driver=null;
        }
        return driver;
    }
    public static void terminate(WebDriver driver){
        driver.quit();


    }
}
