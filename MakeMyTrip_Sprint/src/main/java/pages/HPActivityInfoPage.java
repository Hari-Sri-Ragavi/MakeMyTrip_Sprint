package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HPActivityInfoPage {

	WebDriver driver;

	public HPActivityInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Skip Ad
	@FindBy(xpath = "//BUTTON[.='SKIP']")
	private WebElement skipGuide;

	// Close the Quote
	@FindBy(xpath = "//div[@id = 'modalpopup']//span[@class='close closeIcon']")
	private WebElement closeQuote;

	// Change hotel -> Click

	// Select the hotel -> Click
	@FindBy(xpath = "//span[. = 'Select']")
	private WebElement selectRestaurent;

	// Update Button -> Click
	@FindBy(id = "updateHotelBtnClick")
	private WebElement updateRestaurent;

	//Remove the activity 
	@FindBy(xpath = "//span[. = 'Remove']")
	private WebElement removeActivity;
	
	//Confirm Remove
	@FindBy(xpath = "//button[. = 'YES, REMOVE']")
	private WebElement confirmRemove;
	
	// Payment proceed -> Click
	@FindBy(xpath = "//span[. = 'PROCEED TO PAYMENT']")
	private WebElement proceedPayment;
	

	// Getters and setters of Skip Ad
	public WebElement getSkipGuide() {
		return skipGuide;
	}

	public void clickSkipGuide() {
		getSkipGuide().click();
	}

	// Getters and setters of Close the Quote
	public WebElement getCloseQuote() {
		return closeQuote;
	}

	public void clickCloseQuote() {
		getCloseQuote().click();
	}

	//Getters and setters of Remove Activity
	public WebElement getRemoveActivity() {
		return removeActivity;
	}

	public void clickRemoveActivity() {
		getRemoveActivity().click();
	}

	//Getters and setters of Confirm Action
	public WebElement getConfirmRemove() {
		return confirmRemove;
	}

	public void clickConfirmRemove() {
		getConfirmRemove().click();
	}

	// Getters and setters of Change hotel -> Click
	public WebElement getChangeRestaurent(String place) {
		WebElement changeRestaurent = driver.findElement(By.xpath("//span[. ='" + place + "']/../../..//span[.= 'Change']"));
		return changeRestaurent;
	}

	public void clickChangeRestaurent(String place) {
		getChangeRestaurent(place).click();
	}

	// Getters and setters of Select the hotel -> Click
	public WebElement getSelectRestaurent() {
		return selectRestaurent;
	}

	public void clickSelectRestaurent() {
		getSelectRestaurent().click();
	}

	// Getters and setters of Update Button -> Click
	public WebElement getUpdateRestaurent() {
		return updateRestaurent;
	}

	public void clickUpdateRestaurent() {
		getUpdateRestaurent().click();
	}

	// Getters and setters of Payment proceed -> Click
	public WebElement getProceedPayment() {
		return proceedPayment;
	}

	public void clickProceedPayment() {
		getProceedPayment().click();
	}


//	// Methods -> Select the activity Edit
//	public void selectActivityInfo() {
//		clickSkipGuide();
//		clickCloseQuote();
//		clickChangeRestaurent();
//		clickSelectRestaurent();
//		clickUpdateRestaurent();
//		clickProceedPayment();
//	}

}
