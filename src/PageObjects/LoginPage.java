package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Constant;
import Common.Utilities;

public class LoginPage extends GeneralPage{
	//Locators
	private final By txtUsername 	= By.id("username");
	private final By txtPassword 	= By.id("password");
	private final By btnLogin 	 	= By.xpath("//input[@type='submit' and @title='Login']");
	private final By lblLoginErrMsg = By.xpath("//p[@class='message error LoginForm']");

	// Elements
	public WebElement getTxtUsername(){
		return Constant.driver.findElement(txtUsername);
	}
	
	public WebElement getTxtPassword(){
		return Constant.driver.findElement(txtPassword);
	}
	
	public WebElement getBtnLogin(){
		return Constant.driver.findElement(btnLogin);
	}
	
	public WebElement getLblLoginErrMsg(){
		return Constant.driver.findElement(lblLoginErrMsg);
	}
	
	//Methods
	public HomePage login(String username, String password) {
		Utilities.scrollByVisibleElement(btnLogin);
		this.getTxtUsername().sendKeys(username);
		this.getTxtPassword().sendKeys(password);
		this.getBtnLogin().click();
		return new HomePage();
	}
	
	public LoginPage loginExpectingError(String username, String password) {
		Utilities.scrollByVisibleElement(btnLogin);
		this.getTxtUsername().sendKeys(username);
		this.getTxtPassword().sendKeys(password);
		this.getBtnLogin().click();
		return this;
	}
	
	public String getLoginErrorMessage() {
		return this.getLblLoginErrMsg().getText().trim();
	}
}
