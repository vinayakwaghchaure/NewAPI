package com.api.RestAssuredNew.Test;


import static org.testng.Assert.assertNotNull;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.api.RestAssuredNew.helpers.PesrsonServiceHelper;
import com.api.RestAssuredNew.model.Person;

public class TestPostPerson {
	
	private PesrsonServiceHelper serviceHelper;


	@BeforeClass
	public void init()
	{
		serviceHelper=new PesrsonServiceHelper();
	}
	
	@Test
	public void testPOSTCreatePerson()
	{
		String id=serviceHelper.CreatePerson().jsonPath().getString("id");
		System.out.println(id);
		assertNotNull(id, "person ID is not Null");
	}

}
 