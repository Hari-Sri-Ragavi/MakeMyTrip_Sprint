package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
public class CabPage {
    WebDriver driver;
    WebDriverWait wait;

    public CabPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    // ---------------- WEBELEMENT ----------------

    @FindBy(xpath = "//li[contains(text(),'Outstation One-Way')]")
    private WebElement outstation;


    // ---------------- GETTER ----------------

    public WebElement getOutstation() {
        return outstation;
    }


    // ---------------- ACTION ----------------

    public void selectOutstation() {

        wait.until(ExpectedConditions.elementToBeClickable(getOutstation())).click();

        System.out.println("Outstation selected");
    }
}
