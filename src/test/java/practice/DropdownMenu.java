package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownMenu {

    public static void main(String[] args){

        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        Select dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"dropdown-class-example\"]")));
        
        int countOptions = dropdown.getOptions().size();

        for(int i=0; i<countOptions; i++){

            dropdown.selectByIndex(i);
        }









    }
}
