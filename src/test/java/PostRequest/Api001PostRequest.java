package PostRequest;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Api001PostRequest {

	// -------------------------------Using BDD Style ---------------------------
	@Description("Test the post request")
	@Severity(SeverityLevel.MINOR)
	@Test
	public void New_PostReq() {

		String Payload = "{\n" + "    \"username\" : \"admin\",\n" + "    \"password\" : \"password123\"\n" + "}";

		RestAssured.given().baseUri("https://restful-booker.herokuapp.com").basePath("/auth")
				.contentType(ContentType.JSON).log().all().body(Payload).when().post().then().log().all()
				.statusCode(200);
	}

}
