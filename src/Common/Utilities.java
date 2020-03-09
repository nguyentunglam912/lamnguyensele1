package Common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Constant;

public class Utilities {
	public static void scrollByVisibleElement (By elementXpath) {
		JavascriptExecutor js = (JavascriptExecutor) Constant.driver;
		WebElement element = Constant.driver.findElement(elementXpath);
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public static Boolean checkElementExisted(By elementXpath) {
		Boolean result = Constant.driver.findElement(elementXpath).isDisplayed();
		return result;	
	}
}
