package util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptExceutor_Utility {

	WebDriver driver;
	JavascriptExecutor js;

	public JavaScriptExceutor_Utility(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
	}

	// Force Click The Element
	public void clickForceTheElement(WebElement ele) {
		js.executeScript("arguments[0].scrollIntoView({block:'center'}); arguments[0].click();", ele);
	}
}
