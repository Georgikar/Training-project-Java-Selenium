package pom;

import WebElements.ElementInteraction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Login {

    ElementInteraction elementInteraction = new ElementInteraction();

    WebDriver driver = null;
    public Login(WebDriver driver){
        this.driver = driver;

    }

    By txtUserName = By.xpath("//input[@name='username']");
    By txtPassword = By.xpath("//input[@name='password']");
    By btnLogin = By.xpath("//button[@type='submit']");


    public void enterUser(String userName){

        elementInteraction.setText(driver,txtUserName,userName);
    }

    public void enterPassword(String password){
        elementInteraction.setText(driver,txtPassword,password);
    }

    public void pressLogin(){

        elementInteraction.elementClick(driver,btnLogin);
    }

    public void loginToHRM(String userName, String password) throws InterruptedException {

        elementInteraction.setText(driver,txtUserName,userName);
        elementInteraction.setText(driver,txtPassword,password);
        Thread.sleep(Duration.ofSeconds(3));
        elementInteraction.elementClick(driver,btnLogin);
    }
}
