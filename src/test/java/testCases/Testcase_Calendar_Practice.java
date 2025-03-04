package testCases;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class Testcase_Calendar_Practice {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
        driver.manage().window().maximize();


        WebElement modalWindow = driver.findElement(By.xpath("//p[text()='Consent']"));
        if(modalWindow.isDisplayed()){
            modalWindow.click();
        }

        String setDate = "6";
        String setMonth = "June";
        String setYear = "2023";


        WebElement btnCalendar = driver.findElement(By.className("ui-datepicker-trigger"));
        btnCalendar.click();
        Thread.sleep(2000);

        WebElement btnPrev = driver.findElement(By.xpath("//a[@title='Prev']"));

        String getYear = driver.findElement(By.className("ui-datepicker-year")).getText();


        String getMonth = driver.findElement(By.className("ui-datepicker-month")).getText();



        while (!(getMonth.equals(setMonth) && getYear.equals(setYear))){

            try {
                btnPrev.click();
            } catch (StaleElementReferenceException e) {
                btnPrev = driver.findElement(By.xpath("//a[@title='Prev']"));
                btnPrev.click();
            }
            getMonth=driver.findElement(By.className("ui-datepicker-month")).getText();
            getYear=driver.findElement(By.className("ui-datepicker-year")).getText();


        }

        WebElement calendar = driver.findElement(By.className("ui-datepicker-calendar"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", calendar);
        

        if(getMonth.equals(setMonth) && getYear.equals(setYear)){
            List<WebElement> getDays = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody/tr/td"));

            for(WebElement date: getDays){

                if(date.getText().equals(setDate)){
                    date.click();
                    return;
                }

            }
        }




    }
}
