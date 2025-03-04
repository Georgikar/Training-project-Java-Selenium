package testCases;

import driver.DriverInteraction;
import org.openqa.selenium.WebDriver;
import pom.Login;

public class TestCaseTwo {

    public static void main(String[] args) throws InterruptedException {

        DriverInteraction driverInteraction = new DriverInteraction();
        WebDriver driver = driverInteraction.initialize("Firefox");
        Login login = new Login(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(5000);
        login.enterUser("admin");
        login.enterPassword("Admin123");
        login.pressLogin();

        driverInteraction.terminate(driver);
    }
}
