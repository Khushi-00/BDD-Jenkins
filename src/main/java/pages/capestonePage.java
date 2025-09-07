package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class capestonePage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Home
    @FindBy(id = "signin2") WebElement signUpBtn;
    @FindBy(id = "login2") WebElement loginBtn;
    @FindBy(id = "logout2") WebElement logoutBtn;
    @FindBy(id = "cartur") WebElement cartBtn;

    // Sign Up
    @FindBy(id = "sign-username") WebElement signUpUsername;
    @FindBy(id = "sign-password") WebElement signUpPassword;
    @FindBy(xpath = "//button[text()='Sign up']") WebElement signUpConfirm;

    // Login
    @FindBy(id = "loginusername") WebElement loginUsername;
    @FindBy(id = "loginpassword") WebElement loginPassword;
    @FindBy(xpath = "//button[text()='Log in']") WebElement loginConfirm;

    // Product
    @FindBy(xpath = "//a[text()='Add to cart']") WebElement addToCartBtn;

    // Cart
    @FindBy(xpath = "//button[text()='Place Order']") WebElement placeOrderBtn;

    // Order Form
    @FindBy(id = "name") WebElement name;
    @FindBy(id = "country") WebElement country;
    @FindBy(id = "city") WebElement city;
    @FindBy(id = "card") WebElement card;
    @FindBy(id = "month") WebElement month;
    @FindBy(id = "year") WebElement year;
    @FindBy(xpath = "//button[text()='Purchase']") WebElement purchaseBtn;
    @FindBy(xpath = "//h2[text()='Thank you for your purchase!']") WebElement confirmationMsg;

    // Constructor
    public capestonePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Methods
    public void openSite() {
        driver.get("https://www.demoblaze.com/");
    }

    public void signUp(String user, String pass) {
        wait.until(ExpectedConditions.elementToBeClickable(signUpBtn)).click();
        wait.until(ExpectedConditions.visibilityOf(signUpUsername)).sendKeys(user);
        signUpPassword.sendKeys(pass);
        signUpConfirm.click();
        handleAlert("Sign-up");
    }

    public void login(String user, String pass) {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
        wait.until(ExpectedConditions.visibilityOf(loginUsername)).sendKeys(user);
        loginPassword.sendKeys(pass);
        loginConfirm.click();
        handleAlert("Login");
    }

    public void selectProduct(String productName) {
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(
                By.linkText(productName)));
        product.click();
    }

    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
        handleAlert("Add to Cart");
    }

    public void goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartBtn)).click();
    }

    public void placeOrder(String n, String c, String ci, String cd, String m, String y) {
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
        wait.until(ExpectedConditions.visibilityOf(name)).sendKeys(n);
        country.sendKeys(c);
        city.sendKeys(ci);
        card.sendKeys(cd);
        month.sendKeys(m);
        year.sendKeys(y);
        purchaseBtn.click();
    }

    public boolean isConfirmationDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(confirmationMsg)).isDisplayed();
    }

    // Alert handler
    private void handleAlert(String context) {
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println(context + " alert: " + alert.getText());
            alert.accept();
        } catch (TimeoutException e) {
            System.out.println("No alert appeared after " + context + ".");
        }
    }
}
