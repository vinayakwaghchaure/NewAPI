package com.api.RestAssuredNew.Test;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertFalse;


import com.api.RestAssuredNew.helpers.PesrsonServiceHelper;
import com.api.RestAssuredNew.model.Person;

public class TestGETPerson {
	private PesrsonServiceHelper serviceHelper;


	@BeforeClass
	public void init()
	{
		serviceHelper=new PesrsonServiceHelper();

	}
	@Test
	public void testGetAllPersons()
	{
		List<Person> personList=serviceHelper.getAllPerson();
		assertNotNull(personList, "person list is not empty");
		assertFalse(personList.isEmpty(),"person list is not true");
	}

}
