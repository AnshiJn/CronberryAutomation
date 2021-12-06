package CronberryTestng.CronberryTestng.integration;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class announcementBar extends BaseClass{

	
	@Test(priority=1,description="Bar menu opened successfully", groups="barAnnouncement")
	public void openBarMenu() throws Exception
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Announcement')]")).click();
		Boolean barDisplayed=driver.findElement(By.xpath("//span[contains(text(),'Bar')]")).isDisplayed();
		Assert.assertTrue(barDisplayed);		
	}
	
	
	@Test(priority=2,description="Bar page opened successfully", groups="barAnnouncement")
	public void openBarPage()
	{
		
		driver.findElement(By.xpath("//span[contains(text(),'Bar')]")).click();
		
		Boolean barPage=driver.findElement(By.xpath("//h4[contains(text(),'Bar Notification')]")).isDisplayed();
		
		Assert.assertTrue(barPage);		
	}
	
	
	@Test(priority=3,description="Create Bar", groups="barAnnouncement")
	public void createBar()
	{
		
		driver.findElement(By.xpath("//a[contains(text(),'Create Bar Notification')]")).click();
		
		Boolean value=driver.findElement(By.xpath("//h4[contains(text(),'Create Bar Notification')]")).isDisplayed();
		
		Assert.assertTrue(value);		
	}
	
	

	@Test(priority=4,description="Create Bar Form", groups="barAnnouncement")

	public void createBarForm() throws Exception
	{
		SoftAssert softassert= new SoftAssert();
		
		String templateName=obj.getProperty("templateName");
		
		String parentWindow=driver.getWindowHandle();
		
		System.out.println(parentWindow);
		
		driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(templateName);
		driver.findElement(By.xpath("//button[text()='Select Image']")).click();
		Thread.sleep(1500);
		Boolean value=driver.findElement(By.xpath("//h4[text()='Asset Library']")).isDisplayed();
		Assert.assertTrue(value);		

		driver.findElement(By.xpath("//span[text()='Media List']")).click();
		Thread.sleep(4000);

		
		driver.findElement(By.xpath("//span[@tooltipplacement='top']")).click();
		

		Thread.sleep(4000);
		
		int size = driver.findElements(By.tagName("iframe")).size();
		
		System.out.print(size+"no of frames");
		
		String imagePreviewSrc=driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/bar-component/main/section/div[2]/div/form/tabset/div/tab[1]/div/div[2]/div/div/div/div/div/div/img")).getAttribute("src");

		
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

		
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/bar-component/main/section/div[2]/div/form/tabset/div/tab[2]/div/div/div[5]/div/div/div[2]/input")).click();
		driver.findElement(By.xpath("/html/body/bs-datepicker-container/div/div/div/div/bs-days-calendar-view/bs-calendar-layout/div[1]/bs-datepicker-navigation-view/button[4]/span")).click();
		driver.findElement(By.xpath("/html/body/bs-datepicker-container/div/div/div/div/bs-days-calendar-view/bs-calendar-layout/div[1]/bs-datepicker-navigation-view/button[4]/span")).click();
		driver.findElement(By.xpath("/html/body/bs-datepicker-container/div/div/div/div/bs-days-calendar-view/bs-calendar-layout/div[1]/bs-datepicker-navigation-view/button[4]/span")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/bs-datepicker-container/div/div/div/div/bs-days-calendar-view/bs-calendar-layout/div[2]/table/tbody/tr[3]/td[5]/span")).click();		
		Thread.sleep(3000);

		
		driver.findElement(By.xpath("//button[contains(text(),'Preview')]")).click();
		
		Thread.sleep(1000);

		
		driver.switchTo().window(parentWindow);

		
		driver.findElement(By.xpath("//button[contains(text(),'Preview')]")).click();

		
		Thread.sleep(2000);
		Thread.sleep(2000);
		
		Boolean barDisplayed=driver.findElement(By.xpath("/html/body/div")).isDisplayed();
		
		softassert.assertTrue(barDisplayed);
	
		driver.switchTo().window(parentWindow);
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[text()='Publish']")).click();
		
		Thread.sleep(3000);

		
		driver.findElement(By.xpath("/html/body/modal-container/div/div/form/div/div[2]/div/div/div[1]/button")).click();
		
	    softassert.assertAll();
	
	    
	}

	
	
	@Test(priority=5,description="Delete Bar Form", groups="barAnnouncement")

	public void deleteBarForm() throws Exception{
		
		SoftAssert softassert= new SoftAssert();
		
		String DeleteBar=obj.getProperty("DeleteBar");
		String ConfirmDeleteBar=obj.getProperty("ConfirmDeleteBar");
		
		Thread.sleep(1000);
		
			driver.findElement(By.xpath(DeleteBar)).click();
			driver.findElement(By.xpath(ConfirmDeleteBar)).click();
			
		Thread.sleep(1000);
		
		String tm=obj.getProperty("ToastMessageBar");
	
		
		boolean status=driver.findElement(By.xpath(tm)).isDisplayed();

	
		softassert.assertTrue(status);
		

		softassert.assertAll();

		
	}

	
	
	
	
	
	
	
}
