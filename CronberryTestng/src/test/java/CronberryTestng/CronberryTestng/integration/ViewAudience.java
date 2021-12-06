package CronberryTestng.CronberryTestng.integration;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class ViewAudience extends BaseClass{


//	public WebDriver driver;
//	public Properties obj;
//
//    
//	@BeforeClass(alwaysRun = true)
//	
//	public void login() throws Exception {
//		
//		System.setProperty("webdriver.chrome.driver", "/Users/alcodesmobility/Desktop/chromedriver");
//		
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		obj = new Properties();
//
//		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"/XPath.properties");
//		obj.load(objfile);
//		String URL= obj.getProperty("URL");
//		String UserName= obj.getProperty("UserName");
//		String Password= obj.getProperty("Password");
//		
//		driver.get(URL);
//		driver.findElement(By.xpath("/html/body/app-root/app-layout/div/div/div[2]/app-sign-in/div/tabset/div/tab[1]/form/div/div[1]/input")).sendKeys(UserName);
//		driver.findElement(By.xpath("/html/body/app-root/app-layout/div/div/div[2]/app-sign-in/div/tabset/div/tab[1]/form/div/div[2]/input")).sendKeys(Password);
//		driver.findElement(By.tagName("Button")).click();	
//		
//	}
//	
//	
//	@AfterClass(alwaysRun = true)
//	public void CloseBrowser() throws Exception{
//		
//		Thread.sleep(4000);
//		driver.close();
//		
//	}
	
	
	
	@Test(priority=3,description="View audience Open lead count verification of very first telecaller",groups= "ViewAudience")
	public void ViewAudienceReprt() throws Exception{
		
		String value=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table/tbody[2]/tr[1]/td[2]/a")).getText();
		
		String FinalValue="Total Count: "+value;
		
		System.out.println(FinalValue);
		
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table/tbody[2]/tr[1]/td[2]/a")).click();
		Thread.sleep(2000);
		String value1=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[4]/div/div/div/div/div[2]/div/span")).getText();
		System.out.println(value1);

		AssertJUnit.assertEquals(FinalValue, value1);
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[1]/div/div/div[1]/h4/a")).click();
		Thread.sleep(3000);

		
	}
	
	
	
	@Test(priority=1,description="View audience tab open",groups= "ViewAudience")
	public void ViewAudienceOpen() throws Exception{
	Thread.sleep(2000);
	driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/aside/div[2]/nav/ul/li[2]/a")).click();
	driver.findElement(By.cssSelector("a[href='/admin/audience/audience-report']")).click();
	Thread.sleep(2000);

    String headervalue=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[1]/div/div/div[1]/h4")).getText();
	
	AssertJUnit.assertTrue(headervalue.contains("Audience Report"));
	Thread.sleep(2000);
	
	}
	
	@Test(priority=2,description="View audience date picker",groups= "ViewAudience")
	public void ViewAudienceDatePicker() throws Exception{
	Thread.sleep(2000);
	driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[1]/div/div/div[2]/input")).click();
	Thread.sleep(2000);

	driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[1]/div/div/div[2]/ngx-daterangepicker-material/div/div[1]/ul/li[4]/button")).click();
	Thread.sleep(2000);

    String headervalue=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[1]/div/div/div[1]/h4")).getText();

	Thread.sleep(2000);

	WebElement table=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table"));
	List<WebElement> rows = table.findElements(By.tagName("tr"));
	System.out.println("no of rows in the first table"+rows.size());
	AssertJUnit.assertTrue(headervalue.contains("Audience Report"));

	
	}
	
	
	
	@Test(priority=4,description="View audience Total Open lead count verification of all the telecallers",groups= "ViewAudience")
	public void TotalLead() throws Exception{
		
		Thread.sleep(2000);

		WebElement table=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		System.out.println("no of rows in the first table"+rows.size());
		
		int numberOfRows=rows.size()-1;
		
		
		String value=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table/tbody[2]/tr["+numberOfRows+"]/td[2]/a")).getText();
		
		
		if (value.contains("0"))
		{
			driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table/tbody[2]/tr["+numberOfRows+"]/td[2]/a")).click();
			Thread.sleep(3000);
			String str=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[4]/div/div/div/div/div/div/table/tbody/tr[2]/td")).getText();
			driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[1]/div/div/div[1]/h4/a")).click();
			AssertJUnit.assertEquals("No Records Yet",str);
		}
		
		else {
		String FinalValue="Total Count: "+value;
		
		System.out.println(FinalValue);
		
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table/tbody[2]/tr["+numberOfRows+"]/td[2]/a")).click();
		Thread.sleep(3000);
	
		
		String value1=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[4]/div/div/div/div/div[2]/div/span")).getText();
		Thread.sleep(2000);

		
		System.out.println(value1);
		
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[1]/div/div/div[1]/h4/a")).click();

		Thread.sleep(2000);

		
		AssertJUnit.assertEquals(FinalValue, value1);
	
		Thread.sleep(2000);
		}
        
	
	}
	
	@Test(priority=5,description="View audience Total Follow Up lead count verification of all the telecallers",groups= "ViewAudience")
	public void TotalFollowUPLead() throws Exception{
		
		Thread.sleep(4000);
		WebElement table=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		System.out.println("no of rows in the first table"+rows.size());
		
		int numberOfRows=rows.size()-1;
		
		
		String value=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table/tbody[2]/tr["+numberOfRows+"]/td[3]/a")).getText();
		
		if (value.contains("0"))
		{
			driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table/tbody[2]/tr["+numberOfRows+"]/td[3]/a")).click();
			Thread.sleep(3000);
			String str=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[4]/div/div/div/div/div/div/table/tbody/tr[2]/td")).getText();
			driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[1]/div/div/div[1]/h4/a")).click();
			AssertJUnit.assertEquals("No Records Yet",str);
		}
		
		else {
		
		String FinalValue="Total Count: "+value;
		
		System.out.println(FinalValue);
		
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table/tbody[2]/tr["+numberOfRows+"]/td[3]/a")).click();
		Thread.sleep(3000);
	
		
		String value1=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[4]/div/div/div/div/div[2]/div/span")).getText();
		Thread.sleep(2000);

		
		System.out.println(value1);

		
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[1]/div/div/div[1]/h4/a")).click();
        
		Thread.sleep(2000);

		
		AssertJUnit.assertEquals(FinalValue, value1);
		
		}

	}
	
	
	@Test(priority=6,description="View audience Total Call Later lead count verification of all the telecallers",groups= "ViewAudience")
	public void TotalCallLaterLead() throws Exception{
		
		Thread.sleep(2000);

		WebElement table=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		System.out.println("no of rows in the first table"+rows.size());
		
		int numberOfRows=rows.size()-1;
		
		
		String value=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table/tbody[2]/tr["+numberOfRows+"]/td[4]/a")).getText();

		if (value.contains("0"))
		{
			driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table/tbody[2]/tr["+numberOfRows+"]/td[4]/a")).click();
			Thread.sleep(3000);
			String str=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[4]/div/div/div/div/div/div/table/tbody/tr[2]/td")).getText();
			driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[1]/div/div/div[1]/h4/a")).click();
			AssertJUnit.assertEquals("No Records Yet",str);
		}
		
		else {
		String FinalValue="Total Count: "+value;
		
		System.out.println(FinalValue);
		
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table/tbody[2]/tr["+numberOfRows+"]/td[4]/a")).click();
		Thread.sleep(3000);
	
		
		String value1=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[4]/div/div/div/div/div[2]/div/span")).getText();
		Thread.sleep(2000);

		
		System.out.println(value1);

		
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[1]/div/div/div[1]/h4/a")).click();
		
		Thread.sleep(2000);

		AssertJUnit.assertEquals(FinalValue, value1);
		}
	}
	
	@Test(priority=7,description="View audience Total Converted lead count verification of all the telecallers",groups= "ViewAudience")
	public void TotalConvertedLead() throws Exception{
		
		Thread.sleep(2000);

		WebElement table=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		System.out.println("no of rows in the first table"+rows.size());
		
		int numberOfRows=rows.size()-1;
		
		
		String value=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table/tbody[2]/tr["+numberOfRows+"]/td[5]/a")).getText();
		
		if (value.contains("0"))
		{
			driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table/tbody[2]/tr["+numberOfRows+"]/td[5]/a")).click();
			Thread.sleep(3000);
			String str=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[4]/div/div/div/div/div/div/table/tbody/tr[2]/td")).getText();
			driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[1]/div/div/div[1]/h4/a")).click();
			AssertJUnit.assertEquals("No Records Yet",str);
		}
		
		else {
		
		String FinalValue="Total Count: "+value;
		
		System.out.println(FinalValue);
		
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table/tbody[2]/tr["+numberOfRows+"]/td[5]/a")).click();
		Thread.sleep(3000);
	
		
		String value1=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[4]/div/div/div/div/div[2]/div/span")).getText();
		Thread.sleep(2000);

		
		System.out.println(value1);

		
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[1]/div/div/div[1]/h4/a")).click();
		Thread.sleep(2000);

		AssertJUnit.assertEquals(FinalValue, value1);
		}
	}
	
	@Test(priority=8,description="View audience Total Interested lead count verification of all the telecallers",groups= "ViewAudience")
	public void TotalInterestedLead() throws Exception{
		
		Thread.sleep(2000);

		WebElement table=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		System.out.println("no of rows in the first table"+rows.size());
		
		int numberOfRows=rows.size()-1;
		
		
		String value=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table/tbody[2]/tr["+numberOfRows+"]/td[6]/a")).getText();
		
		if (value.contains("0"))
		{
			driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table/tbody[2]/tr["+numberOfRows+"]/td[6]/a")).click();
			Thread.sleep(3000);
			String str=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[4]/div/div/div/div/div/div/table/tbody/tr[2]/td")).getText();
			driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[1]/div/div/div[1]/h4/a")).click();
			AssertJUnit.assertEquals("No Records Yet",str);
		}
		
		else{
		String FinalValue="Total Count: "+value;
		
		System.out.println(FinalValue);
		
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table/tbody[2]/tr["+numberOfRows+"]/td[6]/a")).click();
		Thread.sleep(3000);
	
		
		String value1=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[4]/div/div/div/div/div[2]/div/span")).getText();
		Thread.sleep(2000);

		
		System.out.println(value1);

		
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[1]/div/div/div[1]/h4/a")).click();
		
		Thread.sleep(2000);

		AssertJUnit.assertEquals(FinalValue, value1);
		}
	}
	
	@Test(priority=9,description="View audience Total Wrong contact lead count verification of all the telecallers",groups= "ViewAudience")
	public void TotalwrongContactLead() throws Exception{
		
		Thread.sleep(2000);

		WebElement table=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		System.out.println("no of rows in the first table"+rows.size());
		
		int numberOfRows=rows.size()-1;
		
		
		String value=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table/tbody[2]/tr["+numberOfRows+"]/td[7]/a")).getText();
		
		if (value.contains("0"))
		{
			driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table/tbody[2]/tr["+numberOfRows+"]/td[7]/a")).click();
			Thread.sleep(3000);
			String str=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[4]/div/div/div/div/div/div/table/tbody/tr[2]/td")).getText();
			driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[1]/div/div/div[1]/h4/a")).click();
			AssertJUnit.assertEquals("No Records Yet",str);
		}
		else 
		{
		String FinalValue="Total Count: "+value;
		
		System.out.println(FinalValue);
		
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table/tbody[2]/tr["+numberOfRows+"]/td[7]/a")).click();
		Thread.sleep(3000);
	
		
		String value1=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[4]/div/div/div/div/div[2]/div/span")).getText();
		Thread.sleep(2000);

		System.out.println(value1);

		
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[1]/div/div/div[1]/h4/a")).click();
	
		Thread.sleep(2000);

		
		AssertJUnit.assertEquals(FinalValue, value1);
							
		
		}
	}
	
	
  


}
