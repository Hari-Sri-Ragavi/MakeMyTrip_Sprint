package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.AllFunctionalities;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Click on Login btn
	@FindBy(xpath = "//p[@data-cy='LoginHeaderText']")
	private WebElement loginBtn;

	// Login option - Mail id
	@FindBy(xpath = "//div[@class = 'nsm7Bb-HzV7m-LgbsSe-Bz112c']")
	private WebElement mailLogin;

	// Enter Email id
	@FindBy(xpath = "//input[@type = 'email']")
	private WebElement enterEmail;

	// Click on Next to do next
	@FindBy(xpath = "//span[.='Next']")
	private WebElement nextBtn;

	// Enter password
	@FindBy(xpath = "//input[@type ='password']")
	private WebElement enterPwd;

	// Click on continue btn
	@FindBy(xpath = "//span[.='Continue']")
	private WebElement continueBtn;

	// Close the option to login using mobile no
	@FindBy(css = ".mybizLoginClose")
	private WebElement closePhoneNoPopUp;

	@FindBy(xpath = "//span[.='T']")
	private WebElement verifyLogin;
	
	// Getters and setters of Click on Login btn
	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public void clickLoginBtn() {
		getLoginBtn().click();
	}

	// Getters and setters of Login option - Mail id
	public WebElement getMailLogin() {
		return mailLogin;
	}

	public void clickMailLogin() {
		getMailLogin().click();
	}

	// Getters and setters of Enter Email id
	public WebElement getEnterEmail() {
		return enterEmail;
	}

	public void configEnterEmail(String mail) {
		getEnterEmail().sendKeys(mail);
	}

	// Getters and setters of Click on Next to do next
	public WebElement getNextBtn() {
		return nextBtn;
	}

	public void clickNextBtn() {
		getNextBtn().click();
	}

	// Getters and setters of Enter password
	public WebElement getEnterPwd() {
		return enterPwd;
	}

	public void configEnterPwd(String pwd) {
		getEnterPwd().sendKeys(pwd);
	}

	// Getters and setters of Click on continue btn
	public WebElement getContinueBtn() {
		return continueBtn;
	}

	public void clickContinueBtn() {
		getContinueBtn().click();
	}

	// Getters and setters of Close the option to login using mobile no
	public WebElement getClosePhoneNoPopUp() {
		return closePhoneNoPopUp;
	}

	public void setClosePhoneNoPopUp() {
		getClosePhoneNoPopUp().click();
	}

	//Getters of verify login
	public WebElement getVerifyLogin() {
		return verifyLogin;
	}

	

}
