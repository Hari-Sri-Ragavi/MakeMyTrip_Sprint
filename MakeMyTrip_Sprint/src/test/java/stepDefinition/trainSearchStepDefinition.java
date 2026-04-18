package stepDefinition;

import base.BaseClass;
import base.Pages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class trainSearchStepDefinition {
	
	private BaseClass b;
	public trainSearchStepDefinition(BaseClass b)
	{
		this.b=b;
		System.out.println("Driver in StepDef: " + b.driver);
	}
	
	
	@Given("the user is on the train booking page")
	public void the_user_is_on_the_train_booking_page() {
		
		Pages.hp.clickTrainsMenu();
		Pages.tp.clickBookTrainTickets();
	    
	}
	@When("the user enters a valid source station")
	public void the_user_enters_a_valid_source_station() {
		Pages.tp.selectFromCity("Chennai");
	    
	}
	@When("the user enters a valid destination station")
	public void the_user_enters_a_valid_destination_station() {
		Pages.tp.selectToCity("Salem");
	    
	}
	@When("the user selects a travel date")
	public void the_user_selects_a_travel_date() {
	   Pages.tp.selectDate("May", "9");
	}
	@When("the user selects a travel class")
	public void the_user_selects_a_travel_class() {
	    Pages.tp.selectClass("First Class");
	}
	

	@When("the user clicks on the search button")
	public void the_user_clicks_on_the_search_button() {
		Pages.tp.clickSearch();
	   
	}
	@Then("the system should navigate to the booking page")
	public void the_system_should_navigate_to_the_booking_page() {
		System.out.println("Verified");
	    
	}

}
