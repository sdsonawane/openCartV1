package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {

		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-email']")
	@CacheLookup
	WebElement txtEmailAddress;

	@FindBy(xpath = "//input[@id='input-password']")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(xpath = "//input[@type='submit']")
	@CacheLookup
	WebElement btnLogin;

	public void setEmail(String email) {

		txtEmailAddress.sendKeys(email);
	}

	public void setPassword(String pwd) {

		txtPassword.sendKeys(pwd);
	}

	public void clickLogin() {

		btnLogin.click();

	}
	/*
	 * public MyAccountPage clickLogin() {
	 * 
	 * btnLogin.click(); return new MyAccountPage(driver); // we are linking (page
	 * chaining) two pages with login page and my account page }
	 */

}
