package com.api.RestAssuredNew.CRUD;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class UpdateUser {


	@Test
	void get_Req()
	{
		RestAssured.baseURI="https://reqres.in/api/users";
		String userdata ="{" +
				"\"name\" :\"RAM\","+
				"\"job\" :\"leader\"" +
				"}";
		given().body(userdata)
		.when()
		.patch()
		.then().log().all()
		.assertThat()
		.statusCode(200)
		.body("updatedAt", is(notNullValue()));

	}  

}
