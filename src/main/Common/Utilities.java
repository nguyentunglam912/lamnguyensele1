package Common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {
	public static void scrollByVisibleElement (By elementXpath) {
		JavascriptExecutor js = (JavascriptExecutor) Constant.driver;
		WebElement element = Constant.driver.findElement(elementXpath);
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public static String getDateTimeWithFormat(String format) {
		SimpleDateFormat currentDate = new SimpleDateFormat(format);
		currentDate.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
		return currentDate.format(Calendar.getInstance().getTime());
	}

	public static String randomEmail(String prefixEmail){
		String curentDateTime = getDateTimeWithFormat("MMdd_HHmmss");
	    String email=prefixEmail+curentDateTime+"@mailinator.com";
	    return email;
	}
	
	public static String randomPassword(int lengh){
		String allowedChars="abcdefghijklmnopqrstuvwxyz" + "1234567890";
	    return RandomStringUtils.random(lengh, allowedChars);
	}
	
	public static void waitForElement(By element, int timeout) {
		WebDriverWait wait = new WebDriverWait(Constant.driver, timeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	
	public static void selectValue(By dropdownElement, String dropdownValue){
		Select dropdown = new Select(Constant.driver.findElement(dropdownElement));
		dropdown.selectByVisibleText(dropdownValue);
	}

	public static void selectIndex(By dropdownElement, int index){
		Select dropdown = new Select(Constant.driver.findElement(dropdownElement));
		dropdown.selectByIndex(index);
	}
	
	public static String getTitlePage() {
		return Constant.driver.getTitle().trim();
	}
	
	public static void waitPageLoading(int timeout){
		Constant.driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
	}
	
    public static String randomDepartStation(String[] departStationList){
        int random = (int)(Math.random() * departStationList.length);
        return departStationList[random];
     }
}
