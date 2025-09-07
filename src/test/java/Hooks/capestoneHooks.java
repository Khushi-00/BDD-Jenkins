package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverFactory;

public class capestoneHooks {

    @Before
    public void setup() {
        System.out.println("Browser launched before scenario");
        DriverFactory.getDriver(); // Ensures driver is actually started
    }

    @After
    public void tearDown() {
        System.out.println("Closing browser...");
        DriverFactory.quitDriver();
        System.out.println("Browser closed after scenario");
    }
}
