package restassuredTests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.com.RestAPIBDD.RestAPIBDD.TestBase;
import static io.restassured.RestAssured.*;

public class GetRequestTest extends TestBase {
	
	TestBase testbase;
	String serviceUrl;
	String serviceURLget;
	int empid = 719; // can give any idea, based on the requirement
	
	@BeforeTest
	public void setUp() throws IOException {
		testbase = new TestBase();
		serviceUrl = prop.getProperty("URL");
		serviceURLget = prop.getProperty("serviceURLget");
		
		RestAssured.baseURI = serviceUrl;
		RestAssured.basePath = serviceURLget;	
	}
	
	@Test
	public void getEmployeeDetails() {
		given()
		 .when()
		   .get(RestAssured.baseURI + RestAssured.basePath + empid) 
		 .then()
		 .assertThat().statusCode(RESPONSE_STATUS_CODE_200)
		 .assertThat().body("id", equalTo(empid))
		 .header("Content-Type", "application/json");		
	}
}
