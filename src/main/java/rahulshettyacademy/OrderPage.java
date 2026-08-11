package rahulshettyacademy;

import java.util.List;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstactComponents.AbstractComponent;

public class OrderPage extends AbstractComponent {

	WebDriver driver;

//	List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));

	@FindBy(css= "tr td:nth-child(3)")
	List <WebElement> productNames;
	
//	driver.findElement(By.cssSelector(".totalRow button")).click();
	
	@FindBy(css= ".totalRow button")
	WebElement checkoutEle;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Boolean VerifyOrdertDisplay(String productName) {
		
//		List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = productNames.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	

}
