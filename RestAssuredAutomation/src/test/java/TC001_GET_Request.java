
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC001_GET_Request {

	@Test
	void getweatherDetails() {
		//Specify base URL
		RestAssured.baseURI="https://www.trendyol.com/";
		
		//Request object
		RequestSpecification httpRequest=RestAssured.given();
		
		//Response object
		Response response=httpRequest.request(Method.GET,"/Hyderabad");
		
		//print response in console
		String responseBody=response.getBody().asString();
		System.out.println("Response body is:"+responseBody);
		
		//status code validation
		int statusCode=response.getStatusCode();
		System.out.println("status code is:"+statusCode);
		
		Assert.assertEquals(statusCode,200);
		
		//status line verification
		String statusLine=response.getStatusLine();
		System.out.println("Status line is"+statusLine);
		Assert.assertEquals(statusLine , "HTTP/1.1 200 OK");
	}
}
