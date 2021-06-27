package complexjson;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class delete {
	@Test
	  public void deletemethod() {
		//base url	
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		//request obj
		RequestSpecification request = RestAssured.given();	
		JSONObject requestParams=new JSONObject();
		// header stating req. body is a json
		request.header("Content-Type", "application/json");	
		
		requestParams.put("place_id", "3aaa6e463220ec00cd4ff55546c59ac4"); 
		requestParams.put("key","qaclick123");
	    // delete req. and check resp.
		Response response = request.delete("/maps/api/place/delete/json");		
		//status code valid
		int statusCode = response.getStatusCode();
		System.out.println(response.asString());
		Assert.assertEquals(statusCode, 200);
			
		
		}
	
	
	
	
}
