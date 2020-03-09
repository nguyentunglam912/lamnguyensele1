package LoginTCs;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common.Constant;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import TestBase.TestBase;

public class TC08_loginWithAccountHasNotBeenActivated extends TestBase{
	/**
	 * TC08 - User can't login with an account hasn't been activated
	 * @author lam.tung.nguyen
	 */
	@Test
	public void TC08() {
		log.info("TC08 - User can't login with an account hasn't been activated");	
		log.info("Pre-Condition: Create a new account but do not activate it");
		RegisterPage registerPage = TestBase.createWithoutActive();
		
		log.info("Step 1: Navigate to QA Railway Website");		
		log.info("Step 2: Go to Login tab");
		LoginPage loginPage = registerPage.gotoLoginPage();
		
		log.info("Step 3: Login with account has not been activated");
		loginPage.loginExpectingError(Constant.emailRegister, Constant.validPassword);
		
		log.info("VP: User can't login and message 'Invalid username or password. Please try again.' appears.");
		Assert.assertEquals(loginPage.getLoginErrorMessage(), expectedMsg);
	}
	private String expectedMsg 	= "Invalid username or password. Please try again.";
}
