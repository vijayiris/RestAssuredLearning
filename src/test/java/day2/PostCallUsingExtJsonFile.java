package day2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.internal.support.FileReader;

public class PostCallUsingExtJsonFile {
	
	
	@Test()
	public void postcallUsingExtJson() throws FileNotFoundException {
		
//		POJOClass data = new POJOClass();
//		data.setJob("SDET");
//		data.setName("Johny");
		
		File f = new File(".\\ext.json");
		java.io.FileReader fr  = new java.io.FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt);
		
		given()
		.contentType("application/json")
		.body(data.toString())
		
		
		.when()
		.post("https://reqres.in/api/users")
		
		
		
		.then()
		.statusCode(201)
		.body("name", equalTo("Andrew"))
		.body("job", equalTo("SDET"))
		.log().all();
		
	}

}
