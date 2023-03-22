package seleniumLearning.mavenproject;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumLearning.pageObject.landingPage;
import seleniumLearning.pageObject.productPage;

public class sampleProject {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String productName = "zara coat 3";
	
			// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://rahulshettyacademy.com/client");

		

			driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("Vajmeera@gmail.com");

			driver.findElement(By.cssSelector("input[id='userPassword']")).sendKeys("Anil@444");

			driver.findElement(By.id("login")).click();

			/*
			 * Set<String>windowsHandle= driver.getWindowHandles(); Iterator<String> B=
			 * windowsHandle.iterator(); String parent= B.next(); String child=B.next();
			 * driver.switchTo().window(child);
			 */

			
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
			  ".mb-3")));
			 
			// WebDriverWait is used to wait the driver until the visibility of the element

			 List<WebElement> Products = driver.findElements(By.cssSelector("b"));
			List<WebElement> ProductItems =
			 driver.findElements(By.cssSelector("button.btn.w-10.rounded"));

			/*
			 * WebElement prod = Products.stream() .filter(product ->
			 * product.findElement(By.cssSelector("b")).getText().equals(productName)).
			 * findFirst() .orElse(null);
			 * prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
			 * System.out.println("hello");
			 */
			/*
			 * Another way of stream used here like, products.stream filters the element by
			 * css selector 'b' and gets the text of each element and finds the first
			 */

			
			 IntStream.range(0, Products.size()).filter(i ->
			  productName.contains(Products.get(i).getText()))
			  .mapToObj(ProductItems::get).forEach(WebElement::click); 
			 Thread.sleep(3000);
			 

			 driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();

			 Thread.sleep(8000);
			 driver.findElement(By.cssSelector(".totalRow button")).click();
			 driver.findElement(By.xpath("(//input[@type='text'])[3]"))
.sendKeys("Vajmeera")			;// driver.findElement(By.cssSelector(".title")).below(driver.findElement(By.cssSelector("input.input.txt")));
driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']")).click();
		}
	}


