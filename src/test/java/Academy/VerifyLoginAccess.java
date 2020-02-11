package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPageObjects;
import pageObjects.LoginPageObjects;
import resources.base;

public class VerifyLoginAccess extends base {

	public static Logger log = LogManager.getLogger(VerifyLoginAccess.class.getName());

	@BeforeTest
	public void initilizaBrowser() throws IOException {
		driver = initilizeDriver();
		log.info("Browser successfully initialized");
	}

	@Test(dataProvider = "logindata")
	public void login(String email, String password, String text) throws IOException {
		driver.get(prop.getProperty("url"));
		LandingPageObjects landP = new LandingPageObjects(driver);
		landP.linkLogin().click();
		log.info("Click login link");
		LoginPageObjects loginP = new LoginPageObjects(driver);
		loginP.email().sendKeys(email);
		loginP.password().sendKeys(password);
		loginP.loginButton().click();
		Assert.assertEquals(loginP.loginError().getText(), text);
		log.info("Successfully tested login combination");

	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver=null;
	}

	@DataProvider
	public Object[][] logindata() {
		Object[][] logindata = new Object[2][3];

		logindata[0][0] = "validuser@gmail.com";
		logindata[0][1] = "abc12345";
		logindata[0][2] = "Invalid email or password123.";

		logindata[1][0] = "invaliduser@gmail.com";
		logindata[1][1] = "abc1234";
		logindata[1][2] = "Invalid email or password123.";

		return logindata;
	}

}
