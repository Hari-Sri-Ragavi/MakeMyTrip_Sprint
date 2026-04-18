////package pages;
////
////import org.openqa.selenium.*;
////import org.openqa.selenium.interactions.Actions;
////import org.openqa.selenium.support.ui.*;
////
////import java.time.Duration;
////
////public class TripDetailsPage {
////
////    WebDriver driver;
////    WebDriverWait wait;
////
////    public TripDetailsPage(WebDriver driver) {
////        this.driver = driver;
////        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
////    }
////
////    public void enterFromCity(String city) {
////
////        // 👉 CLICK "From" field (Mumbai box)
////        WebElement from = wait.until(ExpectedConditions.elementToBeClickable(
////                By.xpath("//span[text()='From']/following::p[1]")));
////
////        from.click();
////
////        // 👉 TYPE
////        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(
////                By.xpath("//input[@type='text']")));
////
////        input.clear();
////        input.sendKeys(city);
////
////        // 👉 SELECT CITY (POPULAR LIST)
////        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
////                By.xpath("//p[normalize-space()='" + city + "']")));
////
////        option.click();
////
////        System.out.println("✔ From city selected");
////    }
////    // TO
////    public void enterToCity(String city) {
////
////        WebElement to = wait.until(ExpectedConditions.elementToBeClickable(
////                By.xpath("(//p[contains(@class,'blackText')])[2]")));
////
////        to.click();
////
////        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(
////                By.xpath("//input[@type='text']")));
////
////        input.clear();
////        input.sendKeys(city);
////
////        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
////                By.xpath("//p[normalize-space()='" + city + "']")));
////
////        option.click();
////
////        System.out.println("✔ To city selected: " + city);
////    }
////    // DATE
////    public void selectDate() {
////
////        wait.until(ExpectedConditions.elementToBeClickable(
////                By.xpath("//span[contains(text(),'Departure')]"))).click();
////
////        wait.until(ExpectedConditions.elementToBeClickable(
////                By.xpath("(//p[@class='dateInnerCell'])[1]"))).click();
////
////        System.out.println("✔ Date selected");
////    }
////
////    // SEARCH
//////    public void clickSearch() {
//////
//////        WebElement searchBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
//////                By.xpath("//a[text()='Search']")));
//////
//////        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchBtn);
//////
//////        System.out.println("✔ Search clicked (JS)");
//////    }
//////   
////    public void clickSearch() {
////        wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
////    }
////}
////   
////}
//package pages;
//import org.openqa.selenium.*;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.*;
//import org.openqa.selenium.support.ui.*;
//import java.time.Duration;
//
//public class TripDetailsPage {
//    WebDriver driver;
//    WebDriverWait wait;
//
//    public TripDetailsPage(WebDriver driver) {
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        PageFactory.initElements(driver, this);
//    }
//
//    // ─── LOCATORS ────────────────────────────────────────────
//    @FindBy(xpath = "//span[text()='From']/following::p[1]")
//    private WebElement fromField;
//
//    @FindBy(xpath = "//input[@type='text']")
//    private WebElement cityInput;
//
//    @FindBy(xpath = "//span[contains(text(),'Departure')]")
//    private WebElement departureField;
//
//    @FindBy(xpath = "(//p[@class='dateInnerCell'])[1]")
//    private WebElement firstDate;
//
//    // ✅ SEARCH BUTTON - correct locator for MakeMyTrip cabs
//    @FindBy(xpath = "//a[contains(@class,'primaryBtn') and contains(text(),'Search')]")
//    private WebElement searchBtn;
//
//    // ─── METHODS ─────────────────────────────────────────────
//    public void enterFromCity(String city) {
//        wait.until(ExpectedConditions.elementToBeClickable(fromField)).click();
//        WebElement input = wait.until(ExpectedConditions.visibilityOf(cityInput));
//        input.clear();
//        input.sendKeys(city);
//        wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//p[normalize-space()='" + city + "']"))).click();
//        System.out.println("✔ From city selected: " + city);
//    }
//
//    public void enterToCity(String city) {
//        WebElement to = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("(//p[contains(@class,'blackText')])[2]")));
//        to.click();
//        WebElement input = wait.until(ExpectedConditions.visibilityOf(cityInput));
//        input.clear();
//        input.sendKeys(city);
//        wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//p[normalize-space()='" + city + "']"))).click();
//        System.out.println("✔ To city selected: " + city);
//    }
//
//    public void selectDate() {
//        wait.until(ExpectedConditions.elementToBeClickable(departureField)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(firstDate)).click();
//        System.out.println("✔ Date selected");
//    }
//
//    // ✅ FIXED clickSearch()
//    public void clickSearch() {
//        wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
//        System.out.println("✔ Search clicked");
//    }
//}
package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.List;

public class TripDetailsPage {
    WebDriver driver;
    WebDriverWait wait;

    public TripDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    // ─── LOCATORS ─────────────────────────────────────────────

    // FROM city box (shows "Mumbai")
    @FindBy(xpath = "//div[label[text()='From']]//p | //p[contains(@class,'blackText') and contains(text(),'Mumbai')]")
    private WebElement fromField;

    // TO city box (shows "Pune")
    @FindBy(xpath = "//div[label[text()='To']]//p | //p[contains(@class,'blackText') and contains(text(),'Pune')]")
    private WebElement toField;

    // City search input (appears AFTER clicking From/To)
    @FindBy(xpath = "//input[contains(@placeholder,'city') or contains(@placeholder,'From') or contains(@placeholder,'Search')]")
    private WebElement citySearchInput;

    // Departure date button
    @FindBy(xpath = "//div[contains(@class,'Departure') or text()='Departure'] | //label[text()='Departure']/..")
    private WebElement departureField;

    // First available date in calendar
    @FindBy(xpath = "(//p[@class='dateInnerCell'])[1]")
    private WebElement firstDate;
    
@FindBy(xpath ="//span[@aria-label='Next Month']")
private WebElement nextMonthBtn;
//    // Search button
//    @FindBy(xpath = "//a[contains(@class,'primaryBtn')] | //button[contains(text(),'Search')] | //a[contains(text(),'Search')]")
//    private WebElement searchBtn;

    // ─── METHODS ──────────────────────────────────────────────

    public void enterFromCity(String city) {
        // Close calendar if open first
        try {
            driver.findElement(By.xpath("//body")).sendKeys(Keys.ESCAPE);
            Thread.sleep(500);
        } catch (Exception ignored) {}

        // Click the FROM city field
        WebElement from = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//div[contains(@class,'fromCity') or @data-cy='fromCity'] | //span[text()='From']/following::p[1]")));
        from.click();

        // Wait for city SEARCH INPUT (not date input)
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//input[not(@readonly) and not(@disabled) and (@placeholder or @type='text')]")));
        input.clear();
        input.sendKeys(city);

        // Select from dropdown suggestion
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//p[normalize-space()='" + city + "'] | //li[contains(.,'" + city + "')]"))).click();

        System.out.println("✔ From city selected: " + city);
    }

    public void enterToCity(String city) {
        WebElement to = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//div[contains(@class,'toCity') or @data-cy='toCity'] | (//p[contains(@class,'blackText')])[2]")));
        to.click();

        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//input[not(@readonly) and not(@disabled)]")));
        input.clear();
        input.sendKeys(city);

        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//p[normalize-space()='" + city + "'] | //li[contains(.,'" + city + "')]"))).click();

        System.out.println("✔ To city selected: " + city);
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

    
    @FindBy(xpath = "//a[contains(@data-cy, 'outstationSearchBtn')]")
    private WebElement searchBtn;
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
}