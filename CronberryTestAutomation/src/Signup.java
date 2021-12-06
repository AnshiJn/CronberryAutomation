import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Pattern;
import org.apache.poi.hpsf.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.internal.BaseAction;
import java.awt.AWTException;	
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.interactions.*;


public class Signup {

	static String allUr = "";

	public static void main(String[] args) throws Exception {

//		
//		
//  	Signuppage();
//		System.out.println("******* All Cases Singup Checked ******");
//
//		    	try{
//    		Createuser();
//    	
//		System.out.println("******* All Cases Create User Checked ******");
//    	}
//    	
//     catch(Exception e)
//    	{
//    	 System.out.println(allUr);
//            Response response= RestAssured.get(allUr);
//            int statusCode=response.statusCode();
//            System.out.println("Status Code" + statusCode);
//            
//            
//    	}
////
//		PushNotificationCreateTemplate();
//		System.out.println("******* All Cases Push Notification Checked ******");
//
//    	EmailCreateTemplate();
//		System.out.println("******* All Cases Create Template Checked ******");

//		PopUp();
//		System.out.println("******* All Cases Pop Up Checked ******");

//		Audience();
//	   System.out.println("******* All Cases Pop Up Checked ******");

//		UserManagement();
		 System.out.println("******* All Cases User Management Checked ******");



	}

	public static void Signuppage() throws Exception {

		System.setProperty("webdriver.chrome.driver", "/Users/alcodesmobility/Desktop/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://qa1.cronberry.com/");
		Thread.sleep(1000);

		InputStream input = Signup.class.getClassLoader().getResourceAsStream("Cronberryxpath.properties");

		Properties obj = new Properties();

		obj.load(input);
		Thread.sleep(5000);
		String features = obj.getProperty("Features");

		driver.findElement(By.xpath(features)).click();

		Thread.sleep(2000);

		String login = obj.getProperty("Login");
		WebElement login1 = driver.findElement(By.xpath(login));
		login1.click();

		String url;
		Thread.sleep(5000);

		String mainWindowHandle = driver.getWindowHandle();

		Set<String> allWindowHandles = driver.getWindowHandles();
		Iterator<String> iterator = allWindowHandles.iterator();

//// Here we will check if child window has other child windows and will fetch the heading of the child window

		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {

				driver.switchTo().window(ChildWindow);

			}
		}

		Thread.sleep(5000);
		driver.findElement(By.linkText("Sign up")).click();
		String emailid = obj.getProperty("Emailid");
		String password = obj.getProperty("Password");
		String retypepassowrd = obj.getProperty("Retypepassowrd");
		String submit = obj.getProperty("Submit");

		WebElement emailid1 = driver.findElement(By.xpath(emailid));
		WebElement password1 = driver.findElement(By.xpath(password));
		WebElement retypepassowrd1 = driver.findElement(By.xpath(retypepassowrd));
		WebElement submit1 = driver.findElement(By.xpath(submit));

		submit1.click();
		// driver.findElement(By.linkText("Sign up")).click();

		Thread.sleep(1000);

		String toast = obj.getProperty("Toast");
		WebElement toast1 = driver.findElement(By.xpath(toast));
		Thread.sleep(5000);

		CSVReader reader = new CSVReader(new FileReader(
				"/Users/alcodesmobility/eclipse-workspace/CronberryTestAutomation/CSV Sheets/signupusecase.csv"));

		List<String[]> list = reader.readAll();

		System.out.println("Total rows which we have is " + list.size());

		int i, j;

		for (i = 1; i <= list.size() - 1; i++) {

			for (j = 1; j <= 3; j++) {
				String[] thirdRow = list.get(i);
				emailid1.sendKeys(thirdRow[j]);
				System.out.println(thirdRow[j]);

				password1.sendKeys(thirdRow[j + 1]);
				System.out.println(thirdRow[j + 1]);

				retypepassowrd1.sendKeys(thirdRow[j + 2]);
				System.out.println(thirdRow[j + 2]);

				submit1.click();
				// driver.findElement(By.linkText("Sign up")).click();

				Thread.sleep(4000);

				String alert = toast1.getText();

				if (alert.contains("Already Exist") || alert.contains("Error") || alert.contains("Please fill"))

				{

					list.get(i)[4] = alert;

					list.get(i)[5] = "Pass";
				}

				else {
					list.get(i)[4] = alert;

					list.get(i)[5] = "Fail";

				}

				Thread.sleep(5000);
				emailid1.clear();
				password1.clear();
				retypepassowrd1.clear();

				break;

			}

		}
		reader.close();
		CSVWriter writer = new CSVWriter(new FileWriter(new File(
				"/Users/alcodesmobility/eclipse-workspace/CronberryTestAutomation/CSV Sheets/signupusecase.csv")), ',');
		writer.writeAll(list);
		writer.flush();
		writer.close();

		// String userid = obj.getProperty("UserEmail");
		// String userpswd = obj.getProperty("UserPswd");
		// String userretype = obj.getProperty("UserRetype");

		// emailid1.sendKeys(userid);
		// password1.sendKeys(userpswd);
		// retypepassowrd1.sendKeys(userretype);
		// submit1.click();

