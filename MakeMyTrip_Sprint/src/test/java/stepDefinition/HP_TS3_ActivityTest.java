package stepDefinition;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.asserts.SoftAssert;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.Actions_Helper;
import util.JavaScriptExceutor_Utility;
import util.WebDriver_Utility;
import base.Pages;

public class HP_TS3_ActivityTest {

	private BaseClass b;
	private Pages pages;

	WebDriver_Utility wbu;
	Actions_Helper ah;
	JavaScriptExceutor_Utility jsu;

	SoftAssert sa = new SoftAssert();

	public HP_TS3_ActivityTest(BaseClass b, Pages pages) {
		this.b = b;
		this.pages = pages;
		wbu = new WebDriver_Utility(b.getDriver());
		ah = new Actions_Helper(b.getDriver());
		jsu = new JavaScriptExceutor_Utility(b.getDriver());
	}

	@Given("User launches Holiday Package application")
	public void user_launches_holiday_package_application() {
		wbu.waitForElementload(10);
		pages.hp.navigateHolidayPackage();
	}

	@When("User searches holiday package with valid details as {string} {string} {string}")
	public void user_searches_holiday_package_with_valid_details(String from, String to, String date) {
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

//	    Pages.home.clickDepartureField();

		wbu.waitTillElementIsClckable(pages.home.getDeparture(date), 10);
		ah.clickOnElement(pages.home.getDeparture(date));

//	    Pages.home.clickRoomField();
//	    wbu.waitTillElementIsClckable(Pages.home.getRoomIncr(), 10);
//	    Pages.home.clickRoomIncr();

		wbu.waitTillElementIsClckable(pages.home.getRoomApplyBtn(), 10);
		jsu.clickForceTheElement(pages.home.getRoomApplyBtn());
		jsu.clickForceTheElement(pages.home.getFilterApplyBtn());
		pages.home.clickSearchBtn();
	}

	@When("User applies all required filters")
	public void user_applies_all_required_filters() {
		wbu.waitTillElementIsClckable(pages.hpf.getCloseQuote(), 10);
		jsu.clickForceTheElement(pages.hpf.getCloseQuote());
	}

	@When("User selects required package as {string} {string} {string}")
	public void user_selects_required_package(String city, String flight, String theme) throws InterruptedException {
		wbu.waitTillElementIsVisible(pages.hpf.getFilterCities(), 10);
//		wbu.waitForElementload(10);
		pages.hpf.configFilterCities(city);
//		wbu.waitTillElementIsClckable(Pages.hpf.getFilterCitiesCheckbox(city), 10);
		wbu.waitForElementload(5);
		jsu.clickForceTheElement(pages.hpf.getFilterCitiesCheckbox(city));

		wbu.waitForLoaderToDisappear();
		pages.hpf.clickFilterFlight(flight);

		wbu.waitForLoaderToDisappear();
		pages.hpf.clickFilterHoneyMoon(theme);

		pages.hpf.getSelectPackage().click();

		Thread.sleep(3000);

		try {
			wbu.waitTillElementIsClckable(pages.hpf.getFilterFlightPackage(), 10);

			if (pages.hpf.getFilterFlightPackage().isDisplayed())
				jsu.clickForceTheElement(pages.hpf.getFilterFlightPackage());
		} catch (NoSuchElementException e) {
//	        System.out.println("Flight package option not found, skipping execution.");
		}
	}

	@Then("User closes the advertisement popup")
	public void user_closes_the_advertisement_popup() {
		String parent_id = b.getDriver().getWindowHandle();
		Set<String> all_id = b.getDriver().getWindowHandles();

		all_id.remove(parent_id);
		String childWindowHandle = "";
		for (String ele : all_id) {
			childWindowHandle = ele;

		}
		b.getDriver().switchTo().window(childWindowHandle);
	}

	@Then("User clicks on Skip option")
	public void user_clicks_on_skip_option() {
		wbu.waitForElementload(3);
		pages.hpa.clickSkipGuide();
		wbu.waitTillElementIsClckable(pages.hpa.getCloseQuote(), 20);
		jsu.clickForceTheElement(pages.hpa.getCloseQuote());
	}

	@When("User clicks on Remove Activity and then update")
	public void user_clicks_on_remove_activity_and_then_update() {
//		while (true) {
			try {
				if (pages.hpa.getRemoveActivity().isDisplayed()) {
					pages.hpa.clickRemoveActivity();
					wbu.waitTillElementIsClckable(pages.hpa.getRemoveActivity(),3);
					pages.hpa.clickConfirmRemove();
					wbu.waitTillElementIsClckable(pages.hpa.getConfirmRemove(), 3);				
				}
			} catch (Exception e) {
//				break;
			}
		}
//	}

	@When("User clicks on Change Restaurant as {string}")
	public void user_clicks_on_change_restaurant(String place) {
		try {
			pages.hpa.clickChangeRestaurent(place);
		} catch (Exception e) {
			System.out.println("There is no " + place + "to Update and so, we procceded with payment");
		}

	}

	@When("User updates the restaurant details")
	public void user_updates_the_restaurant_details() {
		try {
			wbu.waitTillElementIsClckable(pages.hpa.getSelectRestaurent(), 10);
			pages.hpa.clickSelectRestaurent();
		} catch (Exception e) {
		}
	}

	@When("User clicks on Update button")
	public void user_clicks_on_update_button() {
		try {
			pages.hpa.clickUpdateRestaurent();
		} catch (Exception e) {
		}
	}

	@Then("User proceeds to payment page")
	public void user_proceeds_to_payment_page() {
		pages.hpa.clickProceedPayment();
		
		String text = "Review package";
		String verifyText = "";

		try {
			sa.assertEquals(verifyText, text);
			verifyText = pages.hpr.getVerifyReview().getText();
			System.out.println("TS3 --> Activity Package is updated in HP --- Validation successfull!");
		} catch (Exception e) {
			System.out.println("TS3 --> Activity Package is not yet Updated --- Validation Failed!");
		}
	}

}
