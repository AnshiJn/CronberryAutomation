package CronberrySignin;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import au.com.bytecode.opencsv.CSVReader;
//import au.com.bytecode.opencsv.CSVWriter;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class SigninCSV {

	public static void main(String[] args) throws Exception {
		// Signinpage();
		// Forgotp();
		// SMScampaign();
		// AssetLibrary();
		// PushnotificationDelete();
		// EmailTempDelete();
		// Catalogues();
		// AnnouncementBar();
		// CatalogueProducts();
		// Analysis();
		// Segment();
		Configuration();
	}

	public static void Signinpage() throws Exception {

		System.setProperty("webdriver.chrome.driver", "/Users/alcodesmobility/Desktop/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev1.cronberry.com");

		InputStream input = SigninCSV.class.getClassLoader().getResourceAsStream("cronberry.properties");
		Properties obj = new Properties();
		obj.load(input);
		Thread.sleep(3000);

		String Login = obj.getProperty("login");
		driver.findElement(By.xpath(Login)).click();
		Thread.sleep(3000);

		String Sin = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		java.util.Iterator<String> iterator = allWindowHandles.iterator();

		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!Sin.equalsIgnoreCase(ChildWindow)) {

				driver.switchTo().window(ChildWindow);
				// WebElement text = driver.findElement(By.id("sampleHeading"));

			}
		}

//   	 String Signin1 = obj.getProperty("signin");
//   	 driver.findElement(By.xpath(Signin1)).click();
		Thread.sleep(2000);

		String mainWindowHandle = driver.getWindowHandle();

		String SignIn = driver.getWindowHandle();
		Set<String> allWindowHandles1 = driver.getWindowHandles();
		java.util.Iterator<String> iterator1 = allWindowHandles1.iterator();

		while (iterator1.hasNext()) {
			String ChildWindow1 = iterator1.next();
			if (!SignIn.equalsIgnoreCase(ChildWindow1)) {
			}
		}
		String SignIN = obj.getProperty("signIN");
		driver.findElement(By.xpath(SignIN)).click();
		Thread.sleep(2000);

		String Email = driver.getWindowHandle();
		Set<String> allWindowHandles2 = driver.getWindowHandles();
		java.util.Iterator<String> iterator2 = allWindowHandles2.iterator();

		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {

				driver.switchTo().window(ChildWindow);

			}
		}

		Thread.sleep(5000);

		String emailid = obj.getProperty("emailid");
		String password = obj.getProperty("password");
		String submit = obj.getProperty("signIN");

		WebElement emailid1 = driver.findElement(By.xpath(emailid));
		WebElement password1 = driver.findElement(By.xpath(password));
		WebElement submit1 = driver.findElement(By.xpath(submit));

		submit1.click();
		String toast = obj.getProperty("error1");
		WebElement toast1 = driver.findElement(By.xpath(toast));
		Thread.sleep(5000);

		CSVReader reader = new CSVReader(new FileReader(
				"/Users/alcodesmobility/eclipse-workspace/CronberryTestAutomation/CSV Sheets/CSVdata - Sheet1.csv"));

		List<String[]> list = reader.readAll();

		System.out.println("Total rows which we have is " + list.size());

		int i, j;

		for (i = 1; i <= list.size() - 1; i++) {
			Thread.sleep(3000);

			for (j = 1; j <= 3; j++) {
				String[] thirdRow = list.get(i);
				emailid1.sendKeys(thirdRow[j]);
				System.out.println(thirdRow[j]);

				password1.sendKeys(thirdRow[j + 1]);
				System.out.println(thirdRow[j + 1]);

				submit1.click();
				emailid1.clear();
				password1.clear();
				Thread.sleep(1000);
				break;
			}
			Thread.sleep(1000);

			// emailid1.clear();
			// password1.clear();

			String alert = toast1.getText();

			if (alert.contains("Already Exist") || alert.contains("Error") || alert.contains("Please fill"))

			{

				list.get(i)[3] = alert;

				list.get(i)[4] = "Pass";
			}

			else {
				list.get(i)[3] = alert;

				list.get(i)[4] = "Fail";

			}
			Thread.sleep(5000);
			// emailid1.clear();
			// password1.clear();

		}

		reader.close();
		CSVWriter writer = new CSVWriter(new FileWriter(new File(
				"‎⁨/Users/alcodesmobility/eclipse-workspace/CronberryTestAutomation/CSV Sheets⁩/CSVdata - Sheet1.csv")));
		writer.writeAll(list);
		writer.flush();
		writer.close();
		Thread.sleep(5000);
		driver.close();

	}

	// *******

	public static void Forgotp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/alcodesmobility/Desktop/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev1.cronberry.com");

		InputStream input = SigninCSV.class.getClassLoader().getResourceAsStream("cronberry.properties");
		Properties obj = new Properties();
		obj.load(input);
		Thread.sleep(3000);

		String Login = obj.getProperty("login");
		driver.findElement(By.xpath(Login)).click();
		Thread.sleep(3000);

		String Sin = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		java.util.Iterator<String> iterator = allWindowHandles.iterator();
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!Sin.equalsIgnoreCase(ChildWindow)) {

				driver.switchTo().window(ChildWindow);
			}
		}

//   	 String Signin1 = obj.getProperty("signin");
//   	 driver.findElement(By.xpath(Signin1)).click();
		Thread.sleep(2000);

		String mainWindowHandle = driver.getWindowHandle();

		String SignIn = driver.getWindowHandle();
		Set<String> allWindowHandles1 = driver.getWindowHandles();
		java.util.Iterator<String> iterator1 = allWindowHandles1.iterator();
		while (iterator1.hasNext()) {
			String ChildWindow1 = iterator1.next();
			if (!SignIn.equalsIgnoreCase(ChildWindow1)) {
			}
		}
		Thread.sleep(2000);

		String Email = driver.getWindowHandle();
		Set<String> allWindowHandles2 = driver.getWindowHandles();
		java.util.Iterator<String> iterator2 = allWindowHandles2.iterator();
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {

				driver.switchTo().window(ChildWindow);

			}
		}

		String FP = obj.getProperty("ForgotPw");
		WebElement FP1 = driver.findElement(By.xpath(FP));
		FP1.click();
		Thread.sleep(3000);

		String FEmail = obj.getProperty("ForgotEmail");
		WebElement FE1 = driver.findElement(By.xpath(FEmail));

		String Submit = obj.getProperty("submit");
		WebElement submit1 = driver.findElement(By.xpath(Submit));
		submit1.click();
		Thread.sleep(3000);

		String toast2 = obj.getProperty("error2");
		WebElement toast3 = driver.findElement(By.xpath(toast2));

		CSVReader reader = new CSVReader(new FileReader(
				"/Users/alcodesmobility/eclipse-workspace/CronberryTestAutomation/CSV Sheets/forgotcsv - Sheet1.csv"));

		List<String[]> list = reader.readAll();

		System.out.println("Total rows which we have is " + list.size());

		int i, j;

		for (i = 1; i <= list.size() - 1; i++) {
			Thread.sleep(3000);
			// System.out.println("test");

			for (j = 1; j <= 3; j++) {
				// System.out.println("test");

				String[] thirdRow = list.get(i);
				FE1.sendKeys(thirdRow[j]);
				System.out.println(thirdRow[j]);
				// System.out.println("test");

				submit1.click();
				Thread.sleep(1000);
				break;
			}
			Thread.sleep(1000);

			FE1.clear();

			String alert = toast3.getText();

			if (alert.contains("Error") || alert.contains("Please fill") || alert.contains("Success"))

			{

				list.get(i)[2] = alert;

				list.get(i)[3] = "Pass";
			}

			else {
				list.get(i)[2] = alert;

				list.get(i)[3] = "Fail";

			}
			Thread.sleep(3000);
			FE1.clear();

		}
		reader.close();
		Thread.sleep(3000);
		CSVWriter writer = new CSVWriter(new FileWriter(new File(
				"/Users/alcodesmobility/eclipse-workspace/CronberryTestAutomation/CSV Sheets/forgotcsv - Sheet1.csv")));
		writer.writeAll(list);
		writer.flush();
		writer.close();
		Thread.sleep(3000);
		System.out.println("test");
//    driver.close();

	}

//********

	public static void SMScampaign() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/alcodesmobility/Desktop/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://qa1.cronberry.com");

		InputStream input = SigninCSV.class.getClassLoader().getResourceAsStream("cronberry.properties");
		Properties obj = new Properties();
		obj.load(input);
		Thread.sleep(3000);

		String Login = obj.getProperty("login");
		driver.findElement(By.xpath(Login)).click();
		Thread.sleep(3000);

		String Sin = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		java.util.Iterator<String> iterator = allWindowHandles.iterator();
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!Sin.equalsIgnoreCase(ChildWindow)) {

				driver.switchTo().window(ChildWindow);
			}
		}

