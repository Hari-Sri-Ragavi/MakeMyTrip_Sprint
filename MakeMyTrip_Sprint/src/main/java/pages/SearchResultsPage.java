package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class SearchResultsPage {

    WebDriver driver;
    WebDriverWait wait;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public boolean verifyResults() {

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(@class,'listingCard')]")));

            List<WebElement> cabs = driver.findElements(
                    By.xpath("//div[contains(@class,'listingCard')]"));

            return cabs.size() > 0;

        } catch (Exception e) {
            return false;
        }
    }
}