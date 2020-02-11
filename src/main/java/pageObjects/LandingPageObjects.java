package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPageObjects {

	WebDriver driver;

	public LandingPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a[href*='sign_in']")
	WebElement login;

	By popup = By.xpath("//button[text()='NO THANKS']");

	public WebElement linkLogin() {
		return login;
	}

	public int getPopUpsize() {
		return driver.findElements(popup).size();
	}

	public WebElement getPopUp()
	{
		return driver.findElement(popup);
	}
}
