package asyncDemo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class ProxySettings {
   
	@Test
	public void proxy()
	{
		//RestAssured.proxy("127.0.0.1", 8080);
		 
		RestAssured.proxy("127.0.0.1", 3000);
		RestAssured.given().when().get("http://localhost:3000/book").then().log().all();
	}

}
