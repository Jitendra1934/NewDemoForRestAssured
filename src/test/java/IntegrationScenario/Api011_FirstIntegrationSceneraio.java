package IntegrationScenario;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.testng.AllureTestNg;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


@Listeners({AllureTestNg.class}) 
public class Api011_FirstIntegrationSceneraio {

	// Create Token
	// Create Booking
	// Perform Put
	// Verify the put is success by Get
	// Delete ID
	// Verify it doesn't exist by Get

	RequestSpecification requestSpecification;
	Response response;
	ValidatableResponse validatableResponse;

	String accessToekn;
	String bookingID;

	public String getToken() {
		
		
		   String payload = "{\n" + 
                   "    \"username\": \"admin\",\n" + 
                   "    \"password\": \"password123\"\n" + 
                   "}";
		   
		   
		      requestSpecification = RestAssured.given();
		      requestSpecification.baseUri("https://restful-booker.herokuapp.com");
			  requestSpecification.basePath("/auth");
			  requestSpecification.contentType(ContentType.JSON);
			  requestSpecification.log().all();
			  requestSpecification.body(payload);
			  
			  
			  response = requestSpecification.when().post();
			  
			  
			  validatableResponse = response.then().log().all().statusCode(200);
			  
			  accessToekn = response.jsonPath().getString("token");
			  
			  System.out.println(accessToekn);
			  
			  return accessToekn;
			  
	}

	public String getBookingID() {
		
		
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
		
		  requestSpecification = RestAssured.given();
	      requestSpecification.baseUri("https://restful-booker.herokuapp.com");
		  requestSpecification.basePath("/booking");
		  requestSpecification.contentType(ContentType.JSON);
		  requestSpecification.log().all();
		  requestSpecification.body(body);
		  
		  
		  response = requestSpecification.when().post();
		  
		  
		  validatableResponse = response.then().log().all().statusCode(200);
		  
		  bookingID = response.jsonPath().getString("bookingid");
		  
		  System.out.println(bookingID);
		  
		  return bookingID;
		  	
	}

	@Test(priority = 1)
	public void update_put() {
		
		
		accessToekn = getToken();
		System.out.println(accessToekn);
		
		bookingID = getBookingID();
		System.out.println(bookingID);
		
		
		String body = "{"
                + "\"firstname\":\"Ansur\","
                + "\"lastname\":\"New\","
                + "\"totalprice\":111,"
                + "\"depositpaid\":true,"
                + "\"bookingdates\":{"
                + "\"checkin\":\"2018-01-01\","
                + "\"checkout\":\"2019-01-01\""
                + "},"
                + "\"additionalneeds\":\"Breakfast\""
                + "}";
		
		requestSpecification = RestAssured.given();
		requestSpecification.baseUri("https://restful-booker.herokuapp.com");
		requestSpecification.basePath("/booking/"+ bookingID);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.cookie("token", accessToekn);
		requestSpecification.log().all();
		requestSpecification.body(body);
		
		response = requestSpecification.when().log().all().put();
		
		validatableResponse = response.then().log().all();
		
		validatableResponse.statusCode(200);
		
		 		
	}

	@Test(priority = 2)
	public void update_put_get() {	
		
		requestSpecification = RestAssured.given();
		requestSpecification.baseUri("https://restful-booker.herokuapp.com");
		requestSpecification.basePath("/booking/"+ bookingID);
		requestSpecification.log().all();
		
		response = requestSpecification.when().log().all().get();
		
		validatableResponse = response.then().log().all();
		
		validatableResponse.statusCode(200);
		
		String firstname = response.jsonPath().getString("firstname");
		
		assertEquals(firstname, "Ansur");
		
		

	}

	@Test(priority = 3)
	public void delete_Booking() {
		
		requestSpecification = RestAssured.given();
		requestSpecification.baseUri("https://restful-booker.herokuapp.com");
		requestSpecification.basePath("/booking/"+ bookingID);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.cookie("token", accessToekn);
		requestSpecification.log().all();
		
		response = requestSpecification.when().log().all().delete();
		
		validatableResponse = response.then().log().all();
		
		validatableResponse.statusCode(201);// TODO  Status Code was changed 200 to 201
		

	}

	@Test(priority = 4)
	public void get_After_Delete() {

		requestSpecification = RestAssured.given();
		requestSpecification.baseUri("https://restful-booker.herokuapp.com");
		requestSpecification.basePath("/booking/"+ bookingID);
		requestSpecification.log().all();
		response = requestSpecification.when().log().all().get();
		
		validatableResponse = response.then().log().all();
		
		validatableResponse.statusCode(404);
	}

}
