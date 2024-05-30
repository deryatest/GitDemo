package stepDefinitions;

import Utills.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import pageObjects.CheckoutPage;
import pageObjects.LandingPage;

public class CheckOutPageStepDefinition {
    public WebDriver driver;
    public String landingPageProductName;
    public String offerPageProductName;
    public CheckoutPage checkoutPage;
    TestContextSetup testContextSetup;


    public CheckOutPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
    }

    @Then("verify user has ability to enter promo code and place the order")
    public void verify_user_has_ability_to_enter_promo_code_and_place_the_order()
    {
        Assert.assertTrue(checkoutPage.VerifyPromoBtn());
        Assert.assertTrue(checkoutPage.VerifyPlaceOrder());
    }
    @Then("^user proceeds to Checkout and validate (.+) items in checkout page$")
    public void user_proceeds_to_Checkout_and_validate(String name) throws InterruptedException {
        checkoutPage.CheckoutItems();
        Thread.sleep(2000);
    }
}
