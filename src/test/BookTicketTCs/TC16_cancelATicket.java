package BookTicketTCs;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common.Constant;
import PageObjects.BookTicketPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyTicketPage;
import PageObjects.RegisterPage;
import TestBase.TestBase;

public class TC16_cancelATicket extends TestBase {
	/**
	 * TC16 - User can cancel a ticket
	 * 
	 * @author lam.tung.nguyen
	 */
	@Test
	public void TC16() {
		log.info("TC16 - User can cancel a ticket");
		log.info("Pre-Condition: Create a new account and activate it");
		RegisterPage registerPage = TestBase.createAndActiveAccount();

		log.info("Step 1: Navigate to QA Railway Login Page");
		LoginPage loginPage = registerPage.gotoLoginPage();

		log.info("Step 2: Login with valid account");
		HomePage homePage = loginPage.login(Constant.emailRegister, Constant.validPassword);

		log.info("Step 3: Go to Book ticket tabs");
		BookTicketPage bookTicketPage = homePage.gotoBookTicket();

		log.info("Step 4: Select ticket info and book a ticket");
		bookTicketPage.bookTicketWithSelectInfo(Constant.date, Constant.departFrom, Constant.arriveAt,
				Constant.seatType, Constant.ticketAmount);

		log.info("Step 5: Go to My Ticket tab");
		MyTicketPage myticketPage = bookTicketPage.gotoMyticketPage();

		log.info("Step 6:  Click on 'Cancel' button of ticket which user want to cancel.");
		myticketPage.clickCancelByDepartAndArrive(Constant.departFrom, Constant.arriveAt);

		log.info("Step 7:  Click on 'OK' button on Confirmation message 'Are you sure?'");
		myticketPage.acceptPopup();

		log.info("VP:  The canceled ticket is disappeared.");
		Assert.assertFalse(myticketPage.checkTicketDisplayed(Constant.departFrom, Constant.arriveAt));

	}

}
