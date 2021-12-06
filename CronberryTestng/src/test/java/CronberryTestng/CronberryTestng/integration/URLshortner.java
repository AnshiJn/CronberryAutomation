package CronberryTestng.CronberryTestng.integration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class URLshortner extends BaseClass {

	
	@Test(priority=1, description="Open URL shortener")
	
	void openURLshortner() throws Exception
	{
		
		SoftAssert softasset= new SoftAssert();
		
		String urshortner=obj.getProperty("URLshortner");
		String pageOpenUrlShortner=obj.getProperty("pageOpenUrlShortner");
		
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(urshortner)).click();
		
		String pageHeading=driver.findElement(By.xpath(pageOpenUrlShortner)).getText();
		
		softasset.assertEquals("Url Shortner", pageHeading);
		
	    softasset.assertAll();

	}
	
	
	@Test(priority=2, description="Create URL shortener")
	void createURLshortner() throws Exception{
		
		SoftAssert softassert= new SoftAssert();

		
		String CreateURLShortner=obj.getProperty("CreateURLShortner");
		
		String AddURL=obj.getProperty("AddURL");
		
		String UrlShortLink=obj.getProperty("UrlShortLink");
		
		String URLButton=obj.getProperty("URLButton");

		String URLShotnerModelHeading=obj.getProperty("URLShotnerModelHeading");
		
		String ToastMessage=obj.getProperty("ToastMessage");
		
		 Thread.sleep(1000);
		
		 driver.findElement(By.xpath(CreateURLShortner)).click();
		
		 Thread.sleep(1000);

		String headingURLShortner=driver.findElement(By.xpath(URLShotnerModelHeading)).getText();
		
		
		softassert.assertNotEquals(" Create Short URL", headingURLShortner);
		
		
		driver.findElement(By.xpath(AddURL)).sendKeys(UrlShortLink);
		
		driver.findElement(By.xpath(URLButton)).click();
		
		 Thread.sleep(1000);

		String toastmsg= driver.findElement(By.xpath(ToastMessage)).getText();
		
		softassert.assertEquals("Success Shortner URL created.", toastmsg);
		
		String CopyURLShort=obj.getProperty("CopyURLShort");
		
		driver.findElement(By.xpath(CopyURLShort)).click();
		 
		Thread.sleep(1000);

		
		toastmsg= driver.findElement(By.xpath(ToastMessage)).getText();
		
		softassert.assertEquals("Copied to clipboard", toastmsg);
		
		Thread.sleep(500);

		
		String CloseButton=obj.getProperty("CloseButton");
		
		driver.findElement(By.xpath(CloseButton)).click();
	    softassert.assertAll();

		
	}
	
	
	
	@Test(priority=3, description="Delete URL shortener")
	void DeleteURLshortner() throws Exception{
		
		SoftAssert softassert= new SoftAssert();
		String DeleteURL= obj.getProperty("DeleteURL");
		String DeleteModel=obj.getProperty("DeleteURL");
		String ConfirmDelete=obj.getProperty("ConfirmDelete");
		String ToastMessage=obj.getProperty("ToastMessage");

		
		
		driver.findElement(By.xpath(DeleteURL)).click();
		
		Thread.sleep(1000);

		String heading=driver.findElement(By.xpath(DeleteModel)).getText();
		
		softassert.assertEquals("Do you want to remove?", heading);
		
		driver.findElement(By.xpath(ConfirmDelete)).click();
		
		
		Thread.sleep(1000);

		
		String toastmsg= driver.findElement(By.xpath(ToastMessage)).getText();
		
		softassert.assertEquals("Success Success", toastmsg);
		
		
	    softassert.assertAll();

	
	
	}
}
