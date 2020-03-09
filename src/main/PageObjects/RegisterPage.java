package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Common.Constant;
import Common.Utilities;

public class RegisterPage extends GeneralPage {
	// Locators
	private final By txtEmail = By.id("email");
	private final By txtPassword = By.id("password");
	private final By txtConfirmPassword = By.id("confirmPassword");
	private final By txtPid = By.id("pid");
	private final By btnRegister = By.xpath("//input[@type='submit' and @title='Register']");
	private final By lblRegisterSuccess = By.xpath("//div[@id='content']//h1");
	private final By lblRegisterErrorMsg = By.xpath("//p[@class='message error']");
	private final By lblPasswordErr = By.xpath("//li[@class='password']//label[@class='validation-error']");
	private final By lblPIDError = By.xpath("//li[@class='pid-number']//label[@class='validation-error']");

	// Elements
	public WebElement getTextField(By txtName) {
		return Constant.driver.findElement(txtName);
	}

	public WebElement getBtnRegister() {
		return Constant.driver.findElement(btnRegister);
	}

	public WebElement getLblRegisterSuccess() {
		return Constant.driver.findElement(lblRegisterSuccess);
	}

	public WebElement getLblRegisterErrorMsg() {
		return Constant.driver.findElement(lblRegisterErrorMsg);
	}

	public WebElement getLblTextFieldError(By lblTxtName) {
		return Constant.driver.findElement(lblTxtName);
	}

	// Methods
	public void submitRegisterForm(String email, String password, String confirmPassword, String pid) {
		Utilities.scrollByVisibleElement(btnRegister);
		this.getTextField(txtEmail).sendKeys(email);
		this.getTextField(txtPassword).sendKeys(password);
		this.getTextField(txtConfirmPassword).sendKeys(confirmPassword);
		this.getTextField(txtPid).sendKeys(pid);
		this.getBtnRegister().click();
	}

	public RegisterPage registerAccount(String email, String password, String confirmPassword, String pid) {
		Constant.emailRegister = Utilities.randomEmail(Constant.prefixEmail);
		submitRegisterForm(Constant.emailRegister, password, confirmPassword, pid);
		return this;
	}

	public RegisterPage registerAndActiveAccount(String email, String password, String confirmPassword, String pid) {
		Constant.emailRegister = Utilities.randomEmail(Constant.prefixEmail);
		submitRegisterForm(Constant.emailRegister, password, confirmPassword, pid);
		Constant.driver.navigate().to(Constant.mailigatorURL);
		MailigatorPage mailPage = new MailigatorPage();
		mailPage.activeAccountByEmail(Constant.emailRegister);
		return this;
	}

	public String getRegisterSuccessMsg() {
		return this.getLblRegisterSuccess().getText().trim();
	}

	public Boolean checkReLoginWithNewAccount() {
		String loginMsgSuccess = "Welcome " + Constant.emailRegister;
		Constant.driver.navigate().to(Constant.mailigatorURL);
		MailigatorPage mailPage = new MailigatorPage();
		mailPage.activeAccountByEmail(Constant.emailRegister);
		RegisterPage registerPage = new RegisterPage();
		LoginPage loginPage = registerPage.gotoLoginPage();
		loginPage.login(Constant.emailRegister, Constant.validPassword);
		if (loginPage.getWelcomeMsg().equals(loginMsgSuccess)) {
			return true;
		} else {
			System.out.println("Cannot login with this account");
			return false;
		}
	}

	public void checkRegisterSuccess(String expectedMsg) {
		String actualMsg = getRegisterSuccessMsg();
		Boolean checkReLoginSuccess = checkReLoginWithNewAccount();
		Assert.assertTrue(actualMsg.equals(expectedMsg) && checkReLoginSuccess);
	}

	public String getRegisterErrorMessage() {
		return this.getLblRegisterErrorMsg().getText().trim();
	}

	public String getPasswordError() {
		return this.getLblTextFieldError(lblPasswordErr).getText().trim();
	}

	public String getPIDError() {
		return this.getLblTextFieldError(lblPIDError).getText().trim();
	}
}
