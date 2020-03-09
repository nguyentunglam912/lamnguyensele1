package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Constant;

public class ContactPage {
	// Locator
	private final By hrefContactEmail = By.xpath("//div[@class='contact']//b[contains(text(),'Email')]/following-sibling::a");
	
	// Elements
	public WebElement getHrefContactEmail(){
		return Constant.driver.findElement(hrefContactEmail);
	}
	
	public String getContactEmailHref() {
		return this.getHrefContactEmail().getAttribute("href");
	}
}
