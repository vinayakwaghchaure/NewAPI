package com.api.RestAssuredNew.helpers;

import java.util.List;

import org.apache.http.HttpStatus;

import com.api.RestAssuredNew.constants.Endpoints;
import com.api.RestAssuredNew.model.Person;
import com.api.RestAssuredNew.utils.ConfigManager;
import com.fasterxml.jackson.core.type.TypeReference;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


import java.lang.reflect.Type;

public class PesrsonServiceHelper {

	//we need to read the config varible
	//rest Assured about the url port
	//make a get on this url and the data to testGetPerson

	private static final String BASE_URL=ConfigManager.getInstance().getString("baseURL");
	private static final String PORT=ConfigManager.getInstance().getString("port");

	public PesrsonServiceHelper()
	{
		RestAssured.baseURI=BASE_URL;
		RestAssured.port=Integer.parseInt(PORT);
		RestAssured.useRelaxedHTTPSValidation();// local api so that need 
	}

	public List<Person> getAllPerson()
	{
		Response response=RestAssured
				.given().log().all()
				.contentType(ContentType.JSON)
				.get(Endpoints.GET_ALL_PERSON)
				.andReturn();

		ResponseBody body = response.getBody();
		System.out.println(body.asString());


		Type type= new TypeReference<List<Person>>(){}.getType();

		List<Person> personList= response.as(type);
		return personList;

	}

	public Response CreatePerson()
	{
		Person person=new Person();
		person.setId(3);
		person.setFirstName("ajay");
		person.setLastName("Patil");
		person.setAge(22);
		person.setPhoneNumbers("3456789434");
		person.setAddress("DADAR");
		//need to make a post call
		Response response=RestAssured.given()
				.contentType(ContentType.JSON).log().all()
				.when()
				.body(person)
				.post(Endpoints.CREATE_PERSON)
				.andReturn();

		assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED,"Created");


		return response;
	}



	public Response updatePerson(Integer id)
	{
		Person person=new Person();
		person.setFirstName("Ram");
		person.setLastName("NATH");
		person.setAge(35);
		person.setPhoneNumbers("9876564645");
		person.setAddress("Mumbai");

		Response response=RestAssured.given()
				.contentType(ContentType.JSON)
				.pathParam("id", id).log().all()
				.when()
				.body(person)
				.patch(Endpoints.UPDATE_PERSON)
				.andReturn();

		assertTrue(response.getStatusCode()==HttpStatus.SC_OK);
		return response;

	}
	
	
	public Response deletePerson(Integer id)
	{
	
		Response response=RestAssured.given()
				.contentType(ContentType.JSON)
				.pathParam("id", id)
				.log().all()
				.when().delete(Endpoints.DELETE_PERSON)
				
				.andReturn();

		assertTrue(response.getStatusCode()==HttpStatus.SC_OK);
		return response;

	}
}
