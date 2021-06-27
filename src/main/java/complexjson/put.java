package complexjson;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class put {
	@Test
	void Putup(){
	//base url
	RestAssured.baseURI ="https://rahulshettyacademy.com";
	//request obj
	RequestSpecification request = RestAssured.given();
	//request paylaod with post request
	JSONObject requestParams = new JSONObject();
	requestParams.put("place_id", "3aaa6e463220ec00cd4ff55546c59ac4"); 
	requestParams.put("address", "70 Summer Walk, USA");
    requestParams.put("key","qaclick123");

	request.body(requestParams.toJSONString());
	//response obj
	Response response = request.put("/maps/api/place/update/json");
	//status code valid
	int statusCode = response.getStatusCode();
	System.out.println(response.asString());
	Assert.assertEquals(statusCode, 200); 

}
}
