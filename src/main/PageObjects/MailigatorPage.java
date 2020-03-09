package PageObjects;

import java.util.concurrent.TimeUnit;

import javax.mail.Message;
import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Common.Constant;
import Common.Utilities;
import PageObjects.EmailUtils;
import PageObjects.EmailUtils.EmailFolder;

public class MailigatorPage {
	// Locators
	private final By txtInbox = By.id("inbox_field");
	private final By btnGo = By.xpath("//button[@class='btn btn-default' and contains(text(),'Go!')]");
	private final By frameContent = By.id("msg_body");
	private final By hrefContent = By.xpath("//a[contains(@href,'www.mailinator.com')]");
	private final By lblResetemail = By.xpath("//td[contains(text(),'Please reset your password')]");
	private final String lblConfirmEmail = "//td[contains(text(),'Please confirm your account %s')]";

	// Elements
	public WebElement getTxtInbox() {
		return Constant.driver.findElement(txtInbox);
	}

	public WebElement getBtnGo() {
		return Constant.driver.findElement(btnGo);
	}

	public WebElement getLblConfirmEmail(String email) {
		return Constant.driver.findElement(By.xpath(String.format(lblConfirmEmail, email)));
	}

	public WebElement getLblResetEmail() {
		return Constant.driver.findElement(lblResetemail);
	}

	public WebElement getHrefContent() {
		return Constant.driver.findElement(hrefContent);
	}

	public WebElement getFrameContent() {
		return Constant.driver.findElement(frameContent);
	}

	// methods
	public void activeAccountByEmail(String email) {
		Utilities.waitPageLoading(5);
		this.getTxtInbox().sendKeys(email);
		this.getBtnGo().click();
		Constant.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		this.getLblConfirmEmail(email).click();
		Constant.driver.switchTo().defaultContent();
		Constant.driver.switchTo().frame(getFrameContent());
		String activeUrl = this.getHrefContent().getAttribute("href");
		Constant.driver.navigate().to(activeUrl);
		Constant.driver.switchTo().defaultContent();
	}

	public ForgotPasswordPage navigateResetMailURL(String email) {
		this.getTxtInbox().sendKeys(email);
		this.getBtnGo().click();
		Constant.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		this.getLblResetEmail().click();
		Constant.driver.switchTo().defaultContent();
		Constant.driver.switchTo().frame(getFrameContent());
		String activeUrl = this.getHrefContent().getAttribute("href");
		Constant.driver.navigate().to(activeUrl);
		Constant.driver.switchTo().defaultContent();
		return new ForgotPasswordPage();
	}
	
	public String activeEmail() throws Exception {
		String username = "nguyentunglam912@gmail.com";
		String password = "nguyentunglam925";
		String server = "imap.gmail.com";
		EmailFolder emailFolder = EmailFolder.INBOX;
		EmailUtils emailUlti = new EmailUtils(username, password, server, emailFolder);
		Message a = emailUlti.getLatestMessage();
		String b = emailUlti.getMessageContent(a);
		return b;
	}
	
}
