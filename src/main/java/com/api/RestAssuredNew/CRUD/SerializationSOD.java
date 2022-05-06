package com.api.RestAssuredNew.CRUD;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SerializationSOD {
	
	private static final ObjectMapper mapper=new ObjectMapper();

	
	@Test
	void serializationPost() throws JsonProcessingException
	{
		BlogPostPOJO bp=new BlogPostPOJO();
		bp.setId("5");
		bp.setTitle("BLOG");
		bp.setAuthor("Kiran");
		
		String url="http://localhost:3000/book";
		String json=mapper.writeValueAsString(bp);
		
		Response response= RestAssured.given().contentType("application/json")
				.log().all(true).body(json).post(url).andReturn();
		System.out.println(response);
		assertEquals(response.getStatusCode(), 201,"HTTP Message");
		
		
	}

}
