package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrainFilterPage {

    WebDriver driver;
    WebDriverWait wait;
    
    

    public TrainFilterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath="//div[contains(@class,'RailsModifySearch_newWrapper__EjCg')]")
    WebElement headerSearchBar;
    
    

    public WebElement getHeaderSearchBar() {
		return headerSearchBar;
	}

    public WebElement getArrivalTimeSlot(String timeSlot) {
        return wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//span[contains(text(),'Arrival')]/../..//p[contains(text(),'" + timeSlot + "')]")));
    }
     
    public WebElement getDepartureTimeSlot(String timeSlot) {
        return wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//span[contains(text(),'Departure')]/../..//p[contains(text(),'" + timeSlot + "')]")));
    }
     
    public WebElement getTrainTypeOption(String trainType) {
        return wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//span[contains(text(),'Train Types')]/../..//ul//li//p[contains(text(),'" + trainType + "')]")));
    }
     
    public WebElement getFirstTrain() {
        return wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("(//section[@aria-label='Train Listings']//div[@data-testid='listing-card'])[1]")));
    }
	

	// Select Arrival Time dynamically
    public void selectArrivalTime(String timeSlot) {
        By arrival = By.xpath("//span[contains(text(),'Arrival')]/../..//p[contains(text(),'" + timeSlot + "')]");
        wait.until(ExpectedConditions.elementToBeClickable(arrival)).click();
    }

    // Select Departure Time dynamically
    public void selectDepartureTime(String timeSlot) {
        By departure = By.xpath("//span[contains(text(),'Departure')]/../..//p[contains(text(),'" + timeSlot + "')]");
        wait.until(ExpectedConditions.elementToBeClickable(departure)).click();
    }

    // Select Train Type dynamically
    public void selectTrainType(String trainType) {

        By requestedType = By.xpath(
            "//span[contains(text(),'Train Types')]/../..//ul//li//p[contains(text(),'" 
            + trainType + "')]"
        );

        By defaultType = By.xpath(
            "//span[contains(text(),'Train Types')]/../..//ul//li//p[contains(text(),'Others')]"
        );

        try {
            wait.until(ExpectedConditions.elementToBeClickable(requestedType)).click();
            System.out.println(trainType + " selected.");
        } 
        catch (Exception e) {
            System.out.println(trainType + " not available. Selecting Others.");
            wait.until(ExpectedConditions.elementToBeClickable(defaultType)).click();
        }
    }

    // Always select first displayed train
    public void selectFirstTrain() {
        By firstTrain = By.xpath("(//section[@aria-label='Train Listings']//div[@data-testid='listing-card'])[1]");
        wait.until(ExpectedConditions.elementToBeClickable(firstTrain)).click();
    }

    // Full reusable method
    public void selectTrain(String arrivalTime, String departureTime, String trainType) {
        selectArrivalTime(arrivalTime);
        selectDepartureTime(departureTime);
        selectTrainType(trainType);
        selectFirstTrain();
    }
}