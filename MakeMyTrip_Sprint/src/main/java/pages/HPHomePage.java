package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HPHomePage {
	
	//FromCity Field
	@FindBy(id = "fromCity")
	private WebElement fromCityField;
	
	//FromCity TextField -> Chennai
	@FindBy(css = "[placeholder='Enter City']")
	 WebElement fromCityTextField;
	
	//FromCity Click -> Chennai
	@FindBy(xpath = "//p[contains(. , 'Chennai')]")
	private WebElement fromCity;
	
	//ToCity Field
	@FindBy(id = "toCity")
	private WebElement toCityField;
	
	//ToCity TextField -> Kerala
	@FindBy(css = "[placeholder = 'To']")
	private WebElement toCityTextField;
	
	//ToCity Click -> Kerala
	@FindBy(xpath = "//div[. = 'Kerala']")
	private WebElement toCity;
	
	//Departure Field
	@FindBy(id = "departure")
	private WebElement departureField;
	
	//Departure Click -> May 7,2026 
	@FindBy(xpath = "//div[@aria-label='Thu May 07 2026']")
	private WebElement departure;
	
	//Room & Guests Field
	@FindBy(xpath = "//div[. = '1 Room']")
	private WebElement RoomField;
	
	//Room & Guests Increment -> 3
	@FindBy(xpath = "//div[@data-testid= 'adult-increment-counter']")
	private WebElement RoomIncr;
	
	//Room & Guests Apply
	@FindBy(xpath = "//button[. = 'APPLY']")
	private WebElement RoomApplyBtn;
	
	//Filters Apply
	@FindBy(xpath = "//button[text()='APPLY']")
	private WebElement FilterApplyBtn;
	
	//Search Button
	@FindBy(xpath = "//button[text() = 'Search']")
	private WebElement SearchBtn;

	//Getters and setters of From city Field
	public WebElement getFromCityField() {
		return fromCityField;
	}

	public void clickFromCityField() {
		getFromCityField().click();
	}

	//Getters and setters of From City Text Field
	public WebElement getFromCityTextField() {
		return fromCityTextField;
	}

	public void configFromCityTextField(String From) {
		getFromCityTextField().sendKeys(From);
	}

	//Getters and setters of From City 
	public WebElement getFromCity() {
		return fromCity;
	}

	public void clickFromCity() {
		getFromCity().click();
	}

	//Getters and setters of to City Field
	public WebElement getToCityField() {
		return toCityField;
	}

	public void clickToCityField() {
		getToCityField().click();
	}

	//Getters and Setters of to City TextField
	public WebElement getToCityTextField() {
		return toCityTextField;
	}

	public void configToCityTextField(String To) {
		getToCityTextField().sendKeys(To);
	}

	//Getters and setters of To City
	public WebElement getToCity() {
		return toCity;
	}

	public void clickToCity() {
		getToCity().click();
	}

	//Getters and setters of Departure Click
	public WebElement getDepartureField() {
		return departureField;
	}

	public void clickDepartureField() {
		getDepartureField().click();
	}

	//Getters and setters of Departure -> Date
	public WebElement getDeparture() {
		return departure;
	}

	public void clickDeparture() {
		getDeparture().click();
	}

	//Getters and setters of Room & guest Field
	public WebElement getRoomField() {
		return RoomField;
	}

	public void clickRoomField() {
		getRoomField().click();
	}

	//Getters and setters of Increment No. of Rooms 
	public WebElement getRoomIncr() {
		return RoomIncr;
	}

	public void clickRoomIncr() {
		getRoomIncr().click();
	}

	//Getters and setters of Apply No. of Rooms & Guests
	public WebElement getRoomApplyBtn() {
		return RoomApplyBtn;
	}

	public void clickRoomApplyBtn() {
		getRoomApplyBtn().click();
	}

	//Getters and setters of Filter Apply
	public WebElement getFilterApplyBtn() {
		return FilterApplyBtn;
	}

	public void clickFilterApplyBtn() {
		getFilterApplyBtn().click();
	}

	//Getters and setters of Search btn
	public WebElement getSearchBtn() {
		return SearchBtn;
	}

	public void clickSearchBtn() {
		getSearchBtn().click();
	}
	
	//Methods --> (Chennai, Kerala, May 22,2026, 2)
	public void SearchInfo() {
		clickFromCityField();
		configFromCityTextField("Chennai");
		clickFromCity();
//		clickToCityField();
		configToCityTextField("Kerala");
		clickToCity();
//		clickDepartureField();
		clickDeparture();
//		clickRoomField();
//		clickRoomIncr();
		clickRoomApplyBtn();
		clickSearchBtn();
	}
	
	

}
