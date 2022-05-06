package com.api.RestAssuredNew.Test;

import static org.testng.Assert.assertNotNull;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.api.RestAssuredNew.helpers.PesrsonServiceHelper;

public class TestPATCHPerson {
	
	private PesrsonServiceHelper serviceHelper;


	@BeforeClass
	public void init()
	{
		serviceHelper=new PesrsonServiceHelper();
	}
	
	@Test
	public void testPatchPerson()
	{
		String id=serviceHelper.updatePerson(3).jsonPath().getString("id");
		System.out.println(id);
		assertNotNull(id, "Updated");
	}

}
