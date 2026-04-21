package base;

import org.openqa.selenium.WebDriver;

import pages.CABS_SearchPage;
import pages.CabAirportPage;
import pages.CabPage;
import pages.HomePage;
import pages.Homepagecab;
import pages.SelectCabpage;
import pages.SelectGiftCardPage;
import pages.SelectOccasionPage;
import pages.TrainAddPassengerPage;
import pages.TrainFilterPage;
import pages.FlightSearchPage;
import pages.FlightTrackerPage;
import pages.GiftCardBookingPage;
import pages.HPActivityInfoPage;
import pages.HPFilterPage;
import pages.HPHomePage;
import pages.HPReviewPage;
import pages.HomePage;
import pages.HotelSearchPage;
import pages.ReviewBookingPage;
import pages.TrainPNRPage;
import pages.TrainPaymentPage;
import pages.TrainSearchPage;
import util.AllFunctionalities;

public class Pages {
	
	public HomePage hp;
	
	public HotelSearchPage hsp;
	
	//Flight Module
	public FlightSearchPage fp; // Added
	public FlightTrackerPage ftp; // Add this
	
	//Train Module
	public TrainSearchPage tp;
	public TrainPNRPage tpnr;
	public TrainAddPassengerPage tap;
	public TrainFilterPage tfp;
	public TrainPaymentPage tpp;

	// Holiday Package Module
	public  HPHomePage home;
	public HPFilterPage hpf;
	public  HPActivityInfoPage hpa;
	public  HPReviewPage hpr;
	
	//Cab Module
	public  Homepagecab hpc;
	public  CabPage cp;
	public CABS_SearchPage csp;
	public SelectCabpage scp;
	 public  ReviewBookingPage rbp;
	 public SelectGiftCardPage sgcp;
	 public  SelectOccasionPage sop;
	 public  GiftCardBookingPage gbp;
	 public AllFunctionalities all;
	public static CabAirportPage cap;
	

	public void loadAllPages(WebDriver driver) {
		
		//home
		hp = new HomePage(driver);
		
		//hotel
		hsp = new HotelSearchPage(driver);
		
		//flight
		fp = new FlightSearchPage(driver); // Added
		ftp = new FlightTrackerPage(driver); // Initialize this
		

		// Holiday Package
		home = new HPHomePage(driver);
		hpf = new HPFilterPage(driver);
		hpa = new HPActivityInfoPage(driver);
		hpr = new HPReviewPage(driver);
		
		//cab
		hpc=new Homepagecab(driver);
		cp=new CabPage(driver);
		csp=new CABS_SearchPage(driver);
		scp=new SelectCabpage(driver);
		rbp=new ReviewBookingPage(driver);
		sgcp=new SelectGiftCardPage(driver);
		sop=new SelectOccasionPage(driver);
		gbp=new GiftCardBookingPage(driver);
		all=new AllFunctionalities(driver);
		cap=new CabAirportPage(driver);
		
		//train
		tp = new TrainSearchPage(driver);
		tpnr = new TrainPNRPage(driver);
		tap = new TrainAddPassengerPage(driver);
		tfp = new TrainFilterPage(driver);
		tpp=new TrainPaymentPage(driver);
		
	}

}
