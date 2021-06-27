import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Put {
		
		
		@Test
		 void Putup(){
		RestAssured.baseURI ="https://reqres.in";
		RequestSpecification request = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "morpheus"); // Cast
		requestParams.put("job", "zion resident");

		request.body(requestParams.toJSONString());
		Response response = request.put("/api/users/2");

		int statusCode = response.getStatusCode();
		System.out.println(response.asString());
		Assert.assertEquals(statusCode, 200); 

	}
}


