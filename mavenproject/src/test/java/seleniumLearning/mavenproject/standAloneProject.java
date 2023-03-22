package seleniumLearning.mavenproject;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.aventstack.extentreports.ExtentReports;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumLearning.TestBaseComponent.retryFailedTests;
import seleniumLearning.TestBaseComponent.testBase;
import seleniumLearning.pageObject.checkOutPage;
import seleniumLearning.pageObject.landingPage;
import seleniumLearning.pageObject.productPage;

public class standAloneProject extends testBase {
	static String productName = "zara coat 3";

	@Test(dataProvider = "JsonData", groups = { "smoke" }, retryAnalyzer =retryFailedTests.class)
	public void login(HashMap<String,String> input) throws InterruptedException, IOException {
		//ExtentReports extent;
	

		landingPage landingPage = launchAPP();

		productPage ProductPage = landingPage.clickToLogin(input.get("email"), input.get("password"));

		landingPage.waitForElement();

		ProductPage.addToCart();
            
		tearDown();

	}

	@Test(dataProvider = "test1")
	public void Applogin(String email, String Password) throws InterruptedException, IOException {
		landingPage landingPage = launchAPP();

		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(email);

		driver.findElement(By.cssSelector("input[id='userPassword']")).sendKeys(Password);

		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class*='flyInOut']")));

			String ErrorMsg=	driver.findElement(By.cssSelector("[class*='flyInOut']")).getText();
		AssertJUnit.assertEquals("Incorrect email om password.", ErrorMsg);


		
	/*	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

		// WebDriverWait is used to wait the driver until the visibility of the element

		List<WebElement> Products = driver.findElements(By.cssSelector("b"));
		List<WebElement> ProductItems = driver.findElements(By.cssSelector("button.btn.w-10.rounded"));

		IntStream.range(0, Products.size()).filter(i -> productName.contains(Products.get(i).getText()))
				.mapToObj(ProductItems::get).forEach(WebElement::click);
		Thread.sleep(3000);

		driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();

		Thread.sleep(8000);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		tearDown();*/

	}
	@DataProvider(name = "test1")

	public Object[][] GetData() {

		return new Object[][] { { "vajmeera@gmail.com", "anil@444" }, { "Vajmeera@gmail.com", "1234567" } };

	}
	
	
// 	@DataProvider(name="newDataSet")
	public Object[][] newDataSet() {
		
		HashMap<String,String> Map=new HashMap();
	Map.put("email","Vajmeera@gmail.com");
	Map.put(null, null);
	Map.put("password", "Anil@444");
	
	
	HashMap<String,String> Map1=new HashMap();
	
	Map1.put("email","Vajmeera@com");
	Map1.put(null, null);
	Map1.put("password", "Anil@444");
	return new Object[][] {
		{Map},
		{Map1}
		};
	
	}// it retrieves the data from json
	
	@DataProvider(name="JsonData")
	public Object[][] JsonData() throws IOException {
		List<HashMap<String, String>> Data=	DataReader(System.getProperty("user.dir")+"//src//test//java//seleniumLearning//data//standAloneData.json");
	
	return new Object[][] {{Data.get(0)},{Data.get(1)}};
	}

	
}