		driver.close();

	}

	public static void Createuser() throws Exception {

		System.setProperty("webdriver.chrome.driver", "/Users/alcodesmobility/Desktop/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://qa1.cronberry.com/admin/sign-in");
		Thread.sleep(1000);

		InputStream input = Signup.class.getClassLoader().getResourceAsStream("Cronberryxpath.properties");

		Properties obj = new Properties();
		obj.load(input);

		String signin12 = obj.getProperty("Singnin");
		WebElement signin13 = driver.findElement(By.xpath(signin12));
		signin13.click();
		allUr = driver.getCurrentUrl();
		String userEmail = obj.getProperty("UserEmailId");
		String userPswd = obj.getProperty("UserPswd");
		String SignUp = obj.getProperty("SignUp");
		String userPassword = obj.getProperty("UserPassword");
		String signin = obj.getProperty("Signin");
		String CreateUserLogin = obj.getProperty("CreateUserLogin");
		String ConfirmPassword = obj.getProperty("ConfirmPassword");

		WebElement SignUp1 = driver.findElement(By.xpath(SignUp));
		WebElement userPassword1 = driver.findElement(By.xpath(userPassword));

		WebElement signin1 = driver.findElement(By.xpath(signin));
		SignUp1.sendKeys(userEmail);
		userPassword1.sendKeys(userPswd);
		driver.findElement(By.xpath(ConfirmPassword)).sendKeys(userPswd);
		driver.findElement(By.xpath(CreateUserLogin)).click();
		allUr = driver.getCurrentUrl();
		// signin1.click();

		Thread.sleep(5000);

		String firstname = obj.getProperty("Firstname");
		String lastname = obj.getProperty("Lastname");
		String gender = obj.getProperty("Gender");
		String verify = obj.getProperty("Verify");
		String mobile = obj.getProperty("Mobile");
		String companyName = obj.getProperty("CompanyName");
		String gst = obj.getProperty("GST");
		String address = obj.getProperty("Address");
		String pincode = obj.getProperty("Pincode");
		String city = obj.getProperty("City");
		String state = obj.getProperty("State");
		String country = obj.getProperty("Country");
		String iaccept = obj.getProperty("Iaccept");
		String ipermit = obj.getProperty("Ipermit");
		String submitCreateUser = obj.getProperty("SubmitCreateUser");
		String toastcreateuser = obj.getProperty("Toastcreateuser");

		WebElement firstname1 = driver.findElement(By.xpath(firstname));
		WebElement lastname1 = driver.findElement(By.xpath(lastname));
		WebElement gender1 = driver.findElement(By.xpath(gender));

		WebElement verify1 = driver.findElement(By.xpath(verify));
		WebElement mobile1 = driver.findElement(By.xpath(mobile));
		WebElement companyName1 = driver.findElement(By.xpath(companyName));
		WebElement gst1 = driver.findElement(By.xpath(gst));
		WebElement address1 = driver.findElement(By.xpath(address));
		WebElement pincode1 = driver.findElement(By.xpath(pincode));
		WebElement city1 = driver.findElement(By.xpath(city));
		WebElement state1 = driver.findElement(By.xpath(state));
		WebElement country1 = driver.findElement(By.xpath(country));
		WebElement iaccept1 = driver.findElement(By.xpath(iaccept));
		WebElement ipermit1 = driver.findElement(By.xpath(ipermit));
		WebElement submitCreateUser1 = driver.findElement(By.xpath(submitCreateUser));
		submitCreateUser1.click();

		WebElement toastcreateuser1 = driver.findElement(By.xpath(toastcreateuser));

		allUr = driver.getCurrentUrl();

		CSVReader reader = new CSVReader(new FileReader(
				"/Users/alcodesmobility/eclipse-workspace/CronberryTestAutomation/CSV Sheets/creatuser - Sheet1.csv"));

		List<String[]> list = reader.readAll();

		System.out.println("Total rows which we have is " + list.size());

		int i, j;

		for (i = 1; i <= list.size() - 1; i++) {
			Thread.sleep(5000);

			for (j = 1; j <= 3; j++) {
				String[] thirdRow = list.get(i);
				firstname1.sendKeys(thirdRow[j]);
				Boolean firstNameCheck = Pattern.matches("^[A-Za-z\s]{3,29}$", thirdRow[j]);

				lastname1.sendKeys(thirdRow[j + 1]);
				Boolean lastNameCheck = Pattern.matches("^[A-Za-z]{3,29}$", thirdRow[j + 1]);

				gender1.sendKeys(thirdRow[j + 2]);
				mobile1.sendKeys(thirdRow[j + 3]);
				Boolean mobileCheck = Pattern.matches("^[6-9]\\d{9}$", thirdRow[j + 3]);
				companyName1.sendKeys(thirdRow[j + 4]);
				gst1.sendKeys(thirdRow[j + 5]);
				address1.sendKeys(thirdRow[j + 6]);

				pincode1.sendKeys(thirdRow[j + 7]);

				Boolean pinCodeCheck = Pattern.matches("^[1-9]{1}[0-9]{5}$", thirdRow[j + 7]);
				city1.sendKeys(thirdRow[j + 8]);

				state1.sendKeys(thirdRow[j + 9]);
				country1.sendKeys(thirdRow[j + 10]);
				submitCreateUser1.click();
				allUr = driver.getCurrentUrl();
				Thread.sleep(5000);

				String alert = toastcreateuser1.getText();

				// Check regex
				if (firstNameCheck && lastNameCheck && pinCodeCheck && mobileCheck) {
					// Regex Matched Succesfully
					list.get(i)[12] = alert;
					list.get(i)[13] = "Pass";

				} else if (alert.contains("Already Exist") || alert.contains("Error")
						|| alert.contains("Please fill")) {

					// Alert Message Comes as per Expectation
					list.get(i)[12] = alert;
					list.get(i)[13] = "Pass";

				} else {
					list.get(i)[12] = alert;
					list.get(i)[13] = "Fail";

				}

				Thread.sleep(5000);

				firstname1.clear();
				lastname1.clear();

				gender1.sendKeys("Select Gender");
				mobile1.clear();
				companyName1.clear();
				gst1.clear();
				address1.clear();
				Thread.sleep(2000);

				pincode1.clear();
				city1.clear();
				state1.clear();
				country1.sendKeys("Select Country");
				allUr = driver.getCurrentUrl();
				break;

			}

			reader.close();
			CSVWriter writer = new CSVWriter(new FileWriter(new File(
					"/Users/alcodesmobility/eclipse-workspace/CronberryTestAutomation/CSV Sheets/creatuser - Sheet1.csv")),
					',');
			writer.writeAll(list);
			writer.flush();
			writer.close();
//			 WebDriverWait wait = new WebDriverWait(driver,300);
//			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Verified')]")));
//			 ipermit1.click();

//			 submitCreateUser1.click();

		}

		WebDriverWait wait = new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Verified')]")));
		driver.findElement(By.xpath(firstname)).sendKeys("devuser");
		driver.findElement(By.xpath(lastname)).sendKeys("jain");
		driver.findElement(By.xpath(gender)).sendKeys("Male");
		driver.findElement(By.xpath(mobile)).sendKeys("9895895855");
		driver.findElement(By.xpath(companyName)).sendKeys("maaruji");
		driver.findElement(By.xpath(gst)).sendKeys("jfjefjff47847");
		driver.findElement(By.xpath(address)).sendKeys("120d ndhdbd trhitratsh ncnnc");
		driver.findElement(By.xpath(pincode)).sendKeys("399393");
		driver.findElement(By.xpath(city)).sendKeys("jaipur");
		driver.findElement(By.xpath(state)).sendKeys("rajasthan");
		driver.findElement(By.xpath(country)).sendKeys("India");

		Thread.sleep(1000);

		ipermit1.click();
		Thread.sleep(1000);

		iaccept1.click();
		Thread.sleep(1000);

		submitCreateUser1.click();
		Thread.sleep(2000);

		allUr = driver.getCurrentUrl();
		driver.close();

	}

	public static void PushNotificationCreateTemplate() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/alcodesmobility/Desktop/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://qa1.cronberry.com/admin/sign-in");
		Thread.sleep(1000);
		// allUr=driver.getCurrentUrl();
		InputStream input = Signup.class.getClassLoader().getResourceAsStream("Cronberryxpath.properties");

		Properties obj = new Properties();

		obj.load(input);
		Thread.sleep(3000);

		String Signin = obj.getProperty("Signin");
		String SigninEmailId1 = obj.getProperty("SigninEmailId");
		String PasswordSignIn1 = obj.getProperty("PasswordSignIn");
		String PassowrdSignInButton1 = obj.getProperty("PassowrdSignInButton");
		String LoginUser1 = obj.getProperty("LoginUser");
		String LoginPswd1 = obj.getProperty("LoginPswd");
		Thread.sleep(3000);
		// driver.findElement(By.xpath(Signin)).click();
		// allUr=driver.getCurrentUrl();

		driver.findElement(By.xpath(SigninEmailId1)).sendKeys(LoginUser1);
		driver.findElement(By.xpath(PasswordSignIn1)).sendKeys(LoginPswd1);
		driver.findElement(By.xpath(PassowrdSignInButton1)).click();
		// allUr=driver.getCurrentUrl();

		Thread.sleep(5000);

		String CampaignTemplate = obj.getProperty("CampaignTemplate");
		driver.findElement(By.cssSelector(CampaignTemplate)).click();
		// allUr=driver.getCurrentUrl();

		Thread.sleep(5000);

		String CampaignTemplateButton = obj.getProperty("CampaignTemplateButton");
		driver.findElement(By.xpath(CampaignTemplateButton)).click();

		CSVReader reader = new CSVReader(
				new FileReader("/Users/alcodesmobility/Desktop/push notification - Sheet1.csv"));

		List<String[]> list = reader.readAll();

		System.out.println("Total rows which we have is " + list.size());

		Thread.sleep(5000);

		String TemplateName = obj.getProperty("TemplateName");

		String Title = obj.getProperty("Title");
		String DynamicValues = obj.getProperty("DynamicValues");
		String DynamicVal = obj.getProperty("DynamicVal");

		String Message = obj.getProperty("Message");
		String ClickAction = obj.getProperty("ClickAction");
		String Web = obj.getProperty("Web");
		String IOS = obj.getProperty("IOS");
		String Android = obj.getProperty("Android");
		String Save = obj.getProperty("Save");
		String SelectImage = obj.getProperty("SelectImage");
		String ChooseFile = obj.getProperty("ChooseFile");

		String MediaName = obj.getProperty("MediaName");
		String ImageSaveButton = obj.getProperty("ImageSaveButton");

		driver.findElement(By.xpath(Save)).click();

		String AlertMessage = obj.getProperty("AlertMessage");
		String DymanicClear = obj.getProperty("DymanicClear");

		String MediaList = obj.getProperty("MediaList");
		String SearchImageImput = obj.getProperty("SearchImageImput");
		String SearchImageButton = obj.getProperty("SearchImageButton");
		String ImageSelect = obj.getProperty("ImageSelect");

		String Emoji = obj.getProperty("Emoji");
		String EmojiSelect = obj.getProperty("EmojiSelect");

		// WebElement TemplateName1= driver.findElement(By.xpath(TemplateName));
		// WebElement Title1= driver.findElement(By.xpath(Title));
		// WebElement DynamicValues1= driver.findElement(By.xpath(DynamicValues));
		// DynamicValues1.click();
		// Thread.sleep(5000);

		// WebElement DynamicVal1= driver.findElement(By.xpath(DynamicVal));
		Thread.sleep(5000);
		// WebElement Message1= driver.findElement(By.xpath(Message));
		// WebElement ClickAction1= driver.findElement(By.xpath(ClickAction));
		// WebElement IOS1= driver.findElement(By.xpath(IOS));
		// WebElement Android1= driver.findElement(By.xpath(Android));
		// WebElement Web1= driver.findElement(By.xpath(Web));
		// WebElement Save1= driver.findElement(By.xpath(Save));
		// WebElement SelectImage1= driver.findElement(By.xpath(SelectImage));
		// WebElement AlertMessage1=driver.findElement(By.xpath(AlertMessage));

		// Message1.clear();
		int i, j;
		String templatename = "";

		for (i = 1; i < list.size(); i++) {

			WebElement TemplateName1 = driver.findElement(By.xpath(TemplateName));

			System.out.print(TemplateName);

			WebElement Title1 = driver.findElement(By.xpath(Title));

			WebElement DynamicValues1 = driver.findElement(By.xpath(DynamicValues));
			WebElement Message1 = driver.findElement(By.xpath(Message));
			WebElement ClickAction1 = driver.findElement(By.xpath(ClickAction));
			WebElement IOS1 = driver.findElement(By.xpath(IOS));
			WebElement Android1 = driver.findElement(By.xpath(Android));
			WebElement Web1 = driver.findElement(By.xpath(Web));
			WebElement SelectImage1 = driver.findElement(By.xpath(SelectImage));
			WebElement Save1 = driver.findElement(By.xpath(Save));

			System.out.println("print");

			WebElement AlertMessage1 = driver.findElement(By.xpath(AlertMessage));

			for (j = 1; j <= 3; j++) {
				String[] thirdRow = list.get(i);

				// System.out.println(thirdRow[j]);

				TemplateName1.sendKeys(thirdRow[j]);
				// System.out.println(thirdRow[j]);

				Title1.sendKeys(thirdRow[j + 1]);
				// System.out.println(thirdRow[j + 1]);

				DynamicValues1.sendKeys(thirdRow[j + 2]);
				DynamicValues1.sendKeys(Keys.ENTER);
				Thread.sleep(10000);

				SelectImage1.click();
				// DynamicVal1.click();
				Thread.sleep(5000);

				WebElement MediaName1 = driver.findElement(By.xpath(MediaName));

				if (thirdRow[j + 3].isBlank())

				{

					driver.findElement(By.xpath(MediaList)).click();
					driver.findElement(By.xpath(SearchImageImput)).sendKeys("N");
					Thread.sleep(2000);
					driver.findElement(By.xpath(SearchImageButton)).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath(ImageSelect)).click();
					// allUr=driver.getCurrentUrl();

				}

				else {

					MediaName1.sendKeys(thirdRow[j + 3]);
					WebElement ChooseFile1 = driver.findElement(By.xpath(ChooseFile));
					Thread.sleep(3000);

					ChooseFile1.sendKeys(thirdRow[j + 4]);

					driver.findElement(By.xpath(ImageSaveButton)).click();
					Thread.sleep(2000);

					driver.findElement(By.xpath(ImageSelect)).click();
					// allUr=driver.getCurrentUrl();

				}

				// MediaName1.sendKeys(thirdRow[j + 3]);
				// WebElement ChooseFile1= driver.findElement(By.xpath(ChooseFile));

				Thread.sleep(3000);

				// ChooseFile1.sendKeys(thirdRow[j + 4]);

				// driver.findElement(By.xpath(ImageSaveButton)).click();

				// System.out.println(thirdRow[j + 2]);

				Thread.sleep(3000);

				Message1.sendKeys(thirdRow[j + 5]);
				driver.findElement(By.xpath(Emoji)).click();
				driver.findElement(By.xpath(EmojiSelect)).click();
				// System.out.println(thirdRow[j + 5]);

				Thread.sleep(2000);

				ClickAction1.sendKeys(thirdRow[j + 6]);
				// System.out.println(thirdRow[j + 6]);
				Web1.click();
				Android1.click();
				IOS1.click();
				Save1.click();
				Thread.sleep(4000);
				String alert = AlertMessage1.getText();

				System.out.println(templatename);
//				
//				if(thirdRow[j].equalsIgnoreCase(templatename))
//				{
//				
//					
//					list.get(i)[8] = alert;
//
//					list.get(i)[9] = "Fail";
//					
//					TemplateName1.clear();
//					Title1.clear();
//		        	Thread.sleep(2000);
//					WebElement DymanicClear1=driver.findElement(By.xpath(DymanicClear));
//					DymanicClear1.click();
//					Message1.clear();
//					ClickAction1.clear();
//				
//				}
//				
//				else {	
				if (alert.contains("Already Exist") || alert.contains("Error") || alert.contains("Please fill"))

				{

					list.get(i)[8] = alert;

					list.get(i)[9] = "Pass";

					TemplateName1.clear();
					Title1.clear();
					Thread.sleep(2000);
					WebElement DymanicClear1 = driver.findElement(By.xpath(DymanicClear));
					DymanicClear1.click();
					Message1.clear();
					ClickAction1.clear();
				}

				else if (alert.contains("Template")) {

					list.get(i)[8] = alert;

					list.get(i)[9] = "Pass";

					Thread.sleep(5000);
					driver.findElement(By.xpath(CampaignTemplateButton)).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath(Save)).click();

				}

				else {
					list.get(i)[8] = alert;

					list.get(i)[9] = "Fail";

					TemplateName1.clear();
					Title1.clear();
					Thread.sleep(2000);
					WebElement DymanicClear1 = driver.findElement(By.xpath(DymanicClear));
					DymanicClear1.click();
					Message1.clear();
					ClickAction1.clear();

				}

				// allUr=driver.getCurrentUrl();

				// Thread.sleep(15000);

