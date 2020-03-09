package Common;

import org.openqa.selenium.WebDriver;

public class Constant {
	public static WebDriver driver;
	public static final String chromePath		= "./Executables/chromedriver.exe";
	public static final String railwayURL 		= "http://logigearrailway.somee.com/Page/HomePage.cshtml";
	public static final String loginPageURL 	= "http://logigearrailway.somee.com/Account/Login.cshtml";
	public static final String validUsername	= "lam.tung.nguyen@logigear.com";
	public static final String validPassword	= "12345678";
	public static final String blankUsername	= "";
	public static final String blankPassword	= "";
	public static final String invalidPassword	= "abcd";
	public static final String newPassword		= "123456789";
	public static final String pidNumber		= "11111111";
	public static final String blankPidnumber	= "";
	public static 		String emailRegister	= "";
	public static final String prefixEmail		= "LAM";
	public static final String mailigatorURL	= "https://www.mailinator.com/v3/#/#inboxpane";
	
	//Page name
	public static final String myTicketPage			= "My Ticket";
	public static final String changePasswordPage	= "Change Password";
	public static final String ticketPricePage		= "Ticket Price";
	
	//Ticket Info
	public static final String date 		= "1/10/2019";
	public static final String departFrom 	= "Sài Gòn";
	public static final String arriveAt 	= "Nha Trang";
	public static final String seatType		= "Soft bed";
	public static final String ticketAmount = "1";
	public static final int bookingAmount 	= 6;
	public static final String[] departStationList = {"Sài Gòn", "Phan Thiết", "Sài Gòn", "Đà Nẵng", "Huế", "Quảng Ngãi"};
	
	//Filter option
	public static final String departFilterOption	 	= "Depart Station";
	public static final String ignoreFilterValue 		= "Ignore";
	public static final String departFilterValue 	 	= "Sài Gòn";
	public static final String blankDateFilterValue 	= "";
	public static final String invalidDateFilterValue 	= "12202018";
}
