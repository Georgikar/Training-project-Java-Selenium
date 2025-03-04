package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class CheckBox {

    public static void main (String[] args){

        WebDriver driver = new FirefoxDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        List<WebElement> checkboxes =  driver.findElements(By.xpath("//input[@type='checkbox']"));
        int count = checkboxes.size();

        for(int i=0; i<count; i++){
            checkboxes.get(i).click();
        }



    }
}
