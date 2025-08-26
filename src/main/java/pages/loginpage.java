package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginpage {
	
	// locators + page actions + constructor 
		private WebDriver driver;
		// locators 
		private By  usernameField = By.name("username");
		private By  passwordField = By.name("password");
		private By loginButton = By.xpath("//button[normalize-space()='Login']");
		// constructor
	 
		
		public loginpage(WebDriver driver) {
			this.driver = driver;
		}

		// page actions 
		 // Actions
	    public void enterCredentials(String username,String password) 
	    		throws InterruptedException {
	    	Thread.sleep(4000);
	        driver.findElement(usernameField).sendKeys(username);
	        driver.findElement(passwordField).sendKeys(password);
	    }
	 
		
	    public void clickLogin() {
	        driver.findElement(loginButton).click();
	    }
	 
	    public String getPageTitle() {
	        return driver.getTitle();
	    }

}
