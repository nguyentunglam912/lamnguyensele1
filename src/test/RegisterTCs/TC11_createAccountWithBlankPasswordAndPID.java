package RegisterTCs;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common.Constant;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import TestBase.TestBase;

public class TC11_createAccountWithBlankPasswordAndPID extends TestBase{
	/**
	 * TC11 - User can't create account while password and PID fields are empty
	 * @author lam.tung.nguyen
	 */
	@Test
	public void TC11() {
		log.info("TC11 - User can't create account while password and PID fields are empty");	
		log.info("Step 1: Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		homePage.open();
		
		log.info("Step 2: Go to Register tab");
		RegisterPage registerPage = homePage.gotoRegisterPage();
		
		log.info("Step 3: Enter valid email address and leave other fields empty");
		registerPage.registerAccount(Constant.emailRegister, Constant.blankPassword,  Constant.blankPassword, Constant.blankPidnumber);
		
		log.info("VP1: Message 'There're errors in the form. Please correct the errors and try again. ' appears.");
		Assert.assertEquals(registerPage.getRegisterErrorMessage(), registerErrMsg);
		
		log.info("VP2: Next to password fields, error message 'Invalid password length.' displays");
		Assert.assertEquals(registerPage.getPasswordError(), passwordErrMsg);
		
		log.info("VP3: Next to PID field, error message 'Invalid ID length.' displays");
		Assert.assertEquals(registerPage.getPIDError(), pidErrorMsg);
	}
	private String registerErrMsg 	= "There're errors in the form. Please correct the errors and try again.";
	private String passwordErrMsg	= "Invalid password length.";
	private String pidErrorMsg		= "Invalid ID length.";
}
