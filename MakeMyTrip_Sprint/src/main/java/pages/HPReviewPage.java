package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HPReviewPage {

	// Add Traveller -> Click
	@FindBy(xpath = "//p[. ='Add Traveller']")
	private WebElement addTravellerBtn;

	// First Name
	@FindBy(xpath = "//label[.='first name']/../..//input")
	private WebElement firstName;

	// Last Name
	@FindBy(xpath = "//label[.='last name']/../..//input")
	private WebElement lastName;

	// Calender Select Date
	@FindBy(xpath = "//div[. ='DD']")
	private WebElement selectDate;

	// Calender Select Month
	@FindBy(xpath = "//div[. ='MM']")
	private WebElement selectMonth;

	// Calender Select Year
	@FindBy(xpath = "//div[. ='YYYY']")
	private WebElement selectYear;

	// Select the Gender
	@FindBy(xpath = "//label[.='gender']/../..//div[@class='react-select-formV2__value-container react-select-formV2__value-container--has-value css-1hwfws3']")
	private WebElement selectGender;

	// Select the Gender Male adult 1
	@FindBy(id = "react-select-7-option-0")
	private WebElement selectMaleAdult1;

	// Select the Gender Male adult 2
	@FindBy(id = "react-select-11-option-0")
	private WebElement selectMaleAdult2;

	// Click Confirm btn
	@FindBy(xpath = "//button[@data-testid='add-traveller']")
	private WebElement selectConfirmBtn;

	// Click on Adult 2
	@FindBy(xpath = "//span[.='ADULT - 2']")
	private WebElement selectAdult2;

	// Enter Mail id
	@FindBy(xpath = "//label[.='email']/../..//input")
	private WebElement emailId;

	// Selct the Mobile Code
	@FindBy(xpath = "//label[.='mobile code']/../..//div[@class='react-select-formV2__value-container react-select-formV2__value-container--has-value css-1hwfws3']")
	private WebElement mobileCodeClick;

	// Select the Mobile Code Checkbox
	@FindBy(xpath = "//div[.='India (+91)']")
	private WebElement mobileCodeCheckbox;

	// Enter Mobile No
	@FindBy(xpath = "//label[.='mobile']/../..//input")
	private WebElement mobileNo;

	// Select the Gst Code Checkbox
	@FindBy(xpath = "react-select-3-input")
	private WebElement gstCodeClick;

	// Enter the Gst code
	@FindBy(xpath = "//div[.='Kerala' and @data-testid='dropdown-option-Kerala']")
	private WebElement gstCodeCheckbox;

	// Click on Proceed to Payment
	@FindBy(xpath = "//span[.='Proceed To Payments']")
	private WebElement paymentProceed;

	// Getters and setters of Add Traveller -> Click
	public WebElement getAddTravellerBtn() {
		return addTravellerBtn;
	}

	public void clickAddTravellerBtn() {
		getAddTravellerBtn().click();
	}

	// Getters and setters of First Name
	public WebElement getFirstName() {
		return firstName;
	}

	public void configFirstName(String fname) {
		getFirstName().sendKeys(fname);
	}

	// Getters and setters of First Name
	public WebElement getLastName() {
		return lastName;
	}

	public void configLastName(String lname) {
		getLastName().sendKeys(lname);
	}

	// Getters and setters of Calender Select Date
	public WebElement getSelectDate() {
		return selectDate;
	}

	public void configSelectDate(String date) {
		getSelectDate().sendKeys(date);
	}

	// Getters and setters of Calender Select Month
	public WebElement getSelectMonth() {
		return selectMonth;
	}

	public void configSelectMonth(String month) {
		getSelectMonth().sendKeys(month);
	}

	// Getters and setters of Calender Select Month
	public WebElement getSelectYear() {
		return selectYear;
	}

	public void configSelectYear(String year) {
		getSelectYear().sendKeys(year);
	}

	// Getters and setters of Select the Gender
	public WebElement getSelectGender() {
		return selectGender;
	}

	public void clickSelectGender() {
		getSelectGender().click();
	}

	// Getters and setters of Select the Gender -> Male Adult 1
	public WebElement getSelectMaleAdult1() {
		return selectMaleAdult1;
	}

	public void clickSelectMaleAdult1() {
		getSelectMaleAdult1().click();
	}

	// Getters and setters of Select the Gender -> Male Adult 1
	public WebElement getSelectMaleAdult2() {
		return selectMaleAdult2;
	}

	public void clickSelectMaleAdult2() {
		getSelectMaleAdult2().click();
	}

	// Getters and setters of Click Confirm btn
	public WebElement getSelectConfirmBtn() {
		return selectConfirmBtn;
	}

	public void clickSelectConfirmBtn() {
		getSelectConfirmBtn().click();
	}

	// Getters and setter of Click on Adult 2
	public WebElement getSelectAdult2() {
		return selectAdult2;
	}

	public void clickSelectAdult2() {
		getSelectAdult2().click();
	}

	// Getters and setters of Email ID
	public WebElement getEmailId() {
		return emailId;
	}

	public void configEmailId(String email) {
		getEmailId().sendKeys(email);
	}

	// Getters and setters of Mobile Code Input Btn
	public WebElement getMobileCodeClick() {
		return mobileCodeClick;
	}

	public void clickMobileCodeClick() {
		getMobileCodeClick().click();
	}

	// Getters and setters of Mobile Code -> India (+91)
	public WebElement getMobileCodeCheckbox() {
		return mobileCodeCheckbox;
	}

	public void clickMobileCodeCheckbox() {
		getMobileCodeCheckbox().click();
	}

	// Getters and setters of Mobile Number
	public WebElement getMobileNo() {
		return mobileNo;
	}

	public void configMobileNo(String mobile) {
		getMobileNo().sendKeys(mobile);
	}

	// Getters and setters of Select the Gst Code Checkbox
	public WebElement getGstCodeClick() {
		return gstCodeClick;
	}

	public void configGstCodeClick(String gst) {
		getGstCodeCheckbox().sendKeys(gst);
	}

	// Getters and setters of Enter the Gst code
	public WebElement getGstCodeCheckbox() {
		return gstCodeCheckbox;
	}

	public void clickGstCodeCheckbox() {
		getGstCodeCheckbox().click();
	}

	// Getters and setters of Click on Proceed to Payment
	public WebElement getPaymentProceed() {
		return paymentProceed;
	}

	public void clickPaymentProceed() {
		getPaymentProceed().click();
	}

	// Methods -> Add Traveller
	public void travelerDetials() {
		clickAddTravellerBtn();
		configFirstName("Arun");
		configLastName("Kumar");
		configSelectDate("11");
		configSelectMonth("May");
		configSelectYear("2005");
		clickSelectGender();
		clickSelectMaleAdult1();
		clickSelectConfirmBtn();
		clickSelectAdult2();
		configFirstName("Arun");
		configLastName("Kumar");
		configSelectDate("11");
		configSelectMonth("May");
		configSelectYear("2005");
		clickSelectGender();
		clickSelectMaleAdult2();
		clickSelectConfirmBtn();
	}

	// Add all the details and proceed to payment
	public void travelerAddInfo() {
		travelerDetials();
		configEmailId("arun@gmail.com");
		clickMobileCodeClick();
		clickMobileCodeCheckbox();
		configMobileNo("1234567890");
		configGstCodeClick("Kerala");
		clickGstCodeCheckbox();
		clickPaymentProceed();
	}

}
