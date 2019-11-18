package stepDefinition;

import com.aventstack.extentreports.ExtentTest;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.MainPage;
import pages.SearchResultsPage;
import reporting.ExtentReport;
import rest.MainSearchPageRest;
import utilities.DriverFactory;
import utilities.Log4jHandler;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class NavigationCucumberSteps {
    String currentClassName = getClass().getName();

    @Given("^main aviasales page opened$")
    public void mainAviasalesComPageOpened() throws InterruptedException {
        ExtentReport.createScenario("user could not do a search with empty arrival date");
        ExtentTest given = ExtentReport.createNode("Given", "main aviasales page opened",
                "try to open main page and validates page opened by title name");
        Log4jHandler.Add_Log.info("Cucumber step execution: Given main aviasales page opened");

        MainPage.validateMainPageOpened(currentClassName, given);
        Log4jHandler.Add_Log.info("Completed Cucumber step execution: Given main aviasales page opened");
    }

    @Then("^I should see aviasales search results$")
    public void iShouldSeeAviasalesSearchResults() throws Throwable {
        ExtentTest then = ExtentReport.createNode("Then", "I should see aviasales search results",
                "Compare URLs");
        Log4jHandler.Add_Log.info("Cucumber step execution: Then I should see aviasales search results");


        SearchResultsPage.searchResultsAviasalesComPageOpened(currentClassName, then);
        Log4jHandler.Add_Log.info("Completed Cucumber step execution: Then I should see aviasales search results");
    }


    @Given("^aviasales search results page opened via REST API call$")
    public void aviasalesSearchResultsPageOpenedViaRESTAPICall() throws Throwable {
        ExtentReport.createScenario("results page - search for a round trip ticket with all data filled and no hotels required");
        ExtentTest given = ExtentReport.createNode("Given", "Aviasales searh reults pagee opened via REST API call",
                "call REST API to open the page");
        Log4jHandler.Add_Log.info("Cucumber step execution: Given Aviasales searh reults pagee opened via REST API");

        MainSearchPageRest.searchResultsAviasalesComPageOpened(currentClassName, given);
        Log4jHandler.Add_Log.info("Completed Cucumber step execution: Given Aviasales searh reults pagee opened via REST API");

    }

    @Before
    public void startDrivers() throws IOException {
        Log4jHandler.getLogger().info("Class execution begins: " + this.getClass().getName());
        ExtentReport.setTestName("Main Page");
    }

    @After
    public void tearDown() throws IOException {
        Log4jHandler.getLogger().info("Class execution tear down: " + this.getClass().getName());
        DriverFactory.tearDown();
        ExtentReport.flushExtentReport();
    }

    @Given("^test$")
    public void test() throws Throwable {
        URL url = new URL("http://example.com");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
    }

    @When("^test(\\d+)$")
    public void test(int arg0) throws Throwable {
        System.out.println("Oooops");
    }
}
