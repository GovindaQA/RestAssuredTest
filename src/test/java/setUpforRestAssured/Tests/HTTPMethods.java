package setUpforRestAssured.Tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HTTPMethods {
	
	@Test
	void getUser() 
	{
		given()
		.when()
		.get("https://reqres.in/api/users?page=2")

		
		.then()
		.statusCode(200);
		
		System.out.println("Validation is passed");
		
	}
	@Test
	void addUser()
	{
		
	}

}
