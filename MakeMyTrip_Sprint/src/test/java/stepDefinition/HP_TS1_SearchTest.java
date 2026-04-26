package stepDefinition;

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

public class HP_TS1_SearchTest {

	private BaseClass b;
	 private Pages pages;

	WebDriver_Utility wbu;
	Actions_Helper ah;
	JavaScriptExceutor_Utility jsu;

	public HP_TS1_SearchTest(BaseClass b, Pages pages) {
		this.b = b;
		this.pages = pages;
		wbu = new WebDriver_Utility(b.getDriver());
		ah = new Actions_Helper(b.getDriver());
		jsu = new JavaScriptExceutor_Utility(b.getDriver());
	}

	@Given("Open the browser and then Navigate")
	public void open_the_browser_and_then_navigate() {
		wbu.waitForElementload(10);
	}

	@When("Click on HP")
	public void click_on_hp() {
		pages.hp.navigateHolidayPackage();
	}

	@When("Enter FromCity as {string}")
	public void enter_from_city(String from) {

		pages.home.clickFromCityField();

		wbu.waitTillElementIsClckable(pages.home.getFromCityTextField(), 10);
		pages.home.getFromCityTextField().clear();
		pages.home.configFromCityTextField(from);

		wbu.waitTillElementIsClckable(pages.home.getFromCity(from), 10);
		pages.home.clickFromCity(from);
	}

	@When("Enter ToCity as {string}")
	public void enter_to_city(String dest) {

		pages.home.clickToCityField();

		wbu.waitTillElementIsClckable(pages.home.getToCityTextField(), 10);
		pages.home.getToCityTextField().clear();
		pages.home.configToCityTextField(dest);

		wbu.waitTillElementIsClckable(pages.home.getToCity(dest), 10);
		pages.home.clickToCity(dest);
	}

	@When("Select DepartureDate as {string}")
	public void select_departure_date(String date) {

//      Pages.home.clickDepartureField();
		wbu.waitTillElementIsClckable(pages.home.getDeparture(date), 10);
		ah.clickOnElement(pages.home.getDeparture(date));
	}

	@When("Enter Rooms&Guests")
	public void enter_rooms_guests() {

//        Pages.home.clickRoomField();
//        wbu.waitTillElementIsClckable(Pages.home.getRoomIncr(), 10);
//        Pages.home.clickRoomIncr();

		wbu.waitTillElementIsClckable(pages.home.getRoomApplyBtn(), 10);
		jsu.clickForceTheElement(pages.home.getRoomApplyBtn());
	}

	@Then("Click on Search")
	public void click_on_search() {
		try {
			jsu.clickForceTheElement(pages.home.getFilterApplyBtn());
			pages.home.clickSearchBtn();
		} catch (Exception e) {
		}
		
		wbu.waitTillElementIsClckable(pages.hpf.getCloseQuote(), 10);
		jsu.clickForceTheElement(pages.hpf.getCloseQuote());
	}

	@Then("Verify HP HomePage")
	public void verify_hp_home_page() {
		Assert.assertTrue(pages.hpf.getVerifyFilterPage().isDisplayed());
				
	}

}
