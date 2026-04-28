package stepDefinition;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;

import base.BaseClass;
import base.Pages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.ExcelReader;

public class Train_FilterSteps {

    private BaseClass b;
    private Pages pages;
    int rowno;
    public Train_FilterSteps(BaseClass b, Pages pages) {
        this.b = b;
        this.pages = pages;
    }
    ExcelReader excel=new ExcelReader();
	

    @Given("the user accesses the train reservation section")
    public void the_user_accesses_the_train_reservation_section() {
        pages.tp.clickTrainsMenu();
        pages.tp.clickBookTrainTickets();
    }
    @When("the user provides departure station details from excel")
    public void the_user_provides_departure_station_details_from_excel() throws EncryptedDocumentException, IOException {
    	excel.loadExcelFile("./src/test/resources/testdata/MakeMyTripExcelData.xlsx", "Train");
    	rowno=1;
    	 String fromStation = excel.getDataFromSingleCell(rowno, 0) ; 
         pages.tp.selectFromCity(fromStation);
    	
       
    }
    @When("the user provides arrival station details from excel")
    public void the_user_provides_arrival_station_details_from_excel() {
    	String toStation=excel.getDataFromSingleCell(rowno, 1);
    	pages.tp.selectToCity(toStation);
        
    }
    @When("the user chooses a journey schedule date from excel")
    public void the_user_chooses_a_journey_schedule_date_from_excel() {

    	String day = excel.getDataFromSingleCell(rowno, 3).trim();      
	    String month = excel.getDataFromSingleCell(rowno, 2).trim(); 
	    pages.tp.selectDate(month, day);
    	}
    	
        
    
    @When("the user picks a preferred coach category from excel")
    public void the_user_picks_a_preferred_coach_category_from_excel() {
    	String coach=excel.getDataFromSingleCell(rowno,4);
    	pages.tp.selectClass(coach);
        
    }
    
    @When("the user initiates the train lookup")
    public void the_user_initiates_the_train_lookup() {
        pages.tp.clickSearch();
    }

    @Then("the available train options should be listed")
    public void the_available_train_options_should_be_listed() {
       Assert.assertTrue(pages.tfp.getHeaderSearchBar().isDisplayed());
    }
    @When("the user sets an arrival timing filter from excel")
    public void the_user_sets_an_arrival_timing_filter_from_excel() {
    	 String arrivalTime = excel.getDataFromSingleCell(rowno, 5);   // 12 AM - 6 AM

        arrivalTime = arrivalTime
                        .replace(" AM", "am")
                        .replace(" PM", "pm")
                        .replace(" ", "");

        arrivalTime = arrivalTime.substring(0, arrivalTime.indexOf("-"))
                     + " - " +
                     arrivalTime.substring(arrivalTime.indexOf("-") + 1);

        pages.tfp.selectArrivalTime(arrivalTime);
       
    }
    @When("the user sets a departure timing filter from excel")
    public void the_user_sets_a_departure_timing_filter_from_excel() {
    	String departureTime = excel.getDataFromSingleCell(rowno, 6);   // 12 AM - 6 AM

        departureTime = departureTime
                        .replace(" AM", "am")
                        .replace(" PM", "pm")
                        .replace(" ", "");

        departureTime = departureTime.substring(0, departureTime.indexOf("-"))
                     + " - " +
                    departureTime.substring(departureTime.indexOf("-") + 1);

        pages.tfp.selectDepartureTime(departureTime);
    	
        
    }
    @When("the user applies a train type preference from excel")
    public void the_user_applies_a_train_type_preference_from_excel() {
    	String trainType=excel.getDataFromSingleCell(rowno, 7);
  
    	pages.tfp.selectTrainType(trainType);
        
    }
    
    @When("the user selects the first train from the filtered list")
    public void the_user_selects_the_first_train_from_the_filtered_list() {
        pages.tfp.selectFirstTrain();
    }

    @Then("the train information and booking continuation page should open")
    public void the_train_information_and_booking_continuation_page_should_open() {
       Assert.assertTrue(pages.tap.verifyTravellerPage().isDisplayed());
    }
}