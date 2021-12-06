package API_Automation_Testing.API_Automation_Testing;


import org.json.simple.JSONObject;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jdk.jshell.Snippet.Status;
import junit.framework.Assert;

public class APITesting {

	@Test
	
  void getAPItesting() {
   
	RestAssured.baseURI="https://catalogue.dev1.cronberry.com/api/catalogue";
//    	
 	RequestSpecification url= RestAssured.given();
 	
  	Response response=url.request(Method.GET,"/listOfCatalogues");
   	
    	String printresponse= response.getBody().asString();
    	
    	System.out.println(printresponse);
    	
    	int statusCode= response.getStatusCode();
    	
    	System.out.println("statusCode"+statusCode);
    
    	Assert.assertEquals(statusCode,200);
    	 	
    }
      
//@Test	
//	void audienceapi() {
//	
//	//base uri
//		
//		RestAssured.baseURI="https://api.dev1.cronberry.com/cronberry/api/report";
//	
	//Request object
		
//		RequestSpecification audienceapi=RestAssured.given();
//		
//	JSONObject requestjson= new JSONObject();
//	
//	requestjson.put("userId", "ZHu8ynOXAZ7h3&+IoCIUsA==");
//	requestjson.put("fromDate", "");
//	requestjson.put("fromDate", "");
//	requestjson.put("source", "");
//
//	audienceapi.header("Content-Type","application/json");
//	  
//	audienceapi.body(requestjson.toJSONString());
//	
//	 Response response=audienceapi.request(Method.POST,"/fetch-audience-data");
//
//	  String responseBody=response.getBody().asString();
//	
//	  int statusCode=response.getStatusCode();
//	  System.out.println("Status code is: "+statusCode);
//	  Assert.assertEquals(statusCode, 200);	
//		
//	}

	
	@Test
	
	public void signapi() {
		
//		//base uri
//			
//			RestAssured.baseURI="https://api.dev1.cronberry.com/cronberry/api/user";
//		
//		//Request object
//			
//			RequestSpecification audienceapi=RestAssured.given();
//			
//		JSONObject requestjson= new JSONObject();
//		
//		requestjson.put("email", "testingprofile@mailinator.com");
//		requestjson.put("password", "123456");
//	
//		audienceapi.header("Content-Type","application/json");
//		  
//		audienceapi.body(requestjson.toJSONString());
//		
//		 Response response=audienceapi.request(Method.POST,"/sign-in");
//
//		  String responseBody=response.getBody().asString();
//		
//		  
//		  //status line verification
//		  String statusLine=response.getStatusLine();
//		  System.out.println("Status line is:"+statusLine);
//		  
//		  int statusCode=response.getStatusCode();
//		  System.out.println("Status code is: "+statusCode);
//		  Assert.assertEquals(statusCode, 200);	
		  
//		  //Specify base URI
//		  RestAssured.baseURI="https://api.dev1.cronberry.com/cronberry/api/user";
//		  
//		  //Request object
//		  RequestSpecification httpRequest=RestAssured.given();
//		     
//		  //Request paylaod sending along with post request
//
//		  JSONObject requestParams=new JSONObject();
//		  
//		  requestParams.put("email", "testingprofile@mailinator.com");
//		  requestParams.put("password", "123456");
//		
//		  
//		  httpRequest.header("Content-Type","application/json");
//		  
//		  httpRequest.body(requestParams.toJSONString()); // attach above data to the request
//		  
//		  //Response object
//		  Response response=httpRequest.request(Method.POST,"/sign-in");
//		    
//		  //print response in console window
//		  
//		  String responseBody=response.getBody().asString();
//		  System.out.println("Response Body is:" +responseBody);
//		  
//		  //status code validation
//		  int statusCode=response.getStatusCode();
//		  System.out.println("Status code is: "+statusCode);
//		  Assert.assertEquals(statusCode, 201);
//		  
//		  //success code validation
//		  String successCode=response.jsonPath().get("SuccessCode");
//		  Assert.assertEquals(successCode, "OPERATION_SUCCESS");
		
			String code= RestAssured.given().auth().preemptive().basic("testingprofile@mainator.com","1234567").when().get("https://api.dev1.cronberry.com/cronberry/api/user/sign-in").asString();
			
			System.out.print("Response of api"+code);
		
		
		
		
		}
	
}
	
	
	
	
	
	

