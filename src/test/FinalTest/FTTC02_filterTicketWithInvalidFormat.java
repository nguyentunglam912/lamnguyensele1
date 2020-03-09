package FinalTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common.Constant;
import PageObjects.BookTicketPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyTicketPage;
import PageObjects.RegisterPage;
import TestBase.TestBase;

public class FTTC02_filterTicketWithInvalidFormat extends TestBase {
	/**
	 * FTTC02 - Error displays when user applies filter with invalid format for
	 * 'Depart Data' in 'Manage ticket' table
	 * 
	 * @author lam.tung.nguyen
	 */
	@Test
	public void FTTC02() {
		log.info("FTTC02 - Error displays when user applies filter with invalid format for 'Depart Data' in 'Manage ticket' table");
		log.info("Pre-Condition: Create a new account and activate it");
//		RegisterPage registerPage = TestBase.createAndActiveAccount();
		
		HomePage homePage = new HomePage();
		homePage.open();

		log.info("Step 1: Navigate to QA Railway Login Page");
		LoginPage loginPage = homePage.gotoLoginPage();

		log.info("Step 2: Login with valid info");
		loginPage.login(Constant.validUsername, Constant.validPassword);

		log.info("Step 3: Book more than 6 tickets");
		BookTicketPage bookTicketPage = homePage.gotoBookTicket();
		bookTicketPage.bookSeveralTicket(Constant.date, Constant.departStationList, Constant.arriveAt,
				Constant.seatType, Constant.ticketAmount);

		log.info("Step 4: Go to My ticket tab");
		MyTicketPage myTicketPage = homePage.gotoMyticketPage();

		log.info("Step 5: Filter with invalid date into 'Depart Date'");
		myTicketPage.filterBySelection(Constant.ignoreFilterValue, Constant.ignoreFilterValue,
				Constant.invalidDateFilterValue, Constant.ignoreFilterValue);

		log.info("VP: Message 'The date format is wrong, date filter is ignored. Example of a proper date: Today is mm/dd/yyyy'");
		Assert.assertTrue(myTicketPage.checkErrorDateFilterMessage());
	}
}
