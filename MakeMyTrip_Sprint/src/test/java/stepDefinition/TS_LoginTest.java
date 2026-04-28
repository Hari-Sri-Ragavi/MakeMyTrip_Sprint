package stepDefinition;

import java.util.Set;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import base.BaseClass;
import base.Pages;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.Actions_Helper;
import util.ConfigReader;
import util.JavaScriptExceutor_Utility;
import util.WebDriver_Utility;

public class TS_LoginTest {

	private BaseClass b;
	private Pages pages;

	WebDriver_Utility wbu;
	Actions_Helper ah;
	JavaScriptExceutor_Utility jsu;
	SoftAssert sa = new SoftAssert();
	String parent_id = "";
	
	public TS_LoginTest(BaseClass b, Pages pages) {
		this.b = b;
		this.pages = pages;
		wbu = new WebDriver_Utility(b.getDriver());
		ah = new Actions_Helper(b.getDriver());
		jsu = new JavaScriptExceutor_Utility(b.getDriver());
	}

	@When("user logins through Gmail")
	public void user_logins_through_gmail() {
		pages.lp.clickLoginBtn();
		pages.lp.clickMailLogin();
		
		parent_id =  b.getDriver().getWindowHandle();
		Set<String> all_id = b.getDriver().getWindowHandles();

		all_id.remove(parent_id);
		String childWindowHandle = "";
		for (String ele : all_id) {
			childWindowHandle = ele;

		}
		
		b.getDriver().switchTo().window(childWindowHandle);
		String title=ConfigReader.getProperty("title");
		System.out.println(title);
	}

	@When("enters Email ID as {string}")
	public void enters_email_id_as(String mail) {
//		wbu.waitForElementload(5);
		pages.lp.configEnterEmail(mail);
		pages.lp.clickNextBtn();
	}

	@When("enters Password as {string}")
	public void enters_password_as(String pwd) throws InterruptedException {
		wbu.waitForElementload(5);
		Thread.sleep(5000);
		pages.lp.configEnterPwd(pwd);
		pages.lp.clickNextBtn();
	}

	@Then("continue to perform as logged user.")
	public void continue_to_perform_as_logged_user() throws InterruptedException {
		try {
			wbu.waitForElementload(5);
			pages.lp.clickContinueBtn();
		} catch(Exception e) {
			
		}
		
		b.getDriver().switchTo().window(parent_id);
		Thread.sleep(2000);
		pages.lp.getClosePhoneNoPopUp().click();
		
		String verifyText = pages.lp.getVerifyLogin().getText();
		String text = "T";
		
		
		Assert.assertEquals(verifyText, text);
		
		
	}
}
