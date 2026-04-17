package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import util.AllFunctionalities;

public class FlightSearchPage {

    WebDriver driver;
    WebDriverWait wait;

    public FlightSearchPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    // ===== LOCATORS =====

    @FindBy(xpath = "//li[@data-cy='menu_Flights']")
    private WebElement flightsMenu;

    @FindBy(id = "fromCity")
    private WebElement fromCity;

    @FindBy(xpath = "//input[@placeholder='From']")
    private WebElement fromInput;

    @FindBy(id = "toCity")
    private WebElement toCity;

    @FindBy(xpath = "//input[@placeholder='To']")
    private WebElement toInput;

    @FindBy(xpath = "//span[text()='Departure']")
    private WebElement departureField;

    @FindBy(xpath = "//span[@aria-label='Next Month']")
    private WebElement nextMonthBtn;

    @FindBy(xpath = "//a[contains(@class,'primaryBtn') and contains(text(),'Search')]")
    private WebElement searchBtn;

    // ===== ACTIONS =====

    public void clickFlightsMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(flightsMenu)).click();
    }

    public void enterSource(String city) {
        wait.until(ExpectedConditions.elementToBeClickable(fromCity)).click();
        WebElement input = wait.until(ExpectedConditions.visibilityOf(fromInput));
        input.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        input.sendKeys(city);
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[contains(@role,'option')]//p[contains(text(),'" + city + "')]")))
                .click();
    }

    public void enterDestination(String city) {
        wait.until(ExpectedConditions.elementToBeClickable(toCity)).click();
        WebElement input = wait.until(ExpectedConditions.visibilityOf(toInput));
        input.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        input.sendKeys(city);
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[contains(@role,'option')]//p[contains(text(),'" + city + "')]")))
                .click();
    }

    public void selectDate(String month, String day) {
        wait.until(ExpectedConditions.elementToBeClickable(departureField)).click();

        while (true) {
            List<WebElement> months = wait.until(
                    ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            By.className("DayPicker-Month")));

            for (WebElement m : months) {
                String title = m.findElement(By.className("DayPicker-Caption")).getText();

                if (title.toLowerCase().contains(month.toLowerCase())) {
                    WebElement date = m.findElement(
                            By.xpath(".//div[contains(@class,'dateInnerCell')]/p[text()='" + day + "']"));
                    date.click();
                    return;
                }
            }
            wait.until(ExpectedConditions.elementToBeClickable(nextMonthBtn)).click();
        }
    }

    public void clickSearch() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchBtn);
        System.out.println("Search clicked");
        
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[contains(@class,'listingCard')]")));
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Select Airline (optional - skip if not needed)
    public void selectAirline() {
        try {
            // Scroll to see filters
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -300);");
            Thread.sleep(1000);
            
            List<WebElement> airlineCheckboxes = driver.findElements(By.xpath("//div[@class='filter-option']//input[@type='checkbox']"));
            
            if (airlineCheckboxes.size() > 0) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", airlineCheckboxes.get(0));
                System.out.println("Airline checkbox clicked");
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            System.out.println("Error selecting airline: " + e.getMessage());
        }
    }
    
    // Click View Prices
    public void clickViewPrices() {
        try {
            WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("(//span[contains(text(),'VIEW PRICES')])[1]")));
            
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);
            Thread.sleep(1000);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
            System.out.println("VIEW PRICES clicked");
            Thread.sleep(3000);
            
        } catch (Exception e) {
            System.out.println("Error clicking view prices: " + e.getMessage());
        }
    }

    // NEW METHOD: Select a fare option (SAVER, FLEXI PLUS, etc.)
    public void selectFareOption(String fareType) {
        try {
            // Wait for fare options to load
            Thread.sleep(2000);
            
            // Click on the fare option based on type
            String fareXpath = "//div[contains(@class,'fare-card') and contains(.,'" + fareType + "')]";
            WebElement fareOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(fareXpath)));
            
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fareOption);
            Thread.sleep(500);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", fareOption);
            System.out.println("Selected fare: " + fareType);
            Thread.sleep(2000);
            
        } catch (Exception e) {
            System.out.println("Error selecting fare option: " + e.getMessage());
            
            // Alternative: Click the first available fare option
            try {
                List<WebElement> fareOptions = driver.findElements(By.xpath("//div[contains(@class,'fare-card')]"));
                if (fareOptions.size() > 0) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", fareOptions.get(0));
                    System.out.println("Selected first available fare");
                    Thread.sleep(2000);
                }
            } catch (Exception e2) {
                System.out.println("No fare options found");
            }
        }
    }

    // UPDATED: Click Book Now - First select fare, then click book button
    public void clickBookNow() {
        try {
            // First, select the SAVER fare (or any available fare)
            selectFareOption("SAVER");
            
            // Then click the Book Now button
            Thread.sleep(2000);
            
            String[] bookNowLocators = {
                "//button[text()='BOOK NOW']",
                "//button[contains(text(),'Book Now')]",
                "//div[contains(@class,'fare-footer')]//button",
                "(//button[text()='BOOK NOW'])[1]",
                "//button[contains(@class,'bookNow')]"
            };
            
            WebElement btn = null;
            for (String locator : bookNowLocators) {
                try {
                    btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
                    if (btn != null && btn.isDisplayed()) {
                        System.out.println("Found Book Now button with: " + locator);
                        break;
                    }
                } catch (Exception e) {
                    // Continue
                }
            }
            
            if (btn != null) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);
                Thread.sleep(500);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
                System.out.println("Book Now clicked");
            } else {
                System.out.println("No Book Now button found");
            }
            
            Thread.sleep(3000);
            
        } catch (Exception e) {
            System.out.println("Error clicking book now: " + e.getMessage());
        }
    }

    // Alternative: Click Book Now for specific fare type
//    public void clickBookNowForFare(String fareType) {
//        try {
//            // Find the fare section and click its Book Now button
//            String fareSectionXpath = "//div[contains(@class,'fare-card') and contains(.,'" + fareType + "')]";
//            WebElement fareSection = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(fareSectionXpath)));
//            
//            WebElement bookNowBtn = fareSection.findElement(By.xpath(".//button[text()='BOOK NOW']"));
//            
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bookNowBtn);
//            Thread.sleep(1000);
//            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", bookNowBtn);
//            System.out.println("Book Now clicked for fare: " + fareType);
//            Thread.sleep(3000);
//            
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//    }

    // ===== BAGGAGE =====
    public void clickAddBaggage() {
        try {
            WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//button[contains(@data-test,\"component-add_btn\")]")));
            
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
            Thread.sleep(1000);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
            System.out.println("Add Baggage clicked");
            Thread.sleep(2000);
            
        } catch (Exception e) {
            System.out.println("Error clicking add baggage: " + e.getMessage());
        }
    }

    // ===== PRICE =====
    public String getTotalPrice() {
        try {
            WebElement priceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(@class,'fare-summary')]//span")));
            return priceElement.getText().replaceAll("[^0-9]", "");
        } catch (Exception e) {
            System.out.println("Error getting price: " + e.getMessage());
            return "0";
        }
    }
}