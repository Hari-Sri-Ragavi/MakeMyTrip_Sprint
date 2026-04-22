package testRunner;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "./src/test/resources/features", 
        glue = { "stepDefinition", "hooks", "listener" }, 
        dryRun = false, 
		monochrome = true, 
		tags = "@HP",
		plugin = { "pretty", 
				  "summary",
				  "html:target/cucumber-report.html", 
				  "json:target/cucumber.json", 
				  "util.ExtentCucumberListener" 
				  }

)
public class TestRunnerIO extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}