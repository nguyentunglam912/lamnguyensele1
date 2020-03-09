package Common;

import org.openqa.selenium.WebDriver;

public class Constant {
	public static WebDriver driver;
	public static final String chromePath		= "./Executables/chromedriver.exe";
	public static final String railwayURL 		= "http://logigearrailway.somee.com/Page/HomePage.cshtml";
	public static final String validUsername	= "lam.tung.nguyen@logigear.com";
	public static final String validPassword	= "12345678";
	public static final String blankUsername	= "";
	public static final String blankPassword	= "";
	public static final String invalidPassword	= "abcd";
	public static final String pidNumber		= "11111111";
	public static final String email			= "test@mail.com";
}
