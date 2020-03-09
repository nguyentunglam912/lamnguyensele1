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

public class FTTC01_filterTicketWithDepartStation extends TestBase{
	/**
	 * FTTC01 - User can filter 'Manager ticket' table with Depart Station
	 * 
	 * @author lam.tung.nguyen
	 */
	@Test
	public void FTTC01() {
//		log.info("FTTC01 - User can filter 'Manager ticket' table with Depart Station");
//		log.info("Pre-Condition: Create a new account and activate it");
//		RegisterPage registerPage = TestBase.createAndActiveAccount();
//
//		log.info("Step 1: Navigate to QA Railway Login Page");
//		LoginPage loginPage = registerPage.gotoLoginPage();
		HomePage homePage = new HomePage();
		homePage.open();
		
		LoginPage loginPage = homePage.gotoLoginPage();
		
		log.info("Step 2: Login with valid info");
		loginPage.login(Constant.validUsername, Constant.validPassword);
		
		log.info("Step 3: Book more than 6 tickets with different Depart Station");
		BookTicketPage bookTicketPage = homePage.gotoBookTicket();
		bookTicketPage.bookSeveralTicket(Constant.date, Constant.departStationList, Constant.arriveAt,
				Constant.seatType, Constant.ticketAmount);
		
		log.info("Step 4: Go to My ticket tab");
		MyTicketPage myTicketPage = homePage.gotoMyticketPage();
		
		log.info("Step 5: Filter with a booked Depart Station");
		myTicketPage.filterBySelection(Constant.departFilterValue, Constant.ignoreFilterValue, Constant.blankDateFilterValue, Constant.ignoreFilterValue);
		
		log.info("VP: Manage ticket table shows correct tickets");
		Assert.assertTrue(myTicketPage.checkCorrectTickets(Constant.departFilterOption, Constant.departFilterValue));
	}
}
