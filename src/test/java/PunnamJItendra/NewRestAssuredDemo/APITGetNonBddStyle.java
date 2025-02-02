package PunnamJItendra.NewRestAssuredDemo;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class APITGetNonBddStyle {
	
	static RequestSpecification r = RestAssured.given();
	
	@Severity(SeverityLevel.CRITICAL)
	@Description("Non Bdd Positive test Case")
	@Test
	public void nonBddStylePositive() {
		
		
		r.baseUri("https://restful-booker.herokuapp.com");
		r.basePath("/booking/1");
		r.when().log().all().get();
		r.then().log().all().statusCode(200);
		
	}
	
	
	@Description("Non Bdd Negitive Test Case")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void nonBddStyleNegitive() {
		
		
		r.baseUri("https://restful-booker.herokuapp.com");
		r.basePath("/booking/-1");
		r.when().log().all().get();
		r.then().log().all().statusCode(404);
		
	}
	

}
