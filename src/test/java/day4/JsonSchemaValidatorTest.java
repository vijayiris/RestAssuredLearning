package day4;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import java.net.http.HttpResponse.BodyHandler;

import org.json.JSONObject;


public class JsonSchemaValidatorTest {
	
	
	@Test
	void jsonSchemaValidationMethod() {
		
		given()
		.when()
		.get("https://reqres.in/api/users")
		
		.then()
		.assertThat()
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("SampleJsonFile.json"));
		
		
	}

}
