package pom;

import net.bytebuddy.utility.RandomString;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.security.KeyStore;

public class ReportAssistance {


    public void writeImage(WebDriver driver) throws IOException {

        String screenshotPath = caputureScreenshot(driver, RandomString.make(7).toString());
        Reporter.log("<br><img src='"+ screenshotPath + "'height = '400' width='600'/><br>");
    }

    public String caputureScreenshot(WebDriver driver, String screenshotName) throws IOException {

        TakesScreenshot ts = (TakesScreenshot) driver;

        //Capture Screenshot and store as file
        File source = ts.getScreenshotAs(OutputType.FILE);

        //Define screenshot path
        String destination = System.getProperty("user.dir")+ "/Screenshots/" + screenshotName + ".png";
        System.out.println("Destination of file: "+destination);
        File finalDestination = new File(destination);

        //Copy file to destination
        FileUtils.copyFile(source, finalDestination);

        //Return the screenshot path for logging
        return destination;
    }


    public void writeLog(String msg){

       Reporter.log(msg, true);
   }
}
