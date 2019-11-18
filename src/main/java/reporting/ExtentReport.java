package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import utilities.Log4jHandler;

public class ExtentReport extends Base {
    public static ExtentReports extent = null;
    public static ExtentTest feature = null;
    public static String testName = null;
    static ExtentTest scenario = null;


    public ExtentReports getExtentReport() {
        return extent;
    }

    public static void setTestName(String newTestName){
        testName = newTestName;
    }

    public static ExtentTest getExtentTest(){
        if (testName != null) {
            if (extent == null) {
                ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("./reports/extentReport.html");
                htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
                htmlReporter.config().setChartVisibilityOnOpen(true);
                htmlReporter.config().setTheme(Theme.STANDARD);
                htmlReporter.config().setDocumentTitle("Cucumber");
                htmlReporter.config().setEncoding("utf-8");
                htmlReporter.config().setReportName("Cucumber Test  Report. aviasales.com test automation");

                extent = new ExtentReports();
                extent.attachReporter(htmlReporter);
            }

            if (feature == null) {
                feature = extent.createTest(testName);
            }
            return feature;
        }
        else{
            System.out.println("No testName specified fr test");
            return null;
        }
    }

    public static void createScenario(String scenarioName){
        try {
            scenario = getExtentTest().createNode(new GherkinKeyword("Scenario"),scenarioName);
        } catch (ClassNotFoundException e) {
            Log4jHandler.getLogger().error("Failed to create a scenario for ExtentReport. Stack Trace: " + e);
            e.printStackTrace();
        }
    }

    public static ExtentTest createNode(String gherkinKeyword, String gherkinStep, String gherkinInfo) {
        try {
            ExtentTest extentTest = getScenario().createNode(new GherkinKeyword(gherkinKeyword),
                    gherkinStep).info(gherkinInfo);
            //returns given,then,when,and,etc
            return extentTest;
        } catch (ClassNotFoundException e) {
            Log4jHandler.getLogger().error("Failed to create a step" + gherkinStep + "for ExtentReport. Stack Trace: " + e);
            return null;
        }
    }

    public static ExtentTest getScenario(){
        return scenario;
    }

    public static void flushExtentReport() {
        if (extent != null) {
            extent.flush();
            feature = null;
            testName = null;
        }
    }
}

/*
        ExtentReport.setTestName("My test");
        ExtentTest scenario = ExtentReport.getExtentTest().createNode(new GherkinKeyword("Scenario"), "Child");
        ExtentTest given = scenario.createNode(new GherkinKeyword("Given"), "Given").info("info");
        ExtentTest and = scenario.createNode(new GherkinKeyword("And"), "And").info("info");
        ExtentTest when = scenario.createNode(new GherkinKeyword("When"), "When").info("info");
        ExtentTest then = scenario.createNode(new GherkinKeyword("Then"), "Then").pass("pass");

        Assert.assertEquals(ExtentReport.getExtentTest().getModel().getLevel(), 0);
        Assert.assertEquals(scenario.getModel().getLevel(), 1);
        Assert.assertEquals(given.getModel().getLevel(), 2);
        Assert.assertEquals(and.getModel().getLevel(), 2);
        Assert.assertEquals(when.getModel().getLevel(), 2);
        Assert.assertEquals(then.getModel().getLevel(), 2);
        Assert.assertEquals(given.getStatus(), Status.PASS);
        Assert.assertEquals(and.getStatus(), Status.PASS);
        Assert.assertEquals(when.getStatus(), Status.PASS);
        Assert.assertEquals(then.getStatus(), Status.PASS);
        Assert.assertEquals(scenario.getStatus(), Status.PASS);
        Assert.assertEquals(ExtentReport.getExtentTest().getStatus(), Status.PASS);

        ExtentReport.flushExtentReport();
        */
