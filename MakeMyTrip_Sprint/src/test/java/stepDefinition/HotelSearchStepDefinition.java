package stepDefinition;

import base.BaseClass;
import base.Pages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.Excel_Utility;

public class HotelSearchStepDefinition {

	private BaseClass b;
	private Pages pages;

	Excel_Utility eu = new Excel_Utility();
	
	public  HotelSearchStepDefinition(BaseClass b, Pages pages) {
		this.b = b;
		this.pages = pages;
	}
    @Given("the user is on the hotel booking page")
    public void the_user_is_on_the_hotel_booking_page() {

        pages.hsp.clickHotelsMenu();
    }
    
    @When("finds for a hotel using excel sheet")
    public void finds_for_a_hotel_using_excel_sheet() throws Exception {
    	
    	eu.loadExcelFile("./src/test/resources/testdata/MakeMyTripExcelData.xlsx", "Hotel");

		Object[][] travellers = eu.getDataFromTheExcelSheet();

		for (Object[] row : travellers) {
			String city = row[1].toString();
			String checkin = row[2].toString();
			String checkout = row[3].toString();
			
			pages.hsp.enterCitySelectDatesAndSearch(city, checkin, checkout);
		}
    }

    @When("the user searches hotel with city {string} checkin {string} checkout {string}")
    public void the_user_searches_hotel(String city, String checkIn, String checkOut) {

        pages.hsp.enterCitySelectDatesAndSearch(city, checkIn, checkOut);
    }

    @When("the user enters invalid hotel city {string}")
    public void the_user_enters_invalid_hotel_city(String city) throws InterruptedException {
    	pages.hsp.enterCity(city);
    }
    @When("the user clicks invalid hotel search button")
    public void the_user_clicks_invalid_hotel_search_button() throws Exception {
    	pages.hsp.clickSearch();
    }
    @Then("the system should navigate to hotel results page")
    public void the_system_should_navigate_to_hotel_results_page() throws Exception {

        Thread.sleep(4000);

        String url = b.getDriver().getCurrentUrl();

        if(url.contains("hotel-listing")) {
            System.out.println("Hotel Search Passed");
        } else {
            System.out.println("Hotel Search Failed");
        }
    }
    
}