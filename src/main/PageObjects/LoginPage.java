package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Constant;
import Common.Utilities;

public class LoginPage extends GeneralPage {
	// Locators
	private final By txtUsername = By.id("username");
	private final By txtPassword = By.id("password");
	private final By btnLogin = By.xpath("//input[@type='submit' and @title='Login']");
	private final By lblLoginErrMsg = By.xpath("//p[@class='message error LoginForm']");
	private final By hrefForgotPassword = By.xpath("//div[@id='content']//a[@href='/Account/ForgotPassword.cshtml']");

	// Elements
	public WebElement getTxtUsername() {
		return Constant.driver.findElement(txtUsername);
	}

	public WebElement getTxtPassword() {
		return Constant.driver.findElement(txtPassword);
	}

	public WebElement getBtnLogin() {
		return Constant.driver.findElement(btnLogin);
	}

	public WebElement getLblLoginErrMsg() {
		return Constant.driver.findElement(lblLoginErrMsg);
	}

	public WebElement getTabMenu(By tabMenu) {
		return Constant.driver.findElement(tabMenu);
	}

	public WebElement getHrefForgotPassword() {
		return Constant.driver.findElement(hrefForgotPassword);
	}

	// Methods
	public LoginPage open() {
		Constant.driver.navigate().to(Constant.loginPageURL);
		return this;
	}

	public void submitLoginForm(String username, String password) {
		Utilities.scrollByVisibleElement(btnLogin);
		this.getTxtUsername().sendKeys(username);
		this.getTxtPassword().sendKeys(password);
		this.getBtnLogin().click();
	}

	public HomePage login(String username, String password) {
		submitLoginForm(username, password);
		return new HomePage();
	}

	public LoginPage loginExpectingError(String username, String password) {
		submitLoginForm(username, password);
		return this;
	}

	public LoginPage loginSeveralTime(String username, String password, int attempts) {
		for (int i = 0; i <= 3; i++) {
			submitLoginForm(username, password);
		}
		return this;
	}

	public String getLoginErrorMessage() {
		return this.getLblLoginErrMsg().getText().trim();
	}

	public Boolean checkTabMenuPresent(By tabMenu) {
		return this.getTabMenu(tabMenu).isDisplayed();
	}

	public ForgotPasswordPage gotoForgotPasswordPage() {
		this.getHrefForgotPassword().click();
		return new ForgotPasswordPage();
	}
}
