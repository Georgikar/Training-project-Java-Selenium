package pom;

import WebElements.ElementInteraction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Calendar {


    WebDriver driver=null;
    public Calendar (WebDriver driver){
        this.driver=driver;
    }
    ElementInteraction elementInteraction = new ElementInteraction();

    By btnCalendar = By.xpath("(//i[@class='oxd-icon bi-calendar oxd-date-input-icon'])[1]");
    By btnPrev = By.xpath("//div[@class='oxd-calendar-header']/button/i[@class='oxd-icon bi-chevron-left']");


    public void clickCalendar(){
        elementInteraction.elementClick(driver,btnCalendar);

    }
    public void setDay(String setDate,String setMonth, String setYear){

        String  getMonth = driver.findElement(By.xpath("//div[@class='oxd-calendar-selector-month-selected']")).getText();
        String getYear = driver.findElement(By.xpath("//div[@class='oxd-calendar-selector-year-selected']")).getText();


        while (!(getMonth.equals(setMonth) && getYear.equals(setYear))){

            elementInteraction.elementClick(driver,btnPrev);
            getMonth =driver.findElement(By.xpath("//div[@class='oxd-calendar-selector-month-selected']")).getText();
            getYear = driver.findElement(By.xpath("//div[@class='oxd-calendar-selector-year-selected']")).getText();
        }

        if(getMonth.equals(setMonth) && getYear.equals(setYear)){
            List<WebElement> getDays = driver.findElements(By.className("oxd-calendar-date-wrapper"));

            for(WebElement days : getDays){

                if(days.getText().equals(setDate)){
                    days.click();
                    return;
                }
            }
        }
    }
}

