package pankajacademy.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pankajacademy.TestComponents.BaseTest;
import pankajacademy.pageobject.CartPage;
import pankajacademy.pageobject.ProductCatalogue;

public class ErrorValidation extends BaseTest {
	@Test(groups= {"ErrorHandling"})
	public void LoginErrorValidation() throws IOException {

		String productName = "ZARA COAT 3";

		landpage.loginapplication("tvorvoi@gmail.com", "Kampli@123");

		// .ng-tns-c4-4.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error

		Assert.assertEquals("Incorrect email  password.", landpage.geterrormessage());

	}

	@Test
	public void productErrorvalidation() throws IOException, InterruptedException {

		String productName = "ZARA COAT 3";

		ProductCatalogue productcatalogue = landpage.loginapplication("tvorvoi@gmail.com", "Kampli@123");

		List<WebElement> products = productcatalogue.productList();
		productcatalogue.addToCart(productName);
		CartPage cartpage = productcatalogue.goToCart();

		Boolean match = cartpage.verifyProductToCart("zara kcnsj");

		Assert.assertFalse(match);

	}

}
