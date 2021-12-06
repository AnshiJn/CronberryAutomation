package Important;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import CronberryTestng.CronberryTestng.integration.BaseClass;
import io.netty.util.internal.SystemPropertyUtil;


public class UtilitiesCronberry extends BaseClass{

	public void getScreenshot(String methodName) throws Exception {
		
		
		Date currentDate= new Date();
		
		String folderCreateDate=currentDate.toString().substring(4, 10);
				
			System.out.println(folderCreateDate);
				 
		String testDate=currentDate.toString().replace(" ", "-").replace(":", "-");
		String screenShotFileName= methodName+" "+testDate;
		File screenshotFile= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile,new File(".//screenshot"+folderCreateDate+"//"+screenShotFileName+".png"));
		
	}
	
	
	
	
}
	

