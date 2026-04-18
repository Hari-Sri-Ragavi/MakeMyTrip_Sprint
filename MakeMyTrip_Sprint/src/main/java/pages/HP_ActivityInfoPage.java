package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HP_ActivityInfoPage {

	// Skip Ad
	@FindBy(xpath = "//BUTTON[.='SKIP']")
	private WebElement skipGuide;

	// Close the Quote
	@FindBy(xpath = "//div[@id = 'modalpopup']//span[@class='close closeIcon']")
	private WebElement closeQuote;

	// Change hotel -> Click
	@FindBy(xpath = "//span[. ='HOTEL']/../../..//span[.= 'Change']")
	private WebElement changeRestaurent;

	// Select the hotel -> Click
	@FindBy(xpath = "//h3[. ='Casino Hotel - CGH Earth, Cochin']/../..//span[.='Select']")
	private WebElement selectRestaurent;

	// Update Button -> Click
	@FindBy(id = "updateHotelBtnClick")
	private WebElement updateRestaurent;

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

	// Getters and setters of Change hotel -> Click
	public WebElement getChangeRestaurent() {
		return changeRestaurent;
	}

	public void clickChangeRestaurent() {
		getChangeRestaurent().click();
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

	// Methods -> Select the activity Edit
	public void selectActivityInfo() {
		clickSkipGuide();
		clickCloseQuote();
		clickChangeRestaurent();
		clickSelectRestaurent();
		clickUpdateRestaurent();
		clickProceedPayment();
	}

}