//						System.out.print("itipriya");

				templatename = thirdRow[j];

				break;

			}

			System.out.print(i);

			Thread.sleep(5000);

		}

		reader.close();
		CSVWriter writer = new CSVWriter(
				new FileWriter(new File("/Users/alcodesmobility/Desktop/push notification - Sheet1.csv")), ',');
		writer.writeAll(list);
		writer.flush();
		writer.close();
		Thread.sleep(2000);

		driver.close();

	}

	public static void EmailCreateTemplate() throws Exception {

		System.setProperty("webdriver.chrome.driver", "/Users/alcodesmobility/Desktop/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://qa1.cronberry.com/admin/sign-in");
		Thread.sleep(1000);

		InputStream input = Signup.class.getClassLoader().getResourceAsStream("Cronberryxpath.properties");

		Properties obj = new Properties();

		obj.load(input);
		Thread.sleep(3000);

		obj.load(input);
		Thread.sleep(3000);

		String Signin = obj.getProperty("Signin");
		String SigninEmailId1 = obj.getProperty("SigninEmailId");
		String PasswordSignIn1 = obj.getProperty("PasswordSignIn");
		String PassowrdSignInButton1 = obj.getProperty("PassowrdSignInButton");
		String LoginUser1 = obj.getProperty("LoginUser");
		String LoginPswd1 = obj.getProperty("LoginPswd");
		Thread.sleep(3000);
		// driver.findElement(By.xpath(Signin)).click();
		driver.findElement(By.xpath(SigninEmailId1)).sendKeys(LoginUser1);
		driver.findElement(By.xpath(PasswordSignIn1)).sendKeys(LoginPswd1);
		driver.findElement(By.xpath(PassowrdSignInButton1)).click();
		Thread.sleep(5000);

		String CampaignTemplate = obj.getProperty("CampaignTemplate");
		driver.findElement(By.cssSelector(CampaignTemplate)).click();

		Thread.sleep(5000);

		String EmailTemplate = obj.getProperty("EmailTemplate");
		driver.findElement(By.xpath(EmailTemplate)).click();

		Thread.sleep(5000);

		String CreateEmailTemplate = obj.getProperty("CreateEmailTemplate");
		driver.findElement(By.xpath(CreateEmailTemplate)).click();

		String EmailTemplateSave = obj.getProperty("EmailTemplateSave");
		driver.findElement(By.xpath(EmailTemplateSave)).click();

		String AlertMessageEmail = obj.getProperty("AlertMessageEmail");
		// driver.findElement(By.xpath(AlertMessageEmail));

		String SelectImage = obj.getProperty("SelectImage");
		String ChooseFile = obj.getProperty("ChooseFile");

		String CustomForm = obj.getProperty("CustomForm");
		String SelectCustomForm = obj.getProperty("SelectCustomForm");

		// csv file

		CSVReader reader = new CSVReader(new FileReader("/Users/alcodesmobility/Desktop/Email - Sheet1.csv"));

		List<String[]> list = reader.readAll();

		System.out.println("Total rows which we have is " + list.size());

		Thread.sleep(5000);

		String EmailTemplateName = obj.getProperty("EmailTemplateName");

		String EmailSubject = obj.getProperty("EmailSubject");

		String EmailDynamicValue = obj.getProperty("EmailDynamicValue");

		String EmailDynamicValueClear = obj.getProperty("EmailDynamicValueClear");

		String EmailCustomForSelectMedium = obj.getProperty("EmailCustomForSelectMedium");

		String EmailMessage = obj.getProperty("EmailMessage");

		String MediaName = obj.getProperty("MediaName");
		String ImageSaveButton = obj.getProperty("ImageSaveButton");

		String MediaList = obj.getProperty("MediaList");
		String SearchImageImput = obj.getProperty("SearchImageImput");
		String SearchImageButton = obj.getProperty("SearchImageButton");
		String ImageSelect = obj.getProperty("ImageSelect");

		String EditorEmail = obj.getProperty("EditorEmail");

		String TypeDropDownFile = obj.getProperty("TypeDropDownFile");

		String SelectFile = obj.getProperty("SelectFile");

		int i, j;
		String templatename = "";

		for (i = 1; i < list.size(); i++) {

			WebElement EmailTemplateName1 = driver.findElement(By.xpath(EmailTemplateName));

			System.out.print(EmailTemplateName);

			WebElement EmailSubject1 = driver.findElement(By.xpath(EmailSubject));

			WebElement EmailDynamicValue1 = driver.findElement(By.xpath(EmailDynamicValue));

			WebElement EmailCustomForSelectMedium1 = driver.findElement(By.xpath(EmailCustomForSelectMedium));

			WebElement EmailTemplateSave1 = driver.findElement(By.xpath(EmailTemplateSave));

			WebElement AlertMessageEmail1 = driver.findElement(By.xpath(AlertMessageEmail));

			WebElement EditorEmail1 = driver.findElement(By.xpath(EditorEmail));

			for (j = 1; j <= 3; j++) {
				String[] thirdRow = list.get(i);

				// System.out.println(thirdRow[j]);

				EmailTemplateName1.sendKeys(thirdRow[j]);
				// System.out.println(thirdRow[j]);

				EmailSubject1.sendKeys(thirdRow[j + 1]);
				System.out.println(thirdRow[j + 1]);

				EmailDynamicValue1.sendKeys(thirdRow[j + 2]);

				System.out.println(thirdRow[j + 1]);

				EmailDynamicValue1.sendKeys(Keys.ENTER);
				Thread.sleep(2000);

				// DynamicVal1.click();

				String text = EditorEmail1.getText();
				System.out.println(text);

				if (text.contains("Editor View")) {
					EditorEmail1.click();
				}
				Thread.sleep(5000);

				WebElement EmailMessage1 = driver.findElement(By.xpath(EmailMessage));

				EmailMessage1.sendKeys(thirdRow[j + 5]);

				System.out.println(thirdRow[j + 3]);

				Thread.sleep(2000);

				EmailCustomForSelectMedium1.click();
				WebElement MediaName1 = driver.findElement(By.xpath(MediaName));

				if (thirdRow[j + 3].isBlank())

				{

					driver.findElement(By.xpath(MediaList)).click();
					driver.findElement(By.xpath(SearchImageImput)).sendKeys("New");
					Thread.sleep(2000);
					driver.findElement(By.xpath(SearchImageButton)).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath(ImageSelect)).click();
					EmailCustomForSelectMedium1.click();
					driver.findElement(By.xpath(CustomForm)).click();
					driver.findElement(By.xpath(SelectCustomForm)).click();

				}

				else if (thirdRow[j + 3].contains("file")) {
					MediaName1.sendKeys(thirdRow[j + 3]);
					Thread.sleep(2000);
					driver.findElement(By.xpath(SelectFile)).click();
					Thread.sleep(2000);
					WebElement ChooseFile1 = driver.findElement(By.xpath(ChooseFile));
					Thread.sleep(3000);
					// driver.findElement(By.xpath(TypeDropDownFile)).click();
					Thread.sleep(2000);
					ChooseFile1.sendKeys(thirdRow[j + 4]);

					driver.findElement(By.xpath(ImageSaveButton)).click();
					Thread.sleep(2000);

					driver.findElement(By.xpath(ImageSelect)).click();

				}

				else {

					MediaName1.sendKeys(thirdRow[j + 3]);
					WebElement ChooseFile1 = driver.findElement(By.xpath(ChooseFile));
					Thread.sleep(3000);

					ChooseFile1.sendKeys(thirdRow[j + 4]);

					driver.findElement(By.xpath(ImageSaveButton)).click();
					Thread.sleep(2000);

					driver.findElement(By.xpath(ImageSelect)).click();
				}

				// Select Custom Form

				EmailTemplateSave1.click();

				Thread.sleep(2000);

				String alert = AlertMessageEmail1.getText();

				System.out.println(alert);

				Thread.sleep(3000);

				if (alert.contains("Already Exist") || alert.contains("Error") || alert.contains("Please fill"))

				{

					list.get(i)[7] = alert;

					list.get(i)[8] = "Pass";

					EmailTemplateName1.clear();
					EmailSubject1.clear();
					Thread.sleep(2000);

					WebElement EmailDynamicValueClear1 = driver.findElement(By.xpath(EmailDynamicValueClear));

					System.out.println("test email run dynsmic1");

					System.out.println("test email rundymanic");

					EmailDynamicValueClear1.click();

					System.out.println("test email run111");

					// EmailMessage1.clear();

				}

				else if (alert.contains("Template")) {

					list.get(i)[7] = alert;

					list.get(i)[8] = "Pass";

					Thread.sleep(5000);
					driver.findElement(By.xpath(CreateEmailTemplate)).click();
					Thread.sleep(5000);
					driver.findElement(By.xpath(EmailTemplateSave)).click();

					System.out.println("test email run");

				}

				else {
					list.get(i)[7] = alert;

					list.get(i)[8] = "Fail";

					EmailTemplateName1.clear();
					EmailSubject1.clear();
					Thread.sleep(2000);

					WebElement EmailDynamicValueClear1 = driver.findElement(By.xpath(EmailDynamicValueClear));

					System.out.println("test email run1ejejje1");

					EmailDynamicValueClear1.click();

					System.out.println("test email run2222");

					// EmailMessage1.clear();

				}

				System.out.println("testline2");

				// Thread.sleep(15000);

//						System.out.print("itipriya");

				templatename = thirdRow[j];

				break;

			}

			System.out.println(i);

			Thread.sleep(5000);

		}

		reader.close();
		CSVWriter writer = new CSVWriter(new FileWriter(new File("/Users/alcodesmobility/Desktop/Email - Sheet1.csv")),
				',');
		writer.writeAll(list);
		writer.flush();
		writer.close();
		Thread.sleep(2000);

		driver.close();

	}

	public static void PopUp() throws Exception {

		System.setProperty("webdriver.chrome.driver", "/Users/alcodesmobility/Desktop/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://qa1.cronberry.com/admin/sign-in");
		Thread.sleep(1000);

		InputStream input = Signup.class.getClassLoader().getResourceAsStream("Cronberryxpath.properties");

		Properties obj = new Properties();

		obj.load(input);
		Thread.sleep(3000);

		obj.load(input);
		Thread.sleep(3000);

		String Signin = obj.getProperty("Signin");
		String SigninEmailId1 = obj.getProperty("SigninEmailId");
		String PasswordSignIn1 = obj.getProperty("PasswordSignIn");
		String PassowrdSignInButton1 = obj.getProperty("PassowrdSignInButton");
		String LoginUser1 = obj.getProperty("LoginUser");
		String LoginPswd1 = obj.getProperty("LoginPswd");
		Thread.sleep(3000);
		// driver.findElement(By.xpath(Signin)).click();
		driver.findElement(By.xpath(SigninEmailId1)).sendKeys(LoginUser1);
		driver.findElement(By.xpath(PasswordSignIn1)).sendKeys(LoginPswd1);
		driver.findElement(By.xpath(PassowrdSignInButton1)).click();
		Thread.sleep(5000);

		String Announcement = obj.getProperty("Announcement");
		driver.findElement(By.xpath(Announcement)).click();
		Thread.sleep(500);

		String Popup = obj.getProperty("Popup");
		driver.findElement(By.cssSelector(Popup)).click();
		Thread.sleep(500);

		String CreatePopUpNotification = obj.getProperty("CreatePopUpNotification");
		driver.findElement(By.cssSelector(CreatePopUpNotification)).click();

		String PupUpName = obj.getProperty("PupUpName");
		driver.findElement(By.xpath(PupUpName)).sendKeys("newpopup");

		Thread.sleep(500);

		DateFormat dateFormat = new SimpleDateFormat("DD/mm/yyyy ");
		Date date = new Date();
		String date1 = dateFormat.format(date);

		String CalendarFrom = obj.getProperty("CalendarFrom");
		driver.findElement(By.xpath(CalendarFrom)).sendKeys(date1);
		Thread.sleep(500);

		String IsSelectedFrom = obj.getProperty("IsSelectedFrom");
		driver.findElement(By.xpath(IsSelectedFrom)).click();
		Thread.sleep(500);

		String CalendarTo = obj.getProperty("CalendarTo");
		driver.findElement(By.xpath(CalendarTo)).click();
		Thread.sleep(500);

		String IsSelectedTo = obj.getProperty("IsSelectedTo");
		driver.findElement(By.xpath(IsSelectedTo)).click();
		Thread.sleep(500);

		String OnOpen = obj.getProperty("OnOpen");
		driver.findElement(By.xpath(OnOpen)).click();
		Thread.sleep(500);

		String StartTime = obj.getProperty("StartTime");
		driver.findElement(By.xpath(StartTime)).clear();
		driver.findElement(By.xpath(StartTime)).sendKeys("3");

		// String OnClose= obj.getProperty("OnClose");
		// driver.findElement(By.xpath(OnClose)).click();

		String Duration = obj.getProperty("Duration");
		driver.findElement(By.xpath(Duration)).click();
		Thread.sleep(500);

		String Source = obj.getProperty("Source");
		driver.findElement(By.xpath(Source)).click();
		Thread.sleep(1000);

		String TextArea = obj.getProperty("TextArea");
		driver.findElement(By.xpath(TextArea)).clear();
		Thread.sleep(1500);

		driver.findElement(By.xpath(Source)).click();

		String SelectMedia = obj.getProperty("SelectMedia");
		driver.findElement(By.xpath(SelectMedia)).click();
		Thread.sleep(1500);
		String MediaList = obj.getProperty("MediaList");
		driver.findElement(By.xpath(MediaList)).click();

		Thread.sleep(500);

		String SelectImagePOPUP = obj.getProperty("SelectImagePOPUP");
		driver.findElement(By.xpath(SelectImagePOPUP)).click();
		Thread.sleep(500);
		String BgColor = obj.getProperty("BgColor");
		driver.findElement(By.xpath(BgColor)).click();

		String HexCode = obj.getProperty("HexCode");
		driver.findElement(By.xpath(HexCode)).clear();

		driver.findElement(By.xpath(HexCode)).sendKeys("#0bffeb");

		driver.findElement(By.xpath(BgColor)).click();

		Thread.sleep(1000);
		String CloseButtonColor = obj.getProperty("CloseButtonColor");

		driver.findElement(By.xpath(CloseButtonColor));

		String BgButtonColor = obj.getProperty("BgButtonColor");

		driver.findElement(By.xpath(BgButtonColor)).click();

		Thread.sleep(1000);

		String HexCodeButton = obj.getProperty("HexCodeButton");
		driver.findElement(By.xpath(HexCodeButton)).clear();

		driver.findElement(By.xpath(HexCodeButton)).sendKeys("#191919");
		driver.findElement(By.xpath(BgButtonColor)).click();

		Thread.sleep(1000);

		String Width = obj.getProperty("Width");
		driver.findElement(By.xpath(Width)).clear();
		driver.findElement(By.xpath(Width)).sendKeys("800");
		Thread.sleep(1000);

		// String Clickable=obj.getProperty("Clickable");
		// driver.findElement(By.xpath(Clickable)).click();

		String URLaddress = obj.getProperty("URLaddress");
		driver.findElement(By.xpath(URLaddress)).clear();
		driver.findElement(By.xpath(URLaddress)).sendKeys("qa1.google.com");

		String NewTab = obj.getProperty("NewTab");
		driver.findElement(By.xpath(NewTab)).click();
		Thread.sleep(1000);

		// String Enable=obj.getProperty("Enable");
		// river.findElement(By.xpath(Enable)).click();

		String CloseButton = obj.getProperty("CloseButton");
		driver.findElement(By.xpath(CloseButton)).click();

		Thread.sleep(1000);
		String Preview = obj.getProperty("Preview");
		driver.findElement(By.xpath(Preview)).click();
		Thread.sleep(1000);

		String parent = driver.getWindowHandle();
		driver.switchTo().window(parent);
		// System.out.println(driver.switchTo().window(parent).getTitle());

		Thread.sleep(1000);
		String Submitpopup = obj.getProperty("Submitpopup");
		driver.findElement(By.xpath(Submitpopup)).click();
		Thread.sleep(1000);
		String Closepopup = obj.getProperty("Closepopup");
		driver.findElement(By.xpath(Closepopup)).click();
		driver.close();

	}

	public static void Audience() throws Exception {

		System.setProperty("webdriver.chrome.driver", "/Users/alcodesmobility/Desktop/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://qa1.cronberry.com/admin/sign-in");
		Thread.sleep(1000);

		InputStream input = Signup.class.getClassLoader().getResourceAsStream("Cronberryxpath.properties");

		Properties obj = new Properties();

		obj.load(input);
		Thread.sleep(3000);

		obj.load(input);
		Thread.sleep(3000);

		// String Signin = obj.getProperty("Signin");
		String SigninEmailId1 = obj.getProperty("SigninEmailId");
		String PasswordSignIn1 = obj.getProperty("PasswordSignIn");
		String PassowrdSignInButton1 = obj.getProperty("PassowrdSignInButton");
		String LoginUser1 = obj.getProperty("LoginUser");
		String LoginPswd1 = obj.getProperty("LoginPswd");
		String ViewAudienceIcon = obj.getProperty("ViewAudienceIcon");
		String LeadConverted = obj.getProperty("LeadConverted");
		String Note = obj.getProperty("Note");

		String SubmitAudience = obj.getProperty("SubmitAudience");
		String AlertMessage = obj.getProperty("AlertMessage");

		String alertmsg = driver.findElement(By.xpath(AlertMessage)).getText();

		Thread.sleep(3000);
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.xpath(SigninEmailId1)).sendKeys(LoginUser1);
		driver.findElement(By.xpath(PasswordSignIn1)).sendKeys(LoginPswd1);
		driver.findElement(By.xpath(PassowrdSignInButton1)).click();
		Thread.sleep(2000);

