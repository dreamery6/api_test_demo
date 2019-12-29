package demo01;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class test_start {
	private static final Logger logger = LoggerFactory.getLogger(test_start.class);
	private static final String user_id = "23";
	private static final String token = "55fe8600-927a-11e9-bea7-1d10fbb9f745";

	 @Before
	public void setUP(){
	  //指定 URL 和端口号
	  RestAssured.baseURI = "http://47.101.179.0";
	  RestAssured.port = 9886;
	  RestAssured.basePath = "/app";
	  }
    @Test
	public void test() {
    	Map map = new HashMap<String, String>();
    	map.put("user_id", user_id);
    	map.put("token", token);
    	//Response response = given().params(map).when().get("/get_user_info").then().extract().response();
    	given().params(map).when().get("/get_user_info").then().assertThat().body("code", equalTo(10000));
    	//System.out.println(response.body().asString());
    }
}
