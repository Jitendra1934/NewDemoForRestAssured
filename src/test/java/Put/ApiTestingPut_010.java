package Put;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class ApiTestingPut_010 {
	
	@Description("Verify put requets")
	@Test
	public void NonBddPut010() {
		
		/*
		 *
		 *curl -X PUT \
  		https://restful-booker.herokuapp.com/booking/1 \
  		-H 'Content-Type: application/json' \
  		-H 'Accept: application/json' \
  		-H 'Cookie: token=abc123' \
  -d '{
    "firstname" : "James",
    "lastname" : "Brown",
    "totalprice" : 111,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2018-01-01",
        "checkout" : "2019-01-01"
    },
    "additionalneeds" : "Breakfast"
}'
		 */
		

//5e3f4a99021a258 ------------- Token
//
//3824 ---------------- booking d 
		
		String Generatedtoken = "9ae5f70ec0de289";
		String id = "335";
		
		String payload = "{"
                + "\"firstname\":\"Bala\","
                + "\"lastname\":\"New York03\","
                + "\"totalprice\":111,"
                + "\"depositpaid\":true,"
                + "\"bookingdates\":{"
                + "\"checkin\":\"2018-01-01\","
                + "\"checkout\":\"2019-01-01\""
                + "},"
                + "\"additionalneeds\":\"Breakfast\""
                + "}";
	
		RequestSpecification r = RestAssured.given();	
		r.baseUri("https://restful-booker.herokuapp.com");
		r.basePath("/booking/"+id);
		r.contentType(ContentType.JSON);
		r.cookie("token",Generatedtoken);
		r.body(payload).log().all();
		
		
		Response response = r.when().put();
		
		ValidatableResponse validatableResponse = response.then().log().all();
		
		validatableResponse.statusCode(200);
		
	}

}
