package testCasesPackage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import driverPackage.BaseDriver;
import pageObjectPackage.LoginPage;
import pageObjectPackage.SubmissionPage;



public class LoginAndIdeaSubmission extends BaseDriver {

	//Initialization
		public LoginPage lp;
		public SubmissionPage sp;
		public void initialize() throws IOException, InterruptedException {
			
			driver=initializeDriver();
		}
		@Test(dataProvider="getData")
		public void Login_and_submission(String username,String password) throws InterruptedException {
			SoftAssert softAssert =new SoftAssert();
			lp=new LoginPage(driver);
			sp=new SubmissionPage(driver);
			lp.CookiesAccept().click();
			lp.Userlogin().click();
			lp.provideUsername().sendKeys(username);
			lp.providepassword().sendKeys(password);
			lp.clickLoginbutton().click();
			//login_assertion
			softAssert.assertEquals(driver.getCurrentUrl(), "https://rashed.ideascale.com/a/community/login");
			sp.clickIconplusbutton().click();
			WebDriverWait w=new WebDriverWait(driver,15);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'-- Please choose a campaign --')]")));
			sp.clickDropdown().click();
			WebDriverWait w1=new WebDriverWait(driver,15);
			w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Product Improvement')]")));
			sp.selectDropdownoption().click();
			sp.provideTitle().sendKeys("PROJECT PURPOSE");
			sp.provideDescription().sendKeys("Description of new ideas");
			sp.clickSubmitbutton().click();
			WebDriverWait w3=new WebDriverWait(driver,15);
			w3.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='font-weight-bold h3']")));
			//Title_assertion
			softAssert.assertEquals(sp.validateTitle().getText(), "PROJECT PURPOSE");
			//Description_assertion
			softAssert.assertEquals(sp.validateDescription().getText(), "Description of new ideas");
			softAssert.assertAll();
			
		}
			
			@DataProvider
			public Object[][] getData()
			{
			    //row stands for how many different data types test should run.
				//coloumn stands for how many values per each test
				Object[][] data=new Object[1][2];
				data[0][0]="makid94haider@gmail.com";
				data[0][1]="ideascaleP01";
				return data;
			
			}  
			
			
			
	
}
