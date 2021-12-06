package Cronberry.Automation;

import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Locatable;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

public class testClass {

	
	
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
		
		creatForm(obj,objfile,driver,URL,UserName,Password);
	//	deleteFrom();
	//	editForm();
	//	formUser();
	//	urlShortner(obj,objfile,driver,URL,UserName,Password);
		driver.close();
		System.out.println("end of program");
	}
	
	public static void creatForm(Properties obj,FileInputStream objfile, WebDriver driver,String URL,String UserName,String Password) throws Exception
	{
		
		obj.load(objfile);
		
		Thread.sleep(5000);

		//CSV file creation
		
		CSVWriter writer = new CSVWriter(new FileWriter(new File(
				"/Users/alcodesmobility/eclipse-workspace/Automation/CSV Sheets/CustomForm.csv")),
				',');

		String[] header = { "UseCase", "Message", "Result" };
		writer.writeNext(header);
		
		driver.manage().window().maximize();
		driver.get(URL);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("/html/body/app-root/app-layout/div/div/div[2]/app-sign-in/div/tabset/div/tab[1]/form/div/div[1]/input")).sendKeys(UserName);
		driver.findElement(By.xpath("/html/body/app-root/app-layout/div/div/div[2]/app-sign-in/div/tabset/div/tab[1]/form/div/div[2]/input")).sendKeys(Password);
		driver.findElement(By.tagName("Button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/aside/div/nav/ul/li[11]/a/div[1]/span[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/aside/div/nav/ul/li[11]/ul/li[1]/a")).click();
		Thread.sleep(4000);

		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/aside/div/nav/ul/li[11]/ul/li[1]/ul/li[2]/a")).click();
		Thread.sleep(2000);

	   System.out.print(driver.getTitle());
		
		
		driver.findElement(By.cssSelector("a[href='/admin/custom-form']")).click();
		Thread.sleep(4000);
		
		
		
		
		
		
		Actions builder = new Actions(driver);
	
		WebElement selectTextBox=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/customform-app/main/section/div[2]/div/div[1]/div[1]/div[1]/tabset/div/tab[1]/div/ul/li[1]/span"));

		System.out.println(	selectTextBox.getText());
		
		WebElement droptBox=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/customform-app/main/section/div[2]/div/div[2]/div[1]/div/section"));
		System.out.println(	droptBox.getTagName());
		System.out.println(droptBox.getLocation());
		
		WebElement submit=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/customform-app/main/section/div[2]/div/div[3]/button"));
		
		builder.click(submit);
		
		Thread.sleep(1000);
		
		WebElement submitbutton=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/customform-app/main/section/div[2]/div/div[2]/div[1]/div/section/div"));
		
		System.out.println(submitbutton.getLocation());
		

		
		
		Robot robot = new Robot();	
		robot.mouseMove(227, 550);
		Thread.sleep(4000);

		builder.dragAndDropBy(selectTextBox, 512, 28).build().perform();
		
		Thread.sleep(7000);

		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/customform-app/main/section/div[2]/div/div[2]/div[1]/div/section/div[1]/div[1]/div[1]/i[2]")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/customform-app/main/section/div[2]/div/div[2]/div[1]/div/section/div[1]/div[2]/div[3]/select")).sendKeys("Name");
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/customform-app/main/section/div[2]/div/div[2]/div[1]/div/section/div[1]/div[2]/div[2]/input")).clear();
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/customform-app/main/section/div[2]/div/div[2]/div[1]/div/section/div[1]/div[2]/div[2]/input")).sendKeys("Enter Your Name");
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/customform-app/main/section/div[2]/div/div[2]/div[1]/div/section/div[1]/div[1]/div[1]/i[2]")).click();
		Thread.sleep(2000);

		
		
		
		WebElement emaildrag=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/customform-app/main/section/div[2]/div/div[1]/div/ul/li[2]/span"));
		
		Thread.sleep(1000);
		robot.mouseMove(227, 630);
		
		builder.dragAndDropBy(emaildrag, 512, 27).build().perform();		

		Thread.sleep(7000);
    
		WebElement dragsubmit=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/customform-app/main/section/div[2]/div/div[2]/div[1]/div/section/div[2]/div/i"));
		
		builder.dragAndDropBy(dragsubmit, 548, 33).build().perform();		
		
		robot.mouseMove(227, 730);

		WebElement formname=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/customform-app/main/section/div[2]/div/div[2]/div[1]/div/div/div[1]/div[1]/input"));
		WebElement formmsg=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/customform-app/main/section/div[2]/div/div[2]/div[1]/div/div/div[2]/div[1]/input"));
		
		String formName= obj.getProperty("formName");
		
		formname.sendKeys(formName);
		formmsg.sendKeys("Thanks For Your Response");
		submit.click();

		System.out.print("end of program");
		
	}	
	
	
	public static void deleteFrom() throws Exception{
		Properties obj = new Properties();

		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"/XPath.properties");
		
		obj.load(objfile);
		
		Thread.sleep(5000);
		
		System.setProperty("webdriver.chrome.driver", "/Users/alcodesmobility/Desktop/chromedriver");
		WebDriver driver = new ChromeDriver();
	
		String URL= obj.getProperty("URL");
		String UserName= obj.getProperty("UserName");
		String Password= obj.getProperty("Password");
		
		driver.manage().window().maximize();
		driver.get(URL);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("/html/body/app-root/app-layout/div/div/div[2]/app-sign-in/div/tabset/div/tab[1]/form/div/div[1]/input")).sendKeys(UserName);
		driver.findElement(By.xpath("/html/body/app-root/app-layout/div/div/div[2]/app-sign-in/div/tabset/div/tab[1]/form/div/div[2]/input")).sendKeys(Password);
		driver.findElement(By.tagName("Button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/aside/div/nav/ul/li[11]/a/div[1]/span[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/aside/div/nav/ul/li[11]/ul/li[1]/a")).click();
		Thread.sleep(4000);

		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/aside/div/nav/ul/li[11]/ul/li[1]/ul/li[2]/a")).click();
		Thread.sleep(2000);
		
		WebElement customform=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-project-integration/main/section/div[2]/tabset/div/tab[1]/div/div/div/div/tabset/div/tab[2]/div[2]/a[10]/div[2]/div"));
		customform.click();
		Thread.sleep(2000);

		
		driver.findElement(By.xpath("/html/body/modal-container/div/div/div/div[2]/div[3]/div[2]/button")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("/html/body/modal-container/div/div/form/div/div[2]/div/div/div[2]/button")).click();
	
	
	}

	public static void editForm() throws Exception{
		Properties obj = new Properties();

		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"/XPath.properties");
		
		obj.load(objfile);
		
		Thread.sleep(5000);
		
		System.setProperty("webdriver.chrome.driver", "/Users/alcodesmobility/Desktop/chromedriver");
		WebDriver driver = new ChromeDriver();
	
		String URL= obj.getProperty("URL");
		String UserName= obj.getProperty("UserName");
		String Password= obj.getProperty("Password");
		
		driver.manage().window().maximize();
		driver.get(URL);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("/html/body/app-root/app-layout/div/div/div[2]/app-sign-in/div/tabset/div/tab[1]/form/div/div[1]/input")).sendKeys(UserName);
		driver.findElement(By.xpath("/html/body/app-root/app-layout/div/div/div[2]/app-sign-in/div/tabset/div/tab[1]/form/div/div[2]/input")).sendKeys(Password);
		driver.findElement(By.tagName("Button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/aside/div/nav/ul/li[11]/a/div[1]/span[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/aside/div/nav/ul/li[11]/ul/li[1]/a")).click();
		Thread.sleep(4000);

		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/aside/div/nav/ul/li[11]/ul/li[1]/ul/li[2]/a")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-project-integration/main/section/div[2]/tabset/div/tab[1]/div/div/div/div/tabset/div/tab[2]/div[2]/a[1]/div[2]/div")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("/html/body/modal-container/div/div/div/div[2]/div[3]/div[2]/a")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/customform-app/main/section/div[2]/div/div[3]/button[2]")).click();
		
		
	}

	public static void formUser() throws Exception{
		
		Properties obj = new Properties();

		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"/XPath.properties");
		
		obj.load(objfile);
		
		Thread.sleep(5000);
		
		System.setProperty("webdriver.chrome.driver", "/Users/alcodesmobility/Desktop/chromedriver");
		WebDriver driver = new ChromeDriver();
	
		String URL= obj.getProperty("URL");
		String UserName= obj.getProperty("UserName");
		String Password= obj.getProperty("Password");
		
		driver.manage().window().maximize();
		driver.get(URL);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("/html/body/app-root/app-layout/div/div/div[2]/app-sign-in/div/tabset/div/tab[1]/form/div/div[1]/input")).sendKeys(UserName);
		driver.findElement(By.xpath("/html/body/app-root/app-layout/div/div/div[2]/app-sign-in/div/tabset/div/tab[1]/form/div/div[2]/input")).sendKeys(Password);
		driver.findElement(By.tagName("Button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/aside/div/nav/ul/li[11]/a/div[1]/span[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/aside/div/nav/ul/li[11]/ul/li[1]/a")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/aside/div/nav/ul/li[11]/ul/li[1]/ul/li[2]/a")).click();
		Thread.sleep(2000);
		
		//click on settings
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-project-integration/main/section/div[2]/tabset/div/tab[1]/div/div/div/div/tabset/div/tab[2]/div[2]/a[9]/div[1]")).click();
		Thread.sleep(10000);
	
		//dropdown menu
		
		WebElement dropdown=driver.findElement(By.xpath("/html/body/modal-container/div/div/div/div[2]/div[1]/ng-select"));
		
		dropdown.click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("/html/body/modal-container/div/div/div/div[2]/div[1]/ng-select/ng-dropdown-panel/div/div[2]/div[1]")).click();
		dropdown.click();
		Thread.sleep(1000);

		
		driver.findElement(By.xpath("/html/body/modal-container/div/div/div/div[2]/div[1]/ng-select/ng-dropdown-panel/div/div[2]/div[2]")).click();
		dropdown.click();
		Thread.sleep(1000);

		
		driver.findElement(By.xpath("/html/body/modal-container/div/div/div/div[2]/div[1]/ng-select/ng-dropdown-panel/div/div[2]/div[3]")).click();	

		driver.findElement(By.xpath("/html/body/modal-container/div/div/div/div[2]/div[2]/div[2]/button")).click();
	
	
	}

	public static void urlShortner(Properties obj,FileInputStream objfile, WebDriver driver,String URL,String UserName,String Password) throws Exception{
		
	//	Properties obj = new Properties();

	//	FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"/XPath.properties");
		
	//	obj.load(objfile);
		
		Thread.sleep(5000);
		
	//	System.setProperty("webdriver.chrome.driver", "/Users/alcodesmobility/Desktop/chromedriver");
	//	WebDriver driver = new ChromeDriver();
//	
//		String URL= obj.getProperty("URL");
//		String UserName= obj.getProperty("UserName");
//		String Password= obj.getProperty("Password");
		
		driver.manage().window().maximize();
		driver.get(URL);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("/html/body/app-root/app-layout/div/div/div[2]/app-sign-in/div/tabset/div/tab[1]/form/div/div[1]/input")).sendKeys(UserName);
		driver.findElement(By.xpath("/html/body/app-root/app-layout/div/div/div[2]/app-sign-in/div/tabset/div/tab[1]/form/div/div[2]/input")).sendKeys(Password);
		Thread.sleep(2000);

		driver.findElement(By.tagName("Button")).click();
		Thread.sleep(4000);
		
		driver.findElement(By.cssSelector("a[href='/admin/url-shortner']")).click();
		Thread.sleep(2000);

		//element to add short URL

		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/url-shortner-app/main/section/div[1]/div/div/div[2]/button")).click();
		Thread.sleep(2000);

		String shortURL=obj.getProperty("shortURL");
		
		driver.findElement(By.xpath("/html/body/modal-container/div/div/div[2]/form/div/div[1]/input")).sendKeys(shortURL);
		
		driver.findElement(By.xpath("/html/body/modal-container/div/div/div[2]/form/div/div[2]/button")).click();
		Thread.sleep(2000);

		
		//short url created close button
				driver.findElement(By.xpath("/html/body/modal-container/div/div/div[2]/form/div/div[3]/button")).click();
				
				//page count 
				driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/url-shortner-app/main/section/div[2]/div/div[2]/div/div/select")).sendKeys("100");
				
				
		
		
		
		//delete URL shortner
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/url-shortner-app/main/section/div[2]/div/div[1]/table/tbody/tr[2]/td[4]/a/img")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/modal-container/div/div/form/div/div[2]/div/div/div[2]/button")).click();
		
		
		
	}

	
	
}

