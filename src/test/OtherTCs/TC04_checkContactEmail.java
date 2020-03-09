package OtherTCs;

import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.ContactPage;
import PageObjects.HomePage;
import TestBase.TestBase;

public class TC04_checkContactEmail extends TestBase{
	/**
	 * TC04 - Contact Email contains correct href value which can help to quickly 
	 * open Outlook Compose Message dialog
	 * @author lam.tung.nguyen
	 */
	@Test
	public void TC04() {
		log.info("TC04 - Contact Email contains correct href value ");	
		log.info("Step 1: Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		homePage.open();
		
		log.info("Step 2: Go to Contact tab");
		ContactPage contactPage = homePage.gotoContactPage();
		
		log.info("VP: Check the email address in Contact Page");
		Assert.assertEquals(contactPage.getContactEmailHref(), expectedMsg, "Contact email is not displayed as expected");
	}
	private String expectedMsg 	= "mailto:thanh.viet.le@logigear.com";
}
