package testCases;

import WebElements.ElementInteraction;
import com.sun.jdi.ByteValue;
import driver.DriverInteraction;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pom.*;
import practice.TableSearch;

import java.io.IOException;
import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class TestNG {

    public WebDriver driver = null;
    DriverInteraction driverInteraction = new DriverInteraction();
    ReportAssistance report = new ReportAssistance();



        @BeforeTest
        public void initialize() throws IOException {

            driver = driverInteraction.initialize("Firefox");
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            report.writeImage(driver);

        }

        @Test(priority = 1)

        public void Login() throws IOException, InterruptedException {

            Login login = new Login(driver);

            login.loginToHRM("Admin","admin123");
            report.writeImage(driver);
            report.writeLog("Logged on successfully");
        }


        @Test (priority = 2)
        public void AddNewEmployee() throws InterruptedException {
            NavigationButtons navigationButtons = new NavigationButtons(driver);
            AddEmployee addEmployee =new AddEmployee(driver);
            TableNavigation tableNavigation = new TableNavigation(driver);
            UpdateEmployee updateEmployee = new UpdateEmployee(driver);
            Calendar calendar = new Calendar(driver);



            navigationButtons.clickPim();
            navigationButtons.clickAdd();
            addEmployee.enterFirsName("Test1");
            addEmployee.enterLastName("test123");
            Thread.sleep(Duration.ofSeconds(2));


            WebElement ID =driver.findElement(By.xpath("//label[text()='Employee Id']/following::input[1]"));
            String idValue = ID.getAttribute("value");
            //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
            //wait.until(ExpectedConditions.presenceOfElementLocated(By.className("oxd-switch-wrapper")));



            addEmployee.clickBtnCreateDetails();
            addEmployee.enterNewUsername("User1"+ RandomString.make(5));
            addEmployee.enterNewPassword("password123");
            addEmployee.enterNewPasswordAgain("password123");
            addEmployee.btnSave();
            Thread.sleep(Duration.ofSeconds(4));

            navigationButtons.clickPim();
            Thread.sleep(Duration.ofSeconds(2));
            addEmployee.enterEmployeeID(idValue);

            navigationButtons.clickSearch();
            Thread.sleep(Duration.ofSeconds(3));
            tableNavigation.setCheckBox();
            tableNavigation.btnEdit();
            Thread.sleep(Duration.ofSeconds(5));
            updateEmployee.enterDriversLicenseNumber(RandomString.make(5));


            calendar.clickCalendar();
            calendar.setDay("5","March","2023");
            updateEmployee.clickBtnSave();
            Thread.sleep(Duration.ofSeconds(2));
            navigationButtons.clickPim();
            Thread.sleep(Duration.ofSeconds(3));

            addEmployee.enterEmployeeID(idValue);
            navigationButtons.clickSearch();
            tableNavigation.setCheckBox();
            tableNavigation.btnEdit();

            //Assert.assertEquals(getDriversLicenseNumber.getAttribute("value"),driversLicenseNummer);

            navigationButtons.clickPim();
            Thread.sleep(Duration.ofSeconds(2));

            addEmployee.enterEmployeeID(idValue);
            navigationButtons.clickSearch();
            tableNavigation.setCheckBox();
            tableNavigation.btnDelete();
            navigationButtons.clickDelete();
        }




        @AfterTest
        public void Terminate(){

            driverInteraction.terminate(driver);
        }
    }

