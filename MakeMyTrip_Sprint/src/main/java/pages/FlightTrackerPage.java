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

    // Locators
    private final By flightStatusTab = By.xpath("//span[contains(text(),'Flight Status')]");
    
    // Based on your screenshot, Flight Tracker is a text element
    private final By flightTrackerOption = By.xpath("//div[text()='Flight Tracker']");
    
    // Alternative locators for Flight Tracker
    private final By flightTrackerLink = By.xpath("//span[text()='Flight Tracker']");
    private final By flightTrackerDiv = By.xpath("//div[contains(text(),'Flight Tracker')]");
    
    private final By flightNumberInput = By.xpath("//input[@placeholder='E.g. 6E413']");
    
    private final By dateInput = By.xpath("//input[@placeholder='DD/MM/YYYY']");
    
    private final By searchButton = By.xpath("//button[text()='Search']");
    
    private final By flightStatusResult = By.xpath("//div[contains(@class,'flight-status')]");
    
    private final By errorMessage = By.xpath("//*[contains(text(),'Invalid') or contains(text(),'No flights')]");

    // Click Flight Status Tab
    public void clickFlightStatusTab() {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(flightStatusTab));
            element.click();
        } catch (Exception e) {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(flightStatusTab));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
        System.out.println("Flight Status tab clicked");
        sleep(1000);
    }

    // Click Flight Tracker Option - Multiple attempts with different locators
    public void clickFlightTrackerOption() {
        try {
            // Try first locator
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(flightTrackerOption));
            element.click();
            System.out.println("Flight Tracker clicked using text locator");
        } catch (Exception e1) {
            try {
                // Try second locator
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(flightTrackerLink));
                element.click();
                System.out.println("Flight Tracker clicked using span locator");
            } catch (Exception e2) {
                try {
                    // Try third locator
                    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(flightTrackerDiv));
                    element.click();
                    System.out.println("Flight Tracker clicked using div locator");
                } catch (Exception e3) {
                    // Last resort - find by text
                    WebElement element = driver.findElement(By.xpath("//*[text()='Flight Tracker']"));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
                    System.out.println("Flight Tracker clicked using JavaScript");
                }
            }
        }
        sleep(2000);
    }

    public void waitForFlightTrackerPopup() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(flightNumberInput));
        System.out.println("Popup loaded");
    }

    // Enter flight number
    public void enterFlightNumber(String flightNumber) {
        System.out.println("Flight: " + flightNumber);

        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(flightNumberInput));
        input.click();
        input.sendKeys(Keys.CONTROL + "a");
        input.sendKeys(Keys.DELETE);

        for (char c : flightNumber.toCharArray()) {
            input.sendKeys(String.valueOf(c));
            sleep(100);
        }

        System.out.println("Flight entered");
        sleep(500);
    }

    // Enter Date
    public void enterDate(String date) {
        System.out.println("Date: " + date);

        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(dateInput));
        input.click();
        input.sendKeys(Keys.CONTROL + "a");
        input.sendKeys(Keys.DELETE);
        input.sendKeys(date);

        System.out.println("Date entered");
        sleep(500);
    }

    // Click Search
    public void clickTrackButton() {
        try {
            WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);
            sleep(500);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
        } catch (Exception e) {
            WebElement btn = driver.findElement(searchButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
        }
        System.out.println("Search clicked");
        sleep(3000);
    }

    // Complete track flight method
    public void trackFlight(String flightNumber, String date) {
        clickFlightStatusTab();
        clickFlightTrackerOption();
        waitForFlightTrackerPopup();
        enterFlightNumber(flightNumber);
        enterDate(date);
        clickTrackButton();
    }

    // Wait for status to load
    public void waitForFlightStatusToLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(flightStatusResult));
        System.out.println("Status loaded");
    }

    // Get status
    public String getFlightStatus() {
        try {
            if (!driver.findElements(errorMessage).isEmpty()) {
                return "Invalid";
            }

            WebElement statusElem = wait.until(ExpectedConditions.visibilityOfElementLocated(flightStatusResult));
            String raw = statusElem.getText().toLowerCase();

            if (raw.contains("on time")) return "On Time";
            if (raw.contains("delayed")) return "Delayed";
            if (raw.contains("early")) return "Early Arrival";

            return raw;

        } catch (Exception e) {
            return "Status Not Found";
        }
    }

    // Sleep method
    private void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}