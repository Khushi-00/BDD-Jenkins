package StepDefinitions;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.loginpage;
import utils.DriverFactory;

public class Step22Definitions {
	
	WebDriver driver = DriverFactory.getDriver();
	loginpage lp = new loginpage(driver);

	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() throws InterruptedException {

		// launch the application on the chrome browser

				Thread.sleep(10000);
 
				driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
 
				Thread.sleep(2000);
 
	}
 
	@When("the user enters username {string} and password {string}")
	public void the_user_enters_username_and_password(String username, String password) throws InterruptedException {
 
	lp.enterCredentials(username, password);

	}
 
	@Then("the user should be navigated to the home page")

	public void the_user_should_be_navigated_to_the_home_page() {

		lp.clickLogin();

	}

 
}
