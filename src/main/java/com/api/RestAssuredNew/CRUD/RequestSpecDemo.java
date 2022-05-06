package com.api.RestAssuredNew.CRUD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestSpecDemo {


	static RequestSpecification getCommonSpec()
	{
		RequestSpecBuilder builder=new RequestSpecBuilder();
		builder.setBaseUri("https://reqres.in/");
		builder.setBasePath("api/users");
		RequestSpecification requestSpec=builder.build();

		return requestSpec;
	}


	/*public static void main(String[] args) {
		test_withoutparam();
		test_withparam();

	}
	 */

	/*@Test
	public void tst1()
	{
		test_withoutparam();

	}*/
	@Test
	public void tst2()
	{
		test_withparam();		
	}
	static void test_withoutparam()
	{
		Response response= RestAssured
				.given()
				.spec(getCommonSpec())
				.when() 
				.get();

		response.getBody().prettyPrint();
	}


	static void test_withparam()
	{
		Response response= RestAssured
				.given()
				.spec(getCommonSpec())
				.queryParam("page", "2")
				.when()
				.get();

		response.getBody().prettyPrint();
	}



}
