package CreateToken;

import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ApiPost002 {
    
    @Description("Test the POST request using Non-BDD approach")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void New_PostReqNonBDD() {

        // Define JSON Payload
        String payload = "{\n" + 
                         "    \"username\": \"admin\",\n" + 
                         "    \"password\": \"password123\"\n" + 
                         "}";
		
		
		 RequestSpecification r = RestAssured.given();
		  r.baseUri("https://restful-booker.herokuapp.com");
		  r.basePath("/auth");
		  r.contentType(ContentType.JSON);
		  r.log().all();
		  r.body(payload);
		  r.when().post().then().log().all().statusCode(200);
		 
		 
    }
}
