package CronberryTestng.CronberryTestng.integration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Report extends BaseClass{

	SoftAssert softassert = new SoftAssert();


	@Test(priority = 1, description = "open report tab ")

		void openReport() throws Exception {
		
	Thread.sleep(1000);	
	String ReportTab=obj.getProperty("ReportTab");
	driver.findElement(By.xpath(ReportTab)).click();
	Thread.sleep(3000);	


	String ReportPageHeading=obj.getProperty("ReportPageHeading");
	
	String pageHeading=driver.findElement(By.xpath(ReportPageHeading)).getText();
	
	softassert.assertEquals("Reports", pageHeading);
    softassert.assertAll();

	
	}
	
	
	@Test(priority = 2, description = "reports functionalities ")

	void report() throws Exception {
	
	Thread.sleep(2000);	
	String 	ReportAudience=obj.getProperty("ReportAudience");
	driver.findElement(By.xpath(ReportAudience)).click();
	Thread.sleep(2000);	

	String ReportModel=obj.getProperty("ReportModell");
	
	Boolean status=driver.findElement(By.xpath(ReportModel)).isDisplayed();

	softassert.assertTrue(status);
	
	Thread.sleep(2000);	

	
	String 	CloseModel=obj.getProperty("CloseModel");
	driver.findElement(By.xpath(CloseModel)).click();
    softassert.assertAll();

	

	}
	
	}