//   	 String Signin1 = obj.getProperty("signin");
//   	 driver.findElement(By.xpath(Signin1)).click();
		Thread.sleep(2000);

		String mainWindowHandle = driver.getWindowHandle();

		String SignIn = driver.getWindowHandle();
		Set<String> allWindowHandles1 = driver.getWindowHandles();
		java.util.Iterator<String> iterator1 = allWindowHandles1.iterator();
		while (iterator1.hasNext()) {
			String ChildWindow1 = iterator1.next();
			if (!SignIn.equalsIgnoreCase(ChildWindow1)) {
			}
		}
		Thread.sleep(2000);

		String Email = driver.getWindowHandle();
		Set<String> allWindowHandles2 = driver.getWindowHandles();
		java.util.Iterator<String> iterator2 = allWindowHandles2.iterator();
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {

				driver.switchTo().window(ChildWindow);

			}
		}
		Thread.sleep(2000);

		String emailid = obj.getProperty("emailid");
		String password = obj.getProperty("password");
		String submit = obj.getProperty("signIN");

		WebElement emailid1 = driver.findElement(By.xpath(emailid));
		emailid1.sendKeys("newusersix@mailinator.com");
		WebElement password1 = driver.findElement(By.xpath(password));
		password1.sendKeys("12345");
		WebElement submit1 = driver.findElement(By.xpath(submit));
		submit1.click();

		Thread.sleep(5000);
		String CT = obj.getProperty("CampaignTemplate");
		String SMSC = obj.getProperty("SMSCampaign");
		String CreateT = obj.getProperty("CreateTemplate");
		String SaveS = "/html/body/modal-container/div/div/form/div/div[2]/div/div[1]/div[4]/button";
		String TempN = obj.getProperty("TempName");
		String Dvalues = obj.getProperty("Dynvalues");
		String Msg = obj.getProperty("Msgbox");
		String Cdvalues = obj.getProperty("Cleardvalues");
		String Attach = obj.getProperty("Attachment");
		String Media = obj.getProperty("MediaName");
		String file = obj.getProperty("File");
		String Upload = obj.getProperty("Choosefile");
		String Savem = obj.getProperty("SaveM");
		String mediaselect = obj.getProperty("mselect");
//   	 String type = obj.getProperty("File");
//   	 String medialist = obj.getProperty("Medialist");
//   	 String Imageone = obj.getProperty("Image1");
//   	 String customf = obj.getProperty("CustomF");
//   	 String form1 = obj.getProperty("CF1");
//   	 String Simage = obj.getProperty("SearchImage");
//   	 String search = obj.getProperty("Searchbutton");

		WebElement CT1 = driver.findElement(By.xpath(CT));
		CT1.click();
		Thread.sleep(2000);
		WebElement SMSC1 = driver.findElement(By.xpath(SMSC));
		SMSC1.click();
		WebElement CreateT1 = driver.findElement(By.xpath(CreateT));
		CreateT1.click();
		String SmsE = obj.getProperty("Smserror");
		CSVReader reader = new CSVReader(new FileReader(
				"/Users/alcodesmobility/eclipse-workspace/CronberryTestAutomation/CSV Sheets/SMSCSV - Sheet1.csv"));

		List<String[]> list = reader.readAll();
		System.out.println("Total rows which we have is " + list.size());

		int i, j;

		for (i = 1; i <= list.size() - 1; i++) {
			Thread.sleep(3000);
			System.out.println("test1");
			WebElement TempN1 = driver.findElement(By.xpath(TempN));
			System.out.println("test2");
			Thread.sleep(3000);
			WebElement Dvalues1 = driver.findElement(By.xpath(Dvalues));
			System.out.println("test3");
			Thread.sleep(2000);
			WebElement MsgB = driver.findElement(By.xpath(Msg));
			System.out.println("test4");
			Thread.sleep(5000);
			WebElement Attach1 = driver.findElement(By.xpath(Attach));
			Thread.sleep(5000);

			WebElement SaveB = driver.findElement(By.xpath(SaveS));
			SaveB.click();

			Thread.sleep(1000);
			System.out.println("test5");

			WebElement SmsE1 = driver.findElement(By.xpath(SmsE));
			System.out.println("errortest");
			Thread.sleep(2000);

			for (j = 1; j <= 1; j++) {
				// System.out.println("test");

				String[] thirdRow = list.get(i);
				TempN1.sendKeys(thirdRow[j]);
				System.out.println(thirdRow[j]);

				Dvalues1.sendKeys(thirdRow[j + 1]);
				Dvalues1.sendKeys(Keys.ENTER);
				System.out.println(thirdRow[j + 1]);

				MsgB.sendKeys(thirdRow[j + 2]);
				System.out.println(thirdRow[j + 2]);
				// System.out.println("test");
				Thread.sleep(3000);

				Attach1.click();
				Thread.sleep(3000);
				System.out.println("tesdfdft");
				WebElement Medianame = driver.findElement(By.xpath(Media));

				Thread.sleep(3000);

				if (thirdRow[j + 3].isEmpty())

				{
				}

				else {

				}
				Medianame.sendKeys(thirdRow[j + 3]);
				Thread.sleep(3000);
				// driver.findElement(By.xpath(file)).click();
				WebElement ChooseFile1 = driver.findElement(By.xpath(Upload));
				Thread.sleep(3000);

//   				 driver.findElement(By.xpath(medialist)).click();
//   				 Thread.sleep(3000);
//   				 driver.findElement(By.xpath(Imageone)).click();
//   				 Thread.sleep(3000);
//   				 driver.findElement(By.xpath(customf)).click();
//   				 Thread.sleep(3000);
//   				 driver.findElement(By.xpath(form1)).click();
//   				 Thread.sleep(3000);
				System.out.println("tesd1212t");
				ChooseFile1.sendKeys(thirdRow[j + 4]);
				Thread.sleep(5000);
				driver.findElement(By.xpath(Savem)).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath(mediaselect)).click();
				Thread.sleep(2000);
//   				 Thread.sleep(2000);
//   				 SaveB.click();
				Thread.sleep(2000);
				String alert = SmsE1.getText();
				Thread.sleep(2000);

				if (alert.contains("Error") || alert.contains("Please fill") || alert.contains("Success"))

				{

					list.get(i)[6] = alert;

					list.get(i)[7] = "Pass";

					driver.findElement(By.xpath(Cdvalues)).click();
					System.out.println("test6");
				} else if (alert.contains("Template")) {

					list.get(i)[6] = alert;

					list.get(i)[7] = "Pass";

					Thread.sleep(5000);
					driver.findElement(By.xpath(CreateT)).click();
					Thread.sleep(5000);
					driver.findElement(By.xpath(SaveS)).click();

				}

				else {
					list.get(i)[6] = alert;

					list.get(i)[7] = "Fail";

					driver.findElement(By.xpath(Cdvalues)).click();
					System.out.println("test7");

					Thread.sleep(2000);

					TempN1.clear();
					// driver.findElement(By.xpath(Cdvalues)).click();
					Thread.sleep(2000);
					MsgB.clear();

				}
			}
		}
		reader.close();
		Thread.sleep(3000);
		CSVWriter writer = new CSVWriter(new FileWriter(new File(
				"/Users/alcodesmobility/eclipse-workspace/CronberryTestAutomation/CSV Sheets/SMSCSV - Sheet1.csv")));
		writer.writeAll(list);
		writer.flush();
		writer.close();

		driver.close();
		// ********* without csv flow ******////////

//   	 WebElement TempN1 = driver.findElement(By.xpath(TempN));
//   	 TempN1.sendKeys("piatest");
//   	 Thread.sleep(2000);
//
//   	 WebElement Dvalues1 = driver.findElement(By.xpath(Dvalues));
//   	 Dvalues1.click();
//   	 Dvalues1.sendKeys("Email");
//   	 Dvalues1.sendKeys(Keys.ENTER);
//   	 
//   	 Thread.sleep(2000);
//   	 Dvalues1.click();
//   	 Dvalues1.sendKeys("Phone Number");
//   	 Dvalues1.sendKeys(Keys.ENTER);
//   	 
//   	 Thread.sleep(2000);
//   	 WebElement MsgB = driver.findElement(By.xpath(Msg));
//   	 MsgB.sendKeys(" 	Hello this is for testing ");;
//   	 Thread.sleep(2000);
//   	 
//   	 WebElement AttachI = driver.findElement(By.xpath(Attach));
//   	 AttachI.click();
//   	 Thread.sleep(5000);

		// uploadiamge
//   	 WebElement Mtext = driver.findElement(By.xpath(Media));
//   	 Mtext.sendKeys("testimage");
//   	 Thread.sleep(2000);
//
//   	 WebElement Typef = driver.findElement(By.xpath(type));
//   	 Typef.click();
//   	 Thread.sleep(2000);
//
//   	 WebElement Uploadfile = driver.findElement(By.xpath(Upload));
//   	 Uploadfile.sendKeys("/Users/itipriyaparashar/Desktop/forgotcsv - Sheet1.csv");
//
//   	 WebElement Savem1 = driver.findElement(By.xpath(Savem));
//   	 Savem1.click();

		// Medialist
//   	 	WebElement Mlist = driver.findElement(By.xpath(medialist));
//   	 	Mlist.click();
//   	 	Thread.sleep(2000);
//        	WebElement image = driver.findElement(By.xpath(Imageone));
//        	image.click();
		// serachimage
//   			 WebElement searchI = driver.findElement(By.xpath(Simage));
//   			 searchI.sendKeys("ArrowNewImage");
//   			 WebElement sbutton = driver.findElement(By.xpath(search));
//   			 sbutton.click();
//   			 Thread.sleep(2000);
//   	     	WebElement image = driver.findElement(By.xpath(Imageone));
//   	     	image.click();

		// customform
//   	 WebElement cform = driver.findElement(By.xpath(customf));
//   	 cform.click();
//   	 Thread.sleep(2000);
//   	 WebElement Cform1 = driver.findElement(By.xpath(form1));
//   	 Cform1.click();

		Thread.sleep(2000);
		// SaveB.click();

		// ***** delete SMS templates *****/////

