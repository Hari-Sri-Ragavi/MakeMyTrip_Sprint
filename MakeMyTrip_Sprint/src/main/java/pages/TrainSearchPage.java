package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrainSearchPage {

    WebDriver driver;
    WebDriverWait wait;

    public TrainSearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@data-cy='bookTrainTickets']")
    WebElement bookTrain;

    @FindBy(css = "label[for='fromCity']")
    WebElement fromCityLabel;

    @FindBy(xpath = "//input[@title='From']")
    WebElement fromInput;

    @FindBy(xpath = "//input[@title='To']")
    WebElement toInput;

    @FindBy(xpath = "//span[@aria-label='Next Month']")
    WebElement nextMonthBtn;

    @FindBy(xpath = "//a[@data-cy='submit']")
    WebElement searchBtn;

    @FindBy(xpath = "//li[@data-cy='menu_Trains']")
    private WebElement trainsMenu;

    @FindBy(xpath = "//span[@data-cy='bookTrainTickets']")
    private WebElement bookTrainTickets;
    
    public WebElement getTrainsMenu() {
        return wait.until(ExpectedConditions.visibilityOf(trainsMenu));
    }
     
    public WebElement getBookTrainTickets() {
        return wait.until(ExpectedConditions.visibilityOf(bookTrainTickets));
    }
     
    public WebElement getFromCityLabel() {
        return wait.until(ExpectedConditions.visibilityOf(fromCityLabel));
    }
     
    public WebElement getFromInput() {
        return wait.until(ExpectedConditions.visibilityOf(fromInput));
    }
     
    public WebElement getToInput() {
        return wait.until(ExpectedConditions.visibilityOf(toInput));
    }
     
    public WebElement getNextMonthBtn() {
        return wait.until(ExpectedConditions.elementToBeClickable(nextMonthBtn));
    }
     
    public WebElement getSearchBtn() {
        return wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
    }
     

    public void clickTrainsMenu() {
        trainsMenu.click();
    }

    public void clickBookTrainTickets() {
        bookTrainTickets.click();
    }

    public void selectFromCity(String city) {
        fromCityLabel.click();
        wait.until(ExpectedConditions.visibilityOf(fromInput));
        fromInput.clear();
        fromInput.sendKeys(city);

        String xpath = "//ul[@role='listbox']//li[contains(.,'" + city + "')]";
        
        for (int attempt = 0; attempt < 3; attempt++) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
                return; // success
            } catch (StaleElementReferenceException e) {
                // dropdown re-rendered, retry
            }
        }
    }

    public void selectToCity(String city) {
        wait.until(ExpectedConditions.visibilityOf(toInput));
        toInput.clear();
        toInput.sendKeys(city);

        String xpath = "//ul[@role='listbox']//li[contains(.,'" + city + "')]";

        for (int attempt = 0; attempt < 3; attempt++) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
                return;
            } catch (StaleElementReferenceException e) {
                // retry
            }
        }
    }

    public void selectDate(String month, String day) {

        while (true) {

            List<WebElement> months = wait.until(
                    ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            By.className("DayPicker-Month"))
            );

            for (WebElement m : months) {

                String title = m.findElement(By.className("DayPicker-Caption")).getText();

                if (title.toLowerCase().contains(month.toLowerCase())) {

                    WebElement date = m.findElement(
                            By.xpath(".//div[not(contains(@class,'disabled'))]/div[text()='"
                                    + day + "']")
                    );

                    date.click();
                    return;
                }
            }

            wait.until(ExpectedConditions.elementToBeClickable(nextMonthBtn)).click();
        }
    }

    public void selectClass(String className) {

        WebElement classOption = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//ul[@class='travelForPopup']//li[contains(.,'" + className + "')]"))
        );

        classOption.click();
    }

    public void clickSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
    }
}