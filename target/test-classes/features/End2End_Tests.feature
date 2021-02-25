Feature: RegisterAndMakeOrder
   I want to register new user then login with it then 
   navigates to women page and wants to return the all items are “In Stock”
   

  Scenario: RegisterAndMakeOrder
    Given Open home page
    When Create an account with the mandatory fields then click on Register
    And log out
    And log on with the registered User
    And Select Category Women
    Then Select Items which In Stock Only in women grid and Added them in Shopping Cart
   
