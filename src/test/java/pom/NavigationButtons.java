package pom;

import WebElements.ElementInteraction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class NavigationButtons {

    ElementInteraction elementInteraction = new ElementInteraction();

    WebDriver driver = null;
    public NavigationButtons(WebDriver driver){
        this.driver=driver;
    }

    By pim = By.xpath("//a[@href=\"/web/index.php/pim/viewPimModule\"]");
    By add = By.xpath("//i[@class=\"oxd-icon bi-plus oxd-button-icon\"]");
    By search = By.xpath("//button[@type='submit']");
    By deleteYes = By.xpath("(//button[@type='button'])[10]");

    public void clickPim(){

        elementInteraction.elementClick(driver, pim);


    }
    public void clickAdd(){
        elementInteraction.elementClick(driver, add);

    }

    public void clickSearch(){
        elementInteraction.elementClick(driver,search);
    }

    public void clickDelete (){

        elementInteraction.elementClick(driver,deleteYes);
    }
}
