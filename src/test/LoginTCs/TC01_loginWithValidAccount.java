package LoginTCs;

import org.testng.Assert;
import org.testng.annotations.Test;
import Common.Constant;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import TestBase.TestBase;

public class TC01_loginWithValidAccount extends TestBase{
	/**
	 * TC01 - User can log into Railway with valid username and password
	 * @author lam.tung.nguyen
	 */
//	@AfterTest
//	public void logoutAccount() {
//		GeneralPage generalPage = new GeneralPage();
//		generalPage.logout();
//	}
	
	@Test(description = "TC01 - User can log into Railway with valid username and password")
	public void TC01() {
		log.info("TC01 - User can log into Railway with valid username and password");	
		log.info("Step 1: Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		homePage.open();
		
		log.info("Step 2: Go to Login tab");
		LoginPage loginPage = homePage.gotoLoginPage();
		
		log.info("Step 3: Login with valid username and password");
		loginPage.login(Constant.validUsername, Constant.validPassword);
		
		log.info("VP: Check welcome message displayed as expected");
		Assert.assertEquals(homePage.getWelcomeMsg(), expectedMsg, "Welcome message is not displayed as expected");
	}
	private String expectedMsg 	= "Welcome " + Constant.validUsername;
}
