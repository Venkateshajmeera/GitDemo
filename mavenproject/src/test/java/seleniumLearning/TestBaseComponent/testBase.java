package seleniumLearning.TestBaseComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumLearning.pageObject.landingPage;

public class testBase {
public WebDriver driver;
public landingPage landingPage;
public ExtentReports extent;
	



public WebDriver intializeDriver() throws IOException {
		// TODO Auto-generated method stub
		//Properties Class
		//1. create a properties object to read the global properties
		Properties pro=new Properties();
		FileInputStream File =new FileInputStream(System.getProperty("user.dir")+"//src//main//java//seleniumLearning//Resources//GlobalData.properties");
pro.load(File);
String BrowserName= System.getProperty("browser")!= null ? System.getProperty("browser"):pro.getProperty("browser");
//String BrowserName= pro.getProperty("browser");
//"//src//main//java//rahulshettyacademy//resources//GlobalData.properties"

//extent.createTest("Login"); 

if (BrowserName.contains("chrome")){
	
	WebDriverManager.chromedriver().setup();
	 driver= new ChromeDriver();
	 ChromeOptions options = new ChromeOptions();
	 options.addArguments("--remote-allow-origins=*");
	 ChromeDriver driver = new ChromeDriver(options);
	//return driver;
}
else if(BrowserName.contains("firefox")) {
	WebDriverManager.firefoxdriver().setup();
	  driver =new FirefoxDriver();
	// return driver;
}
else if(BrowserName.contains("edge") ){
	WebDriverManager.edgedriver().setup();
	 driver= new EdgeDriver();
	 EdgeOptions options = new EdgeOptions();
	 
	 options.addArguments("--no-sandbox");
options.addArguments("--disable-dev-shm-usage");
	//return driver;
	
}
driver.manage().window().maximize();
return driver;

	}
	public landingPage launchAPP() throws IOException {
		driver= intializeDriver();
		landingPage = new landingPage(driver);
		landingPage.GoTo();
		return landingPage;
		
	}
	
public List<HashMap<String, String>> DataReader(String FilePath) throws IOException {
		
		//JSON TO STRING--->
		
	String JsonData=	FileUtils.readFileToString(new File(FilePath),StandardCharsets.UTF_8);
		
	//string to hashmap
	ObjectMapper mapper=new ObjectMapper();
	List<HashMap<String,String>> Data= mapper.readValue(JsonData, new TypeReference<List<HashMap<String,String> >>() {});
	return Data;
}

public String TakeScreenshot(String TestCaseName) throws IOException {
	TakesScreenshot SS= (TakesScreenshot)driver;
	File Image= SS.getScreenshotAs(OutputType.FILE);
	File path= new File(System.getProperty("user.dir")+"//reports//"+ TestCaseName+".png");
			
	FileUtils.copyFile(Image, path);
	return (System.getProperty("user.dir")+"//reports//"+ TestCaseName+".png");
}
/*
@BeforeTest
public ExtentReports reporters() {
	String PathOfReports=System.getProperty("user.dir")+"//reports//index.html";
	ExtentSparkReporter reports= new ExtentSparkReporter(PathOfReports);
	reports.config().setReportName("Automation Reports");
	reports.config().setDocumentTitle("Test Result");
	reports.config().setTheme(null);
	 extent= new ExtentReports();
	extent.attachReporter(reports);
	extent.setSystemInfo("venkatesh ajmeera", "QA");
	return extent;
}
*/



/*public File getScreenShot() throws IOException {
	TakesScreenshot SS= (TakesScreenshot)driver;
File image =SS.getScreenshotAs(OutputType.FILE);
File path=	new File("C:\\Users\\venkatesh.ajmeera\\eclipse-workspace\\mavenproject\\Reports"+  ".png");
	FileUtils.copyFile(image, path);
	return path;
	
	
}*/


	public void tearDown() {
		driver.close();
	}
	}


