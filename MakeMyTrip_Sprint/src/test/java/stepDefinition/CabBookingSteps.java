package stepDefinition;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.BaseClass;
import base.Pages;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.cucumber.plugin.event.Result;
import pages.*;
import util.ExcelReader;

public class CabBookingSteps {

    private BaseClass b;
    private Pages pages;

    public CabBookingSteps(BaseClass b, Pages pages) {
        this.b = b;
        this.pages = pages;
    }
    @Given("open the browser")
    public void open_the_browser() {
     System.out.println("Browser handled by Hooks");
    }

    @And("load the application URL")
    public void load_the_application_url() {
   
        System.out.println("URL already opened by Hooks");
    }

    @And("click on Cabs menu")
    public void click_on_cabs_menu() throws InterruptedException {
        pages.hpc.clickCabs(); 
    }

    @And("select Outstation trip type")
    public void select_outstation_trip_type() {
    	 pages.cp.selectOutstation(); 
    }

//--------------------------------------------------------------
// using Scenario outline
    @Given("the user enters source for cab {string}")
    public void the_user_enters_source_for_cab(String string) {
    	  pages.csp.selectFromCity("Delhi");
        
    }
    @Given("the user enters destination for cab  {string}")
    public void the_user_enters_destination_for_cab(String string) {
        
        pages.csp.selectToCity("Bangalore");
        System.out.println("Trip details entered");
        pages.csp.selectTodayDate();
    }
    @And("user select the date")
    public void user_select_the_date () {
    	  pages.csp.selectTodayDate();
    
    }
   
   //search button
    @When("click on Search button")
    public void click_on_search_button() {
    	 pages.csp.clickSearchButton();
         System.out.println("Search button clicked");
        
       
    }
    @And("clicks OK if no cabs popup appears to proceed with available cabs")
    public void clicks_OK_if_no_cabs_popup_appears_to_proceed_with_available_cabs() {
    	 pages.csp. handlePopup();
    	
    }
    //Using Assert
   @Then("validate cab results are displayed")
    public void validate_cab_results_are_displayed() {


        WebDriverWait wait = new WebDriverWait(b.getDriver(), Duration.ofSeconds(25));

        try {
            boolean urlCheck = wait.until(
                ExpectedConditions.urlContains("cabs")
            );

            WebElement result = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(@class,'listing')]")
                )
            );
        
	        //TRUE ->PASS -> System.out.println() runs ->message NOT shown
            Assert.assertTrue(urlCheck && result.isDisplayed(),
                    "Cab results NOT displayed");

            System.out.println("SUCCESS → Navigated to results page");

        } catch (Exception e) {
            Assert.fail("Cab results page not loaded properly");
        }
        
    }
   //------------------ SCENARIO 2 ----------------------------------------------------------------


   @When("user filters cab type from the filter panel")
   public void user_filters_cab_type_from_the_filter_panel() {
       pages.scp.clickFirstCabType();
   }

   @When("user filters fuel type from the filter panel")
   public void user_filters_fuel_type_from_the_filter_panel() {
       pages.scp.clickFirstFuelType();
   }

   @When("user selects a cab from the filtered results")
   public void user_selects_a_cab_from_the_filtered_results() {
       pages.scp.clickSelectCab();
   }

   @Then("user should be navigated to the Review Booking page")
   public void user_should_be_navigated_to_the_review_booking_page() {
     //Without using Assert
//       if (b.getDriver().getCurrentUrl().contains("review")) {
//           System.out.println("Review Page opened");
//       }

	   WebDriverWait wait = new WebDriverWait(b.getDriver(), Duration.ofSeconds(15));

	    try {
	        WebElement element = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("//div[contains(text(),'Review')] | //span[contains(text(),'Traveller')] | //button[contains(text(),'Pay')]")
	                )
	        );
	        
	        //TRUE ->PASS -> System.out.println() runs ->message NOT shown

	        Assert.assertTrue(element.isDisplayed(), "Summary NOT visible");

	        System.out.println("Summary visible");

	    } catch (Exception e) {
	        Assert.fail("Summary elements not loaded properly");
	    }
   }
 //-------------------SCENARIO 3-----------------------------------------------------------------------------------

   @Then("cab booking summary details should be displayed on the Review Booking page")
   public void cab_booking_summary_details_should_be_displayed_on_the_review_booking_page() {

	    WebDriverWait wait = new WebDriverWait(b.getDriver(), Duration.ofSeconds(15));

	    boolean isReview = wait.until(
	            ExpectedConditions.urlContains("review")
	    );

	    Assert.assertTrue(isReview, "Not navigated to Review page");

	    System.out.println("Review Page opened");
       
   }
//--------------without using Data Table-----------------------------
//   @When("user enters mobile number {string} in the traveller details section")
//   public void user_enters_mobile_number_in_the_traveller_details_section(String mobile) {
//
//       pages.rbp.enterMobile(mobile);
//       
//   }
//--------------------using Data Table-------------------   
   @When("user enters invalid mobile numbers in traveller details")
   public void user_enters_invalid_mobile_numbers_in_traveller_details(DataTable dataTable) {
	   List<String> mobiles = dataTable.asList();

	    for (String mobile : mobiles) {
	        pages.rbp.enterMobile(mobile);
	        System.out.println("Entered: " + mobile);
	    }
   }
  
   @When("user enters invalid email in traveller details")
   public void user_enters_invalid_email_in_traveller_details(DataTable dataTable) {

	    List<String> emails = dataTable.asList();

	    for (String email : emails) {
	        pages.rbp.enterEmail(email);   
	        System.out.println("Entered Email: " + email);
	    }
	        
   }
   @When("user clicks on Paynow button")
   public void user_clicks_on_paynow_button() {

       pages.rbp.clickPayNow();
       System.out.println("Invalid Mobile Number");
   }

@Then("verify Shows Error Message")
public void verify_shows_error_message() {
	  String pageText = b.getDriver().getPageSource();
	  // failure 
    Assert.assertTrue(
	            pageText.contains("correct mobile") || pageText.contains("correct email"),
	            "Error message NOT displayed"
    );

	    System.out.println("Error message displayed");
	    //without assert
//	   WebDriverWait wait = new WebDriverWait(b.getDriver(), Duration.ofSeconds(15));
//
//	    try {
//	        wait.until(ExpectedConditions.urlContains("review"));
//	        System.out.println(" Review Page opened");
//	    } catch (Exception e) {
//	        System.out.println("Review Page NOT opened");
//	    }
}

}




    
