package hooks;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import base.BaseClass;
import base.Pages;
import util.ConfigReader;

public class hook {

    private BaseClass b;

    public hook(BaseClass b) {
        this.b = b;
    }

    @Before
    public void setUp() throws IOException {

        ConfigReader config = new ConfigReader();

        String browser = config.getProperty("browser");
        String url = config.getProperty("url");
        int timeout = Integer.parseInt(config.getProperty("timeout"));

        // Initialize driver HERE (not in BaseClass)
        if (browser.equalsIgnoreCase("chrome")) {
            b.driver = new ChromeDriver();
        } 
        else if (browser.equalsIgnoreCase("edge")) {
            b.driver = new EdgeDriver();
        } 
        else if (browser.equalsIgnoreCase("firefox")) {
            b.driver = new FirefoxDriver();
        } 
        else {
        	b.driver = new FirefoxDriver();
        }

        // Browser setup
        b.driver.manage().window().maximize();
        b.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));

        // Launch URL
        String workingUrl=url+"/flights";
        b.driver.get(workingUrl);
        
        Pages.loadAllPages(b.driver);
        Pages.hp.closeModalIfPresent();
        
    }

    @After
    public void tearDown() {
//        if (b.driver != null) {
//            b.driver.quit();
//        }
    }
}