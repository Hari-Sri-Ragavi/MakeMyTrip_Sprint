package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelSearchPage {

    WebDriver driver;
    WebDriverWait wait;

    public HotelSearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[@data-cy='menu_Hotels']")
    WebElement hotelsMenu;

    @FindBy(xpath = "//input[@placeholder='Where do you want to stay?']")
    WebElement cityInput;

    @FindBy(xpath = "//button[contains(text(),'Search')]")
    WebElement searchBtn;

    public void clickHotelsMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(hotelsMenu)).click();
    }

    public void enterCity(String city) {

        wait.until(ExpectedConditions.visibilityOf(cityInput)).click();
        cityInput.sendKeys(city);

        WebElement option = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//ul//li[contains(.,'" + city + "')]"))
        );

        option.click();
    }

    public void clickSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
    }

   public void selectDatesAndSearch() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try { Thread.sleep(2000); } catch (Exception e) {}

        // Check-in
        WebElement checkIn = wait.until(
            ExpectedConditions.elementToBeClickable(
            org.openqa.selenium.By.xpath("(//div[@aria-disabled='false'])[1]"))
        );
        checkIn.click();

        try { Thread.sleep(1000); } catch (Exception e) {}

        // Check-out
        WebElement checkOut = wait.until(
            ExpectedConditions.elementToBeClickable(
            org.openqa.selenium.By.xpath("(//div[@aria-disabled='false'])[2]"))
        );
        checkOut.click();

        try { Thread.sleep(2000); } catch (Exception e) {}

        // Search button
        WebElement searchBtn = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
            org.openqa.selenium.By.xpath("//button[contains(.,'Search')]"))
        );

        ((org.openqa.selenium.JavascriptExecutor)driver)
            .executeScript("arguments[0].click();", searchBtn);

        try { Thread.sleep(5000); } catch (Exception e) {}
    }
}

