package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;



public class FlightSearchPage {

    WebDriver driver;
    WebDriverWait wait;

    public FlightSearchPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
//Locators

    @FindBy(xpath = "//li[@data-cy='menu_Flights']")
    private WebElement flightsMenu;

    @FindBy(id = "fromCity")
    private WebElement fromCity;

    @FindBy(xpath = "//input[@placeholder='From']")
	public WebElement fromInput;

    @FindBy(id = "toCity")
    private WebElement toCity;

    @FindBy(xpath = "//input[@placeholder='To']")
    private WebElement toInput;

    @FindBy(xpath = "//span[text()='Departure']")
    private WebElement departureField;

    @FindBy(xpath = "//span[@aria-label='Next Month']")
    private WebElement nextMonthBtn;

    @FindBy(xpath = "//a[contains(@class,'primaryBtn') and contains(text(),'Search')]")
    private WebElement searchBtn;

    public void clickFlightsMenu() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(flightsMenu)).click();
        } catch (Exception e) {
            System.out.println("Flights menu click failed, trying fallback...");
            try {
            	Thread.sleep(2000);
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.spa-classic-peek__back-to-classic-search"))).click();
            } catch (Exception e1) {
                System.out.println("Flights menu click failed, trying fallback...");
              
                driver.findElement(By.xpath("//button[contains(@class, 'back-to-classic-search')]")).click();
            }
        }
    }
   
    public void enterSource(String city) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(fromCity)).click();
        WebElement input = wait.until(ExpectedConditions.visibilityOf(fromInput));
        
        input.sendKeys(city);
       
        try {
            WebElement suggestion = driver.findElement(By.xpath("//li[contains(@role,'option')]"));
            suggestion.click();
        }
        catch (Exception e) {
            input.sendKeys(Keys.ENTER);
        }
        
        System.out.println("Source entered: " + city);
    }

    public void enterDestination(String city) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(toCity)).click();
        WebElement input = wait.until(ExpectedConditions.visibilityOf(toInput));
        input.sendKeys(city);
       
        Thread.sleep(1500);
        
        try {
            WebElement suggestion = driver.findElement(By.xpath("//li[contains(@role,'option')]"));
            suggestion.click();
        } catch (Exception e) {
            input.sendKeys(Keys.ENTER);
        }

        System.out.println("Destination entered: " + city);
    }

    public void selectDate(String month, String day) {
        wait.until(ExpectedConditions.elementToBeClickable(departureField)).click();
        
        while (true) {
            List<WebElement> months = wait.until(
                    ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            By.className("DayPicker-Month")));

            for (WebElement m : months) {
                String title = m.findElement(By.className("DayPicker-Caption")).getText();

                if (title.toLowerCase().contains(month.toLowerCase())) {
                    WebElement date = m.findElement(
                            By.xpath(".//div[contains(@class,'dateInnerCell')]/p[text()='" + day + "'] | " +
                                     ".//div[contains(@class,'dateInnerCell')]/p[contains(text(),'" + day + "')]"));
                    date.click();
                    System.out.println("Date selected: " + month + " " + day);
                    return;
                }
            }
            wait.until(ExpectedConditions.elementToBeClickable(nextMonthBtn)).click();
        }
    }

    public void clickSearch() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchBtn);
        System.out.println("Search clicked");
        

        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void selectAirline() throws InterruptedException {
       
            Thread.sleep(5000);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 400);");
            Thread.sleep(2000);

            String[] airlines = {"Air India", "Akasa Air", "IndiGo"};

            for (String airline : airlines) {
                try {
                    driver.findElement(
                        By.xpath("(//*[contains(text(),'" + airline + "')])[1]/ancestor::*[1]//input[@type='checkbox'] | " +
                                 "(//*[contains(text(),'" + airline + "')])[1]/preceding::input[@type='checkbox'][1]")
                    ).click();

                    Thread.sleep(500);

                } catch (Exception e) {
                    
                }
            


        } 
    }
    
    public void clickViewPrices() throws InterruptedException {
       
            WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("(//span[contains(text(),'VIEW PRICES')])[1]")));
            
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);
            Thread.sleep(1000);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
            System.out.println("VIEW PRICES clicked");
            Thread.sleep(3000);
            
        } 


    public void clickBookNow() {
        try {
            String[] bookNowLocators = {
                "//button[text()='BOOK NOW']",
                "//button[contains(text(),'Book Now')]",
                "(//button[text()='BOOK NOW'])[1]",

            };
            
            WebElement btn = null;
            for (String locator : bookNowLocators) {
                try {
                    btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
                    if (btn != null) {
                        break;
                    }
                } catch (Exception e) {
                    // Continue
                }
            }
            
            if (btn != null) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);
                Thread.sleep(500);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
                System.out.println("Book Now clicked");
            } else {
                System.out.println("No Book Now button found");
            }
            
            Thread.sleep(3000);
            
        } catch (Exception e) {
            System.out.println("Error clicking book now: " + e.getMessage());
        }
    }
    
            
    }
    
    


