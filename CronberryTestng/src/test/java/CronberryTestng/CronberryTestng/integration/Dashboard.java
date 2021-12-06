package CronberryTestng.CronberryTestng.integration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Dashboard extends BaseClass {
	
	@Test(priority=1,description="User logged in successfully",groups= "Dashboard")
	public void DashboardOption() throws Exception{
		
		SoftAssert softassert= new SoftAssert();
		Thread.sleep(2000);
		String value=driver.findElement(By.xpath("//span[contains(text(),'Dashboard')]")).getText();
		System.out.print(value);
		softassert.assertTrue(value.contains("Dashboard"));

	//Select Date for Calender	
		String CalendarDashboard=obj.getProperty("CalendarDashboard");
		driver.findElement(By.xpath(CalendarDashboard)).click();
		Thread.sleep(1000);

		
		
		String CalBack=obj.getProperty("CalBack");
		driver.findElement(By.xpath(CalBack)).click();
		driver.findElement(By.xpath(CalBack)).click();
		driver.findElement(By.xpath(CalBack)).click();
		Thread.sleep(1000);

		
		
		String CalSelect=obj.getProperty("CalSelect");
		driver.findElement(By.xpath(CalSelect)).click();
		Thread.sleep(1000);

		
		
		String CalFwd=obj.getProperty("CalFwd");
		driver.findElement(By.xpath(CalFwd)).click();
		driver.findElement(By.xpath(CalFwd)).click();
		driver.findElement(By.xpath(CalFwd)).click();
		driver.findElement(By.xpath(CalSelect)).click();
		Thread.sleep(1000);
		
		
		String ApplyDate=obj.getProperty("ApplyDate");
		driver.findElement(By.xpath(ApplyDate)).click();
		
		
		
	}
	
	@Test(priority=2,description="Email stats opened successfully",groups= "Dashboard")
	public void DashboardEmail() throws Exception{
		
		SoftAssert softassert= new SoftAssert();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/dashboard-app/main/section/div/div[2]/div[2]/div[1]/div/apx-chart/div[1]/div")).click();
		Thread.sleep(2000);

		String value= driver.findElement(By.xpath("/html/body/modal-container/div/div/div[1]/h4")).getText();
		Thread.sleep(2000);
		String expectedValue="Email Stats";
		System.out.print(value);
		softassert.assertEquals(value, expectedValue);
		driver.findElement(By.xpath("/html/body/modal-container/div/div/div[1]/button")).click();
		softassert.assertAll();
	}
	
	
	@Test(priority=3,description="SMS stats opened successfully",groups= "Dashboard")
	public void DashboardSMSl() throws Exception{
		
		SoftAssert softassert= new SoftAssert();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/dashboard-app/main/section/div/div[2]/div[2]/div[2]/div/apx-chart/div[1]/div")).click();
		Thread.sleep(2000);

		String value= driver.findElement(By.xpath("/html/body/modal-container/div/div/div[1]/h4")).getText();
		Thread.sleep(2000);
		String expectedValue="Sms Stats";
		System.out.print(value);
		softassert.assertEquals(value, expectedValue);
		driver.findElement(By.xpath("/html/body/modal-container/div/div/div[1]/button")).click();
		softassert.assertAll();
	}
	
	@Test(priority=4,description="Push stats opened successfully",groups= "Dashboard")
	public void DashboardPush() throws Exception{
		
		SoftAssert softassert= new SoftAssert();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/dashboard-app/main/section/div/div[2]/div[2]/div[3]/div/apx-chart/div[1]/div")).click();
		Thread.sleep(2000);

		String value= driver.findElement(By.xpath("/html/body/modal-container/div/div/div[1]/h4")).getText();
		Thread.sleep(2000);
		String expectedValue="Push Stats";
		System.out.print(value);
		softassert.assertEquals(value, expectedValue);
		driver.findElement(By.xpath("/html/body/modal-container/div/div/div[1]/button")).click();
		softassert.assertAll();
	}
	
	@Test(priority=5,description="In App stats opened successfully",groups= "Dashboard")
	public void DashboardInApp() throws Exception{
		
		SoftAssert softassert= new SoftAssert();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/dashboard-app/main/section/div/div[2]/div[2]/div[4]/div/apx-chart/div[1]/div")).click();
		Thread.sleep(2000);

		String value= driver.findElement(By.xpath("/html/body/modal-container/div/div/div[1]/h4")).getText();
		Thread.sleep(2000);
		String expectedValue="InApp Stats";
		System.out.print(value);
		softassert.assertEquals(value, expectedValue);
		driver.findElement(By.xpath("/html/body/modal-container/div/div/div[1]/button")).click();
		softassert.assertAll();
	}
	
	
	@Test(priority=6,description="",groups= "Dashboard")
	public void menuOptions() throws Exception{
		
		SoftAssert softassert= new SoftAssert();
		
		Thread.sleep(2000);
		Boolean menuOption1=driver.findElement(By.xpath("//span[contains(text(),'Audience')]")).isDisplayed();
		Boolean menuOption2=driver.findElement(By.xpath("//span[contains(text(),'Catalogue')]")).isDisplayed();
		Boolean menuOption15=driver.findElement(By.xpath("//span[contains(text(),'Catalogue')]")).isDisplayed();
		Boolean menuOption16=driver.findElement(By.xpath("//span[contains(text(),'Catalogue')]")).isDisplayed();
		Boolean menuOption3=driver.findElement(By.xpath("//span[contains(text(),'Landing Page')]")).isDisplayed();
		Boolean menuOption4=driver.findElement(By.xpath("//span[contains(text(),'Announcement')]")).isDisplayed();
		Boolean menuOption5=driver.findElement(By.xpath("//span[contains(text(),'Url Shortner')]")).isDisplayed();
		Boolean menuOption6=driver.findElement(By.xpath("//span[contains(text(),'Campaign Template')]")).isDisplayed();
		Boolean menuOption7=driver.findElement(By.xpath("//span[contains(text(),'Segments')]")).isDisplayed();
		Boolean menuOption8=driver.findElement(By.xpath("//span[contains(text(),'Report')]")).isDisplayed();
		Boolean menuOption9=driver.findElement(By.xpath("//span[contains(text(),'Asset Library')]")).isDisplayed();
		Boolean menuOption10=driver.findElement(By.xpath("//span[contains(text(),'Project Integration')]")).isDisplayed();
		Boolean menuOption11=driver.findElement(By.xpath("//span[contains(text(),'Subscription')]")).isDisplayed();
		Boolean menuOption12=driver.findElement(By.xpath("//span[contains(text(),'User Management')]")).isDisplayed();
		Boolean menuOption13=driver.findElement(By.xpath("//span[contains(text(),'Configuration')]")).isDisplayed();
		Boolean menuOption14=driver.findElement(By.xpath("//span[contains(text(),'Settings')]")).isDisplayed();

		softassert.assertTrue(menuOption1);
		softassert.assertTrue(menuOption2);
		softassert.assertTrue(menuOption3);
		softassert.assertTrue(menuOption4);
		softassert.assertTrue(menuOption5);
		softassert.assertTrue(menuOption6);
		softassert.assertTrue(menuOption7);
		softassert.assertTrue(menuOption8);
		softassert.assertTrue(menuOption9);
		softassert.assertTrue(menuOption10);
		softassert.assertTrue(menuOption11);
		softassert.assertTrue(menuOption12);
		softassert.assertTrue(menuOption13);
		softassert.assertTrue(menuOption14);
		softassert.assertTrue(menuOption15);
		softassert.assertTrue(menuOption16);
		softassert.assertAll();

		
	}
	
	
	
}
