package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

    /*
     * This class returns a WebDriver object using 3 overloaded .get() methods:
     * 1. get() - default
     * 2. get(String browserType)
     * 3. get(String browserType, String webURL)
     */
    public class DriverFactory {
        private static String rootFolder = System.getProperty("user.dir") +
                "//src//test//drivers//";
        public static WebDriver driver = null;

        // Write a function that returns a default WebDriver (user does not specify)
        /*public static WebDriver get() {

            WebDriver driver;
            System.out.println("Opening chrome browser");
            System.setProperty("webdriver.chrome.driver", rootFolder + "chromedriver.exe");
                    driver = new ChromeDriver();
            return driver;
        }
        */

        // Write a function that returns a WebDriver when user sends desired browser
        public static WebDriver getDriver(){
            if (driver == null) {
                String browserType = PropertiesHandler.getProperty("browser");
                if (browserType.equalsIgnoreCase("Chrome")) {
                    Log4jHandler.getLogger().info("Opening chrome browser");
                    System.setProperty("webdriver.chrome.driver", rootFolder + "chromedriver.exe");
                    driver = new ChromeDriver();
                } else if (browserType.equalsIgnoreCase("Firefox")) {
                    Log4jHandler.getLogger().info("Opening Firefox browser");
                    System.setProperty("webdriver.gecko.driver", rootFolder + "geckodriver.exe");
                    driver = new FirefoxDriver();
                } else if (browserType.equalsIgnoreCase("IE")) {
                    Log4jHandler.getLogger().info("Opening IE browser");
                    System.setProperty("webdriver.ie.driver", rootFolder + "IEDriverServer.exe");
                    driver = new InternetExplorerDriver();
                } else {
                    Log4jHandler.getLogger().info("Could not understand input. Will open Chrome as default");
                    System.setProperty("webdriver.chrome.driver", rootFolder + "chromedriver.exe");
                    driver = new ChromeDriver();
                }
                setConfigs();
            }
            return driver;
        }

        // This function returns a WebDriver with maximized window and 3 second wait
        public static void setConfigs(){
            Log4jHandler.getLogger().info("Setup basic WebDriver configurations");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        }

        public static void tearDown() throws IOException {
            if (driver != null) {
                driver.close();
                driver = null;
                Log4jHandler.getLogger().info("WebDriver stopped");
            }
        }

        public static void waitThreeSeconds() throws InterruptedException {
            getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            Thread.sleep(2000);
        }
    }
