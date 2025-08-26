package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverFactory;

public class RegisterHooks {

    @Before
    public void beforeScenario() {
        System.out.println("Browser launched before scenario");
        DriverFactory.getDriver();
    }

    @After
    public void afterScenario() {
        System.out.println("Browser closed after scenario");
        DriverFactory.quitDriver();
    }
}
