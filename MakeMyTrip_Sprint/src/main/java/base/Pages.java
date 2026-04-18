package base;

import org.openqa.selenium.WebDriver;

import pages.CABS_SearchPage;
import pages.HomePage;
import pages.SelectCabpage;
import pages.TrainSearchPage;

public class Pages {
	public static HomePage hp;
	public static TrainSearchPage tp;
	public static CABS_SearchPage csp;
	public static SelectCabpage scp;
	
	
	
	public static void loadAllPages(WebDriver driver)
	{
		hp=new HomePage(driver);
		tp=new TrainSearchPage(driver);
		csp=new CABS_SearchPage(driver);
		scp=new SelectCabpage(driver);
	}

}
