package TestCases;

import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.CreateAnAccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ShoppingCartPage;
import Pages.WomenProductViewPage;
import TestData.ExcelReader;

public class LoginAndMakeOrder extends TestBase{
	CreateAnAccountPage CreateAccountObj;
	ExcelReader ExcelReaderObj;
	LoginPage loginObject ;
	HomePage homeObject ; 
	WomenProductViewPage womenProdViewPageObj;
	ShoppingCartPage shoppingCartPageObj;
	
	@BeforeMethod
	public void BeforeMethod() {
		homeObject = new HomePage(driver, properties); 
		loginObject = new LoginPage(driver, properties); 
		CreateAccountObj = new CreateAnAccountPage(driver, properties); 
		womenProdViewPageObj = new WomenProductViewPage(driver, properties);
		shoppingCartPageObj = new ShoppingCartPage(driver, properties);
	}
	
	@DataProvider(name = "RegisterNewUserAndMakeOrder")
    public Object[][] testLogin() throws InvalidFormatException, IOException {
          Object[][] data = ExcelReader.fetchData(properties.getProperty("TestDataSheetPath"), "RegisterNewUserAndMakeOrder");
          return data;
    }
	
	 @Test(priority=1,alwaysRun=true,dataProvider="RegisterNewUserAndMakeOrder")
		public void UserRegAndMakeOrder
		(String strEmail, String strFirstName, String strLastName, String strPassword, String strAddress, 
		 String strCity, String strPostalCode, String strMobilePhone, String strCategory, String strSubCategory) {
		/* homeObject.openLoginPage();
		CreateAccountObj.CreateNewUser(strEmail, strFirstName, strLastName, strPassword, strAddress, strCity, strPostalCode, strMobilePhone);
		Assert.assertTrue(CreateAccountObj.successMessage.getText().contains("Welcome to your account"));
		System.out.println("User Registered Successfully");
		homeObject.userLogout(); */
		
		homeObject.openLoginPage();
		loginObject.UserLogin(strEmail, strPassword);
		Assert.assertTrue(homeObject.logoutLink.getText().contains("Sign out"));
		
		homeObject.SelectCategory(strCategory);;
		Assert.assertTrue(womenProdViewPageObj.HeaderTxt.getText().contains("Women"));
		System.out.println("'"+strCategory+"'Category Selected Successfully");

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
