package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import org.testng.Assert;
import Pages.CreateAnAccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ShoppingCartPage;
import Pages.WomenProductViewPage;

public class E2Escenario extends Base.TestBase {

	CreateAnAccountPage CreateAccountObj;
	LoginPage loginObject ;
	HomePage homeObject ; 
	WomenProductViewPage womenProdViewPageObj;
	ShoppingCartPage shoppingCartPageObj;


	@Given("Open home page")
	public void the_user_in_the_home_page() throws Throwable {
		homeObject = new Pages.HomePage(driver, properties);
		homeObject.openLoginPage();
        System.out.println("User Opened Home Page successfully");

	}
	

	@When("Create an account with the mandatory fields then click on Register")
	public void CreateAnAccountNew()  {
		CreateAccountObj = new CreateAnAccountPage(driver, properties);
		CreateAccountObj.CreateNewUser("lomyasl@str.com", "lomyasl", "asl", "L@miaaaa2020" , "oct", "strCity", "11511", "011182423535");
        System.out.println("User registered successfully");

	}
	
	@When ("log out")
	public void usershouldloginOut()  {
		homeObject = new Pages.HomePage(driver, properties);
    	homeObject.userLogout();
        System.out.println("User Log out successfully");
	}
	
	@When ("log on with the registered User")
	public void usershouldlogin()  {		
		homeObject = new Pages.HomePage(driver, properties);
		loginObject = new LoginPage(driver, properties); 
		loginObject.UserLogin("lomyasl@str.com", "L@miaaaa2020");
		Assert.assertTrue(homeObject.logoutLink.getText().contains("Sign out"));
        System.out.println("User Login with the registered user successfully");
	}
	
	@When ("Select Category Women")
	public void SelectCategoryWomen()  {
			
		homeObject = new Pages.HomePage(driver, properties);
		homeObject.SelectCategory("Women");
		System.out.println("women Category Selected Successfully");
	}
	
	
	@Then("Select Items which In Stock Only in women grid and Added them in Shopping Cart")
	
	public void OpenShoppingCartAndAssert() throws InterruptedException {
		
		shoppingCartPageObj = new ShoppingCartPage(driver, properties);
		womenProdViewPageObj = new Pages.WomenProductViewPage(driver, properties);
		womenProdViewPageObj.SelectItemsInStockOnly();
		List<String> ExpectedResult = womenProdViewPageObj.AddAllInStockToShoppingCart();
		System.out.println("Products Added to Cart Successfully");
		homeObject.OpenShoppingCart();
		Assert.assertTrue(shoppingCartPageObj.shoppingCartTitle.getText().contains("SHOPPING-CART SUMMARY"));
		System.out.println("Shopping Cart Opened Successfully");
		
		List<String> ActualResult =	shoppingCartPageObj.verifyShoppingCartContent();
		Assert.assertEquals(ExpectedResult, ActualResult);
		System.out.println("All desired products Added Successfully to Shopping Cart and displayed correct with Name and Price too");
		
	}
}


