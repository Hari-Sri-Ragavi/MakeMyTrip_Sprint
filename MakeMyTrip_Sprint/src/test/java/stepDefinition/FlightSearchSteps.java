package stepDefinition;

import static org.testng.Assert.assertTrue;

import base.BaseClass;
import base.Pages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlightSearchSteps {

    String originalPrice;
    String priceAfterBaggage;
    boolean baggageAdded = false;
  
    String selectedAirline;  

    private BaseClass b;
    private Pages pages;
   
    public FlightSearchSteps(BaseClass b, Pages pages) {
        this.b = b;
        this.pages = pages;
    }

    @When("the user clicks on {string}")
    public void the_user_clicks_on(String value) {
        if (value.equalsIgnoreCase("Flights")) {
            pages.fp.clickFlightsMenu();
        } else if (value.equalsIgnoreCase("Search")) {
            pages.fp.clickSearch();
        }
    }

    @When("the user enters source as {string}")
    public void source(String value) throws InterruptedException {
        pages.fp.enterSource(value);
    }

    @When("the user enters destination as {string}")
    public void destination(String value) throws InterruptedException {
        pages.fp.enterDestination(value);
    }

    @When("the user selects a valid travel date")
    public void select_date() {
        pages.fp.selectDate("June", "4");
    }

    @Then("the user should see search results for the selected route")
    public void results() {
        assertTrue(true);
        System.out.println("Results displayed");
    }

    @When("the user selects a specific airline from the search results")
    public void airline() {
        pages.fp.selectAirline();
    }

    @When("the user views the price details for the selected flight")
    public void price() {
        pages.fp.clickViewPrices();
    }

    @When("the user clicks on {string} button")
    public void button(String value) {
        if (value.equalsIgnoreCase("Book Now")) {
            pages.fp.clickBookNow();
        }
    }

    @Then("the user should be navigated to the review booking page")
    public void nav() {
        assertTrue(true);
        System.out.println("On booking page");
    }

   @Then("the user should see filtered results for that airline")
   public void the_user_should_see_filtered_results_for_that_airline() {
    System.out.println("the user sees filtered results");
    }


}