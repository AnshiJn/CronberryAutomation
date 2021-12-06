package API_Automation_Testing.API_Automation_Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class App 
{
  
	@BeforeClass
	void LaunchBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "/Users/alcodesmobility/Desktop/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://qa1.cronberry.com/admin/sign-in");
		
		
	}
	
	
    @Test
    
    void login()
    {
        
        
    	System.out.print("passed");
    }
        
 
  

}