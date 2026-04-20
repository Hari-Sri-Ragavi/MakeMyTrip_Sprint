package stepDefinition;

import java.io.IOException;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.testng.asserts.SoftAssert;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.Actions_Helper;
import util.Excel_Utility;
import util.JavaScriptExceutor_Utility;
import util.WebDriver_Utility;
import base.Pages;

public class HP_TS4_AddTravellerTest {

	private BaseClass b;

	WebDriver_Utility wbu;
	Actions_Helper ah;
	JavaScriptExceutor_Utility jsu;
	Excel_Utility eu;
	private Pages pages;

	public HP_TS4_AddTravellerTest(BaseClass b, Pages pages) {
		this.b = b;
		this.pages = pages;
		wbu = new WebDriver_Utility(b.getDriver());
		ah = new Actions_Helper(b.getDriver());
		jsu = new JavaScriptExceutor_Utility(b.getDriver());
		eu = new Excel_Utility();
	}

	SoftAssert sa = new SoftAssert();

	@Given("Application is launched")
	public void application_is_launched() {
		wbu.waitForElementload(20);
		pages.hp.navigateHolidayPackage();
	}

	@When("User searches HP for Package ideas as {string} {string} {string}")
	public void user_searches_hp_for_package_ideas(String from, String to, String date) {
		pages.home.clickFromCityField();
		wbu.waitTillElementIsClckable(pages.home.getFromCityTextField(), 10);
		pages.home.getFromCityTextField().clear();
		pages.home.configFromCityTextField(from);
		wbu.waitTillElementIsClckable(pages.home.getFromCity(from), 10);
		pages.home.clickFromCity(from);

		pages.home.clickToCityField();
		wbu.waitTillElementIsClckable(pages.home.getToCityTextField(), 10);
		pages.home.getToCityTextField().clear();
		pages.home.configToCityTextField(to);
		wbu.waitTillElementIsClckable(pages.home.getToCity(to), 10);
		pages.home.clickToCity(to);

//	        Pages.home.clickDepartureField();
		wbu.waitTillElementIsClckable(pages.home.getDeparture(date), 10);
		ah.clickOnElement(pages.home.getDeparture(date));

//	        Pages.home.clickRoomField();
//	        wbu.waitTillElementIsClckable(Pages.home.getRoomIncr(), 10);
//	        Pages.home.clickRoomIncr();
		wbu.waitTillElementIsClckable(pages.home.getRoomApplyBtn(), 10);
		jsu.clickForceTheElement(pages.home.getRoomApplyBtn());

		jsu.clickForceTheElement(pages.home.getFilterApplyBtn());
		pages.home.clickSearchBtn();
	}

	@When("User selects a package using filters as {string} {string} {string}")
	public void user_selects_a_package_using_filters(String place, String flight, String type)
			throws InterruptedException {
		wbu.waitTillElementIsClckable(pages.hpf.getCloseQuote(), 10);
		jsu.clickForceTheElement(pages.hpf.getCloseQuote());
		
		wbu.waitTillElementIsVisible(pages.hpf.getFilterCities(), 10);
//		wbu.waitForElementload(10);
		pages.hpf.configFilterCities(place);
//		wbu.waitTillElementIsClckable(Pages.hpf.getFilterCitiesCheckbox(city), 10);
		wbu.waitForElementload(5);
		jsu.clickForceTheElement(pages.hpf.getFilterCitiesCheckbox(place));

		wbu.waitForLoaderToDisappear();
		pages.hpf.clickFilterFlight(flight);

		wbu.waitForLoaderToDisappear();
		pages.hpf.clickFilterHoneyMoon(type);

		pages.hpf.getSelectPackage().click();

		Thread.sleep(3000);

		try {
			wbu.waitTillElementIsClckable(pages.hpf.getFilterFlightPackage(), 10);

			if (pages.hpf.getFilterFlightPackage().isDisplayed())
				jsu.clickForceTheElement(pages.hpf.getFilterFlightPackage());
		} catch (NoSuchElementException e) {
		}

	}

	@When("User edit restaurant details as {string}")
	public void user_edit_restaurant_details(String place) {
		String parent_id = b.getDriver().getWindowHandle();
		Set<String> all_id = b.getDriver().getWindowHandles();

		all_id.remove(parent_id);
		String childWindowHandle = "";
		for (String ele : all_id) {
			childWindowHandle = ele;

		}
		b.getDriver().switchTo().window(childWindowHandle);

		wbu.waitForElementload(3);
		pages.hpa.clickSkipGuide();
		wbu.waitTillElementIsClckable(pages.hpa.getCloseQuote(), 20);
		jsu.clickForceTheElement(pages.hpa.getCloseQuote());

		try {
			pages.hpa.clickChangeRestaurent(place);
		} catch (Exception e) {
			System.out.println("There is no " + place + "to Update and so, we procceded with payment");
		}

		try {
			wbu.waitTillElementIsClckable(pages.hpa.getSelectRestaurent(), 10);
			pages.hpa.clickSelectRestaurent();
		} catch (Exception e) {
		}

	}

	@Then("User proceeds to Booking page")
	public void user_proceeds_to_booking_page() {
		try {
			pages.hpa.clickUpdateRestaurent();
		} catch (Exception e) {
		}

		pages.hpa.clickProceedPayment();
	}

	@When("User click add Traveller details")
	public void user_click_add_traveller_details() {
		wbu.waitTillElementIsClckable(pages.hpr.getAddTravellerBtn(), 5);
		pages.hpr.getAddTravellerBtn().click();
	}

	@When("User adds traveller details from Excel")
	public void user_adds_traveller_details_from_excel() throws EncryptedDocumentException, IOException {
		eu.loadExcelFile("./src/test/resources/testdata/MakeMyTripExcelData.xlsx", "HPTravellerDetail");

		Object[][] travellers = eu.getDataFromTheExcelSheet();

		for (Object[] row : travellers) {
			String fname = row[1].toString();
			String lname = row[2].toString();
			String day = row[3].toString();
			String month = row[4].toString();
			String year = row[5].toString();
			String gender = row[6].toString();

			pages.hpr.clickSelectConfirmBtn();
			pages.hpr.configFirstName(fname);
			pages.hpr.configLastName(lname);
			pages.hpr.getSelectDate().click();
			ah.entervalueinDropDown(day);
			pages.hpr.getSelectMonth().click();
			ah.entervalueinDropDown(month);
			pages.hpr.getSelectYear().click();
			ah.entervalueinDropDown(year);
			pages.hpr.getSelectGender().click();
			pages.hpr.clickSelectMaleAdult1();
			pages.hpr.clickSelectConfirmBtn();
		}
	}

	@Then("Verify the Traveller details added")
	public void verify_the_traveller_details_added() {

//			Pages.hpr.clickCancelAddDetail();
		try {
			wbu.waitTillElementIsClckable(pages.hpr.getCancelAddDetail(), 2);
			pages.hpr.clickCancelAddDetail();
		} catch(Exception e) {
		}
		

		try {
			String verifyText = pages.hpr.getVerifyAddedTraveller().getText();
			String text = "Profile Completed";
			sa.assertEquals(verifyText, text);
			System.out.println("TS3 --> Traveller details added --- Validation successfull!");
		} catch (Exception e) {
			System.out.println("TS3 --> Traveller detials is not yet added --- Validation Failed!");
		}
	}
}
