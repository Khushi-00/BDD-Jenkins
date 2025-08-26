package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

public class MySwagTestRunner {
	
	@RunWith(Cucumber.class)
	@CucumberOptions(
	    features = "src/test/resources/Features",
	    glue = {"StepDefinitions", "Hooks"}
	)
	public class MyTestRunner {

	}

}
