package CronberryTestng.CronberryTestng.integration;

import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CustomForm extends BaseClass {

	SoftAssert softassert= new SoftAssert();

	
	@Test(priority=1,description="Custom form navigation",groups= {"custom"} )
	public void customFrom() throws Exception {
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		
		String customForm=obj.getProperty("customForm");
		
		driver.findElement(By.xpath(customForm)).click();
		Thread.sleep(2000);

		
		
		String customFormSp=obj.getProperty("customFormSp");

		driver.findElement(By.xpath(customFormSp)).click();
		Thread.sleep(2000);

		
		
		String customFormOp=obj.getProperty("customFormOp");
		driver.findElement(By.xpath(customFormOp)).click();
		Thread.sleep(2000);	

		
		String customFormh=obj.getProperty("customFormh");
		
		
		String cfH=	driver.findElement(By.xpath(customFormh)).getText();
		
		System.out.println("this is custom form "+cfH);
		
		softassert.assertEquals("Forms", cfH);
	    softassert.assertAll();

	}
	
	@Test(priority=2,description="Plugin status check",groups= {"custom"})
	public void CustomFormPlugin() throws Exception
	{
		
	Thread.sleep(2000);
	Boolean value =driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-project-integration/main/section/div[2]/tabset/div/tab[1]/div/div/div/div/tabset/div/tab[2]/div[3]/label")).isEnabled();
	System.out.print(value);
	softassert.assertTrue(value);	
    softassert.assertAll();

	}
	
	
	@Test(priority=3,description="Lead Updation status check",groups= {"custom"})
	public void CustomFormLeadUpdation() throws Exception
	{
		
	Thread.sleep(2000);
	Boolean value=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-project-integration/main/section/div[2]/tabset/div/tab[1]/div/div/div/div/tabset/div/tab[2]/div[4]/label")).isEnabled();
	
	System.out.print(value);
	softassert.assertTrue(value);	
    softassert.assertAll();

	}
	
	@Test(priority=4,description="Create custom form page",groups= {"custom"})
	public void OpenCustomFrom() throws Exception{
		
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("a[href='/admin/custom-form']")).click();
		String value=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/customform-app/main/section/div[1]/div/div/div[1]/h4")).getText();
		softassert.assertEquals("Create Form", value);
		Thread.sleep(3000);
	    softassert.assertAll();

	}
	
	
	@Test(priority=5,description="Create new custom form page",groups= {"custom"})
	public void CreateCustomForm() throws Exception{
		
		Thread.sleep(2000);
		WebElement textbox=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/customform-app/main/section/div[2]/div/div[1]/div[1]/div[1]/tabset/div/tab[1]/div/ul/li[1]/span"));
		
		WebElement drop=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/customform-app/main/section/div[2]/div/div[1]/div[2]/div/section"));
  //empty field validation
		String Proceed=obj.getProperty("Proceed");
		driver.findElement(By.xpath(Proceed)).click();
		String message1=driver.findElement(By.xpath("/html/body/div/div")).getText();
		System.out.println(message1);
		
		Actions builder= new Actions(driver);
		Thread.sleep(2000);
		Robot r=new Robot();
		r.mouseMove(699,370);
		builder.moveByOffset(699,370).perform();
		builder.click();
		builder.clickAndHold(textbox).build();
		Thread.sleep(2000);

		builder.dragAndDropBy(textbox,665,366);
		Thread.sleep(2000);

		builder.release(drop).build().perform();
		Thread.sleep(3000);

		WebElement email=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/customform-app/main/section/div[2]/div/div[1]/div[1]/div[1]/tabset/div/tab[1]/div/ul/li[2]/span"));
		builder.clickAndHold(email).build();
		Thread.sleep(2000);
		
		builder.dragAndDropBy(email,665,366);
		r.mouseMove(665,366);
		
		Thread.sleep(1000);

		builder.release(drop).build().perform();
		String formName=obj.getProperty("formName");
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/customform-app/main/section/div[2]/div/div[1]/div[2]/div/section/div[1]/div/div[1]/i[2]")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/customform-app/main/section/div[2]/div/div[1]/div[2]/div/section/div[1]/div[2]/div[2]/input")).clear();
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/customform-app/main/section/div[2]/div/div[1]/div[2]/div/section/div[1]/div[2]/div[2]/input")).sendKeys("Enter your Name");
		driver.findElement(By.id("name-")).sendKeys("Name");
		Thread.sleep(1000);

		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/customform-app/main/section/div[1]/div/div/div[2]/input")).sendKeys(formName);
		Thread.sleep(1000);

		Thread.sleep(1000);

		driver.findElement(By.xpath(Proceed)).click();
		Thread.sleep(2000);

		String ToastMessageBar=obj.getProperty("ToastMessageBar");
		
		String message=driver.findElement(By.xpath(ToastMessageBar)).getText();
		
		System.out.println(message);
		
		softassert.assertTrue(message.contains("Success"));
	    softassert.assertAll();
	    
	    

		}
	
	
	@Test(priority=6,description="Edit custom form page",groups= {"custom"})
	public void EditCustomFrom() throws Exception{
		
		Thread.sleep(1000);
		String formName=obj.getProperty("formName");
		
		driver.findElement(By.xpath("//*[contains (text(),"+formName+")]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[contains (text(),'Edit')]")).click();
		
		
		
		driver.findElement(By.xpath("/html/body/modal-container/div/div/div/div[1]/button/span")).click();
		Thread.sleep(2000);
		String PageHeader=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/customform-app/main/section/div[2]/div/div[1]/div[1]/div[1]/tabset/ul/li[1]/a/span")).getText();
		
		
		softassert.assertTrue(PageHeader.contains("Fields"));	
		Thread.sleep(4000);
	    softassert.assertAll();
	    
	    
	    
	}
	
	
	
	@Test(priority=7,description="Update custom form page",groups= {"custom"})
	public void UpdateCustomForm() throws Exception{
		
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/customform-app/main/section/div[2]/div/div[1]/div[1]/div[1]/tabset/ul/li[2]/a/span")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/customform-app/main/section/div[2]/div/div[1]/div[1]/div[1]/tabset/div/tab[2]/div/div[6]/div/input")).sendKeys("4");
	
		Thread.sleep(1000);

		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/customform-app/main/section/div[2]/div/div[1]/div[1]/div[2]/button[2]")).click();
		Thread.sleep(1000);
		
		String ToastMessageBar=obj.getProperty("ToastMessageBar");
		
		String message=driver.findElement(By.xpath(ToastMessageBar)).getText();
		
		
		softassert.assertTrue(message.contains("Success"));
	    softassert.assertAll();


	}
	
	@Test(priority=8,description="Copy Short URl of custom form",groups= {"custom"})
	public void ShortCustomForm() throws Exception{
	
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[contains (text(),formName)]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[contains (text(),'Get Short URL')]")).click();

		Thread.sleep(2000);
		
		String ToastMessageBar=obj.getProperty("ToastMessageBar");
		String message=driver.findElement(By.xpath(ToastMessageBar)).getText();
		System.out.println(message);
		Thread.sleep(2000);

		softassert.assertTrue(message.contains("Copied to clipboard"));
		driver.findElement(By.xpath("/html/body/modal-container/div/div/div/div[1]/button/span")).click();
	    softassert.assertAll();

	}
	
	
	
	
	

	@Test(priority=9,description="Delete custom form page",groups= {"custom"})
	public void DeleteCustomFrom() throws Exception{
		
		Thread.sleep(3000);
		String formName=obj.getProperty("formName");
		
		driver.findElement(By.xpath("//*[contains (text(),"+formName+")]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("/html/body/modal-container/div/div/div/div[2]/div[3]/div[2]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/modal-container/div/div/form/div/div[2]/div/div/div[2]/button")).click();
		
		Thread.sleep(1000);

		String ToastMessageBar=obj.getProperty("ToastMessageBar");
		String message=driver.findElement(By.xpath(ToastMessageBar)).getText();
		
		
		softassert.assertTrue(message.contains("Success"));
		Thread.sleep(3000);
	    softassert.assertAll();

	   
	}
	
	
	@Test(priority=10,description="Custom form page link copy to clipboard",groups= "custom")
	public void LinkCopyCustomFrom() throws Exception{
		
		
		Thread.sleep(2000);
		String formName=obj.getProperty("formName");
		
		driver.findElement(By.xpath("//*[contains (text(),"+formName+")]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("/html/body/modal-container/div/div/div/div[2]/div[1]/div/span")).click();
		Thread.sleep(1500);
		
		String ToastMessageBar=obj.getProperty("ToastMessageBar");
		String message=driver.findElement(By.xpath(ToastMessageBar)).getText();
		
		Thread.sleep(1000);

		softassert.assertTrue(message.contains("Copied to clipboard"));

		driver.findElement(By.xpath("/html/body/modal-container/div/div/div/div[1]/button")).click();
		
		Thread.sleep(2000);
	    softassert.assertAll();

	}
	
	
//	@Test(priority=1,description="User logged in successfully",groups= "Dashboard")
//	public void Dashboard() throws Exception{
//		
//		Thread.sleep(2000);
//		String value=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/aside/div[2]/nav/ul/li[1]/a/span[2]")).getText();
//		System.out.print(value);
//		AssertJUnit.assertTrue(value.contains("Dashboard"));
//	}
//	
//	@Test(priority=2,description="Email stats opened successfully",groups= "Dashboard")
//	public void DashboardEmail() throws Exception{
//		
//		SoftAssert softassert= new SoftAssert();
//		
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/dashboard-app/main/section/div/div[2]/div[2]/div[1]/div/apx-chart/div[1]/div")).click();
//		Thread.sleep(2000);
//
//		String value= driver.findElement(By.xpath("/html/body/modal-container/div/div/div[1]/h4")).getText();
//		Thread.sleep(2000);
//		String expectedValue="Email Stats";
//		System.out.print(value);
//		AssertJUnit.assertEquals(value, expectedValue);
//		driver.findElement(By.xpath("/html/body/modal-container/div/div/div[1]/button")).click();
//		softassert.assertAll();
//	}
//	
//	
//	@Test(priority=3,description="SMS stats opened successfully",groups= "Dashboard")
//	public void DashboardSMSl() throws Exception{
//		
//		SoftAssert softassert= new SoftAssert();
//		
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/dashboard-app/main/section/div/div[2]/div[2]/div[2]/div/apx-chart/div[1]/div")).click();
//		Thread.sleep(2000);
//
//		String value= driver.findElement(By.xpath("/html/body/modal-container/div/div/div[1]/h4")).getText();
//		Thread.sleep(2000);
//		String expectedValue="Sms Stats";
//		System.out.print(value);
//		AssertJUnit.assertEquals(value, expectedValue);
//		driver.findElement(By.xpath("/html/body/modal-container/div/div/div[1]/button")).click();
//		softassert.assertAll();
//	}
//	
//	@Test(priority=4,description="Push stats opened successfully",groups= "Dashboard")
//	public void DashboardPush() throws Exception{
//		
//		SoftAssert softassert= new SoftAssert();
//		
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/dashboard-app/main/section/div/div[2]/div[2]/div[3]/div/apx-chart/div[1]/div")).click();
//		Thread.sleep(2000);
//
//		String value= driver.findElement(By.xpath("/html/body/modal-container/div/div/div[1]/h4")).getText();
//		Thread.sleep(2000);
//		String expectedValue="Push Stats";
//		System.out.print(value);
//		AssertJUnit.assertEquals(value, expectedValue);
//		driver.findElement(By.xpath("/html/body/modal-container/div/div/div[1]/button")).click();
//		softassert.assertAll();
//	}
//	
//	@Test(priority=5,description="In App stats opened successfully",groups= "Dashboard")
//	public void DashboardInApp() throws Exception{
//		
//		SoftAssert softassert= new SoftAssert();
//		
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/dashboard-app/main/section/div/div[2]/div[2]/div[4]/div/apx-chart/div[1]/div")).click();
//		Thread.sleep(2000);
//
//		String value= driver.findElement(By.xpath("/html/body/modal-container/div/div/div[1]/h4")).getText();
//		Thread.sleep(2000);
//		String expectedValue="InApp Stats";
//		System.out.print(value);
//		AssertJUnit.assertEquals(value, expectedValue);
//		driver.findElement(By.xpath("/html/body/modal-container/div/div/div[1]/button")).click();
//		softassert.assertAll();
//	}
//	
//	
//	@Test(priority=3,description="View audience Open lead count verification of very first telecaller",groups= "ViewAudience")
//	public void ViewAudienceReprt() throws Exception{
//		
//		String value=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table/tbody[2]/tr[1]/td[2]/a")).getText();
//		
//		String FinalValue="Total Count: "+value;
//		
//		System.out.println(FinalValue);
//		
//		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table/tbody[2]/tr[1]/td[2]/a")).click();
//		Thread.sleep(2000);
//		String value1=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[4]/div/div/div/div/div[2]/div/span")).getText();
//		System.out.println(value1);
//
//		AssertJUnit.assertEquals(FinalValue, value1);
//		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[1]/div/div/div[1]/h4/a")).click();
//		Thread.sleep(3000);
//
//		
//	}
//	
//	
//	
//	@Test(priority=1,description="View audience tab open",groups= "ViewAudience")
//	public void ViewAudience() throws Exception{
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/aside/div[2]/nav/ul/li[2]/a")).click();
//	driver.findElement(By.cssSelector("a[href='/admin/audience-report']")).click();
//	Thread.sleep(2000);
//
//    String headervalue=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[1]/div/div/div[1]/h4")).getText();
//	
//	AssertJUnit.assertTrue(headervalue.contains("Audience Report"));
//	Thread.sleep(2000);
//	
//	}
//	
//	@Test(priority=2,description="View audience date picker",groups= "ViewAudience")
//	public void ViewAudienceDatePicker() throws Exception{
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[1]/div/div/div[2]/input")).click();
//	Thread.sleep(2000);
//
//	driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[1]/div/div/div[2]/ngx-daterangepicker-material/div/div[1]/ul/li[4]/button")).click();
//	Thread.sleep(2000);
//
//    String headervalue=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[1]/div/div/div[1]/h4")).getText();
//
//	Thread.sleep(2000);
//
//	WebElement table=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table"));
//	List<WebElement> rows = table.findElements(By.tagName("tr"));
//	System.out.println("no of rows in the first table"+rows.size());
//	AssertJUnit.assertTrue(headervalue.contains("Audience Report"));
//
//	
//	}
//	
//	
//	
//	@Test(priority=4,description="View audience Total Open lead count verification of all the telecallers",groups= "ViewAudience")
//	public void TotalLead() throws Exception{
//		
//		Thread.sleep(2000);
//
//		WebElement table=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table"));
//		List<WebElement> rows = table.findElements(By.tagName("tr"));
//		System.out.println("no of rows in the first table"+rows.size());
//		
//		int numberOfRows=rows.size()-1;
//		
//		
//		String value=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table/tbody[2]/tr["+numberOfRows+"]/td[2]/a")).getText();
//		
//		
//		if (value.contains("0"))
//		{
//			driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table/tbody[2]/tr["+numberOfRows+"]/td[2]/a")).click();
//			Thread.sleep(3000);
//			String str=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[4]/div/div/div/div/div/div/table/tbody/tr[2]/td")).getText();
//			driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[1]/div/div/div[1]/h4/a")).click();
//			AssertJUnit.assertEquals("No Records Yet",str);
//		}
//		
//		else {
//		String FinalValue="Total Count: "+value;
//		
//		System.out.println(FinalValue);
//		
//		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table/tbody[2]/tr["+numberOfRows+"]/td[2]/a")).click();
//		Thread.sleep(3000);
//	
//		
//		String value1=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[4]/div/div/div/div/div[2]/div/span")).getText();
//		Thread.sleep(2000);
//
//		
//		System.out.println(value1);
//		
//		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[1]/div/div/div[1]/h4/a")).click();
//
//		AssertJUnit.assertEquals(FinalValue, value1);
//	
//		Thread.sleep(2000);
//		}
//        
//	
//	}
//	
//	@Test(priority=5,description="View audience Total Follow Up lead count verification of all the telecallers",groups= "ViewAudience")
//	public void TotalFollowUPLead() throws Exception{
//		
//		Thread.sleep(4000);
//		WebElement table=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table"));
//		List<WebElement> rows = table.findElements(By.tagName("tr"));
//		System.out.println("no of rows in the first table"+rows.size());
//		
//		int numberOfRows=rows.size()-1;
//		
//		
//		String value=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table/tbody[2]/tr["+numberOfRows+"]/td[3]/a")).getText();
//		
//		if (value.contains("0"))
//		{
//			driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table/tbody[2]/tr["+numberOfRows+"]/td[3]/a")).click();
//			Thread.sleep(3000);
//			String str=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[4]/div/div/div/div/div/div/table/tbody/tr[2]/td")).getText();
//			driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[1]/div/div/div[1]/h4/a")).click();
//			AssertJUnit.assertEquals("No Records Yet",str);
//		}
//		
//		else {
//		
//		String FinalValue="Total Count: "+value;
//		
//		System.out.println(FinalValue);
//		
//		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table/tbody[2]/tr["+numberOfRows+"]/td[3]/a")).click();
//		Thread.sleep(3000);
//	
//		
//		String value1=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[4]/div/div/div/div/div[2]/div/span")).getText();
//		Thread.sleep(2000);
//
//		
//		System.out.println(value1);
//
//		
//		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[1]/div/div/div[1]/h4/a")).click();
//        
//		AssertJUnit.assertEquals(FinalValue, value1);
//		
//		}
//
//	}
//	
//	
//	@Test(priority=6,description="View audience Total Call Later lead count verification of all the telecallers",groups= "ViewAudience")
//	public void TotalCallLaterLead() throws Exception{
//		
//		Thread.sleep(2000);
//
//		WebElement table=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table"));
//		List<WebElement> rows = table.findElements(By.tagName("tr"));
//		System.out.println("no of rows in the first table"+rows.size());
//		
//		int numberOfRows=rows.size()-1;
//		
//		
//		String value=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table/tbody[2]/tr["+numberOfRows+"]/td[4]/a")).getText();
//
//		if (value.contains("0"))
//		{
//			driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table/tbody[2]/tr["+numberOfRows+"]/td[4]/a")).click();
//			Thread.sleep(3000);
//			String str=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[4]/div/div/div/div/div/div/table/tbody/tr[2]/td")).getText();
//			driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[1]/div/div/div[1]/h4/a")).click();
//			AssertJUnit.assertEquals("No Records Yet",str);
//		}
//		
//		else {
//		String FinalValue="Total Count: "+value;
//		
//		System.out.println(FinalValue);
//		
//		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table/tbody[2]/tr["+numberOfRows+"]/td[4]/a")).click();
//		Thread.sleep(3000);
//	
//		
//		String value1=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[4]/div/div/div/div/div[2]/div/span")).getText();
//		Thread.sleep(2000);
//
//		
//		System.out.println(value1);
//
//		
//		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[1]/div/div/div[1]/h4/a")).click();
//		AssertJUnit.assertEquals(FinalValue, value1);
//		}
//	}
//	
//	@Test(priority=7,description="View audience Total Converted lead count verification of all the telecallers",groups= "ViewAudience")
//	public void TotalConvertedLead() throws Exception{
//		
//		Thread.sleep(2000);
//
//		WebElement table=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table"));
//		List<WebElement> rows = table.findElements(By.tagName("tr"));
//		System.out.println("no of rows in the first table"+rows.size());
//		
//		int numberOfRows=rows.size()-1;
//		
//		
//		String value=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table/tbody[2]/tr["+numberOfRows+"]/td[5]/a")).getText();
//		
//		if (value.contains("0"))
//		{
//			driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table/tbody[2]/tr["+numberOfRows+"]/td[5]/a")).click();
//			Thread.sleep(3000);
//			String str=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[4]/div/div/div/div/div/div/table/tbody/tr[2]/td")).getText();
//			driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[1]/div/div/div[1]/h4/a")).click();
//			AssertJUnit.assertEquals("No Records Yet",str);
//		}
//		
//		else {
//		
//		String FinalValue="Total Count: "+value;
//		
//		System.out.println(FinalValue);
//		
//		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table/tbody[2]/tr["+numberOfRows+"]/td[5]/a")).click();
//		Thread.sleep(3000);
//	
//		
//		String value1=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[4]/div/div/div/div/div[2]/div/span")).getText();
//		Thread.sleep(2000);
//
//		
//		System.out.println(value1);
//
//		
//		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[1]/div/div/div[1]/h4/a")).click();
//		AssertJUnit.assertEquals(FinalValue, value1);
//		}
//	}
//	
//	@Test(priority=8,description="View audience Total Interested lead count verification of all the telecallers",groups= "ViewAudience")
//	public void TotalInterestedLead() throws Exception{
//		
//		Thread.sleep(2000);
//
//		WebElement table=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table"));
//		List<WebElement> rows = table.findElements(By.tagName("tr"));
//		System.out.println("no of rows in the first table"+rows.size());
//		
//		int numberOfRows=rows.size()-1;
//		
//		
//		String value=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table/tbody[2]/tr["+numberOfRows+"]/td[6]/a")).getText();
//		
//		if (value.contains("0"))
//		{
//			driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table/tbody[2]/tr["+numberOfRows+"]/td[6]/a")).click();
//			Thread.sleep(3000);
//			String str=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[4]/div/div/div/div/div/div/table/tbody/tr[2]/td")).getText();
//			driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[1]/div/div/div[1]/h4/a")).click();
//			AssertJUnit.assertEquals("No Records Yet",str);
//		}
//		
//		else{
//		String FinalValue="Total Count: "+value;
//		
//		System.out.println(FinalValue);
//		
//		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table/tbody[2]/tr["+numberOfRows+"]/td[6]/a")).click();
//		Thread.sleep(3000);
//	
//		
//		String value1=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[4]/div/div/div/div/div[2]/div/span")).getText();
//		Thread.sleep(2000);
//
//		
//		System.out.println(value1);
//
//		
//		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[1]/div/div/div[1]/h4/a")).click();
//		AssertJUnit.assertEquals(FinalValue, value1);
//		}
//	}
//	
//	@Test(priority=9,description="View audience Total Wrong contact lead count verification of all the telecallers",groups= "ViewAudience")
//	public void TotalwrongContactLead() throws Exception{
//		
//		Thread.sleep(2000);
//
//		WebElement table=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table"));
//		List<WebElement> rows = table.findElements(By.tagName("tr"));
//		System.out.println("no of rows in the first table"+rows.size());
//		
//		int numberOfRows=rows.size()-1;
//		
//		
//		String value=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table/tbody[2]/tr["+numberOfRows+"]/td[7]/a")).getText();
//		
//		if (value.contains("0"))
//		{
//			driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table/tbody[2]/tr["+numberOfRows+"]/td[7]/a")).click();
//			Thread.sleep(3000);
//			String str=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[4]/div/div/div/div/div/div/table/tbody/tr[2]/td")).getText();
//			driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[1]/div/div/div[1]/h4/a")).click();
//			AssertJUnit.assertEquals("No Records Yet",str);
//		}
//		else 
//		{
//		String FinalValue="Total Count: "+value;
//		
//		System.out.println(FinalValue);
//		
//		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-audience-report/main/section/div[2]/div/div[1]/div/div/table/tbody[2]/tr["+numberOfRows+"]/td[7]/a")).click();
//		Thread.sleep(3000);
//	
//		
//		String value1=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[4]/div/div/div/div/div[2]/div/span")).getText();
//		Thread.sleep(2000);
//
//		System.out.println(value1);
//
//		
//		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-view-audience/main/section/div[1]/div/div/div[1]/h4/a")).click();
//	
//		AssertJUnit.assertEquals(FinalValue, value1);
//							
//		
//		}
//	}
//	
	
  
	
	
	
}
