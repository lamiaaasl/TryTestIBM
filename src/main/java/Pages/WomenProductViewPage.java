package Pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.PageBase;

public class WomenProductViewPage extends PageBase {
	public Properties properties;
	public LoginPage LoginObj;
	public ShoppingCartPage shoppingCartPageObj;
	
	public WomenProductViewPage(WebDriver driver, Properties properties) {
		super(driver);
		this.properties = properties;
	}	
	
	public WebDriverWait wait= new WebDriverWait(driver, 10);
	
	@FindBy(xpath="//span[@class='category-name']")
	public WebElement HeaderTxt;
	
	@FindBy(id="layered_quantity_1")
	WebElement inStockCheckbox;
	
	@FindBy(xpath="//*[@class='icon-chevron-left left']")
	WebElement continueShopping;
		
	public void SelectItemsInStockOnly() {
		clickOnLink(inStockCheckbox);
		driver.manage().timeouts().implicitlyWait(200,TimeUnit.SECONDS);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='cat-name']")));
	}
	
	public List<String> AddAllInStockToShoppingCart() {
		driver.manage().timeouts().implicitlyWait(1500,TimeUnit.SECONDS);
		List<String> productsNamePrice = new ArrayList<String>();	
		List<WebElement> allInStockProducts = driver.findElements(By.xpath("//div[@class='right-block']//a[@class='product-name']"));
		List<WebElement> addToCartAll = driver.findElements(By.xpath("//a[@class='button ajax_add_to_cart_button btn btn-default'][@title='Add to cart']"));
		List<WebElement> allProductsName = driver.findElements(By.xpath("//div[@class='right-block']//a[@class='product-name']"));
		List<WebElement> allProductsPrice = driver.findElements(By.xpath("//div[@class='right-block']//span[@class='price product-price']"));
	
		int a = allInStockProducts.size();

		for(int i = 0 ; i < a ; i++) {
			WebElement product = allInStockProducts.get(i);
						
			productsNamePrice.add(allProductsName.get(i).getText());
			System.out.println(productsNamePrice);
			
			productsNamePrice.add(allProductsPrice.get(i).getText());
			System.out.println(productsNamePrice);
						
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
			hoverToElement(product);
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);

			clickButton(addToCartAll.get(i));
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='layer_cart_product col-xs-12 col-md-6']")));
			clickOnLink(continueShopping);
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		}
		return productsNamePrice;
	}
}
