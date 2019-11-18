package rest;

import com.aventstack.extentreports.ExtentTest;
import pages.SearchResultsPage;
import utilities.DriverFactory;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class MainSearchPageRest {

    public static void searchResultsAviasalesComPageOpened(String className, ExtentTest gherkinKeyword) throws InterruptedException {

        String departDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dayAfter = new Date(new Date().getTime() + TimeUnit.DAYS.toMillis(1));
        String returnDate = dateFormat.format(dayAfter);

        String urlToOpenSearchResults = "http://www.aviasales.com/flights?" +
                "marker=" +
                "&origin_name=New+York%2C+NY" +
                "&origin_iata=NYC" +
                "&destination_name=Los+Angeles%2C+CA" +
                "&destination_iata=LAX" +
                "&depart_date=" + departDate +
                "&return_date=" + returnDate +
                "&with_request=true" +
                "&adults=1" +
                "&children=0" +
                "&infants=0" +
                "&trip_class=0" +
                "&locale=en" +
                "&one_way=false" +
                "&ct_guests=1+passenger" +
                "&ct_rooms=1";

        DriverFactory.getDriver().get(urlToOpenSearchResults);
        DriverFactory.waitThreeSeconds();
        SearchResultsPage.searchResultsAviasalesComPageOpened(className, gherkinKeyword);
    }
}
