package OtherTCs;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common.Constant;
import PageObjects.ForgotPasswordPage;
import PageObjects.LoginPage;
import PageObjects.MailigatorPage;
import PageObjects.RegisterPage;
import TestBase.TestBase;

public class TC13_resetPasswordWithPasswordAndConfirmPasswordDoNotMatch extends TestBase {
	/**
	 * TC13 - Errors display if password and confirm password don't match when
	 * resetting password
	 * 
	 * @author lam.tung.nguyen
	 */
	@Test
	public void TC13() {
		log.info("TC13 - Errors display if password and confirm password don't match when resetting password");
		log.info("Pre-Condition: Create a new account and activate it");
		RegisterPage registerPage = TestBase.createAndActiveAccount();

		log.info("Step 1: Navigate to QA Railway Login Page");
		LoginPage loginPage = registerPage.gotoLoginPage();

		log.info("Step 2: Go to Forgot Password tab");
		ForgotPasswordPage forgotPasswordPage = loginPage.gotoForgotPasswordPage();

		log.info("Step 3: Enter register email address and click 'Send Instructions' button");
		forgotPasswordPage.submitForgotPasswordForm(Constant.emailRegister);

		log.info("Step 4: Open mailbox and click on reset password link");
		MailigatorPage mailPage = forgotPasswordPage.navigateToMailinator();
		mailPage.navigateResetMailURL(Constant.emailRegister);

		log.info("VP1:'Password Change Form' page displays");
		Assert.assertTrue(forgotPasswordPage.checkChangePasswordDisplayed());

		log.info("Step 5: Enter different values for password fields");
		forgotPasswordPage.submitPasswordChangeForm(Constant.validPassword, Constant.blankPassword);

		log.info("VP2: Error message 'Could not reset password. Please correct the errors and try again.' displays above the form.");
		Assert.assertEquals(forgotPasswordPage.getChangePasswordErrorMessage(), changePasswordMsg);

		log.info("VP3: Error message 'The password confirmation did not match the new password.' displays next to the confirm password field.");
		Assert.assertEquals(forgotPasswordPage.getConfirmPasswordErrorMessage(), confirmPasswordMsg);
	}

	private String changePasswordMsg = "Could not reset password. Please correct the errors and try again.";
	private String confirmPasswordMsg = "The password confirmation did not match the new password.";
}
