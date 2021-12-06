package CronberryTestng.CronberryTestng.integration;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class announcementPopUp extends BaseClass{

	@Test(priority=1,description="Pop-Up menu opened successfully", groups="Pop-UpAnnouncement")
	public void openPopUpMenu() throws Exception
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Announcement')]")).click();
		Boolean PopUpDisplayed=driver.findElement(By.xpath("//span[contains(text(),'Popup')]")).isDisplayed();
		Assert.assertTrue(PopUpDisplayed);		
	}
	
	
	@Test(priority=2,description="PopUp page opened successfully", groups="PopUpAnnouncement")
	public void openPopUpPage()
	{
		
		driver.findElement(By.xpath("//span[contains(text(),'Popup')]")).click();
		
		Boolean PopUpPage=driver.findElement(By.xpath("//h4[contains(text(),'Popup Notification')]")).isDisplayed();
		
		Assert.assertTrue(PopUpPage);		
	}
	
	
	@Test(priority=3,description="Create PopUp", groups="PopUpAnnouncement")
	public void createPopUp()
	{
		
		driver.findElement(By.xpath("//a[contains(text(),'Create Popup Notification')]")).click();
		
		Boolean value=driver.findElement(By.xpath("//h4[contains(text(),'Create Popup Notification')]")).isDisplayed();
		
		Assert.assertTrue(value);		
	}
	
	

	@Test(priority=4,description="Create PopUp Form", groups="PopUpAnnouncement")

	public void createPopUpForm() throws Exception
	{
		SoftAssert softassert= new SoftAssert();
		
		String templateName=obj.getProperty("templateName");
		
		String parentWindow=driver.getWindowHandle();
		
		System.out.println(parentWindow);
		
		driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(templateName);
		driver.findElement(By.xpath("//button[text()='Select Image / Custom Form']")).click();
		Thread.sleep(1500);
		Boolean value=driver.findElement(By.xpath("//h4[text()='Asset Library']")).isDisplayed();
		Assert.assertTrue(value);		

		driver.findElement(By.xpath("//span[text()='Media List']")).click();
		Thread.sleep(4000);

		
		driver.findElement(By.xpath("//span[@tooltipplacement='top']")).click();
		

		Thread.sleep(3000);
		
		int size = driver.findElements(By.tagName("iframe")).size();
		
		System.out.print(size+"no of frames");
		
		String imagePreviewSrc=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/popup-component/main/section/div[2]/div/form/tabset/div/tab[1]/div/div[2]/div/div/div/div/div/div/img")).getAttribute("src");
		
		String imageSrc	= driver.switchTo().frame(0).findElement(By.xpath("/html/body/span/img")).getAttribute("src");
				
				
		System.out.println(imageSrc+"   "+imagePreviewSrc);
		
		
		softassert.assertEquals(imagePreviewSrc, imageSrc, imagePreviewSrc);
		
		//click on trigger
		
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//span[contains(text(),'Trigger')]")).click();
		
		Date currentDate= new Date();

		//String folderCreateDate=currentDate.toString().substring(0, 10);

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		String strDate= formatter.format(currentDate);

		System.out.println(strDate+" current date");
		Thread.sleep(1000);

		
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/popup-component/main/section/div[2]/div/form/tabset/div/tab[2]/div/div/div[4]/div/div/div[2]/input")).click();
	
		
		driver.findElement(By.xpath("/html/body/bs-datepicker-container/div/div/div/div/bs-days-calendar-view/bs-calendar-layout/div[1]/bs-datepicker-navigation-view/button[4]/span")).click();
		driver.findElement(By.xpath("/html/body/bs-datepicker-container/div/div/div/div/bs-days-calendar-view/bs-calendar-layout/div[1]/bs-datepicker-navigation-view/button[4]/span")).click();
		driver.findElement(By.xpath("/html/body/bs-datepicker-container/div/div/div/div/bs-days-calendar-view/bs-calendar-layout/div[1]/bs-datepicker-navigation-view/button[4]/span")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/bs-datepicker-container/div/div/div/div/bs-days-calendar-view/bs-calendar-layout/div[2]/table/tbody/tr[3]/td[5]/span")).click();		
		Thread.sleep(3000);

		
		//click on On open option button
		
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/popup-component/main/section/div[2]/div/form/tabset/div/tab[2]/div/div/div[1]/div/div/div[1]/label")).click();
		
		
		
	

		
		driver.findElement(By.xpath("//button[contains(text(),'Preview')]")).click();
		
		driver.switchTo().window(driver.getWindowHandle());
		
		
		Thread.sleep(2000);

		
			String previewURL=driver.getCurrentUrl();
				
				
				System.out.println(driver.getCurrentUrl());

		
		
		softassert.assertEquals("https://qa1.cronberry.com/assets/preview.html", previewURL);
		
		driver.switchTo().window(parentWindow);
		
		Thread.sleep(2000);

		
		driver.findElement(By.xpath("//button[text()='Publish']")).click();
		
		Thread.sleep(3000);

		
		driver.findElement(By.xpath("/html/body/modal-container/div/div/form/div/div[2]/div/div/div[1]/button")).click();
		
	    softassert.assertAll();

		
	}

	
	
	@Test(priority=5,description="Delete PopUp Form", groups="PopUpAnnouncement")

	public void deletePopUpForm() throws Exception{
		
		SoftAssert softassert= new SoftAssert();
		
		String DeletePopUp=obj.getProperty("DeletePopUp");
		String ConfirmDeletePopUp=obj.getProperty("ConfirmDeletePopUp");
		
		Thread.sleep(2000);
		
			driver.findElement(By.xpath(DeletePopUp)).click();
			driver.findElement(By.xpath(ConfirmDeletePopUp)).click();
			
		Thread.sleep(2000);
		
		String tm=obj.getProperty("ToastMessageBar");
	
		
		boolean status=driver.findElement(By.xpath(tm)).isDisplayed();

	
		softassert.assertTrue(status);
		

		softassert.assertAll();

		
	}

	

	
	
	
}
