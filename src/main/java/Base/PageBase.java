package Base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class PageBase {

	static int defaultElementIdentificationTimeout = 1; // Integer.parseInt(System.getProperty("defaultElementIdentificationTimeout").trim());
	static int attemptsBeforeThrowingElementNotFoundException = 1; // Integer.parseInt(System.getProperty("attemptsBeforeThrowingElementNotFoundException").trim());
	public WebDriver driver ; 
	public JavascriptExecutor jse ; 
	public Actions action ;
	
	// methods
	
	public PageBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	protected static void clickButton(WebElement button) {
		button.click();
	}
	
	protected static void clickOnLink(WebElement link) {
		link.click();
	}
	
	protected static void setTextElementText(WebElement textElement , String value) {
		textElement.sendKeys(value);
	}
	
	public void clearText(WebElement element) {
		element.clear();
	}
	
	public void hoverToElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}	
	
	public String getElementText(WebElement element) {
		String TextGot = element.getText();
		return TextGot;
	}
	
	public void scrollToBottom() {
		jse.executeScript("scrollBy(0,2500)"); 
	}
}
