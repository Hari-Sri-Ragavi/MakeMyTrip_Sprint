package base;

import org.openqa.selenium.WebDriver;

import pages.CABS_SearchPage;
import pages.HomePage;
import pages.SelectCabpage;
import pages.TrainAddPassengerPage;
import pages.TrainFilterPage;
import pages.FlightSearchPage;
import pages.FlightTrackerPage;
import pages.HPActivityInfoPage;
import pages.HPFilterPage;
import pages.HPHomePage;
import pages.HPReviewPage;
import pages.HomePage;
import pages.HotelSearchPage;
import pages.TrainPNRPage;
import pages.TrainSearchPage;

public class Pages {
	public HomePage hp;
	public TrainSearchPage tp;
	public CABS_SearchPage csp;
	public SelectCabpage scp;
	public HotelSearchPage hsp;
	public FlightSearchPage fp; // Added
	public FlightTrackerPage ftp; // Add this
	public TrainPNRPage tpnr;
	public TrainAddPassengerPage tap;
	public TrainFilterPage tfp;

	// Holiday Package
	public static HPHomePage home;
	public static HPFilterPage hpf;
	public static HPActivityInfoPage hpa;
	public static HPReviewPage hpr;

	public void loadAllPages(WebDriver driver) {
		hp = new HomePage(driver);
		tp = new TrainSearchPage(driver);
		csp = new CABS_SearchPage(driver);
		scp = new SelectCabpage(driver);
		hsp = new HotelSearchPage(driver);
		fp = new FlightSearchPage(driver); // Added
		ftp = new FlightTrackerPage(driver); // Initialize this
		tpnr = new TrainPNRPage(driver);
		tap = new TrainAddPassengerPage(driver);
		tfp = new TrainFilterPage(driver);

		// Holiday Package
		home = new HPHomePage(driver);
		hpf = new HPFilterPage(driver);
		hpa = new HPActivityInfoPage(driver);
		hpr = new HPReviewPage(driver);
	}

}
