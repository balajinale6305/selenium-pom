package rahulshettyacademy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstactComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;

//	List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));

	@FindBy(css= ".cartSection h3")
	List <WebElement> cartProducts;
	
//	driver.findElement(By.cssSelector(".totalRow button")).click();
	
	@FindBy(css= ".totalRow button")
	WebElement checkoutEle;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Boolean VerifyProductDisplay(String productName) {
		
//		List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public ChcekoutPage goToCheckout() {
		
//		driver.findElement(By.cssSelector(".totalRow button")).click();
		checkoutEle.click();
		return new ChcekoutPage(driver);
		
	}

}
