package hooks;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.MediaEntityBuilder;

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
        String browser = ConfigReader.getProperty("browser");
        String url = ConfigReader.getProperty("url");
        int timeout = Integer.parseInt(ConfigReader.getProperty("timeout"));
        String tester = ConfigReader.getProperty("tester");
        String env = ConfigReader.getProperty("env");

        ExtentReportUtility.initReport(tester, browser, env);

        // Store scenario reference for step-level screenshot attachment
        ExtentReportUtility.currentScenario.set(scenario);

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
                
               
                byte[] screenshotBytes = ((TakesScreenshot) b.getDriver())
                        .getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshotBytes, "image/png", scenario.getName());

              
                String base64Screenshot = ((TakesScreenshot) b.getDriver())
                        .getScreenshotAs(OutputType.BASE64);
                ExtentReportUtility.test.get()
                        .fail("Scenario Failed",
                                MediaEntityBuilder
                                    .createScreenCaptureFromBase64String(base64Screenshot)
                                    .build());

            } else {
                ExtentReportUtility.test.get().pass("Scenario Passed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            b.quitDriver();
            ExtentReportUtility.flushReport();
            ExtentReportUtility.currentScenario.remove();
        }
    }
}