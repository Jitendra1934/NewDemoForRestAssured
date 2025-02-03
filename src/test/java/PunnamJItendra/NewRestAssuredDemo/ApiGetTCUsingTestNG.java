package PunnamJItendra.NewRestAssuredDemo;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;

public class ApiGetTCUsingTestNG {
	
	@Description("First Allure Re[port")
	@Severity(SeverityLevel.CRITICAL)
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
