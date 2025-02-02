package PunnamJItendra.NewRestAssuredDemo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class ApiGetTCUsingTestNG {
	
	@Test
	public void Get_Request() {
		
		RestAssured
		.given()
		.baseUri("https://restful-booker.herokuapp.com")
		.basePath("/booking/1")
		.when()
		.get()
		.then().log().all()
		.statusCode(200);
		
	}

}
