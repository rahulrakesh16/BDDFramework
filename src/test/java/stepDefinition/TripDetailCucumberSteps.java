package stepDefinition;

import com.aventstack.extentreports.ExtentTest;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.SearchResultsPage;
import reporting.ExtentReport;
import utilities.Log4jHandler;

public class TripDetailCucumberSteps {
    String currentClassName = getClass().getName();

    @When("^I click on the trip$")
    public void iClickOnTheTrip() throws Throwable {
        ExtentTest when = ExtentReport.createNode("When", "I click on the trip",
                "Click on the trip header");
        Log4jHandler.Add_Log.info("Cucumber step execution: I click on the trip");


        SearchResultsPage.clickOnTripToGetDetails(currentClassName, when);
        Log4jHandler.Add_Log.info("Completed Cucumber step execution: I click on the trip");
    }

    @Then("^I should see trip details$")
    public void iShouldSeeTripDetails() throws Throwable {
        ExtentTest then = ExtentReport.createNode("Then", "I should see trip details",
                "validate trip details expanded");
        Log4jHandler.Add_Log.info("Cucumber step execution: I should see trip details");


        SearchResultsPage.validateTripDetailsExpanded(currentClassName, then);
        Log4jHandler.Add_Log.info("Completed Cucumber step execution: I should see trip details");
    }

    @And("^I should see a way to book my trip$")
    public void iShouldSeeAWayToBookMyTrip() throws Throwable {
        ExtentTest and = ExtentReport.createNode("And", "I should see a way to book my trip",
                "Booking button is available");
        Log4jHandler.Add_Log.info("Cucumber step execution: I should see a way to book my trip");


        SearchResultsPage.validateBookingButtonAvailable(currentClassName, and);
        Log4jHandler.Add_Log.info("Completed Cucumber step execution: I should see a way to book my trip");
    }

    @And("^I should see a price of the trip$")
    public void iShouldSeeAPriceOfTheTrip() throws Throwable {
        ExtentTest and = ExtentReport.createNode("And", "I should see a price of the trip",
                "Read price tag value");
        Log4jHandler.Add_Log.info("Cucumber step execution: I should see a price of the trip");


        SearchResultsPage.ReadPriceTagValue(currentClassName, and);
        Log4jHandler.Add_Log.info("Completed Cucumber step execution: I should see a price of the trip");
    }
}
