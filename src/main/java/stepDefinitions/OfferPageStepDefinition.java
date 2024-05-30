package stepDefinitions;

import Utills.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;

import java.util.Iterator;
import java.util.Set;

public class OfferPageStepDefinition {
public WebDriver driver;
public String landingPageProductName;
public String offerPageProductName;
TestContextSetup testContextSetup;
PageObjectManager pageObjectManager;

public OfferPageStepDefinition (TestContextSetup testContextSetup)    {
        this.testContextSetup=testContextSetup;
    }
    @Then("^user searched for (.+) Shortname in offers page$")
    public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exist(String shortName) throws InterruptedException {
        //offer page->enter->grab text
        switchToOffersPage();
       // OffersPage offersPage = new OffersPage(testContextSetup.driver);
        OffersPage offersPage=testContextSetup.pageObjectManager.offersPage();
        offersPage.searchItem(shortName);
        Thread.sleep(2000);
        offerPageProductName = offersPage.getProductName();
        System.out.println (offerPageProductName + " is extracted from Offer page");
    }

   public void switchToOffersPage(){
        //if switched to offor page -> skip below part
        //if (testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers")
        LandingPage landingPage =testContextSetup.pageObjectManager.getLandingPage();
        landingPage.selectTopDealsPage();
        testContextSetup.genericUtils.SwitchWindowToChild();
    }
    @Then("validate product name in offers page matches with Landing Page")
        public void validate_product_name_in_offers_page_matches_with_Landing_Page () {
        Assert.assertEquals (offerPageProductName, testContextSetup.landingPageProductName);
    }

}
