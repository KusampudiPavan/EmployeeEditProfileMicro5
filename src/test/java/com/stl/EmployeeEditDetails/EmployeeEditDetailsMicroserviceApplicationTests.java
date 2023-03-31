package com.stl.EmployeeEditDetails;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.http.ContentType;


@SuppressWarnings("unused")
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeEditDetailsMicroserviceApplicationTests {

	@Test
	@Order(1)
	public void testupdate() {
		String jsonbody="{\"firstname\":\"Akhil\",\"lastname\":\"Maddu\",\"email\":\"akhil@gmail.com\",\"phonenumber\":\"9866787389\",\"password\":\"akhil\",\"manageremail\":\"manikanta@gmail.com\",\"gender\":\"Male\"}";
		String res=given()
				.header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(jsonbody)
				.when()
				.put("http://localhost:8086/employee/update/akhil@gmail.com")
				.then()
				.assertThat().statusCode(200)
				.extract().response().asString();
	}

}



