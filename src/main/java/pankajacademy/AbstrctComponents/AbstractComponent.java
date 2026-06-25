package pankajacademy.AbstrctComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pankajacademy.pageobject.CartPage;
import pankajacademy.pageobject.OrderPage;

public class AbstractComponent {
	
   WebDriver driver;
   public AbstractComponent(WebDriver driver) {
	   this.driver=driver;
	   PageFactory.initElements(driver, this);
   }
   @FindBy(css="[routerlink*='cart']")
   WebElement cartProduct;
   @FindBy(css="[routerlink*='myorders']")
   WebElement orderproduct;
    
    public void waitForElementToAppear(By findBy) {
    	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
    	    wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    	
    	
    }
    
    public void waitForWebElementToAppear(WebElement findBy) {
    	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
    	    wait.until(ExpectedConditions.visibilityOf(findBy));
    	
    	
    }
    public CartPage goToCart() {
    	cartProduct.click();
    	CartPage cartPage=new CartPage(driver);
    	return cartPage;
    	
    }
    public OrderPage gotoOrderPage() {
    	 orderproduct.click();
    	OrderPage orderPage=new OrderPage(driver);
    	return orderPage;
    	
    }
    public void waitForElementToDisappear(WebElement spinner2) throws InterruptedException {
    	Thread.sleep(1000);//  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
    	
		// TODO Auto-generated method stub
    	//wait.until(ExpectedConditions.invisibilityOf(spinner2));

		
	 }
 
  
    


}
