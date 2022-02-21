package com.bridgelabz;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestApi {

	@Test
	public void getTest() {
		Response response = RestAssured.get("http://localhost:3000/posts");

		System.out.println("Response code: " + response.getStatusCode());
		response.prettyPrint();

	}

	@Test
	public void postTest() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.header("Content-Type", "application/json");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", 2);
		jsonObject.put("title", "kalyanpost");
		jsonObject.put("author", "myauthor");
		requestSpecification.body(jsonObject.toJSONString());
		Response response = requestSpecification.post("http://localhost:3000/posts");
		System.out.println("responseCode: " + response.getStatusCode());
		response.prettyPrint();

	}

	@Test
	public void putTest() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.header("Content-Type", "application/json");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("title", "kalyan API Testing");
		jsonObject.put("author", "kalyan");
		requestSpecification.body(jsonObject.toJSONString());
		Response response = requestSpecification.put("http://localhost:3000/posts/2");
		System.out.println("responseCode: " + response.getStatusCode());
		response.prettyPrint();

	}

	@Test
	public void deleteTest() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.header("Content-Type", "application/json");
		Response response = requestSpecification.delete("http://localhost:3000/posts/11");
		System.out.println("responseCode: " + response.getStatusCode());
		response.prettyPrint();

	}

}