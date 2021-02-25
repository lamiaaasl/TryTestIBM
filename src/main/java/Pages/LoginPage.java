package Pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.PageBase;

public class LoginPage extends PageBase
{
	public Properties properties;
	public WebDriverWait wait ;

	public LoginPage(WebDriver driver, Properties properties) {
		super(driver);
		this.properties = properties;
	}

	@FindBy(xpath="//*[contains(text(),'Sign in')]")
	WebElement SignIn_btn;
	
	@FindBy(id="email")
	WebElement emailTxtBox ; 

	@FindBy(id="passwd")
	WebElement passwordTxtBox ; 

	@FindBy(xpath="//*[@class=\"icon-lock left\"]")
	WebElement loginBtn ; 
		
	public void UserLogin(String strEmail , String strPassword) {
		setTextElementText(emailTxtBox, strEmail);
		setTextElementText(passwordTxtBox, strPassword);
		clickButton(loginBtn);
	}
}
