package base;

import org.openqa.selenium.WebDriver;

import pages.HomePage;
import pages.TrainPNRPage;
import pages.TrainSearchPage;

public class Pages {
	public static HomePage hp;
	public static TrainSearchPage tp;
	public static TrainPNRPage tpnr;
	
	
	
	public static void loadAllPages(WebDriver driver)
	{
		hp=new HomePage(driver);
		tp=new TrainSearchPage(driver);
		tpnr=new TrainPNRPage(driver);
	}

}
