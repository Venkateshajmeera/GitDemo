package seleniumLearning.stepDefinitions;

import java.io.IOException;

import io.cucumber.java.en.Given;
import seleniumLearning.TestBaseComponent.testBase;
import seleniumLearning.pageObject.landingPage;
import seleniumLearning.pageObject.productPage;


public class stepDefinition extends testBase {
	
	public landingPage landingPage;
	public productPage Productpage;
	
	@Given("landed on page")
	public void I_landed_on_login_page() throws IOException {
		landingPage =launchAPP();
	}
	@Given("^Logged in with username (.+) and password (.+)$")
	public void I_landed_on_Prdocutpage(String username, String password) throws InterruptedException {
		productPage Prodcutpage = landingPage.clickToLogin(username,password);
		Productpage.addToCart();
	}


}
