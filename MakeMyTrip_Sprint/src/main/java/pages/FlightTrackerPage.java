package pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

public class FlightTrackerPage {

    WebDriver driver;
    WebDriverWait wait;

    public FlightTrackerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Flight Tracker']")
    private WebElement flightTrackerOption;

    @FindBy(xpath = "//input[@placeholder='E.g. 6E413']")
    private WebElement flightNumberInput;

    @FindBy(xpath = "//button[contains(@class,'search')]")
    private WebElement searchButton;

    @FindBy(xpath = "//*[contains(text(),'Flights could not be found')]")
    private WebElement noFlightMessage;

    public void clickFlightTrackerOption() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(flightTrackerOption));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        System.out.println("Flight Tracker clicked");
    }

    public void waitForFlightTrackerPopup() {
    	wait.until(ExpectedConditions.visibilityOf(flightNumberInput));
    }

    public void enterFlightNumber(String flightNumber) {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(flightNumberInput));
        input.click();
        input.sendKeys(Keys.CONTROL + "a");
        input.sendKeys(Keys.DELETE);
        input.sendKeys(flightNumber);
    }

    public void clickTrackButton() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
    }

    public String getDerivedFlightStatus() {

        try {

            // wait for either result or timeout
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOf(searchButton),
                    ExpectedConditions.visibilityOf(noFlightMessage)
            ));

            if (noFlightMessage.isDisplayed()) {
                
                return "Invalid Flight";
            }

            return "Valid Flight";

        } catch (Exception e) {

            System.out.println("Fallback check");

            String page = driver.getPageSource().toLowerCase();

            if (page.contains("could not be found")) {
                return "Invalid Flight";
            }

            return "Valid Flight";
        }
    }
}