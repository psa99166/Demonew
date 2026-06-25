package pankajacademy.StepDefinationOnImpl;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pankajacademy.TestComponents.BaseTest;
import pankajacademy.pageobject.CartPage;
import pankajacademy.pageobject.CheckOutPage;
import pankajacademy.pageobject.ConformationPage;
import pankajacademy.pageobject.LandingPage;
import pankajacademy.pageobject.ProductCatalogue;

public class StepDefinationOnImpl extends BaseTest{
	public  LandingPage landpage;
	public ProductCatalogue productcatalogue;
	public 	ConformationPage confirmationpage;
	@Given("I land on Ecommerce page")
	public void I_land_on_Ecommerce_page() throws IOException{
		landpage=launchApplication();
		
		
	}
	@Given( "^Logged in with username(.+) and passwordd(.+)$")
	public void Logged_in_username_and_password(String username, String passwordd){
		productcatalogue = landpage.loginapplication(username, passwordd);
	}
	@When ("^I add product (.+) to cart$")
	public void I_add_product_to_cart(String productName) throws InterruptedException{
		List<WebElement> products = productcatalogue.productList();
		productcatalogue.addToCart(productName);
	
	}
	@When("^Checkout (.+) and submit the order$")
		public void Checkout_and_submit_the_order(String productName) {
		CartPage cartpage = productcatalogue.goToCart();
		Boolean match = cartpage.verifyProductToCart(productName);

		Assert.assertTrue(match);
		CheckOutPage checkoutpage = cartpage.goToCheck();
		checkoutpage.SelectCountry("india");
		confirmationpage = checkoutpage.submitOrder();
		
	}
	@Then ("{string} message is displayed on ConfirmationPage")
	public void message_is_displayed_onConfirmationPage(String string) {

		String confirmMessage = confirmationpage.getConfirmationMessage();

		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		driver.close();
		
	}
	@When ("{string} message_is_displayed") 
	public void message_is_displayed(String string) {
		Assert.assertEquals(string, landpage.geterrormessage());
		driver.close();		
	}
	
	
		
	

}
