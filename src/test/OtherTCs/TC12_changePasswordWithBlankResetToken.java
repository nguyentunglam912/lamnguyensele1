package OtherTCs;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common.Constant;
import PageObjects.ForgotPasswordPage;
import PageObjects.LoginPage;
import PageObjects.MailigatorPage;
import PageObjects.RegisterPage;
import TestBase.TestBase;

public class TC12_changePasswordWithBlankResetToken extends TestBase{
	/**
	 * TC12 - Errors display when password reset token is blank
	 * 
	 * @author lam.tung.nguyen
	 */
	@Test
	public void TC12() {
		log.info("TC13 - Errors display when password reset token is blank");
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
		
		log.info("Step 5: remove the Password Reset Token");
		forgotPasswordPage.clearResetTokenTextBox();
		
		log.info("Step 6: Enter values for password fields");
		forgotPasswordPage.submitPasswordChangeForm(Constant.validPassword, Constant.validPassword);

		log.info("VP2: Error message 'The password reset token is incorrect or may be expired. Visit the forgot password page to generate a new one.' displays above the form.");
		Assert.assertEquals(forgotPasswordPage.getChangePasswordErrorMessage(), changePasswordMsg);

		log.info("VP3: Error message 'The password reset token is invalid.' displays next to the 'Password Reset Token' field.");
		Assert.assertEquals(forgotPasswordPage.getConfirmPasswordErrorMessage(), resetTokenErrorMsg);
	}

	private String changePasswordMsg = "The password reset token is incorrect or may be expired. Visit the forgot password page to generate a new one.";
	private String resetTokenErrorMsg = "The password reset token is invalid.";
}
