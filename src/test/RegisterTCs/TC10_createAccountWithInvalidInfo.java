package RegisterTCs;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common.Constant;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import TestBase.TestBase;

public class TC10_createAccountWithInvalidInfo extends TestBase{
	/**
	 * TC10 - User can't create account with Confirm password is not the same with Password
	 * @author lam.tung.nguyen
	 */
	@Test
	public void TC10() {
		log.info("TC10 - User can't create account with Confirm password is not the same with Password");	
		log.info("Step 1: Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		homePage.open();
		
		log.info("Step 2: Go to Register tab");
		RegisterPage registerPage = homePage.gotoRegisterPage();
		
		log.info("Step 3: Enter valid information into all fields except Confirm password is not the same with Password");
		registerPage.registerAccount(Constant.emailRegister, Constant.validPassword,  Constant.newPassword, Constant.pidNumber);
		
		log.info("VP: Message 'There're errors in the form. Please correct the errors and try again. ' appears.");
		Assert.assertEquals(registerPage.getRegisterErrorMessage(), expectedMsg);
	}
	private String expectedMsg 	= "There're errors in the form. Please correct the errors and try again.";
}
