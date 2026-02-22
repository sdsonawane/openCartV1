package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC0001_Acc_RegistrationTest extends BaseClass {

	@Test(groups = { "Regression", "Master" })
	public void verify_Account_Registration() {

		logger.info("**** starting TC0001_Acc_RegistrationTest******");

		try {
			HomePage hp = new HomePage(driver);

			hp.clickMyAccount();
			logger.info("Clicked on My Account Link");

			hp.clickRegister();
			logger.info("Clicked on Register link");

			AccountRegistrationPage regPage = new AccountRegistrationPage(driver);

			logger.info("Providing customer details... ");
			regPage.setFirstName(randomString().toUpperCase());
			regPage.setLastName(randomString().toUpperCase());
			regPage.setEmail(randomString() + "@gmail.com");
			regPage.setTelephone(randomNumber());

			// password set as alphaNumeric
			String password = randomAlphaNumeric();
			regPage.setPassword(password);
			regPage.setConfirmPassword(password);

			regPage.setPrivacyPolicy();
			regPage.clickContinue();

			logger.info("Validating expected message...");
			String confmsg = regPage.getConfirmationMsg();

			if (confmsg.equals("Your Account Has Been Created!")) {

				Assert.assertTrue(true);
			} else {

				logger.error("Test failed...");
				logger.debug("Debug logs... ");
				Assert.assertTrue(false);
			}

			// Assert.assertEquals(confmsg, "Your Account Has Been created!");
		} catch (Exception e) {

			Assert.fail();

		}

		logger.info("**** Finished TC0001_Acc_RegistrationTest******");

	}

}
