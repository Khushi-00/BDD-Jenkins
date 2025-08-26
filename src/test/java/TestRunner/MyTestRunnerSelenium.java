package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

public class MyTestRunnerSelenium {
	
	@RunWith(Cucumber.class)
	@CucumberOptions(
	    features = "src/test/resources/features",
	    glue = {"stepDefinitions", "hooks"},
	    plugin = {"pretty", "html:target/cucumber-reports.html"},
	    monochrome = true
	)
	public class TestRunner {
	}


}
