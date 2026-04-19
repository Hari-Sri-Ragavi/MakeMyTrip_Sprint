package stepDefinition;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;

import base.Pages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.FlightTrackerPage;
import util.ExcelReader;

public class FlightTrackerSteps {

    private FlightTrackerPage flightTrackerPage;
    private ExcelReader excelReader;

    // ✅ SINGLE PATH (VERY IMPORTANT)
    private static final String EXCEL_PATH =
            System.getProperty("user.dir") + "/src/test/resources/testdata/flight_testdata.xlsx";

    public FlightTrackerSteps() {
        this.excelReader = new ExcelReader();
    }

    @Given("the user is logged in and on the MakeMyTrip home page")
    public void the_user_is_logged_in_and_on_the_make_my_trip_home_page() {
        Pages.hp.closeModalIfPresent();
        assertTrue(true);
        System.out.println("User on home page");
    }

    @Given("the user is on the MakeMyTrip homepage")
    public void theUserIsOnMakeMyTripHomepage() {
        Assert.assertNotNull(Pages.hp);
    }

    @When("the user jumps to the Flights module")
    public void the_user_jumps_to_the_flights_module() {
        Pages.hp.clickFlightsTab();
    }

    @When("the user clicks on {string} option")
    public void theUserClicksOnOption(String option) {
        flightTrackerPage = Pages.ftp;

        if (option.equalsIgnoreCase("Flight Status")) {
            flightTrackerPage.clickFlightTrackerOption();
            flightTrackerPage.waitForFlightTrackerPopup();
        }
    }

    @When("the user tracks all flights using flight number and date from Excel sheet {string}")
    public void theUserTracksAllFlightsFromExcel(String FlightTracker) throws Exception {

        // ✅ Load from correct path
        excelReader.loadExcelFile(EXCEL_PATH, FlightTracker);

        int rowCount = excelReader.getLastRowNum();

        for (int i = 1; i <= rowCount; i++) {

            String flightNumber = excelReader.getDataFromSingleCell(i, 0);
            String expectedStatus = excelReader.getDataFromSingleCell(i, 1);

            if (flightNumber == null || flightNumber.trim().isEmpty()) continue;

            System.out.println("▶ Tracking Flight: " + flightNumber);

            flightTrackerPage.enterFlightNumber(flightNumber);
            flightTrackerPage.clickTrackButton();

            String actualStatus = flightTrackerPage.getFlightStatus();

            System.out.println("Expected: " + expectedStatus + " | Actual: " + actualStatus);

            Assert.assertEquals(actualStatus, expectedStatus);

            // ✅ WRITE TO SAME FILE (FIXED)
            excelReader.writeDataInTheCell(EXCEL_PATH, i, 2, actualStatus);
        }
    }
}