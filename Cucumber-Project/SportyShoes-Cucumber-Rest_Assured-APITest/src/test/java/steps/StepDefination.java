package steps;



import static org.hamcrest.Matchers.equalTo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class StepDefination {
	
	@Given("A list of users are registered")
	public void a_list_of_users_are_registered() {
		
		//http://localhost:9010/get-users
				Response response = RestAssured
						.given()
						.baseUri("http://localhost:9010")
						.basePath("/get-users")
						.when()
						.get()
						.then()
						.statusCode(200)
						.extract()
						.response();
			
				System.out.println(response.getBody().asPrettyString());
				System.out.println("Status Code " + response.getStatusCode());
				System.out.println("Response Time: "+response.getTime());
				System.out.println("Content Type: "+response.getHeader("Content-Type"));
	}

	@Given("A list of products are available")
	public void a_list_of_products_are_available() {
		
		//http://localhost:9010/get-shoes
				Response response = RestAssured
						.given()
						.baseUri("http://localhost:9010")
						.basePath("/get-shoes")
						.when()
						.get()
						.then()
						.statusCode(200)
						.extract()
						.response();
			
				System.out.println(response.getBody().asPrettyString());
				System.out.println("Status Code " + response.getStatusCode());
				System.out.println("Response Time: "+response.getTime());
				System.out.println("Content Type: "+response.getHeader("Content-Type"));
			
				
	}

	@When("I add a product")
	public void i_add_a_product() {
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
				.extract()
				.response();
	
		System.out.println(response.getBody().asPrettyString());
		System.out.println("Status Code " + response.getStatusCode());
		System.out.println("Response Time: "+response.getTime());
		System.out.println("Content Type: "+response.getHeader("Content-Type"));
	}

	@Then("The product is added")
	public void the_product_is_added() {
		
		//http://localhost:9010/get-shoes
		Response response = RestAssured
				.given()
				.baseUri("http://localhost:9010")
				.basePath("/get-shoes")
				.when()
				.get()
				.then()
				.statusCode(200)
				.extract()
				.response();
	
		System.out.println(response.getBody().asPrettyString());
	}

	@When("I update the product details")
	public void i_update_the_product_details() {
		
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
						.extract()
						.response();
			
				
				System.out.println(response.getBody().asPrettyString());
	}

	@Then("The product details is updated")
	public void the_product_details_is_updated() {
		
		//http://localhost:9010/get-shoes
				Response response = RestAssured
						.given()
						.baseUri("http://localhost:9010")
						.basePath("/get-shoes")
						.when()
						.get()
						.then()
						.statusCode(200)
						.extract()
						.response();
			
				System.out.println(response.getBody().asPrettyString());
	}

	@When("I delete the product")
	public void i_delete_the_product() {

		//http://localhost:9010/delete-shoe?id=101
				RestAssured
				.given()
				.baseUri("http://localhost:9010")
				.basePath("/delete-shoe")
				.queryParam("id", 101)
				.when()
				.delete()
				.then()
				.statusCode(200)
				.body("message",equalTo("Shoe with ID 101 Deleted Successfully."));
	
	}

	@Then("The product is deleted")
	public void the_product_is_deleted() {
		
		//http://localhost:9010/get-shoes
				Response response = RestAssured
						.given()
						.baseUri("http://localhost:9010")
						.basePath("/get-shoes")
						.when()
						.get()
						.then()
						.statusCode(200)
						.extract()
						.response();
			
				System.out.println(response.getBody().asPrettyString());
	}

}
