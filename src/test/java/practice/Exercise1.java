package practice;

import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Exercise1 {

    public static void main (String[] args) throws InterruptedException {

        //Load Website
        WebDriver driver = new FirefoxDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();


        //Login
        WebElement username =driver.findElement(By.name("username"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");
        WebElement loginButton = driver.findElement(RelativeLocator.with(By.tagName("button")).below(password));
        loginButton.click();

        //Wait until Dashboard is displayed
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()=\"Dashboard\"]")));

        //Open PIM
        WebElement pim = driver.findElement(By.xpath("//a[@href=\"/web/index.php/pim/viewPimModule\"]"));
        pim.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class=\"oxd-icon bi-plus oxd-button-icon\"]")));
        WebElement add = driver.findElement(By.xpath("//i[@class=\"oxd-icon bi-plus oxd-button-icon\"]"));
        add.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));

        //Add Employee
        WebElement firstname = driver.findElement(By.name("firstName"));
        firstname.sendKeys("Testname");
        WebElement lastname = driver.findElement(By.name("lastName"));
        lastname.sendKeys("Testlastname");

        //Create Login Details
        WebElement createlogindetails = driver.findElement(By.className("oxd-switch-wrapper"));
        createlogindetails.click();

        WebElement new_username = driver.findElement(RelativeLocator.with(By.tagName("input")).below(createlogindetails));
        new_username.sendKeys("test" + RandomString.make(5));
        WebElement new_password = driver.findElement(RelativeLocator.with(By.tagName("input")).below(new_username));
        new_password.sendKeys("test123");
        WebElement confirm_password = driver.findElement(RelativeLocator.with(By.tagName("input")).below(driver.findElement(By.cssSelector("span.oxd-radio-input.oxd-radio-input--active.--label-right"))));
        confirm_password.sendKeys("test123");
        WebElement save = driver.findElement(By.xpath("//button[@type='submit']"));

        save.click();


        //Logout
        WebElement manda_user = driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']"));
        manda_user.click();
        WebElement logout = driver.findElement(By.xpath("//a[text()='Logout']"));
        logout.click();

        WebDriverWait fluent1 =  (WebDriverWait) new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofMillis(200));
        fluent1.until(d->username.isDisplayed());

        }



















}
