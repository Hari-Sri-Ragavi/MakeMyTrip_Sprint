package stepDefinition;

import org.testng.Assert;

import base.BaseClass;
import base.Pages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Train_LiveStatus {
	
	 private BaseClass b;
	 private Pages pages;

	 public Train_LiveStatus(BaseClass b, Pages pages) {
	        this.b = b;
	        this.pages = pages;
	    }
	


	@When("the user navigates to trains section")
	public void the_user_navigates_to_trains_section() {
	    pages.tp.clickTrainsMenu();
	}

	@When("the user opens live train status page")
	public void the_user_opens_live_train_status_page() {
	    pages.tlscp.clickLiveTrainStatus();
	}

	@When("the user enters train number {string}")
	public void the_user_enters_train_number(String trainNo) {
		pages.tlscp.clickTrainStatusInputField();
	   pages.tlscp.setTrainNumberField(trainNo); 
	}

	@When("the user selects stop {string}")
	public void the_user_selects_stop(String stopName) {
	  pages.tlscp.selectStop(stopName);
	}

	@When("the user selects journey day {string}")
	public void the_user_selects_journey_day(String day) {
	   pages.tlscp.selectDay(day);
	}

	@When("the user clicks check status button")
	public void the_user_clicks_check_status_button() {
	    pages.tlscp.clickCheckStatusBtn();
	}

	@Then("the train tracker section should be displayed")
	public void the_train_tracker_section_should_be_displayed() {
	   Assert.assertTrue(pages.tlscp.verifyTracker());
	}


}
