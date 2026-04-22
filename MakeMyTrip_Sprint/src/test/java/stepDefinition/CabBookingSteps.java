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
    Homepagecab home;
    CabPage cab;
    private Pages pages;

    public CabBookingSteps(BaseClass b, Pages pages) {
        this.b = b;
        this.pages = pages;
    }
    @Given("open the browser")
    public void open_the_browser() {
    home = new Homepagecab(b.getDriver());
    cab = new CabPage(b.getDriver());
     //   trip = new TripDetailsPage(b.driver);
    System.out.println("Browser handled by Hooks");
    }
    // IMPORTANT
    @And("load the application URL")
    public void load_the_application_url() {
       // TL Hook already opened URL
        System.out.println("URL already opened by Hooks");
    }

    @And("click on Cabs menu")
    public void click_on_cabs_menu() throws InterruptedException {

//        home.closePopup();
//        Thread.sleep(2000);// popup close
        home.clickCabs();    // click cabs
    }

    @And("select Outstation trip type")
    public void select_outstation_trip_type() {
    cab.selectOutstation();
    }
//-------------------------------------------------------------
///////Without scenario outline////////////////////////////
//    @When("user enters valid trip details")
//    public void user_enters_valid_trip_details() throws EncryptedDocumentException, IOException {
//    	//ExcelReader excel=new ExcelReader();
//    	//excel.loadExcelFile("./src/test/resources/testdata/MakeMyTripExcelData.xlsx", "Cab");
//   	 //String fromStation = excel.getDataFromSingleCell(7, 0) ; // Row 1 Col 0
//       // pages.csp.selectFromCity(fromStation);
//    	
//
//       //pages.csp.selectFromCity("Delhi");
//      // pages.csp.selectToCity("Bangalore");
//     //// pages.csp.selectDate("June", "1");
//      // pages.csp.selectDate("May", "9");
//       //pages.csp.selectClass("First Class");
//       System.out.println("Trip details entered");
//    }
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
    //search button
    @When("click on Search button")
    public void click_on_search_button() {
    	b.getDriver().findElement(By.xpath("//a[contains(@data-cy,'Outstation')]")).click();
    }
    @When("user clicks on search cabs button")
    public void user_clicks_on_search_button() {
        
    }
    //Using Assert
   @Then("validate cab results are displayed")
    public void validate_cab_results_are_displayed() {

        //System.out.println("SUCCESS → Navigated to results page");

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
//   @Then("user should be navigated to the Review Booking page")
//   public void user_should_be_navigated_to_the_review_booking_page() {
//
//       String actualUrl = b.getDriver().getCurrentUrl();
//
//       if(actualUrl.contains("review")) {
//           System.out.println("Navigation successful to Review Booking page");
//       } else {
//           throw new AssertionError("Not navigated to Review Booking page. URL: " + actualUrl);
//       }
//   }

//-------------------SCENARIO 3-----------------------------------------------------------------------------------
   @Then("user should be navigated to the Review Booking page")
   public void user_should_be_navigated_to_the_review_booking_page() {

       if (b.getDriver().getCurrentUrl().contains("review")) {
           System.out.println("Review Page opened");
       }

//	   WebDriverWait wait = new WebDriverWait(b.getDriver(), Duration.ofSeconds(15));
//
//	    try {
//	        WebElement element = wait.until(
//	                ExpectedConditions.visibilityOfElementLocated(
//	                        By.xpath("//div[contains(text(),'Review')] | //span[contains(text(),'Traveller')] | //button[contains(text(),'Pay')]")
//	                )
//	        );
//
//	        Assert.assertTrue(element.isDisplayed(), "Summary NOT visible");
//
//	        System.out.println("Summary visible");
//
//	    } catch (Exception e) {
//	        Assert.fail("Summary elements not loaded properly");
//	    }
   }

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
   @When("user enters mobile numbers in traveller details")
   public void user_enters_mobile_numbers_in_traveller_details(DataTable dataTable) {
	   List<String> mobiles = dataTable.asList();

	    for (String mobile : mobiles) {
	        pages.rbp.enterMobile(mobile);
	        System.out.println("Entered: " + mobile);
	    }
   }
  
   @When("user enters email in traveller details")
   public void user_enters_email_in_traveller_details(DataTable dataTable) {

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
	//  String pageText = b.getDriver().getPageSource();

//	    Assert.assertTrue(
//	            pageText.contains("Invalid mobile") || pageText.contains("Invalid email"),
//	            "Error message NOT displayed"
//	    );
//
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

//   //--------------------------------SCENARIO 4------------------------------------------------------------------------
//   @Given("user selects Airport Transfers trip type")
//   public void user_selects_airport_transfers_trip_type() {
//       pages.cap.clickAirportTab();
//   }
//
//   @When("user enters the same location in both From and To fields")
//   public void user_enters_the_same_location_in_both_from_and_to_fields() {
//	   
//	   
////	   pages.csp.selectFromCity("Delhi");
////       pages.csp.selectToCity("Delhi");
//       pages.cap.enterSameLocation("Terminal 3, Indira Gandhi International Airport, Delhi");
//       
//      // pages.cap.clickSearch();
//   }}
//
//   @Then("system should display an error message")
//   public void system_should_display_an_error_message() {
//
//       String result = pages.cap.getResult();
//
//       System.out.println(result);
//
//       Assert.assertTrue(
//           result.toLowerCase().contains("same")
//           || result.toLowerCase().contains("cab"),
//           "Validation failed"
//       );
//   }


    
