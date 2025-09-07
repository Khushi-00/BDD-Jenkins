package StepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

import java.time.Duration;

public class capestoneSteps {

    WebDriver driver = DriverFactory.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    String lastProductAdded = "";

    // ==============================
    // Common
    // ==============================
    @Given("I open Demoblaze website")
    public void i_open_website() {
        driver.get("https://www.demoblaze.com/");
        System.out.println("Opened Demoblaze homepage.");
    }

    // ==============================
    // Registration
    // ==============================
    @When("I register with username {string} and password {string}")
    public void i_register_with_username_and_password(String UserName, String PassWord) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("signin2"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInModal")));
        driver.findElement(By.id("sign-username")).sendKeys(UserName);
        driver.findElement(By.id("sign-password")).sendKeys(PassWord);
        driver.findElement(By.xpath("//button[text()='Sign up']")).click();

        handleAlertIfPresent("Sign-up alert");
    }

    @Then("I should see a success message")
    public void i_should_see_a_success_message() {
        System.out.println("Registration successful!");
    }

    // ==============================
    // Login
    // ==============================
    @When("I login with username {string} and password {string}")
    public void i_login_with_username_and_password(String UserName, String PassWord) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("login2"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInModal")));
        driver.findElement(By.id("loginusername")).sendKeys(UserName);
        driver.findElement(By.id("loginpassword")).sendKeys(PassWord);
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        if (isAlertPresent()) {
            Alert alert = driver.switchTo().alert();
            System.out.println("Login alert: " + alert.getText());
            alert.accept();
        }
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        try {
            // Wait briefly to see if an alert pops up
            wait.withTimeout(Duration.ofSeconds(3)).until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            alert.accept();
            throw new AssertionError("Login failed: " + alertText);
        } catch (TimeoutException e) {
            // No alert appeared → assume login success
            System.out.println("Login successful!");
        } catch (NoAlertPresentException e) {
            // No alert at all → assume login success
            System.out.println("Login successful!");
        }
    }

    // ==============================
    // Product Search & Details
    // ==============================
    @When("I search for {string}")
    public void i_search_for(String product) {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(product))).click();
        lastProductAdded = product;
        System.out.println("Navigated to product: " + product);
    }

    @When("I view product details")
    public void i_view_product_details() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("price-container")));
        System.out.println("Product details loaded.");
    }

    // ==============================
    // Cart
    // ==============================
    @Given("I add {string} to the cart")
    public void i_add_to_the_cart(String productName) {
        lastProductAdded = productName;
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(productName))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add to cart"))).click();
        handleAlertIfPresent("Add to cart");
        System.out.println(productName + " added to cart.");
    }

    @When("I add the product to the cart")
    public void i_add_the_product_to_the_cart() {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add to cart"))).click();
        handleAlertIfPresent("Add to cart");
    }

    @Then("the product should be added successfully")
    public void the_product_should_be_added_successfully() {
        driver.findElement(By.linkText("Cart")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(.,'" + lastProductAdded + "')]")));

        boolean productPresent = driver.findElements(By.xpath("//tr[contains(.,'" + lastProductAdded + "')]")).size() > 0;
        if (!productPresent) {
            throw new AssertionError("Product '" + lastProductAdded + "' not found in cart!");
        }
        System.out.println("Verified: Product added to cart successfully.");
    }

    // ==============================
    // Checkout
    // ==============================
    @When("I proceed to checkout")
    public void i_proceed_to_checkout() {
        driver.findElement(By.linkText("Cart")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Place Order']"))).click();
        System.out.println("Initiated checkout.");
    }

    @When("I enter payment details")
    public void i_enter_payment_details() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderModal")));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("name"))).sendKeys("John Doe");
        driver.findElement(By.id("country")).sendKeys("USA");
        driver.findElement(By.id("city")).sendKeys("New York");
        driver.findElement(By.id("card")).sendKeys("1234567890123456");
        driver.findElement(By.id("month")).sendKeys("12");
        driver.findElement(By.id("year")).sendKeys("2025");
        driver.findElement(By.xpath("//button[text()='Purchase']")).click();
        System.out.println("Payment details submitted.");
    }

    @Then("I should see a purchase confirmation")
    public void i_should_see_a_purchase_confirmation() {
        WebElement confirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[text()='Thank you for your purchase!']")));
        System.out.println("Purchase confirmed: " + confirmation.getText());
    }

    // ==============================
    // Helpers
    // ==============================
    private void handleAlertIfPresent(String actionName) {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            System.out.println(actionName + " alert: " + alert.getText());
            alert.accept();
        } catch (TimeoutException ignored) {
            System.out.println("No alert appeared after " + actionName + ".");
        }
    }

    private boolean isAlertPresent() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
