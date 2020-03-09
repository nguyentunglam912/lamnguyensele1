package BookTicketTCs;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common.Constant;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import PageObjects.TicketPricesPage;
import PageObjects.TimetablePage;
import TestBase.TestBase;

public class TC15_checkTicketPrices extends TestBase {
	/**
	 * TC15 - "Ticket price" page displays with ticket details after clicking on
	 * "check price" link in "Train timetable" page
	 * 
	 * @author lam.tung.nguyen
	 */
	@Test
	public void TC15() {
		log.info("TC15 - 'Ticket price' page displays with ticket details after clicking on 'check price' link");
		log.info("Pre-Condition: Create a new account and activate it");
		RegisterPage registerPage = TestBase.createAndActiveAccount();

		log.info("Step 1: Navigate to QA Railway Login Page");
		LoginPage loginPage = registerPage.gotoLoginPage();

		log.info("Step 2: Login with valid account");
		HomePage homePage = loginPage.login(Constant.emailRegister, Constant.validPassword);

		log.info("Step 3: Go to Timetable tab");
		TimetablePage timetablePage = homePage.gotoTimetable();

		log.info("Step 4: Click 'check prices' link of the route from Nha Trang to Sai Gon");
		TicketPricesPage ticketPricesPage = timetablePage.clickCheckPricebyDepartAndArrive(departStation,
				arriveStation);

		log.info("VP1: 'Ticket Price' page is loaded.");
		Assert.assertTrue(ticketPricesPage.checkPageDisplayed(Constant.ticketPricePage));

		log.info("VP2: Ticket table shows 'Ticket price from Nha Trang to Sài Gòn'");
		Assert.assertEquals(ticketPricesPage.getHeaderTableText(), headerTable);

	}

	private String departStation = "Nha Trang";
	private String arriveStation = "Sài Gòn";
	private String headerTable = "Ticket price from Nha Trang to Sài Gòn";
}
