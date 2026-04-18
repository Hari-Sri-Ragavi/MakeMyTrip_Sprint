package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectCabpage {

    WebDriver driver;
    WebDriverWait wait;

    public SelectCabpage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // ================= COMMON FILTER CLICK =================
    public void clickFilter(String value) {

        By filter = By.xpath("//span[text()='" + value + "']");

        WebElement el = wait.until(
                ExpectedConditions.visibilityOfElementLocated(filter)
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", el
        );

        wait.until(ExpectedConditions.elementToBeClickable(el)).click();

        System.out.println("✔ Filter clicked: " + value);

        // wait for results to load
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//span[text()='SELECT CAB']")
        ));
    }

    // ================= SELECT CAB =================
    public void clickSelectCab() {

        By btn = By.xpath("(//span[text()='SELECT CAB'])[1]");

        WebElement el = wait.until(
                ExpectedConditions.elementToBeClickable(btn)
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", el
        );

        el.click();

        System.out.println("✔ SELECT CAB clicked");
    }
}