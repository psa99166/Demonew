package pankajacademy.tests;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import pankajacademy.TestComponents.BaseTest;
import pankajacademy.pageobject.CartPage;
import pankajacademy.pageobject.CheckOutPage;
import pankajacademy.pageobject.ConformationPage;
import pankajacademy.pageobject.LandingPage;
import pankajacademy.pageobject.OrderPage;
import pankajacademy.pageobject.ProductCatalogue;

public class submitordertest extends BaseTest {
	String productName = "ZARA COAT 3";
	@Test(dataProvider="getData",groups={"purchase"})
	public void submitorder(HashMap<String,String> input) throws IOException, InterruptedException {



		ProductCatalogue productcatalogue = landpage.loginapplication(input.get("email"),input.get("password"));

		List<WebElement> products = productcatalogue.productList();
		productcatalogue.addToCart(input.get("productName"));
		CartPage cartpage = productcatalogue.goToCart();

		Boolean match = cartpage.verifyProductToCart(input.get("productName"));

		Assert.assertTrue(match);
		CheckOutPage checkoutpage = cartpage.goToCheck();
		checkoutpage.SelectCountry("india");
		ConformationPage confirmationpage = checkoutpage.submitOrder();

		String confirmMessage = confirmationpage.getConfirmationMessage();

		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}
	@Test(dependsOnMethods= {"submitorder"})
	public void controlorderTest() {
		ProductCatalogue productcatalogue = landpage.loginapplication("tvorvoi@gmail.com", "Kampli@123");
		OrderPage orderpage=productcatalogue.gotoOrderPage();
	    orderpage.verifyOrderDisplay(productName);
	    Assert.assertTrue(orderpage.verifyOrderDisplay(productName));
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException{
//		return new Object[][] {{"tvorvoi@gmail.com","Kampli@123","ZARA COAT 3"},{"thousifvorvoi57@gmail.com","Kampli@123","ADIDAS ORIGINAL"}};
//		HashMap<String,String> Map=new HashMap<String,String>();
//		Map.put("email","tvorvoi@gmail.com");
//		Map.put("password","Kampli@123");
//		Map.put("productName","ZARA COAT 3");
//		HashMap<String,String> Map1=new HashMap<String,String>();
//		Map1.put("email","thousifvorvoi57@gmail.com");
//		Map1.put("password","Kampli@123");
//		Map1.put("productName","ADIDAS ORIGINAL");
//		return new Object[][] {{Map},{Map1}};
		List<HashMap<String,String>> data=getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\pankajacademy\\data\\purchase.json");
	
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}

}
