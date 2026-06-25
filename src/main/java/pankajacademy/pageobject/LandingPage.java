package pankajacademy.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pankajacademy.AbstrctComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
	WebDriver driver;

	public LandingPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

    @FindBy(id="userEmail")
    WebElement userEmail;	
    @FindBy(id="userPassword")
    WebElement userPassword;
    @FindBy(id="login")
    WebElement login;
    @FindBy(css="[class*='flyInOut']")
    WebElement errormessage;
       public ProductCatalogue loginapplication(String email,String password) {
    	userEmail.sendKeys(email);
    	userPassword.sendKeys(password);
    	login.click();
    	   
        ProductCatalogue productcatalogue=new ProductCatalogue(driver);
        return productcatalogue;
    	
    	
    }
    public void goTo() {
    	  driver.get("https://rahulshettyacademy.com/client/#/auth/login");
    	
    }
    public String geterrormessage() {
    	waitForWebElementToAppear(errormessage);
    	return errormessage.getText();
    }
}
