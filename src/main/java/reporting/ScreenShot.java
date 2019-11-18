package reporting;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.DriverFactory;
import utilities.Log4jHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot {

    // This method takes a screenshot of the browser and saves as a file
    public static String doScreenshot(String filename) {
        String rootFolder = "./reports/screenshots/";
        String returnRootFolder= "./screenshots/";
        String returnDestination = null;
        String destination = null;
        WebDriver driver = DriverFactory.getDriver();
        File ScreenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // Create file from the screenshot of driver
        try {
            String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            destination = rootFolder + filename + dateName + ".jpg";
            returnDestination = returnRootFolder + filename + dateName + ".jpg";
            FileUtils.copyFile(ScreenshotFile, new File (destination));
            Log4jHandler.getLogger().error("Screenshot generated");
        } catch (IOException e) {
            Log4jHandler.getLogger().error("Failed to create a screenshot " + destination + ". Stack Trace: " + e);
        }
        return returnDestination;
    }
}

