package Cronberry.Automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateCampaign {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
			Properties obj = new Properties();
			FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"/XPath.properties");
			obj.load(objfile);
			System.setProperty("webdriver.chrome.driver", "/Users/alcodesmobility/Desktop/chromedriver");
			WebDriver driver = new ChromeDriver();

			String URL= obj.getProperty("URL");
			String UserName= obj.getProperty("UserName");
			String Password= obj.getProperty("Password");
			
			driver.get(URL);
			driver.manage().window().maximize();
			driver.findElement(By.xpath("/html/body/app-root/app-layout/div/div/div[2]/app-sign-in/div/tabset/div/tab[1]/form/div/div[1]/input")).sendKeys(UserName);
			driver.findElement(By.xpath("/html/body/app-root/app-layout/div/div/div[2]/app-sign-in/div/tabset/div/tab[1]/form/div/div[2]/input")).sendKeys(Password);
			Thread.sleep(2000);
			driver.findElement(By.tagName("Button")).click();
			Thread.sleep(4000);
			
			createCampaignPush(driver,obj,objfile); 
			
		}
		
public static void createCampaignPush (WebDriver driver,Properties obj,FileInputStream objfile) throws Exception {
	
		driver.findElement(By.cssSelector("a[href='/admin/create-campaign-segment/push']")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-create-campaign-with-segment/main/section/div[2]/div/form/div[2]/div/div/div[1]/label/span[2]")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-create-campaign-with-segment/main/section/div[2]/div/form/div[2]/div/div/div[3]/label/span[2]")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-create-campaign-with-segment/main/section/div[2]/div/form/div[3]/div/div/div[1]/button[1]")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-create-campaign-with-segment/main/section/div[2]/div/form/div[1]/div/div/div/input")).sendKeys("new campaign");

		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-create-campaign-with-segment/main/section/div[2]/div/div[2]/div/div[2]/button")).click();



}		
		
	}


