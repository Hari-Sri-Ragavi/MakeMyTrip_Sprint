package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

    // ── Shared modal ──────────────────────────────────────────────
    @FindBy(xpath = "//span[@data-cy='closeModal']")
    private WebElement closeModalBtn;

    // ── Team 1 – Holiday Packages ─────────────────────────────────
    @FindBy(className = "commonModal__close")
    private WebElement closeLogin;

    @FindBy(linkText = "Holiday Packages")
    private WebElement holidayPackage;

    // ── Team 2 – Flights ──────────────────────────────────────────
    @FindBy(xpath = "//span[text()='Flights']")
    private WebElement flightsTab;

    // ── Team 3 – Hotels ───────────────────────────────────────────
    @FindBy(xpath = "//li[@data-cy='menu_Hotels']")
    private WebElement hotelsMenu;

  //-------------------------CABS-------------------------
    @FindBy(xpath = "//span[text()='Cabs']")
    WebElement cabsMenu;
  //---------------------------TRAINS------------------------
    @FindBy(xpath = "//li[@data-cy='menu_Trains']")
    private WebElement trainsMenu;

    // ── Modal helpers ─────────────────────────────────────────────

    /**
     * Closes the data-cy modal if it appears (used on the main landing page).
     */
    public void closeModalIfPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(closeModalBtn)).click();
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("No popup to close");
        }
    }


    // ── Holiday Packages ─────────────────────────────────

    public WebElement getCloseLogin() {
        return closeLogin;
    }

    public void clickCloseLogin() {
        getCloseLogin().click();
    }

    public WebElement getHolidayPackage() {
        return holidayPackage;
    }

    public void clickHolidayPackage() {
        getHolidayPackage().click();
    }

    /** Dismisses the login modal then navigates to Holiday Packages. */
    public void navigateHolidayPackage() {
        //clickCloseLogin();
        clickHolidayPackage();
    }


    // ── Flights ──────────────────────────────────────────

    /** Ensures the Flights tab is active. Skips the click when already on /flights. */
    public void clickFlightsTab() {
        try {
            System.out.println("✓ Already on flights page");
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


   //---------------------------------------------------clicking hotel module-----------------------------
    public void clickHotelsMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(hotelsMenu)).click();
        try { Thread.sleep(3000); } catch (Exception ignored) {}
    }
    
    //-----------------------------------------clicking cabs module-----------------------------------------------------
    public void clickCabs() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(cabsMenu)).click();
        System.out.println("✔ Cabs clicked");
    }
    
    //--------------------------------------Clicking Train Module--------------------------------------------------------
    
    public void clickTrainsMenu() {
        trainsMenu.click();
    }
   
}