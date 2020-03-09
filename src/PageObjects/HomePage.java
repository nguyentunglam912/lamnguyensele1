package PageObjects;

import Common.Constant;

public class HomePage extends GeneralPage{
	//Methods
	public HomePage open() {
		Constant.driver.navigate().to(Constant.railwayURL);
		return this;
	}
}
