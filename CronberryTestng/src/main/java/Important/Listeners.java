package Important;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.TakesScreenshot;



public class Listeners extends UtilitiesCronberry implements ITestListener {

	public void onTestFailure(ITestResult result){
		
		
		
		System.out.println("test case failed **********************");

	String methodName=result.getMethod().getMethodName().toString().trim();
	
       
   	System.out.println("test case failed #####");

	
	try {
		
		getScreenshot(methodName);
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
	
	
}
