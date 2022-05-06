package com.api.RestAssuredNew.CRUD;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DownloadFile {
	
	@Test
	public void downloadFile() throws IOException
	{
		Response response= RestAssured.given().log().all().when().get("https://reqres.in/api/users").andReturn();
		response.prettyPrint();
		byte[] bytes= response.getBody().asByteArray();
		File file=new File("D://vinayak/file/data.json");
		Files.write(file.toPath(), bytes);
	}

}
