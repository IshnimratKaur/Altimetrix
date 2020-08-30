package restassuredTests;

import java.util.HashMap;

import org.com.RestAPIBDD.RestAPIBDD.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;

public class PostRequestTest extends TestBase{
	
	TestBase testbase;
	String serviceUrl;
	String serviceURLpost;
	public static HashMap map = new HashMap();
	
	@BeforeClass
		public void postdata() {
		
		map.put("Name", RestUtils.empName());
		map.put("Salary", RestUtils.empSal());
		map.put("Age", RestUtils.empAge());
		testbase = new TestBase();
		serviceUrl = prop.getProperty("URL");
		serviceURLpost = prop.getProperty("serviceURLpost");
		RestAssured.baseURI = serviceUrl;
		RestAssured.basePath = serviceURLpost;
		
	}

	@Test
	public void testPost() {
		given()
		  .contentType("application/json")
		  .accept("application/json")
		  .body(map)
		  
		  .when()
		   .post()
		   
		  .then()
		    .assertThat().statusCode(RESPONSE_STATUS_CODE_201)//config
		    .and()
		    .body("name",equalTo(RestUtils.empName())) 
		    .and()
		    .body("salary",equalTo(RestUtils.empSal()))
		    .and()
		    .body("age" ,equalTo(RestUtils.empAge()));		   
		 
	}
}
