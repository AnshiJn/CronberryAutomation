package CronberryTestng.CronberryTestng.integration;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NewClassForTesting extends BaseClass {

	
	@Test(description="Title of the page")
	public void testFunctitle()
	{
		SoftAssert assertNew= new SoftAssert();

		String title=driver.getTitle();
		
		assertNew.assertTrue(false);
}
}
