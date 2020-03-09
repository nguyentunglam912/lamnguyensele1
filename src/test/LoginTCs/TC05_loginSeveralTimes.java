package LoginTCs;

import org.testng.Assert;
import org.testng.annotations.Test;
import Common.Constant;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import TestBase.TestBase;

public class TC05_loginSeveralTimes extends TestBase{
	/**
	 * TC05 - System shows message when user enters wrong password several times 
	 * @author lam.tung.nguyen
	 */
	@Test
	public void TC05() {
		log.info("TC05 - System shows message when user enters wrong password several times");	
		log.info("Step 1: Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		homePage.open();
		
		log.info("Step 2: Go to Login tab");
		LoginPage loginPage = homePage.gotoLoginPage();
		
		log.info("Step 3: Enter valid info into Username textbox except Password 4 times");
		loginPage.loginSeveralTime(Constant.validUsername, Constant.blankPassword, 4);
		
		log.info("VP: Check login error message displayed as expected");
		Assert.assertEquals(loginPage.getLoginErrorMessage(), expectedMsg, "Login error message is not displayed as expected");
	}
	private String expectedMsg 	= "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
}
