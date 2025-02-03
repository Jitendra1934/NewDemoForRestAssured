package PunnamJItendra.NewRestAssuredDemo;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;

public class BddStyleGet_Request {
	
	
	
	@Description("first allure tc")
	@Severity(SeverityLevel.MINOR)
	@Test

	public void BddGet_Request() {
		
		
		RestAssured
		.given()
		.baseUri("https://restful-booker.herokuapp.com")
		.basePath("/booking/102")
		.when()
		.get()
		.then().log().all()
		.statusCode(200);
		
	}
}
