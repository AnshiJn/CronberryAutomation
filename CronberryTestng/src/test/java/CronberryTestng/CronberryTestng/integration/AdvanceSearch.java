package CronberryTestng.CronberryTestng.integration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AdvanceSearch extends BaseClass{

	SoftAssert softassert = new SoftAssert();
	
	
	
	@Test(priority=1,description="open advance search in view audience")
	public void AdvSearchViewAudience() throws Exception{
	
		String Navigate=obj.getProperty("Navigate");
		
		driver.navigate().to(Navigate);
		
		String AdvSearchBtn=obj.getProperty("AdvSearchBtn");

		Thread.sleep(3000);
		driver.findElement(By.xpath(AdvSearchBtn)).click();
		
		
		
		
		String AllSrc=obj.getProperty("AllSrc");

		Thread.sleep(2000);
		driver.findElement(By.xpath(AllSrc)).click();
		
		
		
		
		
		String Attributes=obj.getProperty("Attributes");

		Thread.sleep(2000);
		driver.findElement(By.xpath(Attributes)).click();
		
		
		String Search=obj.getProperty("Search");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(Search)).sendKeys("LeadStatus");
		
		String SelectAttri=obj.getProperty("SelectAttri");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(SelectAttri)).click();
		
		
		String SubmitAttri=obj.getProperty("SubmitAttri");
		driver.findElement(By.xpath(SubmitAttri)).click();
		
		
		Thread.sleep(3000);

		
		String filtrHeading=obj.getProperty("filtrHeading");
		String getHeading=driver.findElement(By.xpath(filtrHeading)).getText();
		
		
		softassert.assertTrue(getHeading.contains("Source"));		
		
		
		

		String AttriHeading=obj.getProperty("AttriHeading");
		String AttriHead=driver.findElement(By.xpath(AttriHeading)).getText();
		
		
		softassert.assertTrue(AttriHead.contains("Attributes"));	
		
		
		

		String CityAttri=obj.getProperty("CityAttri");
		driver.findElement(By.xpath(CityAttri)).click();
		Thread.sleep(3000);

		
		String ClickAttri=obj.getProperty("ClickAttri");
		driver.findElement(By.xpath(ClickAttri)).click();
		Thread.sleep(3000);

		
		
		String ApplyFilter=obj.getProperty("ApplyFilter");
		driver.findElement(By.xpath(ApplyFilter)).click();
		
		Thread.sleep(3000);

		
		
	
		
		   softassert.assertAll();
		}
	
	@Test(priority=2,description="save filter")

	public void SaveFilter() throws Exception
	{
		
		String SaveFilter=obj.getProperty("SaveFilter");
		
		Boolean Status= driver.findElement(By.xpath(SaveFilter)).isDisplayed();

		softassert.assertTrue(Status,"Assertion for save filter");
		

		
		driver.findElement(By.xpath(SaveFilter)).click();
		
		String AddFilterMobdelH=obj.getProperty("AddFilterMobdelH");
		
		String Heading=driver.findElement(By.xpath(AddFilterMobdelH)).getText();
		
		softassert.assertTrue(Heading.contains("Add Filter"),"Assertion to get model heading");
		
		
		
		String AddFilterName=obj.getProperty("AddFilterName");
		driver.findElement(By.xpath(AddFilterName)).sendKeys("newFilterallSources");
		
		Thread.sleep(2000);


		String SaveFiltr=obj.getProperty("SaveFiltr");
		driver.findElement(By.xpath(SaveFiltr)).click();
		
		Thread.sleep(2000);
		
		String ToastMessageBar=obj.getProperty("ToastMessageBar");
		
		String ToastMessageBr=driver.findElement(By.xpath(ToastMessageBar)).getText();
		
		
		System.out.println(ToastMessageBr+"++++++++++++++++++++++");
		
		softassert.assertTrue(ToastMessageBr.contains("Success"),"Assertion for success toast");
		
		softassert.assertAll();
		
		
	}
	
//	@Test(priority=3,description=" filter properties")
//
//	public void SearchHistory() throws Exception{
//		
//		Thread.sleep(2000);
//
//		String SearchHistry=obj.getProperty("SearchHistry");
//		
//		driver.findElement(By.xpath(SearchHistry)).click();
//		Thread.sleep(1000);
//
//		String SelectFil=obj.getProperty("SelectFil");
//		driver.findElement(By.xpath(SelectFil)).click();
//		
//		Thread.sleep(3000);
//
//		String Btn1=obj.getProperty("Btn1");
//		String Btn2=obj.getProperty("Btn2");
//		String Btn3=obj.getProperty("Btn3");
//		String Btn4=obj.getProperty("Btn4");
//		
//		
//		Boolean status1=driver.findElement(By.xpath(Btn1)).isDisplayed();
//		System.out.println(status1+"++++++++++++++++++++++");
//
//		Boolean status2=driver.findElement(By.xpath(Btn2)).isDisplayed();
//		System.out.println(status2+"++++++++++++++++++++++");
//
//		Boolean status3=driver.findElement(By.xpath(Btn3)).isDisplayed();
//		System.out.println(status3+"++++++++++++++++++++++");
//
//		Boolean status4=driver.findElement(By.xpath(Btn4)).isDisplayed();
//		System.out.println(status4+"++++++++++++++++++++++");
//
//		
//		softassert.assertTrue(status1,"clear button");
//		softassert.assertTrue(status2,"apply button");
//		softassert.assertTrue(status3,"delete button");
//		softassert.assertTrue(status4,"update button");
//		
//		softassert.assertAll();
//
//		
		
		
		
//	}
	
	
	

}
