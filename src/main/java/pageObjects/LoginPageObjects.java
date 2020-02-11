package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {
	
	WebDriver driver;
	
	public LoginPageObjects(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_email")
	WebElement email;
	
	@FindBy(id="user_password")
	WebElement password;
	
	@FindBy(xpath="//input[@name='commit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//div[@class='alert alert-danger']")
	WebElement loginError;
	
	public WebElement email()
	{
		return email;
	}

	public WebElement password()
	{
		return password;
	}
	
	public WebElement loginButton()
	{
		return loginBtn;
	}
	
	public WebElement loginError()
	{
		return loginError;
	}
}


