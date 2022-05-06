package com.api.RestAssuredNew.CRUD;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class getRequestDemo {
	
	@BeforeSuite
	void setUp()
	{
		System.out.println("setup");
	}
	
	@Test
	void get_Req()
	{
			RestAssured.baseURI="http://localhost:3000";
			RestAssured.basePath="persons";
			given().when().get().then().log().all().statusCode(200).body("firstName[0]", equalTo("Raghav"));
    }  
	
	
	@AfterSuite
	void tearDown()
	{  
		System.out.println("tearDown");
	}

}
