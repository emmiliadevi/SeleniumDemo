package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

import pageObjects.LoginPageObjects;

public class base {

	public static WebDriver driver = null;
	public Properties prop;

	public WebDriver initilizeDriver() throws IOException {
		prop = new Properties();
		FileInputStream varscr = new FileInputStream(
				System.getProperty("user.dir")+"\\src\\main\\java\\resources\\GlobalVariable.properties");
		prop.load(varscr);

		if (System.getProperty("browser").equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (System.getProperty("browser").contains("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
			/*ChromeOptions options = new ChromeOptions();
			if (System.getProperty("browser").contains("headless")){
				options.addArguments("headless");
			}*/
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public void loginAccount() throws IOException {
		prop = new Properties();
		FileInputStream varscr = new FileInputStream(
				System.getProperty("user.dir")+"\\src\\main\\java\\resources\\GlobalVariable.properties");
		prop.load(varscr);

		String email = prop.getProperty("email"); // get email from global variable
		//String pwd = prop.getProperty("password"); // get password from global variable

		LoginPageObjects loginp = new LoginPageObjects(driver); // get object element from page object
		loginp.email().sendKeys(email);
		loginp.password().sendKeys(prop.getProperty("password"));
		loginp.loginButton().click();
	}	
	
	public void getScreenshot(String result) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileHandler.copy(src, new File("D:\\WORK\\Selenium\\Screenshots\\"+result+"Screenshot.jpg"));
		FileHandler.copy(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+result+"Screenshot.jpg"));
		}
}

