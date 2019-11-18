package pages;

import com.aventstack.extentreports.ExtentTest;
import org.junit.Assert;
import utilities.DriverFactory;
import utilities.Log4jHandler;

public class MainPage {

    public static void validateMainPageOpened(String className, ExtentTest gherkinKeyword) throws InterruptedException {

        //validate that page opened
        DriverFactory.getDriver().get("http://aviasales.com");
        DriverFactory.waitThreeSeconds();

        Log4jHandler.getLogger().info("Open main aviasales page opened (called from class: " + className + ")");
        Assert.assertEquals(DriverFactory.getDriver().getTitle(),"Aviasales.com - Cheap flights and airline tickets.");
        Assert.assertEquals(DriverFactory.getDriver().getCurrentUrl(),"http://www.aviasales.com/");

    }
}