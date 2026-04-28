package stepDefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;

import base.BaseClass;
import base.Pages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.ExcelReader;

public class Train_AddMultiplePassengersStepDefiniton {
	
	 private BaseClass b;
	 private Pages pages;

	public Train_AddMultiplePassengersStepDefiniton(BaseClass b, Pages pages) {
	        this.b = b;
	        this.pages = pages;
	    }
	ExcelReader excel=new ExcelReader();
	     
	@Given("the user launches the train booking portal")
	public void the_user_launches_the_train_booking_portal() {
		pages.tp.clickTrainsMenu();
		pages.tp.clickBookTrainTickets();
		
	   
	}

	@When("the user selects the boarding station")
	public void the_user_selects_the_boarding_station() throws EncryptedDocumentException, IOException {
		excel.loadExcelFile("./src/test/resources/testdata/MakeMyTripExcelData.xlsx", "Train");
   	    String fromStation = excel.getDataFromSingleCell(1, 0) ; // Row 1 Col 0
        pages.tp.selectFromCity(fromStation);
	}

	@When("the user selects the dropping station")
	public void the_user_selects_the_dropping_station() {
	 	String toStation=excel.getDataFromSingleCell(1, 1);
	 	pages.tp.selectToCity(toStation);   
	}

	@When("the user chooses the travel date")
	public void the_user_chooses_the_travel_date() {
		String day = excel.getDataFromSingleCell(1, 3).trim();      
	    String month = excel.getDataFromSingleCell(1, 2).trim(); 
	    pages.tp.selectDate(month, day);
	 }

	@When("the user selects the desired coach category")
	public void the_user_selects_the_desired_coach_category() {
		String coach=excel.getDataFromSingleCell(1, 4);
    		pages.tp.selectClass(coach);
	   
	}

	@When("the user initiates the train search")
	public void the_user_initiates_the_train_search() {
		pages.tp.clickSearch();
	   
	}

	@Then("the available train options should be shown")
	public void the_available_train_options_should_be_shown() {
	   Assert.assertTrue(pages.tfp.getHeaderSearchBar().isDisplayed());
	}

	@When("the user applies an arrival slot filter")
	public void the_user_applies_an_arrival_slot_filter() {
		String arrivalTime = excel.getDataFromSingleCell(1, 5);   // 12 AM - 6 AM
		arrivalTime = arrivalTime
                        .replace(" AM", "am")
                        .replace(" PM", "pm")
                        .replace(" ", "");

        arrivalTime = arrivalTime.substring(0, arrivalTime.indexOf("-"))
                     + " - " +
                     arrivalTime.substring(arrivalTime.indexOf("-") + 1);

        pages.tfp.selectArrivalTime(arrivalTime);
	}

	@When("the user applies a departure slot filter")
	public void the_user_applies_a_departure_slot_filter() {
		String departureTime = excel.getDataFromSingleCell(1, 6);   // 12 AM - 6 AM
		departureTime = departureTime
                        .replace(" AM", "am")
                        .replace(" PM", "pm")
                        .replace(" ", "");

        departureTime = departureTime.substring(0, departureTime.indexOf("-"))
                     + " - " +
                    departureTime.substring(departureTime.indexOf("-") + 1);

        pages.tfp.selectDepartureTime(departureTime);
	}

	@When("the user chooses the required train type")
	public void the_user_chooses_the_required_train_type() {
		String trainType=excel.getDataFromSingleCell(1, 7);
	}

	@When("the user selects the first listed train")
	public void the_user_selects_the_first_listed_train() {
	   pages.tfp.selectFirstTrain();
	}

	@When("the user navigates to the passenger details screen")
	public void the_user_navigates_to_the_passenger_details_screen() {
	  
		pages.tap.selectRefundOption();
	}

	@When("the user enters multiple passenger details using DataTable")
	public void the_user_enters_multiple_passenger_details_using_data_table(io.cucumber.datatable.DataTable dataTable) {
		
		    List<Map<String, String>> passengers = dataTable.asMaps(String.class, String.class);

		    for (int i = 0; i < passengers.size(); i++) {

		        Map<String, String> passenger = passengers.get(i);

		        String name = passenger.get("Name");
		        String age = passenger.get("Age");
		        String gender = passenger.get("Gender");
		        String berthPreference = passenger.get("Berth Preference");
		        pages.tap.addPassenger(name, age, gender, berthPreference);
		    }
		}
	

	@When("the user enters a valid IRCTC username")
	public void the_user_enters_a_valid_irctc_username() {
		pages.tap.enterIRCTCUsername("Hari_Sri_Ragavi");
	    
	}

	@When("the user provides a valid mobile number and valid email")
	public void the_user_provides_a_valid_mobile_number_and_valid_email() {
		pages.tap.enterContactDetails("sprintmakemytrip@gmail.com", "1234567908");
	   
	}

	@When("the user selects all additional preferences")
	public void the_user_selects_all_additional_preferences() {
		pages.tap.selectState("Tamil Nadu");
	    
	}

	@Then("the passenger details for all travellers should be submitted successfully")
	public void the_passenger_details_for_all_travellers_should_be_submitted_successfully() {
		pages.tap.clickBookNow();
	Assert.assertTrue(pages.tpp.verifyPaymentPage());
	   
	}


}