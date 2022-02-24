package com.bridgelabz;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TwitterApiTest {
	@Test
	public void postTweet() {
		Response response = RestAssured.given().auth()
				.oauth("TTQQO4y0DJGZLBU2LcU1VJECQ", "qkf8Rj3kggsjkvc2mF5sBLvE8k93ZL9Q74nPzKujFwJ8QAofoV",
						"4003503614-NqJnAeZ2s6oHIPEWsNJnKDoKB4TtIPD2oOFUSuW",
						"CsW3W4jEd4OarUqbqaJSSVzy808HEAB5uyGyZDA9QrLZR")
				.post("https://api.twitter.com/1.1/statuses/update.json?status=kalyan first tweet in twitter");

		System.out.println("status code: " + response.getStatusCode());
		System.out.println("time taken: " + response.getTime());
		System.out.println("status line: " + response.getStatusLine());
		response.prettyPrint();

		JsonPath jsonPath = response.jsonPath();

		String id_str = jsonPath.getString("id_str");
		System.out.println("-------------------");
		System.out.println(id_str);
	}

	@Test
	public void retweetTest() {

		Response response = RestAssured.given().auth()
				.oauth("TTQQO4y0DJGZLBU2LcU1VJECQ", "qkf8Rj3kggsjkvc2mF5sBLvE8k93ZL9Q74nPzKujFwJ8QAofoV",
						"4003503614-NqJnAeZ2s6oHIPEWsNJnKDoKB4TtIPD2oOFUSuW",
						"CsW3W4jEd4OarUqbqaJSSVzy808HEAB5uyGyZDA9QrLZR")
				.post("https://twitter.com/TwitterDev/status/1496720869938589700");
		System.out.println("status code: " + response.getStatusCode());
		System.out.println("Response jason Body: " + response.jsonPath().prettyPrint());

	}

	@Test
	public void delete() {

		Response response = RestAssured.given().auth()
				.oauth("TTQQO4y0DJGZLBU2LcU1VJECQ", "qkf8Rj3kggsjkvc2mF5sBLvE8k93ZL9Q74nPzKujFwJ8QAofoV",
						"4003503614-NqJnAeZ2s6oHIPEWsNJnKDoKB4TtIPD2oOFUSuW",
						"CsW3W4jEd4OarUqbqaJSSVzy808HEAB5uyGyZDA9QrLZR")
				.delete("https://api.twitter.com/2/tweets/1496720869938589700");

		System.out.println("Response code: " + response.getStatusCode());
		response.prettyPrint();
	}

}