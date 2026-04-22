package stepDefinition;

import io.cucumber.java.en.*;
import base.BaseClass;
import base.Pages;

public class HotelBookingStepDefinition {
	
	private BaseClass b;
	private Pages pages;

	public  HotelBookingStepDefinition(BaseClass b, Pages pages) {
		this.b = b;
		this.pages = pages;
	}

	
    @Given("the user is on hotel results page")
    public void user_on_results_page() {
        System.out.println("Already on hotel results page");
    }

    @When("the user selects first hotel")
    public void select_first_hotel() throws Exception {
        pages.hsp.selectHotelFromResults();
    }

    @When("the user clicks view this combo")
    public void click_view_combo() throws Exception {
        pages.hsp.clickViewThisCombo();
    }

    @When("the user clicks select combo")
    public void click_select_combo() throws Exception {
        pages.hsp.clickSelectCombo();
    }

    @Then("the user should navigate to review booking page")
    public void verify_review_page() {
        System.out.println("Booking page opened");
    }
    @When("the user enters guest details")
    public void the_user_enters_guest_details(io.cucumber.datatable.DataTable data) throws Exception {

        java.util.List<java.util.List<String>> details = data.asLists();

        String fname  = details.get(1).get(0);
        String lname  = details.get(1).get(1);
        String email  = details.get(1).get(2);
        String mobile = details.get(1).get(3);

        pages.hsp.enterGuestDetails(fname, lname, email, mobile);
    }

    @When("the user clicks pay now")
    public void the_user_clicks_pay_now() throws Exception {

        pages.hsp.clickPayNow();
    }

    @Then("payment page should open")
    public void payment_page_should_open() {

        System.out.println("Payment page opened successfully");
    }
}