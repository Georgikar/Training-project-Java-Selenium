package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class WaitStrategies {
    public static void main (String[] args){

        WebDriver driver = new FirefoxDriver();

        // Implicit Wait

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement element = driver.findElement(By.xpath(""));

        driver.manage().window().maximize();

        // Explicit Wait

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));

                //Aproach 1
        wait.until(d -> element.isDisplayed());

                //Aproach 2
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("")));

        //Fluent Wait

        WebDriverWait wait1 = (WebDriverWait) new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofMillis(200));
    }
}
