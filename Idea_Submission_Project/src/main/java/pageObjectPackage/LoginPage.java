package pageObjectPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
			
		}
	
	@FindBy(xpath="//button[contains(text(),'Accept')]")
	WebElement CookiesAccept ;
	
	@FindBy(css="[data-element-id='community-login-link']")
	WebElement login ;
	
	@FindBy(css="[id='login-email']")
	WebElement username ;
	
	@FindBy(css="[id='login-password']")
	WebElement password ;
	
	@FindBy(css="[data-tracker-event-label='Email Login : Login Started']")
	WebElement Loginbutton;
	
 
	 
	 public WebElement  CookiesAccept () {
	     return CookiesAccept;
	    	
		}
	 
	 public WebElement Userlogin() {
		 return login;
		 
	 }
	 public WebElement  provideUsername () {
	     return username;
	    	
		}
	 
	 public WebElement  providepassword () {
	     return password;
	    }
	 
	 public WebElement clickLoginbutton() {
		 return Loginbutton;
		 
	 }
}
