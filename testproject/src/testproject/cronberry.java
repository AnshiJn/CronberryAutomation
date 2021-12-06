package testproject;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;


public class cronberry {

	

		
		public static void main(String[] args) throws Exception {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
	        WebDriver driver=new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://dev1.cronberry.com/");
	        
	        
	        
	        
	       
	  Thread.sleep(2000);  
	       
Thread.sleep(2000); 

Properties obj = new Properties(); 

FileInputStream objfile = new FileInputStream("cronberry.properties");


obj.load(objfile);

String features = obj.getProperty("Features");

WebElement features1= driver.findElement(By.xpath(features));

features1.click();

String login= obj.getProperty("Login");

WebElement login1 = driver.findElement(By.xpath(login));
	    login1.click();
	     
	    Thread.sleep(2000);
	    
	    String mainWindowHandle = driver.getWindowHandle();
	    
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        // Here we will check if child window has other child windows and will fetch the heading of the child window
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                
                	driver.switchTo().window(ChildWindow);
                //WebElement text = driver.findElement(By.id("sampleHeading"));
                
                }
        }

 	  
        WebElement emailid=driver.findElement(By.xpath("/html/body/app-root/app-layout/div/div/div[2]/app-sign-in/div/tabset/div/tab[1]/form/div/div[1]/input"));	
 	  
 	   Thread.sleep(2000);
 	  
 	  
       emailid.sendKeys("testingprofil@mailinator.com");
        
        
       WebElement signup = driver.findElement(By.xpath("/html/body/app-root/app-layout/div/div/div[2]/app-sign-in/div/tabset/div/tab[1]/form/div/div[4]/button"));
	    
	    
	   WebElement password= driver.findElement(By.xpath("/html/body/app-root/app-layout/div/div/div[2]/app-sign-in/div/tabset/div/tab[1]/form/div/div[2]/input"));        
	
	    password.sendKeys("1234");	
	    
	    WebElement retype=driver.findElement(By.xpath("/html/body/app-root/app-layout/div/div/div[2]/app-sign-in/div/tabset/div/tab[1]/form/div/div[3]/input"));
	    
	    retype.sendKeys("1234");		
	  
	    signup.click();
	    
	 	   Thread.sleep(1000);

	    
	    WebElement toastmsg= driver.findElement(By.xpath("/html/body/div/div"));   
	    
    	String str1= toastmsg.getText();
    
	    System.out.println(str1);
	    
	   if (str1.contains("Already Exist"))
	   {
		   System.out.println("valid");
	   
	   }
	    
	   
	   else {
		   
		   System.out.println("invalid");
	   }
	   
	   
	}
		
}
	     



