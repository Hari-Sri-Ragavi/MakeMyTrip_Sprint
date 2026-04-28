package pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class GiftCardSelectPage {

    WebDriver driver;
    WebDriverWait wait;

    public GiftCardSelectPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    // ---------------- WEBELEMENTS ----------------

    @FindBy(xpath = "//li[contains(@class,'menu_More')]")
    private WebElement moreMenu;

    @FindBy(xpath = "//a[@data-cy='submenu_Giftcards']")
    private WebElement giftCards;


    // ---------------- GETTERS ----------------

    public WebElement getMoreMenu() {
        return moreMenu;
    }

    public WebElement getGiftCards() {
        return giftCards;
    }


    // ---------------- ACTION METHODS ----------------

    // Hover on More menu
    public void hoverMoreMenu() {

        Actions actions = new Actions(driver);

        WebElement more = wait.until(
                ExpectedConditions.visibilityOf(getMoreMenu())
        );

        actions.moveToElement(more).pause(Duration.ofSeconds(1)).perform();

        System.out.println("More menu hovered");
    }

    // Click Gift Cards
    public void clickGiftCards() {

        WebElement gift = wait.until(
                ExpectedConditions.elementToBeClickable(getGiftCards())
        );

        gift.click();

        System.out.println("Gift Cards clicked");
    }

    // Verify page opened
    public boolean isGiftPageOpened() {

        return driver.getCurrentUrl().contains("gift-cards");
    }
}