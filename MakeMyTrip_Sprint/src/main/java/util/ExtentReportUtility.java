package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.Scenario;

public class ExtentReportUtility {
    public static ExtentReports extent;
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    public static ThreadLocal<ExtentTest> step = new ThreadLocal<>();
    public static ThreadLocal<Scenario> currentScenario = new ThreadLocal<>();

    public static synchronized void initReport(String tester, String browser, String env) {
        if (extent == null) {
            String time = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss")
                    .format(new Date());
            String path = "./target/Reports/MMT_Report_" + time + ".html";
            ExtentSparkReporter spark = new ExtentSparkReporter(path);
            spark.config().setReportName("MakeMyTrip Automation Report");
            spark.config().setDocumentTitle("BDD Execution Report");
            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Tester", tester);
            extent.setSystemInfo("Browser", browser);
            extent.setSystemInfo("Environment", env);
            extent.setSystemInfo("Framework", "Selenium + Cucumber + TestNG");
        }
    }

    public static synchronized void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}