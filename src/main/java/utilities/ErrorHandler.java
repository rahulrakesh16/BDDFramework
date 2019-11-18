package utilities;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import reporting.ScreenShot;
import java.io.IOException;

public class ErrorHandler {

    public static void errorNoPageObjectFound(String className, ExtentTest gherkinKeyword, NoSuchElementException e) {

        //To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
        //We do pass the path captured by this mehtod in to the extent reports using "logger.addScreenCapture" method.
        String screenshotPath = ScreenShot.doScreenshot(className);
        //To add it in the extent report

        try {
            gherkinKeyword.addScreenCaptureFromPath(screenshotPath);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        Log4jHandler.getLogger().error(e);
        gherkinKeyword.error(e);
        Assert.assertEquals(gherkinKeyword.getStatus(), Status.PASS);
    }
}
