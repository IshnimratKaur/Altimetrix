package restassuredTests;

import org.testng.annotations.Test;
import org.com.RestAPIBDD.RestAPIBDD.TestBase;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class putRequestTest extends TestBase {
	
	TestBase testbase;
	String serviceUrl;
	String serviceURLput;
	public static HashMap map = new HashMap();	
	String empName = RestUtils.empName();
	String empSalary = RestUtils.empSal();
	String empAge = RestUtils.empAge();
	int empid = 719;  //can give any data based on the requirement
	
	@BeforeClass
	public void putData() {
		map.put("name", empName);
		map.put("salary", empSalary);
		map.put("age", empAge);
		
		testbase = new TestBase();
		serviceUrl = prop.getProperty("URL");
		serviceURLput  = prop.getProperty("serviceURLput");
		RestAssured.baseURI = serviceUrl;
		RestAssured.basePath = serviceURLput +empid;
	}
	
	@Test
	public void testPUT() {
		given()
		  .contentType("application/json")
		  .body(map)
		.when()
		   .put()
		.then()
		   .assertThat().statusCode(RESPONSE_STATUS_CODE_200)
		   .log().all();
				
	}
}
