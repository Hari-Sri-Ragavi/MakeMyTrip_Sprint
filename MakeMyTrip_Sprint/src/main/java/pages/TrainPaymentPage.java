package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrainPaymentPage {
	WebDriver driver;
    WebDriverWait wait;
     public TrainPaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }
     
     @FindBy(xpath="//h3[text()='Scan to Pay']")
     private WebElement scanToPayHeader;
     
	 public WebElement getScanToPayHeader() {
		 return scanToPayHeader;
	 }

	 
     
	
	

}
