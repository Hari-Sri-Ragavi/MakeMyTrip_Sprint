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

    // ================= AMOUNT =================
    @FindBy(xpath = "//li[contains(@data-cy,'suggestion')]")
    List<WebElement> amountList;

    // ================= SENDER DETAILS =================
    @FindBy(xpath = "//input[@name='senderName']")
    WebElement senderName;

    @FindBy(xpath = "//input[@data-cy='FormField_082' and @type='text']")
    WebElement senderEmail;

    @FindBy(xpath = "//input[@name='senderMobileNo']")
    WebElement senderMobile;

    public static final String filePath =
            System.getProperty("user.dir")
            + "/src/test/resources/testdata/MakeMyTripExcelData.xlsx";

    String sheetName = "sheet1";

    // ================= AMOUNT =================
    public void selectAmount() {

        wait.until(ExpectedConditions.visibilityOfAllElements(amountList));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (WebElement amt : amountList) {

            try {

                //  DIRECT SCROLL 
                js.executeScript("arguments[0].scrollIntoView(true);", amt);

                Thread.sleep(500);

                if (amt.isDisplayed() && amt.isEnabled()) {

                    js.executeScript("arguments[0].click();", amt);

                    System.out.println("Amount selected");
                    break;
                }

            } catch (Exception e) {
                js.executeScript("window.scrollBy(0,300)");
            }
        }
    }

    // ================= NAME =================
    public void enterName() throws Exception {

        excel.loadExcelFile(filePath, sheetName);

        String name = excel.getDataFromSingleCell(1, 0);

        wait.until(ExpectedConditions.visibilityOf(senderName));

        senderName.click();
        senderName.clear();
        senderName.sendKeys(name);

        System.out.println("Name entered: " + name);
    }

    // ================= EMAIL =================
    public void enterEmail() throws Exception {

    	excel.loadExcelFile(filePath, sheetName);

        String email = excel.getDataFromSingleCell(1, 1);

        WebElement emailField = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='senderEmailId']")
            )
        );

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

        mobileField.click();
        mobileField.clear();
        mobileField.sendKeys(mobile);

        System.out.println("Mobile entered: " + mobile);
    }
}