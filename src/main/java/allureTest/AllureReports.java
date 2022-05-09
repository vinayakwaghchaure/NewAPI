package allureTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AllureReports {
	
	@Severity(SeverityLevel.NORMAL)	
	@Test(priority=1, description="post request users Creation")
	@Description("post request users Creation.....")
	@Feature("Feature2: post request users Creation.....")
	@Story("Story:post request users Creation.....")
	@Step("post request users Creation.....")
	void post_Req()
	{
		RestAssured.baseURI="https://reqres.in/api/users";
		String userdata ="{" +
				"\"name\" :\"Vinayak\","+
				"\"job\" :\"leader\"" +
				"}";
		given().body(userdata)
		.when()
		.post()
		.then().log().all()
		.assertThat()
		.statusCode(201)
		.body("id", is(notNullValue()));
		
	}
	
	
	@Severity(SeverityLevel.NORMAL)	
	@Test(priority=2, description="get request download File ...")
	@Description("get request download File ...")
	@Feature("Feature2: get request get request download File ...")
	@Story("Story:get request download File ...")
	@Step("get request download File ...")
	public void downloadFile() throws IOException
	{
		Response response= RestAssured.given().log().all().when().get("https://reqres.in/api/users").andReturn();
		response.prettyPrint();
		byte[] bytes= response.getBody().asByteArray();
		File file=new File("D://vinayak/file/data.json");
		Files.write(file.toPath(), bytes);
	}

}
