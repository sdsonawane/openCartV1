package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	
	public HomePage(WebDriver driver) {
		
		super(driver);
	}
	
@FindBy(xpath="//a[@title='My Account']")
@CacheLookup
WebElement lnkMyAccount; 

//@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Register']")
//@FindBy(xpath = "//a[text()='Register']")
@FindBy(linkText = "Register")
@CacheLookup
WebElement lnkRegister; 

//@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Login']")
@FindBy(linkText = "Login")
@CacheLookup
WebElement linkLogin;


public void clickMyAccount()
{
	lnkMyAccount.click();
	
}

public void clickRegister() 
{
	lnkRegister.click();
	
}

public void clickLogin() {
	
	linkLogin.click();
}
}
