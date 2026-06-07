package rahulshettyacademy.pageobjects;

import java.io.IOException;
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
import org.testng.annotations.Test;

import rahulshettyacademy.CartPage;
import rahulshettyacademy.ChcekoutPage;
import rahulshettyacademy.ConfirmationPage;
import rahulshettyacademy.LandingPage;
import rahulshettyacademy.ProductCatalogue;
import rahulshettyacademy.TestComponents.BaseTest;

public class ErrorValidations extends BaseTest {

	

	@Test
	public void loginErrorValidation() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		String productName = "ZARA COAT 3";
		landingPage.loginApplication("balaji1997@gmail.com", "xalaji6235");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	}
	@Test
	public void productErrorValidation() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("balajinale1997@gmail.com", "Balaji@6305");
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		Thread.sleep(2000);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);

	}
}
