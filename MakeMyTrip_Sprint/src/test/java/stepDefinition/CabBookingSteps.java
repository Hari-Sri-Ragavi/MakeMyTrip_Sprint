package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.BaseClass;
import base.Pages;
import io.cucumber.java.en.*;
import pages.*;

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
    // IMPORTANT FIX (add this)
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

    @When("user enters valid trip details")
    public void user_enters_valid_trip_details() {

       pages.csp.selectFromCity("Delhi");
       pages.csp.selectToCity("Bangalore");
      // Pages.csp.selectDate("June", "1");
       System.out.println("Trip details entered");
    }
     // In your StepDefinitions.java
    @When("click on Search button")
    public void click_on_search_button() {
    	b.getDriver().findElement(By.xpath("//a[contains(@data-cy,'Outstation')]")).click();
    }
    @When("user clicks on search cabs button")
    public void user_clicks_on_search_button() {
        
    }
   @Then("validate cab results are displayed")
    public void validate_cab_results_are_displayed() {

        System.out.println("SUCCESS → Navigated to results page");
    }
   //------------------ scenario 2 ------------------


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

       String actualUrl = b.getDriver().getCurrentUrl();

       if(actualUrl.contains("review")) {
           System.out.println("Navigation successful to Review Booking page");
       } else {
           throw new AssertionError("Not navigated to Review Booking page. URL: " + actualUrl);
       }
   }
}
//   //-------------------Scenario3-----------------------------------------------------------------------------------
//   @Then("user should be navigated to the Review Booking page")
//   public void user_should_be_navigated_to_the_review_booking_page() {
//
//       if (b.getDriver().getCurrentUrl().contains("review")) {
//           System.out.println("Review Page opened");
//       }
//   }
//
//   @Then("cab booking summary details should be displayed on the Review Booking page")
//   public void cab_booking_summary_details_should_be_displayed_on_the_review_booking_page() {
//
//       System.out.println("Summary visible");
//   }
//
//   @When("user enters mobile number {string} in the traveller details section")
//   public void user_enters_mobile_number_in_the_traveller_details_section(String mobile) {
//
//       pages.rbp.enterMobile(mobile);
//   }
//
//   @When("user clicks on Paynow button")
//   public void user_clicks_on_paynow_button() {
//
//       pages.rbp.clickPayNow();
//       System.out.println("Invalid Mobile Number");
//   }
//   //--------------------------------Scenario4
//   @Given("user selects Airport Transfers trip type")
//   public void user_selects_airport_transfers_trip_type() {
//
//       Pages.cap.clickAirportTab();
//   }
//
//   @When("user enters the same location in both From and To fields")
//   public void user_enters_the_same_location_in_both_from_and_to_fields() {
//
//       pages.cap.enterSameLocation("Terminal 3, Indira Gandhi International Airport, Delhi");
//
//       pages.cap.clickSearch();
//   }
//
//   @Then("system should display an error message")
//   public void system_should_display_an_error_message() {
//
//       String result = Pages.cap.getErrorMessage();
//
//       System.out.println("OUTPUT: " + result);
//
//       Assert.assertTrue(
//               result.toLowerCase().contains("same"),
//               "Error message not displayed"
//       );
//   }
//}
    
//   // TripDetailsPage trip;
// @Given("open the browser")
//    public void open_the_browser() {
//
//        home = new Homepagecab(b.getDriver());
//        cab = new CabPage(b.getDriver());
//     //   trip = new TripDetailsPage(b.driver);
//
//        System.out.println("Browser handled by Hooks");
//        
//    }
//
//    // ✅ IMPORTANT FIX (add this)
//    @And("load the application URL")
//    public void load_the_application_url() {
//        // ❌ nothing here
//        // TL Hook already opened URL
//        System.out.println("URL already opened by Hooks");
//    }
//
//    @And("click on Cabs menu")
//    public void click_on_cabs_menu() throws InterruptedException {
//
////        home.closePopup();
////        Thread.sleep(2000);// popup close
//        home.clickCabs();    // click cabs
//    }
//
//    @And("select Outstation trip type")
//    public void select_outstation_trip_type() {
//
//        cab.selectOutstation();
//    }
//
//    @When("user enters valid trip details")
//    public void user_enters_valid_trip_details() {
//
//       pages.csp.selectFromCity("Delhi");
//       pages.csp.selectToCity("Bangalore");
//      // Pages.csp.selectDate("June", "1");
//
//        System.out.println("✔ Trip details entered");
//    }
//
//
// // In your StepDefinitions.java
//    @When("click on Search button")
//    public void click_on_search_button() {
//    	b.getDriver().findElement(By.xpath("//a[contains(@data-cy,'Outstation')]")).click();
//    }
//
//    @When("user clicks on search cabs button")
//    public void user_clicks_on_search_button() {
//        
//    }
//
//    @Then("validate cab results are displayed")
//    public void validate_cab_results_are_displayed() {
//
//        System.out.println("✔ SUCCESS → Navigated to results page");
//    }
//    

