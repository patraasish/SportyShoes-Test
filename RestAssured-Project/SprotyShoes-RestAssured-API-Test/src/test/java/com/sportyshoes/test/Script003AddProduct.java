package com.sportyshoes.test;

import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Script003AddProduct {

	@Test
	public void AddProduct() {

		/*
		 * http://localhost:9010/add-shoe?id=101&image=image_url&name=SampleShoe
		 * &category=Running&sizes=9&price=1000
		 */

			
		Response response = RestAssured
				.given()
				.baseUri("http://localhost:9010")
				.basePath("/add-shoe")
				.contentType("application/json")
				.queryParam("id", 101)
				.queryParam("image", "image_url")
				.queryParam("name", "SampleShoe")
				.queryParam("category", "Running")
				.queryParam("sizes", 9)
				.queryParam("price", 1000)
				.when()
				.post()
				.then()
				.statusCode(200)
				.body("message",equalTo("SampleShoe Added Successfully."))
				.body("shoe.id",equalTo(101))
				.body("shoe.image",equalTo("image_url"))
				.body("shoe.name",equalTo("SampleShoe"))
				.body("shoe.category",equalTo("Running"))
				.body("shoe.sizes",equalTo("9"))
				.body("shoe.price",equalTo(1000))
				.extract()
				.response();
	
		System.out.println(response.getBody().asPrettyString());
		System.out.println("Status Code " + response.getStatusCode());
		System.out.println("Response Time: "+response.getTime());
		System.out.println("Content Type: "+response.getHeader("Content-Type"));
		int expectStatusCode = 200;
		int ActualStatusCode = response.getStatusCode();
		Assert.assertEquals(expectStatusCode, ActualStatusCode);
}
}