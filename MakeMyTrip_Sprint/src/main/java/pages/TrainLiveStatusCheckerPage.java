package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrainLiveStatusCheckerPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public TrainLiveStatusCheckerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@data-cy='liveTrainStatus']")
    private WebElement liveTrainStatus;

    @FindBy(xpath = "//input[@data-cy='selectTrain']")
    private WebElement trainStatusInputField;

    @FindBy(xpath = "//div[@role='combobox']/..//input")
    private WebElement trainNumberField;

    @FindBy(xpath = "//a[@data-cy='checkStatusButton']")
    private WebElement checkStatusBtn;

    @FindBy(xpath = "//div[@data-cy='trainTracker']")
    private WebElement trackerSection;

    // Getter Methods

    public WebElement getLiveTrainStatus() {
        return liveTrainStatus;
    }

    public WebElement getTrainStatusInputField() {
        return trainStatusInputField;
    }

    public WebElement getTrainNumberField() {
        return trainNumberField;
    }

    public WebElement getCheckStatusBtn() {
        return checkStatusBtn;
    }

    public WebElement getTrackerSection() {
        return trackerSection;
    }
    
    public WebElement getTrainSuggestion(String trainNo) {
        return wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//span[text()='" + trainNo + "']")));
    }
     
    public WebElement getStopOption(String stop) {
        return wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//ul[@class='travelForPopup']//span[contains(text(),'" + stop + "')]")));
    }
     
    public WebElement getDayOption(String day) {
        return wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//ul[@class='travelForPopup dateSel']//span[contains(.,'" + day + "')]")));
    }
     

    // Action Methods

    public void clickLiveTrainStatus() {
        wait.until(ExpectedConditions.elementToBeClickable(getLiveTrainStatus())).click();
    }

    public void clickTrainStatusInputField() {
        wait.until(ExpectedConditions.elementToBeClickable(getTrainStatusInputField())).click();
    }

    public void setTrainNumberField(String trainNo) {
    		
        wait.until(ExpectedConditions.visibilityOf(getTrainNumberField())).click();

        wait.until(ExpectedConditions.visibilityOf(getTrainNumberField()))
                .sendKeys(trainNo);

        WebElement trainSuggestion = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[text()='" + trainNo + "']")));

        trainSuggestion.click();
    }

    public void clickCheckStatusBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(getCheckStatusBtn())).click();
    }

    public boolean verifyTracker() {
        return wait.until(
                ExpectedConditions.visibilityOf(getTrackerSection()))
                .isDisplayed();
    }

    // Dynamic Methods

    public void selectStop(String stop) {

        WebElement stopOption = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//ul[@class='travelForPopup']//span[contains(text(),'" + stop + "')]")));

        stopOption.click();
    }

    public void selectDay(String day) {

        WebElement dayOption = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//ul[@class='travelForPopup dateSel']//span[contains(.,'" + day + "')]")));

        dayOption.click();
    }
}