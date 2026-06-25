package pankajacademy.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pankajacademy.AbstrctComponents.AbstractComponent;

public class CartPage extends AbstractComponent{
	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProduct;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;

    

   public  Boolean verifyProductToCart(String productName) {
	   Boolean match= cartProduct.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
	   return match;
	   
   }
   public CheckOutPage goToCheck() {
   checkoutEle.click();
   
   return new CheckOutPage(driver);
   
   }

}
