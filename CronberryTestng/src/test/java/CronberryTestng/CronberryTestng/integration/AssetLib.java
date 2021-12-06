package CronberryTestng.CronberryTestng.integration;


import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Important.UtilitiesCronberry;

public class AssetLib extends BaseClass{

	SoftAssert softassert = new SoftAssert();


	@Test(priority = 1, description = "open asset tab ")

		void openAsset() throws Exception {
		
	Thread.sleep(1000);	
	String AssetTab=obj.getProperty("AssetTab");
	driver.findElement(By.xpath(AssetTab)).click();
	Thread.sleep(1000);	


	String AssetPageHeading=obj.getProperty("AssetPageHeading");
	
	String pageHeading=driver.findElement(By.xpath(AssetPageHeading)).getText();
	
	softassert.assertEquals("Asset Library", pageHeading);
	
	   softassert.assertAll();
	
	}
	
 	@Test(priority = 2, description = "add media images")
 
 	void addMedia() throws Exception {
 		
 	Thread.sleep(2000);	
 	String AddMedia=obj.getProperty("AddMedia");
 	driver.findElement(By.xpath(AddMedia)).click();
 	Thread.sleep(1000);	
 	
 	
 	String MediaModel=obj.getProperty("MediaModel");
 	Thread.sleep(1000);	
 
 	
 	Boolean mediaModel=driver.findElement(By.xpath(MediaModel)).isDisplayed();
 	
 	softassert.assertTrue(mediaModel);
 	
 	
 	
 	String AddFiles=obj.getProperty("AddFiles");
 	
 	
 	
 	String Image1=obj.getProperty("Image1");
 	String Image2=obj.getProperty("Image2");
 	String Image3=obj.getProperty("Image3");
 	String Image4=obj.getProperty("Image4");
 	String Image5=obj.getProperty("Image5");
 	String Image6=obj.getProperty("Image6");
 
 	
 	
 	driver.findElement(By.xpath(AddFiles)).sendKeys(Image1+"\n"+Image2+"\n"+Image3+"\n"+Image4+"\n"+Image5+"\n"+Image6);
 	
 	
 	
 	String ImageName=obj.getProperty("ImageName");
 	driver.findElement(By.xpath(ImageName)).sendKeys("Images");
 	
 	Thread.sleep(1000);	
 	
 	String SaveMedia=obj.getProperty("SaveMedia");
 	
 	driver.findElement(By.xpath(SaveMedia)).click();
 	Thread.sleep(2000);	
 
 	String ToastMessage=obj.getProperty("ToastMessage");
 	
 	Boolean status=driver.findElement(By.xpath(ToastMessage)).isDisplayed();
 	
 	
 	softassert.assertTrue(status);
 	
    softassert.assertAll();
 	
 }
 	
 	
 	
 	@Test(priority = 3, description = "delete media ")
 
 	void deleteMedia() throws Exception {
 		
 	Thread.sleep(2000);	
 	String DeleteMedia=obj.getProperty("DeleteMedia");
 	driver.findElement(By.xpath(DeleteMedia)).click();
 	Thread.sleep(1000);	
 	
 	String Yes=obj.getProperty("Yes");
 	driver.findElement(By.xpath(Yes)).click();
 	
 	String ToastMessage=obj.getProperty("ToastMessage");
 	
 	Boolean status=driver.findElement(By.xpath(ToastMessage)).isDisplayed();
 	
 	
 	softassert.assertTrue(status);
    softassert.assertAll();
 	
 	}
 	
 	
 	
 	
 	@Test(priority = 4, description = "copy media ")
 
 	void copyMedia() throws Exception {
 		
 	Thread.sleep(2000);	
 	String CopyMedia=obj.getProperty("CopyMedia");
 	driver.findElement(By.xpath(CopyMedia)).click();
 	Thread.sleep(1000);	
 		
 	String ToastMessage=obj.getProperty("ToastMessage");
 	
 	Boolean status=driver.findElement(By.xpath(ToastMessage)).isDisplayed();
 	
 	
 	softassert.assertTrue(status);
    softassert.assertAll();
 	
 	}
 	
 	
 	
 	@Test(priority = 5, description = "view media ")
 
 	void viewMedia() throws Exception {
 	
 	String parentWindow=driver.getWindowHandle();
 	
 	Thread.sleep(2000);	
 	String ViewMedia=obj.getProperty("ViewMedia");
 	driver.findElement(By.xpath(ViewMedia)).click();
 	Thread.sleep(1000);	
 	
 	String url=driver.getCurrentUrl().toString();
 	 
 	softassert.assertTrue(url.contains("image_file"));
 
 	driver.switchTo().window(parentWindow);
 
    softassert.assertAll();	
 	
 	}
 	
 	@Test(priority = 6, description = "add media file")
 
 	void addMediafile() throws Exception {
 		
 	Thread.sleep(2000);	
 	String AddMedia=obj.getProperty("AddMedia");
 	driver.findElement(By.xpath(AddMedia)).click();
 	Thread.sleep(1000);	
 	
 	
 	String MediaModel=obj.getProperty("MediaModel");
 	Thread.sleep(1000);	
 
 	
 	Boolean mediaModel=driver.findElement(By.xpath(MediaModel)).isDisplayed();
 	
 	softassert.assertTrue(mediaModel);
 	
 	
 	
 	String SelectTypeOfMedia=obj.getProperty("SelectTypeOfMedia");
 	driver.findElement(By.xpath(SelectTypeOfMedia)).click();
 	
 	String SelectFile=obj.getProperty("SelectFile");
 	driver.findElement(By.xpath(SelectFile)).click();
 	
 	
 	
 	
 	String AddFiles=obj.getProperty("AddFiles");
 	
 	
 	
 	String Filecsv=obj.getProperty("Filecsv");
 
 
 	
 	
 	driver.findElement(By.xpath(AddFiles)).sendKeys(Filecsv);
 	
 	
 	
 	String ImageName=obj.getProperty("ImageName");
 	driver.findElement(By.xpath(ImageName)).sendKeys("Files");
 	
 	Thread.sleep(1000);	
 	
 	String SaveMedia=obj.getProperty("SaveMedia");
 	
 	driver.findElement(By.xpath(SaveMedia)).click();
 	Thread.sleep(2000);	
 
 	String ToastMessage=obj.getProperty("ToastMessage");
 	
 	Boolean status=driver.findElement(By.xpath(ToastMessage)).isDisplayed();
 	
 	
 	softassert.assertTrue(status);
    softassert.assertAll();
 }
	
	
	@Test(priority = 7, description = "defaultgallery images")

	void galleryImages() throws Exception {
	
		
		
	UtilitiesCronberry scrnshot= new UtilitiesCronberry();
	
	
	
	Thread.sleep(2000);	
	String SelectType=obj.getProperty("SelectType");
	driver.findElement(By.xpath(SelectType)).click();
	Thread.sleep(1000);	
	
	String Gallery=obj.getProperty("Gallery");
	driver.findElement(By.xpath(Gallery)).click();
	Thread.sleep(2000);	
	
	scrnshot.getScreenshot("galleryImagesScreenshot");
	
	driver.findElement(By.xpath(SelectType)).click();

	
	Thread.sleep(2000);	

	driver.findElement(By.xpath(SelectType)).click();
	Thread.sleep(1000);	
	
	String YourFile=obj.getProperty("YourFile");
	driver.findElement(By.xpath(YourFile)).click();
	Thread.sleep(2000);	
	
	scrnshot.getScreenshot("assetFileScreenshot");
	
	
	   softassert.assertAll();
	}	
	
	
	
	
	
	
	
	
}
