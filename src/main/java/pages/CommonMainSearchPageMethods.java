package pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.junit.Assert;
import org.openqa.selenium.*;
import utilities.DriverFactory;
import utilities.ErrorHandler;
import utilities.Log4jHandler;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CommonMainSearchPageMethods {
    public static void clickOnTheSearchButton(String className, ExtentTest gherkinKeyword) throws InterruptedException {
        try {
            DriverFactory.getDriver().findElement(By.xpath("//button[@role='flights_submit']")).click();
        } catch (NoSuchElementException e) {
            ErrorHandler.errorNoPageObjectFound(className, gherkinKeyword, e);
        }
        DriverFactory.waitThreeSeconds();
    }

    private static void clearFieldById(String id, String className, ExtentTest gherkinKeyword) throws InterruptedException {
        Log4jHandler.getLogger().info("Search main page field by id " + id);
        try {
            DriverFactory.waitThreeSeconds();
            DriverFactory.getDriver().findElement(By.id(id)).click();
            DriverFactory.getDriver().findElement(By.id(id)).clear();
            System.out.println("");
        } catch (NoSuchElementException e) {
            ErrorHandler.errorNoPageObjectFound(className, gherkinKeyword, e);
        }
    }

    public static void clearFlightReturnField(String className, ExtentTest gherkinKeyword) throws InterruptedException {
        clearFieldById("flights-dates-return-prepop-whitelabel_en",className,gherkinKeyword);
    }

    public static void validateFieldIsEmptyValidationWorks(String className, ExtentTest gherkinKeyword) {
        //this is not a correct implementation - we should be sure that other fields got no validation issues
        //please fix

        if (DriverFactory.getDriver().getPageSource().contains("Please fill put this field.")){
            Log4jHandler.getLogger().info("Search is not allowed");
        } else {
            Log4jHandler.getLogger().error("No search should be available for  empty departure date");
            gherkinKeyword.error("No search should be available for empty departure date");
            Assert.assertEquals(gherkinKeyword.getStatus(), Status.PASS);
        }
    }

    public static void clearFlightDepartField(String className, ExtentTest gherkinKeyword) throws InterruptedException {
        clearFieldById("flights-dates-depart-prepop-whitelabel_en", className, gherkinKeyword);
    }

    public static void setOriginAirport(String originAirport, String className, ExtentTest gherkinKeyword) throws InterruptedException {
        try {
            //this id works for english version only, please apply tests for other lang
            clearFieldById("flights-origin-prepop-whitelabel_en",className,gherkinKeyword);
            setAirport("flights-origin-prepop-whitelabel_en",originAirport);
        } catch (NoSuchElementException e) {
            ErrorHandler.errorNoPageObjectFound(className, gherkinKeyword, e);
        }
    }

    public static void setDestinationAirport(String destinationAirport, String className, ExtentTest gherkinKeyword) throws InterruptedException {
        try {
            //this id works for english version only, please apply tests for other lang
            clearFieldById("flights-destination-prepop-whitelabel_en",className,gherkinKeyword);
            setAirport("flights-destination-prepop-whitelabel_en",destinationAirport);
        } catch (NoSuchElementException e) {
            ErrorHandler.errorNoPageObjectFound(className, gherkinKeyword, e);
        }
    }

    private static void setAirport(String elementId, String airport) throws InterruptedException {
        DriverFactory.waitThreeSeconds();
        WebElement e = DriverFactory.getDriver().findElement(By.id(elementId));
        e.click();
        e.sendKeys(airport);
        DriverFactory.waitThreeSeconds();

        try {
            DriverFactory.getDriver().findElement(By.xpath("//li[contains(@role,'autocomplete_item')]")).click();
        }
        catch (NoSuchElementException error){
            DriverFactory.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            e.sendKeys(Keys.TAB);
        }

        DriverFactory.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Log4jHandler.Add_Log.info(airport + " added");
    }

    public static void setDepartDate(String className, ExtentTest gherkinKeyword) throws InterruptedException {
        try {
            //this id works for english version only, please apply tests for other lang
            DriverFactory.getDriver().findElement(By.id("flights-dates-depart-prepop-whitelabel_en")).click();
            String date = new SimpleDateFormat("yyyy-M-d").format(new Date());

            DriverFactory.waitThreeSeconds();

            String cssSelector = "td[id='mewtwo-datepicker-"+ date + "'][data-date='" + date + "']";
            DriverFactory.getDriver().findElement(By.cssSelector(cssSelector)).click();
            Log4jHandler.Add_Log.info(date + " depart date selected");
        } catch (NoSuchElementException e) {
            ErrorHandler.errorNoPageObjectFound(className, gherkinKeyword, e);
        }
    }

    public static void setReturnDate(String className, ExtentTest gherkinKeyword) throws InterruptedException {
        try {
            //this id works for english version only, please apply tests for other lang
            DriverFactory.getDriver().findElement(By.id("flights-dates-return-prepop-whitelabel_en")).click();

            DriverFactory.waitThreeSeconds();
            DriverFactory.getDriver().findElement(By.cssSelector("span[class=mewtwo-datepicker-next-month-control][role=datepicker-next]")).click();

            DriverFactory.waitThreeSeconds();
            DriverFactory.getDriver().findElement(By.xpath("//td[@class='mewtwo-datepicker-current-date mewtwo-datepicker-current']/div[text()='1']")).click();

            Log4jHandler.Add_Log.info("Return date selected");
        } catch (NoSuchElementException e) {
            ErrorHandler.errorNoPageObjectFound(className, gherkinKeyword, e);
        }
    }

    private static void passangerAmountChange(int amount, String role) throws InterruptedException {
        DriverFactory.waitThreeSeconds();
        DriverFactory.getDriver().findElement(By.xpath("//div[@class='mewtwo-flights-trip_class-wrapper']")).click();
        DriverFactory.waitThreeSeconds();
        int uiAmountInt = Integer.valueOf(DriverFactory.getDriver().
                findElement(By.cssSelector("div[role='" + role + "']>span[class='mewtwo-popup-ages-counter__amount']")).
                    getText());

        while (amount != uiAmountInt) {
            if (amount > uiAmountInt) {
                DriverFactory.getDriver().findElement(By.cssSelector("div[role='" + role + "']>span[class='mewtwo-popup-ages-counter__plus']")).click();
                uiAmountInt++;
            } else {
                DriverFactory.getDriver().findElement(By.cssSelector("div[role='" + role + "']>span[class='mewtwo-popup-ages-counter__minus']")).click();
                uiAmountInt--;
            }
        }
    }

    public static void setAdultsAmount(int adultsAmount, String className, ExtentTest gherkinKeyword) throws InterruptedException {
        try {
            //this id works for english version only, please apply tests for other lang
            if(adultsAmount<1){
                Log4jHandler.getLogger().error("It should be at least one adult passanger! Please modify your test case");
                gherkinKeyword.error("It should be at least one adult passanger! Please modify your test case");
                Assert.assertEquals(gherkinKeyword.getStatus(), Status.PASS);
            }

            passangerAmountChange(adultsAmount, "adults");
            DriverFactory.getDriver().findElement(By.xpath("//span[@class='mewtwo-passengers-ready__button mewtwo-popup_apply_button--desktop']")).click();

        } catch (NoSuchElementException e) {
            ErrorHandler.errorNoPageObjectFound(className, gherkinKeyword, e);
        }
    }

    public static void setChildrenAmount(int childrenAmount, String className, ExtentTest gherkinKeyword) throws InterruptedException {
        try {
            passangerAmountChange(childrenAmount, "children");
            DriverFactory.getDriver().findElement(By.xpath("//span[@class='mewtwo-passengers-ready__button mewtwo-popup_apply_button--desktop']")).click();
        }
        catch (NoSuchElementException e) {
            ErrorHandler.errorNoPageObjectFound(className, gherkinKeyword, e);
        }
    }

    public static void setInfantsAmount(int infantsAmount, String className, ExtentTest gherkinKeyword) throws InterruptedException {
       try {
          passangerAmountChange(infantsAmount, "infants");
            DriverFactory.getDriver().findElement(By.xpath("//span[@class='mewtwo-passengers-ready__button mewtwo-popup_apply_button--desktop']")).click();
         }
        catch (NoSuchElementException e) {
        ErrorHandler.errorNoPageObjectFound(className, gherkinKeyword, e);
        }
    }

    public static void setHotelsSearch(String searchForHotels, String className, ExtentTest gherkinKeyword) throws InterruptedException {
        try {
            //this id works for english version only, please apply tests for other lang
            WebDriver driver = DriverFactory.getDriver();
            DriverFactory.waitThreeSeconds();
            boolean isSelected = driver.findElement(By.xpath("//input[@class='mewtwo-show_hotels-checkbox']")).isSelected();

            if (searchForHotels.equals("no") && isSelected){
                driver.findElement(By.xpath("//label[@class='mewtwo-show_hotels__label']")).click();
            }
            if (searchForHotels.equals("yes") && !isSelected){
                driver.findElement(By.xpath("//label[@class='mewtwo-show_hotels__label']")).click();
            }
        } catch (NoSuchElementException e) {
            ErrorHandler.errorNoPageObjectFound(className, gherkinKeyword, e);
        }

    }

}
