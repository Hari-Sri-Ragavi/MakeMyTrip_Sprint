//package pages;
//
//import java.time.Duration;
//import java.util.List;
//
//import org.openqa.selenium.*;
//import org.openqa.selenium.support.*;
//import org.openqa.selenium.support.ui.*;
//
//import util.ExcelReader;
//
//public class GiftCardBookingPage {
//
//    WebDriver driver;
//    WebDriverWait wait;
//    ExcelReader excel = new ExcelReader();
//
//    public GiftCardBookingPage(WebDriver driver) {
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
//        PageFactory.initElements(driver, this);
//    }
//
//    // ================= WEBELEMENTS =================
//
//    @FindBy(xpath = "//li[contains(@data-cy,'suggestion')]")
//    private List<WebElement> amountList;
//
//    @FindBy(xpath = "//input[@name='senderName']")
//    private WebElement senderName;
//
//    @FindBy(xpath = "//input[@data-cy='FormField_082' and @type='text']")
//    private WebElement senderEmail;
//
//    @FindBy(xpath = "//input[@name='senderMobileNo']")
//    private WebElement senderMobile;
//
//
//    public static final String filePath =
//            System.getProperty("user.dir")
//            + "/src/test/resources/testdata/MakeMyTripExcelData.xlsx";
//
//    String sheetName = "Cab";
//
//
//    // ================= GETTERS =================
//
//    public List<WebElement> getAmountList() {
//        return amountList;
//    }
//
//    public WebElement getSenderName() {
//        return senderName;
//    }
//
//    public WebElement getSenderEmail() {
//        return senderEmail;
//    }
//
//    public WebElement getSenderMobile() {
//        return senderMobile;
//    }
//
//
//    // ================= ACTION METHODS =================
//
//    // AMOUNT
//    public void selectAmount() {
//
//        wait.until(ExpectedConditions.visibilityOfAllElements(getAmountList()));
//
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//
//        for (WebElement amt : getAmountList()) {
//
//            try {
//                js.executeScript("arguments[0].scrollIntoView(true);", amt);
//                Thread.sleep(500);
//
//                if (amt.isDisplayed() && amt.isEnabled()) {
//
//                    js.executeScript("arguments[0].click();", amt);
//                    System.out.println("Amount selected");
//                    break;
//                }
//
//            } catch (Exception e) {
//                js.executeScript("window.scrollBy(0,900)");
//            }
//        }
//    }
//
//
//    // NAME
//    public void enterName() throws Exception {
//
//        excel.loadExcelFile(filePath, sheetName);
//        String name = excel.getDataFromSingleCell(1, 0);
//
//        wait.until(ExpectedConditions.visibilityOf(getSenderName()));
//
//        getSenderName().click();
//        getSenderName().clear();
//        getSenderName().sendKeys(name);
//
//        System.out.println("Name entered: " + name);
//    }
//
//
//    // EMAIL
//    public void enterEmail() throws Exception {
//
//        excel.loadExcelFile(filePath, sheetName);
//        String email = excel.getDataFromSingleCell(1, 1);
//
//        wait.until(ExpectedConditions.visibilityOf(getSenderEmail()));
//
//        getSenderEmail().click();
//        getSenderEmail().clear();
//        getSenderEmail().sendKeys(email);
//
//        System.out.println("Email entered: " + email);
//    }
//
//
//    // MOBILE
//    public void enterMobile() throws Exception {
//
//        excel.loadExcelFile(filePath, sheetName);
//        String mobile = excel.getDataFromSingleCell(1, 2);
//
//        wait.until(ExpectedConditions.visibilityOf(getSenderMobile()));
//
//        getSenderMobile().click();
//        getSenderMobile().clear();
//        getSenderMobile().sendKeys(mobile);
//
//        System.out.println("Mobile entered: " + mobile);
//    }
//}
package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import util.ExcelReader;

public class GiftCardBookingPage {

    WebDriver driver;
    WebDriverWait wait;
    ExcelReader excel = new ExcelReader();

    public GiftCardBookingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        PageFactory.initElements(driver, this);
    }

    // ================= WEBELEMENTS =================
    @FindBy(xpath = "//li[contains(@data-cy,'suggestion')]")
    private List<WebElement> amountList;

    @FindBy(xpath = "//input[@name='senderName']")
    private WebElement senderName;

    @FindBy(xpath = "//input[@data-cy='FormField_082' and @type='text']")
    private WebElement senderEmail;

    @FindBy(xpath = "//input[@name='senderMobileNo']")
    private WebElement senderMobile;


    public static final String filePath =
            System.getProperty("user.dir")
            + "/src/test/resources/testdata/MakeMyTripExcelData.xlsx";

    String sheetName = "Cab";


    // ================= GETTERS =================
    public List<WebElement> getAmountList() {
        return amountList;
    }

    public WebElement getSenderName() {
        return senderName;
    }

    public WebElement getSenderEmail() {
        return senderEmail;
    }

    public WebElement getSenderMobile() {
        return senderMobile;
    }


   
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
    }


    // ================= AMOUNT =================
    public void selectAmount() {

        wait.until(ExpectedConditions.visibilityOfAllElements(getAmountList()));

        for (WebElement amt : getAmountList()) {

            try {
                scrollToElement(amt);
                Thread.sleep(500);

                if (amt.isDisplayed() && amt.isEnabled()) {

                    amt.click();   // JS click remove (normal click ok)
                    System.out.println("Amount selected");
                    break;
                }

            } catch (Exception e) {
                ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)");
            }
        }
    }


    // ================= NAME =================
    public void enterName() throws Exception {

        excel.loadExcelFile(filePath, sheetName);
        String name = excel.getDataFromSingleCell(1, 0);

        scrollToElement(getSenderName());

        wait.until(ExpectedConditions.visibilityOf(getSenderName()));

        getSenderName().click();
        getSenderName().clear();
        getSenderName().sendKeys(name);

        System.out.println("Name entered: " + name);
    }


    // ================= EMAIL =================
    public void enterEmail() throws Exception {

        excel.loadExcelFile(filePath, sheetName);
        String email = excel.getDataFromSingleCell(1, 1);

        // dynamic locate
        
        //page reload may happen- DOM re-renders-element becomes stale sometimes so used dynamic
        WebElement emailField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input[@name='senderEmailId']")
                )
        );

        scrollToElement(emailField);

        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);

        System.out.println("Email entered: " + email);
    }


    // ================= MOBILE =================
    public void enterMobile() throws Exception {

        excel.loadExcelFile(filePath, sheetName);
        String mobile = excel.getDataFromSingleCell(1, 2);

        WebElement mobileField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input[@name='senderMobileNo']")
                )
        );

        scrollToElement(mobileField);

        mobileField.click();
        mobileField.clear();
        mobileField.sendKeys(mobile);

        System.out.println("Mobile entered: " + mobile);
    }
}
