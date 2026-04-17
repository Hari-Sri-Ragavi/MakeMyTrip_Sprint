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

    @FindBy(xpath = "//input[@placeholder='Where do you want to stay?']")
    private WebElement cityInput;

    @FindBy(xpath = "//button[@id='hsw_search_button']")
    private WebElement searchBtn;


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


    // ── Team 1 – Holiday Packages ─────────────────────────────────

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
        clickCloseLogin();
        clickHolidayPackage();
    }


    // ── Team 2 – Flights ──────────────────────────────────────────

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


    // ── Team 3 – Hotels ───────────────────────────────────────────

    public void clickHotelsMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(hotelsMenu)).click();
        try { Thread.sleep(3000); } catch (Exception ignored) {}
    }

    public void enterCity(String city) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[contains(text(),'City, Property name or Location')]")))
            .click();

        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@placeholder='Where do you want to stay?']")));
        searchBox.click();
        searchBox.clear();
        searchBox.sendKeys(city);

        try { Thread.sleep(2000); } catch (Exception ignored) {}

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//p[text()='Chennai']")))
            .click();
    }

    public void clickSearch() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(),'Search')]")))
            .click();
    }

    public void selectDatesAndSearch() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try { Thread.sleep(2000); } catch (Exception ignored) {}

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//div[@aria-disabled='false'])[1]")))
            .click();

        try { Thread.sleep(1000); } catch (Exception ignored) {}

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//div[@aria-disabled='false'])[2]")))
            .click();

        try { Thread.sleep(2000); } catch (Exception ignored) {}

        WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[contains(.,'Search')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);

        try { Thread.sleep(5000); } catch (Exception ignored) {}
    }
}