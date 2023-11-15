package com.sportyshoes.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Script004UpdateProduct {

	@Test
	public void Upadate_Product() {

		// URL: http://localhost:9010/update-shoe
		/*
		 * { "id": 101, "name": "Updated Shoe Name", "category": "Updated Category",
		 * "sizes": "8,9,10", "price": 1500 "image": "updated_image_url", }
		 */

		Response response = RestAssured
				.given()
				.baseUri("http://localhost:9010")
				.basePath("/update-shoe")
				.contentType("application/json")
				.queryParam("id", 101)
				.queryParam("image", "updated_image_url")
				.queryParam("name", "Updated Shoe Name")
				.queryParam("category", "Updated Category")
				.queryParam("sizes",10)
				.queryParam("price", 1500)
				.when()
				.put()
				.then()
				.statusCode(200)
				.body("message",equalTo("Updated Shoe Name Updated Successfully."))
				.body("shoe.id",equalTo(101))
				.body("shoe.image",equalTo("updated_image_url"))
				.body("shoe.name",equalTo("Updated Shoe Name"))
				.body("shoe.category",equalTo("Updated Category"))
				.body("shoe.sizes",equalTo("10"))
				.body("shoe.price",equalTo(1500))
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
