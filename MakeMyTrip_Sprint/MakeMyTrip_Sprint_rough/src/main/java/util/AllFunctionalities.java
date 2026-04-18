package util;


import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

public class AllFunctionalities{

    public WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public AllFunctionalities(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // =========================
    // Browser Utility
    // =========================
    public void configMaximizedBrowser() {
        driver.manage().window().maximize();
    }

    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // =========================
    // Explicit Waits
    // =========================
    public void waitForElementClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForTitleContains(String title) {
        wait.until(ExpectedConditions.titleContains(title));
    }

    // =========================
    // Window Handling
    // =========================
    public void switchToWindow(String partialTitle) {
        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {
            driver.switchTo().window(window);
            if (driver.getTitle().contains(partialTitle)) {
                break;
            }
        }
    }

    // =========================
    // Frame Handling
    // =========================
    public void switchToFrame(WebElement frameElement) {
        driver.switchTo().frame(frameElement);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    // =========================
    // Alert Handling
    // =========================
    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void dismissAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    // =========================
    // Dropdown Handling
    // =========================
    public void selectByVisibleText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void selectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void selectByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    // =========================
    // Mouse Actions
    // =========================
    public void mouseHover(WebElement element) {
        Actions act = new Actions(driver);
        act.moveToElement(element).perform();
    }

    public void doubleClick(WebElement element) {
        Actions act = new Actions(driver);
        act.doubleClick(element).perform();
    }

    public void rightClick(WebElement element) {
        Actions act = new Actions(driver);
        act.contextClick(element).perform();
    }

    // =========================
    // Scroll
    // =========================
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollByPixels(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
    }

    // =========================
    // Java Utility
    // =========================
    public int getRandomNumber(int range) {
        return new Random().nextInt(range);
    }

    public String getRandomValue() {
        return UUID.randomUUID().toString().replaceAll("[^a-zA-Z]", "");
    }

    public String getCurrentDate(String format) {
        return new SimpleDateFormat(format).format(new Date());
    }

    public String getRequiredDate(int days) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, days);
        return sdf.format(cal.getTime());
    }
}