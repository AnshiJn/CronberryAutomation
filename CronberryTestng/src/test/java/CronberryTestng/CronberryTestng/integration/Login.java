package CronberryTestng.CronberryTestng.integration;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import au.com.bytecode.opencsv.CSVReader;

public class Login {

	
	public static WebDriver driver;
	public static Properties obj;
	public static Object[][] testdata;
	public static	String[] getData; 
	public static	String[] name= new String[15];
	public static	String[] password=new String[15]; 
	
	
	@DataProvider
	
	public static Object[][] readFile() throws Exception {

	String path = "/Users/alcodesmobility/eclipse-workspace/CronberryTestng/testData/testDataLogin.csv";
	
	CSVReader reader = new CSVReader(new FileReader(
			path));

	List<String[]> list = reader.readAll();
	
	
	int i, j;

	for (i = 0; i <= list.size()-1; i++) {

		System.out.println(list.size());
		for (j = 1; j <= 2; j++) {
			getData = list.get(i);
			
			
		}

	name[i]=getData[j-2];
	password[i]	=getData[j-1]; 	
		
	System.out.print(testdata);
	
	}

	
	
	testdata= new Object[][]
			{
		{name[1],password[1]},

		{name[2],password[2]},
		
		{name[3],password[3]},
		
		{name[4],password[4]},
		
		{name[5],password[5]},
		{name[6],password[6]},
		
		{name[7],password[7]},
			};
			
	
	return testdata;

}
	

	
	@BeforeClass
	
	public void login() throws Exception {
		
	
		System.setProperty("webdriver.chrome.driver", "/Users/alcodesmobility/Desktop/chromedriver");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.print("chrome broswer running");

		obj = new Properties();

		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"/XPath.properties");
		obj.load(objfile);
		String URL= obj.getProperty("URL");
	
		
		driver.get(URL);
				
		
	}
	
	@Test(dataProvider="readFile")
	
	public void loginTest(String username, String password) throws Exception {

		SoftAssert softAssertion= new SoftAssert();
		driver.findElement(By.tagName("Button")).click();			
		driver.findElement(By.xpath("/html/body/div/div")).getText();
		Thread.sleep(8000);
		
		driver.findElement(By.xpath("/html/body/app-root/app-layout/div/div/div[2]/app-sign-in/div/tabset/div/tab[1]/form/div/div[1]/input")).sendKeys(username);
		driver.findElement(By.xpath("/html/body/app-root/app-layout/div/div/div[2]/app-sign-in/div/tabset/div/tab[1]/form/div/div[2]/input")).sendKeys(password);
		driver.findElement(By.tagName("Button")).click();			
		String alert=driver.findElement(By.xpath("/html/body/div/div")).getText();
		
		
		String[] expectedAlert = {
                "Please",
                "Error"
        };
    
    
    
		softAssertion.assertEquals(alert, expectedAlert);
		
	
		
		
		driver.findElement(By.xpath("/html/body/app-root/app-layout/div/div/div[2]/app-sign-in/div/tabset/div/tab[1]/form/div/div[1]/input")).clear();
		driver.findElement(By.xpath("/html/body/app-root/app-layout/div/div/div[2]/app-sign-in/div/tabset/div/tab[1]/form/div/div[2]/input")).clear();
		
		
		
	}
	
	
	public void tearDown()
	
	{
		
		driver.close();
	}
	
}
