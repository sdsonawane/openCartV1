package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;


public class TC0003_LoginDDT extends BaseClass{
	
	@Test(dataProvider = "LoginData", dataProviderClass= DataProviders.class, groups="DataDriver") // getting dataProvider from different class
	public void verify_LoginDTT(String email, String pwd, String exp) {
		
		logger.info("**** Starting TC_0003_LoginDDT ****");
		
		//HomePage
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//Login
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		//MyAccount
		
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage = macc.isMyAccountPageExists();
		

		/* Valid data - login success -test passed
	 	Valid data - login failed - test failed
	 	Invalid data - login failed - test passed
	 	Invalid data - login passed - test failed
	 
	 */
		
		if(exp.equalsIgnoreCase("Valid")) {
			if(targetPage==true) {
			
				macc.clickLogout();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		
		
		if(exp.equalsIgnoreCase("Invalid")) {
		
			if(targetPage==true) {
				Thread.sleep(2000);
				macc.clickLogout();
				Assert.assertTrue(false);
			}
			else {
				
				Assert.assertTrue(true);
			}
		
		}
		
	}
		catch(Exception e) {
			Assert.fail();
		}
		
		
		logger.info("**** Finished TC_0003_LoginDDT ****");
	}
	
}
