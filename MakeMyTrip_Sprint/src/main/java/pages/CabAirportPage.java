package pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class CabAirportPage {

    WebDriver driver;
    WebDriverWait wait;

    public CabAirportPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    // AIRPORT TAB
    @FindBy(xpath = "//li[contains(@data-cy,'airport')]")
    WebElement airportTab;

    // FROM
    @FindBy(xpath = "//label[@for='fromCity']")
    WebElement fromLabel;

    @FindBy(xpath = "//input[contains(@placeholder,'From')]")
    WebElement fromInput;

    // TO
    @FindBy(xpath = "//input[contains(@placeholder,'To')]")
    WebElement toInput;

    // SUGGESTION (COMMON for both)
    @FindBy(xpath = "//div[contains(@class,'suggestion')]//p")
    WebElement firstSuggestion;

    // SEARCH
    @FindBy(xpath = "//a[contains(text(),'Search')]")
    WebElement searchBtn;

    // ERROR
    @FindBy(xpath = "//*[contains(text(),'same location') or contains(text(),'same')]")
    WebElement errorMsg;


    public void clickAirportTab() {

        wait.until(ExpectedConditions.elementToBeClickable(airportTab));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", airportTab);

        wait.until(ExpectedConditions.visibilityOf(fromLabel));
    }


    public void enterSameLocation(String place) {

        fromLabel.click();

        wait.until(ExpectedConditions.visibilityOf(fromInput)).sendKeys(place);

        wait.until(ExpectedConditions.elementToBeClickable(firstSuggestion)).click();

        wait.until(ExpectedConditions.visibilityOf(toInput)).sendKeys(place);

        wait.until(ExpectedConditions.elementToBeClickable(firstSuggestion)).click();

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", searchBtn);
    }
    public void clickSearch() {

        wait.until(ExpectedConditions.visibilityOf(searchBtn));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", searchBtn);

        System.out.println("Search clicked");
    }

    public String getErrorMessage() {

        try {
            return wait.until(ExpectedConditions.visibilityOf(errorMsg)).getText();
        } catch (Exception e) {
            return driver.getCurrentUrl();
        }
    }
}