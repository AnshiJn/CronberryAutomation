package CronberryApiTesting.CronberryApiTesting;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

public class BaseClass {
	
	
	public static Properties getProp=new Properties();
	public static String contentTyp="application/json";
	public static String BasicAutUsername="cronberry@username";
	public static String BasicAutUserPswd="cronberry@password";
	
	
	
	//json object
	
	public static JSONObject requestParams= new JSONObject();
	
	@BeforeClass
	void setUri() throws Exception {
		
		//accessing properties file
		FileReader reader=new FileReader("EndPoints.properties");
		getProp.load(reader);
		
		String uri=getProp.getProperty("baseURI");
	
		
		//specify base URI
		RestAssured.baseURI =uri;
		
	}
	

	
	
	
	


	
	
	
	
	
	
}
