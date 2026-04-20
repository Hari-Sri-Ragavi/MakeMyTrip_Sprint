package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.Actions_Helper;

public class HPReviewPage {

	WebDriver driver;

	public HPReviewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// this.ahh = new Actions_Helper(driver);
	}

	// Verify the Review Page
	@FindBy(className = "reviewHead")
	private WebElement verifyReview;

	// Add Traveller -> Click
	@FindBy(xpath = "//p[@data-testid='add-traveller-btn-1']")
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
	@FindBy(xpath = "//div[contains(@id , 'option-0')]")
	private WebElement selectMaleAdult1;

	// Select the Gender Male adult 2
	@FindBy(xpath = "//div[contains(@id , 'option-0')]")
	private WebElement selectMaleAdult2;

	// Click Confirm btn
	@FindBy(xpath = "//button[@data-testid='add-traveller']")
	private WebElement selectConfirmBtn;

	// Click on Adult 2
	@FindBy(xpath = "//span[.='ADULT - 2']")
	private WebElement selectAdult2;

	//Click on Cancel btn
	@FindBy(xpath = "//span[@class = 'closeTravellerIcon']")
	private WebElement cancelAddDetail;
	
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
	@FindBy(id = "react-select-3-input")
	private WebElement gstCodeClick;

	// Enter the Gst code
	@FindBy(xpath = "//div[.='Kerala' and @data-testid='dropdown-option-Kerala']")
	private WebElement gstCodeCheckbox;

	// Click on Proceed to Payment
	@FindBy(xpath = "//span[.='Proceed To Payments']")
	private WebElement paymentProceed;

	//Verify the traveller added
	@FindBy(xpath = "//p[.= 'Profile Completed']")
	private WebElement verifyAddedTraveller;
	
	@FindBy(xpath = "//div[.='Add Insurance']")
	private WebElement verifyInsPage;
	
	@FindBy(xpath = "//span[@class ='reviewSprite BlueArrow pointer appendLeft40 down']")
	private WebElement clickAddOns;
	
	@FindBy(xpath = "//button[.='SELECT']")
	private WebElement selectAddOns;
	
	@FindBy(xpath = "//span[@class = 'font30 latoBlack appendRight5']")
	private WebElement oldPrice;
	
	@FindBy(xpath = "//span[@class = 'addonPriceDiff']")
	private WebElement insurancePrice;
	
	
	
	// Getters and setters of Verify Review
	public WebElement getVerifyReview() {
		return verifyReview;
	}

	public void clickVerifyReview() {
		getVerifyReview().click();
	}

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

	public void configSelectGender(String gender) {
		getSelectGender().sendKeys(gender);
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
		getGstCodeClick().sendKeys(gst);
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

	//Getters of Verify the traveller details added
	public WebElement getVerifyAddedTraveller() {
		return verifyAddedTraveller;
	}
	
	//Getters and setters of Cancel Add detail 
	public WebElement getCancelAddDetail() {
		return cancelAddDetail;
	}

	public void clickCancelAddDetail() {
		getCancelAddDetail().click();
	}

	//Getters and setters of verify Proceed payment
	public WebElement getVerifyInsPage() {
		return verifyInsPage;
	}

	public void clickVerifyInsPage() {
		getVerifyInsPage().click();
	}

	//Getters and setters of clicking addons
	public WebElement getClickAddOns() {
		return clickAddOns;
	}

	public void clickClickAddOns() {
		getClickAddOns().click();
	}

	//Getters and setters of selecting the addons
	public WebElement getSelectAddOns() {
		return selectAddOns;
	}

	public void clickSelectAddOns() {
		getSelectAddOns().click();
	}

	//Getters of OldPrice 
	public WebElement getOldPrice() {
		return oldPrice;
	}

	//Getters of addOns Price
	public WebElement getInsurancePrice() {
		return insurancePrice;
	}

	// Methods -> Add Traveller
	public void travelerDetials(String fname, String lname, String day, String month, String year, String gender) {
		configFirstName(fname);
		configLastName(lname);
		configSelectDate(day);
//		ahh.navigateDownDropdown(getSelectDate(), 5, 1);
		configSelectMonth(month);
		configSelectYear(year);
		configSelectGender(gender);
		clickSelectMaleAdult1();
		clickSelectConfirmBtn();
	}

	// Add all the details and proceed to payment
	public void travelerAddInfo() {
		configEmailId("arun@gmail.com");
		clickMobileCodeClick();
		clickMobileCodeCheckbox();
		configMobileNo("1234567890");
		configGstCodeClick("Kerala");
		clickGstCodeCheckbox();
		clickPaymentProceed();
	}
	
	public boolean isCheckStatusButtonClickable() {
		String classAttribute = getPaymentProceed().getAttribute("class");
        if (classAttribute.contains("disabled") || classAttribute.contains("not-allowed")) {
            return false;
        }
        return true;
	}


}
