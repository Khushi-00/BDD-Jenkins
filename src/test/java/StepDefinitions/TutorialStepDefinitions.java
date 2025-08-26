package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import io.cucumber.java.en.*;

public class TutorialStepDefinitions {
    WebDriver driver;

    @Given("user navigates to the registration page")
    public void user_navigates_to_the_registration_page() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        Thread.sleep(2000); // Wait for page to load
    }

    @When("user enters valid details in the form")
    public void user_enters_valid_details_in_the_form() throws InterruptedException {
        driver.findElement(By.name("name")).sendKeys("Khushi");
        Thread.sleep(500);

        driver.findElement(By.name("email")).sendKeys("khushi@example.com");
        Thread.sleep(500);

        driver.findElement(By.xpath("//label[normalize-space()='Female'][1]")).click();
        Thread.sleep(500);

        driver.findElement(By.name("mobile")).sendKeys("9876543210");
        Thread.sleep(500);

        driver.findElement(By.name("dob")).sendKeys("01/01/2000");
        Thread.sleep(500);

        driver.findElement(By.name("subjects")).sendKeys("Computer Science");
        Thread.sleep(500);

        driver.findElement(By.xpath("(//label[normalize-space()='Reading'])[1]")).click();
        Thread.sleep(500);

        driver.findElement(By.id("picture")).sendKeys("C:\\Users\\Khushi\\OneDrive - Amity University\\Pictures\\Woman reading-pana.png");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//textarea[@id='picture']")).sendKeys("Sirsi road");
        Thread.sleep(500);

        driver.findElement(By.xpath("//select[@id='state']")).sendKeys("Delhi");
        Thread.sleep(500);

        driver.findElement(By.xpath("//select[@id='city']")).sendKeys("New Delhi");
        Thread.sleep(1000);
    }

    @And("user submits the form")
    public void user_submits_the_form() throws InterruptedException {
        WebElement submitBtn = driver.findElement(By.cssSelector("input[type='submit']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true);", submitBtn);
        Thread.sleep(1000); // Let layout settle

        js.executeScript("arguments[0].click();", submitBtn);
        Thread.sleep(2000); // Wait for submission to process
    }

    @Then("form should be submitted successfully")
    public void form_should_be_submitted_successfully() {
        System.out.println("Form submitted successfully.");
        driver.quit();
    }
}
