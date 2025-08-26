package Hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class TutorialHooks {
    public static WebDriver driver;

    @Before
    public void setUp() {
        System.out.println("Starting browser...");
    }

    @After
    public void tearDown() {
        System.out.println("Closing browser...");
    }
}
