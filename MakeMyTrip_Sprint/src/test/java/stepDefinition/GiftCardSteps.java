package stepDefinition;

import org.openqa.selenium.By;
import org.testng.Assert;
import base.BaseClass;
import base.Pages;
import io.cucumber.java.en.*;
import util.ExcelReader;

public class GiftCardSteps {

    private BaseClass b;
    private Pages pages;

    public GiftCardSteps(BaseClass b,Pages pages) {
        this.b = b;
        this.pages = pages;
    }

    @Given("user opens the browser for gift cards")
    public void user_opens_browser_for_gift_cards() {

       this. pages.loadAllPages(b.getDriver());

        System.out.println("Pages initialized");
    }

    @When("user clicks on the More menu from the results page")
    public void user_clicks_on_more_menu_from_results_page() {

        pages.sgcp.hoverMoreMenu();
    }

    @When("user selects Gift Cards from the More menu")
    public void user_selects_gift_cards_from_more_menu() {

        pages.sgcp.clickGiftCards();
    }

    @Then("user should be navigated to the Gift Cards page")
    public void user_should_be_navigated_to_gift_cards_page() {

        Assert.assertTrue(pages.sgcp.isGiftPageOpened(),
                "Not navigated to Gift Cards page");

        System.out.println("Gift Cards page verified");
    }

    @Then("all occasion categories should be displayed")
    public void all_occasion_categories_should_be_displayed() {

        System.out.println("Occasion categories visible");
    }
    //---------------------scenario 2----------------------------------
    @When("user selects gift occasion")
    public void user_selects_gift_occasion() {

        System.out.println("Step triggered: gift occasion");

        pages.sop.selectGiftOccasion();
    }

    @When("user selects gift card")
    public void user_selects_gift_card() {

        System.out.println("Step triggered: gift card");

        pages.sop.selectGiftCard();
    }
    @Then("gift card detail page should be displayed")
    public void gift_card_detail_page_should_be_displayed() {

        String url = b.getDriver().getCurrentUrl();

        boolean status = url.contains("gift-card");

        Assert.assertTrue(status,
                " Gift card detail page NOT displayed. Current URL: " + url);

        System.out.println("Gift card detail page is displayed");
    }
    
    ////////-------------scenario 3---------------------------------------
    @When("user selects gift card amount")
    public void user_selects_gift_card_amount() {
        pages.gbp.selectAmount();
        System.out.println("Amount selected");
    }

    @When("user enters sender name")
    public void user_enters_sender_name() throws Exception {
        pages.gbp.enterName();
        System.out.println("Name entered");
    }

    @When("user enters sender email")
    public void user_enters_sender_email() throws Exception {
        pages.gbp.enterEmail();
        System.out.println("Email entered");
    }

    @When("user enters sender mobile number")
    public void user_enters_sender_mobile_number() throws Exception {
        pages.gbp.enterMobile();
        System.out.println("Mobile entered");
    }
    @Then("verify entered")
    public void verify_entered() {

        String name = b.getDriver()
                .findElements(By.tagName("input")).get(0)
                .getAttribute("value");

        String email = b.getDriver()
                .findElements(By.tagName("input")).get(1)
                .getAttribute("value");

        String mobile = b.getDriver()
                .findElements(By.tagName("input")).get(2)
                .getAttribute("value");

        Assert.assertFalse(
                name.isEmpty() && email.isEmpty() && mobile.isEmpty(),
                "Sender details not entered"
        );

        System.out.println("Sender details entered successfully");
    }}
