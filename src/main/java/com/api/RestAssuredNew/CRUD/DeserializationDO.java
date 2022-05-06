package com.api.RestAssuredNew.CRUD;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Type;
import java.util.List;

import org.testng.annotations.Test;

import com.api.RestAssuredNew.model.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeserializationDO {
private static final ObjectMapper mapper=new ObjectMapper();
	  
	@Test
	void deserializationPost() throws JsonProcessingException
	{
		String url="http://localhost:3000/book/3";
		BlogPostPOJO blogpost_3=RestAssured.given().get(url).as(BlogPostPOJO.class);
		System.out.println("blogpost_3"+ blogpost_3.toString());
		
		String url2="http://localhost:3000/book";
		
		Type type= new TypeReference<List<BlogPostPOJO>>(){}.getType();
		
		List<BlogPostPOJO> blogpostlist=RestAssured.get(url2).as(type);
		
		System.out.println("blogpost_3"+ blogpostlist.toString());
		
		/*BlogPostPOJO allBlogs[]= RestAssured.get(url2).as(BlogPostPOJO[].class);
		System.out.println("All Blog2"+allBlogs);*/

	}
	

}
