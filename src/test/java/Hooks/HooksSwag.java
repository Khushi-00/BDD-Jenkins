package Hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.DriverFactory;

public class HooksSwag {
	
	@Before
    public void setUp() {
        DriverFactory.getDriver();
        System.out.println("Browser launched before scenario");
    }

    @After
    public void tearDown(Scenario scenario) {
        WebDriver driver = DriverFactory.getDriver();
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Failed Screenshot");
                System.out.println("Screenshot taken for failed scenario");
            } catch (Exception e) {
                System.out.println("Error taking screenshot: " + e.getMessage());
            }
        }
        DriverFactory.quitDriver();
        System.out.println("Browser closed after scenario");
    }

}
