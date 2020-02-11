package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pageObjects.LandingPageObjects;
import resources.base;


public class HomePageTest extends base {

	public static Logger log = LogManager.getLogger(HomePageTest.class.getName());
	
	@BeforeTest
	public void initilizaBrowser() throws IOException {
		driver = initilizeDriver();
		log.info("Browser successfully initialized");
		
	}

	// Call methods from base class, without hard coding
	@Test
	public void loginPageNavigation() throws IOException {
		driver.get(prop.getProperty("url"));
		LandingPageObjects landp = new LandingPageObjects(driver);
		landp.linkLogin().click();
		log.info("Click login link");
		loginAccount();
		log.info("Successfully tried login using method from base");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver=null;  //release memory heap
	}
}
