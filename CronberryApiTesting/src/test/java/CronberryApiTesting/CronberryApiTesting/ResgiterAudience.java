package CronberryApiTesting.CronberryApiTesting;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;



public class ResgiterAudience extends BaseClass{

	
	public static Properties objData= new Properties();
	SoftAssert softassert= new SoftAssert();


	@BeforeClass
	public void ResgiterAudience() throws Exception {
		
		//accessing properties data file
		FileReader dataReader=new FileReader("testData.properties");
		objData.load(dataReader);	
	}
	

	

	
	
	@Test(priority=1,description="case checked with valid project key, audience id, email id")
	@Severity(SeverityLevel.NORMAL)
	@Description("case checked with valid project key, audience id, email id")
	
	 void RegisterAudienceTestCaseOne() {
		
		 String audienceId=objData.getProperty("audienceId");
		 String projectKey=objData.getProperty("projectKey");
		 String email=objData.getProperty("email");

		
		
		 String registerAudienceAPI=getProp.getProperty("registerAudienceAPI");
		 System.out.println("this is project key"+projectKey);
		requestParams.put( "projectKey", projectKey);
		requestParams.put( "audienceId", audienceId);
		requestParams.put("email", email);
		
		
		RestAssured.given().when().contentType(contentTyp).body(requestParams.toJSONString())
		.post(registerAudienceAPI)
		.then()
		.body("data",equalTo("Record submitted successfully"))
		.body("status",equalTo(true))
		.statusCode(200);
				
	}

	
	
	@Test(priority=2,description="case checked with valid project key, audience id, web fcmtoken")
	@Severity(SeverityLevel.NORMAL)
	@Description("case checked with valid project key, audience id, web fcmtoekn")
	
	void RegisterAudienceTestCaseTwo() {
		
		
		 String audienceId=objData.getProperty("audienceId");
		 String projectKey=objData.getProperty("projectKey");
		 String web_fcm_token=objData.getProperty("web_fcm_token");
		 String registerAudienceAPI=getProp.getProperty("registerAudienceAPI");
		
		 System.out.println("this is project key"+projectKey);
		
		requestParams.put( "projectKey", projectKey);
		requestParams.put( "audienceId"+"01", audienceId);
		requestParams.put("web_fcm_token", web_fcm_token);
		
		
			RestAssured.given()
			.when()
			.contentType(contentTyp)
			.body(requestParams.toJSONString())
			.post(registerAudienceAPI)
			.then()
			.body("data",equalTo("Record submitted successfully"))
			.body("status",equalTo(true))
			.statusCode(200);
		
		
	}
		
	

	@Test(priority=3,description="case checked with valid project key, audience id, mobile")
	@Severity(SeverityLevel.NORMAL)
	@Description("case checked with valid project key, audience id, mobile")
	
	void RegisterAudienceTestCaseThree() {
		
		
		 String audienceId=objData.getProperty("audienceId");
		 String projectKey=objData.getProperty("projectKey");
		 String mobile=objData.getProperty("mobile");
		 String registerAudienceAPI=getProp.getProperty("registerAudienceAPI");
		
		 System.out.println("this is project key"+projectKey);
		
		requestParams.put( "projectKey", projectKey);
		requestParams.put( "audienceId"+"02", audienceId);
		requestParams.put("mobile", mobile);
		
		
			RestAssured.given()
			.when()
			.contentType(contentTyp)
			.body(requestParams.toJSONString())
			.post(registerAudienceAPI)
			.then()
			.body("data",equalTo("Record submitted successfully"))
			.body("status",equalTo(true))
			.statusCode(200);
		
		
	}

	@Test(priority=3,description="case checked with valid project key, audience id")
	@Severity(SeverityLevel.NORMAL)
	@Description("case checked with valid project key, audience id")
	
	void RegisterAudienceTestCaseTfour() {
		
		
		 String audienceId=objData.getProperty("audienceId");
		 String projectKey=objData.getProperty("projectKey");

		 String registerAudienceAPI=getProp.getProperty("registerAudienceAPI");
		
		 System.out.println("this is project key"+projectKey);
		
		requestParams.put( "projectKey", projectKey);
		requestParams.put( "audienceId"+"03", audienceId);
	
		
			RestAssured.given()
			.when()
			.contentType(contentTyp)
			.body(requestParams.toJSONString())
			.post(registerAudienceAPI)
			.then()
			.body("error_msgs",equalTo("Invalid Parameters"))
			.body("status",equalTo(false))
			.statusCode(200);
		
		
	}
	
	
	
	
}
