package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.*;
import utils.DriverFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;


public class StepDefinitionsSwag {
	
	WebDriver driver = DriverFactory.getDriver();

    @Given("User is on the SauceDemo login page")
    public void user_is_on_the_saucedemo_login_page() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);
    }

    @When("user enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) throws InterruptedException {
        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys(username);
        Thread.sleep(1000);

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(1000);
    }

    @And("user clicks the login button")
    public void user_clicks_the_login_button() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        WebElement productsTitle = driver.findElement(By.xpath("//span[text()='Products']"));
        if (!productsTitle.isDisplayed()) {
            throw new AssertionError("Login failed - Products page not displayed");
        }
    }

    @When("user selects the first product and adds it to cart")
    public void user_selects_first_product_and_adds_to_cart() throws InterruptedException {
        driver.findElement(By.cssSelector(".inventory_item:first-child button")).click();
        Thread.sleep(2000);
    }

    @And("user goes to cart")
    public void user_goes_to_cart() throws InterruptedException {
        driver.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(2000);
    }
    @And("user clicks checkout")
    public void user_clicks_checkout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkoutBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout")));
        checkoutBtn.click();
    }



    @And("user enters first name {string}, last name {string}, postal code {string}")
    public void user_enters_checkout_details(String firstName, String lastName, String postalCode) throws InterruptedException {
        driver.findElement(By.id("first-name")).sendKeys(firstName);
        driver.findElement(By.id("last-name")).sendKeys(lastName);
        driver.findElement(By.id("postal-code")).sendKeys(postalCode);
        Thread.sleep(4000);
    }

    @And("user clicks continue and finish")
    public void user_clicks_continue_and_finish() throws InterruptedException {
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();
        Thread.sleep(1000);
    }

    @Then("order should be placed successfully")
    public void order_should_be_placed_successfully() {
        WebElement confirmation = driver.findElement(By.xpath("//h2[text()='Thank you for your order!']"));
        if (!confirmation.isDisplayed()) {
            throw new AssertionError("Order confirmation not displayed");
        }
    }

}
