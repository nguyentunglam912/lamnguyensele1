package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Constant;

public class TicketPricesPage extends GeneralPage{
	//Locators
	private final By headerTable = By.xpath("//tr[@class='TableSmallHeader']/th");
	
	//elements
	public WebElement getHeaderTable() {
		return Constant.driver.findElement(headerTable);
	}
	
	public String getHeaderTableText() {
		return this.getHeaderTable().getText().trim();
	}
}
