package seleniumLearning.Resources;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.observer.ExtentObserver;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	@BeforeTest
	public static ExtentReports getReporter() {
		String PathOfReports=System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reports= new ExtentSparkReporter(PathOfReports);
		reports.config().setReportName("Automation Reports");
		reports.config().setDocumentTitle("Test Result");
		//reports.config().setTheme(null);
		ExtentReports extent= new ExtentReports();
		extent.attachReporter(reports);
		extent.setSystemInfo("venkatesh ajmeera", "QA");

	
	return extent;
	}

}
