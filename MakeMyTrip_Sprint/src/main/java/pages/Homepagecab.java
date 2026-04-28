
package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class Homepagecab {

    WebDriver driver;
    WebDriverWait wait;

    public Homepagecab(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    // ---------------- WEBELEMENTS ----------------

    @FindBy(xpath = "//span[@data-cy='closeModal']")
    private WebElement popupClose;

    @FindBy(xpath = "//span[text()='Cabs']")
    private WebElement cabsMenu;


    // ---------------- GETTERS ----------------

    public WebElement getPopupClose() {
        return popupClose;
    }

    public WebElement getCabsMenu() {
        return cabsMenu;
    }


    // ---------------- ACTION METHODS ----------------

    // Close popup
    public void closePopup() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(getPopupClose())).click();
            System.out.println("Popup closed");
        } catch (Exception e) {
            System.out.println("No popup");
        }
    }

    // Click Cabs menu
    public void clickCabs() {
        wait.until(ExpectedConditions.elementToBeClickable(getCabsMenu())).click();
        System.out.println("Cabs clicked");
    }
}
