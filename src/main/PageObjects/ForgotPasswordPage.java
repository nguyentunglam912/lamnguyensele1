package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Constant;
import Common.Utilities;

public class ForgotPasswordPage extends GeneralPage{
	//Locators
	private final By txtEmailAddress 		= By.xpath("//input[@title='Email address']");
	private final By btnSendInstructions 	= By.xpath("//input[@type='submit' and @value='Send Instructions']");
	private final By lblErrorMessage		= By.xpath("//p[@class='message error']");	
	private final By txtNewPassword			= By.id("newPassword");
	private final By txtConfirmPassword		= By.id("confirmPassword");
	private final By txtResetToken			= By.id("resetToken");
	private final By lblConfirmPwdErrorMsg 	= By.xpath("//label[@for='confirmPassword' and @class='validation-error']");
	private final By lblResetTokenErrorMsg 	= By.xpath("//label[@for='resetToken' and @class='validation-error']");
	private final By btnResetPassword		= By.xpath("//input[@type='submit' and @title='Reset password']");
	private final By formChangePassword	 	= By.xpath("//form//legend[text()='Password Change Form']");
	
	//Elements
	public WebElement getTextBoxbyName(By txtName) {
		return Constant.driver.findElement(txtName);
	}
	
	public WebElement getButtonbyName(By btnName) {
		return Constant.driver.findElement(btnName);
	}
	
	public WebElement getLblErrorMessage() {
		return Constant.driver.findElement(lblErrorMessage);
	}
	
	public WebElement getTextBoxErrorMsg(By lblMessageName) {
		return Constant.driver.findElement(lblMessageName);
	}
	
	public WebElement getFormChangePassword() {
		return Constant.driver.findElement(formChangePassword);
	}
	
	//Methods
	public ForgotPasswordPage submitForgotPasswordForm(String emailRegister) {
		this.getTextBoxbyName(txtEmailAddress).sendKeys(emailRegister);
		this.getButtonbyName(btnSendInstructions).click();
		return this;
	}
	
	public void clickResetPasswordLink() {
		Constant.driver.navigate().to(Constant.mailigatorURL);
		MailigatorPage mailPage = new MailigatorPage();
		mailPage.navigateResetMailURL(Constant.emailRegister);
	}
	
	public ForgotPasswordPage submitPasswordChangeForm(String newPassword, String confirmPassword) {
		Utilities.scrollByVisibleElement(btnResetPassword);
		this.getTextBoxbyName(txtNewPassword).sendKeys(newPassword);
		this.getTextBoxbyName(txtConfirmPassword).sendKeys(confirmPassword);
		this.getButtonbyName(btnResetPassword).click();
		return this;
	}
	
	public String getChangePasswordErrorMessage() {
		return this.getLblErrorMessage().getText().trim();
	}
	
	public String getConfirmPasswordErrorMessage() {
		return this.getTextBoxErrorMsg(lblConfirmPwdErrorMsg).getText().trim();
	}
	
	public String getResetTokenErrorMessage() {
		return this.getTextBoxErrorMsg(lblResetTokenErrorMsg).getText().trim();
	}
	
	public boolean checkChangePasswordDisplayed() {
		return this.getFormChangePassword().isDisplayed();
	}
	
	public void clearResetTokenTextBox() {
		this.getTextBoxbyName(txtResetToken).clear();
	}
}
