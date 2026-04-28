package pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class CabReviewBookingPage {

    WebDriver driver;
    WebDriverWait wait;

    public CabReviewBookingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    // ---------------- WEBELEMENTS ----------------

    @FindBy(xpath = "//input[@type='number']")
    private WebElement mobile;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailid;

    @FindBy(xpath = "//button[contains(.,'PAY NOW')]")
    private WebElement payNow;

    @FindBy(xpath = "//*[contains(text(),'Please enter valid mobile number')]")
    private WebElement error;


    // ---------------- GETTERS ----------------

    public WebElement getMobile() {
        return mobile;
    }

    public WebElement getEmail() {
        return emailid;
    }

    public WebElement getPayNow() {
        return payNow;
    }

    public WebElement getError() {
        return error;
    }


    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }


    // ---------------- ACTION METHODS ----------------

    public void enterMobile(String num) {

        scrollDown();
        wait.until(ExpectedConditions.visibilityOf(getMobile()));

        getMobile().clear();
        getMobile().sendKeys(num);
    }

    public void enterEmail(String email) {

        scrollDown();
        wait.until(ExpectedConditions.visibilityOf(getEmail()));

        getEmail().clear();
        getEmail().sendKeys(email);
    }

    public void clickPayNow() {

        scrollDown();
        wait.until(ExpectedConditions.elementToBeClickable(getPayNow()));

        getPayNow().click();
    }
}


    // ---------------- POPUP ----------------

//    public void closePopupIfPresent() {
//
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//
//            WebElement closeBtn = wait.until(
//                    ExpectedConditions.visibilityOfElementLocated(
//                            By.xpath("//span[text()='×'] | //button[contains(@class,'close')]")
//                    )
//            );
//
//            closeBtn.click();
//            System.out.println("Popup closed");
//
//        } catch (Exception e) {
//            System.out.println("No popup present");
//        }
//    }
