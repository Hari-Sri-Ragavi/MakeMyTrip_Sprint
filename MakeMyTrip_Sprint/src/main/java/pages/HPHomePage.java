package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HPHomePage {

	WebDriver driver;

	public HPHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// FromCity Field
	@FindBy(id = "fromCity")
	private WebElement fromCityField;

	// FromCity TextField -> Chennai
	@FindBy(css = "[placeholder='Enter City']")
	WebElement fromCityTextField;

//	FromCity Click -> Chennai

	// ToCity Field
	@FindBy(id = "toCity")
	private WebElement toCityField;

	// ToCity TextField -> Kerala
	@FindBy(css = "[placeholder = 'To']")
	private WebElement toCityTextField;

//   ToCity Click -> Kerala

	// Departure Field
	@FindBy(id = "departure")
	private WebElement departureField;

//	Departure Click -> May 7,2026

	// Room & Guests Field
	@FindBy(xpath = "//div[. = '1 Room']")
	private WebElement RoomField;

	// Room & Guests Increment -> 3
	@FindBy(xpath = "//div[@data-testid= 'adult-increment-counter']")
	private WebElement RoomIncr;

	// Room & Guests Apply
	@FindBy(xpath = "//button[. = 'APPLY']")
	private WebElement RoomApplyBtn;

	// Filters Apply
	@FindBy(xpath = "//button[text()='APPLY']")
	private WebElement FilterApplyBtn;

	// Search Button
	@FindBy(xpath = "//button[text() = 'Search']")
	private WebElement SearchBtn;

	
	
	// Getters and setters of From city Field
	public WebElement getFromCityField() {
		return fromCityField;
	}

	public void clickFromCityField() {
		getFromCityField().click();
	}

	// Getters and setters of From City Text Field
	public WebElement getFromCityTextField() {
		return fromCityTextField;
	}

	public void configFromCityTextField(String From) {
		getFromCityTextField().sendKeys(From);
	}

	// Getters and setters of From City
	public WebElement getFromCity(String from) {
		WebElement fromCity = driver.findElement(By.xpath("//p[contains(. , '" + from + "')]"));
		return fromCity;
	}

	public void clickFromCity(String from) {
		getFromCity(from).click();
	}

	// Getters and setters of to City Field
	public WebElement getToCityField() {
		return toCityField;
	}

	public void clickToCityField() {
		getToCityField().click();
	}

	// Getters and Setters of to City TextField
	public WebElement getToCityTextField() {
		return toCityTextField;
	}

	public void configToCityTextField(String To) {
		getToCityTextField().sendKeys(To);
	}

	// Getters and setters of To City
	public WebElement getToCity(String to) {
		WebElement toCity = driver.findElement(By.xpath("//div[. = '" + to + "']"));
		return toCity;
	}

	public void clickToCity(String to) {
		getToCity(to).click();
	}

	// Getters and setters of Departure Click
	public WebElement getDepartureField() {
		return departureField;
	}

	public void clickDepartureField() {
		getDepartureField().click();
	}

	// Getters and setters of Departure -> Date
	public WebElement getDeparture(String date) {
		WebElement departure = driver.findElement(By.xpath("//div[@aria-label='" + date + "']"));
		return departure;
	}

	public void clickDeparture(String date) {
		getDeparture(date).click();
	}

	// Getters and setters of Room & guest Field
	public WebElement getRoomField() {
		return RoomField;
	}

	public void clickRoomField() {
		getRoomField().click();
	}

	// Getters and setters of Increment No. of Rooms
	public WebElement getRoomIncr() {
		return RoomIncr;
	}

	public void clickRoomIncr() {
		getRoomIncr().click();
	}

	// Getters and setters of Apply No. of Rooms & Guests
	public WebElement getRoomApplyBtn() {
		return RoomApplyBtn;
	}

	public void clickRoomApplyBtn() {
		getRoomApplyBtn().click();
	}

	// Getters and setters of Filter Apply
	public WebElement getFilterApplyBtn() {
		return FilterApplyBtn;
	}

	public void clickFilterApplyBtn() {
		getFilterApplyBtn().click();
	}

	// Getters and setters of Search btn
	public WebElement getSearchBtn() {
		return SearchBtn;
	}

	public void clickSearchBtn() {
		getSearchBtn().click();
	}

	// Methods --> (src, dest, date , 2rooms)
	public void SearchInfo(String from, String to, String date) {
		clickFromCityField();
		configFromCityTextField(from);
		clickFromCity(from);
//		clickToCityField();
		configToCityTextField(to);
		clickToCity(to);
//		clickDepartureField();
		clickDeparture(date);
//		clickRoomField();
//		clickRoomIncr();
		clickRoomApplyBtn();
		clickSearchBtn();
	}

}
