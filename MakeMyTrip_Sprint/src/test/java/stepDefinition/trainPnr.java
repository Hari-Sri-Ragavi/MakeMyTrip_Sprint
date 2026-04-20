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
	private Pages pages;
	public trainPnr(BaseClass b,Pages pages)
	{
		this.b=b;
		this.pages=pages;
		System.out.println("Driver in StepDef: " + b.getDriver());
	}
	@Given("the user is on the PNR status enquiry page")
	public void the_user_is_on_the_pnr_status_enquiry_page() {
		pages.hp.clickTrainsMenu();
		pages.tpnr.clickCheckPnrStatus();
	    
	}
	@When("the user enters a valid ten-digit {string} PNR number")
	public void the_user_enters_a_valid_ten_digit_pnr_number(String PNR) {
		pages.tpnr.setPnrInput(PNR);
	   
	}
	@When("clicks on the Check Status button")
	public void clicks_on_the_check_status_button() {
		pages.tpnr.clickCheckStatusBtn();
	   
	}
	@Then("the system should display the PNR status successfully")
	public void the_system_should_display_the_pnr_status_successfully() {
		WebDriverWait wait = new WebDriverWait(b.getDriver(), Duration.ofSeconds(10));
		
		Assert.assertTrue(
		    wait.until(ExpectedConditions.visibilityOf(pages.tpnr.getPrintButton())).isEnabled()
		);
	  
	}


}
