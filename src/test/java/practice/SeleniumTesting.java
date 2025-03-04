package practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTesting {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        String browser="chrome";

        if (browser.equals("chrome")) {
            ChromeOptions opt = new ChromeOptions();
            opt.addArguments("--disable-search-engine-choice-screen");
            opt.addArguments("---start-maximized");
            driver = new ChromeDriver(opt);

        }
        else if (browser.equals("firefox")){
            driver = new FirefoxDriver();
            driver.manage().window().maximize();

        }
        else {
            EdgeOptions opts1 = new EdgeOptions();
            //opts1.addArguments("---start-maximized");
            driver = new EdgeDriver(opts1);}

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //          Implicit Wait
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //        Find Element and enter Name
        driver.findElement(By.name("enter-name")).sendKeys("test");
        //        Find Element and click on Alert
        driver.findElement(By.id("alertbtn")).click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();







        //driver.quit();
    }
}
