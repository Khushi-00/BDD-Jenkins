package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import utils.DriverFactory;

public class StepDefinitions {

    WebDriver driver = DriverFactory.getDriver();

    @Given("User is on the login page")
    public void user_is_on_the_login_page() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(2000);
    }

    @When("user enters the {string}")
    public void user_enters_the_username(String username) {
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    @When("user enters the {string} password")
    public void user_enters_the_password(String password) {
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    @When("user clicks on the login button")
    public void user_clicks_on_the_login_button() {
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
    }

    @Then("user is navigated to home page")
    public void user_is_navigated_to_home_page() {
        WebElement adminMenu = driver.findElement(By.xpath("//li[1]//a[1]//span[1]"));
        if (!adminMenu.isDisplayed()) {
            throw new AssertionError("Home Page not displayed — login failed");
        }
    }
}
