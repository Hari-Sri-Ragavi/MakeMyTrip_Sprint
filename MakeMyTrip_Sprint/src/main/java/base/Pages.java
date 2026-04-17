package base;

import org.openqa.selenium.WebDriver;

import pages.HomePage;
import pages.HotelSearchPage;
import pages.TrainSearchPage;

public class Pages {
	public static HomePage hp;
	public static TrainSearchPage tp;
	public static HotelSearchPage hsp;
	
	
	public static void loadAllPages(WebDriver driver)
	{
		hp=new HomePage(driver);
		tp=new TrainSearchPage(driver);
		hsp = new HotelSearchPage(driver);
	}
	
	
	

}
