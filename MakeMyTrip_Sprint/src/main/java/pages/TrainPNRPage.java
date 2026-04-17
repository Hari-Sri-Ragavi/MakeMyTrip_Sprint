package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class TrainPNRPage {
	

	    WebDriver driver;
	    public TrainPNRPage(WebDriver driver)
	    {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	    
	 // Check PNR status button
	    @FindBy(xpath = "//span[@data-cy='checkPnrStatus']")
	    private WebElement checkPnrStatus;

	    // Enter PNR input box
	    @FindBy(xpath = "//input[@data-cy='enterPnr']")
	    private WebElement pnrInput;

	    // Check status button
	    @FindBy(xpath = "//a[@data-cy='checkStatusButton']")
	    private WebElement checkStatusBtn;
	    
	    //Print button
	   @FindBy(xpath=" //a[@data-cy='PNRSearchHeader_348' and text()='Print']")
	   private WebElement printButton;
	    
	    //******************GETTERS AND SETTERS************************//
	    
		public WebElement getCheckPnrStatus() {
			return checkPnrStatus;
		}

		public WebElement getPrintButton() {
			return printButton;
		}

		public void clickCheckPnrStatus() {
			getCheckPnrStatus().click();
		}

		public WebElement getPnrInput() {
			return pnrInput;
		}

		public void setPnrInput(String PNRNumber) {
			getPnrInput().sendKeys(PNRNumber);
		}

		public WebElement getCheckStatusBtn() {
			return checkStatusBtn;
		}

		public void clickCheckStatusBtn() {
			
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			 wait.until(ExpectedConditions.elementToBeClickable(checkStatusBtn));
			 checkStatusBtn.click();
		
		}
		
		//**************ACTIVITY METHODS**************************
		
		public void checkPNR(String PNRNumber)
		{
			
			setPnrInput(PNRNumber);
			clickCheckPnrStatus();
		}
		
		public boolean isCheckStatusButtonClickable() {
			String classAttribute = checkStatusBtn.getAttribute("class");
            if (classAttribute.contains("disabled") || classAttribute.contains("not-allowed")) {
                return false;
            }
            return true;
		}

		public boolean isCheckStatusButtonDisabled() {
		    return !checkStatusBtn.isEnabled();
		}
		
}
