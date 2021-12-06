package CronberryTestng.CronberryTestng.integration;

import java.util.Date;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Segment extends BaseClass{

		SoftAssert softassert = new SoftAssert();


		@Test(priority = 1, description = "open create segment tab ")

			void createSegemnt() throws Exception {
			
		Thread.sleep(1000);	
		String segment=obj.getProperty("Segment");
		driver.findElement(By.xpath(segment)).click();
		Thread.sleep(1000);	

		String SegPageHeading=obj.getProperty("SegPageHeading");
		
		String pageHeading=driver.findElement(By.xpath(SegPageHeading)).getText();
		
		softassert.assertEquals("Segments", pageHeading);
	    softassert.assertAll();

		}


		@Test(priority = 2, description = "open create segment page ")

			void createSegemntPage() throws Exception {
			
		Thread.sleep(1000);	
		String CreateSegement=obj.getProperty("CreateSegement");
		driver.findElement(By.xpath(CreateSegement)).click();
		Thread.sleep(1000);	

		String SegPageHeading=obj.getProperty("SegmentPage");
		
		String pageHeading=driver.findElement(By.xpath(SegPageHeading)).getText();
		
		softassert.assertEquals("Segments", pageHeading);
	    softassert.assertAll();

		}
		
		
		@Test(priority = 3, description = "open create segment ")

		void createSegments() throws Exception {
		
			
			
			
			Date ran= new Date();
			String num=ran.toString();
          
			
			
			String SegmentName=obj.getProperty("SegmentName");
			String SegmentNamefield=obj.getProperty("SegmentNamefield");
			
			
			Boolean isDisplayed=driver.findElement(By.xpath(SegmentNamefield)).isDisplayed();
			driver.findElement(By.xpath(SegmentNamefield)).sendKeys(SegmentName+num);
	
			
			softassert.assertTrue(isDisplayed);
			
			String AddFilter=obj.getProperty("AddFilter");
			
			driver.findElement(By.xpath(AddFilter)).click();	
			Thread.sleep(500);

			
			driver.findElement(By.xpath("//option[text()='LeadStatus']")).click();
			Thread.sleep(2500);

			
			
			driver.findElement(By.xpath("//input[@role='combobox']")).click();
			Thread.sleep(500);

			
			
			driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-create-segments/main/form/section[2]/div/div/div/div[2]/div[2]/div/div/div/div/div/div[3]/div/div/div/div/div[2]/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div[1]")).click();
			Thread.sleep(500);
			
//			String AddFilter1=obj.getProperty("AddFilter1");
//			
//			driver.findElement(By.xpath(AddFilter1)).click();
//			Thread.sleep(500);
//
//			
//			String NewFilter=obj.getProperty("NewFilter");
//			Thread.sleep(500);

//			
//			driver.findElement(By.xpath(NewFilter)).click();
//			Thread.sleep(500);
//
//			
//			driver.findElement(By.xpath("//option[text()='Lead Count']")).click();
//			Thread.sleep(500);
//
//
//			String LeadCount=obj.getProperty("LeadCount");
//			
//			driver.findElement(By.xpath(LeadCount)).sendKeys("2");
			
			
			
			String CreateSeg=obj.getProperty("CreateSeg");
			
			driver.findElement(By.xpath(CreateSeg)).click();
			
			Thread.sleep(1000);
			
			String SegmentCreated=obj.getProperty("SegmentCreated");
			
			System.out.println("print..................now");
			
			String segName=driver.findElement(By.xpath(SegmentCreated)).getText();
			
			System.out.println("print..................now 2");

			
			String check=SegmentName+num;
			
			softassert.assertEquals(check, segName);
			
		    softassert.assertAll();

			}
		
		
 
		@Test(priority = 4, description = "view segment ")

		void viewSegemnt() throws Exception {
		
			Thread.sleep(1000);	
			String ViewSegment=obj.getProperty("ViewSegment");
			driver.findElement(By.xpath(ViewSegment)).click();
			Thread.sleep(1000);

			Thread.sleep(1000);	
				
			String SegmentModel=obj.getProperty("SegmentModel");
			
			Boolean segModel= driver.findElement(By.xpath(SegmentModel)).isDisplayed();
			
			softassert.assertTrue(segModel);
			
			String CloseSegmentModel=obj.getProperty("CloseSegmentModel");
			
			driver.findElement(By.xpath(CloseSegmentModel)).click();
			Thread.sleep(1000);
		    softassert.assertAll();

		
		}
	
		
		@Test(priority = 5, description = "view segment audience ")

		void CalculateSegemntAudeince() throws Exception {
		
			Thread.sleep(1000);	
			String CalculateSegAudience=obj.getProperty("CalculateSegAudience");
			driver.findElement(By.xpath(CalculateSegAudience)).click();
			Thread.sleep(1000);	

			
			
		
			String CalculateSegAudienceBtn=obj.getProperty("CalculateSegAudienceBtn");
			driver.findElement(By.xpath(CalculateSegAudienceBtn)).click();
			Thread.sleep(1500);	

		
			
			
			String ToastMessage=obj.getProperty("ToastMessage");
			String toastmsg=driver.findElement(By.xpath(ToastMessage)).getText();
			Thread.sleep(1000);	

			softassert.assertTrue(toastmsg.contains("Found"));
			
		    softassert.assertAll();

		
		
		}
		
		
		
		
		
		@Test(priority = 6, description = "edit segment ")

		void EditSegment() throws Exception {
		
			Thread.sleep(1000);	
			String EditSegment=obj.getProperty("EditSegment");
			driver.findElement(By.xpath(EditSegment)).click();
			Thread.sleep(1000);	
			
		
			String SegmentNamefield=obj.getProperty("SegmentNamefield");
			
			Boolean isDisplayed=driver.findElement(By.xpath(SegmentNamefield)).isDisplayed();
						
			softassert.assertTrue(isDisplayed);
			
			String UpdateSegment = obj.getProperty("UpdateSegment");
			driver.findElement(By.xpath(UpdateSegment)).click();
			Thread.sleep(1000);	
		    softassert.assertAll();

		
		}
		
		
		
			
		@Test(priority = 7, description = "delete segment ")

		void DeleteSegment() throws Exception {
		
			Thread.sleep(1000);	
			String DeleteSegment=obj.getProperty("DeleteSegment");
			driver.findElement(By.xpath(DeleteSegment)).click();
			Thread.sleep(1000);	
			
		
			String YesBtn=obj.getProperty("YesBtn");
			driver.findElement(By.xpath(YesBtn)).click();
			Thread.sleep(1000);	

			String ToastMessage=obj.getProperty("ToastMessageBar");
			String toastmsg=driver.findElement(By.xpath(ToastMessage)).getText();
			Thread.sleep(1000);	
			
			System.out.println(toastmsg+"this is toast message");

			softassert.assertTrue(toastmsg.contains("Segment"));
			
		    softassert.assertAll();

			
		}

}	
	
	
	
	
	
