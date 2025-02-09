package PunnamJItendra.NewRestAssuredDemo;

import io.restassured.RestAssured;

public class APITest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Get all the bookings 
		RestAssured
					.given()
					.baseUri("https://restful-booker.herokuapp.com")
					.basePath("/booking")
					.when()
					.get()
					.then().log().all()
					.statusCode(200);

	}

}
