package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserDashboardObject {
	
	WebDriver driver;
	
	public UserDashboardObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='navbar-current-user']")
	WebElement userName;
	
	
	public WebElement getUserAccountName()
	{
		return userName;
	}
}


