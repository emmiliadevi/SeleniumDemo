package stepDefinations;

import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LandingPageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.UserDashboardObject;
import resources.base;

public class stepDefination extends base {

	@Given("^Initialize chrome browser$")
	public void initialize_chrome_browser() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver = initilizeDriver();
	}

	@Given("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_site(String url) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.get(url);
	}

	@Given("^Click on Login link to access login page$")
	public void click_on_Login_link_to_access_login_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		LandingPageObjects landp = new LandingPageObjects(driver);
		if(landp.getPopUpsize()>0)
		{
			landp.getPopUp().click();
		}
			
		landp.linkLogin().click();
	}

	  @When("^User enter (.+) and (.+) and logs in$")
	    public void user_enter_and_and_logs_in(String username, String password) throws Throwable {
		  LoginPageObjects loginP = new LoginPageObjects(driver);
			loginP.email().sendKeys(username);
			loginP.password().sendKeys(password);
			loginP.loginButton().click();     
	    }

	@Then("^Verify the user is successfully logged in$")
	public void verify_the_user_is_successfully_logged_in() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		
		UserDashboardObject udash = new UserDashboardObject(driver);
		Assert.assertEquals(udash.getUserAccountName().getText(),"Emmilia Devi");
	}
	
	   @And("^close browsers$")
	    public void close_browsers() throws Throwable {
	       driver.quit();
	    }

}
