package day3;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.net.http.HttpResponse.BodyHandler;

import org.json.JSONObject;


public class ParsingJSONObject {
	
	
	@Test
	 void ParseJSONObjectApproach1() {
		 
	    given()
		.contentType("ContentType.JSON")
		
		.when()
		.get("https://reqres.in/api/users")
		
		
		.then()
		.log().ifValidationFails()
		.statusCode(200)
		.header("X-Powered-By", "Express")
	    .body("data[5].avatar", equalTo("https://reqres.in/img/faces/6-image.jpg"));

		
		
	}  
	
	
/*	void ParseJSONObjectApproach2() {
		
	    Response res = given()
		.contentType("ContentType.JSON")
		
		.when()
		.get("https://reqres.in/api/users");
	    Assert.assertEquals(res.getStatusCode(), 200);
	    Assert.assertEquals(res.getHeader("X-Powered-By"), "Express");
	    Assert.assertEquals(res.getHeader("Cache-Control"), "max-age=14400");
	    String avatarref = res.jsonPath().get("data[5].avatar").toString();
	    Assert.assertEquals(avatarref, "https://reqres.in/img/faces/6-image.jpg");
	    
	} */
	
/*	@Test
	void ParseJSONObjectApproach3() {
		
	    Response res = given()
		.contentType(ContentType.JSON)
		
		.when()
		.get("https://reqres.in/api/users");
	    Assert.assertEquals(res.getStatusCode(), 200);
	    Assert.assertEquals(res.getHeader("X-Powered-By"), "Express");
	    Assert.assertEquals(res.getHeader("Cache-Control"), "max-age=14400");
	    String avatarref = res.jsonPath().get("data[5].avatar").toString();
	    //System.out.println("Avatar Ref---------->"+ avatarref);
	    Assert.assertEquals(avatarref, "https://reqres.in/img/faces/6-image.jpg");
        JSONObject jo = new JSONObject(res.asString());
	    
	    for(int i = 0;i<jo.getJSONArray("data").length();i++) {
	    	
	    	String avatarLink = jo.getJSONArray("data").getJSONObject(i).get("avatar").toString();
	    	System.out.println("All Avatar Links  ------------> "  +avatarLink);  
	    	
	    	
	    	
	    }  */

		
	//}
	

	
	
	
	

}
