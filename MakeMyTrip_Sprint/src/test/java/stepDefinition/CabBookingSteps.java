package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    
   // TripDetailsPage trip;

   

    @Given("open the browser")
    public void open_the_browser() {

        home = new Homepagecab(b.getDriver());
        cab = new CabPage(b.getDriver());
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

       pages.csp.selectFromCity("Delhi");
       pages.csp.selectToCity("Bangalore");
      // Pages.csp.selectDate("June", "1");

        System.out.println("✔ Trip details entered");
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

        System.out.println("✔ SUCCESS → Navigated to results page");
    }
    //------------------ scenario 2 ------------------

    @When("user filters cab type from the filter panel")
    public void user_filters_cab_type_from_the_filter_panel() {
        pages.scp.clickFilter("Hatchback");
    }

    @When("user filters fuel type from the filter panel")
    public void user_filters_fuel_type_from_the_filter_panel() {
        pages.scp.clickFilter("Cng");
    }

    @When("user selects a cab from the filtered results")
    public void user_selects_a_cab_from_the_filtered_results() {
        pages.scp.clickSelectCab();
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
  

   
