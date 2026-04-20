package pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class FlightTrackerPage {

    WebDriver driver;
    WebDriverWait wait;

    public FlightTrackerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    private final By flightTrackerOption = By.xpath("//span[text()='Flight Tracker']");
    private final By flightNumberInput = By.xpath("//input[@placeholder='E.g. 6E413']");
    private final By searchButton = By.xpath("//button[contains(@class,'search')]");


    private final By flightDetailsHeader =
            By.xpath("//h1[contains(text(),'Flight Status for')]");

    private final By noFlightMessage =
            By.xpath("//*[contains(text(),'Flights could not be found')]");

    public void clickFlightTrackerOption() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(flightTrackerOption));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        System.out.println("Flight Tracker clicked");
    }

    public void waitForFlightTrackerPopup() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(flightNumberInput));
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
          
            wait.until(driver ->
                    driver.findElements(noFlightMessage).size() > 0 ||
                    driver.getPageSource().length() > 0
            );

          
            if (!driver.findElements(noFlightMessage).isEmpty()) {
                System.out.println("Invalid Flight detected");
                return "Invalid Flight";
            }

            
            System.out.println(" Valid Flight (no error message)");
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