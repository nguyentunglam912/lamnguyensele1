package TestBase;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Common.Constant;
import PageObjects.HomePage;
import PageObjects.RegisterPage;

public class TestBase {
	@BeforeClass
	public void beforeClass() {
		System.out.println("Pre-condition");
		BasicConfigurator.configure();
		System.setProperty("webdriver.chrome.driver", Constant.chromePath);
		Constant.driver = new ChromeDriver();
		Constant.driver.manage().window().maximize();
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Post-condition");
		Constant.driver.quit();
	}

	public static RegisterPage createAndActiveAccount() {
		HomePage homePage = new HomePage();
		homePage.open();
		RegisterPage registerPage = homePage.gotoRegisterPage();
		return registerPage.registerAndActiveAccount(Constant.emailRegister, Constant.validPassword,
				Constant.validPassword, Constant.pidNumber);
	}

	public static RegisterPage createWithoutActive() {
		HomePage homePage = new HomePage();
		homePage.open();
		RegisterPage registerPage = homePage.gotoRegisterPage();
		return registerPage.registerAccount(Constant.emailRegister, Constant.validPassword, Constant.validPassword,
				Constant.pidNumber);
	}

	public static final Logger log = Logger.getLogger(TestBase.class.getName());
}
