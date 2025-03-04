package pom;

import WebElements.ElementInteraction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class AddEmployee {

    ElementInteraction elementInteraction = new ElementInteraction();

    WebDriver driver= null;
    public AddEmployee(WebDriver driver){
        this.driver=driver;
    }

    By txtfirstName = By.name("firstName");
    By txtlastName = By.name("lastName");
    By btnCreateLoginDetails = By.className("oxd-switch-wrapper");
    RelativeLocator.RelativeBy txtnewUsername = RelativeLocator.with(By.tagName("input")).below(btnCreateLoginDetails);
    RelativeLocator.RelativeBy txtnewPassword = RelativeLocator.with(By.tagName("input")).below(txtnewUsername);
    By elementBelow = By.cssSelector("span.oxd-radio-input.oxd-radio-input--active.--label-right");
    RelativeLocator.RelativeBy txtconfirmNewPassword = RelativeLocator.with(By.tagName("input")).below(elementBelow);
    By btNSave = By.xpath("//button[@type='submit']");
    By labelEmployeeID = By.xpath("//label[text()='Employee Id']");
    RelativeLocator.RelativeBy txtEmployeeID = RelativeLocator.with(By.tagName("Input")).below(labelEmployeeID);


    public void enterFirsName(String firstName) {
        elementInteraction.setText(driver, txtfirstName, firstName);

    }
        public void enterLastName(String lastName){
            elementInteraction.setText(driver, txtlastName, lastName);
    }

    public void clickBtnCreateDetails(){

        elementInteraction.elementClick(driver,btnCreateLoginDetails);
    }

    public void enterNewUsername(String newUsername){
        elementInteraction.setTextRelativeLocator(driver, txtnewUsername, newUsername);
    }

    public void enterNewPassword(String newPassword){
        elementInteraction.setText(driver,txtnewPassword,newPassword);
    }

    public void enterNewPasswordAgain(String newPasswordAgain){
        elementInteraction.setText(driver,txtconfirmNewPassword,newPasswordAgain);

    }

    public void btnSave(){
        elementInteraction.elementClick(driver,btNSave);
    }

    public void enterEmployeeID (String idValue){

        elementInteraction.setText(driver,txtEmployeeID, idValue);
    }
}