//   	 String Dsms = obj.getProperty("DeleteS");
//   	 String dissms = obj.getProperty("DismissS");
//   	 String Yes = obj.getProperty("YesS");
//   	 Thread.sleep(2000);
//   	 driver.findElement(By.xpath(Dsms)).click();
//   	 Thread.sleep(2000);
//   	 driver.findElement(By.xpath(Yes)).click();
//   	 Thread.sleep(5000);
//   	 System.out.println("1");
//   	 driver.findElement(By.xpath(Dsms)).click();
//   	 Thread.sleep(2000);
//   	 driver.findElement(By.xpath(Yes)).click();
//   	 Thread.sleep(5000);
//   	 System.out.println("2");
//   	 driver.findElement(By.xpath(Dsms)).click();
//   	 Thread.sleep(2000);
//   	 driver.findElement(By.xpath(Yes)).click();
//   	 Thread.sleep(5000);
//   	 System.out.println("3");
//   	 driver.findElement(By.xpath(Dsms)).click();
//   	 Thread.sleep(2000);
//   	 driver.findElement(By.xpath(Yes)).click();
//   	 Thread.sleep(5000);
//   	 System.out.println("4");
//   	 driver.findElement(By.xpath(Dsms)).click();
//   	 Thread.sleep(2000);
//   	 driver.findElement(By.xpath(Yes)).click();
//   	 Thread.sleep(5000);
//   	 System.out.println("5");
//   	 driver.findElement(By.xpath(Dsms)).click();
//   	 Thread.sleep(2000);
//   	 driver.findElement(By.xpath(dissms)).click();
//   	 Thread.sleep(5000);
//   	 System.out.println("6");
		// driver.findElement(By.xpath(Dsms)).click();
//   	 Thread.sleep(2000);
//   	 driver.findElement(By.xpath(Yes)).click();
//   	 Thread.sleep(5000);
//   	 System.out.println("6");    

	}

//*********

	public static void AssetLibrary() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/alcodesmobility/Desktop/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://qa1.cronberry.com/");

		InputStream input = SigninCSV.class.getClassLoader().getResourceAsStream("cronberry.properties");
		Properties obj = new Properties();
		obj.load(input);
		Thread.sleep(3000);

		String Login = obj.getProperty("login");
		driver.findElement(By.xpath(Login)).click();
		Thread.sleep(3000);

		String Sin = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		java.util.Iterator<String> iterator = allWindowHandles.iterator();
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!Sin.equalsIgnoreCase(ChildWindow)) {

				driver.switchTo().window(ChildWindow);
			}
		}

//    String Signin1 = obj.getProperty("signin");
//    driver.findElement(By.xpath(Signin1)).click();
		Thread.sleep(2000);

		String mainWindowHandle = driver.getWindowHandle();

		String SignIn = driver.getWindowHandle();
		Set<String> allWindowHandles1 = driver.getWindowHandles();
		java.util.Iterator<String> iterator1 = allWindowHandles1.iterator();
		while (iterator1.hasNext()) {
			String ChildWindow1 = iterator1.next();
			if (!SignIn.equalsIgnoreCase(ChildWindow1)) {
			}
		}
		Thread.sleep(2000);

		String Email = driver.getWindowHandle();
		Set<String> allWindowHandles2 = driver.getWindowHandles();
		java.util.Iterator<String> iterator2 = allWindowHandles2.iterator();
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {

				driver.switchTo().window(ChildWindow);

			}
		}
		Thread.sleep(2000);

		String emailid = obj.getProperty("emailid");
		String password = obj.getProperty("password");
		String submit = obj.getProperty("signIN");
		String asset = obj.getProperty("Assetlibrary");
		String delete = obj.getProperty("Delete");
		String Yes = obj.getProperty("yes");
		String dismiss = obj.getProperty("Dismiss");

		WebElement emailid1 = driver.findElement(By.xpath(emailid));
		emailid1.sendKeys("newusersix@mailinator.com");
		WebElement password1 = driver.findElement(By.xpath(password));
		password1.sendKeys("12345");
		WebElement submit1 = driver.findElement(By.xpath(submit));
		submit1.click();

		Thread.sleep(2000);
		WebElement assetclick = driver.findElement(By.xpath(asset));
		assetclick.click();
		Thread.sleep(2000);

		WebElement deleteA = driver.findElement(By.xpath(delete));
		deleteA.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(Yes)).click();
		System.out.println("1");
		Thread.sleep(5000);
		driver.findElement(By.xpath(delete)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Yes)).click();
		System.out.println("2");
		Thread.sleep(5000);
		driver.findElement(By.xpath(delete)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Yes)).click();
		System.out.println("3");
		Thread.sleep(5000);
		driver.findElement(By.xpath(delete)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Yes)).click();
		System.out.println("4");
		Thread.sleep(5000);
		driver.findElement(By.xpath(delete)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Yes)).click();
		System.out.println("5");
		Thread.sleep(5000);
		driver.findElement(By.xpath(delete)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Yes)).click();
		System.out.println("6");
		Thread.sleep(5000);
		driver.findElement(By.xpath(delete)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Yes)).click();
		System.out.println("7");
		Thread.sleep(5000);
		driver.findElement(By.xpath(delete)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Yes)).click();
		System.out.println("8");
		Thread.sleep(5000);
		driver.findElement(By.xpath(delete)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Yes)).click();
		System.out.println("9");
		Thread.sleep(5000);
		driver.findElement(By.xpath(delete)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(dismiss)).click();
		System.out.println("10");
		Thread.sleep(2000);
		driver.findElement(By.xpath(delete)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Yes)).click();
		System.out.println("10");
		System.out.println("Media deleted successfully");
		driver.close();

	}

//**********

	public static void PushnotificationDelete() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/alcodesmobility/Desktop/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev1.cronberry.com");

		InputStream input = SigninCSV.class.getClassLoader().getResourceAsStream("cronberry.properties");
		Properties obj = new Properties();
		obj.load(input);
		Thread.sleep(3000);

		String Login = obj.getProperty("login");
		driver.findElement(By.xpath(Login)).click();
		Thread.sleep(3000);

		String Sin = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		java.util.Iterator<String> iterator = allWindowHandles.iterator();
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!Sin.equalsIgnoreCase(ChildWindow)) {

				driver.switchTo().window(ChildWindow);
			}
		}

//    String Signin1 = obj.getProperty("signin");
//    driver.findElement(By.xpath(Signin1)).click();
		Thread.sleep(2000);

		String mainWindowHandle = driver.getWindowHandle();

		String SignIn = driver.getWindowHandle();
		Set<String> allWindowHandles1 = driver.getWindowHandles();
		java.util.Iterator<String> iterator1 = allWindowHandles1.iterator();
		while (iterator1.hasNext()) {
			String ChildWindow1 = iterator1.next();
			if (!SignIn.equalsIgnoreCase(ChildWindow1)) {
			}
		}
		Thread.sleep(2000);

		String Email = driver.getWindowHandle();
		Set<String> allWindowHandles2 = driver.getWindowHandles();
		java.util.Iterator<String> iterator2 = allWindowHandles2.iterator();
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {

				driver.switchTo().window(ChildWindow);

			}
		}
		Thread.sleep(2000);
		String emailid = obj.getProperty("emailid");
		String password = obj.getProperty("password");
		String submit = obj.getProperty("signIN");
		String CT = obj.getProperty("CampaignTemplate");
		String PushN = obj.getProperty("PushNotification");
		String PushD = obj.getProperty("PushDelete");
		String PushY = obj.getProperty("PushYes");
		String PushDis = obj.getProperty("PushDis");

		Thread.sleep(2000);
		WebElement emailid1 = driver.findElement(By.xpath(emailid));
		emailid1.sendKeys("testingprofile@mailinator.com");
		WebElement password1 = driver.findElement(By.xpath(password));
		password1.sendKeys("123456");
		Thread.sleep(2000);
		WebElement submit1 = driver.findElement(By.xpath(submit));
		submit1.click();
		Thread.sleep(5000);
		WebElement CT1 = driver.findElement(By.xpath(CT));
		CT1.click();
		Thread.sleep(5000);
		WebElement PushN1 = driver.findElement(By.xpath(PushN));
		PushN1.click();

		Thread.sleep(5000);
		driver.findElement(By.xpath(PushD)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(PushY)).click();
		System.out.println("1");
		Thread.sleep(5000);
		driver.findElement(By.xpath(PushD)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(PushY)).click();
		System.out.println("2");
		Thread.sleep(5000);
		driver.findElement(By.xpath(PushD)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(PushY)).click();
		System.out.println("3");
		Thread.sleep(5000);
		driver.findElement(By.xpath(PushD)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(PushY)).click();
		System.out.println("4");
		Thread.sleep(5000);
		driver.findElement(By.xpath(PushD)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(PushY)).click();
		System.out.println("5");
		Thread.sleep(5000);
		driver.findElement(By.xpath(PushD)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(PushY)).click();
		System.out.println("6");
		Thread.sleep(5000);
		driver.findElement(By.xpath(PushD)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(PushY)).click();
		System.out.println("7");
		Thread.sleep(5000);
		driver.findElement(By.xpath(PushD)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(PushY)).click();
		System.out.println("8");
		Thread.sleep(5000);
		driver.findElement(By.xpath(PushD)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(PushY)).click();
		System.out.println("9");
		Thread.sleep(5000);
		driver.findElement(By.xpath(PushD)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(PushDis)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(PushD)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(PushY)).click();
		System.out.println("10");
		System.out.println("Push template deleted successfully");
		driver.close();

	}

