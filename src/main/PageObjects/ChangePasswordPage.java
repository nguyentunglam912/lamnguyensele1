package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Constant;

public class ChangePasswordPage extends GeneralPage {
	// Locators
	private final By txtCurrentPassword = By.id("currentPassword");
	private final By txtNewPassword = By.id("newPassword");
	private final By txtConfirmPassword = By.id("confirmPassword");
	private final By btnChangePassword = By.xpath("//input[@type='submit' and @title='Change password']");
	private final By lblSuccessMsg = By.xpath("//p[@class='message success']");

	// Elements
	public WebElement getTextBox(By txtName) {
		return Constant.driver.findElement(txtName);
	}

	public WebElement getBtnChangePassword() {
		return Constant.driver.findElement(btnChangePassword);
	}

	public WebElement getLblSuccessMsg() {
		return Constant.driver.findElement(lblSuccessMsg);
	}

	// Methods
	public String getSuccessMessage() {
		return this.getLblSuccessMsg().getText().trim();
	}

	public void submitChangePasswordForm(String currentPassword, String newPassword) {
		this.getTextBox(txtCurrentPassword).sendKeys(currentPassword);
		this.getTextBox(txtNewPassword).sendKeys(newPassword);
		this.getTextBox(txtConfirmPassword).sendKeys(newPassword);
		this.getBtnChangePassword().click();
	}

	public ChangePasswordPage changePassword(String currentPassword, String newPassword) {
		submitChangePasswordForm(currentPassword, newPassword);
		return this;
	}

	public boolean checkReLoginWithNewPassword() {
		String loginMsgSuccess = "Welcome " + Constant.emailRegister;
		ChangePasswordPage changePasswordPage = new ChangePasswordPage();
		HomePage homePage = changePasswordPage.logout();
		LoginPage loginPage = homePage.gotoLoginPage();
		loginPage.login(Constant.emailRegister, Constant.newPassword);
		if (loginPage.getWelcomeMsg().equals(loginMsgSuccess)) {
			return true;
		} else {
			System.out.println("Cannot login with new password");
			return false;
		}
	}
}
