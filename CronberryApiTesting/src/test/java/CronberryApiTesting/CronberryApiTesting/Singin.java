package CronberryApiTesting.CronberryApiTesting;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Singin extends BaseClass {

	
	@Test(priority=1, description="login test")
	@Severity(SeverityLevel.NORMAL)
	@Description("this is logintest")
	void signIn() {
		
		
		requestParams.put( "email", "aja@kkd.com");
		requestParams.put( "password", "apitesting02");
		
		String siginAPI=getProp.getProperty("siginAPI");
		
		Response response=RestAssured.given().when()
				.auth().preemptive()
				.basic(BasicAutUsername, BasicAutUserPswd)
				.contentType(contentTyp)
				.body(requestParams.toJSONString())
				.post(siginAPI).then().extract().response();

	
		System.out.println(response.asString());
		System.out.println(response.statusCode());
		
		
	}
	
	
	
}