//		String csv = "/Users/alcodesmobility/Desktop/audiencenew.csv";
//		CSVWriter writer = new CSVWriter(new FileWriter(csv));    	
//		List<String[]> list = new ArrayList<String[]>();
//		String[] data;

		driver.findElement(By.linkText("Audience")).click();
		Thread.sleep(1000);

		driver.findElement(By.linkText("View Audience")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath(ViewAudienceIcon)).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath(LeadConverted)).click();

		Thread.sleep(2000);

		driver.findElement(By.cssSelector(SubmitAudience)).click();

		Thread.sleep(1000);

		Thread.sleep(2000);

		System.out.println(alertmsg);

		Thread.sleep(2000);

		driver.findElement(By.tagName("textarea")).sendKeys("This lead is converted.");

		Thread.sleep(4000);

		driver.findElement(By.cssSelector(SubmitAudience)).click();

		String Delete = obj.getProperty("Delete");

		Thread.sleep(2000);

		driver.findElement(By.xpath(Delete)).click();
		Thread.sleep(2000);

		String Dismiss = obj.getProperty("Dismiss");

		driver.findElement(By.xpath(Dismiss)).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath(Delete)).click();
		Thread.sleep(2000);
		String DelecteYes = obj.getProperty("DelecteYes");
		Thread.sleep(2000);
		driver.findElement(By.xpath(DelecteYes)).click();

		Thread.sleep(2000);

		String AdvanceSearch = obj.getProperty("AdvanceSearch");

		driver.findElement(By.xpath(AdvanceSearch)).click();

		Thread.sleep(2000);
		String API = obj.getProperty("API");
		driver.findElement(By.xpath(API)).click();
		Thread.sleep(2000);
		String AudienceSubmit = obj.getProperty("AudienceSubmit");

		driver.findElement(By.xpath(AudienceSubmit)).click();
		Thread.sleep(2000);

		String ApplySearch = obj.getProperty("ApplySearch");

		driver.findElement(By.xpath(ApplySearch)).click();
		Thread.sleep(2000);

		String SearchResult = obj.getProperty("SearchResult");

		String searchresult = driver.findElement(By.xpath(SearchResult)).getText();
		Thread.sleep(2000);

		System.out.println(searchresult);

		driver.findElement(By.linkText("Upload Audience")).click();

	}

	public static void UserManagement() throws Exception {

		System.setProperty("webdriver.chrome.driver", "/Users/alcodesmobility/Desktop/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://qa1.cronberry.com/admin/sign-in");

		Thread.sleep(1000);

		InputStream input = Signup.class.getClassLoader().getResourceAsStream("Cronberryxpath.properties");

		Properties obj = new Properties();

		obj.load(input);
		Thread.sleep(3000);

		obj.load(input);
		Thread.sleep(3000);

		String SigninEmailId1 = obj.getProperty("SigninEmailId");
		String PasswordSignIn1 = obj.getProperty("PasswordSignIn");
		String PassowrdSignInButton1 = obj.getProperty("PassowrdSignInButton");
		String LoginUser1 = obj.getProperty("LoginUser");
		String LoginPswd1 = obj.getProperty("LoginPswd");
		String CloseButton = obj.getProperty("CloseButton");
		String VerificationLink = obj.getProperty("VerificationLink");
		String UserManagement = obj.getProperty("UserManagement");
		String AddUser = obj.getProperty("AddUser");
		String AlertMessage = obj.getProperty("AlertMessage");
		String EmailUsed = obj.getProperty("EmailUsed");
		String UserEmail = obj.getProperty("UserEmail");
		String UserFullName = obj.getProperty("UserFullName");
		String DropDown = obj.getProperty("DropDown");
		String UserDropDown = obj.getProperty("UserDropDown");
		String SelectField = obj.getProperty("SelectField");
		String RemoveUser = obj.getProperty("RemoveUser");
		String EditButton = obj.getProperty("EditButton");
		String Click = obj.getProperty("Click");
		String UpdateUser = obj.getProperty("UpdateUser");
		String SelectedField = obj.getProperty("SelectedField");

		Thread.sleep(3000);
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.xpath(SigninEmailId1)).sendKeys(LoginUser1);
		driver.findElement(By.xpath(PasswordSignIn1)).sendKeys(LoginPswd1);
		driver.findElement(By.xpath(PassowrdSignInButton1)).click();
		Thread.sleep(2000);

		driver.findElement(By.cssSelector(UserManagement)).click();

		driver.findElement(By.xpath(AddUser)).click();

		Thread.sleep(1000);

		WebElement message = driver.findElement(By.xpath(AlertMessage));

		String toastmessage = message.getText();

		driver.findElement(By.xpath(UserFullName)).sendKeys("Robin");
		String TeleCaller1 = obj.getProperty("TeleCaller1");
		driver.findElement(By.xpath(UserEmail)).sendKeys(TeleCaller1);

		driver.findElement(By.xpath(DropDown)).sendKeys("Telecaller");

		Thread.sleep(2000);

		driver.findElement(By.xpath(AddUser)).click();

		CSVWriter writer = new CSVWriter(new FileWriter(new File(
				"/Users/alcodesmobility/eclipse-workspace/CronberryTestAutomation/CSV Sheets/UserManagement.csv")),
				',');

		String[] header = { "UseCase", "Message", "Result" };
		writer.writeNext(header);

		if (toastmessage.contains("Please")) {

			String[] UseCase1 = { "Blank Validation", toastmessage, "Pass" };

			writer.writeNext(UseCase1);

		}

		else {

			String[] UseCase1 = { "Blank Validation", toastmessage, "Fail" };

			writer.writeNext(UseCase1);

		}

		Thread.sleep(9000);

		String email = driver.findElement(By.xpath(EmailUsed)).getText();

		driver.findElement(By.xpath(UserFullName)).clear();
		driver.findElement(By.xpath(UserEmail)).clear();

		String TeleCaller2 = obj.getProperty("TeleCaller2");

		String emailuser = TeleCaller2;
		String usernamenew = "NewTelle";

		driver.findElement(By.xpath(UserFullName)).sendKeys(usernamenew);
		driver.findElement(By.xpath(UserEmail)).sendKeys(emailuser);

		driver.findElement(By.xpath(DropDown)).sendKeys("Telecaller");

		Thread.sleep(2000);

		driver.findElement(By.xpath(AddUser)).click();

		driver.findElement(By.xpath(UserEmail)).sendKeys(email);

		driver.findElement(By.xpath(UserFullName)).sendKeys("TelleCallerNew");
		driver.findElement(By.xpath(AddUser)).click();

		Thread.sleep(1000);

		if (message.getText().contains("Error")) {

			String[] UseCase2 = { "Email Already Exists", message.getText(), "Pass" };
			writer.writeNext(UseCase2);

		}

		else {

			String[] UseCase2 = { "Email Already Exists", message.getText(), "Fail" };

			writer.writeNext(UseCase2);

		}
		Thread.sleep(9000);

		driver.findElement(By.xpath(UserFullName)).clear();
		driver.findElement(By.xpath(UserEmail)).clear();
		driver.findElement(By.xpath(UserFullName)).sendKeys("TelleCallerNew");
		driver.findElement(By.xpath(AddUser)).click();

		Thread.sleep(1000);

		if (message.getText().contains("Please")) {

			String[] UseCase2 = { "Blank Field Email Id ", message.getText(), "Pass" };
			writer.writeNext(UseCase2);

		}

		else {

			String[] UseCase2 = { "Blank Field Email Id", message.getText(), "Fail" };

			writer.writeNext(UseCase2);

		}

		Thread.sleep(9000);

		driver.findElement(By.xpath(UserFullName)).clear();
		driver.findElement(By.xpath(UserEmail)).clear();
		String TeleCaller3 = obj.getProperty("TeleCaller3");
		driver.findElement(By.xpath(UserEmail)).sendKeys(TeleCaller3);
		driver.findElement(By.xpath(AddUser)).click();

		Thread.sleep(1000);

		if (message.getText().contains("Please")) {

			String[] UseCase2 = { "Blank Field- Name", message.getText(), "Pass" };
			writer.writeNext(UseCase2);

		}

		else {

			String[] UseCase2 = { "Blank Field- Name", message.getText(), "Fail" };

			writer.writeNext(UseCase2);

		}

		Thread.sleep(9000);

		driver.findElement(By.xpath(UserFullName)).clear();
		driver.findElement(By.xpath(UserEmail)).clear();

		driver.findElement(By.xpath(UserFullName)).sendKeys("TelleCallerNew");

		String TeleCaller4 = obj.getProperty("TeleCaller4");

		driver.findElement(By.xpath(UserEmail)).sendKeys(TeleCaller4);

		driver.findElement(By.xpath(DropDown)).sendKeys("Telecaller");

		driver.findElement(By.xpath(AddUser)).click();

		Thread.sleep(1000);

		if (message.getText().contains("User")) {

			String[] UseCase2 = { "Create new user TELECALLER", message.getText(), "Pass" };
			writer.writeNext(UseCase2);

		}

		else {

			String[] UseCase2 = { "Create new user TELECALLER", message.getText(), "Fail" };

			writer.writeNext(UseCase2);

		}
		Thread.sleep(9000);

		driver.findElement(By.xpath(UserFullName)).clear();
		driver.findElement(By.xpath(UserEmail)).clear();

		driver.findElement(By.xpath(UserFullName)).sendKeys("MarketerrNewUser");

		String Marketer1 = obj.getProperty("Marketer1");

		driver.findElement(By.xpath(UserEmail)).sendKeys(Marketer1);

		driver.findElement(By.xpath(DropDown)).sendKeys("Marketer");
		
		Thread.sleep(4000);

		
		driver.findElement(By.xpath(AddUser)).click();

		Thread.sleep(1000);

		if (message.getText().contains("User")) {

			String[] UseCase2 = { "Create new user MARKETER", message.getText(), "Pass" };
			writer.writeNext(UseCase2);

		}

		else {

			String[] UseCase2 = { "Create new user MARKETER", message.getText(), "Fail" };

			writer.writeNext(UseCase2);

		}
		Thread.sleep(3000);

	   WebElement editButton=driver.findElement(By.xpath(EditButton));
		
	   editButton.click();
		
		Thread.sleep(1000);

		driver.findElement(By.cssSelector(RemoveUser)).click();
		Thread.sleep(1000);
		if (message.getText().contains("User")) {

			String[] UseCase2 = { "Delete user MARKETER", message.getText(), "Pass" };
			writer.writeNext(UseCase2);

		}

		else {

			String[] UseCase2 = { "Delete new user MARKETER", message.getText(), "Fail" };

			writer.writeNext(UseCase2);

		}

		Thread.sleep(9000);
		driver.findElement(By.xpath(EditButton)).click();
		Thread.sleep(1000);

		driver.findElement(By.cssSelector(RemoveUser)).click();
		Thread.sleep(1000);
		if (message.getText().contains("User")) {

			String[] UseCase2 = { "Delete user Telecaller", message.getText(), "Pass" };
			writer.writeNext(UseCase2);

		}

		else {

			String[] UseCase2 = { "Delete new user Telecaller", message.getText(), "Fail" };

			writer.writeNext(UseCase2);

		}

		Thread.sleep(9000);

		driver.findElement(By.xpath(UserFullName)).clear();
		driver.findElement(By.xpath(UserEmail)).clear();

		driver.findElement(By.xpath(UserFullName)).sendKeys("JackTelleCaller");

		String TeleCaller5 = obj.getProperty("TeleCaller5");

		driver.findElement(By.xpath(UserEmail)).sendKeys(TeleCaller5);

		driver.findElement(By.xpath(DropDown)).sendKeys("Telecaller");

		Thread.sleep(2000);

		// driver.findElement(By.xpath(CloseButton)).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath(AddUser)).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath(EditButton)).click();
		driver.findElement(By.xpath(UserDropDown)).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[contains(text(),'JUST DIAL')]")).click();

		// driver.findElement(By.xpath(SelectField)).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath(Click)).click();
		driver.findElement(By.xpath(Click)).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath(UpdateUser)).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(EditButton)).click();

		Thread.sleep(2000);

		String fields = driver.findElement(By.xpath(SelectedField)).getText();

		System.out.println(fields);

		Thread.sleep(1000);

		if (fields.contains("Just"))

		{

			String[] UseCase2 = { "Telecaller leads marketplace updated", message.getText(), "Pass" };
			writer.writeNext(UseCase2);

		}

		else {

			String[] UseCase2 = { "Telecaller leads marketplace not updated", message.getText(), "Fail" };

			writer.writeNext(UseCase2);

		}

		Thread.sleep(1000);

		driver.findElement(By.xpath(CloseButton)).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath(EditButton)).click();
		Thread.sleep(1000);

		// select all fields validation

		String IndiaMart = obj.getProperty("IndiaMart");
		String TradeIndia = obj.getProperty("TradeIndia");
		String GoogleForm = obj.getProperty("GoogleForm");
		String API = obj.getProperty("API");
		String CustomForm = obj.getProperty("CustomForm");
		String ExcelUpload = obj.getProperty("ExcelUpload");
		String Shopify = obj.getProperty("Shopify");
		String JustDail = obj.getProperty("JustDail");
		Thread.sleep(1000);

		String RemoveFeilds = obj.getProperty("RemoveFeilds");
		Thread.sleep(1000);

		driver.findElement(By.xpath(RemoveFeilds)).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath(UserDropDown)).click();

		driver.findElement(By.xpath("//*[contains(text(),' EXCEL UPLOAD ')]")).click();

		driver.findElement(By.xpath("//*[contains(text(),' SHOPIFY ')]")).click();

		// driver.findElement(By.xpath("//*[contains(text(),' CUSTOM FORMS
		// ')]")).click();

		driver.findElement(By.xpath("//*[contains(text(),' API ')]")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath(Click)).click();
		driver.findElement(By.xpath(Click)).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath(UpdateUser)).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(EditButton)).click();

		Thread.sleep(2000);

		String FieldsList = obj.getProperty("FieldsList");
		// String listoffields= driver.findElement(By.xpath(FieldsList)).getText();

		List<WebElement> list = driver
				.findElements(By.xpath("/html/body/modal-container/div/div/form/div/div[2]/div/div[2]/ng-select/div"));

		Thread.sleep(2000);

		// Select dropdownlist= new Select(list);
		// System.out.println(dropdownlist.getOptions());

		System.out.println(list.size());

		// System.out.println(listoffields);

		if (list.contains("Trade"))

		{

			String[] UseCase2 = { "List of fields aaded", "list", "Pass" };
			writer.writeNext(UseCase2);

		}

		else {

			String[] UseCase2 = { "List of fields aaded failed", "list", "Fail" };

			writer.writeNext(UseCase2);

		}

		Thread.sleep(1000);

		driver.findElement(By.xpath(CloseButton)).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath(EditButton)).click();

		driver.findElement(By.cssSelector(RemoveUser)).click();

		// driver.findElement(By.xpath(CloseButton)).click();

		// lead assignment check

		driver.findElement(By.xpath(UserFullName)).clear();
		driver.findElement(By.xpath(UserEmail)).clear();

		String TeleCaller6 = obj.getProperty("TeleCaller6");

		driver.findElement(By.xpath(UserFullName)).sendKeys("JackTelleCallerLead");
		driver.findElement(By.xpath(UserEmail)).sendKeys(TeleCaller6);

		driver.findElement(By.xpath(DropDown)).sendKeys("Telecaller");

		Thread.sleep(2000);

		// driver.findElement(By.xpath(CloseButton)).click();
		// Thread.sleep(1000);

		driver.findElement(By.xpath(AddUser)).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath(EditButton)).click();

		String leadAssignmentToggle = obj.getProperty("leadAssignmentToggle");

		Boolean status = driver.findElement(By.xpath(leadAssignmentToggle)).isEnabled();

		if (status)

		{

			String[] UseCase2 = { "Lead Assignment Status", "on", "Pass" };
			writer.writeNext(UseCase2);

		}

		else {

			String[] UseCase2 = { "Lead Assignment Status", "Off", "Fail" };

			writer.writeNext(UseCase2);

		}

		Thread.sleep(1000);

		driver.findElement(By.xpath(CloseButton)).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath(EditButton)).click();

		Thread.sleep(2000);

		driver.findElement(By.cssSelector(RemoveUser)).click();

		Thread.sleep(8000);

		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/section/div/section/section/app-user-management/main/section/div[2]/div/div[2]/div/table/tbody/tr[2]/td[2]/div/span[2]")).click();

		Thread.sleep(1000);

		if (message.getText().contains("Verification")) {

			String[] UseCase2 = { "Verification Link Send", message.getText(), "Pass" };
			writer.writeNext(UseCase2);

		}

		else {

			String[] UseCase2 = { "Verification Link Send", message.getText(), "Fail" };

			writer.writeNext(UseCase2);

		}

		writer.close();

		// Telecaller Creation Change credentials before running the code

		driver.findElement(By.xpath(UserFullName)).clear();
		driver.findElement(By.xpath(UserEmail)).clear();

		String TeleCaller7 = obj.getProperty("TeleCaller7");

		String emailusertelecaller = TeleCaller7;
		String usernamenewtelecaller = "Saupnilone";

		driver.findElement(By.xpath(UserFullName)).sendKeys(usernamenewtelecaller);
		driver.findElement(By.xpath(UserEmail)).sendKeys(emailusertelecaller);

		driver.findElement(By.xpath(DropDown)).sendKeys("Telecaller");

		Thread.sleep(2000);

		driver.findElement(By.xpath(AddUser)).click();

		// Marketer Creation- Change credentials before running the code
		Thread.sleep(2000);

		driver.findElement(By.xpath(UserFullName)).clear();
		driver.findElement(By.xpath(UserEmail)).clear();
		Thread.sleep(2000);
		String TeleCaller8 = obj.getProperty("TeleCaller8");
		String emailusermarketer = TeleCaller8;
		String usernamenewmarketer = "Robinmarketer";
		Thread.sleep(2000);

		driver.findElement(By.xpath(UserFullName)).sendKeys(usernamenewmarketer);
		driver.findElement(By.xpath(UserEmail)).sendKeys(emailusermarketer);

		driver.findElement(By.xpath(DropDown)).sendKeys("Marketer");

		Thread.sleep(2000);

		driver.findElement(By.xpath(AddUser)).click();

		driver.close();

		CreateTelecaller(emailusertelecaller, usernamenewtelecaller);
		CreateMarketer(emailusermarketer, usernamenewmarketer);
	}

	public static void CreateTelecaller(String email, String username) throws Exception {

		System.setProperty("webdriver.chrome.driver", "/Users/alcodesmobility/Desktop/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://qa1.cronberry.com/admin/sign-in");

		InputStream input = Signup.class.getClassLoader().getResourceAsStream("Cronberryxpath.properties");

		Properties obj = new Properties();

		obj.load(input);

		driver.findElement(By.linkText("Sign up")).click();
		String emailid = obj.getProperty("Emailid");
		String password = obj.getProperty("Password");
		String retypepassowrd = obj.getProperty("Retypepassowrd");
		String submit = obj.getProperty("Submit");
		String UserPswd = obj.getProperty("UserPswd");

		WebElement emailid1 = driver.findElement(By.xpath(emailid));
		WebElement password1 = driver.findElement(By.xpath(password));

		WebElement retypepassowrd1 = driver.findElement(By.xpath(retypepassowrd));
		WebElement submit1 = driver.findElement(By.xpath(submit));

		submit1.click();
		// driver.findElement(By.linkText("Sign up")).click();

		Thread.sleep(1000);

		String toast = obj.getProperty("Toast");
		WebElement toast1 = driver.findElement(By.xpath(toast));
		Thread.sleep(5000);

		// telecaller creation

		emailid1.sendKeys(email);
		password1.sendKeys("12345");
		retypepassowrd1.sendKeys("12345");

		submit1.click();

		Thread.sleep(2000);

		String TeleCallerSubmit = obj.getProperty("TeleCallerSubmit");

		driver.findElement(By.xpath(TeleCallerSubmit)).click();

		String toastmessage = toast1.getText();

		CSVWriter writer = new CSVWriter(new FileWriter(new File(
				"/Users/alcodesmobility/eclipse-workspace/CronberryTestAutomation/CSV Sheets/tele caller creation - Sheet1.csv")),
				',');

		String[] header = { "UseCase", "Message", "Result" };
		writer.writeNext(header);

		// use case empty field validation

		if (toast1.getText().contains("Please"))

		{
			String[] UseCase = { "All blank field validation for Tele Caller profile page", toast1.getText(), "Pass" };
			writer.writeNext(UseCase);

		}

		else

		{
			String[] UseCase = { "Blank field validation for Tele Caller profile page", toast1.getText(), "Fail" };
			writer.writeNext(UseCase);

		}

		Thread.sleep(3000);

		String TeleCallerFirstName = obj.getProperty("TeleCallerFirstName");
		String TeleCallerLastName = obj.getProperty("TeleCallerLastName");

		driver.findElement(By.xpath(TeleCallerFirstName)).sendKeys("telecaller new");

		driver.findElement(By.xpath(TeleCallerLastName)).sendKeys("jain");

		String TeleCallerGender = obj.getProperty("TeleCallerGender");
		driver.findElement(By.xpath(TeleCallerGender)).sendKeys("Female");
		Thread.sleep(3000);

		String TermsCondition = obj.getProperty("TermsCondition");
		driver.findElement(By.xpath(TermsCondition)).click();

		driver.findElement(By.xpath(TeleCallerSubmit)).click();

//			String VerifiedEmail=obj.getProperty("VerifiedEmail");
//			String UnverifiedEmail=obj.getProperty("UnverifiedEmail");
//			
//			WebElement status=driver.findElement(By.xpath(VerifiedEmail));
//			
//			WebDriverWait wait = new WebDriverWait(driver, 100);
//				wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(UnverifiedEmail))));

		Thread.sleep(10000);

		String TeleCallerPhone = obj.getProperty("TeleCallerPhone");

		driver.findElement(By.xpath(TeleCallerPhone)).sendKeys("9598585585");
		Thread.sleep(3000);

		WebDriverWait wait = new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Verified')]")));

		driver.findElement(By.xpath(TeleCallerSubmit)).click();
		Thread.sleep(2000);

		if (toast1.getText().contains("User"))

		{
			String[] UseCase = { "Tele Caller Created", toast1.getText(), "Pass" };
			writer.writeNext(UseCase);

		}

		else

		{
			String[] UseCase = { "Tele Caller Created", toast1.getText(), "Fail" };
			writer.writeNext(UseCase);

		}

		writer.close();

		driver.close();

	}

	public static void CreateMarketer(String email, String username) throws Exception {

		System.setProperty("webdriver.chrome.driver", "/Users/alcodesmobility/Desktop/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://qa1.cronberry.com/admin/sign-in");

		InputStream input = Signup.class.getClassLoader().getResourceAsStream("Cronberryxpath.properties");

		Properties obj = new Properties();

		obj.load(input);

		driver.findElement(By.linkText("Sign up")).click();
		String emailid = obj.getProperty("Emailid");
		String password = obj.getProperty("Password");
		String retypepassowrd = obj.getProperty("Retypepassowrd");
		String submit = obj.getProperty("Submit");
		String UserPswd = obj.getProperty("UserPswd");

		WebElement emailid1 = driver.findElement(By.xpath(emailid));
		WebElement password1 = driver.findElement(By.xpath(password));

		WebElement retypepassowrd1 = driver.findElement(By.xpath(retypepassowrd));
		WebElement submit1 = driver.findElement(By.xpath(submit));

		submit1.click();
		// driver.findElement(By.linkText("Sign up")).click();

		Thread.sleep(1000);

		String toast = obj.getProperty("Toast");
		WebElement toast1 = driver.findElement(By.xpath(toast));
		Thread.sleep(5000);

		// telecaller creation

		emailid1.sendKeys(email);
		password1.sendKeys("12345");
		retypepassowrd1.sendKeys("12345");

		submit1.click();

		Thread.sleep(2000);

		String TeleCallerSubmit = obj.getProperty("TeleCallerSubmit");

		driver.findElement(By.xpath(TeleCallerSubmit)).click();

		String toastmessage = toast1.getText();

		CSVWriter writer = new CSVWriter(new FileWriter(new File(
				"/Users/alcodesmobility/eclipse-workspace/CronberryTestAutomation/CSV Sheets/Marketer Creation.xlsx")),
				',');

		String[] header = { "UseCase", "Message", "Result" };
		writer.writeNext(header);

		// use case empty field validation

		if (toast1.getText().contains("Please"))

		{
			String[] UseCase = { "All blank field validation for Marketer profile page", toast1.getText(), "Pass" };
			writer.writeNext(UseCase);

		}

		else

		{
			String[] UseCase = { "Blank field validation for Marketer profile page", toast1.getText(), "Fail" };
			writer.writeNext(UseCase);

		}

		Thread.sleep(3000);

		String TeleCallerFirstName = obj.getProperty("TeleCallerFirstName");
		String TeleCallerLastName = obj.getProperty("TeleCallerLastName");

		driver.findElement(By.xpath(TeleCallerFirstName)).sendKeys("telecaller new");

		driver.findElement(By.xpath(TeleCallerLastName)).sendKeys("jain");

		String TeleCallerGender = obj.getProperty("TeleCallerGender");
		driver.findElement(By.xpath(TeleCallerGender)).sendKeys("Male");
		Thread.sleep(3000);

		String TermsCondition = obj.getProperty("TermsCondition");
		driver.findElement(By.xpath(TermsCondition)).click();

		driver.findElement(By.xpath(TeleCallerSubmit)).click();

//			String VerifiedEmail=obj.getProperty("VerifiedEmail");
//			String UnverifiedEmail=obj.getProperty("UnverifiedEmail");
//			
//			WebElement status=driver.findElement(By.xpath(VerifiedEmail));
//			
//			WebDriverWait wait = new WebDriverWait(driver, 100);
//				wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(UnverifiedEmail))));

		Thread.sleep(10000);

		String TeleCallerPhone = obj.getProperty("TeleCallerPhone");

		driver.findElement(By.xpath(TeleCallerPhone)).sendKeys("9598585385");
		Thread.sleep(3000);

		WebDriverWait wait = new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Verified')]")));

		driver.findElement(By.xpath(TeleCallerSubmit)).click();
		Thread.sleep(2000);

		if (toast1.getText().contains("User"))

		{
			String[] UseCase = { "Marketer Created", toast1.getText(), "Pass" };
			writer.writeNext(UseCase);

		}

		else

		{
			String[] UseCase = { " Marketer Created", toast1.getText(), "Fail" };
			writer.writeNext(UseCase);

		}

		writer.close();

		driver.close();

	}



	

}
