package CronberryTestng.CronberryTestng.integration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Catalogue extends BaseClass{

	SoftAssert softassert = new SoftAssert();
	Boolean status;

	@Test(priority = 1, description = "open catalogue tab ")

		void openCatalogue() throws Exception {
		
	Thread.sleep(3000);	
	String CatalogueTab=obj.getProperty("CatalogueTab");
	driver.findElement(By.xpath(CatalogueTab)).click();
	Thread.sleep(1000);	

	String PageHeading=obj.getProperty("CataloguePg");
	
	WebDriverWait wait = new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageHeading)));
	
	
	status=driver.findElement(By.xpath(PageHeading)).isDisplayed();
	
	softassert.assertTrue(status);
	
    softassert.assertAll();

	
	
		}

	
	
	@Test(priority = 2, description = "create catalogue tab ")

	void createCatalogue() throws Exception {
	
	Thread.sleep(3000);	
	String CreateCatalogue=obj.getProperty("CreateCatalogue");
	driver.findElement(By.xpath(CreateCatalogue)).click();
	Thread.sleep(1000);	
	
	String PageHeading=obj.getProperty("CreateCataloquePg");
	
	WebDriverWait wait = new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageHeading)));
	
	
	status=driver.findElement(By.xpath(PageHeading)).isDisplayed();
	
	softassert.assertTrue(status);
	
	
	
	String UploadLogo=obj.getProperty("UploadLogo");
	driver.findElement(By.xpath(UploadLogo)).click();
	Thread.sleep(2000);	

	
	
	String ChooseMedia=obj.getProperty("ChooseMedia");
	driver.findElement(By.xpath(ChooseMedia)).click();
	Thread.sleep(1000);	

	
	
	String ChooseLogo=obj.getProperty("ChooseLogo");
	driver.findElement(By.xpath(ChooseLogo)).click();
	Thread.sleep(1000);	

	
	
	
	String AddProduct=obj.getProperty("AddProduct");
	driver.findElement(By.xpath(AddProduct)).click();
	Thread.sleep(1000);	
	
	driver.findElement(By.xpath(ChooseMedia)).click();
	Thread.sleep(1000);	
	driver.findElement(By.xpath(ChooseLogo)).click();
	Thread.sleep(1000);	
	
	String Price1=obj.getProperty("Price1");
	driver.findElement(By.xpath(Price1)).sendKeys("2000");
	Thread.sleep(1000);	
	
	
	String AddProduct2=obj.getProperty("AddProduct2");
	driver.findElement(By.xpath(AddProduct2)).click();
	Thread.sleep(1000);	
	
	driver.findElement(By.xpath(ChooseMedia)).click();
	Thread.sleep(1000);	
	driver.findElement(By.xpath(ChooseLogo)).click();
	Thread.sleep(1000);		
	
	String Price2=obj.getProperty("Price2");
	driver.findElement(By.xpath(Price2)).sendKeys("2000");
	Thread.sleep(1000);	

	
	String CatalogueTitle=obj.getProperty("CatalogueTitle");
	String CatalogueTitleName=obj.getProperty("CatalogueTitleName");
	driver.findElement(By.xpath(CatalogueTitle)).sendKeys(CatalogueTitleName);
	Thread.sleep(1000);	
	
	
	
	
	String DeleteNumber=obj.getProperty("DeleteNumber");
	driver.findElement(By.xpath(DeleteNumber)).clear();
	Thread.sleep(1000);
	
	
	String CatalogueHandel=obj.getProperty("CatalogueHandel");
	driver.findElement(By.xpath(CatalogueHandel)).sendKeys(CatalogueTitleName);
	Thread.sleep(1000);	
	
	
	
	String GenerateLink=obj.getProperty("GenerateLink");
	driver.findElement(By.xpath(GenerateLink)).click();
	Thread.sleep(1000);	
	
	
	
	String CatalogueToast=obj.getProperty("CatalogueToast");

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CatalogueToast)));
	
	
	status=driver.findElement(By.xpath(CatalogueToast)).isDisplayed();
	
	softassert.assertTrue(status);
	
	
	
	
	String CatalogueLinkModel=obj.getProperty("CatalogueLinkModel");

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CatalogueLinkModel)));
	
	
	status=driver.findElement(By.xpath(CatalogueLinkModel)).isDisplayed();
	
	softassert.assertTrue(status);
	
	
	
	String CloseCatModel=obj.getProperty("CloseCatModel");
	driver.findElement(By.xpath(CloseCatModel)).click();
	Thread.sleep(1000);
	
	
	String PageHeadin=obj.getProperty("CataloguePg");
	

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageHeadin)));
	
	
	status=driver.findElement(By.xpath(PageHeadin)).isDisplayed();
	
	softassert.assertTrue(status);
	
	
	//**Copy Catalogue Link **//
	
	Thread.sleep(2000);

	String CopyLink=obj.getProperty("CopyLink");
	driver.findElement(By.xpath(CopyLink)).click();
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CatalogueToast)));
	
	
	status=driver.findElement(By.xpath(CatalogueToast)).isDisplayed();
	
	softassert.assertTrue(status);
	
	//**Copy Short Link of Catalogue **//
	
	Thread.sleep(2000);

	
	String ShortLinkCat=obj.getProperty("ShortLinkCat");
	driver.findElement(By.xpath(ShortLinkCat)).click();
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CatalogueToast)));
	
	
	status=driver.findElement(By.xpath(CatalogueToast)).isDisplayed();
	
	softassert.assertTrue(status);
	
    softassert.assertAll();

	
	}
	

	
	
	

	@Test(priority = 3, description = "edit catalogue tab ")

		void editCatalogue() throws Exception {
	
		WebDriverWait wait = new WebDriverWait(driver,30);
	
		Thread.sleep(3000);	
		String EditCatalogue=obj.getProperty("EditCatalogue");
		driver.findElement(By.xpath(EditCatalogue)).click();
		Thread.sleep(1000);	
		
		String GenerateLink=obj.getProperty("GenerateLink");
		driver.findElement(By.xpath(GenerateLink)).click();
		Thread.sleep(1000);	
		
		
		String CatalogueToast=obj.getProperty("CatalogueToast");
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CatalogueToast)));
		
		
		status=driver.findElement(By.xpath(CatalogueToast)).isDisplayed();
		
		softassert.assertTrue(status);
	    softassert.assertAll();

	}
	
	
	
	
	
	
	@Test(priority = 4, description = "delete catalogue tab ")

	void deleteCatalogue() throws Exception {

	WebDriverWait wait = new WebDriverWait(driver,30);

	Thread.sleep(3000);	
	String DeleteCatalogue=obj.getProperty("DeleteCatalogue");
	driver.findElement(By.xpath(DeleteCatalogue)).click();
	Thread.sleep(1000);	
	
	String YesDelete=obj.getProperty("YesDelete");
	driver.findElement(By.xpath(YesDelete)).click();
	Thread.sleep(1000);	
	
	String CatalogueToast=obj.getProperty("CatalogueToast");
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CatalogueToast)));
	
	
	status=driver.findElement(By.xpath(CatalogueToast)).isDisplayed();
	
	softassert.assertTrue(status);
	
    softassert.assertAll();

	
	}
	

}