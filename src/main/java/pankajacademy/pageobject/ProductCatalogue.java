package pankajacademy.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pankajacademy.AbstrctComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent
{
	
	WebDriver driver;

	public ProductCatalogue(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	
    
	 
    @FindBy(css=".mb-3")
    List<WebElement> products;
    @FindBy(css=".ng-animating")
    WebElement spinner;
   
    By productssBy=By.cssSelector(".mb-3");
    By addcart=By.cssSelector(".card-body button:last-of-type");
    By toastvisible=By.cssSelector("#toast-container");
    public List<WebElement> productList() {
    	waitForElementToAppear(productssBy);
		return products;
    	
    }
     public WebElement getProductByName(String productName) {
    	   WebElement prod= productList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
    	   return prod;
    	    
    	 
     }
     public void addToCart(String productName) throws InterruptedException {
    	 WebElement prod=getProductByName(productName);
    	   prod.findElement(addcart).click();
    		waitForElementToAppear(toastvisible);
      
         waitForElementToDisappear(spinner);
     }


     
}
