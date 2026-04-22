package pages;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CABS_SearchPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public  CABS_SearchPage(WebDriver driver) {
	    this.driver = driver;
	    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    PageFactory.initElements(driver, this);
	}
	///---------------------------WEBELEMENTS-------------------------------------------------------------
	  @FindBy(css = "label[for='fromCity']")
	    WebElement fromCityLabel;

	    @FindBy(xpath = "//input[@title='From']")
	    WebElement fromInput;

	    @FindBy(xpath = "//input[@title='To']")
	    WebElement toInput;

	  
	    @FindBy(xpath = "//span[@aria-label='Next Month']")
	    WebElement nextMonthBtn;
//---------------------------------------------------------Methods-------------------------------------------
	    public void selectFromCity(String city) {
	        fromCityLabel.click();

	        wait.until(ExpectedConditions.visibilityOf(fromInput));
	        fromInput.sendKeys(city);

	        WebElement option = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("//ul[@role='listbox']//li[contains(.,'" + city + "')]"))
	        );
	        option.click();
	    }

	    public void selectToCity(String city) {
	        wait.until(ExpectedConditions.visibilityOf(toInput));
	        toInput.sendKeys(city);

	        WebElement option = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("//ul[@role='listbox']//li[contains(.,'" + city + "')]"))
	        );
	        option.click();
	    }

//	    public void selectDate(String month, String day) {
//
//	        while (true) {
//
//	            List<WebElement> months = wait.until(
//	                    ExpectedConditions.visibilityOfAllElementsLocatedBy(
//	                            By.className("DayPicker-Month"))
//	            );
//
//	            for (WebElement m : months) {
//
//	                String title = m.findElement(By.className("DayPicker-Caption")).getText();
//
//	                if (title.toLowerCase().contains(month.toLowerCase())) {
//
//	                    WebElement date = m.findElement(
//	                            By.xpath(".//div[not(contains(@class,'disabled'))]/div[text()='"
//	                                    + day + "']")
//	                    );
//
//	                    date.click();
//	                    return;
//	                }
//	            }
//
//	            wait.until(ExpectedConditions.elementToBeClickable(nextMonthBtn)).click();
//	        }
//	    }
	/////Date
	    public void selectTodayDate() {

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

	        // 1. Click Departure field
	        WebElement departure = wait.until(
	                ExpectedConditions.elementToBeClickable(
	                        By.xpath("//span[text()='Departure']")
	                )
	        );
	        departure.click();

	        // 2. Get today date
	        LocalDate today = LocalDate.now();
	        String day = String.valueOf(today.getDayOfMonth());

	        // 3. Click today's date (dynamic)
	        WebElement todayDate = wait.until(
	                ExpectedConditions.elementToBeClickable(
	                        By.xpath("//div[contains(@class,'DayPicker-Day') and not(contains(@class,'disabled')) and text()='" + day + "']")
	                )
	        );

	        todayDate.click();

	        System.out.println("✔ Selected today's date: " + day);
	    
	    }
}
