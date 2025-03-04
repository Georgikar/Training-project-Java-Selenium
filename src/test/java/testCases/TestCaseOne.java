package testCases;

import WebElements.ElementInteraction;
import driver.DriverInteraction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCaseOne {
    public static void main(String[] args) {

        DriverInteraction driverInetraction = new DriverInteraction();
        WebDriver driver = DriverInteraction.initialize("Firefox");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        ElementInteraction elementInteraction = new ElementInteraction();
        By textBoxControl = By.xpath("//input[@class=\"inputs ui-autocomplete-input\"]");
        elementInteraction.setText(driver,textBoxControl,"Hello");






        //DriverInteraction.terminate(driver);
    }
}