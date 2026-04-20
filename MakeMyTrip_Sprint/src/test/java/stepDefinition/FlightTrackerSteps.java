package stepDefinition;

import static org.testng.Assert.assertTrue;

import base.BaseClass;
import base.Pages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.FlightTrackerPage;
import util.ExcelReader;

public class FlightTrackerSteps {
	private BaseClass b;
    private Pages pages;

     public FlightTrackerSteps(BaseClass b, Pages pages) {
        this.b = b;
        this.pages = pages;
    }

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
        pages.hp.closeModalIfPresent();
        assertTrue(true);
        System.out.println("User on home page");
    }

    @When("the user navigates to the Flights module")
    public void user_navigates_to_flights_module() {
        pages.hp.clickFlightsTab();
        System.out.println("Navigated to Flights");
    }

    @And("the user clicks on Flight Tracker option")
    public void user_clicks_flight_tracker_option() {
        pages.ftp.clickFlightStatusTab();
        pages.ftp.clickFlightTrackerOption();
        System.out.println("Flight Tracker opened");
    }

    @And("the user tracks flight {string} on date {string}")
    public void user_tracks_flight(String flightNumber, String date) {
        pages.ftp.trackFlight(flightNumber, date);
        pages.ftp.waitForFlightStatusToLoad();
        System.out.println("Flight tracked: " + flightNumber);
    }

    @Then("the flight status should be {string}")
    public void flight_status_should_be(String expectedStatus) {
        String actualStatus = pages.ftp.getFlightStatus();
        assertEquals(actualStatus, expectedStatus, 
            "Status mismatch! Expected: " + expectedStatus + ", Actual: " + actualStatus);
        System.out.println("Status verified: " + actualStatus);
    }
}