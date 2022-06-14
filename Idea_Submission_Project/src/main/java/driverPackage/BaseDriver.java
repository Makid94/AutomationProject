package driverPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriver {

	
	 public WebDriver driver;
     @BeforeSuite
	 public WebDriver  initializeDriver() throws IOException, InterruptedException {
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("D:\\EclipseProject\\Idea_Submission_Project\\src\\main\\java\\config_Package\\config.properties");
        
		prop.load(fis);
		
		if(prop.getProperty("browser").equals("chrome"))
			
			WebDriverManager.chromedriver().setup();
		    driver=new ChromeDriver();
		    
		    driver.get(prop.getProperty("url"));
		    
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		    driver.manage().window().maximize();
		    return driver;
		
	}
	@AfterSuite
	public void TearDown() {
		driver.quit();
	
		
	}
	
	
	
}
