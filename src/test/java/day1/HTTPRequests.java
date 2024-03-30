package day1;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;


public class HTTPRequests {
	
	int id;
	@Test(priority = 1)
	void getUsersList() {
		
		given()
		
		.when()
		 .get("https://reqres.in/api/users?page=2")
		
		.then()
		.statusCode(200)
		.body("page", equalTo(2))
		.log().all();
		
	}
	
	@Test(priority = 2)
	void createUser() {
		
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
	
	@Test(priority = 3, dependsOnMethods  = {"createUser"})
	void updateUser() {
		
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("Name", "Vijay Shankar Yadav");
		data.put("job", "Test Lead");
		
		
		given()
		.contentType("application/json")
		.body(data)
		
		
		.when()
		.put("https://reqres.in/api/users/"+id)
		
		
		
		.then()
		.statusCode(200)
		.log().all();
	
		
	}
	
	@Test(priority = 4,dependsOnMethods = {"createUser","updateUser"})
	void deleteUser() {
		
		
		given()
		.when()
		.delete("https://reqres.in/api/users/"+id)
		.then()
		.statusCode(204)
		.log().all();
	}

}
