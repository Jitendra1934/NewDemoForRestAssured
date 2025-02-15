package Payload;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class PayloadUsingnHashMap {
	
	@Test
	public static void CheckPayload() {

		/*
		 * { "firstname": "Sally", "lastname": "Brown", "totalprice": 111,
		 * "depositpaid": true, "bookingdates": { "checkin": "2013-02-23", "checkout":
		 * "2014-10-23" }, "additionalneeds": "Breakfast" }
		 */
		
		
		HashMap<String, Object> bookings = new HashMap<String, Object>();
		bookings.put("firstname", "Sally");
		bookings.put("lastname", "Brown");
		bookings.put("totalprice", 123);
		bookings.put("depositpaid", true);
		bookings.put("depositpaid", true);
		
		HashMap<String, Object> bookingDatesMap = new HashMap<String, Object>();
		bookingDatesMap.put("checkin","2013-02-23");
		bookingDatesMap.put("checkout", "2014-10-23");
		bookings.put("Bookingdates", bookingDatesMap);
		bookingDatesMap.put("additionalneeds", "Breakfast");
		

		RequestSpecification r =	 RestAssured.given();
		r.baseUri("https://restful-booker.herokuapp.com");
		r.basePath("/booking");
		r.contentType(ContentType.JSON);
		r.body(bookings).log().all();
		r.when().post();
		r.then().log().all().statusCode(200);


		
	}

}
