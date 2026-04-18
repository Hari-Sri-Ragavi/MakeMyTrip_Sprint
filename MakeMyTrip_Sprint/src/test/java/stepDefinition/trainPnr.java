package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.BaseClass;
import base.Pages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class trainPnr {
	
	private BaseClass b;
	public trainPnr(BaseClass b)
	{
		this.b=b;
		System.out.println("Driver in StepDef: " + b.driver);
	}
	@Given("the user is on the PNR status enquiry page")
	public void the_user_is_on_the_pnr_status_enquiry_page() {
		Pages.hp.clickTrainsMenu();
		Pages.tpnr.clickCheckPnrStatus();
	    
	}
	@When("the user enters a valid ten-digit {string} PNR number")
	public void the_user_enters_a_valid_ten_digit_pnr_number(String PNR) {
		Pages.tpnr.setPnrInput(PNR);
	   
	}
	@When("clicks on the Check Status button")
	public void clicks_on_the_check_status_button() {
		Pages.tpnr.clickCheckStatusBtn();
	   
	}
	@Then("the system should display the PNR status successfully")
	public void the_system_should_display_the_pnr_status_successfully() {
		WebDriverWait wait = new WebDriverWait(b.driver, Duration.ofSeconds(10));
		
		Assert.assertTrue(
		    wait.until(ExpectedConditions.visibilityOf(Pages.tpnr.getPrintButton())).isEnabled()
		);
	  
	}


}
