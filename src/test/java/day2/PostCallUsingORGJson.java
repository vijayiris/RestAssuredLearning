package day2;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;




public class PostCallUsingORGJson {
	
	
   @Test
	public void CreateUserUsingORGJson() {
		
		
//		HashMap<String, String> data = new HashMap<String, String>();
//		data.put("Name", "Vijay");
//		data.put("job", "SDET");
		
		JSONObject data = new JSONObject();
		data.put("name", "Andrew");
		data.put("job", "SDET");
		
		
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
