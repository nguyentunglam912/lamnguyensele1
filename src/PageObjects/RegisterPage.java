package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Constant;
import Common.Utilities;

public class RegisterPage extends GeneralPage{
	//Locators
	private final By txtEmail = By.xpath("//form[@id='RegisterForm']//input[@id = 'email']");
	private final By txtPassword = By.xpath("//form[@id='RegisterForm']//input[@id = 'password']");
	private final By txtConfirmPassword = By.xpath("//form[@id='RegisterForm']//input[@id = 'confirmPassword']");
	private final By txtPid = By.xpath("//form[@id='RegisterForm']//input[@id = 'pid']");
	private final By btnRegister = By.xpath("//input[@type='submit' and @title='Register']");
	private final By lblRegisterSuccess = By.xpath("//div[@id='content']//h1");
	
	//Elements
	public WebElement getTxtEmail(){
		return Constant.driver.findElement(txtEmail);
	}
	
	public WebElement getTxtPassword(){
		return Constant.driver.findElement(txtPassword);
	}
	
	public WebElement getTxtConfirmPassword(){
		return Constant.driver.findElement(txtConfirmPassword);
	}
	
	public WebElement getTxtPid(){
		return Constant.driver.findElement(txtPid);
	}
	
	public WebElement getBtnRegister(){
		return Constant.driver.findElement(btnRegister);
	}
	
	public WebElement getLblRegisterSuccess(){
		return Constant.driver.findElement(lblRegisterSuccess);
	}
	
	//Methods
	public RegisterPage registerAccount(String email, String password, String pid) {
		Utilities.scrollByVisibleElement(btnRegister);
		this.getTxtEmail().sendKeys(email);
		this.getTxtPassword().sendKeys(password);
		this.getTxtConfirmPassword().sendKeys(password);
		this.getTxtPid().sendKeys(pid);
		this.getBtnRegister().click();
		return this;
	}
	
	public String getRegisterSuccessMsg() {
		return this.getLblRegisterSuccess().getText().trim();
	}
}
