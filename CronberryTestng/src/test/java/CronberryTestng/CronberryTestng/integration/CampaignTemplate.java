package CronberryTestng.CronberryTestng.integration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CampaignTemplate extends BaseClass {

	SoftAssert softassert = new SoftAssert();

	String modelHeading;

	@Test(priority = 1, description = "Open campaign template ")

	void openCampaignTemplate() throws Exception {

		Thread.sleep(1000);

		String openEmailTemplate = obj.getProperty("openEmailTemplate");
		String pageHeading = obj.getProperty("pageHeading");

		driver.findElement(By.xpath(openEmailTemplate)).click();

		String pgHeading = driver.findElement(By.xpath(pageHeading)).getText();

		softassert.assertEquals("Campaign Template", pgHeading);
	    softassert.assertAll();

	}
  	
  	
  	@Test(priority=2, description="Open push campaign template ")
  	
  	void openPushCampaignTemplate() throws Exception
  	{
  		
  		
  		String CreateTemplateButton= obj.getProperty("CreateTemplateButton");
  		WebElement button= driver.findElement(By.xpath(CreateTemplateButton));
  		
  		button.click();
  		
  		Thread.sleep(1500);

  		
  		String ModelPush=obj.getProperty("ModelPush");
  		
  		modelHeading=driver.findElement(By.xpath(ModelPush)).getText();
  		
  		System.out.println(modelHeading+"-------this is push");
  		
  		softassert.assertEquals(modelHeading.contains("Push Notification"), true);
  	    softassert.assertAll();

  	}
  	
   	
   	
    	@Test(priority=3, description="Create push campaign template ")
    	
    	void createPushCampaignTemplate() throws Exception
    	{
    		Thread.sleep(1000);
    	
    		String TemplateNameField=obj.getProperty("TemplateNameField");
    		String TemplateName=obj.getProperty("TemplateName");
    		
    		driver.findElement(By.xpath(TemplateNameField)).sendKeys(TemplateName);
    	
    		String	TemplateTitleField=obj.getProperty("TemplateTitleField");
    		String	TemplateTitle=obj.getProperty("TemplateTitle");
    		
    		driver.findElement(By.xpath(TemplateTitleField)).sendKeys(TemplateTitle);
    		
    		String TemplatedynamicField=obj.getProperty("TemplatedynamicField");
    		String DynamicValue=obj.getProperty("DynamicValue");
    		
    		driver.findElement(By.xpath(TemplatedynamicField)).sendKeys(DynamicValue);
    		
    		
    		String SelectImage=obj.getProperty("SelectImage");
    		
    		driver.findElement(By.xpath(SelectImage)).click();
    		Thread.sleep(500);
    
    		
    		String ModelImage=obj.getProperty("ModelImage");
    		
    		String modelname=driver.findElement(By.xpath(ModelImage)).getText();
    		Thread.sleep(500);
    
    		
    		
    		softassert.assertEquals(modelname.contains("Asset Library"), true);
    		
    		
    		
    		String MediaList=obj.getProperty("MediaList");
    		
    		driver.findElement(By.xpath(MediaList)).click();
    		Thread.sleep(500);
    
    		
    		String SelectImgDropDown=obj.getProperty("SelectImgDropDown");
    		driver.findElement(By.xpath(SelectImgDropDown)).click();
    		Thread.sleep(500);
    
    		String SelectGallery=obj.getProperty("SelectGallery");
    		
    		driver.findElement(By.xpath(SelectGallery)).click();
    		driver.findElement(By.xpath(SelectGallery)).click();
    
    		Thread.sleep(500);
    
    		
    		
    		String SelectImg=obj.getProperty("SelectImg");
    		driver.findElement(By.xpath(SelectImg)).click();
    		Thread.sleep(500);
    		
    		String TextArea=obj.getProperty("TextArea");
    		
    		String Text=obj.getProperty("Text");
    
    		driver.findElement(By.xpath(TextArea)).sendKeys(Text);
    		
    		Boolean ImagePresent=driver.findElement(By.xpath("/html/body/modal-container/div/div/form/div/div[2]/div/div[2]/div/tabset/div/tab[1]/div/div/div/div/img")).isDisplayed();
    		
    		softassert.assertTrue(ImagePresent);
    		
    		
    		String CheckWeb=obj.getProperty("CheckWeb");
    		
    		driver.findElement(By.xpath(CheckWeb)).click();
    		
    		
    		String SaveTemplate=obj.getProperty("SaveTemplate");
    		driver.findElement(By.xpath(SaveTemplate)).click();
    		Thread.sleep(500);
    
    		
    		String ToastMessage=obj.getProperty("ToastMessageBar");
    
    		String toastMsg=driver.findElement(By.xpath(ToastMessage)).getText();
    		
    
    		softassert.assertEquals(toastMsg.contains("Template Created"), true);

    		
    	    softassert.assertAll();
  
    		
    	}
    	
    @Test(priority=4, description="Edit push campaign template ")
    	
    	void editPushCampaignTemplate() throws Exception
    	{
    		Thread.sleep(1500);
    		String EditTemplate=obj.getProperty("EditTemplate");
    		driver.findElement(By.xpath(EditTemplate)).click();
    		
    		Thread.sleep(4000);
    
    		String SaveTemplate=obj.getProperty("UpdateTemplate");

    		
    		
    		driver.findElement(By.xpath(SaveTemplate)).click();
    		
    		Thread.sleep(1000);
    		
    		String ToastMessage=obj.getProperty("ToastMessageBar");
    
    		String toastMsg=driver.findElement(By.xpath(ToastMessage)).getText();
    		
    	
    		
    		softassert.assertEquals(toastMsg.contains("Template Updated"), true);

    		
    		
    	    softassert.assertAll();
  
    		
    	}
    	
    @Test(priority=5, description="Delete push campaign template ")
    
    void deletePushCampaignTemplate() throws Exception
    {
    	Thread.sleep(1500);
    	String DeleteTemplate=obj.getProperty("DeleteTemplate");
    	driver.findElement(By.xpath(DeleteTemplate)).click();
    	
    	Thread.sleep(500);
    
    	String ConfirmDelete=obj.getProperty("ConfirmDelete");
    	driver.findElement(By.xpath(ConfirmDelete)).click();
    	
    	Thread.sleep(1000);
    	
    	String ToastMessage=obj.getProperty("ToastMessageBar");
    
    	String toastMsg=driver.findElement(By.xpath(ToastMessage)).getText();
    	

		softassert.assertEquals(toastMsg.contains("Template Deleted"), true);

    	softassert.assertAll();
  
    	
    }
  
     @Test(priority=6, description="Open sms campaign template ")
     
     void openSMSCampaignTemplate() throws Exception
     {
     	
     	Thread.sleep(1500);
 
     	String SMStemplate=obj.getProperty("SMStemplate");
     	driver.findElement(By.xpath(SMStemplate)).click();
     	
     	String CreateTemplateButton= obj.getProperty("CreateTemplateButton");
     	WebElement button= driver.findElement(By.xpath(CreateTemplateButton));
     	
     	Thread.sleep(500);
     	button.click();
     	Thread.sleep(1000);
     
     	
     	String ModelSMS=obj.getProperty("ModelSMS");
     	
     	modelHeading=driver.findElement(By.xpath(ModelSMS)).getText();
     	
     	
 		softassert.assertEquals(modelHeading.contains("SMS Campaign"), true);
 
     	
     	
     	
       softassert.assertAll();
   
     }
     
     
     
     
     @Test(priority=7, description="Create sms campaign template ")
     
     void createSMSCampaignTemplate() throws Exception
     {
     	Thread.sleep(1000);
     
     	String TemplateNameField=obj.getProperty("TemplateNameField");
     	String TemplateName=obj.getProperty("TemplateName");
     	
     	driver.findElement(By.xpath(TemplateNameField)).sendKeys(TemplateName);
     
     	
     	String SMSmessage=obj.getProperty("SMSmessage");
     	
     	String Message=obj.getProperty("Message");
     
     	driver.findElement(By.xpath(SMSmessage)).sendKeys(Message);
     	
     	String ContentPresent=obj.getProperty("ContentPresent");
     	
     	Boolean contentPresent=driver.findElement(By.xpath(ContentPresent)).isDisplayed();
     	
     	softassert.assertTrue(contentPresent);
     	
     	
     	
     	String SaveTemplate=obj.getProperty("SaveTemplate");
     	driver.findElement(By.xpath(SaveTemplate)).click();
     	Thread.sleep(500);
     
     	
     	String ToastMessage=obj.getProperty("ToastMessageBar");
     
     	String toastMsg=driver.findElement(By.xpath(ToastMessage)).getText();
     	
 		softassert.assertEquals(toastMsg.contains("Template Created"), true);
       softassert.assertAll();
   
     	
     }
     
     @Test(priority=8, description="Edit sms campaign template ")
     
     void editSMSCampaignTemplate() throws Exception
     	{
     	Thread.sleep(1500);
     	String EditTemplate=obj.getProperty("EditTemplateSms");
     	driver.findElement(By.xpath(EditTemplate)).click();
     	
     	Thread.sleep(4000);
     
     	String SaveTemplate=obj.getProperty("UpdateTemplate");
     	driver.findElement(By.xpath(SaveTemplate)).click();
    	
    	Thread.sleep(1000);
    	
    	String ToastMessage=obj.getProperty("ToastMessageBar");
    
    	String toastMsg=driver.findElement(By.xpath(ToastMessage)).getText();
    	
 	softassert.assertEquals(toastMsg.contains("Template Updated"), true);
      softassert.assertAll();
  
    	
    }
    
    @Test(priority=9, description="Delete push campaign template ")
    
    void deleteSMSCampaignTemplate() throws Exception
    {
    	Thread.sleep(1500);
    	String DeleteTemplate=obj.getProperty("DeleteTemplateSms");
    	driver.findElement(By.xpath(DeleteTemplate)).click();
    
    	Thread.sleep(500);
    
    	String ConfirmDelete=obj.getProperty("ConfirmDelete");
    	driver.findElement(By.xpath(ConfirmDelete)).click();
    
    	Thread.sleep(1000);
    
    	String ToastMessage=obj.getProperty("ToastMessageBar");
    
    	String toastMsg=driver.findElement(By.xpath(ToastMessage)).getText();
    
 	softassert.assertEquals(toastMsg.contains("Template Deleted"), true);
    
      softassert.assertAll();
  
    }
  
  	@Test(priority = 10, description = "Open email campaign template ")
  
  	void openEmailCampaignTemplate() throws Exception {
  
  		String Emailtemplate = obj.getProperty("Emailtemplate");
  		driver.findElement(By.xpath(Emailtemplate)).click();
  
  		String CreateTemplateButton = obj.getProperty("CreateTemplateButton");
  		WebElement button = driver.findElement(By.xpath(CreateTemplateButton));
  
  		Thread.sleep(1000);
  		button.click();
  		Thread.sleep(2000);

  		String ModelEmail = obj.getProperty("ModelEmail");
  
  		modelHeading = driver.findElement(By.xpath(ModelEmail)).getText();
  
  	
  		
 		softassert.assertEquals(modelHeading.contains("Email Campaign"), true);
 
  		
  		
  	    softassert.assertAll();
  
  	}
  
  	@Test(priority = 11, description = "Create email campaign template ")
  
  	void createEmailCampaignTemplate() throws Exception {
  		Thread.sleep(1500);
  
  		String TemplateNameField = obj.getProperty("TemplateNameField");
  		String TemplateName = obj.getProperty("TemplateName");
  
  		driver.findElement(By.xpath(TemplateNameField)).sendKeys(TemplateName);
  
  		String TemplateEmailSubject = obj.getProperty("TemplateEmailSubject");
  		String EmailSubject = obj.getProperty("EmailSubject");
  
  		driver.findElement(By.xpath(TemplateEmailSubject)).sendKeys(EmailSubject);
  		Thread.sleep(500);
  
  		String TemplatedynamicField = obj.getProperty("TemplatedynamicField");
  		String DynamicValue = obj.getProperty("DynamicValue");
  		Thread.sleep(500);
  
  		driver.findElement(By.xpath(TemplatedynamicField)).sendKeys(DynamicValue);
  
  		String SelectImage = obj.getProperty("SelectImageEmail");
  		Thread.sleep(500);
  
  		driver.findElement(By.xpath(SelectImage)).click();
  		Thread.sleep(500);
  
  		String ModelImage = obj.getProperty("ModelImage");
  
  		String modelname = driver.findElement(By.xpath(ModelImage)).getText();
  		Thread.sleep(1000);
  
  		softassert.assertEquals("Asset Library", modelname);
  
  		String MediaList = obj.getProperty("MediaList");
  
  		driver.findElement(By.xpath(MediaList)).click();
  		Thread.sleep(500);
  
  		String SelectImgDropDown = obj.getProperty("SelectImgDropDown");
  		driver.findElement(By.xpath(SelectImgDropDown)).click();
  		Thread.sleep(500);
  
  		String SelectGallery = obj.getProperty("SelectGallery");
  
  		driver.findElement(By.xpath(SelectGallery)).click();
  		driver.findElement(By.xpath(SelectGallery)).click();
  
  		Thread.sleep(500);
  
  		String SelectImg = obj.getProperty("SelectImg");
  		driver.findElement(By.xpath(SelectImg)).click();
  		Thread.sleep(500);
  
  		String SaveTemplate = obj.getProperty("SaveTemplate");
  		driver.findElement(By.xpath(SaveTemplate)).click();
  		Thread.sleep(1000);
    
    	
  		String ToastMessage = obj.getProperty("ToastMessageBar");
    
  		String toastMsg = driver.findElement(By.xpath(ToastMessage)).getText();

  		
 		softassert.assertEquals(toastMsg.contains("Template Created"), true);

  		
  	    softassert.assertAll();
  
    	
  	}
  
  	@Test(priority = 12, description = "Edit email campaign template ")
    
  	void editEmailCampaignTemplate() throws Exception {
  		Thread.sleep(3000);
  		String EditTemplate = obj.getProperty("EditTemplateEmail");
  		driver.findElement(By.xpath(EditTemplate)).click();
    	
  		Thread.sleep(4000);
    
  		String SaveTemplate = obj.getProperty("UpdateTemplate");
  		driver.findElement(By.xpath(SaveTemplate)).click();
    	
  		Thread.sleep(1000);
  
  		String ToastMessage = obj.getProperty("ToastMessageBar");
  
  		String toastMsg = driver.findElement(By.xpath(ToastMessage)).getText();
    	
  		softassert.assertEquals(toastMsg.contains("Template Updated"), true);
  		
  		softassert.assertAll();
  
  	}
  
    
  	@Test(priority = 13, description = "Delete email campaign template ")
    
  	void deleteemailCampaignTemplate() throws Exception
  
  	{
  		Thread.sleep(1500);
  
  		String DeleteTemplate = obj.getProperty("DeleteTemplateEmail");
  
  		driver.findElement(By.xpath(DeleteTemplate)).click();
    
  		Thread.sleep(500);
    
  		String ConfirmDelete = obj.getProperty("ConfirmDelete");
  		driver.findElement(By.xpath(ConfirmDelete)).click();
    
  		Thread.sleep(1000);
    
  		String ToastMessage = obj.getProperty("ToastMessageBar");
    
  		String toastMsg = driver.findElement(By.xpath(ToastMessage)).getText();
    
  		softassert.assertEquals(toastMsg.contains("Template Deleted"), true);
  		
  		softassert.assertAll();
  
  	}
  
  	@Test(priority = 14, description = "Import email campaign template ")
  	  
  	void importemailCampaignTemplate() throws Exception
  
  	{
  
  		Thread.sleep(1500);
  
  		String ImportTemplate = obj.getProperty("ImportTemplate");
  		driver.findElement(By.xpath(ImportTemplate)).click();
  
  		Thread.sleep(3000);
  
  		String SelectTemplate = obj.getProperty("SelectTemplate");
  		driver.findElement(By.xpath(SelectTemplate)).click();
  
  		Thread.sleep(1000);
  	    softassert.assertAll();
  
  	}

}
