package seleniumLearning.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumLearning.AbstractComponent.AbstractComponent;

public class landingPage extends AbstractComponent {
	WebDriver driver;

	public landingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	

	// driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("Vajmeera@gmail.com");
	@FindBy(xpath = ("//input[@id='userEmail']"))
	WebElement userName;

	
	//driver.findElement(By.cssSelector("input[id='userPassword']")).sendKeys("Anil@444");
	@FindBy (css=("input[id='userPassword']"))
	WebElement passWord;
	
	//driver.findElement(By.id("login")).click();
	@FindBy(id="login")
	WebElement loginButton;

	public  productPage clickToLogin(String email, String password) {
		userName.sendKeys(email);
		passWord.sendKeys(password);
		loginButton.click();
		productPage Productpage=new productPage(driver);
		return Productpage;
		
	}
	
	public void GoTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

	
		
	}
		
	


