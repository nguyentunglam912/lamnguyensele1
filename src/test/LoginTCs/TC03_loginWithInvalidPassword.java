package LoginTCs;

import org.testng.Assert;
import org.testng.annotations.Test;
import Common.Constant;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import TestBase.TestBase;

public class TC03_loginWithInvalidPassword extends TestBase{
	/**
	 * TC03 - User cannot log into Railway with invalid password 
	 * @author lam.tung.nguyen
	 */
	@Test
	public void TC03() {
		log.info("TC03 - User cannot log into Railway with invalid password ");	
		log.info("Step 1: Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		homePage.open();
		
		log.info("Step 2: Go to Login tab");
		LoginPage loginPage = homePage.gotoLoginPage();
		
		log.info("Step 3: Login with invalid password");
		loginPage.loginExpectingError(Constant.blankUsername, Constant.validPassword);
		
		log.info("VP: Check login error message displayed as expected");
		Assert.assertEquals(loginPage.getLoginErrorMessage(), expectedMsg, "Login error message is not displayed as expected");
	}
	private String expectedMsg 	= "There was a problem with your login and/or errors exist in your form.";
}
