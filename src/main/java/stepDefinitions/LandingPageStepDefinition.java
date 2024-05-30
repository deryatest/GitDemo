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

import java.util.Iterator;
import java.util.Set;

public class LandingPageStepDefinition {
    public WebDriver driver;
    public String landingPageProductName;
    public String offerPageProductName;
    TestContextSetup testContextSetup;
    LandingPage landingPage;


    public LandingPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.landingPage =testContextSetup.pageObjectManager.getLandingPage();
    }

    @Given("User is on GreenCart Landing Page")
    public void user_is_on_green_cart_landing_page() {
     //   System.setProperty("webdriver.chrome.driver", "C:/Users/dur33799/OneDrive - Ordina/Documenten/Learning/chromedriver-win64/chromedriver.exe");
     //   testContextSetup.driver = new ChromeDriver();
     //   testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
    }

    @When("^user searched with Shortname (.+) and extracted actual name of product$")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {

        landingPage.searchItem(shortName);
        Thread.sleep(2000);
        testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
        System.out.println(testContextSetup.landingPageProductName + " is extracted from Home page");
    }
    @When("added {string} items of the selected product to cart")
    public void Added_items_product (String quantity)
    {
    landingPage.incrementQuantity(Integer.parseInt(quantity));
    landingPage.addToCart();
    }
}
