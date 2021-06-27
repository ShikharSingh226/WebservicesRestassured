package complexjson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class post {
	@Test
	 void RegistrationSuccessful()
	 {
	  
	  //base url
	  RestAssured.baseURI="https://rahulshettyacademy.com";
	  
	  //request obj
	  RequestSpecification httpRequest=RestAssured.given();
	  
	   
	  //request paylaod with post request
	  JSONObject requestParams=new JSONObject();
	  Map<String,String> locat = new HashMap<>();
	  locat.put("lat","-38.383494");
	  locat.put("lng","33427362");
	  requestParams.put("location", locat);
	  requestParams.put("accuracy","50");
	  requestParams.put("name","Frontline house");
	  requestParams.put("phone_number","(+91)9838933937");
	  requestParams.put("address","29,side layout, cohen 09");
	  List<String> ty = new ArrayList<String>();
	     ty.add("shoe park");
	     ty.add("shop");
	  requestParams.put("types",ty);   
	  
	  requestParams.put("website","http://google.com");
	  requestParams.put("language","French-IN");
	  
	  httpRequest.header("Content-Type","application/json");
	  
	  httpRequest.body(requestParams.toJSONString()); // attach above data to the request
	  
	  //response obj
	  Response response=httpRequest.request(Method.POST,"/maps/api/place/add/json?key=qaclick123");
	    
	  
	  //print response obj
	  
	  String responseBody=response.getBody().asString();
	  System.out.println("Response Body is:" +responseBody);
	  
	  //status code valid
	  int statusCode=response.getStatusCode();
	  System.out.println("Status code is: "+statusCode);
	  Assert.assertEquals(statusCode, 200);
	  
	  
	  
	 }
	
	
}
