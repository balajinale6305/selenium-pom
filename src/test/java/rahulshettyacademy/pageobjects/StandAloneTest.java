package rahulshettyacademy.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;

import rahulshettyacademy.CartPage;
import rahulshettyacademy.ChcekoutPage;
import rahulshettyacademy.ConfirmationPage;
import rahulshettyacademy.LandingPage;
import rahulshettyacademy.ProductCatalogue;

public class StandAloneTest {

	static String productName = "ZARA COAT 3";

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();
		ProductCatalogue productCatalogue = landingPage.loginApplication("balajinale1997@gmail.com", "Balaji@6305");
		List<WebElement> products = productCatalogue.getProductList();
		System.out.println(productCatalogue.getProductName(productName));
//		productCatalogue.addProductToCart(productName);
//		CartPage cartPage = productCatalogue.goToCartPage();
//		Boolean match = cartPage.VerifyProductDisplay(productName);
//		Assert.assertTrue(match);
//		ChcekoutPage checkoutPage = cartPage.goToCheckout();
//		checkoutPage.selectCountry("India");
//		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
//
//		String confirmMessage = confirmationPage.getConfirmationMessage();
//		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER"));
//		driver.close();

	}

}