//*******

	public static void EmailTempDelete() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/alcodesmobility/Desktop/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev1.cronberry.com");

		InputStream input = SigninCSV.class.getClassLoader().getResourceAsStream("cronberry.properties");
		Properties obj = new Properties();
		obj.load(input);
		Thread.sleep(3000);

		String Login = obj.getProperty("login");
		driver.findElement(By.xpath(Login)).click();
		Thread.sleep(3000);

		String Sin = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		java.util.Iterator<String> iterator = allWindowHandles.iterator();
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!Sin.equalsIgnoreCase(ChildWindow)) {

				driver.switchTo().window(ChildWindow);
			}
		}

//    String Signin1 = obj.getProperty("signin");
//    driver.findElement(By.xpath(Signin1)).click();
		Thread.sleep(2000);

		String mainWindowHandle = driver.getWindowHandle();

		String SignIn = driver.getWindowHandle();
		Set<String> allWindowHandles1 = driver.getWindowHandles();
		java.util.Iterator<String> iterator1 = allWindowHandles1.iterator();
		while (iterator1.hasNext()) {
			String ChildWindow1 = iterator1.next();
			if (!SignIn.equalsIgnoreCase(ChildWindow1)) {
			}
		}
		Thread.sleep(2000);

		String Email = driver.getWindowHandle();
		Set<String> allWindowHandles2 = driver.getWindowHandles();
		java.util.Iterator<String> iterator2 = allWindowHandles2.iterator();
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {

				driver.switchTo().window(ChildWindow);

			}
		}
		Thread.sleep(2000);
		String emailid = obj.getProperty("emailid");
		String password = obj.getProperty("password");
		String submit = obj.getProperty("signIN");
		String CT = obj.getProperty("CampaignTemplate");
		String EmailTemp = obj.getProperty("Emailtemp");
		String EmailD = obj.getProperty("Emaildelete");
		String EmailY = obj.getProperty("EmailYes");
		String EmailDis = obj.getProperty("EmailDis");

		Thread.sleep(2000);
		WebElement emailid1 = driver.findElement(By.xpath(emailid));
		emailid1.sendKeys("testingprofile@mailinator.com");
		WebElement password1 = driver.findElement(By.xpath(password));
		password1.sendKeys("123456");
		Thread.sleep(2000);
		WebElement submit1 = driver.findElement(By.xpath(submit));
		submit1.click();
		Thread.sleep(5000);
		WebElement CT1 = driver.findElement(By.xpath(CT));
		CT1.click();
		Thread.sleep(5000);
		WebElement EmailTemp1 = driver.findElement(By.xpath(EmailTemp));
		EmailTemp1.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(EmailD)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(EmailY)).click();
		System.out.println("1");
		Thread.sleep(5000);
		driver.findElement(By.xpath(EmailD)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(EmailY)).click();
		System.out.println("2");
		Thread.sleep(5000);
		driver.findElement(By.xpath(EmailD)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(EmailY)).click();
		System.out.println("3");
		Thread.sleep(5000);
		driver.findElement(By.xpath(EmailD)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(EmailY)).click();
		System.out.println("4");
		Thread.sleep(5000);
		driver.findElement(By.xpath(EmailD)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(EmailY)).click();
		System.out.println("5");
		Thread.sleep(5000);
		driver.findElement(By.xpath(EmailD)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(EmailY)).click();
		System.out.println("6");
		Thread.sleep(5000);
		driver.findElement(By.xpath(EmailD)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(EmailY)).click();
		System.out.println("7");
		Thread.sleep(5000);
		driver.findElement(By.xpath(EmailD)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(EmailY)).click();
		System.out.println("8");
		Thread.sleep(5000);
		driver.findElement(By.xpath(EmailD)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(EmailY)).click();
		System.out.println("9");
		Thread.sleep(5000);
		driver.findElement(By.xpath(EmailD)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(EmailDis)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(EmailD)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(EmailY)).click();
		System.out.println("10 done ");
		driver.close();

	}

//********

	public static void Catalogues() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/alcodesmobility/Desktop/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cronberry.com/");

		InputStream input = SigninCSV.class.getClassLoader().getResourceAsStream("cronberry.properties");
		Properties obj = new Properties();
		obj.load(input);
		Thread.sleep(3000);

		String Login = obj.getProperty("login");
		driver.findElement(By.xpath(Login)).click();
		Thread.sleep(3000);

		String Sin = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		java.util.Iterator<String> iterator = allWindowHandles.iterator();
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!Sin.equalsIgnoreCase(ChildWindow)) {

				driver.switchTo().window(ChildWindow);
			}
		}

//    String Signin1 = obj.getProperty("signin");
//    driver.findElement(By.xpath(Signin1)).click();
		Thread.sleep(2000);

		String mainWindowHandle = driver.getWindowHandle();

		String SignIn = driver.getWindowHandle();
		Set<String> allWindowHandles1 = driver.getWindowHandles();
		java.util.Iterator<String> iterator1 = allWindowHandles1.iterator();
		while (iterator1.hasNext()) {
			String ChildWindow1 = iterator1.next();
			if (!SignIn.equalsIgnoreCase(ChildWindow1)) {
			}
		}
		Thread.sleep(2000);

		String Email = driver.getWindowHandle();
		Set<String> allWindowHandles2 = driver.getWindowHandles();
		java.util.Iterator<String> iterator2 = allWindowHandles2.iterator();
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {

				driver.switchTo().window(ChildWindow);

			}
		}
		Thread.sleep(2000);

		String emailid = obj.getProperty("emailid");
		String password = obj.getProperty("password");
		String submit = obj.getProperty("signIN");

		WebElement emailid1 = driver.findElement(By.xpath(emailid));
		emailid1.sendKeys("newuserseve@mailinator.com");
		WebElement password1 = driver.findElement(By.xpath(password));
		password1.sendKeys("12345");
		WebElement submit1 = driver.findElement(By.xpath(submit));
		submit1.click();
		Thread.sleep(2000);

		String catalogue = obj.getProperty("Catalogue");
		String CCatalogue = obj.getProperty("CreateCatalogue");
		String titlename = obj.getProperty("Etitlename");
		String CatalougeUrl = obj.getProperty("CUrl");
		String Uplogo = obj.getProperty("Ulogo");
		String Media = obj.getProperty("Mlist");
		String Image = obj.getProperty("Imageone");
		String addphoto = obj.getProperty("Addphoto");
		String addphoto1 = obj.getProperty("Addphoto1");
		String mlistone = obj.getProperty("Mlistone");
		String Image2 = obj.getProperty("Imagetwo");
		String price = obj.getProperty("Price");
		String qty = obj.getProperty("QTY");
		String adddes1 = obj.getProperty("Adddes1");
		String asource1 = obj.getProperty("Asource1");
		String adddesbutton1 = obj.getProperty("Adddesbutton1");
		String addtext1 = obj.getProperty("Addtext1");
		String mlisttwo = obj.getProperty("Mlistone");
		String Image3 = obj.getProperty("Imagethree");
		String priceone = obj.getProperty("price1");
		String qtyone = obj.getProperty("qty1");
		String cataloguesource = obj.getProperty("CatalogueSource");
		String cataloguedes = obj.getProperty("Cataloguedes");
		String SEOd = obj.getProperty("Seodata");
		String mtitle = obj.getProperty("Metatitle");
		String mdes = obj.getProperty("Metades");
		String mkey = obj.getProperty("Metakey");
		String customjarrow = obj.getProperty("Cjavas");
		String CustomJtext = obj.getProperty("CustomJ");
		String checkbox1 = obj.getProperty("checkboxone");
		String checkbox2 = obj.getProperty("checkboxtwo");
		String Wbox = obj.getProperty("wbox");
		String generate = obj.getProperty("Glink");
		String clink1 = obj.getProperty("copylink1");
		String clink2 = obj.getProperty("copylink2");
		String close = obj.getProperty("closeicon");
		String delete = obj.getProperty("Cdelete");
		String yes = obj.getProperty("Cyes");
		String dismiss = obj.getProperty("Cdismiss");
		String Edit = obj.getProperty("edit");
		String deleteC = obj.getProperty("DeleteC");
		String Update = obj.getProperty("update");
		Thread.sleep(2000);

		driver.findElement(By.xpath(catalogue)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CCatalogue)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(titlename)).sendKeys("testimage25");
		Thread.sleep(2000);
		driver.findElement(By.xpath(Uplogo)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Media)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Image)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(addphoto)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(mlistone)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Image2)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(price)).sendKeys("11");
		Thread.sleep(2000);
		driver.findElement(By.xpath(qty)).sendKeys("2");
		Thread.sleep(2000);
		driver.findElement(By.xpath(adddes1)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(asource1)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(addtext1)).sendKeys("ysdgfjsjfgsdjfgsdjgf dsgfjsdgfjsdhgf");
		Thread.sleep(2000);
		driver.findElement(By.xpath(asource1)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(adddesbutton1)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(addphoto1)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(mlisttwo)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Image3)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(priceone)).sendKeys("20");
		Thread.sleep(2000);
		driver.findElement(By.xpath(qtyone)).sendKeys("3");
		Thread.sleep(5000);
		driver.findElement(By.xpath(cataloguesource)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(cataloguedes)).sendKeys("metatitle test");
		Thread.sleep(2000);
		driver.findElement(By.xpath(cataloguesource)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(SEOd)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(mtitle)).sendKeys("metatitle test");
		Thread.sleep(2000);
		driver.findElement(By.xpath(mdes)).sendKeys("metades test description fields ");
		Thread.sleep(2000);
		driver.findElement(By.xpath(mkey)).sendKeys("metakey test");
		Thread.sleep(2000);
		driver.findElement(By.xpath(customjarrow)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CustomJtext)).sendKeys(
				"<script src=\"https://static.dev1.cronberry.com/push_bar_js_file/fHOSQQwwa1&prfW&APvLBA==/bar.js\" type=\"text/javascript\"> </script>");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CatalougeUrl)).sendKeys("test-026_");
		Thread.sleep(5000);
		WebElement checkbox11 = driver.findElement(By.xpath(checkbox1));
		checkbox11.click();
		Thread.sleep(2000);
		WebElement checkbox12 = driver.findElement(By.xpath(checkbox2));
		checkbox12.click();
		Thread.sleep(2000);
		WebElement Whtsapp = driver.findElement(By.xpath(Wbox));
		Whtsapp.clear();
		Thread.sleep(2000);
		Whtsapp.sendKeys("9509204154");
		Thread.sleep(5000);
		driver.findElement(By.xpath(generate)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(clink1)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(clink2)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(close)).click();
		Thread.sleep(2000);
		System.out.println("catalogue created ");
		Thread.sleep(5000);
