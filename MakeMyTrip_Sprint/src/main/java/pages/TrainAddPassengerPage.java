package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.AllFunctionalities;

public class TrainAddPassengerPage {

    WebDriver driver;
    WebDriverWait wait;
    AllFunctionalities fun;

    public TrainAddPassengerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        fun = new AllFunctionalities(driver);
    }

    // ===========================
    // WebElements
    // ===========================

    @FindBy(xpath = "//div[@class='travellerHead']")
    private WebElement travellerHeader;

    @FindBy(xpath = "//h3[text()='Get full ticket fare refund on Cancellation']/../../..")
    private WebElement refundBox;

    @FindBy(xpath = "//p[text()='Pay fees on cancellation']")
    private WebElement refundOption;

    @FindBy(xpath = "//span[text()='Add Traveller']")
    private WebElement addTravellerBtn;

    @FindBy(xpath = "//span[text()='Add Traveller Information']")
    private WebElement addTravellerForm;

    @FindBy(xpath = "//label[text()='Name']/..//input")
    private WebElement travellerName;

    @FindBy(xpath = "//label[contains(.,'Age')]/..//input")
    private WebElement travellerAge;

    @FindBy(xpath = "//button[text()='Add']")
    private WebElement addBtn;

    @FindBy(xpath = "//div[@class='irctcWrapper']")
    private WebElement irctcBox;

    @FindBy(xpath = "//input[@id='irctcUserName']")
    private WebElement irctcInput;

    @FindBy(xpath = "//div[@id='mmt-irctc-modal']")
    private WebElement irctcModal;

    @FindBy(xpath = "//p[text()='USERNAME']/../input")
    private WebElement irctcUsername;

    @FindBy(xpath = "//label[contains(.,'my IRCTC password')]/..//input")
    private WebElement passwordCheckbox;

    @FindBy(xpath = "//span[text()='Email Id']/../..//input")
    private WebElement emailField;

    @FindBy(xpath = "//span[text()='Mobile Number']/../..//input")
    private WebElement mobileField;

    @FindBy(xpath = "//span[text()='Pay & Book Now']")
    private WebElement bookNowBtn;
    
    @FindBy(xpath="//button[@type='button']//span[text()='SAVE & CLOSE']")
    private WebElement saveAndCloseBtn;
    
    @FindBy(xpath="//button[@type='button']")
    private WebElement checkBtn;
   

    public WebElement getRefundBox() {
        return wait.until(ExpectedConditions.visibilityOf(refundBox));
    }
     
    public WebElement getRefundOption() {
        return wait.until(ExpectedConditions.visibilityOf(refundOption));
    }
     
    public WebElement getAddTravellerBtn() {
        return wait.until(ExpectedConditions.elementToBeClickable(addTravellerBtn));
    }
     
    public WebElement getAddTravellerForm() {
        return wait.until(ExpectedConditions.visibilityOf(addTravellerForm));
    }
     
    public WebElement getTravellerName() {
        return wait.until(ExpectedConditions.visibilityOf(travellerName));
    }
     
    public WebElement getTravellerAge() {
        return wait.until(ExpectedConditions.visibilityOf(travellerAge));
    }
     
    public WebElement getAddBtn() {
        return wait.until(ExpectedConditions.elementToBeClickable(addBtn));
    }
     
    public WebElement getGenderDropdown() {
        return wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//label[contains(.,'Gender')]/..//p")));
    }
     
    public WebElement getGenderOption(String gender) {
        return wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//span[text()='" + gender + "']")));
    }
     
    public WebElement getBerthDropdown() {
        return wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//label[contains(.,'Berth')]/..//p")));
    }
     
    public WebElement getBerthOption(String berth) {
        return wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//li//span[text()='" + berth + "']")));
    }
     
    public WebElement getIrctcBox() {
        return wait.until(ExpectedConditions.visibilityOf(irctcBox));
    }
     
    public WebElement getIrctcInput() {
        return wait.until(ExpectedConditions.elementToBeClickable(irctcInput));
    }
     
    public WebElement getIrctcModal() {
        return wait.until(ExpectedConditions.visibilityOf(irctcModal));
    }
     
    public WebElement getIrctcUsername() {
        return wait.until(ExpectedConditions.visibilityOf(irctcUsername));
    }
     
    public WebElement getCheckBtn() {
        return wait.until(ExpectedConditions.elementToBeClickable(checkBtn));
    }
     
    public WebElement getPasswordCheckbox() {
        return wait.until(ExpectedConditions.elementToBeClickable(passwordCheckbox));
    }
     
    public WebElement getSaveAndCloseBtn() {
        return wait.until(ExpectedConditions.elementToBeClickable(saveAndCloseBtn));
    }
     
    public WebElement getEmailField() {
        return wait.until(ExpectedConditions.visibilityOf(emailField));
    }
     
    public WebElement getMobileField() {
        return wait.until(ExpectedConditions.visibilityOf(mobileField));
    }
     
    public WebElement getStateInput() {
        return wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//p[text()='Select the State']/..//input")));
    }
     
    public WebElement getStateOption(String state) {
        return wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//li[text()='" + state + "']")));
    }
     
    public WebElement getBillingConfirmCheckbox() {
        return wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//p[text()='Confirm and save billing details to your profile']")));
    }
     
    public WebElement getBookNowBtn() {
        return wait.until(ExpectedConditions.elementToBeClickable(bookNowBtn));
    }
     
    // ===========================
    // Methods
    // ===========================

    public WebElement verifyTravellerPage() {
       return  wait.until(ExpectedConditions.visibilityOf(travellerHeader));
    }

    public void selectRefundOption() {
        wait.until(ExpectedConditions.visibilityOf(refundBox));
        fun.scrollToElement(refundBox);

        wait.until(ExpectedConditions.elementToBeClickable(refundOption));
        refundOption.click();
    }

    public void clickAddTraveller() {
        wait.until(ExpectedConditions.elementToBeClickable(addTravellerBtn));
        addTravellerBtn.click();

        wait.until(ExpectedConditions.visibilityOf(addTravellerForm));
    }

    public void addPassenger(String name, String age, String gender, String berth) {

        clickAddTraveller();

        wait.until(ExpectedConditions.visibilityOf(travellerName));
        travellerName.clear();
        travellerName.sendKeys(name);

        wait.until(ExpectedConditions.visibilityOf(travellerAge));
        travellerAge.clear();
        travellerAge.sendKeys(age);

        selectGender(gender);
        selectBerth(berth);
        
        addBtn.click();

        
    }

    public void selectGender(String gender) {

        WebElement genderDropdown = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//label[contains(.,'Gender')]/..//p")));
        genderDropdown.click();

        WebElement option = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[text()='" + gender + "']")));
        option.click();
    }

    public void selectBerth(String berth) {

        WebElement berthDropdown = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//label[contains(.,'Berth')]/..//p")));

        berthDropdown.click();

        By optionPath = By.xpath("//label[contains(text(),'Berth')]/..//ul//li//span[text()='"+berth+"']");

        WebElement option = wait.until(
                ExpectedConditions.elementToBeClickable(optionPath));

        //wait.until(ExpectedConditions.elementToBeClickable(option));

        try {
            option.click();
        } catch (ElementClickInterceptedException e) {

            // small wait for overlay/animation
            wait.until(ExpectedConditions.elementToBeClickable(option));

            option.click();
        }
    }

    public void enterIRCTCUsername(String username) {

        wait.until(ExpectedConditions.visibilityOf(irctcBox));
        fun.scrollToElement(irctcBox);

        wait.until(ExpectedConditions.elementToBeClickable(irctcInput));
        irctcInput.click();

        wait.until(ExpectedConditions.visibilityOf(irctcModal));
        

        wait.until(ExpectedConditions.visibilityOf(irctcUsername));
        irctcUsername.clear();
        irctcUsername.sendKeys(username);
        checkBtn.click();
        passwordCheckbox.click();
        saveAndCloseBtn.click();

        
    }

    public void clickPasswordCheckbox() {

        wait.until(ExpectedConditions.elementToBeClickable(passwordCheckbox));
        passwordCheckbox.click();
    }

    public void clickSaveAndClose() {

        WebElement saveBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[@type='button']//span")));
        saveBtn.click();
    }

    public void enterContactDetails(String email, String mobile) {

        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.clear();
        emailField.sendKeys(email);

        wait.until(ExpectedConditions.visibilityOf(mobileField));
        mobileField.clear();
        mobileField.sendKeys(mobile);
    }

    public void selectState(String state) {

        WebElement input = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//p[text()='Select the State']/..//input")));
        input.click();

        WebElement option = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//li[text()='" + state + "']")));
        option.click();

        WebElement checkbox = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//p[text()='Confirm and save billing details to your profile']")));
        checkbox.click();
    }

    public void clickBookNow() {

        wait.until(ExpectedConditions.elementToBeClickable(bookNowBtn));
        bookNowBtn.click();
    }
    
   
}