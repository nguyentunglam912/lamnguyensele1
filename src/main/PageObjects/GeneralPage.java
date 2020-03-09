package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Constant;
import Common.Utilities;

public class GeneralPage {
	// Locators
	private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
	private final By tabChangePassword = By.xpath("//div[@id='menu']//a[@href='/Account/ChangePassword.cshtml']");
	private final By tabMyTicket = By.xpath("//div[@id='menu']//a[@href='/Page/ManageTicket.cshtml']");
	private final By tabContact = By.xpath("//div[@id='menu']//a[@href='/Page/Contact.cshtml']");
	private final By tabRegister = By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']");
	private final By tabBookTicket = By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']");
	private final By tabTimetable = By.xpath("//div[@id='menu']//a[@href='TrainTimeListPage.cshtml']");
	private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
	private final By lblWelcomeMsg = By.xpath("//div[@class='account']");

	// Elements
	protected WebElement getTabMenu(By tabMenu) {
		return Constant.driver.findElement(tabMenu);
	}

	protected WebElement getLblWelcomeMsg() {
		return Constant.driver.findElement(lblWelcomeMsg);
	}

	// Methods
	public String getWelcomeMsg() {
		return this.getLblWelcomeMsg().getText().trim();
	}

	public LoginPage gotoLoginPage() {
		this.getTabMenu(tabLogin).click();
		return new LoginPage();
	}

	public ContactPage gotoContactPage() {
		this.getTabMenu(tabContact).click();
		return new ContactPage();
	}

	public MyTicketPage gotoMyticketPage() {
		this.getTabMenu(tabMyTicket).click();
		return new MyTicketPage();
	}

	public ChangePasswordPage gotoChangePassword() {
		this.getTabMenu(tabChangePassword).click();
		return new ChangePasswordPage();
	}
	
	public TimetablePage gotoTimetable() {
		this.getTabMenu(tabTimetable).click();
		return new TimetablePage();
	}

	public BookTicketPage gotoBookTicket() {
		this.getTabMenu(tabBookTicket).click();
		return new BookTicketPage();
	}

	public RegisterPage gotoRegisterPage() {
		this.getTabMenu(tabRegister).click();
		return new RegisterPage();
	}

	public HomePage logout() {
		this.getTabMenu(tabLogout).click();
		return new HomePage();
	}

	public MailigatorPage navigateToMailinator() {
		Constant.driver.navigate().to(Constant.mailigatorURL);
		return new MailigatorPage();
	}

	public boolean checkTabTicketDisplayed() {
		Constant.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return this.getTabMenu(tabMyTicket).isDisplayed();
	}

	public boolean checkTabChangePasswordDisplayed() {
		Constant.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return this.getTabMenu(tabChangePassword).isDisplayed();
	}

	public boolean checkTabLogoutDisplayed() {
		Constant.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return this.getTabMenu(tabLogout).isDisplayed();
	}

	public boolean checkPageDisplayed(String pageName) {
		Constant.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (Utilities.getTitlePage().contains(pageName)) {
			return true;
		} else {
			return false;
		}
	}
}
