
package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightTrackerPage {

    WebDriver driver;
    WebDriverWait wait;

    public FlightTrackerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Locators
    private final By flightStatusTab = By.xpath("//span[contains(text(),'Flight Status')]");
    private final By flightTrackerOption = By.xpath("//div[text()='Flight Tracker']");
    private final By flightTrackerLink = By.xpath("//span[text()='Flight Tracker']");
    private final By flightTrackerDiv = By.xpath("//div[contains(text(),'Flight Tracker')]");
    private final By flightNumberInput = By.xpath("//input[@placeholder='E.g. 6E413']");
    private final By searchButton = By.xpath("//button[@class=\"fis-search-button\"]");
    
    // Valid flight status locators
    private final By flightStatusText = By.xpath("//span[contains(text(),'EN ROUTE') or contains(text(),'On Time') or contains(text(),'Delayed') or contains(text(),'Landed') or contains(text(),'Departed')]");
    private final By enRouteStatus = By.xpath("//span[contains(text(),'EN ROUTE')]");
    private final By onTimeStatus = By.xpath("//span[contains(text(),'On Time')]");
    private final By delayedStatus = By.xpath("//span[contains(text(),'Delayed')]");
    private final By landedStatus = By.xpath("//span[contains(text(),'Landed')]");
    private final By departedStatus = By.xpath("//span[contains(text(),'Departed')]");
    
    // Invalid flight locators
    private final By invalidFlightMessage = By.xpath("//div[contains(text(),'No flights found') or contains(text(),'Invalid flight') or contains(text(),'No results found')]");
    private final By errorMessage = By.xpath("//*[contains(text(),'Invalid') or contains(text(),'No flights') or contains(text(),'not found')]");
    
    // Flight details locators
    private final By flightNumberDisplay = By.xpath("//div[contains(text(),'AI-') or contains(text(),'6E-')]");

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

    public void clickFlightTrackerOption() {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(flightTrackerOption));
            element.click();
            System.out.println("Flight Tracker clicked using text locator");
        } catch (Exception e1) {
            try {
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(flightTrackerLink));
                element.click();
                System.out.println("Flight Tracker clicked using span locator");
            } catch (Exception e2) {
                try {
                    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(flightTrackerDiv));
                    element.click();
                    System.out.println("Flight Tracker clicked using div locator");
                } catch (Exception e3) {
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
    }

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
        sleep(5000); // Wait for results to load
    }

    public void trackFlight(String flightNumber, String date) {
        clickFlightStatusTab();
        clickFlightTrackerOption();
        waitForFlightTrackerPopup();
        enterFlightNumber(flightNumber);
        clickTrackButton();
    }

    // Get flight status - handles both valid and invalid flights
    public String getFlightStatus() {
        try {
            Thread.sleep(3000); // Wait for page to load completely
            
            // Check for invalid flight first
            if (isInvalidFlight()) {
                return "Invalid Flight Number";
            }
            
            // Check for valid flight status
            return getValidFlightStatus();
            
        } catch (Exception e) {
            System.out.println("Error getting flight status: " + e.getMessage());
            return "Status Not Found";
        }
    }
    
    // Check if flight is invalid
    private boolean isInvalidFlight() {
        try {
            // Check for error messages
            if (!driver.findElements(invalidFlightMessage).isEmpty()) {
                String errorText = driver.findElement(invalidFlightMessage).getText();
                System.out.println("Error message found: " + errorText);
                return true;
            }
            
            if (!driver.findElements(errorMessage).isEmpty()) {
                String errorText = driver.findElement(errorMessage).getText();
                System.out.println("Error message found: " + errorText);
                return true;
            }
            
            // Check if flight number is not displayed (invalid flight)
            if (driver.findElements(flightNumberDisplay).isEmpty()) {
                // Check if page shows "No flights found"
                String pageSource = driver.getPageSource().toLowerCase();
                if (pageSource.contains("no flights") || pageSource.contains("invalid") || 
                    pageSource.contains("not found") || pageSource.contains("no results")) {
                    System.out.println("No flight information found on page");
                    return true;
                }
            }
            
            return false;
            
        } catch (Exception e) {
            System.out.println("Error checking invalid flight: " + e.getMessage());
            return false;
        }
    }
    
  
    private String getValidFlightStatus() {
        try {
        
            if (!driver.findElements(enRouteStatus).isEmpty()) {
                String status = driver.findElement(enRouteStatus).getText();
                System.out.println("Status found: " + status);
                return "EN ROUTE";
            }
        
            if (!driver.findElements(onTimeStatus).isEmpty()) {
                String status = driver.findElement(onTimeStatus).getText();
                System.out.println("Status found: " + status);
                return "On Time";
            }
            
            // Check for Delayed status
            if (!driver.findElements(delayedStatus).isEmpty()) {
                String status = driver.findElement(delayedStatus).getText();
                System.out.println("Status found: " + status);
                return "Delayed";
            }
            
            // Check for Landed status
            if (!driver.findElements(landedStatus).isEmpty()) {
                String status = driver.findElement(landedStatus).getText();
                System.out.println("Status found: " + status);
                return "Landed";
            }
            
            // Check for Departed status
            if (!driver.findElements(departedStatus).isEmpty()) {
                String status = driver.findElement(departedStatus).getText();
                System.out.println("Status found: " + status);
                return "Departed";
            }
          
            if (!driver.findElements(flightStatusText).isEmpty()) {
                String status = driver.findElement(flightStatusText).getText();
                System.out.println("General status found: " + status);
                return status;
            }
            
           
            String pageSource = driver.getPageSource().toUpperCase();
            if (pageSource.contains("EN ROUTE")) {
                return "EN ROUTE";
            } else if (pageSource.contains("ON TIME")) {
                return "On Time";
            } else if (pageSource.contains("DELAYED")) {
                return "Delayed";
            } else if (pageSource.contains("LANDED")) {
                return "Landed";
            } else if (pageSource.contains("DEPARTED")) {
                return "Departed";
            }
            
            return "Flight Found - Status Unknown";
            
        } catch (Exception e) {
            System.out.println("Error getting valid flight status: " + e.getMessage());
            return "Status Not Found";
        }
    }

    private void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}