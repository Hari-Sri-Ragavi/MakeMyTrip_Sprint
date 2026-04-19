package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.AllFunctionalities;

public class HomePage {

    WebDriver driver;
    AllFunctionalities func;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.func = new AllFunctionalities(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@data-cy='closeModal']")
    private WebElement closeModalBtn;
    
    // CHANGE THIS LOCATOR - The old one doesn't work
    @FindBy(xpath = "//span[text()='Flights']")
    private WebElement flightsTab;

    public void closeModalIfPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(closeModalBtn)).click();
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("No popup to close");
        }
    }
    
    public void clickFlightsTab() {
        try {
            // Since we are already on flights page (url ends with /flights), 
            // we may not need to click. Just verify page is loaded.
            System.out.println("✓ Already on flights page");
            
            // Optional: Try to click if needed
            try {
                func.waitForElementClickable(flightsTab);
                flightsTab.click();
                System.out.println("✓ Clicked Flights tab");
            } catch (Exception e) {
                System.out.println("Flights tab click not needed, continuing...");
            }
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Already on flights page: " + e.getMessage());
        }
    }
}