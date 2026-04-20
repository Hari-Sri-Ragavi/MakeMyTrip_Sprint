package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class HPFilterPage {

	WebDriver driver;

	public HPFilterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Verify Filter Page
	@FindBy(xpath = "//span[@class = 'name']")
	private WebElement verifyFilterPage;

	// Quote Close button
	@FindBy(xpath = "//div[@id = 'modalpopup']//span[@class='close closeIcon']")
	private WebElement closeQuote;

	// Filter -> With Flight
//	@FindBy(xpath = "//span[text()='Flights']/ancestor::div[@class='filterHeadouter']/following::div[@class='offerSection']//span[contains(text(),'With Flight')]")
//	private WebElement filterFlight;

	// Filter -> Click on Cities TextBox
	@FindBy(xpath = "//span[.='Cities']/../..//div[@class='innerListSection']//input[@type='text']")
	private WebElement filterCities;

	// Filter -> Click on Munnar Checkbox

	// Filter -> Theme Culture
	@FindBy(xpath = "//span[. = 'Culture']/../..//input")
	private WebElement filterTheme;

	// Filter -> HoneyMoon
//	@FindBy(xpath = "//span[. ='All Packages']/../..//li//span[. = 'Honeymoon']")
//	private WebElement filterHoneyMoon;

	// Select Package
	@FindBy(xpath = "(//section[@style='display: flex; max-width: 100%;'])[1]")
	private WebElement selectPackage;

	// Getters and setters of VerifyFilter Page
	public WebElement getVerifyFilterPage() {
		return verifyFilterPage;
	}

	public void clickVerifyFilterPage() {
		getVerifyFilterPage().click();
	}

	// Getters and setters of Close quote btn
	public WebElement getCloseQuote() {
		return closeQuote;
	}

	public void clickCloseQuote() {
		getCloseQuote().click();
	}

	// Getters and setters of Filter -> With Flight
	public WebElement getFilterFlight(String option) {
		WebElement filterFlight = driver.findElement(By.xpath("//span[text()='Flights']/ancestor::div[@class='filterHeadouter']/following::div[@class='offerSection']//span[contains(text(),'"+ option +" Flight')]"));
		return filterFlight;
	}

	public void clickFilterFlight(String option) {
		getFilterFlight(option).click();
	}

	// Getters and setters of Filter -> Click on Cities TextBox
	public WebElement getFilterCities() {
		return filterCities;
	}

	public void configFilterCities(String City) {
		getFilterCities().sendKeys(City);
	}

	// Getters and setters of Filter -> Click on Munnar Checkbox
	public WebElement getFilterCitiesCheckbox(String city) {
		WebElement filterCitiesCheckbox = driver.findElement(By.xpath("//span[.='" + city + "']/../..//input"));
		return filterCitiesCheckbox;
	}

	public void clickFilterCitiesCheckbox(String city) {
		getFilterCitiesCheckbox(city).click();
	}

	// Getters and setters of Filter -> Theme Culture
	public WebElement getFilterTheme() {
		return filterTheme;
	}

	public void clickFilterTheme() {
		getFilterTheme().click();
	}

	// Getters and setter of Filter -> Honeymoon
	public WebElement getFilterHoneyMoon(String type) {
		WebElement filterHoneyMoon = driver.findElement(By.xpath("//span[. ='All Packages']/../..//li//span[. = '"+type+"']"));
		return filterHoneyMoon;
	}

	public void clickFilterHoneyMoon(String type) {
		getFilterHoneyMoon(type).click();
	}

	// Getters and setters of Select Package
	public WebElement getSelectPackage() {
		return selectPackage;
	}

	public void clickSelectPackage() {
		getSelectPackage().click();
	}

	// Getters and setters of Filter -> package With flight
	public WebElement getFilterFlightPackage() {
		WebElement filterFlightPackage = driver.findElement(By.xpath("//div[. = 'Without Flight']"));
		return filterFlightPackage;
	}

	public void clickFilterFlightPackage() {
		getFilterFlightPackage().click();
	}

	// Methods -> All filters
	public void filter(String flightOption, String city, String type) {
		clickCloseQuote();
		clickFilterFlight(flightOption);
		configFilterCities(city);
		clickFilterCitiesCheckbox(city);
		clickFilterTheme();
		clickFilterHoneyMoon(type);
		clickSelectPackage();
		clickFilterFlightPackage();
	}
}
