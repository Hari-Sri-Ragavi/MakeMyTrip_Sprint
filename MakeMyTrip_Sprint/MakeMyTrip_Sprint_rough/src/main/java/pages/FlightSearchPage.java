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
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
        try {
            wait.until(ExpectedConditions.elementToBeClickable(flightsMenu)).click();
        } catch (Exception e) {
            System.out.println("Flights menu click failed, trying fallback...");
            driver.findElement(By.xpath("//span[text()='Back to Classic Search']")).click();
        }
    }
    
    // UPDATED: Works for ANY city with auto-suggestion
    public void enterSource(String city) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(fromCity)).click();
        WebElement input = wait.until(ExpectedConditions.visibilityOf(fromInput));
        input.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        input.sendKeys(city);
        
        // Wait for suggestions and click the matching one
        Thread.sleep(1500); // Small delay for suggestions to load
        
        List<WebElement> suggestions = driver.findElements(
            By.xpath("//li[contains(@role,'option')]//p[contains(text(),'" + city + "')] | " +
                     "//li[contains(@role,'option')]//span[contains(text(),'" + city + "')] | " +
                     "//li[contains(@class,'suggestion')]//*[contains(text(),'" + city + "')]")
        );
        
        if(suggestions.size() > 0) {
            wait.until(ExpectedConditions.elementToBeClickable(suggestions.get(0))).click();
        } else {
            // Fallback: Press Enter if no suggestion found
            input.sendKeys(Keys.ENTER);
        }
        
        System.out.println("Source entered: " + city);
    }

    // UPDATED: Works for ANY city with auto-suggestion
    public void enterDestination(String city) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(toCity)).click();
        WebElement input = wait.until(ExpectedConditions.visibilityOf(toInput));
        input.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        input.sendKeys(city);
        
        // Wait for suggestions and click the matching one
        Thread.sleep(1500);
        
        List<WebElement> suggestions = driver.findElements(
            By.xpath("//li[contains(@role,'option')]//p[contains(text(),'" + city + "')] | " +
                     "//li[contains(@role,'option')]//span[contains(text(),'" + city + "')] | " +
                     "//li[contains(@class,'suggestion')]//*[contains(text(),'" + city + "')]")
        );
        
        if(suggestions.size() > 0) {
            wait.until(ExpectedConditions.elementToBeClickable(suggestions.get(0))).click();
        } else {
            input.sendKeys(Keys.ENTER);
        }
        
        System.out.println("Destination entered: " + city);
    }

    // Enhanced date selection with better month handling
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
                            By.xpath(".//div[contains(@class,'dateInnerCell')]/p[text()='" + day + "'] | " +
                                     ".//div[contains(@class,'dateInnerCell')]/p[contains(text(),'" + day + "')]"));
                    date.click();
                    System.out.println("Date selected: " + month + " " + day);
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

    // Updated selectAirline with better error handling
    public void selectAirline() {
        try {
            Thread.sleep(5000);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 400);");
            Thread.sleep(2000);
            
            JavascriptExecutor js = (JavascriptExecutor) driver;
            
            // Try multiple airline names in sequence
            String[] airlines = {"Air India", "Akasa Air", "IndiGo"};
            
            for(String airline : airlines) {
                try {
                    js.executeScript(
                        "var labels = document.querySelectorAll('label, span, div, p');" +
                        "for(var i=0; i<labels.length; i++) {" +
                        "   if(labels[i].innerText && labels[i].innerText.trim() === '" + airline + "') {" +
                        "       var checkbox = labels[i].querySelector('input[type=\"checkbox\"]') || " +
                        "                      labels[i].previousElementSibling?.querySelector('input[type=\"checkbox\"]') || " +
                        "                      labels[i].parentElement?.querySelector('input[type=\"checkbox\"]') || " +
                        "                      labels[i].nextElementSibling?.querySelector('input[type=\"checkbox\"]');" +
                        "       if(checkbox) { checkbox.click(); console.log('Clicked: " + airline + "'); break; }" +
                        "   }" +
                        "}"
                    );
                    Thread.sleep(500);
                } catch(Exception e) {
                    // Continue to next airline
                }
            }
            System.out.println("Airline selection attempted");
            
        } catch(Exception e) {
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

    public void clickBookNow() {
        try {
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
                    if (btn != null) {
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

    // ===== BAGGAGE =====
    public void clickAddBaggage() {
        try {
            WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//button[contains(@data-test,'component-add_btn')]")));
            
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