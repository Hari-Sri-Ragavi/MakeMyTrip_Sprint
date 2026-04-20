package pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class SelectGiftCardPage {

    WebDriver driver;
    WebDriverWait wait;

    public SelectGiftCardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[contains(@class,'menu_More')]")
    WebElement moreMenu;

    @FindBy(xpath = "//a[@data-cy='submenu_Giftcards']")
    WebElement giftCards;

    // HOVER (MANDATORY for MMT UI)
    public void hoverMoreMenu() {

        Actions actions = new Actions(driver);

        WebElement more = wait.until(
                ExpectedConditions.visibilityOf(moreMenu)
        );

        actions.moveToElement(more).pause(Duration.ofSeconds(1)).perform();

        System.out.println("More menu hovered");
    }

    public void clickGiftCards() {

        WebElement gift = wait.until(
                ExpectedConditions.elementToBeClickable(giftCards)
        );

        gift.click();

        System.out.println("Gift Cards clicked");
    }

    public boolean isGiftPageOpened() {
        return driver.getCurrentUrl().contains("gift-cards");
    }
}