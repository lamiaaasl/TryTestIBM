package TestCases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.CreateAnAccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import TestData.ExcelReader;

public class RegisterNewAccountTest extends TestBase {
	
	CreateAnAccountPage CreateAccountObj;
	ExcelReader ExcelReaderObj;
	LoginPage loginObject ;
	HomePage homeObject ; 
	
	@BeforeMethod
	public void BeforeMethod() {
		homeObject = new HomePage(driver, properties); 
		loginObject = new LoginPage(driver, properties); 
		CreateAccountObj = new CreateAnAccountPage(driver, properties); 
	}
	
	@DataProvider(name = "RegisterNewUser")
    public Object[][] CreateAccountData() throws InvalidFormatException, IOException {
          Object[][] data = ExcelReader.fetchData(properties.getProperty("TestDataSheetPath"), "RegisterNewUser");
          System.out.println(data);
          return data;
    }

	  @Test(priority=1,alwaysRun=true,dataProvider="RegisterNewUser")
		public void UserCanRegisterSuccssfully(String strEmail, String strFirstName, String strLastName, String strPassword, String strAddress, String strCity, String strPostalCode, String strMobilePhone) {
			homeObject.openLoginPage();
			CreateAccountObj.CreateNewUser(strEmail, strFirstName, strLastName, strPassword, strAddress, strCity, strPostalCode, strMobilePhone);
			Assert.assertTrue(CreateAccountObj.successMessage.getText().contains("Welcome to your account"));
			System.out.println("Account Created Successfully");
			homeObject.userLogout();
			System.out.println("User LoggedOut Succssefully");
			homeObject.openLoginPage();
			loginObject.UserLogin(strEmail, strPassword);
			Assert.assertTrue(homeObject.logoutLink.getText().contains("Sign out"));
			System.out.println("User Logged in Successfully");
			homeObject.userLogout();
		}
	}
