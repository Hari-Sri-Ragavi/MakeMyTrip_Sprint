package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class CabPage {

    WebDriver driver;
    WebDriverWait wait;

    public CabPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void selectOutstation() {

        WebElement outstation = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[contains(text(),'Outstation One-Way')]")));

        outstation.click();
        System.out.println("✔ Outstation selected");
    }
}