//    driver.findElement(By.xpath(Edit)).click();
//    Thread.sleep(2000);
//    driver.findElement(By.xpath(deleteC)).click();
//    Thread.sleep(3000);
//    driver.findElement(By.xpath(Update)).click();
//    Thread.sleep(2000);
//    driver.findElement(By.xpath(delete)).click();
//    Thread.sleep(2000);
//    driver.findElement(By.xpath(yes)).click();
//    Thread.sleep(2000);
//    driver.findElement(By.xpath(delete)).click();
//    Thread.sleep(2000);
//    driver.findElement(By.xpath(dismiss)).click();
//    Thread.sleep(2000);
		System.out.println("done ");

		// driver.close();

	}

//******

	public static void AnnouncementBar() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/alcodesmobility/Desktop/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cronberry.com/");

		InputStream input = SigninCSV.class.getClassLoader().getResourceAsStream("cronberry.properties");
		Properties obj = new Properties();
		obj.load(input);
		Thread.sleep(3000);

		String Login = obj.getProperty("login");
		driver.findElement(By.xpath(Login)).click();
		Thread.sleep(3000);

		String Sin = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		java.util.Iterator<String> iterator = allWindowHandles.iterator();
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!Sin.equalsIgnoreCase(ChildWindow)) {

				driver.switchTo().window(ChildWindow);
			}
		}

//    String Signin1 = obj.getProperty("signin");
//    driver.findElement(By.xpath(Signin1)).click();
		Thread.sleep(2000);

		String mainWindowHandle = driver.getWindowHandle();

		String SignIn = driver.getWindowHandle();
		Set<String> allWindowHandles1 = driver.getWindowHandles();
		java.util.Iterator<String> iterator1 = allWindowHandles1.iterator();
		while (iterator1.hasNext()) {
			String ChildWindow1 = iterator1.next();
			if (!SignIn.equalsIgnoreCase(ChildWindow1)) {
			}
		}
		Thread.sleep(2000);

		String Email = driver.getWindowHandle();
		Set<String> allWindowHandles2 = driver.getWindowHandles();
		java.util.Iterator<String> iterator2 = allWindowHandles2.iterator();
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {

				driver.switchTo().window(ChildWindow);

			}
		}
		Thread.sleep(2000);

		String emailid = obj.getProperty("emailid");
		String password = obj.getProperty("password");
		String submit = obj.getProperty("signIN");

		WebElement emailid1 = driver.findElement(By.xpath(emailid));
		emailid1.sendKeys("newuserseve@mailinator.com");
		WebElement password1 = driver.findElement(By.xpath(password));
		password1.sendKeys("12345");
		WebElement submit1 = driver.findElement(By.xpath(submit));
		submit1.click();
		Thread.sleep(2000);

		String announcement = obj.getProperty("Announcement");
		String bar = obj.getProperty("Bar");
		String Create = obj.getProperty("Createbar");
		String name = obj.getProperty("Name");
		String fromdate = obj.getProperty("Fromdate");
		String dateFrom = obj.getProperty("dateF");
		String enddate = obj.getProperty("Enddate");
		String nextarrow = obj.getProperty("Nextarrow");
		String dateEnd = obj.getProperty("dateE");
		String starttime = obj.getProperty("StartTime");
		String texts = obj.getProperty("Textsource");
		String textclear = obj.getProperty("Textclear");
		String selectImage = obj.getProperty("SelectImage");
		String MediaBar = obj.getProperty("Media");
		String SelectPic = obj.getProperty("Selectpic");
		String height = obj.getProperty("Height");
		String bgcolor = obj.getProperty("Bcolor");
		String bginput = obj.getProperty("BGinput");
		String cbcolor = obj.getProperty("CBcolor");
		String cbinput = obj.getProperty("CBinput");
		String Barposition = obj.getProperty("Barp");
		String btop = obj.getProperty("Bartop");
		String preview = obj.getProperty("Preview");
		String publish = obj.getProperty("Publish");
		String Closeb = obj.getProperty("closebar");
		String Edit = obj.getProperty("Editbar");
		String Delete = obj.getProperty("Deletebar");
		String yes = obj.getProperty("Yes");

		driver.findElement(By.xpath(announcement)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(bar)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Create)).click();
		Thread.sleep(2000);
		WebElement nametext = driver.findElement(By.xpath(name));
		nametext.clear();
		nametext.sendKeys("testbar");
		driver.findElement(By.xpath(fromdate)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(dateFrom)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(enddate)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(nextarrow)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(dateEnd)).click();
		Thread.sleep(2000);
		WebElement stime = driver.findElement(By.xpath(starttime));
		stime.clear();
		stime.sendKeys("16");
		Thread.sleep(2000);
		driver.findElement(By.xpath(texts)).click();
		Thread.sleep(2000);
		WebElement tarea = driver.findElement(By.xpath(textclear));
		tarea.clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath(texts)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(selectImage)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(MediaBar)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(SelectPic)).click();
		Thread.sleep(2000);
		WebElement height1 = driver.findElement(By.xpath(height));
		height1.clear();
		height1.sendKeys("100");
		Thread.sleep(5000);
		driver.findElement(By.xpath(bgcolor)).click();
		Thread.sleep(3000);
		WebElement bginput1 = driver.findElement(By.xpath(bginput));
		bginput1.clear();
		bginput1.sendKeys("#FF0000");
		driver.findElement(By.xpath(bgcolor)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(cbcolor)).click();
		Thread.sleep(3000);
		WebElement cbinput1 = driver.findElement(By.xpath(cbinput));
		cbinput1.clear();
		cbinput1.sendKeys("#00FFFF");
		Thread.sleep(5000);
		driver.findElement(By.xpath(cbcolor)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Barposition)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(btop)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(preview)).click();
		Thread.sleep(5000);
		String parentWindow = driver.getWindowHandle();
		driver.switchTo().window(parentWindow);
		Thread.sleep(2000);
		driver.findElement(By.xpath(publish)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Closeb)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Edit)).click();
		Thread.sleep(2000);
		WebElement nametext1 = driver.findElement(By.xpath(name));
		nametext1.clear();
		nametext1.sendKeys("testbar1");
		Thread.sleep(2000);
		driver.findElement(By.xpath(preview)).click();
		Thread.sleep(5000);
		String parentWindow1 = driver.getWindowHandle();
		driver.switchTo().window(parentWindow1);
		Thread.sleep(2000);
		driver.findElement(By.xpath(publish)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Create)).click();
		Thread.sleep(2000);
		WebElement nametext2 = driver.findElement(By.xpath(name));
		nametext2.clear();
		nametext2.sendKeys("barthree");
		driver.findElement(By.xpath(fromdate)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(dateFrom)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(enddate)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(nextarrow)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(dateEnd)).click();
		Thread.sleep(2000);
		WebElement stime1 = driver.findElement(By.xpath(starttime));
		stime1.clear();
		stime1.sendKeys("20");
		Thread.sleep(3000);
		driver.findElement(By.xpath(selectImage)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(MediaBar)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(SelectPic)).click();
		Thread.sleep(2000);
		WebElement height2 = driver.findElement(By.xpath(height));
		height2.clear();
		height2.sendKeys("100");
		Thread.sleep(5000);
		driver.findElement(By.xpath(bgcolor)).click();
		Thread.sleep(3000);
		WebElement bginput2 = driver.findElement(By.xpath(bginput));
		bginput2.clear();
		bginput2.sendKeys("#FF0000");
		driver.findElement(By.xpath(bgcolor)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(cbcolor)).click();
		Thread.sleep(3000);
		WebElement cbinput2 = driver.findElement(By.xpath(cbinput));
		cbinput2.clear();
		cbinput2.sendKeys("#00FFFF");
		Thread.sleep(5000);
		driver.findElement(By.xpath(cbcolor)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Barposition)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(btop)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(preview)).click();
		Thread.sleep(5000);
		String parentWindow2 = driver.getWindowHandle();
		driver.switchTo().window(parentWindow2);
		Thread.sleep(2000);
		driver.findElement(By.xpath(publish)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Closeb)).click();
		Thread.sleep(2000);
		Thread.sleep(2000);
		driver.findElement(By.xpath(Delete)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(yes)).click();
	}

