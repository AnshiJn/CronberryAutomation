package CronberryTestng.CronberryTestng.integration;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;



public class ProjectIntergration extends BaseClass{

	
	SoftAssert softassert = new SoftAssert();
	Boolean status;

	@Test(priority = 1, description =  "open project integration tabs")
	@Severity(SeverityLevel.BLOCKER)
		void projectIntegration() throws Exception {
		
	Thread.sleep(3000);	
	String ProjectIntegration=obj.getProperty("ProjectIntegration");
	driver.findElement(By.xpath(ProjectIntegration)).click();
	Thread.sleep(1000);	

	
	
	
	String dropdown=obj.getProperty("dropdown");
	driver.findElement(By.xpath(dropdown)).click();
	Thread.sleep(1000);	
	
	
	String GoogleForm=obj.getProperty("GoogleForm");
	driver.findElement(By.xpath(GoogleForm)).click();
	Thread.sleep(1000);	
	
	
	
	String IntegrationPageHeading=obj.getProperty("IntegrationPageHeading");
	status=driver.findElement(By.xpath(IntegrationPageHeading)).isDisplayed();
	softassert.assertTrue(status);
    softassert.assertAll();

	}
	
	@Test(priority = 2, description =  "open project integration tab of google form")
	@Severity(SeverityLevel.BLOCKER)

	void projectIntegrationGForm() throws Exception {
	
	String GoogleFormTab=obj.getProperty("GoogleFormTab");
	status=driver.findElement(By.xpath(GoogleFormTab)).isDisplayed();
	softassert.assertTrue(status);
	
	
	String AddForm=obj.getProperty("AddForm");
	driver.findElement(By.xpath(AddForm)).click();;
	Thread.sleep(1000);
	
	
	
	String GFrmNam=obj.getProperty("GFrmNam");
	String GFormName=obj.getProperty("GFormName");
	driver.findElement(By.xpath(GFormName)).sendKeys(GFrmNam);
	Thread.sleep(1000);
	
	String FormSubmitBtn=obj.getProperty("FormSubmitBtn");
	driver.findElement(By.xpath(FormSubmitBtn)).click();;
	Thread.sleep(1000);
	
	String GForm=obj.getProperty("GForm");
	driver.findElement(By.xpath(GForm)).click();;
	Thread.sleep(1000);
	
	
	String GFormDelete=obj.getProperty("GFormDelete");
	driver.findElement(By.xpath(GFormDelete)).click();;
	Thread.sleep(1000);
	
	
	String FormDelete=obj.getProperty("FormDelete");
	driver.findElement(By.xpath(FormDelete)).click();;
	Thread.sleep(1000);
	
	String DeleteGForm=obj.getProperty("DeleteGForm");
	driver.findElement(By.xpath(DeleteGForm)).click();;
	Thread.sleep(1000);
    softassert.assertAll();

	
}
	
	
	@Test(priority = 3, description =  "open project integration tab of custom form")
	@Severity(SeverityLevel.NORMAL)

	void projectIntegrationCForm() throws Exception {
	
	String CustomFrm=obj.getProperty("CustomFrm");
	status=driver.findElement(By.xpath(CustomFrm)).isDisplayed();
	softassert.assertTrue(status);
	
	driver.findElement(By.xpath(CustomFrm)).click();
    softassert.assertAll();

	
	}
	
	
	
	
	
	@Test(priority = 4, description =  "open project integration tab of Marketplace")

