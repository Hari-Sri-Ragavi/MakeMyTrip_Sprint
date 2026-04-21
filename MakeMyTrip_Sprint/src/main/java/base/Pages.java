package base;

import org.openqa.selenium.WebDriver;

import pages.*;
import util.AllFunctionalities;

public class Pages {
	
	public HomePage hp;
	public LoginPage lp;
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
		
		lp = new LoginPage(driver);
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
