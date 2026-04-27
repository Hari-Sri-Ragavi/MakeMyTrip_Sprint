package stepDefinition;

import org.testng.Assert;

import base.BaseClass;
import base.Pages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Train_SearchStepDefinition {

    private BaseClass b;
    private Pages pages;

    public Train_SearchStepDefinition(BaseClass b,Pages pages) {
        this.b = b;
        this.pages = pages;
        System.out.println("Driver in StepDef: " + b.getDriver());
    }

    @Given("the user is on the train booking page")
    public void the_user_is_on_the_train_booking_page() {

        pages.tp.clickTrainsMenu();
        pages.tp.clickBookTrainTickets();
    }

    @When("the user enters source station {string}")
    public void the_user_enters_source_station(String source) throws InterruptedException {
        pages.tp.selectFromCity(source);
        Thread.sleep(4000);
    }

    @When("the user enters destination station {string}")
    public void the_user_enters_destination_station(String destination) {
        pages.tp.selectToCity(destination);
    }

    @When("the user selects a travel date")
    public void the_user_selects_a_travel_date() {
        pages.tp.selectDate("May", "9");
    }

    @When("the user selects a travel class")
    public void the_user_selects_a_travel_class() {
        pages.tp.selectClass("First Class");
    }

    @When("the user clicks on the search button")
    public void the_user_clicks_on_the_search_button() {
        pages.tp.clickSearch();
    }

    @Then("the system should navigate to the booking page")
    public void the_system_should_navigate_to_the_booking_page() {
        Assert.assertTrue(pages.tfp.getHeaderSearchBar().isDisplayed());
    }
}