package hooks;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import base.BaseClass;
import base.Pages;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import util.ConfigReader;
import util.ExtentReportUtility;
import util.ScreenshotUtility;

public class hook {

    private BaseClass b;

    public hook(BaseClass b) {
        this.b = b;
    }

    @Before
    public void setUp(Scenario scenario) throws IOException {

        ConfigReader config = new ConfigReader();

        String browser = config.getProperty("browser");
        String url = config.getProperty("url");
        int timeout = Integer.parseInt(config.getProperty("timeout"));
        String tester = config.getProperty("tester");
        String env = config.getProperty("env");

        // Initialize report once
        ExtentReportUtility.initReport(tester, browser, env);

        // Create test entry for scenario
        ExtentReportUtility.test.set(
                ExtentReportUtility.extent.createTest(scenario.getName())
        );

        // Launch browser
        if (browser.equalsIgnoreCase("chrome")) {
            b.driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            b.driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            b.driver = new FirefoxDriver();
        } else {
            b.driver = new ChromeDriver();
        }

        // Browser setup
        b.driver.manage().window().maximize();
        b.driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(timeout));

        // Open URL
        b.driver.get(url + "/flights");

        // Launch URL
        String workingUrl=url+"/flights";
        b.driver.get(workingUrl);
        
        Pages.loadAllPages(b.driver);
        Pages.hp.closeModalIfPresent();

        ExtentReportUtility.test.get()
                .info("Browser launched and application opened");
    }

    @After
    public void tearDown(Scenario scenario) {

        try {

            if (scenario.isFailed()) {

                String path = new ScreenshotUtility()
                        .capture(b.driver, scenario.getName());

                ExtentReportUtility.test.get()
                        .fail("Scenario Failed")
                        .addScreenCaptureFromPath(path);

            } else {

                ExtentReportUtility.test.get()
                        .pass("Scenario Passed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (b.driver != null) {
                b.driver.quit();
            }

            ExtentReportUtility.extent.flush();
        }
    }
}