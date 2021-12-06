package CronberryTestng.CronberryTestng.integration;

import java.io.FileInputStream;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;




public class BaseClass {

	public static WebDriver driver;
	public static Properties obj;
	
	@BeforeSuite
	
	public void login() throws Exception {
		
	
		System.setProperty("webdriver.chrome.driver", "/Users/alcodesmobility/Desktop/chromedriver");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.print("chrome broswer running");

		obj = new Properties();

		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"/XPath.properties");
		obj.load(objfile);
		String URL= obj.getProperty("URL");
		String UserName= obj.getProperty("UserName");
		String Password= obj.getProperty("Password");
		
		driver.get(URL);
		driver.findElement(By.xpath("/html/body/app-root/app-layout/div/div/div[2]/app-sign-in/div/tabset/div/tab[1]/form/div/div[1]/input")).sendKeys(UserName);
		driver.findElement(By.xpath("/html/body/app-root/app-layout/div/div/div[2]/app-sign-in/div/tabset/div/tab[1]/form/div/div[2]/input")).sendKeys(Password);
		driver.findElement(By.tagName("Button")).click();			
		
	}
	


	@AfterClass
	public void GoToDashBoard() throws Exception {
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//span[contains(text(),'Dashboard')]")).click();
		
		Thread.sleep(2000);
	}
	
	
	@AfterSuite

	public void CloseBrowser() throws Exception{
		
		Thread.sleep(4000);
		driver.close();
		
	}
}
