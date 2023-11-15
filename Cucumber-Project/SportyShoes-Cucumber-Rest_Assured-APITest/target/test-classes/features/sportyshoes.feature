Feature: End to End Test for SportyShoes API
  

  
  Scenario: API ables to Get all products,Add,Update,Delete products and Get all registered users
  
  	Given A list of users are registered
    Given A list of products are available
    When I add a product
    Then The product is added
    When I update the product details
    Then The product details is updated 
    When I delete the product
    Then The product is deleted 

  