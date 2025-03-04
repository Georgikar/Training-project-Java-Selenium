package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TableSearch {

    WebDriver driver = null;

    public TableSearch(WebDriver driver) {
        this.driver = driver;
    }


    public  WebElement searchByRowName(String name) {


        WebElement table = driver.findElement(By.xpath("(//table[@id='product'])[2]"));
        List<WebElement> rows = table.findElements(By.xpath("tbody/tr"));

        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));

            if (columns.get(0).getText().equals(name)) {
                return row;
            }

        }

    return null;

    }
}


