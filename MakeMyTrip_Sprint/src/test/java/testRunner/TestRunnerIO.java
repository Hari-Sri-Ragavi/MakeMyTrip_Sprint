package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/features/CabTripDetails.feature"}, 
glue={"stepDefinition", "hooks"},
dryRun=false)
public class TestRunnerIO extends AbstractTestNGCucumberTests {

}
