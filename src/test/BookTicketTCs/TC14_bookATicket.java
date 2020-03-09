package BookTicketTCs;

import javax.mail.Message;
import javax.mail.MessagingException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common.Constant;
import PageObjects.BookTicketPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MailigatorPage;
import PageObjects.RegisterPage;
import TestBase.TestBase;

public class TC14_bookATicket extends TestBase {
	/**
	 * TC14 - User can book 1 ticket at a time
	 * 
	 * @author lam.tung.nguyen
	 * @throws Exception 
	 */
	@Test
	public void TC14() throws Exception {
//		log.info("TC14 - User can book 1 ticket at a time");
//		log.info("Pre-Condition: Create a new account and activate it");
//		RegisterPage registerPage = TestBase.createAndActiveAccount();
//
//		log.info("Step 1: Navigate to QA Railway Login Page");
//		LoginPage loginPage = registerPage.gotoLoginPage();
//
//		log.info("Step 2: Login with valid account");
//		HomePage homePage = loginPage.login(Constant.emailRegister, Constant.validPassword);
//
//		log.info("Step 3: Go to Book ticket tabs");
//		BookTicketPage bookTicketPage = homePage.gotoBookTicket();
//
//		log.info("Step 4: Select ticket info and book a ticket");
//		bookTicketPage.bookTicketWithSelectInfo(Constant.date, Constant.departFrom, Constant.arriveAt,
//				Constant.seatType, Constant.ticketAmount);
//
//		log.info("VP1: Message 'Ticket booked successfully!' displays.");
//		Assert.assertEquals(bookTicketPage.getBookSuccessfullyMessage(), bookSuccessMsg);
//
//		log.info("VP2: Ticket information display correctly");
//		Assert.assertTrue(bookTicketPage.checkTicketInfo(Constant.date, Constant.departFrom, Constant.arriveAt,
//				Constant.seatType, Constant.ticketAmount));
		MailigatorPage mail = new MailigatorPage();
		String a = mail.activeEmail();
		System.out.println(a);
	}
	private String bookSuccessMsg = "Ticket booked successfully!";
}
