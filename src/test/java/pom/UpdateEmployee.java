package pom;

import WebElements.ElementInteraction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class UpdateEmployee {

    ElementInteraction elementInteraction = new ElementInteraction();
    WebDriver driver= null;

    public UpdateEmployee(WebDriver driver){
        this.driver=driver;
    }

    By labelSSNNumber = By.xpath("//label[contains(text(),'Driver')]");
    RelativeLocator.RelativeBy txtDriversLicenseNumber = RelativeLocator.with(By.tagName("Input")).below(labelSSNNumber);

    By txtLicenseExpiryDate = By.xpath("(//input[@placeholder='yyyy-dd-mm'])[1]");
    By btNSave = By.xpath("//button[@type='submit']");


    public void enterDriversLicenseNumber(String driversLicenceNumber){
        elementInteraction.setTextRelativeLocator(driver,txtDriversLicenseNumber, driversLicenceNumber);

    }



    public void clickBtnSave(){
        elementInteraction.elementClick(driver,btNSave);
    }



}

