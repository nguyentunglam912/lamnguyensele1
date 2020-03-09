package TestCases;

import org.testng.annotations.Test;

import Common.Constant;
import Common.Utilities;
import PageObjects.ContactPage;
import PageObjects.GeneralPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class loginTCs {
	@BeforeClass
	public void beforeClass() {
		System.out.println("Pre-condition");
		System.setProperty("webdriver.chrome.driver", Constant.chromePath);
		Constant.driver = new ChromeDriver();
		Constant.driver.manage().window().maximize();
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("Post-condition");
		Constant.driver.quit();
	}

	@Test
	public void TC01() {
		System.out.println("TC01 - User can log into Railway with valid username and password");
		HomePage homePage = new HomePage();
		homePage.open();
		
		LoginPage loginPage = homePage.gotoLoginPage();
			
		String actualMsg 	= loginPage.login(Constant.validUsername, Constant.validPassword).getWelcomeMsg();
		String expectedMsg 	= "Welcome " + Constant.validUsername;
		
		Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
		
		GeneralPage generalPage = new GeneralPage();
		generalPage.logout();
	}
	
	@Test
	public void TC02() {
		System.out.println("TC02 - User can't login with blank Username textbox");
		HomePage homePage = new HomePage();
		homePage.open();
		
		LoginPage loginPage = homePage.gotoLoginPage();
		
		String actualMsg 	= loginPage.loginExpectingError(Constant.blankUsername, Constant.validPassword).getLoginErrorMessage();
		String expectedMsg 	= "There was a problem with your login and/or errors exist in your form.";
		
		Assert.assertEquals(actualMsg, expectedMsg, "Error message displays incorrectly");
	}
	
	@Test
	public void TC03() {
		System.out.println("TC03 - User cannot log into Railway with invalid password ");
		HomePage homePage = new HomePage();
		homePage.open();
		
		LoginPage loginPage = homePage.gotoLoginPage();
		
		String actualMsg 	= loginPage.loginExpectingError(Constant.validUsername, Constant.invalidPassword).getLoginErrorMessage();
		String expectedMsg 	= "There was a problem with your login and/or errors exist in your form.";
		
		Assert.assertEquals(actualMsg, expectedMsg, "Error message displays incorrectly");
	}
	
	@Test
	public void TC04() {
		System.out.println("TC04 - Email address's href is \"mailto:thanh.viet.le@logigear.com\"");
		HomePage homePage = new HomePage();
		homePage.open();
		
		ContactPage contactPage = homePage.gotoContactPage();
		String actualMsg = contactPage.getContactEmailHref();
		String expectedMsg = "mailto:thanh.viet.le@logigear.com";

		Assert.assertEquals(actualMsg, expectedMsg, "Incorrectly contact email");
	}

	@Test
	public void TC05() {
		System.out.println("TC05 - System shows message when user enters wrong password several times");
		HomePage homePage = new HomePage();
		homePage.open();
		
		LoginPage loginPage = homePage.gotoLoginPage();
		for(int i=0; i<=3; i++) {
			loginPage.loginExpectingError(Constant.validUsername, Constant.blankPassword);
		}
		String actualMsg	= loginPage.getLoginErrorMessage();
		String expectedMsg 	= "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
		
		Assert.assertEquals(actualMsg, expectedMsg, "Error message displays incorrectly");
	}
	
	@Test
	public void TC07() {
		System.out.println("TC06 - User can create new account");
		HomePage homePage = new HomePage();
		homePage.open();
		
		RegisterPage registerPage = homePage.gotoRegisterPage();
		String actualMsg = registerPage.registerAccount(Constant.email, Constant.validPassword, Constant.pidNumber).getRegisterSuccessMsg();
		String expectedMsg = "Thank you for registering your account";
		Assert.assertEquals(actualMsg, expectedMsg, "Register Success message displays incorrectly");
	}
}