	void projectIntegrationMarketPlace() throws Exception {
	
	String Marketplace=obj.getProperty("Marketplace");
	status=driver.findElement(By.xpath(Marketplace)).isDisplayed();
	softassert.assertTrue(status);
	driver.findElement(By.xpath(Marketplace)).click();
	
	
	String JustDail=obj.getProperty("JustDail");
	status=driver.findElement(By.xpath(JustDail)).isDisplayed();
	softassert.assertTrue(status);
	driver.findElement(By.xpath(JustDail)).click();
	
	
	String IndiaMart=obj.getProperty("IndiaMart");
	status=driver.findElement(By.xpath(IndiaMart)).isDisplayed();
	softassert.assertTrue(status);
	driver.findElement(By.xpath(IndiaMart)).click();
	
	
	
	String TradeIndia=obj.getProperty("TradeIndia");
	status=driver.findElement(By.xpath(TradeIndia)).isDisplayed();
	softassert.assertTrue(status);
	driver.findElement(By.xpath(TradeIndia)).click();
	
	
	String HubSpot=obj.getProperty("HubSpot");
	status=driver.findElement(By.xpath(HubSpot)).isDisplayed();
	softassert.assertTrue(status);
	driver.findElement(By.xpath(HubSpot)).click();
    softassert.assertAll();

	
	}
	
	
	@Test(priority = 5, description =  "open project integration tab of SocialMedia")

	void projectIntegrationSocialMedia() throws Exception {
	
	String SocialMedia=obj.getProperty("SocialMedia");
	status=driver.findElement(By.xpath(SocialMedia)).isDisplayed();
	softassert.assertTrue(status);
	driver.findElement(By.xpath(SocialMedia)).click();
	
	
	String Facebook=obj.getProperty("Facebook");
	status=driver.findElement(By.xpath(Facebook)).isDisplayed();
	softassert.assertTrue(status);
	driver.findElement(By.xpath(Facebook)).click();
    softassert.assertAll();

		
	}
	
	@Test(priority = 6, description =  "open project integration tab of API")

	void projectIntegrationAPI() throws Exception {
	
	String API=obj.getProperty("API");
	status=driver.findElement(By.xpath(API)).isDisplayed();
	softassert.assertTrue(status);
	driver.findElement(By.xpath(API)).click();
    softassert.assertAll();

	}
	
	
	
	@Test(priority = 7, description =  "open project integration tab of Ecommerce")

	void projectIntegrationEcommerce() throws Exception {
	
	String Ecommerce=obj.getProperty("Ecommerce");
	status=driver.findElement(By.xpath(Ecommerce)).isDisplayed();
	softassert.assertTrue(status);
	driver.findElement(By.xpath(Ecommerce)).click();
    softassert.assertAll();

	}
	
	
	@Test(priority = 8, description =  "open project integration tab of Bulk")

	void projectIntegrationBulk() throws Exception {
	
	String Bulk=obj.getProperty("Bulk");
	status=driver.findElement(By.xpath(Bulk)).isDisplayed();
	softassert.assertTrue(status);
	driver.findElement(By.xpath(Bulk)).click();
    softassert.assertAll();

	
	}
	
	
	@Test(priority = 9, description =  "open project integration tab of Custom")

	void projectIntegrationCustom() throws Exception {
	
	String Custom=obj.getProperty("Custom");
	status=driver.findElement(By.xpath(Custom)).isDisplayed();
	softassert.assertTrue(status);
	driver.findElement(By.xpath(Custom)).click();
	
    softassert.assertAll();

	}
	
	
	@Test(priority = 9, description =  "open project integration sub menus")

