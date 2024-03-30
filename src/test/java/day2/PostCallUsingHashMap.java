package day2;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;


public class PostCallUsingHashMap {
	
	int id;
	@Test(priority = 1)
	public void PostCallUsingHashMapCollection() {
		
		
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("Name", "Vijay");
		data.put("job", "SDET");
		
		
		id = given()
		.contentType("application/json")
		.body(data)
		
		
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		
		
	/*	.then()
		.statusCode(201)
		.log().all();
	*/	
	}
	
	@Test(priority = 2)
	void deleteUser() {
		
		
		given()
		.when()
		.delete("https://reqres.in/api/users/"+id)
		.then()
		.statusCode(204)
		.log().all();
	}
	
	

}
