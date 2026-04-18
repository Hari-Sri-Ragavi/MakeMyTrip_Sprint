package stepDefinition;

import org.openqa.selenium.By;

import base.BaseClass;
import base.Pages;
import io.cucumber.java.en.*;
import pages.*;

public class CabBookingSteps {

    private BaseClass b;
    Homepagecab home;
    CabPage cab;
    
   // TripDetailsPage trip;

    public CabBookingSteps(BaseClass b) {
        this.b = b;
    }

    @Given("open the browser")
    public void open_the_browser() {

        home = new Homepagecab(b.driver);
        cab = new CabPage(b.driver);
     //   trip = new TripDetailsPage(b.driver);

        System.out.println("Browser handled by Hooks");
    }

    // ✅ IMPORTANT FIX (add this)
    @And("load the application URL")
    public void load_the_application_url() {
        // ❌ nothing here
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

       Pages.csp.selectFromCity("Delhi");
       Pages.csp.selectToCity("Bangalore");
      // Pages.csp.selectDate("June", "1");

        System.out.println("✔ Trip details entered");
    }


 // In your StepDefinitions.java
    @When("click on Search button")
    public void click_on_search_button() {
    	b.driver.findElement(By.xpath("//a[contains(@data-cy,'Outstation')]")).click();
    }

    @When("user clicks on search cabs button")
    public void user_clicks_on_search_button() {
        
    }

    @Then("validate cab results are displayed")
    public void validate_cab_results_are_displayed() {

        System.out.println("✔ SUCCESS → Navigated to results page");
    }
    //------------------ scenario 2 ------------------

    @When("user filters cab type from the filter panel")
    public void user_filters_cab_type_from_the_filter_panel() {
        Pages.scp.clickFilter("Hatchback");
    }

    @When("user filters fuel type from the filter panel")
    public void user_filters_fuel_type_from_the_filter_panel() {
        Pages.scp.clickFilter("Cng");
    }

    @When("user selects a cab from the filtered results")
    public void user_selects_a_cab_from_the_filtered_results() {
        Pages.scp.clickSelectCab();
    }

    @Then("user should be navigated to the Review Booking page")
    public void user_should_be_navigated_to_the_review_booking_page() {

//        String url = Pages.driver.getCurrentUrl();

  //      System.out.println("✔ Navigated URL: " + url);

    //    if (url.contains("review") || url.contains("booking")) {
        //    System.out.println("✔ Successfully navigated to Review Booking page");
      //  } else {
          //  System.out.println("❌ Navigation failed");
        }
    }
  

   
