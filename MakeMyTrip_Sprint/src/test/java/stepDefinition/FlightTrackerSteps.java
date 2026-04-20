package stepDefinition;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;

import base.BaseClass;
import base.Pages;
import io.cucumber.java.en.*;
import pages.FlightTrackerPage;
import util.ExcelReader;

public class FlightTrackerSteps {

    private FlightTrackerPage flightTrackerPage;
    private ExcelReader excelReader;

    private String currentFlightNumber;
    private String expectedStatus;

    private BaseClass b;
    private Pages pages;

    public FlightTrackerSteps(BaseClass b, Pages pages) {
        this.b = b;
        this.pages = pages;
        this.excelReader = new ExcelReader();
    }

    private static final String EXCEL_PATH =
            System.getProperty("user.dir") + "/src/test/resources/testdata/MakeMyTripExcelData.xlsx";

    @Given("the user is on the MakeMyTrip homepage")
    public void the_user_is_on_the_make_my_trip_homepage() {
        pages.hp.closeModalIfPresent();
        assertTrue(true);
        System.out.println("User on homepage");
    }

    @When("the user jumps to the Flights module")
    public void the_user_jumps_to_the_flights_module() {
        pages.hp.clickFlightsTab();
    }

    @When("the user clicks on {string} option")
    public void theUserClicksOnOption(String option) {
        flightTrackerPage = pages.ftp;

        if (option.equalsIgnoreCase("Flight Status")) {
            flightTrackerPage.clickFlightTrackerOption();
            flightTrackerPage.waitForFlightTrackerPopup();
        }
    }

    @When("the user tracks flight using row {int} from Excel sheet {string}")
    public void the_user_tracks_flight_using_row_from_excel(int rowNumber, String sheetName) throws Exception {

        excelReader.loadExcelFile(EXCEL_PATH, sheetName);

        currentFlightNumber = excelReader.getDataFromSingleCell(rowNumber, 0);
        expectedStatus = excelReader.getDataFromSingleCell(rowNumber, 1);

        System.out.println("Row: " + rowNumber);
        System.out.println("Flight: " + currentFlightNumber);
        System.out.println("Expected: " + expectedStatus);

        flightTrackerPage.enterFlightNumber(currentFlightNumber);
        flightTrackerPage.clickTrackButton();
    }


    @Then("each flight status should be displayed correctly as per Excel")
    public void each_flight_status_should_be_displayed_correctly_as_per_excel() {

        String actualStatus = flightTrackerPage.getDerivedFlightStatus();

        System.out.println("Actual: " + actualStatus);

        Assert.assertEquals(actualStatus, expectedStatus,
                "Flight " + currentFlightNumber + " status mismatch.");

        System.out.println("Verified: " + currentFlightNumber);
    }
}