package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	@CacheLookup
	WebElement txtFirstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	@CacheLookup
	WebElement txtLastName;

	@FindBy(xpath = "//input[@id='input-email']")
	@CacheLookup
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='input-telephone']")
	@CacheLookup
	WebElement txtTelephone;

	@FindBy(xpath = "//input[@id='input-password']")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(xpath = "//input[@id='input-confirm']")
	@CacheLookup
	WebElement txtConfirmPassword;

	@FindBy(xpath = "//input[@name='agree']")
	@CacheLookup
	WebElement chkPolicy;

	@FindBy(xpath = "//input[@value='Continue']")
	@CacheLookup
	WebElement btnContinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	@CacheLookup
	WebElement msgConfirmation;

	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}

	public void setLastName(String lname) {
		txtLastName.sendKeys(lname);
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setTelephone(String tel) {
		txtTelephone.sendKeys(tel);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void setConfirmPassword(String pwd) {
		txtConfirmPassword.sendKeys(pwd);
	}

	public void setPrivacyPolicy() {
		chkPolicy.click();
	}

	public void clickContinue() {
		btnContinue.click();
	}

	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}

	}
}