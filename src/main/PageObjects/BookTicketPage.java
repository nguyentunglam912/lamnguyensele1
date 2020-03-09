package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Constant;
import Common.Utilities;

public class BookTicketPage extends GeneralPage {
	// Locators
	private final By selectDate = By.xpath("//select[@name='Date']");
	private final By selectDepartFrom = By.xpath("//select[@name='DepartStation']");
	private final By selectArriveStation = By.xpath("//select[@name='ArriveStation']");
	private final By selectSeatType = By.xpath("//select[@name='SeatType']");
	private final By selectTicketAmount = By.xpath("//select[@name='TicketAmount']");
	private final By btnBookTicket = By.xpath("//input[@type='submit' and @value='Book ticket']");

	private final By lblBookSuccessMsg = By.xpath("//div[@id='content']/h1");
	private final By cellDepartStation = By.xpath("//table[@class='MyTable WideTable']//td[1]");
	private final By cellArriveStation = By.xpath("//table[@class='MyTable WideTable']//td[2]");
	private final By cellSeatType = By.xpath("//table[@class='MyTable WideTable']//td[3]");
	private final By cellDepartDate = By.xpath("//table[@class='MyTable WideTable']//td[4]");
	private final By cellAmount = By.xpath("//table[@class='MyTable WideTable']//td[7]");

	// Elements
	public WebElement getBtnBookTicket() {
		return Constant.driver.findElement(btnBookTicket);
	}

	public WebElement getLblBookSuccessfully() {
		return Constant.driver.findElement(lblBookSuccessMsg);
	}

	public WebElement getCellByHeader(By headerName) {
		return Constant.driver.findElement(headerName);
	}

	// Methods
	public void selectTicketInfo(String date, String departFrom, String arriveAt, String seatType,
			String ticketAmount) {
		Utilities.selectValue(selectDate, date);
		Utilities.selectValue(selectDepartFrom, departFrom);
		if(!arriveAt.equals(""))
			Utilities.selectValue(selectArriveStation, arriveAt);
		Utilities.selectValue(selectSeatType, seatType);
		Utilities.selectValue(selectTicketAmount, ticketAmount);
	}

	public BookTicketPage bookTicketWithSelectInfo(String date, String departFrom, String arriveAt, String seatType,
			String ticketAmount) {
		selectTicketInfo(date, departFrom, arriveAt, seatType, ticketAmount);
		this.getBtnBookTicket().click();
		return this;
	}

	public String getBookSuccessfullyMessage() {
		return this.getLblBookSuccessfully().getText().trim();
	}

	public String getCellValueByHeader(By headerName) {
		return this.getCellByHeader(headerName).getText().trim();
	}

	public boolean checkTicketInfo(String date, String departFrom, String arriveAt, String seatType,
			String ticketAmount) {
		String actualDepartDate = this.getCellValueByHeader(cellDepartDate);
		String actualArriveAt = this.getCellValueByHeader(cellArriveStation);
		String actualSeatType = this.getCellValueByHeader(cellSeatType);
		String actualDepartFrom = this.getCellValueByHeader(cellDepartStation);
		String actualAmount = this.getCellValueByHeader(cellAmount);

		if (actualDepartDate.equals(date) && actualDepartFrom.equals(actualDepartFrom)
				&& actualArriveAt.equals(arriveAt) && actualSeatType.equals(seatType)
				&& actualAmount.equals(ticketAmount)) {
			return true;
		} else {
			return false;
		}
	}

	public BookTicketPage bookSeveralTicket(String date, String[] departFromList, String arriveAt,
			String seatType, String ticketAmount) {
		for (int i = 0; i < departFromList.length; i++) {
			selectTicketInfo(date, departFromList[i] , arriveAt, seatType, ticketAmount);
			this.getBtnBookTicket().click();
			this.gotoBookTicket();
		}
		return this;
	}
}
