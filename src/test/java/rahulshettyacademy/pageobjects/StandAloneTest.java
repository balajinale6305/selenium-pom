package rahulshettyacademy.pageobjects;

import java.io.File;
import java.io.IOException;
//import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulshettyacademy.CartPage;
import rahulshettyacademy.ChcekoutPage;
import rahulshettyacademy.ConfirmationPage;
//import rahulshettyacademy.LandingPage;
import rahulshettyacademy.OrderPage;
import rahulshettyacademy.ProductCatalogue;
import rahulshettyacademy.TestComponents.BaseTest;

public class StandAloneTest extends BaseTest {

	String productName = "ZARA COAT 3";
	@Test(dataProvider="getData", groups={"Purchase"})
	public void submitOrder(HashMap<String, String> input) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
//		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));
		Thread.sleep(2000);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		ChcekoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("India");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();

		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER"));

	}
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void OrderHistoryTest() {
		ProductCatalogue productCatalogue = landingPage.loginApplication("balajinale1997@gmail.com", "Balaji@6305");
		OrderPage ordersPage = productCatalogue.goToOrdersPage();
		Assert.assertTrue(ordersPage.VerifyOrdertDisplay(productName));
	}
	
	public String getSceenshot(String testCaseName) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	
	}
	
	@DataProvider
	public Object[] [] getData() throws IOException
	{
		
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "\\src\\test\\java\\rahulshettyacademy\\data\\PurchaseOrder.json");
		return new Object[] [] {{data.get(0)}, {data.get(1)}};
	}

}
