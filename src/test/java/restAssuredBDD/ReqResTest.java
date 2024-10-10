package restAssuredBDD;

import java.util.HashMap;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ReqResTest {
	
	@Test
	
	public void Test01getAllEmployee() {
		RestAssured.given()
		.baseUri("https://reqres.in/api/users")
		.when()
		.get()
		.then()
		.log()
		.all()
		.statusCode(200)
		.body("data.first_name[0]", Matchers.equalTo("George"));
	}
	
	@Test
	
	public void Test02getSingleEmployee() {
		
		RestAssured.given()
		.baseUri("https://reqres.in/api/users")
		.when()
		.get("/3")
		.then()
		.log()
		.all()
		.statusCode(200)
		.body("data.first_name", Matchers.equalTo("Emma"));;
		
	}
	
	@Test
	public void createEmployee() {
		
			Logger logger = Logger.getLogger("PostRequest");
		
		
			BasicConfigurator.configure();
			
			logger.info("started the post call using BDD");

			
			HashMap<String,String> obj = new HashMap<String,String>();
			
			
			obj.put("name", "Mahi");
			obj.put("job", "Teacher");
			
				RestAssured.given()
						.baseUri("https://reqres.in/api/users")
						.contentType(ContentType.JSON)
						.accept(ContentType.JSON)
						.body(obj)
						.when()
						.post()
						.then()
						.log()
						.all();
				
				logger.info("post call ended with---");
			
		
	}

}
