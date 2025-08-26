package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Lab22RegisterPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public Lab22RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    private By firstName = By.name("firstName");
    private By lastName = By.name("lastName");
    private By phone = By.name("phone");
    private By email = By.id("userName");
    private By address = By.name("address1");
    private By city = By.name("city");
    private By state = By.name("state");
    private By postalCode = By.name("postalCode");
    private By country = By.name("country");
    private By username = By.id("email");
    private By password = By.name("password");
    private By confirmPassword = By.name("confirmPassword");
    private By submitBtn = By.name("submit");

    // Actions
    public void openRegistrationPage() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");
    }

    public void fillForm(String fName, String lName, String ph, String mail, String addr,
                         String cty, String st, String pCode, String cntry,
                         String uName, String pwd, String cPwd) throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(fName);
        Thread.sleep(500);
        driver.findElement(lastName).sendKeys(lName);
        Thread.sleep(500);
        driver.findElement(phone).sendKeys(ph);
        Thread.sleep(500);
        driver.findElement(email).sendKeys(mail);
        Thread.sleep(500);
        driver.findElement(address).sendKeys(addr);
        Thread.sleep(500);
        driver.findElement(city).sendKeys(cty);
        Thread.sleep(500);
        driver.findElement(state).sendKeys(st);
        Thread.sleep(500);
        driver.findElement(postalCode).sendKeys(pCode);
        Thread.sleep(500);

        Select countrySelect = new Select(driver.findElement(country));
        countrySelect.selectByVisibleText(cntry);
        Thread.sleep(500);

        driver.findElement(username).sendKeys(uName);
        Thread.sleep(500);
        driver.findElement(password).sendKeys(pwd);
        Thread.sleep(500);
        driver.findElement(confirmPassword).sendKeys(cPwd);
        Thread.sleep(500);
    }

    public void submitForm() throws InterruptedException {
        try {
            // Wait for any overlay/ad to disappear
            Thread.sleep(2000); // sometimes ad shows after load

            // Scroll into view
            ((org.openqa.selenium.JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView(true);", driver.findElement(submitBtn));

            // Wait until clickable
            wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();

        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            System.out.println("Popup detected, trying to close...");

            // Try to close popup if exists
            try {
                driver.findElement(By.cssSelector(".cb-cross")).click();
                Thread.sleep(1000);
                wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
            } catch (Exception ex) {
                System.out.println("No popup found, retrying click...");
                wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
            }
        }
        Thread.sleep(2000);
    }

}
