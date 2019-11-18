package pages;

import com.aventstack.extentreports.ExtentTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import utilities.DriverFactory;
import utilities.ErrorHandler;
import utilities.Log4jHandler;
public class SearchResultsPage {

    public static void searchResultsAviasalesComPageOpened(String className, ExtentTest gherkinKeyword) throws InterruptedException {
        DriverFactory.waitThreeSeconds();

        Log4jHandler.getLogger().info("Open main aviasales page opened (called from class: " + className + ")");
        Assert.assertEquals(DriverFactory.getDriver().getTitle(),"Aviasales.com - Cheap flights and airline tickets.");
        Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("http://www.aviasales.com/flights"));
    }

    public static void clickOnTripToGetDetails(String className, ExtentTest gherkinKeyword) {
        try {
            WebElement element = DriverFactory.getDriver().findElement(By.xpath("" +
                "//div[@role='ticket-container']/div[@class='ticket-scroll-container']/" +
                "div[@class='ticket-details']/div[@class='ticket-details-toggler']"));
        } catch (NoSuchElementException e) {
        ErrorHandler.errorNoPageObjectFound(className, gherkinKeyword, e);
        }
    }

    public static void validateTripDetailsExpanded(String className, ExtentTest gherkinKeyword) throws InterruptedException {
        DriverFactory.waitThreeSeconds();
        try {
            DriverFactory.getDriver().findElement(By.xpath("" +
                    "(//span[@class='flight-header__direction'])[1]")).isDisplayed();
        } catch (NoSuchElementException e) {
            ErrorHandler.errorNoPageObjectFound(className, gherkinKeyword, e);
        }
    }

    public static void validateBookingButtonAvailable(String className, ExtentTest gherkinKeyword) {
        WebElement element = null;
        try {
            element = DriverFactory.getDriver().findElement(By.xpath("" +
                    "(//a[@class='ticket-action-button-deeplink ticket-action-button-deeplink--'])[1]"));
        } catch (NoSuchElementException e) {
            ErrorHandler.errorNoPageObjectFound(className, gherkinKeyword, e);
        }
        Assert.assertEquals(element.isDisplayed(),true);
        Assert.assertEquals(element.isEnabled(), true);
    }

    public static void ReadPriceTagValue(String className, ExtentTest gherkinKeyword) {
        WebElement element = null;
        try {
            element = DriverFactory.getDriver().findElement(By.xpath("" +
                    "(//span[@class='currency_font currency_font--usd'])[2]"));
        } catch (NoSuchElementException e) {
            ErrorHandler.errorNoPageObjectFound(className, gherkinKeyword, e);
        }
        Assert.assertEquals(element.isDisplayed(),true);
        Assert.assertEquals(element.isEnabled(), true);
        Assert.assertNotNull(element.getText());
    }
}
