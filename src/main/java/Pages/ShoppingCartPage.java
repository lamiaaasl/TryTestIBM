package Pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Base.PageBase;

public class ShoppingCartPage extends PageBase{

	public Properties properties;
	public LoginPage LoginObj;
	
	public ShoppingCartPage(WebDriver driver, Properties properties) {
		super(driver);
		this.properties = properties;
	}	
	
	@FindBy(id="cart_title")
	public WebElement shoppingCartTitle;
	
	@FindBy(xpath="//*[@class='layer_cart_product col-xs-12 col-md-6']/h2")
	public WebElement AddingSuccessMSG;
	
	List<String> shoppingCartProd = new ArrayList<String>();
		
	public List<String> verifyShoppingCartContent() {
		driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS);

		List<WebElement> allProdNames = driver.findElements(By.xpath("//*[@class='cart_description']//*[@class='product-name']"));
		List<WebElement> allPrices = driver.findElements(By.xpath("//td[@class='cart_total']//span[@class='price']"));

		int b = allProdNames.size();
		System.out.println(b);
		driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS);
		
		for(int j = 0 ; j < b ; j++) {
			shoppingCartProd.add(allProdNames.get(j).getText());
			driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS);
			
			shoppingCartProd.add(allPrices.get(j).getText());	
			driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS);
			
			System.out.println(shoppingCartProd);
		}
		return shoppingCartProd;
	}
}
