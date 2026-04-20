package stepDefinition;

import java.util.Set;

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

public class HP_TS2_FilterTest {

	private BaseClass b;

	WebDriver_Utility wbu;
	Actions_Helper ah;
	JavaScriptExceutor_Utility jsu;
	private Pages pages;

	SoftAssert sa = new SoftAssert();

	public HP_TS2_FilterTest(BaseClass b, Pages pages) {
		this.b = b;
		this.pages = pages;
		wbu = new WebDriver_Utility(b.getDriver());
		ah = new Actions_Helper(b.getDriver());
		jsu = new JavaScriptExceutor_Utility(b.getDriver());
		
	}

	@Given("Open the browser and Navigate to Application")
	public void open_the_browser_and_navigate_to_application() {
		wbu.waitForElementload(10);
		pages.hp.navigateHolidayPackage();
	}

	@When("Enter search details in HP as {string} {string} {string}")
	public void enter_search_details_in_hp(String from, String to, String date) {
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
	}

	@When("Click on Search button")
	public void click_on_search_button() {
		jsu.clickForceTheElement(pages.home.getFilterApplyBtn());
		pages.home.clickSearchBtn();
	}

	@Then("User is on filter page")
	public void user_is_on_filter_page() {
		wbu.waitTillElementIsClckable(pages.hpf.getCloseQuote(), 10);
		jsu.clickForceTheElement(pages.hpf.getCloseQuote());
	}

	@When("Apply City filter as {string}")
	public void apply_city_filter(String city) {
		wbu.waitTillElementIsVisible(pages.hpf.getFilterCities(), 10);
//		wbu.waitForElementload(10);
		pages.hpf.configFilterCities(city);
//		wbu.waitTillElementIsClckable(Pages.hpf.getFilterCitiesCheckbox(city), 10);
		wbu.waitForElementload(5);
		jsu.clickForceTheElement(pages.hpf.getFilterCitiesCheckbox(city));
	}

	@When("Apply Flight filter as {string}")
	public void apply_flight_filter(String flight) {
		wbu.waitForLoaderToDisappear();
		pages.hpf.clickFilterFlight(flight);
	}

//	@When("Apply Theme filter")
//	public void apply_theme_filter() {	
//		wbu.waitForLoaderToDisappear();
//		jsu.clickForceTheElement(Pages.hpf.getFilterTheme());
//	}

	@When("Apply Package filter as {string}")
	public void apply_package_filter(String type) {
		wbu.waitForLoaderToDisappear();
		pages.hpf.clickFilterHoneyMoon(type);
	}

	@Then("Click on required package")
	public void click_on_required_package() {
		pages.hpf.getSelectPackage().click();
	}

	@Then("Select Package flight option")
	public void select_package_flight_option() throws InterruptedException {
		Thread.sleep(3000);

		try {
			wbu.waitTillElementIsClckable(pages.hpf.getFilterFlightPackage(), 10);

			if (pages.hpf.getFilterFlightPackage().isDisplayed())
				jsu.clickForceTheElement(pages.hpf.getFilterFlightPackage());
		} 
		catch (NoSuchElementException e) {
//	        System.out.println("Flight package option not found, skipping execution.");
	    }
	}

	@Then("Verify package details page")
	public void verify_package_details_page() {

		String parent_id = b.getDriver().getWindowHandle();
		Set<String> all_id = b.getDriver().getWindowHandles();
		all_id.remove(parent_id);
		String childWindowHandle = "";
		for (String ele : all_id) {
			childWindowHandle = ele;
		}
		b.getDriver().switchTo().window(childWindowHandle);

		Assert.assertNotEquals(childWindowHandle, parent_id);
		System.out.println("TS2 --> Filters performed and Navigated Successfully!");
	}

}
