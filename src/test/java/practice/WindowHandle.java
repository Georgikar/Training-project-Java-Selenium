package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowHandle {
    public static void main (String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        String parentWindow = driver.getWindowHandle();
        System.out.println("Name of parentHandel" + parentWindow);

        driver.findElement(By.id("opentab")).click();

        for (String win : driver.getWindowHandles()) {
            if(!win.equals(parentWindow)){
                driver.switchTo().window(win);
            }
            System.out.println("Window Handle name:" + win);

        }
            System.out.println("The titel of page ist:" + driver.getTitle());
        //driver.quit();
    }
}