//********

	public static void CatalogueProducts() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/alcodesmobility/Desktop/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://catalogue.dev1.cronberry.com/p/helloindai");

		InputStream input = SigninCSV.class.getClassLoader().getResourceAsStream("cronberry.properties");
		Properties obj = new Properties();
		obj.load(input);
		Thread.sleep(3000);

		String selectone = obj.getProperty("select1");
		String Qone = obj.getProperty("Qty1");
		String enquiry = obj.getProperty("Enow");

		Thread.sleep(2000);
		driver.findElement(By.xpath(selectone)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Qone)).sendKeys("10");
		Thread.sleep(2000);
		driver.findElement(By.xpath(enquiry)).click();
		Thread.sleep(2000);

		String Name = obj.getProperty("name");
		String Email = obj.getProperty("email");
		String Phone = obj.getProperty("phone");
		String Description = obj.getProperty("description");
		String Submit = obj.getProperty("Esubmit");
		// String WappButton = obj.getProperty("WappB");

		WebElement Name1 = driver.findElement(By.xpath(Name));
		WebElement Email1 = driver.findElement(By.xpath(Email));
		WebElement Phone1 = driver.findElement(By.xpath(Phone));
		WebElement Description1 = driver.findElement(By.xpath(Description));
		WebElement Submit1 = driver.findElement(By.xpath(Submit));
		Submit1.click();

		String Error1 = obj.getProperty("Error");
		WebElement Error2 = driver.findElement(By.xpath(Error1));
		Thread.sleep(3000);

		CSVReader reader = new CSVReader(
				new FileReader("/Users/itipriyaparashar/Desktop/catalogue form  - Sheet1.csv"));

		List<String[]> list = reader.readAll();

		System.out.println("Total rows which we have is " + list.size());

		int i, j;
		for (i = 1; i <= list.size() - 1; i++) {
			Thread.sleep(3000);

			for (j = 1; j <= 7; j++) {

				String[] thirdRow = list.get(i);
				Name1.sendKeys(thirdRow[j]);
				System.out.println(thirdRow[j]);
				System.out.println("1");

				Email1.sendKeys(thirdRow[j + 1]);
				System.out.println(thirdRow[j + 1]);
				System.out.println("2");

				Phone1.sendKeys(thirdRow[j + 2]);
				System.out.println(thirdRow[j + 2]);
				System.out.println("3");

				Description1.sendKeys(thirdRow[j + 3]);
				System.out.println(thirdRow[j + 3]);
				System.out.println("4");

				Submit1.click();
				Thread.sleep(1000);
				break;

			}
			Name1.clear();
			Email1.clear();
			Phone1.clear();
			Description1.clear();
			// Submit1.click();

			String alert = Error2.getText();

			if (alert.contains("This field is required.") || alert.contains("Please enter")
					|| alert.contains("Please fill"))

			{

				list.get(i)[5] = alert;

				list.get(i)[6] = "Pass";
			}

			else {
				list.get(i)[5] = alert;

				list.get(i)[6] = "Fail";

			}

			Thread.sleep(3000);
			Name1.clear();
			Email1.clear();
			Phone1.clear();
			Description1.clear();
			// Submit1.click();

		}

		reader.close();
		CSVWriter writer = new CSVWriter(
				new FileWriter(new File("/Users/itipriyaparashar/Desktop/catalogue form  - Sheet1.csv")));
		writer.writeAll(list);
		writer.flush();
		writer.close();
		Thread.sleep(3000);
		// driver.close();
		System.out.println("done");

	}
//    String selectall = obj.getProperty("Sall");
//    String Qone = obj.getProperty("Qty1");
//    String enquiry = obj.getProperty("Enow");
//    String Name = obj.getProperty("name");
//    String Email = obj.getProperty("email");
//    String Phone = obj.getProperty("phone");
//    String Des = obj.getProperty("description");
//    String esubmit = obj.getProperty("Esubmit");
//    //String whtsappb = obj.getProperty("WappB");
//
//    Thread.sleep(2000);
//    driver.findElement(By.xpath(selectall)).click();
//    Thread.sleep(2000);
//    driver.findElement(By.xpath(Qone)).sendKeys("10");
//    Thread.sleep(2000);
//    driver.findElement(By.xpath(enquiry)).click();
//    Thread.sleep(2000);
//    driver.findElement(By.xpath(Name)).sendKeys("priya");
//    Thread.sleep(2000);
//    driver.findElement(By.xpath(Email)).sendKeys("priyap@mailinator.com");
//    Thread.sleep(2000);
//    driver.findElement(By.xpath(Phone)).sendKeys("9509204154");
//    Thread.sleep(2000);
//    driver.findElement(By.xpath(Des)).sendKeys("test enuiry now");
//    Thread.sleep(2000);
//    driver.findElement(By.xpath(esubmit)).click();
//    Thread.sleep(2000);

	public static void Analysis() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/alcodesmobility/Desktop/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://qa1.cronberry.com");

		InputStream input = SigninCSV.class.getClassLoader().getResourceAsStream("cronberry.properties");
		Properties obj = new Properties();
		obj.load(input);
		Thread.sleep(3000);

		String Login = obj.getProperty("login");
		driver.findElement(By.xpath(Login)).click();
		Thread.sleep(3000);

		String Sin = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		java.util.Iterator<String> iterator = allWindowHandles.iterator();
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!Sin.equalsIgnoreCase(ChildWindow)) {

				driver.switchTo().window(ChildWindow);
			}
		}

		String mainWindowHandle = driver.getWindowHandle();

		String SignIn = driver.getWindowHandle();
		Set<String> allWindowHandles1 = driver.getWindowHandles();
		java.util.Iterator<String> iterator1 = allWindowHandles1.iterator();
		while (iterator1.hasNext()) {
			String ChildWindow1 = iterator1.next();
			if (!SignIn.equalsIgnoreCase(ChildWindow1)) {
			}
		}
		Thread.sleep(2000);

		String Email = driver.getWindowHandle();
		Set<String> allWindowHandles2 = driver.getWindowHandles();
		java.util.Iterator<String> iterator2 = allWindowHandles2.iterator();
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {

				driver.switchTo().window(ChildWindow);

			}
		}
		Thread.sleep(2000);

		String emailid = obj.getProperty("emailid");
		String password = obj.getProperty("password");
		String submit = obj.getProperty("signIN");

		WebElement emailid1 = driver.findElement(By.xpath(emailid));
		emailid1.sendKeys("cronberrycat@mailinator.com");
		WebElement password1 = driver.findElement(By.xpath(password));
		password1.sendKeys("12345");
		WebElement submit1 = driver.findElement(By.xpath(submit));
		submit1.click();

		Thread.sleep(5000);
		String audience = obj.getProperty("AudienceC");
		String analysis = obj.getProperty("Analysis");
		String addreport = obj.getProperty("Addreport");
		String reportname = obj.getProperty("Reportname");
		String source = obj.getProperty("Source");
		String Sindiamart = obj.getProperty("Sim");
		String SgoogleF = obj.getProperty("SGF");
		String ScustomF = obj.getProperty("SCF");
		String attributes = obj.getProperty("Attributes");
		String qType = obj.getProperty("QType");
		String a1 = obj.getProperty("A1");
		String a2 = obj.getProperty("A2");
		String yaxis = obj.getProperty("Yaxis");
		String yaxs1 = obj.getProperty("Yaxs1");
		String y1 = obj.getProperty("Y1");
		String y2 = obj.getProperty("Y2");
		String daterange = obj.getProperty("Daterange");
		String rangetype = obj.getProperty("Rangetype");
		String submitlead = obj.getProperty("Submitlead");
		String editR = obj.getProperty("EditR");
		String addnewreoprt = obj.getProperty("Addnewreoprt");
		String deletereoprt = obj.getProperty("Deletereoprt");
		String deleteyes = obj.getProperty("Deleteyes");

		Thread.sleep(2000);
		driver.findElement(By.xpath(audience)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(analysis)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(addreport)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(submitlead)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(reportname)).sendKeys("two");
		Thread.sleep(2000);
		driver.findElement(By.xpath(source)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Sindiamart)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(attributes)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(qType)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(yaxis)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(yaxs1)).click();
		Thread.sleep(2000);
//    driver.findElement(By.xpath(daterange)).click();
//    Thread.sleep(5000);
//    driver.findElement(By.xpath(rangetype)).click();
//    Thread.sleep(2000);
		driver.findElement(By.xpath(submitlead)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(editR)).click();
		Thread.sleep(2000);
		WebElement edit = driver.findElement(By.xpath(reportname));
		edit.clear();
		edit.sendKeys("three");
//    driver.findElement(By.xpath(reportname)).sendKeys("three");
		Thread.sleep(2000);
		driver.findElement(By.xpath(source)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(SgoogleF)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(attributes)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(a1)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(yaxis)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(y1)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(submitlead)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(addnewreoprt)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(reportname)).sendKeys("four");
		Thread.sleep(2000);
		driver.findElement(By.xpath(source)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(ScustomF)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(attributes)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(a2)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(yaxis)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(y2)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(submitlead)).click();
		Thread.sleep(2000);

