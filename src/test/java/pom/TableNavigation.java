package pom;

import WebElements.ElementInteraction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TableNavigation {

    ElementInteraction elementInteraction = new ElementInteraction();
    WebDriver driver= null;

    By editButton = By.xpath("//i[@class='oxd-icon bi-pencil-fill']");
    By checkbox = By.xpath("//div[@class='oxd-table-card-cell-checkbox']");
    By deleteBtn = By.xpath("//i[@class='oxd-icon bi-trash']");
    public TableNavigation(WebDriver driver){
        this.driver=driver;
    }


    public void setCheckBox() {
        elementInteraction.elementClick(driver,checkbox);
    }

    public void btnEdit (){
        elementInteraction.elementClick(driver,editButton);

    }
    public void btnDelete(){
        elementInteraction.elementClick(driver,deleteBtn);

    }
}
