package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class ElementInteraction {

    public void setText (WebDriver driver,By locator,String value) {


        try {
            driver.findElement(locator).sendKeys(value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void setTextRelativeLocator (WebDriver driver, RelativeLocator.RelativeBy relativeLocator, String value) {


        try {
            driver.findElement(relativeLocator).sendKeys(value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void elementClick(WebDriver driver, By locator){

        try {
            FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(2))
                    .pollingEvery(Duration.ofMillis(200));
            wait.until(d ->  driver.findElement(locator).isDisplayed());
            driver.findElement(locator).click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }




}
