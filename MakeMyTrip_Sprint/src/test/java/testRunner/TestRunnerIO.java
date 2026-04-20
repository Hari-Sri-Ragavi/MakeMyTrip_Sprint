package testRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/features/trainAddPassenger.feature"}, 
glue={"stepDefinition", "hooks"},
dryRun=false)
public class TestRunnerIO extends AbstractTestNGCucumberTests {
	 @Override
	    @DataProvider(parallel = true)
	    public Object[][] scenarios() {
	        return super.scenarios();
	    }
}
