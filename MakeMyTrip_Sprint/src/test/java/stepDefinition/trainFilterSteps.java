package stepDefinition;

import base.BaseClass;
import base.Pages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class trainFilterSteps {

    private BaseClass b;
    private Pages pages;

    public trainFilterSteps(BaseClass b, Pages pages) {
        this.b = b;
        this.pages = pages;
    }

    @Given("the user accesses the train reservation section")
    public void the_user_accesses_the_train_reservation_section() {
        pages.hp.clickTrainsMenu();
        pages.tp.clickBookTrainTickets();
    }

    @When("the user provides departure station details")
    public void the_user_provides_departure_station_details() {
        pages.tp.selectFromCity("Chennai");
    }

    @When("the user provides arrival station details")
    public void the_user_provides_arrival_station_details() {
        pages.tp.selectToCity("Salem");
    }

    @When("the user chooses a journey schedule date")
    public void the_user_chooses_a_journey_schedule_date() {
        pages.tp.selectDate("May", "9");
    }

    @When("the user picks a preferred coach category")
    public void the_user_picks_a_preferred_coach_category() {
        pages.tp.selectClass("First Class");
    }

    @When("the user initiates the train lookup")
    public void the_user_initiates_the_train_lookup() {
        pages.tp.clickSearch();
    }

    @Then("the available train options should be listed")
    public void the_available_train_options_should_be_listed() {
        System.out.println("Trains are displayed");
    }

    @When("the user sets an arrival timing filter")
    public void the_user_sets_an_arrival_timing_filter() {
        pages.tfp.selectArrivalTime("12am - 6am");
    }

    @When("the user sets a departure timing filter")
    public void the_user_sets_a_departure_timing_filter() {
        pages.tfp.selectDepartureTime("6am - 12pm");
    }

    @When("the user applies a train type preference")
    public void the_user_applies_a_train_type_preference() {
        pages.tfp.selectTrainType("Others - O");
    }

    @Then("only trains matching the selected filters should remain visible")
    public void only_trains_matching_the_selected_filters_should_remain_visible() {
        System.out.println("Filtered trains are shown");
    }

    @When("the user selects the first train from the filtered list")
    public void the_user_selects_the_first_train_from_the_filtered_list() {
        pages.tfp.selectFirstTrain();
    }

    @Then("the train information and booking continuation page should open")
    public void the_train_information_and_booking_continuation_page_should_open() {
        System.out.println("The train is displayed");
    }
}