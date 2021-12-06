package CronberryTestng.CronberryTestng.integration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Analysis extends BaseClass{

	
	
	SoftAssert softassert = new SoftAssert();
	Boolean status;

	
	@Test(priority = 1, description = "open analysis tab ")
	@Severity(SeverityLevel.BLOCKER)
	@Description("This test case will open Anaylsis Page")
		void openAnalysis() throws Exception {
		
	Thread.sleep(1000);	
	String Audience=obj.getProperty("Audience");
	driver.findElement(By.xpath(Audience)).click();
	Thread.sleep(1000);	
	String Analysis=obj.getProperty("Analysis");
	driver.findElement(By.xpath(Analysis)).click();
	Thread.sleep(1000);	

	String PageHeading=obj.getProperty("PageHeading");
	
	WebDriverWait wait = new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageHeading)));
	
	
	status=driver.findElement(By.xpath(PageHeading)).isDisplayed();
	
	softassert.assertTrue(status);
	
    softassert.assertAll();

	
	}
	
	
	
	@Test(priority = 2, description = "add analysis report ")

	void addReport() throws Exception {
	
		
		String AddReport=obj.getProperty("AddReport");
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AddReport)));
		
			
	
	driver.findElement(By.xpath(AddReport)).click();
	Thread.sleep(2000);	
	
	

	
	String ReportModel=obj.getProperty("ReportModel");
	
	status=driver.findElement(By.xpath(ReportModel)).isDisplayed();
	
	softassert.assertTrue(status);
	
	String RName=obj.getProperty("RName");

	String ReportName=obj.getProperty("ReportName");
	driver.findElement(By.xpath(ReportName)).sendKeys(RName);
	Thread.sleep(1000);	
	
	String Selectsource=obj.getProperty("Selectsource");
	driver.findElement(By.xpath(Selectsource)).click();
	String SourceName=obj.getProperty("SourceName");
	driver.findElement(By.xpath(SourceName)).click();
	Thread.sleep(1000);	


	
	
	String SourceAttributes=obj.getProperty("SourceAttributes");
	driver.findElement(By.xpath(SourceAttributes)).click();
	String SelectAttri=obj.getProperty("SelectAttri");
	driver.findElement(By.xpath(SelectAttri)).click();
	Thread.sleep(1000);	
	
	
	
	
	String DateRange=obj.getProperty("DateRange");
	driver.findElement(By.xpath(DateRange)).click();
	String SelectDateRange=obj.getProperty("SelectDateRange");
	driver.findElement(By.xpath(SelectDateRange)).click();
	Thread.sleep(1000);	
	
	
	
	String ReportSubmit=obj.getProperty("ReportSubmit");
	driver.findElement(By.xpath(ReportSubmit)).click();
	
	String ToastMessage=obj.getProperty("ToastMessage");
 	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ToastMessage)));

 	status=driver.findElement(By.xpath(ToastMessage)).isDisplayed();
 	
 	
 	softassert.assertTrue(status);
	
 	
 	
 	
 	String ReportChart=obj.getProperty("ReportChart");

 	status=driver.findElement(By.xpath(ReportChart)).isDisplayed();
 	
 	
 	softassert.assertTrue(status);
    softassert.assertAll();

 	
	
	
}
	
	
	
	@Test(priority = 3, description = "chart edit ")

	void chartEdit() throws Exception {
	WebDriverWait wait = new WebDriverWait(driver,30);

	Thread.sleep(1000);	
	String ChartEdit=obj.getProperty("ChartEdit");
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ChartEdit)));

	
	driver.findElement(By.xpath(ChartEdit)).click();
	Thread.sleep(3000);	
	
	String ReportSubmit=obj.getProperty("ReportSubmit");
	driver.findElement(By.xpath(ReportSubmit)).click();
	
	String ToastMessage=obj.getProperty("ToastMessage");
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ToastMessage)));

 	status=driver.findElement(By.xpath(ToastMessage)).isDisplayed();
 	
 	
 	softassert.assertTrue(status);
    softassert.assertAll();

	
	}
	
	
	
 	@Test(priority = 4, description = "chart delete ")

	void chartDelete() throws Exception {
	
	Thread.sleep(1000);	
	String DeleteChart=obj.getProperty("DeleteChart");
	driver.findElement(By.xpath(DeleteChart)).click();
	Thread.sleep(1000);	
 	

	String Yes=obj.getProperty("YesDelete");
 	driver.findElement(By.xpath(Yes)).click();
 	
 	String ToastMessage=obj.getProperty("ToastMessage");
 	
 	Boolean status=driver.findElement(By.xpath(ToastMessage)).isDisplayed();
 	
 	
 	softassert.assertTrue(status);
    softassert.assertAll();

	
	
	
 	}
	
 	
 	
 	
	
}
