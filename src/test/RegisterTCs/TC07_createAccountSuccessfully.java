package RegisterTCs;

import org.testng.annotations.Test;

import Common.Constant;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import TestBase.TestBase;

public class TC07_createAccountSuccessfully extends TestBase{
	/**
	 * TC07 - User can create new account
	 * @author lam.tung.nguyen
	 */
	@Test
	public void TC07() {
		log.info("TC07 - User can create new account");	
		log.info("Step 1: Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		homePage.open();
		
		log.info("Step 2: Go to Register tab");
		RegisterPage registerPage = homePage.gotoRegisterPage();
		
		log.info("Step 3: Enter valid info and click Register button");
		registerPage.registerAccount(Constant.emailRegister, Constant.validPassword, Constant.validPassword, Constant.pidNumber);
		
		log.info("VP: New account is created and message 'Thank you for registering your account' appears.");
		registerPage.checkRegisterSuccess(expectedMsg);
	}
	private String expectedMsg 	= "Thank you for registering your account";
}
