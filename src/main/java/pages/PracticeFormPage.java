package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticeFormPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By firstName = By.id("firstname");
    private By lastName = By.id("lastname");
    private By genderMale = By.id("sex-0");
    private By yearsExp = By.id("exp-4");
    private By date = By.id("datepicker");
    private By professionTester = By.id("profession-0");
    private By toolSelenium = By.id("tool-2");
    private By continentAsia = By.id("continents");
    private By seleniumCmds = By.id("selenium_commands");
    private By fileUpload = By.id("photo");
    private By submitBtn = By.id("submit");

    public void fillForm() throws InterruptedException {
        WebElement fname = wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
        fname.sendKeys("John");
        Thread.sleep(500);

        driver.findElement(lastName).sendKeys("Doe");
        Thread.sleep(500);

        driver.findElement(genderMale).click();
        Thread.sleep(500);

        driver.findElement(yearsExp).click();
        Thread.sleep(500);

        driver.findElement(date).sendKeys("22-08-2025");
        Thread.sleep(500);

        driver.findElement(professionTester).click();
        Thread.sleep(500);

        driver.findElement(toolSelenium).click();
        Thread.sleep(500);

        driver.findElement(continentAsia).sendKeys("Asia");
        Thread.sleep(500);

        driver.findElement(seleniumCmds).sendKeys("Browser Commands");
        Thread.sleep(500);

        driver.findElement(fileUpload).sendKeys("C:\\path\\to\\file.txt");
        Thread.sleep(1000);

        driver.findElement(submitBtn).click();
        Thread.sleep(2000);
    }
}
