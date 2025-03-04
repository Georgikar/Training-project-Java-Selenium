package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocators {

    public static void main (String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.manage().window().maximize();

        WebElement element = driver.findElement(RelativeLocator.with(By.tagName("input")).below(driver.findElement(By.xpath("//legend[text()=\"Suggession Class Example\"]"))));

        element.sendKeys("Gogo");
    }
}
