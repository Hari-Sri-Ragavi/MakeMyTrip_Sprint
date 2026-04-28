package pages;

import java.time.Duration;
import java.time.LocalDate;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.net.UrlChecker.TimeoutException;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class CABS_DetailsSelectPage {

    WebDriver driver;
    WebDriverWait wait;

    public CABS_DetailsSelectPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // ---------------- WEBELEMENTS ----------------

    @FindBy(css = "label[for='fromCity']")
    private WebElement fromCityLabel;

    @FindBy(xpath = "//input[@title='From']")
    private WebElement fromInput;

    @FindBy(xpath = "//input[@title='To']")
    private WebElement toInput;

    @FindBy(xpath = "//span[@aria-label='Next Month']")
    private WebElement nextMonthBtn;
   
    @FindBy(xpath = "//a[contains(@data-cy,'Outstation')]")
    private WebElement searchButton;


    // ---------------- GETTERS & ACTIONS ----------------

    // FROM CITY
    public WebElement getFromCityLabel() {
        return fromCityLabel;
    }

    public WebElement getFromInput() {
        return fromInput;
    }
    public WebElement getSearchButton() {
        return searchButton;
    }

    public void selectFromCity(String city) {

        getFromCityLabel().click();

        wait.until(ExpectedConditions.visibilityOf(getFromInput()));
        getFromInput().sendKeys(city);

        WebElement option = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//ul[@role='listbox']//li[contains(.,'" + city + "')]"))
        );

        option.click();
    }


    // TO CITY
    public WebElement getToInput() {
        return toInput;
    }

    public void selectToCity(String city) {

        wait.until(ExpectedConditions.visibilityOf(getToInput()));
        getToInput().sendKeys(city);
        
     // Dynamic autosuggestions appear after typing city, so @FindBy cannot be used.
     // Hence, dynamic By locator is used to select the matching option.

        WebElement option = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//ul[@role='listbox']//li[contains(.,'" + city + "')]"))
        );

        option.click();
    }


    // ---------------- DATE----------------

    public void selectTodayDate() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

        WebElement departure = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[text()='Departure']")
                )
        );
        departure.click();

        LocalDate today = LocalDate.now();
        String day = String.valueOf(today.getDayOfMonth());

        WebElement todayDate = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[contains(@class,'DayPicker-Day') and not(contains(@class,'disabled')) and text()='" + day + "']")
                )
        );

        todayDate.click();

        System.out.println("Selected today's date: " + day);
    }
    
    ///SEARCH
     public void clickSearchButton() {
    wait.until(ExpectedConditions.elementToBeClickable(getSearchButton()));
    getSearchButton().click();
}
  
     //Handle no cab Available Popup   
     public void handlePopup() {

    	    try {
    	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    	        WebElement okBtn = wait.until(
    	                ExpectedConditions.elementToBeClickable(
    	                        By.xpath("//span[normalize-space()='OKAY']/parent::button")
    	                )
    	        );

    	        okBtn.click();
    	        System.out.println("Popup handled");

    	    } catch (Exception e) {
    	        System.out.println("No popup present");
    	    }
    	}
     
}
    

