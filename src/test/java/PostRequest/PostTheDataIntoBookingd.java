package PostRequest;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class PostTheDataIntoBookingd {
	
	@Description("Post the data into bookings")
	@Test
	public void postTheDataIntoBookings() {
		
		
		/*
		 * String body = { "firstname" : "Jim", "lastname" : "Brown", "totalprice" :
		 * 111, "depositpaid" : true, "bookingdates" : { "checkin" : "2018-01-01",
		 * "checkout" : "2019-01-01" }, "additionalneeds" : "Breakfast" }'
		 */		
		 String body = "{"
	                + "\"firstname\":\"Jithu\","
	                + "\"lastname\":\"New\","
	                + "\"totalprice\":111,"
	                + "\"depositpaid\":true,"
	                + "\"bookingdates\":{"
	                + "\"checkin\":\"2018-01-01\","
	                + "\"checkout\":\"2019-01-01\""
	                + "},"
	                + "\"additionalneeds\":\"Breakfast\""
	                + "}";
		
			/*
			 * RestAssured.given() .baseUri("https://restful-booker.herokuapp.com")
			 * .basePath("/booking") .contentType(ContentType.JSON) .body(body)
			 * .when().post() .then().log().all().statusCode(200);
			 */
		 
	RequestSpecification r =	 RestAssured.given();
			r.baseUri("https://restful-booker.herokuapp.com");
			r.basePath("/booking");
			r.contentType(ContentType.JSON);
			r.body(body).log().all();
			r.when().post();
			r.then().log().all().statusCode(200);
	}
	
	

}