//    driver.findElement(By.xpath(deletereoprt)).click();
//    Thread.sleep(2000);
//    driver.findElement(By.xpath(deleteyes)).click();
//    Thread.sleep(2000);
//    driver.findElement(By.xpath(deletereoprt)).click();
//    Thread.sleep(2000);
//    driver.findElement(By.xpath(deleteyes)).click();

	}

	public static void Segment() throws Exception {

		System.setProperty("webdriver.chrome.driver", "/Users/alcodesmobility/Desktop/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://qa1.cronberry.com");

		InputStream input = SigninCSV.class.getClassLoader().getResourceAsStream("cronberry.properties");
		Properties obj = new Properties();
		obj.load(input);
		Thread.sleep(3000);

		String Login = obj.getProperty("login");
		driver.findElement(By.xpath(Login)).click();
		Thread.sleep(3000);

		String Sin = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		java.util.Iterator<String> iterator = allWindowHandles.iterator();
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!Sin.equalsIgnoreCase(ChildWindow)) {

				driver.switchTo().window(ChildWindow);
			}
		}

		String mainWindowHandle = driver.getWindowHandle();

		String SignIn = driver.getWindowHandle();
		Set<String> allWindowHandles1 = driver.getWindowHandles();
		java.util.Iterator<String> iterator1 = allWindowHandles1.iterator();
		while (iterator1.hasNext()) {
			String ChildWindow1 = iterator1.next();
			if (!SignIn.equalsIgnoreCase(ChildWindow1)) {
			}
		}
		Thread.sleep(2000);

		String Email = driver.getWindowHandle();
		Set<String> allWindowHandles2 = driver.getWindowHandles();
		java.util.Iterator<String> iterator2 = allWindowHandles2.iterator();
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {

				driver.switchTo().window(ChildWindow);

			}
		}
		Thread.sleep(2000);

		String emailid = obj.getProperty("emailid");
		String password = obj.getProperty("password");
		String submit = obj.getProperty("signIN");

		WebElement emailid1 = driver.findElement(By.xpath(emailid));
		emailid1.sendKeys("newusersix@mailinator.com");
		WebElement password1 = driver.findElement(By.xpath(password));
		password1.sendKeys("12345");
		WebElement submit1 = driver.findElement(By.xpath(submit));
		submit1.click();

		Thread.sleep(5000);
		String segments = obj.getProperty("Segments");
		String createsegment = obj.getProperty("Createsegment");
		String nameS = obj.getProperty("NameS");
		String ssource = obj.getProperty("Ssource");
		String s1 = obj.getProperty("S1");
		String addfilter = obj.getProperty("Addfilter");
		String af1 = obj.getProperty("AF1");
		String in = obj.getProperty("IN");
		String in1 = obj.getProperty("IN1");
		String open = obj.getProperty("Open");
		String Addfilter1 = obj.getProperty("Addfilterone");
		String af2 = obj.getProperty("AF2");
		String filterbox = obj.getProperty("Filterbox");
		String addgrp = obj.getProperty("Addgrp");
		String Source2 = obj.getProperty("source2");
		String sTI = obj.getProperty("STI");
		String entrydate = obj.getProperty("FilterED");
		String selectd = obj.getProperty("SelectD");
		String datef = obj.getProperty("DATEF");
		String createseg = obj.getProperty("Createseg");
		String editseg = obj.getProperty("Editseg");
		String notin = obj.getProperty("Notin");
		String update = obj.getProperty("Update");
		String deleteseg = obj.getProperty("Deleteseg");
		String yesD = obj.getProperty("YesD");

		String s2 = obj.getProperty("S2");
		String f2 = obj.getProperty("F2");
		String f3 = obj.getProperty("F3");
		String s3 = obj.getProperty("S3");
		String f4 = obj.getProperty("F4");
		String SD = obj.getProperty("selectdate");
		String Dateselect = obj.getProperty("Dates");

		Thread.sleep(2000);
		driver.findElement(By.xpath(segments)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(createsegment)).click();
		Thread.sleep(2000);
		WebElement names = driver.findElement(By.xpath(nameS));
		names.sendKeys("tradindia");
		Thread.sleep(2000);
		driver.findElement(By.xpath(ssource)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(s1)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(addfilter)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(af1)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(in)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(in1)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(open)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(Addfilter1)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(af2)).click();
		Thread.sleep(2000);
		WebElement filterbox1 = driver.findElement(By.xpath(filterbox));
		filterbox1.sendKeys("20");
		Thread.sleep(2000);
		driver.findElement(By.xpath(addgrp)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Source2)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(sTI)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(entrydate)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(selectd)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(datef)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(createseg)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(editseg)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(notin)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(update)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(deleteseg)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(yesD)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(createsegment)).click();
		Thread.sleep(2000);
		WebElement names1 = driver.findElement(By.xpath(nameS));
		names1.sendKeys("TDindia");
		Thread.sleep(2000);
		driver.findElement(By.xpath(ssource)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(s1)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(addfilter)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(af1)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(in)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(in1)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(open)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(Addfilter1)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(af2)).click();
		Thread.sleep(2000);
		WebElement filterbox2 = driver.findElement(By.xpath(filterbox));
		filterbox2.sendKeys("20");
		Thread.sleep(2000);
		driver.findElement(By.xpath(addgrp)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Source2)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(sTI)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(entrydate)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(selectd)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(datef)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(createseg)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(createsegment)).click();
		Thread.sleep(5000);

		WebElement names3 = driver.findElement(By.xpath(nameS));
		names3.sendKeys("API");
		Thread.sleep(2000);
		driver.findElement(By.xpath(ssource)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(s2)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(addfilter)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(f2)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(in)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(in1)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(open)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(Addfilter1)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(f3)).click();
		Thread.sleep(2000);
		WebElement filterbox3 = driver.findElement(By.xpath(filterbox));
		filterbox3.sendKeys("20");
		Thread.sleep(2000);
		driver.findElement(By.xpath(addgrp)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Source2)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(s3)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(f4)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(SD)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Dateselect)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(createseg)).click();
		Thread.sleep(2000);
	}

	public static void Configuration() throws Exception {

		System.setProperty("webdriver.chrome.driver", "/Users/alcodesmobility/Desktop/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cronberry.com/");

		InputStream input = SigninCSV.class.getClassLoader().getResourceAsStream("cronberry.properties");
		Properties obj = new Properties();
		obj.load(input);
		Thread.sleep(3000);

		String Login = obj.getProperty("login");
		driver.findElement(By.xpath(Login)).click();
		Thread.sleep(3000);

		String Sin = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		java.util.Iterator<String> iterator = allWindowHandles.iterator();
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!Sin.equalsIgnoreCase(ChildWindow)) {

				driver.switchTo().window(ChildWindow);
			}
		}

		String mainWindowHandle = driver.getWindowHandle();

		String SignIn = driver.getWindowHandle();
		Set<String> allWindowHandles1 = driver.getWindowHandles();
		java.util.Iterator<String> iterator1 = allWindowHandles1.iterator();
		while (iterator1.hasNext()) {
			String ChildWindow1 = iterator1.next();
			if (!SignIn.equalsIgnoreCase(ChildWindow1)) {
			}
		}
		Thread.sleep(2000);

		String Email = driver.getWindowHandle();
		Set<String> allWindowHandles2 = driver.getWindowHandles();
		java.util.Iterator<String> iterator2 = allWindowHandles2.iterator();
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {

				driver.switchTo().window(ChildWindow);

			}
		}
		Thread.sleep(2000);

		String emailid = obj.getProperty("emailid");
		String password = obj.getProperty("password");
		String submit = obj.getProperty("signIN");

		WebElement emailid1 = driver.findElement(By.xpath(emailid));
		emailid1.sendKeys("newuserten@mailinator.com");
		WebElement password1 = driver.findElement(By.xpath(password));
		password1.sendKeys("12345");
		WebElement submit1 = driver.findElement(By.xpath(submit));
		submit1.click();

		Thread.sleep(5000);
		String configuration = obj.getProperty("Configuration");

		Thread.sleep(2000);
		driver.findElement(By.xpath(configuration)).click();

		// android
		String serverkeyA = obj.getProperty("ServerkeyA");
		String testpushA = obj.getProperty("TestpushA");
		String fcmA = obj.getProperty("FCMA");
		String title = obj.getProperty("Title");
		String content = obj.getProperty("Content");
		String sendS = obj.getProperty("SendS");
		String saveS = obj.getProperty("SaveS");

		Thread.sleep(5000);
		driver.findElement(By.xpath(serverkeyA)).clear();

		driver.findElement(By.xpath(testpushA)).click();
		Thread.sleep(2000);
		WebElement serverkeyA1 = driver.findElement(By.xpath(serverkeyA));

		serverkeyA1.sendKeys(
				"AAAA2qQPPRA:APA91bGoGK53ui47jRI7zG3qSo3Nq19Vz1a1ZE90ihN7bSSYfGup0HBXn8uWwPnWG4BDEklWIUn_qdqX9dzFqGoPHwqXE9DBI4ghofkc0X_PLNpv69lB2Rppe3hdHZOzZxZzdJaQm1dP");
		Thread.sleep(3000);
		driver.findElement(By.xpath(testpushA)).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(sendS)).click();
		Thread.sleep(4000);
		WebElement fcmA1 = driver.findElement(By.xpath(fcmA));
		fcmA1.sendKeys(
				"eJ4jdFXRTLK2QH33xiptuL:APA91bH4kaG5gwQ3YXCAfZ8EP3wgMgLqLAU1abpjTQdLvD4TrptRNTwrydw6FUZNl4aBwTrwGxtOvnXU8pdT5-0_1PHaPeKZYn9mM4lwhN6io1AZqk1W5a1H_p5JdpL1E7qDuAJLA9oP");
		Thread.sleep(2000);
		WebElement title1 = driver.findElement(By.xpath(title));
		title1.sendKeys("test sms title ");
		Thread.sleep(2000);
		WebElement content1 = driver.findElement(By.xpath(content));
		content1.sendKeys("test sms configuration ");
		Thread.sleep(2000);
		driver.findElement(By.xpath(sendS)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(saveS)).click();

		// IOS
		Thread.sleep(5000);
		String iosapp = obj.getProperty("Iosapp");
		String serverkeyI = obj.getProperty("ServerkeyI");
		String testpushI = obj.getProperty("TestpushI");
		String fcmI = obj.getProperty("FCMI");
		String titleI = obj.getProperty("TitleI");
		String contentI = obj.getProperty("ContentI");
		String sendI = obj.getProperty("SendI");
		String saveI = obj.getProperty("SaveI");

		Thread.sleep(2000);
		driver.findElement(By.xpath(iosapp)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(testpushI)).click();
		Thread.sleep(2000);
		WebElement serverkeyI1 = driver.findElement(By.xpath(serverkeyI));
		serverkeyI1.sendKeys(
				"AAAACossYG4:APA91bGvkSWDeWIALvhvWGTRBFy19HZ7pW-TzT2Q05yfwLMFmMstA__XS-L_dTgsOJdMZ-pUBx7WqOcJW4G_5IQw6DNDDtOzfGnRDovj7fH3UjSApRT18fdRdinFfuIeiSmCUovMjz2T");
		Thread.sleep(2000);
		driver.findElement(By.xpath(testpushI)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(sendI)).click();
		Thread.sleep(2000);
		WebElement fcmI1 = driver.findElement(By.xpath(fcmI));
		fcmI1.sendKeys(
				"cpibQ7Nix8k:APA91bFtcFj3_3ENWc3wyVnTACIU1qhIK1p6tbUbIK8fd-Q3iVEh0bGLS_I8ka7zqZYuQlqMxPRC6rhQ3KYlC7fuK-4VJHSlJTfKo7EL2Xpt0X8EGrAa0d201s7SvobStnC8883amFmB");
		Thread.sleep(2000);
		WebElement titleI1 = driver.findElement(By.xpath(titleI));
		titleI1.sendKeys("test IOS title ");
		Thread.sleep(2000);
		WebElement contentI1 = driver.findElement(By.xpath(contentI));
		contentI1.sendKeys("test IOS configuration ");
		Thread.sleep(2000);
		driver.findElement(By.xpath(sendI)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(saveI)).click();

		// Web
		Thread.sleep(5000);
		String web = obj.getProperty("Web");
		String fcmurlW = obj.getProperty("FCMurlW");
		String serverkeyW = obj.getProperty("ServerkeyW");
		String testpushW = obj.getProperty("TestpushW");
		String browserID = obj.getProperty("BrowserID");
		String titleW = obj.getProperty("TitleW");
		String contentW = obj.getProperty("ContentW");
		String sendW = obj.getProperty("SendW");
		String saveW = obj.getProperty("SaveW");

		Thread.sleep(2000);
		driver.findElement(By.xpath(web)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(testpushW)).click();
		Thread.sleep(2000);
		WebElement fcmurlW1 = driver.findElement(By.xpath(fcmurlW));
		fcmurlW1.sendKeys("https://fcm.googleapis.com/fcm/send");
		Thread.sleep(2000);
		WebElement serverkeyW1 = driver.findElement(By.xpath(serverkeyW));
		serverkeyW1.sendKeys(
				"AAAAKOwAIGc:APA91bGFjhQMKhtn32NWh5zgj9vLMtOPr6-3cZ1ZG19NvdUhjvGy8lvqrnuERC0D-WX9Uql6qqv70ioCLie5-YEkPd854NDOr-qTDsPfiF3UUIFsDTR75X5rBhGSZJuog3Wi7SR_6aqz");
		Thread.sleep(2000);
		driver.findElement(By.xpath(testpushW)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(sendW)).click();
		Thread.sleep(2000);
		WebElement browserID1 = driver.findElement(By.xpath(browserID));
		browserID1.sendKeys(
				"chAXmKyXT4w:APA91bFcubWYYzbCVicG7j-v2ZMaAz9TnACWeKRLWSXVMmWjkszxVjEoetloIpT7XRoHFhAlON7rARnWMoKJfQ_GKFK8daVe6297KShJ6Kpj-AsLeJW-15GuvWxD5uNjKlDww3-OvPvz");
		Thread.sleep(2000);
		Thread.sleep(2000);
		WebElement titleW1 = driver.findElement(By.xpath(titleW));
		titleW1.sendKeys("test web title");
		Thread.sleep(2000);
		Thread.sleep(2000);
		WebElement contentW1 = driver.findElement(By.xpath(contentW));
		contentW1.sendKeys("test web configuration");
		Thread.sleep(2000);
		driver.findElement(By.xpath(sendW)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(saveW)).click();

		// SMS
		Thread.sleep(5000);
		String sms = obj.getProperty("SMS");
		String smsprovider = obj.getProperty("Smsprovider");
		String alcodes = obj.getProperty("Alcodes");
		String username = obj.getProperty("Username");
		String sendtestsms = obj.getProperty("Sendtestsms");
		String parameter = obj.getProperty("Parameter");
		String value2 = obj.getProperty("Value2");
		String phoneno = obj.getProperty("Phoneno");
		String message = obj.getProperty("Message");
		String sendsms = obj.getProperty("Sendsms");
		String addproviderSMS = obj.getProperty("AddproviderSMS");

		Thread.sleep(5000);
		driver.findElement(By.xpath(sms)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(sendtestsms)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(smsprovider)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(alcodes)).click();
		Thread.sleep(2000);
		WebElement username1 = driver.findElement(By.xpath(username));
		username1.clear();
		username1.sendKeys("a3a37e49-44cc-43f3-b12f-3e384db2e3e6");
		Thread.sleep(2000);
		driver.findElement(By.xpath(parameter)).click();
		Thread.sleep(2000);
		WebElement value3 = driver.findElement(By.xpath(value2));
		value3.sendKeys("ALCODS");
		Thread.sleep(2000);
		driver.findElement(By.xpath(sendtestsms)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(sendsms)).click();
		Thread.sleep(2000);
		WebElement phoneno1 = driver.findElement(By.xpath(phoneno));
		phoneno1.sendKeys("9509204154");
		Thread.sleep(2000);
		WebElement message1 = driver.findElement(By.xpath(message));
		message1.sendKeys("test sms title ");
		Thread.sleep(2000);
		driver.findElement(By.xpath(sendsms)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(addproviderSMS)).click();

		// Email
		Thread.sleep(5000);
		String email = obj.getProperty("Email");
		String emailservice = obj.getProperty("Emailservice");
		String sendgrid = obj.getProperty("Sendgrid");
		String senderemail = obj.getProperty("Senderemail");
		String usernameE = obj.getProperty("UsernameE");
		String passwordE = obj.getProperty("PasswordE");
		String sendtestemail = obj.getProperty("Sendtestemail");
		String emailaddress = obj.getProperty("Emailaddress");
		String subject = obj.getProperty("Subject");
		String meassgeemail = obj.getProperty("Meassgeemail");
		String sendemail = obj.getProperty("Sendemail");
		String addproviderE = obj.getProperty("AddproviderE");

		Thread.sleep(5000);
		driver.findElement(By.xpath(email)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(emailservice)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(sendgrid)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(sendtestemail)).click();
		Thread.sleep(2000);
		WebElement senderemail1 = driver.findElement(By.xpath(senderemail));
		senderemail1.sendKeys("anshika@tallydekho.com");
		Thread.sleep(2000);
		WebElement usernameE1 = driver.findElement(By.xpath(usernameE));
		usernameE1.clear();
		usernameE1.sendKeys("apikey");
		Thread.sleep(2000);
		WebElement passwordE1 = driver.findElement(By.xpath(passwordE));
		passwordE1.sendKeys("SG.FoQSAE0QSpqee0oq0CwXoQ.FEnvePlaagPUaaAUl5ShS2tbpe_8lgjVBKCuK9gPEd4");
		Thread.sleep(2000);
		driver.findElement(By.xpath(sendtestemail)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(sendemail)).click();
		Thread.sleep(2000);
		WebElement emailaddress1 = driver.findElement(By.xpath(emailaddress));
		emailaddress1.sendKeys("i.parashar@maaruji.com");
		Thread.sleep(2000);
		WebElement subject1 = driver.findElement(By.xpath(subject));
		subject1.sendKeys("email test title");
		Thread.sleep(2000);
		WebElement meassgeemail1 = driver.findElement(By.xpath(meassgeemail));
		meassgeemail1.sendKeys("check email configuration");
		Thread.sleep(2000);
		driver.findElement(By.xpath(sendemail)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(addproviderE)).click();

		System.out.println("All configuration done ");
	}
}
