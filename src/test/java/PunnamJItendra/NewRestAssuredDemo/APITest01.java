package PunnamJItendra.NewRestAssuredDemo;

import io.restassured.RestAssured;

public class APITest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
