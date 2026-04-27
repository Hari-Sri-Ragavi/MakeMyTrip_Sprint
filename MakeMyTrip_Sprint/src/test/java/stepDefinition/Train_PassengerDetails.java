package stepDefinition;

import org.testng.Assert;

import base.BaseClass;
import base.Pages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Train_PassengerDetails {

    private Pages pages;


    public Train_PassengerDetails(BaseClass b, Pages pages) {
        this.pages = pages;
    }

    @Given("the user opens the train booking portal")
    public void the_user_opens_the_train_booking_portal() {
        pages.tp.clickTrainsMenu();
        pages.tp.clickBookTrainTickets();
    }

    @When("the user chooses a source station")
    public void the_user_chooses_a_source_station() {
        pages.tp.selectFromCity("Chennai");
    }

    @When("the user chooses a destination station")
    public void the_user_chooses_a_destination_station() {
        pages.tp.selectToCity("Salem");
    }

    @When("the user selects the intended journey date")
    public void the_user_selects_the_intended_journey_date() {
        pages.tp.selectDate("May", "12");
    }

    @When("the user selects the preferred coach type")
    public void the_user_selects_the_preferred_coach_type() {
        pages.tp.selectClass("First Class");
    }

    @When("the user starts the train search")
    public void the_user_starts_the_train_search() {
        pages.tp.clickSearch();
    }

    @Then("the matching train services should be displayed")
    public void the_matching_train_services_should_be_displayed() {
        Assert.assertTrue(pages.tfp.getHeaderSearchBar().isDisplayed());
    }

    @When("the user chooses an arrival time preference")
    public void the_user_chooses_an_arrival_time_preference() {
        pages.tfp.selectArrivalTime("12am - 6am");
    }

    @When("the user chooses a departure time preference")
    public void the_user_chooses_a_departure_time_preference() {
        pages.tfp.selectDepartureTime("6pm - 12am");
    }

    @When("the user selects a preferred train category")
    public void the_user_selects_a_preferred_train_category() {
        pages.tfp.selectTrainType("Others - O");
    }


    @When("the user picks the first available train")
    public void the_user_picks_the_first_available_train() {
        pages.tfp.selectFirstTrain();
    }

    @When("the user moves to the traveller details page")
    public void the_user_moves_to_the_traveller_details_page() {
        pages.tap.verifyTravellerPage();
        pages.tap.selectRefundOption();
    }


    @When("the user enters passenger details")
    public void the_user_enters_passenger_details() {
    		pages.tap.addPassenger("Hari", "21", "Female", "Side Upper");
       
    }
    @When("the user enters valid IRCTC username")
    public void the_user_enters_valid_irctc_username() {
    	pages.tap.enterIRCTCUsername("Hari_Sri_Ragavi");
       
    }
    @When("the user provides a valid mobile number and vaild email")
    public void the_user_provides_a_valid_mobile_number_and_vaild_email() {
    	pages.tap.enterContactDetails("abc@gmail.com", "1234555789");
        
    }
    @When("the selects all the other additional options")
    public void the_selects_all_the_other_additional_options() {
    	pages.tap.selectState("Kerala");
    	
       
    }
    @Then("the passenger information should be submitted successfully")
    public void the_passenger_information_should_be_submitted_successfully() {
    	pages.tap.clickBookNow();
Assert.assertTrue(pages.tpp.getScanToPayHeader().isDisplayed());
    }
}