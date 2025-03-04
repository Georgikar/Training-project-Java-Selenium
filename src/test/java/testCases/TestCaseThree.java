package testCases;

import driver.DriverInteraction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import practice.TableSearch;

public class TestCaseThree {

    public static void main(String[] args){

        DriverInteraction driverInetraction = new DriverInteraction();
        WebDriver driver = DriverInteraction.initialize("Firefox");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        TableSearch tableSearch = new TableSearch(driver);
        WebElement row = tableSearch.searchByRowName("Joe");
        if(row!=null){
            System.out.println("Row found: " + row.getText());
        }else {
            System.out.println("Row not found");
        }


    }
}
