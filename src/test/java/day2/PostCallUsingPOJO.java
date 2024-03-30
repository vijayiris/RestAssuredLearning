package day2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class PostCallUsingPOJO {

	
	@Test
	public void POstUsingPOJO() {
		
		
//		JSONObject data = new JSONObject();
//		data.put("name", "Andrew");
//		data.put("job", "SDET");
		
		POJOClass data = new POJOClass();
		data.setJob("SDET");
		data.setName("Johny");
		
		given()
		.contentType("application/json")
		.body(data)
		
		
		.when()
		.post("https://reqres.in/api/users")
		
		
		
		.then()
		.statusCode(201)
		.body("name", equalTo("Johny"))
		.body("job", equalTo("SDET"))
		.log().all();
	}
}
