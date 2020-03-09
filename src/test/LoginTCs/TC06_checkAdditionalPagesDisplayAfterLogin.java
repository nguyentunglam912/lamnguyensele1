package LoginTCs;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common.Constant;
import PageObjects.ChangePasswordPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyTicketPage;
import TestBase.TestBase;

public class TC06_checkAdditionalPagesDisplayAfterLogin extends TestBase{
	/**
	 * TC03 - Additional pages display once user logged in
	 * @author lam.tung.nguyen
	 */
	@Test
	public void TC06() {
		log.info("TC01 - User can log into Railway with valid username and password");	
		log.info("Step 1: Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		homePage.open();
		
		log.info("Step 2: Go to Login tab");
		LoginPage loginPage = homePage.gotoLoginPage();
		
		log.info("Step 3: Login with valid username and password");
		loginPage.login(Constant.validUsername, Constant.validPassword);
		
		log.info("VP1: 'My ticket', 'Change password' and 'Logout' tabs are displayed");
		Assert.assertTrue(loginPage.checkTabTicketDisplayed());
		Assert.assertTrue(loginPage.checkTabChangePasswordDisplayed());
		Assert.assertTrue(loginPage.checkTabLogoutDisplayed());
		
		log.info("VP2: Click 'My ticket' tab, user will be directed to My ticket page");
		MyTicketPage myTicketPage = loginPage.gotoMyticketPage();
		Assert.assertTrue(myTicketPage.checkPageDisplayed(Constant.myTicketPage));
		
		log.info("VP3: Click 'Change password' tab, user will be directed to Change password page");
		ChangePasswordPage changePasswordPage = myTicketPage.gotoChangePassword();
		Assert.assertTrue(changePasswordPage.checkPageDisplayed(Constant.changePasswordPage));
	}
}
