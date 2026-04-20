package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class SelectOccasionPage {

    WebDriver driver;
    WebDriverWait wait;

    public SelectOccasionPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[text()='Occasions']")
    WebElement occasionTab;

    @FindBy(xpath = "//h3[contains(@class,'lato-black')]")
    List<WebElement> giftCardsList;

    // click occasion
    public void selectGiftOccasion() {

        wait.until(ExpectedConditions.elementToBeClickable(occasionTab)).click();

        System.out.println("Occasion selected");
    }

    // select 2nd gift card
    public void selectGiftCard() {

        WebDriverWait localWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        List<WebElement> cards = localWait.until(
                ExpectedConditions.visibilityOfAllElements(giftCardsList)
        );

        System.out.println("Total gift cards found: " + cards.size());

        // click FIRST card (safe)
        cards.get(0).click();

        System.out.println("Gift card selected");
    }

    // validate detail page
    public boolean isGiftDetailPageDisplayed() {

        return driver.getCurrentUrl().contains("gift-card");
    }
}