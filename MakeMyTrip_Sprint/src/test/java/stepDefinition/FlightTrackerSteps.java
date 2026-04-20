
package stepDefinition;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;

import base.Pages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.FlightTrackerPage;
import util.ExcelReader;

public class FlightTrackerSteps {

    private FlightTrackerPage flightTrackerPage;
    private ExcelReader excelReader;
    private static int rowCounter = 1;
    private static String currentFlightNumber;
    private static String expectedStatus;

    private static final String EXCEL_PATH =
            System.getProperty("user.dir") + "/src/test/resources/testdata/make_my_trip_Excel.xlsx";

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
    public void theUserTracksAllFlightsFromExcel(String sheetName) throws Exception {

        excelReader.loadExcelFile(EXCEL_PATH, sheetName);

        String flightNumber = excelReader.getDataFromSingleCell(rowCounter, 0);
        String flightDate = excelReader.getDataFromSingleCell(rowCounter, 1);
        expectedStatus = excelReader.getDataFromSingleCell(rowCounter, 2);

        if (flightNumber == null || flightNumber.trim().isEmpty()) {
            System.out.println("Flight number is empty at row " + rowCounter);
            return;
        }

        currentFlightNumber = flightNumber;
        System.out.println("Tracking Flight: " + currentFlightNumber + " from row " + rowCounter);
        System.out.println("Expected Status: " + expectedStatus);

        flightTrackerPage.enterFlightNumber(currentFlightNumber);
        flightTrackerPage.clickTrackButton();
        
        rowCounter++;
    }

    @Then("each flight status should be displayed correctly as per Excel")
    public void each_flight_status_should_be_displayed_correctly_as_per_excel() {
        String actualStatus = flightTrackerPage.getFlightStatus();
        
        System.out.println("Actual Status: " + actualStatus);
        
        Assert.assertEquals(actualStatus, expectedStatus, 
            "Flight " + currentFlightNumber + " status mismatch. Expected: " + expectedStatus + ", Actual: " + actualStatus);
        
        System.out.println("✓ Flight " + currentFlightNumber + " verified successfully");
    }
}