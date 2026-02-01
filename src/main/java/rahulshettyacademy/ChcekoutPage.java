package rahulshettyacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstactComponents.AbstractComponent;

public class ChcekoutPage extends AbstractComponent{

	WebDriver driver;
	public ChcekoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	driver.findElement(By.cssSelector("[placeholder='Select Country']")
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
//	driver.findElement(By.xpath("//button[contains(@class, 'ta-item')]) [2]")).click();
	@FindBy(xpath = "//button[contains(@class, 'ta-item')]")
	WebElement selectCountry;
//	driver.findElement(By.cssSelector(".action__submit")).click()
	@FindBy(css=".action__submit")
	WebElement submit;
//	(By.cssSelector(".ta-results")
	By results = By.cssSelector(".ta-results");
//	Actions a = new Actions(driver);
//	a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
	public void selectCountry(String countryName) {
		
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitForElementsToAppear(results);
		selectCountry.click();
	}
	
	public ConfirmationPage submitOrder() {
		
		submit.click();
		return new ConfirmationPage(driver);
	}
}
