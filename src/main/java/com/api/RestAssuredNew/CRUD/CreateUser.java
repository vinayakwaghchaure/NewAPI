package com.api.RestAssuredNew.CRUD;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class CreateUser {
	
	@Test
	void get_Req()
	{
		RestAssured.baseURI="https://reqres.in/api/users";
		String userdata ="{" +
				"\"name\" :\"Vinayak\","+
				"\"job\" :\"leader\"" +
				"}";
		given().body(userdata)
		.when()
		.post()
		.then().log().all()
		.assertThat()
		.statusCode(201)
		.body("id", is(notNullValue()));
		
	}  

}
