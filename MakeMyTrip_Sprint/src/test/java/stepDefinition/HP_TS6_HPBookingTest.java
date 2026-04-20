
package stepDefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.Actions_Helper;
import util.JavaScriptExceutor_Utility;
import util.WebDriver_Utility;
import base.Pages;
import util.Excel_Utility;

public class HP_TS6_HPBookingTest {

	private BaseClass b;
	private Pages pages;
	
	WebDriver_Utility wbu;
	Actions_Helper ah;
	JavaScriptExceutor_Utility jsu;
	Excel_Utility eu;

	public HP_TS6_HPBookingTest(BaseClass b, Pages pages) {
		this.b = b;
		this.pages = pages;
		wbu = new WebDriver_Utility(b.getDriver());
		ah = new Actions_Helper(b.getDriver());
		jsu = new JavaScriptExceutor_Utility(b.getDriver());
		eu = new Excel_Utility();
	}

	SoftAssert sa = new SoftAssert();

	@Given("User launches & navigates to HP")
	public void user_launches_navigates_to_hp() {
		wbu.waitForElementload(20);
		pages.hp.navigateHolidayPackage();
	}

	@When("User searches HP activities as {string} {string} {string}")
	public void user_searches_hp_activities(String from, String to, String date) {
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

	@When("User filters a package and then select as {string} {string} {string}")
	public void user_filters_a_package_and_then_select(String place, String flight, String type)
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
		
		String parent_id = b.getDriver().getWindowHandle();
		Set<String> all_id = b.getDriver().getWindowHandles();

		all_id.remove(parent_id);
		String childWindowHandle = "";
		for (String ele : all_id) {
			childWindowHandle = ele;

		}
		b.getDriver().switchTo().window(childWindowHandle);

		wbu.waitForElementload(3);
		try {
		pages.hpa.clickSkipGuide();
		} catch(Exception e) {
		}
		wbu.waitTillElementIsClckable(pages.hpa.getCloseQuote(), 20);
		jsu.clickForceTheElement(pages.hpa.getCloseQuote());
	}

	@When("User update\\/change restaurant details as {string}")
	public void user_update_change_restaurant_details(String place) {
		

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

	@Then("User proceeds to Review page")
	public void user_proceeds_to_review_page() {
//		try {
//			Pages.hpa.clickUpdateRestaurent();
//		} catch (Exception e) {
//		}

		pages.hpa.clickProceedPayment();
	}

	@When("User adds traveller details")
	public void user_adds_traveller_details() throws EncryptedDocumentException, IOException {
		wbu.waitTillElementIsClckable(pages.hpr.getAddTravellerBtn(), 5);
		pages.hpr.getAddTravellerBtn().click();

		eu.loadExcelFile("./src/test/resources/testdata/MakeMyTripExcelData.xlsx", "HPTravellerDetail");

		Object[][] travellers = eu.getDataFromTheExcelSheet();

		for (Object[] row : travellers) {
			String fname = row[1].toString();
			String lname = row[2].toString();
			String day = row[3].toString();
			String month = row[4].toString();
			String year = row[5].toString();

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

	@When("user enter Traveller Contact :")
	public void user_enter_traveller_contact(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> contactInfo = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> row : contactInfo) {
			String email = row.get("email");
			String mobileCode = row.get("mobileCode");
			String mobile = row.get("mobile");
			String gstState = row.get("gstState");

			pages.hpr.getEmailId().sendKeys(email);
//		    Pages.hpr.configEmailId(email);

			pages.hpr.clickMobileCodeClick();
			pages.hpr.clickMobileCodeCheckbox();

			pages.hpr.configMobileNo(mobile);

			pages.hpr.configGstCodeClick(gstState);
			pages.hpr.getGstCodeCheckbox().click();

			System.out
					.println("Email: " + email + ", Mobile: " + mobileCode + " " + mobile + ", GST State: " + gstState);
		}
	}

	@When("user enter Contact Info {string} {string} {string} {string}")
	public void user_enter_contact_info(String email, String code, String no, String gst) {
		wbu.waitTillElementIsClckable(pages.hpr.getEmailId(), 10);
		pages.hpr.getEmailId().sendKeys(email);
//	    Pages.hpr.configEmailId(email);

		pages.hpr.clickMobileCodeClick();
		pages.hpr.clickMobileCodeCheckbox();

		pages.hpr.configMobileNo(no);

		pages.hpr.configGstCodeClick(gst);
		pages.hpr.getGstCodeCheckbox().click();

		System.out.println("Entered Contact Info: " + email + " | " + code + " " + no + " | " + gst);
	}

	@Then("Payment should be proceed")
	public void payment_should_be_proceed() {
//		Pages.hpr.clickPaymentProceed();

		try {
			Assert.assertEquals(true, pages.hpr.isCheckStatusButtonClickable());
			System.out.println("TS6 ->  Booking Done. --- Validation Successful!");
		} catch(Exception e) {
			System.out.println("TS5 -> Add-on Not still added --- Validation Failed!");
		}
	}
}
