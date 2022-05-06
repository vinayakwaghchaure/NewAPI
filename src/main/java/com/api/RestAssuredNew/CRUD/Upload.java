package com.api.RestAssuredNew.CRUD;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Upload {
	
	File file=new File("D://Users/Vinayak.Waghchaure/Pictures/Saved Pictures/pic.png");
	
	//https://the-internet.herokuapp.com/upload
	@Test
	public void UploadFile()
	{
		
		Response response = RestAssured.given()
				.multiPart("file",file,"multipart/form-data")
				.post("https://the-internet.herokuapp.com/upload").thenReturn();
		
		System.out.println(response.prettyPrint());
	}

}
