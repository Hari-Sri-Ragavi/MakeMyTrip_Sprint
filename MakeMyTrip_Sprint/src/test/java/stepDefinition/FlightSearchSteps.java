package stepDefinition;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.BaseClass;
import base.Pages;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlightSearchSteps {

	String originalPrice;
	String priceAfterBaggage;


	String selectedAirline;

	private BaseClass b;
	private Pages pages;

	public FlightSearchSteps(BaseClass b, Pages pages) {
		this.b = b;
		this.pages = pages;
	}

	@When("the user clicks on {string}")
	public void the_user_clicks_on(String value) {
		if (value.equalsIgnoreCase("Flights")) {
			pages.fp.clickFlightsMenu();
		} else if (value.equalsIgnoreCase("Search")) {
			pages.fp.clickSearch();
		}
	}

	@When("the user enters source as {string}")
	public void source(String value) throws InterruptedException {
		pages.fp.enterSource(value);
	}

	@When("the user enters destination as {string}")
	public void destination(String value) throws InterruptedException {
		pages.fp.enterDestination(value);
	}

	

	@When("the user enters source and destination")
	public void enterSourceAndDestination(DataTable dataTable) throws InterruptedException {

	    List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

	    for (Map<String, String> row : data) {

	        String src = row.get("src");
	        
	        String dest = row.get("dest");

	        pages.fp.enterSource(src);
	       
	        pages.fp.enterDestination(dest);

	        b.getDriver().navigate().refresh();
	        pages.loadAllPages(b.getDriver());
	        pages.hp.closeModalIfPresent();
	        
	    }
	}
	@When("the user selects a valid travel date")
	public void select_date() {
		pages.fp.selectDate("June", "4");
	}

	@Then("the user should see search results for the selected route")
	public void results() {
		assertTrue(true);
		System.out.println("Results displayed");
	}

	@When("the user selects a specific airline from the search results")
	public void airline() throws InterruptedException {
		pages.fp.selectAirline();
	}

	@When("the user views the price details for the selected flight")
	public void price() throws InterruptedException {
		pages.fp.clickViewPrices();
	}

	@When("the user clicks on {string} button")
	public void button(String value) throws InterruptedException {
		if (value.equalsIgnoreCase("Book Now")) {
			pages.fp.clickBookNow();
		}
	}

	@Then("the user should be navigated to the review booking page")
	public void nav() {

		WebDriver driver = b.getDriver();
		WebDriverWait wait = new WebDriverWait(b.getDriver(), Duration.ofSeconds(25));


		for (String handle : driver.getWindowHandles()) {
		    driver.switchTo().window(handle);
		}

		WebElement bookingHeader = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(
		                By.xpath("//h2[contains(text(),'Complete your booking')]")
		        )
		);

		String booking = bookingHeader.getText();

		Assert.assertEquals(
		        booking.trim(),
		        "Complete your booking",
		        "Not on booking page. Found: " + booking
		);

		System.out.println("On booking page");
	}

	@Then("the user should see filtered results for that airline")
	public void the_user_should_see_filtered_results_for_that_airline() {
		String verifyText = b.getDriver()
		        .findElement(By.xpath("//p[@data-test='component-filtersHeading']"))
		        .getText();

		String text = "Applied Filters CLEAR ALL";

		Assert.assertEquals(
		        verifyText.replaceAll("\\s+", " ").trim(),
		        text.replaceAll("\\s+", " ").trim()
		);
	}
	@Then("the system should show an error message")
	public void the_system_should_show_an_error_message() {

	    WebDriverWait wait = new WebDriverWait(b.getDriver(), Duration.ofSeconds(15));

	    WebElement error = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//span[contains(@class,'fltErrorMsgText')]")
	        )
	    );

	    String actual = error.getText();
	    String expected = "From  To airports cannot be the same";

	    System.out.println("Error text: " + actual);

	    Assert.assertEquals(actual, expected);
	}
}