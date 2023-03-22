package seleniumLearning.pageObject;

import java.util.List;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumLearning.AbstractComponent.AbstractComponent;

public class productPage extends AbstractComponent{
WebDriver driver;
String productName = "zara coat 3";
	public productPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy (css="b")
	List<WebElement> Products;
	
	@FindBy(css="button.btn.w-10.rounded")
	List<WebElement> ProductsItems;
	
	@FindBy(css=("button[routerlink*='cart']"))
	WebElement ClickonCart;
	
	
	//driver.findElement(By.cssSelector(".totalRow button")).click();
	
	@FindBy(css=(".totalRow button"))
	WebElement ClickonCheckOut;
	
	public void addToCart() throws InterruptedException {
		IntStream.range(0, Products.size()).filter(i -> productName.contains(Products.get(i).getText()))
		.mapToObj(ProductsItems::get).forEach(WebElement::click);
		Thread.sleep(3000);
		ClickonCart.click();
		Thread.sleep(3000);
		ClickonCheckOut.click();
		
	
		
	}

}
