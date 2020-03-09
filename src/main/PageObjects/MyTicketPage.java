package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Constant;
import Common.Utilities;

public class MyTicketPage extends GeneralPage {
	// Locators
	private final String btnCancel = "//table[@class='MyTable']//td[text()='%s']/following-sibling::td[text()='%s']/..//input[@value='Cancel']";
	private final By selectDepartStation = By.xpath("//select[@name='FilterDpStation']");
	private final By selectArriveStation = By.xpath("//select[@name='FilterArStation']");
	private final By selectStatus = By.xpath("//select[@name='FilterStatus']");
	private final By txtDepartDate = By.xpath("//input[@name='FilterDpDate']");
	private final By btnApplyFilter = By.xpath("//input[@type='submit' and @value='Apply filter']");
	private final By lblErrorDateFilterMsg = By.xpath("//div[@class='error message']");
	private final By tableTickets = By.xpath("//table[@class='MyTable']//tr");
	private final String xpathDepartRow = "//table[@class='MyTable']//tr[%s]/td[count(//table[@class='MyTable']//preceding-sibling::th[contains(text(),'%s')])+1]";

	// Elements
	public WebElement getCancelButton(String departStation, String arriveStation) {
		return Constant.driver.findElement(By.xpath(String.format(btnCancel, departStation, arriveStation)));
	}

	public WebElement getBtnApplyFilter() {
		return Constant.driver.findElement(btnApplyFilter);
	}

	public WebElement getTxtDepartDate() {
		return Constant.driver.findElement(txtDepartDate);
	}

	public WebElement getLblErrorDateFilterMsg() {
		return Constant.driver.findElement(lblErrorDateFilterMsg);
	}

	public WebElement getRowByIndexAndHeader(int index, String headerName) {
		return Constant.driver.findElement(By.xpath(String.format(xpathDepartRow, index, headerName)));
	}

	// Methods
	public MyTicketPage clickCancelByDepartAndArrive(String departStation, String arriveStation) {
		Utilities.scrollByVisibleElement(By.xpath(String.format(btnCancel, departStation, arriveStation)));
		this.getCancelButton(departStation, arriveStation).click();
		return new MyTicketPage();
	}

	public void acceptPopup() {
		Constant.driver.switchTo().alert().accept();
	}

	public boolean checkTicketDisplayed(String departStation, String arriveStation) {
		return this.getCancelButton(departStation, arriveStation).isDisplayed();
	}

	public void filterBySelection(String departStation, String arriveStation, String departDate, String status) {
		Utilities.selectValue(selectDepartStation, departStation);
		Utilities.selectValue(selectArriveStation, arriveStation);
		this.getTxtDepartDate().sendKeys(departDate);
		Utilities.selectValue(selectStatus, status);
		this.getBtnApplyFilter().click();
	}

	public boolean checkErrorDateFilterMessage() {
		String currentDate = Utilities.getDateTimeWithFormat("MM/dd/yyyy");
		String expectedErrorMsg = "The date format is wrong, date filter is ignored.\nExample of a proper date: Today is "
				+ currentDate;
		String actualErrorMsg = this.getLblErrorDateFilterMsg().getText().trim();
		if (actualErrorMsg.equals(expectedErrorMsg)) {
			return true;
		} else {
			System.out.println("Expected Message: " + expectedErrorMsg);
			System.out.println("  Actual Message: " + actualErrorMsg);
			return false;
		}
	}

	public String getValuebyIndexAndHeaderName(int index, String headerName) {
		return this.getRowByIndexAndHeader(index, headerName).getText().trim();
	}

	public int getTotalRowsWithValue(String filterOption, String filterValue) {
		// Get table contains
		List<WebElement> table = Constant.driver.findElements(tableTickets);
		int totalRows = table.size();
		int count = 0;
		// Browse all rows below header to get value
		for (int i = 2; i <= totalRows; i++) {
			//If row value equal filter value, count pluses 1
			if (this.getValuebyIndexAndHeaderName(i, filterOption).equals(filterValue)) {
				count++;
			}
		}
		return count;
	}

	public boolean checkCorrectTickets(String filterOption, String filterValue) {
		// Get total row after filtering with value
		int actualRows = this.getTotalRowsWithValue(filterOption, filterValue);
		this.gotoMyticketPage();
		Utilities.waitPageLoading(5);
		// Get total rows with value before filtering
		int expectedRows = this.getTotalRowsWithValue(filterOption, filterValue);
		if (actualRows == expectedRows) {
			return true;
		} else {
			System.out.println("Total rows has " + filterOption + "is " + filterValue + ": " + expectedRows);
			System.out
					.println("Total rows has " + filterOption + "is " + filterValue + "after filtering: " + actualRows);
			return false;
		}
	}
}
