package com.api.RestAssuredNew.CRUD;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JsonPathdemo {
	
	@BeforeSuite
	void setUp()
	{
		System.out.println("setup");
	}

	@Test
	void get_Req1()
	{
		RestAssured.baseURI="http://localhost:3000/person";
		//String url ="http://localhost:3000";
		Response response= RestAssured.given().get(RestAssured.baseURI="http://localhost:3000/persons").andReturn();
		        response.getBody().prettyPrint();
		        JsonPath jsonPath=response.jsonPath();
		        String result =jsonPath.get("firstName[1]");
		        System.out.println("result :"+result);
    }  
	
	@AfterSuite
	void tearDown()
	{  
		System.out.println("tearDown");
	}

}
