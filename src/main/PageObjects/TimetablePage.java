package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Constant;
import Common.Utilities;

public class TimetablePage extends GeneralPage {
	//Locators
	private final String btnCheckPrice = "//table[@class='MyTable WideTable']//td[text()='%s']/following-sibling::td[text()='%s']/..//a[text()='check price']";
	
	//Elements
	public WebElement getCheckPrice(String departStation, String arriveStation) {
		return Constant.driver.findElement(By.xpath(String.format(btnCheckPrice, departStation, arriveStation)));
	}

	//Methods
	public TicketPricesPage clickCheckPricebyDepartAndArrive(String departStation, String arriveStation) {
		Utilities.scrollByVisibleElement(By.xpath(String.format(btnCheckPrice, departStation, arriveStation)));
		this.getCheckPrice(departStation, arriveStation).click();
		return new TicketPricesPage();
	}
}
