package hooks;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import base.BaseClass;
import base.Pages;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import util.ConfigReader;
import util.ExtentReportUtility;

public class hook {

    private BaseClass b;
    private Pages p;

    public hook(BaseClass b, Pages p) {
        this.b = b;
        this.p = p;
    }

    @Before
    public void setUp(Scenario scenario) throws IOException {

        ConfigReader config = new ConfigReader();

        String browser = config.getProperty("browser");
        String url = config.getProperty("url");
        int timeout = Integer.parseInt(config.getProperty("timeout"));
        String tester = config.getProperty("tester");
        String env = config.getProperty("env");

        ExtentReportUtility.initReport(tester, browser, env);

        // Create Parent Scenario Node
        ExtentReportUtility.test.set(
                ExtentReportUtility.extent.createTest(scenario.getName())
        );

        // Launch Browser
        if (browser.equalsIgnoreCase("chrome")) {
        	ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-blink-features=AutomationControlled");
			options.addArguments("--incognito");
			b.setDriver(new ChromeDriver(options));
           
        } 
        else if (browser.equalsIgnoreCase("edge")) {
            b.setDriver(new EdgeDriver());
        } 
        else if (browser.equalsIgnoreCase("firefox")) {
            b.setDriver(new FirefoxDriver());
        } 
        else {
            b.setDriver(new ChromeDriver());
        }

        b.getDriver().manage().window().maximize();

        b.getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(timeout));

        b.getDriver().get(url + "/flights");

        // Load Pages
        p.loadAllPages(b.getDriver());
        p.hp.closeModalIfPresent();

        ExtentReportUtility.test.get()
                .info("Browser launched and application opened");
    }

    @After
    public void tearDown(Scenario scenario) {

        try {

            if (scenario.isFailed()) {
                ExtentReportUtility.test.get().fail("Scenario Failed");
            } else {
                ExtentReportUtility.test.get().pass("Scenario Passed");
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            // b.quitDriver();
            ExtentReportUtility.flushReport();
        }
    }
}