	void projectIntegrationSubMenu() throws Exception {
	
	
		Thread.sleep(3000);
		
		String Click1=obj.getProperty("Click1");
		String Click2=obj.getProperty("Click2");
		String Click3=obj.getProperty("Click3");
		String Click4=obj.getProperty("Click4");
		String Click5=obj.getProperty("Click5");
		String Click6=obj.getProperty("Click6");
		String Click7=obj.getProperty("Click7");
		String Click8=obj.getProperty("Click8");

		driver.findElement(By.xpath(Click1)).click();
		driver.findElement(By.xpath(Click1)).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(Click2)).click();
		driver.findElement(By.xpath(Click2)).click();
		Thread.sleep(3000);

		
		driver.findElement(By.xpath(Click3)).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(Click4)).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(Click5)).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(Click6)).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(Click7)).click();
		Thread.sleep(3000);

	

		
		String SubMenuGF=obj.getProperty("SubMenuGF");
		driver.findElement(By.xpath(SubMenuGF)).click();
		String PageHeadingForm=obj.getProperty("PageHeadingForm");
		status=driver.findElement(By.xpath(PageHeadingForm)).isDisplayed();
		softassert.assertTrue(status,"Failed to form page");		
		
		String SubMenuCF=obj.getProperty("SubMenuCF");
		driver.findElement(By.xpath(SubMenuCF)).click();
		status=driver.findElement(By.xpath(PageHeadingForm)).isDisplayed();
		softassert.assertTrue(status,"Failed to form page");		
		
		String SubMenuJD=obj.getProperty("SubMenuJD");
		driver.findElement(By.xpath(SubMenuJD)).click();
		String PageHeadingMrkt=obj.getProperty("PageHeadingMrkt");
		status=driver.findElement(By.xpath(PageHeadingMrkt)).isDisplayed();
		softassert.assertTrue(status,"Failed to marketplace page");		
		
		String SubMenuIM=obj.getProperty("SubMenuIM");
		driver.findElement(By.xpath(SubMenuIM)).click();
		status=driver.findElement(By.xpath(PageHeadingMrkt)).isDisplayed();
		softassert.assertTrue(status,"Failed to marketplace page");		
		
		String SubMenuTD=obj.getProperty("SubMenuTD");
		driver.findElement(By.xpath(SubMenuTD)).click();
		status=driver.findElement(By.xpath(PageHeadingMrkt)).isDisplayed();
		softassert.assertTrue(status,"Failed to marketplace page");		
		
		String SubMenuHS=obj.getProperty("SubMenuHS");
		driver.findElement(By.xpath(SubMenuHS)).click();
		status=driver.findElement(By.xpath(PageHeadingMrkt)).isDisplayed();
		softassert.assertTrue(status,"Failed to marketplace page");
		
		
		String SubMenuFB=obj.getProperty("SubMenuFB");
		driver.findElement(By.xpath(SubMenuFB)).click();
		String PageHeadingSCM=obj.getProperty("PageHeadingSCM");
		status=driver.findElement(By.xpath(PageHeadingSCM)).isDisplayed();
		softassert.assertTrue(status,"Failed to load social media page");
		
		
		
		String SubMenuAPi=obj.getProperty("SubMenuAPi");
		driver.findElement(By.xpath(SubMenuAPi)).click();
		String PageHeadingAPI=obj.getProperty("PageHeadingAPI");
		status=driver.findElement(By.xpath(PageHeadingAPI)).isDisplayed();
		softassert.assertTrue(status,"Failed to load api page");
		
		
		String SubMenuEC=obj.getProperty("SubMenuEC");
		driver.findElement(By.xpath(SubMenuEC)).click();
		String PageHeadingEC=obj.getProperty("PageHeadingEC");
		status=driver.findElement(By.xpath(PageHeadingEC)).isDisplayed();
		softassert.assertTrue(status,"Failed to load e commerce page");
		
		
		
		String SubMenuBulk=obj.getProperty("SubMenuBulk");
		driver.findElement(By.xpath(SubMenuBulk)).click();
		String PageHeadingBulk=obj.getProperty("PageHeadingBulk");
		status=driver.findElement(By.xpath(PageHeadingBulk)).isDisplayed();
		softassert.assertTrue(status,"Failed to load bulk upload page");
		
		String SubMenuCustom=obj.getProperty("SubMenuCustom");
		driver.findElement(By.xpath(SubMenuCustom)).click();
		String PageHeadingCustom=obj.getProperty("PageHeadingCustom");
		
		status=driver.findElement(By.xpath(PageHeadingCustom)).isDisplayed();
		System.out.println(driver.findElement(By.xpath(PageHeadingCustom)).isDisplayed());
		
		Assert.assertTrue(status,"Failed to load custom page");
		
        softassert.assertAll();

		
		
		
	}
	
	
	
}
