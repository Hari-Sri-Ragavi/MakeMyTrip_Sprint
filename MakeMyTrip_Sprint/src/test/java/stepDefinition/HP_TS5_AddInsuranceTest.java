package stepDefinition;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
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

public class HP_TS5_AddInsuranceTest {

	private BaseClass b;
	private Pages pages;
	
	WebDriver_Utility wbu;
	Actions_Helper ah;
	JavaScriptExceutor_Utility jsu;

	int updatedTotal = 0;
	int addOnPrice = 0;
	int oldTotal = 0;
	
	SoftAssert sa = new SoftAssert();
	
	public HP_TS5_AddInsuranceTest(BaseClass b, Pages pages) {
		this.b = b;
		this.pages = pages;
		wbu = new WebDriver_Utility(b.getDriver());
		ah = new Actions_Helper(b.getDriver());
		jsu = new JavaScriptExceutor_Utility(b.getDriver());
	}

	@Given("User launches HP application")
	public void user_launches_hp_application() {
		pages.hp.navigateHolidayPackage();
	}

	@When("User searches available HP as {string} {string} {string}")
	public void user_searches_available_hp(String from, String to, String date) {
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

	@When("User applies filters and selects required package as {string}")
	public void user_applies_filters_and_selects_required_package(String place) throws InterruptedException {
		wbu.waitTillElementIsClckable(pages.hpf.getCloseQuote(), 10);
		jsu.clickForceTheElement(pages.hpf.getCloseQuote());

		wbu.waitTillElementIsVisible(pages.hpf.getFilterCities(), 10);
//		wbu.waitForElementload(10);
		pages.hpf.configFilterCities(place);
//		wbu.waitTillElementIsClckable(Pages.hpf.getFilterCitiesCheckbox(city), 10);
		wbu.waitForElementload(5);
		jsu.clickForceTheElement(pages.hpf.getFilterCitiesCheckbox(place));

		pages.hpf.getSelectPackage().click();

		Thread.sleep(3000);

		try {
			wbu.waitTillElementIsClckable(pages.hpf.getFilterFlightPackage(), 10);

			if (pages.hpf.getFilterFlightPackage().isDisplayed())
				jsu.clickForceTheElement(pages.hpf.getFilterFlightPackage());
		} catch (NoSuchElementException e) {
		}
	}

	@When("User updates restaurant details")
	public void user_updates_restaurant_details() {
		String parent_id = b.getDriver().getWindowHandle();
		Set<String> all_id = b.getDriver().getWindowHandles();

		all_id.remove(parent_id);
		String childWindowHandle = "";
		for (String ele : all_id) {
			childWindowHandle = ele;

		}
		b.getDriver().switchTo().window(childWindowHandle);

		try {
			if (pages.hpa.getSkipGuide().isDisplayed()) {
				jsu.clickForceTheElement(pages.hpa.getSkipGuide());
			}
		} catch (Exception e) {
			System.out.println("Ad popup not present");
		}

		try {
			wbu.waitTillElementIsClckable(pages.hpa.getCloseQuote(), 10);
			jsu.clickForceTheElement(pages.hpa.getCloseQuote());
		} catch (Exception e) {
			System.out.println("Skip button not present");
		}

	}

	@Then("User proceeds to review page")
	public void user_proceeds_to_review_page() {
		pages.hpa.clickProceedPayment();
	}

	@When("click on AddOns")
	public void click_on_addons() {
		pages.hpr.clickClickAddOns();
		wbu.waitTillElementIsVisible(pages.hpr.getOldPrice(), 2);		
		oldTotal = Integer.parseInt(pages.hpr.getOldPrice().getText().replaceAll("[^0-9]", ""));
	}

	@When("add the insurance")
	public void add_the_insurance() {
		addOnPrice = Integer.parseInt(pages.hpr.getInsurancePrice().getText().replaceAll("[^0-9]", ""));
		((JavascriptExecutor) b.getDriver()).executeScript("arguments[0].scrollIntoView(true);", pages.hpr.getSelectAddOns());
		((JavascriptExecutor) b.getDriver()).executeScript("arguments[0].click();", pages.hpr.getSelectAddOns());

	    wbu.waitForLoaderToDisappear();;
		updatedTotal = Integer.parseInt(pages.hpr.getOldPrice().getText().replaceAll("[^0-9]", ""));
	}

	@Then("Verify it is added")
	public void verify_it_is_added() {
		Assert.assertTrue(updatedTotal > oldTotal + addOnPrice);
	}


}
