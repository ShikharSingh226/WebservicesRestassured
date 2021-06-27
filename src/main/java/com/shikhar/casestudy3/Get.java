package com.shikhar.casestudy3;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get{

 
 @Test
 void getuserDetails()
 {
  //Specify base URI
  RestAssured.baseURI="https://rahulshettyacademy.com";
  
  //Request object
  RequestSpecification httpRequest=RestAssured.given();
  
  //Response object
  Response response=httpRequest.request(Method.GET,"/maps/api/place/get/json?place_id=xxxx&key=qaclick123");
  
  //print response in console window
  
  String responseBody=response.getBody().asString();
  System.out.println("Response Body is:" +responseBody);
  
  //status code validation
  int statusCode=response.getStatusCode();
  System.out.println("Status code is: "+statusCode);
  Assert.assertEquals(statusCode, 200);
  
  //status line verification
  String statusLine=response.getStatusLine();
  System.out.println("Status line is:"+statusLine);
  Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
  
 }
  
}