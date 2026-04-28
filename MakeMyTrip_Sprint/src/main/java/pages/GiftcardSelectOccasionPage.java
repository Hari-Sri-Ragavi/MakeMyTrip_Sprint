package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class GiftcardSelectOccasionPage {

    WebDriver driver;
    WebDriverWait wait;

    public GiftcardSelectOccasionPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    // ---------------- WEBELEMENTS ----------------

    @FindBy(xpath = "//p[text()='Occasions']")
    private WebElement occasionTab;

    @FindBy(xpath = "//h3[contains(@class,'lato-black')]")
    private List<WebElement> giftCardsList;


    // ---------------- GETTERS ----------------

    public WebElement getOccasionTab() {
        return occasionTab;
    }

    public List<WebElement> getGiftCardsList() {
        return giftCardsList;
    }


    // ---------------- ACTION METHODS ----------------

    // Click Occasion tab
    public void selectGiftOccasion() {

        wait.until(ExpectedConditions.elementToBeClickable(getOccasionTab())).click();

        System.out.println("Occasion selected");
    }

    // Select first gift card
    public void selectGiftCard() {

        WebDriverWait localWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        List<WebElement> cards = localWait.until(
                ExpectedConditions.visibilityOfAllElements(getGiftCardsList())
        );

        System.out.println("Total gift cards found: " + cards.size());

        cards.get(0).click();   //  first card click

        System.out.println("Gift card selected");
    }

    // Verify detail page
    public boolean isGiftDetailPageDisplayed() {

        return driver.getCurrentUrl().contains("gift-card");
    }
}