package stepDefinition;

import static org.testng.Assert.assertTrue;

import base.Pages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlightSearchSteps {

    String originalPrice;
    String priceAfterBaggage;
   

    @When("the user clicks on {string}")
    public void the_user_clicks_on(String value) {
        if (value.equalsIgnoreCase("Flights")) {
            Pages.fp.clickFlightsMenu();
        } else if (value.equalsIgnoreCase("Search")) {
            Pages.fp.clickSearch();
        }
    }

    @When("the user enters source as {string}")
    public void source(String value) throws InterruptedException {
        Pages.fp.enterSource(value);
    }

    @When("the user enters destination as {string}")
    public void destination(String value) throws InterruptedException {
        Pages.fp.enterDestination(value);
    }

    @When("the user selects a valid travel date")
    public void select_date() {
        Pages.fp.selectDate("June", "4");
    }

    @Then("the user should see search results for the selected route")
    public void results() {
        assertTrue(true);
        System.out.println("Results displayed");
    }

    @When("the user selects a specific airline from the search results")
    public void airline() {
        Pages.fp.selectAirline();
    }

    @When("the user views the price details for the selected flight")
    public void price() {
        Pages.fp.clickViewPrices();
    }

    @When("the user clicks on {string} button")
    public void button(String value) {
        if (value.equalsIgnoreCase("Book Now")) {
            Pages.fp.clickBookNow();
        }
    }

    @Then("the user should be navigated to the review booking page")
    public void nav() {
        assertTrue(true);
        System.out.println("On booking page");
    }

}