package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelSearchPage {

	WebDriver driver;
	WebDriverWait wait;

	public HotelSearchPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}

	public void clickHotelsMenu() {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@data-cy='menu_Hotels']"))).click();
	}

	public void enterCity(String city) throws InterruptedException {

		Thread.sleep(3000);

		// Click city box
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[contains(text(),'City, Property name or Location')]"))).click();

		// Enter city
		WebElement cityBox = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//input[@placeholder='Where do you want to stay?']")));

		cityBox.clear();
		cityBox.sendKeys(city);
	}
	public void enterCitySelectDatesAndSearch(String city, String checkIn, String checkOut) {

		try {

			Thread.sleep(3000);

			// Click city box
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[contains(text(),'City, Property name or Location')]"))).click();

			// Enter city
			WebElement cityBox = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//input[@placeholder='Where do you want to stay?']")));

			cityBox.clear();
			cityBox.sendKeys(city);

			Thread.sleep(2000);

			// Select city suggestion
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='" + city + "']"))).click();

			Thread.sleep(5000);

			// Check-In Date
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[contains(@aria-label,' May " + checkIn + " 2026')]")))
					.click();

			Thread.sleep(5000);

			// Check-Out Date
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[contains(@aria-label,' May " + checkOut + " 2026')]")))
					.click();

			Thread.sleep(5000);

			// Search Button
			WebElement searchBtn = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'Search')]")));

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchBtn);

			Thread.sleep(1000);

			((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchBtn);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectDates(String checkIn, String checkOut) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		String checkInXpath = "//div[@role='gridcell' and contains(@aria-label,'Apr " + checkIn
				+ " 2026') and @aria-disabled='false']";

		String checkOutXpath = "//div[@role='gridcell' and contains(@aria-label,'Apr " + checkOut
				+ " 2026') and @aria-disabled='false']";

		WebElement inDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(checkInXpath)));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", inDate);

		Thread.sleep(1000);

		WebElement outDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(checkOutXpath)));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", outDate);
	}

	public void clickSearch() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement searchBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Search')]")));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchBtn);

		Thread.sleep(1000);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchBtn);
	}
	// Add below methods inside HotelSearchPage.java

	// Replace old methods inside HotelSearchPage.java

	// Replace only applyPriceFilter() method

	public void applyPriceFilter(String range) throws Exception {

	    Thread.sleep(4000);

	    WebElement priceFilter =
	    wait.until(ExpectedConditions.visibilityOfElementLocated(
	    By.xpath("//label[contains(text(),'₹ 0 - ₹ 2500')]")));

	    // Scroll till element visible in center
	    ((JavascriptExecutor)driver).executeScript(
	    "arguments[0].scrollIntoView({block:'center'});", priceFilter);

	    Thread.sleep(2000);

	    // Use JS click (fix intercept issue)
	    ((JavascriptExecutor)driver).executeScript(
	    "arguments[0].click();", priceFilter);

	    Thread.sleep(3000);
	}

	// Replace only sortHotels() method

	// FINAL WORKING sortHotels() based on your screenshot

	public void sortHotels(String sortType) throws Exception {

	    Thread.sleep(4000);

	    if(sortType.equalsIgnoreCase("Low to High")) {

	        WebElement sort =
	        wait.until(ExpectedConditions.elementToBeClickable(
	        By.xpath("//span[contains(text(),'Price (Low to High)')]")));

	        ((JavascriptExecutor)driver)
	        .executeScript("arguments[0].scrollIntoView(true);", sort);

	        Thread.sleep(1000);

	        ((JavascriptExecutor)driver)
	        .executeScript("arguments[0].click();", sort);
	    }

	    Thread.sleep(5000);
	}
	public void selectHotelFromResults() throws Exception {

	    Thread.sleep(6000);

	    WebElement firstHotel =
	    wait.until(ExpectedConditions.presenceOfElementLocated(
	    By.xpath("(//p[@id='hlistpg_hotel_name']//span[@class='wordBreak appendRight10'])[1]")));

	    ((JavascriptExecutor)driver).executeScript(
	    "arguments[0].scrollIntoView({block:'center'});", firstHotel);

	    Thread.sleep(2000);

	    ((JavascriptExecutor)driver).executeScript(
	    "arguments[0].click();", firstHotel);

	    Thread.sleep(5000);
	}
	public void clickFirstHotel() {

	    try {

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	        String oldWindow = driver.getWindowHandle();

	        // First hotel name click
	        WebElement firstHotel = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("(//p[@id='hlistpg_hotel_name'])[1]")));

	        ((JavascriptExecutor) driver)
	            .executeScript("arguments[0].scrollIntoView(true);", firstHotel);

	        Thread.sleep(1000);

	        ((JavascriptExecutor) driver)
	            .executeScript("arguments[0].click();", firstHotel);

	        Thread.sleep(4000);

	        // Switch to new tab
	        for (String windowHandle : driver.getWindowHandles()) {
	            if (!windowHandle.equals(oldWindow)) {
	                driver.switchTo().window(windowHandle);
	                break;
	            }
	        }

	        System.out.println("Switched to hotel details tab");

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	public void clickViewThisCombo() {

	    try {

	        // wait for hotel details page to fully load
	        Thread.sleep(6000);

	        // switch to newly opened tab
	        java.util.Set<String> windows = driver.getWindowHandles();
	        java.util.Iterator<String> it = windows.iterator();

	        String parent = it.next();
	        String child = parent;

	        while(it.hasNext()) {
	            child = it.next();
	        }

	        driver.switchTo().window(child);

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	        // locate button
	        WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(
	            By.xpath("//button[contains(text(),'VIEW THIS COMBO')]")
	        ));

	        // scroll till visible
	        ((JavascriptExecutor)driver).executeScript(
	            "arguments[0].scrollIntoView({block:'center'});", btn);

	        Thread.sleep(3000);

	        // direct JS click
	        ((JavascriptExecutor)driver).executeScript(
	            "arguments[0].click();", btn);

	        System.out.println("VIEW THIS COMBO clicked");

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	public void clickSelectCombo() {

	    try {

	        Thread.sleep(5000);

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	        // Correct locator: Select Combo is <a> with span text
	        WebElement comboBtn = wait.until(
	            ExpectedConditions.elementToBeClickable(
	                By.xpath("//a[contains(@class,'rmPayable__dtl--cta')]//span[contains(text(),'Select Combo')]"))
	        );

	        ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].scrollIntoView({block:'center'});", comboBtn);

	        Thread.sleep(2000);

	        ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].click();", comboBtn);

	        System.out.println("Select Combo clicked");

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	public void enterGuestDetails(String fname, String lname, String email, String mobile) {

	    try {

	        Thread.sleep(4000);

	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0,700)");

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	        WebElement firstName = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(By.id("fName")));
	        firstName.clear();
	        firstName.sendKeys(fname);

	        WebElement lastName = driver.findElement(By.id("lName"));
	        lastName.clear();
	        lastName.sendKeys(lname);

	        WebElement emailBox = driver.findElement(By.id("email"));
	        emailBox.clear();
	        emailBox.sendKeys(email);

	        WebElement mobileBox = driver.findElement(By.id("mNo"));
	        mobileBox.clear();
	        mobileBox.sendKeys(mobile);

	        System.out.println("Guest details entered successfully");

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public void clickPayNow() {

	    try {

	        Thread.sleep(3000);

	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	        WebElement payNow = wait.until(
	                ExpectedConditions.elementToBeClickable(
	                By.xpath("//a[contains(@class,'btnContinuePayment') and contains(text(),'Pay Now')]")));

	        js.executeScript("arguments[0].click();", payNow);

	        System.out.println("Pay Now clicked successfully");

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}