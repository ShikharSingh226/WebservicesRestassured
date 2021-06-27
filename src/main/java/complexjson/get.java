package complexjson;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class get {

 @Test
 void getuserDetails()
 {
  //base url
  RestAssured.baseURI="https://rahulshettyacademy.com";
  
  //request obj
  RequestSpecification httpRequest=RestAssured.given();
  
  //response obj
  Response response=httpRequest.request(Method.GET,"/maps/api/place/get/json?place_id=3aaa6e463220ec00cd4ff55546c59ac4&key=qaclick123");
  
  //print response obj
  
  String responseBody=response.getBody().asString();
  System.out.println("Response Body is:" +responseBody);
  
  //status code valid
  int statusCode=response.getStatusCode();
  System.out.println("Status code is: "+statusCode);
  Assert.assertEquals(statusCode, 200);
  
  //status line valid
  String statusLine=response.getStatusLine();
  System.out.println("Status line is:"+statusLine);
  Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
  
 }
  
}