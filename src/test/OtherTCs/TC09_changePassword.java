package OtherTCs;

import org.testng.Assert;
import org.testng.annotations.Test;
import Common.Constant;
import PageObjects.ChangePasswordPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import TestBase.TestBase;

public class TC09_changePassword extends TestBase{
	/**
	 * TC09 - User can't login with an account hasn't been activated
	 * @author lam.tung.nguyen
	 */
	@Test
	public void TC09() {
		log.info("TC09 - User can change password");	
		log.info("Pre-Condition:  Create and activate a new account");
		RegisterPage registerPage = TestBase.createAndActiveAccount();
		
		log.info("Step 1: Navigate to QA Railway Website");		
		log.info("Step 2: Go to Login tab");
		LoginPage loginPage = registerPage.gotoLoginPage();
		
		log.info("Step 3: Login with valid info");
		HomePage homePage = loginPage.login(Constant.emailRegister, Constant.validPassword);
		
		log.info("Step 4: Go to Change Password tab");
		ChangePasswordPage changePasswordPage = homePage.gotoChangePassword();
		
		log.info("Step 5: submit a change password form");
		changePasswordPage.changePassword(Constant.validPassword, Constant.newPassword);
		
		log.info("VP1: Message 'Your password has been updated' appears.");
		Assert.assertEquals(changePasswordPage.getSuccessMessage(), expectedMsg);
		
		log.info("VP2: User can re-login with new password");
		Assert.assertTrue(changePasswordPage.checkReLoginWithNewPassword());
	}
	private String expectedMsg 	= "Your password has been updated!";
}
