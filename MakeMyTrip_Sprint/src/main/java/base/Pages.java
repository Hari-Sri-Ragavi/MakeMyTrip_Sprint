package base;

import org.openqa.selenium.WebDriver;

import pages.FlightSearchPage;
import pages.FlightTrackerPage;
import pages.HomePage;
import pages.HotelSearchPage;
import pages.TrainPNRPage;
import pages.TrainSearchPage;

public class Pages {
	public static HomePage hp;
	public static TrainSearchPage tp;
	public static HotelSearchPage hsp;
	 public static FlightSearchPage fp;  // Added
	 public static FlightTrackerPage ftp;  // Add this
	 static {
	        // Initialize with null, will be set in loadAllPages
	        ftp = null;
	    }
	public static TrainPNRPage tpnr;
	
	
	
	public static void loadAllPages(WebDriver driver)
	{
		hp=new HomePage(driver);
		tp=new TrainSearchPage(driver);
		hsp = new HotelSearchPage(driver);
		fp = new FlightSearchPage(driver);  // Added
		 ftp = new FlightTrackerPage(driver);  // Initialize this
		tpnr=new TrainPNRPage(driver);
	}
	
	
	

}
