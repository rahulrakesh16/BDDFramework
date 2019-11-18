package stepDefinition;

import com.aventstack.extentreports.ExtentTest;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CommonMainSearchPageMethods;
import reporting.ExtentReport;
import utilities.Log4jHandler;

public class MainSearchCucumberSteps {
    ExtentTest scenario;
    String currentClassName = getClass().getName();

    /*
    regex
    (.*)	Match any string
    (\\d+)	Match any number
    ^	    Any beginning of a string
    $	    Any end of a string
    */

    @When("^I delete return date$")
    public void iDeleteReturnDate() throws InterruptedException {
        ExtentTest when = ExtentReport.createNode("When", "I delete return date",
                "search for field by id and clear the value");
        Log4jHandler.Add_Log.info("Cucumber step execution: When I delete return date");

        CommonMainSearchPageMethods.clearFlightReturnField(currentClassName, when);
        Log4jHandler.Add_Log.info("Completed Cucumber step execution: When I delete return date");
    }

    @And("^I click on the Search button$")
    public void iClickOnTheSearchButton() throws InterruptedException {
        ExtentTest and = ExtentReport.createNode("And", "I click on the Search button",
                "click on the Search bytton by Xpath");
        Log4jHandler.Add_Log.info("Cucumber step execution: And I click on the Search button");

        CommonMainSearchPageMethods.clickOnTheSearchButton(currentClassName, and);
        Log4jHandler.Add_Log.info("Completed Cucumber step execution: And I click on the Search button");
    }

    @Then("^I should see an error message$")
    public void iShouldSeeAnErrorMessage() throws Throwable {
        ExtentTest then = ExtentReport.createNode("Then",
                "I should see an error message", "user keep staying at the same page");
        Log4jHandler.Add_Log.info("Cucumber step execution: Then user keep staying at the same page");

        CommonMainSearchPageMethods.validateFieldIsEmptyValidationWorks(currentClassName, then);
        Log4jHandler.Add_Log.info("Completed Cucumber step execution: Then user keep staying at the same page");
    }

    @When("^I delete depart date$")
    public void iDeleteDepartDate() throws Throwable {
        ExtentTest when = ExtentReport.createNode("When", "I delete depart date",
                "search for field by id and clear the value");
        Log4jHandler.Add_Log.info("Cucumber step execution: When I delete depart date");

        CommonMainSearchPageMethods.clearFlightDepartField(currentClassName, when);
        Log4jHandler.Add_Log.info("Completed Cucumber step execution: When I delete depart date");
    }

    @When("^I select (.*) origin airport$")
    public void iSelectOriginOriginAirport(String originAirport) throws Throwable {
        ExtentTest when = ExtentReport.createNode("When", "I select " + originAirport + " as origin airport",
                "search for field by id, clear the value and select a proper one value");
        Log4jHandler.Add_Log.info("Cucumber step execution: When I select " + originAirport + " as origin airport");

        CommonMainSearchPageMethods.setOriginAirport(originAirport, currentClassName, when);
        Log4jHandler.Add_Log.info("Completed Cucumber step execution: When I select " + originAirport + " as origin airport");
    }

    @And("^I select (.*) destination airport$")
    public void iSelectDestinationDestinationAirport(String destinationAirport) throws Throwable {
        ExtentTest and = ExtentReport.createNode("And", "I select " + destinationAirport + " as destination airport",
                "search for field by id, clear the value and select a proper one value");
        Log4jHandler.Add_Log.info("Cucumber step execution: And I select " + destinationAirport + " as destination airport");

        CommonMainSearchPageMethods.setDestinationAirport(destinationAirport, currentClassName, and);
        Log4jHandler.Add_Log.info("Completed Cucumber step execution: And I select " + destinationAirport + " as destination airport");
    }

    @And("^I select depart date as a current date$")
    public void iSelectDepartDateDepartDate() throws Throwable {
        ExtentTest and = ExtentReport.createNode("And", "I select current date as depart date",
                "search for field by id and select a proper one value");
        Log4jHandler.Add_Log.info("Cucumber step execution: And I select current date as depart date");

        CommonMainSearchPageMethods.setDepartDate(currentClassName, and);
        Log4jHandler.Add_Log.info("Completed Cucumber step execution: And I select current date as depart date");
    }

    @And("^I select return date as a first day of the next month$")
    public void iSelectReturnDateReturnDate() throws Throwable {
        ExtentTest and = ExtentReport.createNode("And", "I select first day of the next month as return date",
                "search for field by id and select a proper one value");
        Log4jHandler.Add_Log.info("Cucumber step execution: And I select first day of the next month as return date");

        CommonMainSearchPageMethods.setReturnDate(currentClassName, and);
        Log4jHandler.Add_Log.info("Completed Cucumber step execution: And I select first day of the next month as return date");
    }

    //@And("^I select (\\d+) adult passenger$")
    @And("^I select (.*) adult passenger$")
    public void iSelectAdultsAdultPassenger(int adultsAmount) throws Throwable {
        ExtentTest and = ExtentReport.createNode("And", "I select " + adultsAmount + " as amount of adults",
                "search for field by id, clear the value and select a proper one value");
        Log4jHandler.Add_Log.info("Cucumber step execution: And I select " + adultsAmount + " as amount of adults");

        CommonMainSearchPageMethods.setAdultsAmount(adultsAmount, currentClassName, and);
        Log4jHandler.Add_Log.info("Completed Cucumber step execution: And I select " + adultsAmount + " as amount of adults");
    }

    @And("^I select (.*) children passenger$")
    public void iSelectChildrenChildrenPassenger(int childrenAmount) throws Throwable {
        ExtentTest and = ExtentReport.createNode("And", "I select " + childrenAmount + " as amount of children",
                "search for field by id, clear the value and select a proper one value");
        Log4jHandler.Add_Log.info("Cucumber step execution: And I select " + childrenAmount + " as amount of children");

        CommonMainSearchPageMethods.setChildrenAmount(childrenAmount, currentClassName, and);
        Log4jHandler.Add_Log.info("Completed Cucumber step execution: And I select " + childrenAmount + " as amount of children");
    }

    @And("^I select (.*) infant passenger$")
    public void iSelectInfantsInfantPassenger(int infantsAmount) throws Throwable {
        ExtentTest and = ExtentReport.createNode("And", "I select " + infantsAmount + " as amount of infants",
                "search for field by id, clear the value and select a proper one value");
        Log4jHandler.Add_Log.info("Cucumber step execution: And I select " + infantsAmount + " as amount of infants");

        CommonMainSearchPageMethods.setInfantsAmount(infantsAmount, currentClassName, and);
        Log4jHandler.Add_Log.info("Completed Cucumber step execution: And I select " + infantsAmount + " as amount of infants");
    }

    @And("^I select (.*) hotels search$")
    public void iSearchForHotelsHotelsSearch(String searchForHotels) throws Throwable {
        ExtentTest and = ExtentReport.createNode("And", "I select " + searchForHotels + " for hotels search",
                "search for field by id then check or uncheck checkbox");
        Log4jHandler.Add_Log.info("Cucumber step execution: And I select " + searchForHotels + " for hotels search");

        CommonMainSearchPageMethods.setHotelsSearch(searchForHotels, currentClassName, and);
        Log4jHandler.Add_Log.info("Completed Cucumber step execution: And I select " + searchForHotels + " for hotels search");
    }
}