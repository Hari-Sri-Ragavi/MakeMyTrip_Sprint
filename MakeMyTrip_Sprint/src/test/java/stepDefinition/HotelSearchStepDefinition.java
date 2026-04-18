package stepDefinition;

import base.BaseClass;
import base.Pages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HotelSearchStepDefinition {

    private BaseClass b;

    public HotelSearchStepDefinition(BaseClass b) {
        this.b = b;
        System.out.println("Driver in Hotel StepDef: " + b.driver);
    }

    @Given("the user is on the hotel booking page")
    public void the_user_is_on_the_hotel_booking_page() {

        Pages.hp.clickHotelsMenu();
    }

    @When("the user enters valid hotel city")
    public void the_user_enters_valid_hotel_city() {

        System.out.println("Trying city field");
        Pages.hsp.enterCity("Chennai");
    }

    @When("the user clicks hotel search button")
    public void the_user_clicks_hotel_search_button() {

        Pages.hsp.selectDatesAndSearch();
    }
   

    @Then("the system should navigate to hotel results page")
    public void the_system_should_navigate_to_hotel_results_page() {

        String url = b.driver.getCurrentUrl();

        if(url.contains("hotel-listing")) {
            System.out.println("Hotel Search Passed");
        } else {
            System.out.println("Hotel Search Failed");
        }
    }
}