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
}