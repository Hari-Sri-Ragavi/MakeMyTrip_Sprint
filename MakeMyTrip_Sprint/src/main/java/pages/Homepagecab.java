
	package pages;

	import org.openqa.selenium.*;
	import org.openqa.selenium.support.*;
	import org.openqa.selenium.support.ui.*;

	import java.time.Duration;

	public class Homepagecab {

	    WebDriver driver;
	    WebDriverWait wait;

	    public Homepagecab(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	        PageFactory.initElements(driver, this);
	    }

	    @FindBy(xpath = "//span[@data-cy='closeModal']")
	    WebElement popupClose;

	    @FindBy(xpath = "//span[text()='Cabs']")
	    WebElement cabsMenu;

	    public void closePopup() {
	        try {
	            wait.until(ExpectedConditions.elementToBeClickable(popupClose)).click();
	            System.out.println("✔ Popup closed");
	        } catch (Exception e) {
	            System.out.println("No popup");
	        }
	    }

	    public void clickCabs() {
	        wait.until(ExpectedConditions.elementToBeClickable(cabsMenu)).click();
	        System.out.println("✔ Cabs clicked");
	    }
	}


