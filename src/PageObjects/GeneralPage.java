package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Common.Constant;

public class GeneralPage {
	// Locators
	private final By tabLogin 			= By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
	private final By tabChangePassword 	= By.xpath("//div[@id='menu']//a[@href='/Account/ChangePassword.cshtml']");
	private final By tabMyTicket 		= By.xpath("//div[@id='menu']//a[@href='Page/ManageTicket.cshtml']");
	private final By tabContact 		= By.xpath("//div[@id='menu']//a[@href='/Page/Contact.cshtml']");
	private final By tabRegister 		= By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']");
	private final By tabLogout 			= By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
	private final By lblWelcomeMsg		= By.xpath("//div[@class='account']");
	
	// Elements
	protected WebElement getTagLogin() {
		return Constant.driver.findElement(tabLogin);
	}

	protected WebElement getTabLogout() {
		return Constant.driver.findElement(tabLogout);
	}
	
	protected WebElement getTabContact() {
		return Constant.driver.findElement(tabContact);
	}
	
	protected WebElement getTabRegister() {
		return Constant.driver.findElement(tabRegister);
	}
	
	protected WebElement getLblWelcomeMsg() {
		return Constant.driver.findElement(lblWelcomeMsg);
	}
	
	protected WebElement getTabMyTicket() {
		return Constant.driver.findElement(tabMyTicket);
	}
	
	protected WebElement getTabChangePassword() {
		return Constant.driver.findElement(tabChangePassword);
	}
	
	// Methods
	public String getWelcomeMsg() {
		return this.getLblWelcomeMsg().getText().trim();
	}
	
	public LoginPage gotoLoginPage() {
		this.getTagLogin().click();
		return new LoginPage();
	}
	
	public ContactPage gotoContactPage() {
		this.getTabContact().click();
		return new ContactPage();
	}
	
	public MyTicketPage gotoMyticketPage() {
		this.getTabMyTicket().click();
		return new MyTicketPage();
	}
	
	public ChangePasswordPage gotoChangePassword() {
		this.getTabChangePassword().click();
		return new ChangePasswordPage();
	}
	
	public RegisterPage gotoRegisterPage() {
		this.getTabRegister().click();
		return new RegisterPage();
	}
	
	public LoginPage logout() {
		this.getTabLogout().click();
		return new LoginPage();
	}

}
