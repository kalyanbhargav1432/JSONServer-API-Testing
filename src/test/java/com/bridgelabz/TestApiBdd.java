package com.bridgelabz;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestApiBdd {
	@Test
	public void getTest() {
		RestAssured.given()
		.when().get("http://localhost:3000/posts")
		.then().assertThat().statusCode(200);
	}

	@Test
	public void postTest() {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", 4);
		jsonObject.put("title", "kalyan Api");
		jsonObject.put("author", "k");

		RestAssured.given()
		.header("Content-Type", "application/json")
		.body(jsonObject.toJSONString())
		.when()
		.post("http://localhost:3000/posts")
		.then().statusCode(201);
	}

	@Test
	public void putTest() {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("title", "kalyanBhargav ");
		jsonObject.put("author", "TK");

		RestAssured.given()
		.header("Content-Type", "application/json")
		.body(jsonObject.toJSONString())
		.when()
		.put("http://localhost:3000/posts/13")
		.then().statusCode(200);
	}

	@Test
	public void deleteTest() {

		JSONObject jsonObject = new JSONObject();

		RestAssured.given()
		.header("Content-Type", "application/json")
		.body(jsonObject.toJSONString())
		.when()
		.delete("http://localhost:3000/posts/3")
		.then().statusCode(200);
	}

}