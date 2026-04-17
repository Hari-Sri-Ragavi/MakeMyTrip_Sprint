package stepDefinition;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import base.Pages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class trainPNRIncorrect {
	@Given("the user is on the PNR  enquiry page")
	public void the_user_is_on_the_pnr_enquiry_page() {
		Pages.tp.clickTrainsMenu();
		Pages.tpnr.clickCheckPnrStatus();
	   
	}
	@When("the user enters an invalid or incorrect PNR number")
	public void the_user_enters_an_invalid_or_incorrect_pnr_number() {
		Pages.tpnr.setPnrInput("475602209A");
	    
	}
	@When("clicks on the Check")
	public void clicks_on_the_check() {
		System.out.println("User cannot click on the check button because it is disabled");	    
	}
	@Then("the system should display an appropriate error message")
	public void the_system_should_display_an_appropriate_error_message() {
		System.out.println(Pages.tpnr.isCheckStatusButtonDisabled());
		System.out.print(Pages.tpnr.isCheckStatusButtonClickable());
		
		Assert.assertEquals(false,Pages.tpnr.isCheckStatusButtonClickable());
	}


}
