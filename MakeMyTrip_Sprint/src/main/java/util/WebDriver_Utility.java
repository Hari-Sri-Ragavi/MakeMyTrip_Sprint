package util;

import java.net.URL;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriver_Utility {
	WebDriver driver;
	WebDriverWait wait;

	public WebDriver_Utility(WebDriver driver) {
		this.driver = driver;
	}

	// manage() - maximize browseer
	public void configBrowserMaximize() {
		driver.manage().window().maximize();
	}

	// manage() - minimize browseer
	public void configBrowserMinimize() {
		driver.manage().window().minimize();
	}

	// manage() - Fullscreen browser
	public void configBrowserFullScreen() {
		driver.manage().window().fullscreen();
	}

	// manage() - getsize()
	public Dimension fetchBrowsergetSize() {
		Dimension dim = driver.manage().window().getSize();
		return dim;
	}

	// manage() - setSize()
	public void configsetSize(int width, int height) {
		driver.manage().window().setSize(new Dimension(width, height));
	}

	// manage() - getPosition()
	public Point fetchBrowserPosition() {
		Point point = driver.manage().window().getPosition();
		return point;
	}

	// manage() - setPosition()
	public void configsetPosition(int width, int height) {
		driver.manage().window().setPosition(new Point(width, height));
	}

	// navigate() - to(String URL)
	public void NavigateToApplication(String URL) {
		driver.navigate().to(URL);
	}

	// navigate() - to(String URL)
	public void NavigateToURL(URL URL) {
		driver.navigate().to(URL);
	}

	// navigate() - forward()
	public void NavigateForward() {
		driver.navigate().forward();
	}

	// navigate() - back()
	public void NavigateBack() {
		driver.navigate().back();
	}

	// navigate() - refresh()
	public void NavigateRefresh() {
		driver.navigate().refresh();
	}

	// WebDriver - get()
	public void EnterURL(String URL) {
		driver.get(URL);
	}

	// WebDriver - getTitle()
	public String fetchAppTitle() {
		return driver.getTitle();
	}

	// WebDriver - getCurrentURL()
	public String fetchAppCurrentURL() {
		return driver.getCurrentUrl();
	}

	// WebDriver - getPageSource()
	public String fetchAppPageSrc() {
		return driver.getPageSource();
	}

	// WebDriver - close()
	public void CloseTheTab() {
		driver.close();
	}

	// WebDriver - quit()
	public void QuitTheBrowser() {
		driver.quit();
	}

	// timeOuts() - implictlyWait()
	public void waitForElementload(int Seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Seconds));
	}

	// explictWait() - elementsToClickable
	public void waitTillElementIsClckable(WebElement ele, int seconds) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	// explictWait() - elementsToClickable
	public void waitTillElementIsVisible(WebElement ele, int seconds) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	//explict wait() - elementspresence
	public WebElement waitTillPresenceOfElementLocated(By locator, int timeout) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	    return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	//takes time to apply filters
	public void waitForLoaderToDisappear() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));

	    wait.until(driver -> {
	        try {
	            return driver.findElements(By.className("filtersOverlayLoader"))
	                         .stream()
	                         .noneMatch(WebElement::isDisplayed);
	        } catch (Exception e) {
	            return true;
	        }
	    });
	}

	// Popups - alert() - accept()
	public void clickOnAccept() {
		driver.switchTo().alert().accept();
	}

	// Popups - alert() - dismiss()
	public void clickOnDismiss() {
		driver.switchTo().alert().dismiss();
	}

	// Popups - Type Message()
	public void typeMessageInJavascriptPopup(String msg) {
		driver.switchTo().alert().sendKeys(msg);
	}

	// Popups - Print Message()
	public void fetchInJavascriptPopup() {
		System.out.println(driver.switchTo().alert().getText());
	}

	// Child window switching -- using Title
	public void windowSwitchingByTitle(String childWindowTitle) {
		String parent_id = driver.getWindowHandle();
		Set<String> all_id = driver.getWindowHandles();

		all_id.remove(parent_id);
		for (String ele : all_id) {
			driver.switchTo().window(ele);
			String title = driver.getTitle();
			if (title.contains(childWindowTitle)) {
				break;
			}
		}
	}

	// Child window switching -- using URL
	public void windowSwitchingByURL(String childWindowTitle) {
		String parent_id = driver.getWindowHandle();
		Set<String> all_id = driver.getWindowHandles();

		all_id.remove(parent_id);
		for (String ele : all_id) {
			driver.switchTo().window(ele);
			String title = driver.getCurrentUrl();
			if (title.contains(childWindowTitle)) {
				break;
			}
		}
	}

	// iFrame --- index
	public void SwitchFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	// iFrame --- String
	public void SwitchFrameByString(String id) {
		driver.switchTo().frame(id);
	}

	// iFrame --- WebElement
	public void SwitchFrameByElement(WebElement ele) {
		driver.switchTo().frame(ele);
	}

	// iframe --- parent frame
	public void switchBackControlToParent() {
		driver.switchTo().parentFrame();
	}

	// iframe --- main frame
	public void switchBackControlToMainPage() {
		driver.switchTo().defaultContent();
	}
}
