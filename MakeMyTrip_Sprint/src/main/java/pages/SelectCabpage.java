
package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectCabpage {

    WebDriver driver;
    WebDriverWait wait;

    public SelectCabpage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // CLICK FIRST CAB TYPE
    public void clickFirstCabType() {

        List<WebElement> checkboxes = driver.findElements(
                By.xpath("//div[contains(@class,'checkbox-module')]")
        );

        checkboxes.get(0).click();   // first checkbox

        System.out.println("First cab type selected");
    }

    // CLICK FIRST FUEL TYPE (CNG)
    public void clickFirstFuelType() {

        List<WebElement> checkboxes = driver.findElements(
                By.xpath("//div[contains(@class,'checkbox-module')]")
        );

        checkboxes.get(4).click();   // fuel section index (adjust if needed)

        System.out.println("Fuel type selected");
    }

    // SELECT CAB
    public void clickSelectCab() {

        driver.findElements(By.xpath("//span[text()='SELECT CAB']")).get(0).click();

        System.out.println("SELECT CAB clicked");
    }
}
