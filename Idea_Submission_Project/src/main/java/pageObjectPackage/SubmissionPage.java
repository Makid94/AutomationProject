package pageObjectPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubmissionPage {

WebDriver driver;
	
	public SubmissionPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
			
		}
	
	@FindBy(css="[class='btn btn-submission-entry position-absolute']")
	WebElement iconplusbutton;
	
	@FindBy(xpath="//div[contains(text(),'-- Please choose a campaign --')]")
	WebElement dropdown;
	
	@FindBy(xpath="//span[contains(text(),'Product Improvement')]")
	WebElement dropdownoption;
	
	@FindBy(css="[id='title']")
	WebElement Title;
	
	@FindBy(css="[class='ql-editor ql-blank']")
	WebElement Description;
	
	@FindBy(css="[class='btn btn-primary']")
	WebElement submitbutton;
		
	@FindBy(css="[class='font-weight-bold h3']")
	WebElement titleValidation;
	
	@FindBy(xpath="//*[contains(@class,'ql-editor ql-render')]")
	WebElement descriptionValidation;
	
	
	 public WebElement clickIconplusbutton() {
		 return iconplusbutton;
		 
	 }
	 
	 public WebElement  clickDropdown () {
	    	
	     return dropdown;
	    	
		}
	 public WebElement  selectDropdownoption () {
	    	
	     return dropdownoption;
	    	
		}
	 
	 public WebElement provideTitle() {
		 return Title;
		 
	 }
	 public WebElement provideDescription() {
		 return Description;
		 
	 }
	 public WebElement clickSubmitbutton() {
		 return submitbutton;
		 
	 }
	 
	 public WebElement validateTitle() {
		 return titleValidation;
		 
	 }
	 
     public WebElement  validateDescription() {
		 return  descriptionValidation;
		 
	 }
	
}
