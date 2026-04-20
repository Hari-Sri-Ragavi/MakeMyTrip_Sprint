package pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class ReviewBookingPage {

    WebDriver driver;
    WebDriverWait wait;

    public ReviewBookingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    // Mobile field (simple locator)
    @FindBy(xpath = "//input[@type='number']")
    WebElement mobile;

    // Pay Now button
    @FindBy(xpath = "//button[contains(.,'PAY NOW')]")
    WebElement payNow;

    // Error message
    @FindBy(xpath = "//*[contains(text(),'Please enter valid mobile number')]")
    WebElement error;

    // Scroll
    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void enterMobile(String num) {
        scrollDown();
        wait.until(ExpectedConditions.visibilityOf(mobile));
        mobile.clear();
        mobile.sendKeys(num);
    }

    public void clickPayNow() {
        scrollDown();
        wait.until(ExpectedConditions.elementToBeClickable(payNow));
        payNow.click();
    }

    public void closePopupIfPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            WebElement closeBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//span[text()='×'] | //button[contains(@class,'close')]")
            ));

            closeBtn.click();
            System.out.println("Popup closed");

        } catch (Exception e) {
            System.out.println("No popup present");
        }
    }
}
     