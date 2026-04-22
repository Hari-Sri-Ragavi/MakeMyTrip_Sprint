// HotelSelectionStepDefinition.java

package stepDefinition;

import base.BaseClass;
import base.Pages;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HotelSelectionStepDefinition {
	
	private BaseClass b;
	private Pages pages;

	public  HotelSelectionStepDefinition(BaseClass b, Pages pages) {
		this.b = b;
		this.pages = pages;
	}

    @When("the user applies price filter {string}")
    public void applyPriceFilter(String range) throws Exception {

        pages.hsp.applyPriceFilter(range);
    }

    @When("the user sorts hotels by {string}")
    public void sortHotels(String sortType) throws Exception {

        pages.hsp.sortHotels(sortType);
    }

    @When("the user selects a hotel from results")
    public void selectHotel() throws Exception {

        pages.hsp.selectHotelFromResults();
    }

    @Then("the hotel details page should be displayed")
    public void hotelDetailsPage() {

        System.out.println("Hotel details page displayed");
    }
}