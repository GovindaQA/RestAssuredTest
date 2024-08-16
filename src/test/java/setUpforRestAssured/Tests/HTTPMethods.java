package setUpforRestAssured.Tests;

import org.testng.annotations.Test;

import jdk.internal.net.http.common.Log;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class HTTPMethods {
	int id;
	int id1;

	@Test(priority=1)
	void createUser() 
	{
		given()
		.when()
		.get("https://reqres.in/api/users/2")


		.then()
		.statusCode(200)
		.log().all();
		System.out.println("Get request is passed");

	}
	@Test(priority=2)
	void addUser()
	{
		HashMap data= new HashMap();
		data.put("Name", "Govinda");
		data.put("Designation", "QA");
		data.put("Joined", "Aug");

		id=given()
		.contentType("application/json")
		.body(data)
		.when()
		.post("https://reqres.in/api/user")
		.jsonPath().getInt("id");
		System.out.println("User is created: "+id);
//		.then()
//		.statusCode(201)
//		.log().all();
	}
	@Test(priority=3)
	void updateData()
	{

		HashMap data= new HashMap();
		data.put("Name", "Govinda");
		data.put("Designation", "QA ENGINEER");
		data.put("Joined", "Aug");

		given()
		.contentType("application/json")
		.body(data)
		.when()
		.put("https://reqres.in/api/users/"+id);
		System.out.println("Updated the account and the new id is: "+id);

//		.then()
//		.statusCode(200)
//		.log().all();
//		System.out.println("Updated the account");

	
	}
	@Test(priority=4)
	void deleteData()
	{
		given()
		.when()
		.delete("https://reqres.in/api/users/"+id)
		.then()
		.statusCode(204);
		System.out.println("Deleted the account");
		
	}

}
