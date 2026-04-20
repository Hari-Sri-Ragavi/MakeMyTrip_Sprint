package util;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Actions_Helper {
	WebDriver driver;
	Actions act;

	public Actions_Helper(WebDriver driver) {
		this.driver = driver;
		this.act = new Actions(driver);
	}

	// Move to element and click
	public void clickOnElement(WebElement element) {
		act.moveToElement(element).click().perform();
	}

	public void navigateDownDropdown(WebElement element, long timeInSec, int downArrowIndex) {

		act.click(element).pause(Duration.ofSeconds(timeInSec)).perform();

		for (int i = 0; i < downArrowIndex; i++) {
			act.sendKeys(Keys.ARROW_DOWN).perform();
		}

		act.sendKeys(Keys.ENTER).perform();
	}

	public void scrollDownAutoSuggestion(WebElement element, String text, long timeInSec, int downArrowIndex) {
		act.sendKeys(element, text).pause(Duration.ofSeconds(timeInSec)).perform();
		for (int i = 0; i < downArrowIndex; i++) {
			act.keyDown(Keys.DOWN).perform();
		}
		act.keyDown(Keys.ENTER).perform();
	}

	public void doubleclick(WebElement element) {
		act.doubleClick(element).perform();
	}

	// Hover on element
	public void hoverOnElement(WebElement element) {
		act.moveToElement(element).perform();
	}

	// Right Click
	public void rightClick(WebElement element) {
		act.contextClick(element).perform();
	}

	// Double Click
	public void doubleClick(WebElement element) {
		act.doubleClick(element).perform();
	}

	// Drag and Drop
	public void dragAndDrop(WebElement src, WebElement dest) {
		act.dragAndDrop(src, dest).perform();
	}

	// Click and Hold
	public void clickAndHold(WebElement element) {
		act.clickAndHold(element).perform();
	}

	// Release element
	public void releaseElement(WebElement element) {
		act.release(element).perform();
	}

	// Send keys to element
	public void sendKeysToElement(WebElement element, String text) {
		act.click(element).sendKeys(text).perform();
	}

	// Press Enter key
	public void pressEnter() {
		act.sendKeys(Keys.ENTER).perform();
	}

	// Press Tab key
	public void pressTab() {
		act.sendKeys(Keys.TAB).perform();
	}

	// Navigate dropdown using keyboard
	public void navigateDownDropdown(WebElement element, int downIndex) {
		act.click(element).perform();

		for (int i = 1; i <= downIndex; i++) {
			act.sendKeys(Keys.DOWN).perform();
		}

		act.sendKeys(Keys.ENTER).perform();
	}

	public void entervalueinDropDown(String value) {
		act.sendKeys(value).perform();
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();
	}

	// Scroll to element
	public void scrollToElement(WebElement element) {
		act.moveToElement(element).perform();
	}

	// Drag and drop by offset
	public void dragAndDropByOffset(WebElement element, int x, int y) {
		act.dragAndDropBy(element, x, y).perform();
	}

	// Key combination (Ctrl + A, Ctrl + C etc.)
	public void keyCombination(Keys key, CharSequence value) {
		act.keyDown(key).sendKeys(value).keyUp(key).perform();
	}

}