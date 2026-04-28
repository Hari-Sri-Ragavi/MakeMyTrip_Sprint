
package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class CabSearchPage {

    WebDriver driver;
    WebDriverWait wait;

    public CabSearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    // ---------------- WEBELEMENTS ----------------

    @FindBy(xpath = "//div[contains(@class,'checkbox-module')]")
    private List<WebElement> allCheckboxes;

    @FindBy(xpath = "//span[text()='SELECT CAB']")
    private List<WebElement> selectCabBtns;


    // ---------------- GETTERS ----------------

    public List<WebElement> getAllCheckboxes() {
        return allCheckboxes;
    }

    public List<WebElement> getSelectCabBtns() {
        return selectCabBtns;
    }


    // ---------------- ACTION METHODS ----------------

    // Click first cab type
    public void clickFirstCabType() {

        wait.until(ExpectedConditions.visibilityOfAllElements(getAllCheckboxes()));

        getAllCheckboxes().get(0).click();   

        System.out.println("First cab type selected");
    }

    // Click fuel type (simple index)
    public void clickFirstFuelType() {

        wait.until(ExpectedConditions.visibilityOfAllElements(getAllCheckboxes()));

        getAllCheckboxes().get(4).click();

        System.out.println("Fuel type selected");
    }

    // Click SELECT CAB
    public void clickSelectCab() {

        wait.until(ExpectedConditions.visibilityOfAllElements(getSelectCabBtns()));

        getSelectCabBtns().get(0).click();

        System.out.println("SELECT CAB clicked");
    }
}
