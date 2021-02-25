package Pages;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.PageBase;

public class HomePage extends PageBase
{
	public Properties properties;

	public HomePage(WebDriver driver, Properties properties) {
		super(driver);
		this.properties = properties;
	}
	
	public WebDriverWait wait= new WebDriverWait(driver, 10);
	
	@FindBy(xpath="//*[contains(text(),'Sign in')]")
	WebElement SignIn_btn; 
	
	@FindBy(linkText="Cart")
	WebElement cartLink ; 

	@FindBy(xpath="//*[@title='View my customer account']")
	public WebElement userName;
	
	@FindBy(xpath="//*[@title='Log me out']")
	public WebElement logoutLink;
	
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li/a[contains(text(),'Women')]")
	public WebElement WomenMenu; 
	
	@FindBy(xpath="//a[@title='View my shopping cart']")
	WebElement shoppingCart; 

	@FindBy(xpath="//a[@title='Check out']")
	WebElement checkOut; 
	
	public void openLoginPage() {
		clickButton(SignIn_btn);
	}
			
	public void SelectCategory(String strCategory) {
		WebElement Category = driver.findElement(By.xpath("//li//a[@title='"+strCategory+"']"));
		clickOnLink(Category);
	}
	
	public void OpenShoppingCart() {
		hoverToElement(shoppingCart);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Check out']")));
		clickButton(checkOut);
		driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS);
	}
	
	public void userLogout() {
		clickButton(logoutLink);
	}	
}
