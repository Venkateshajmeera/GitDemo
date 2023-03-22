package seleniumLearning.TestBaseComponent;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import seleniumLearning.Resources.ExtentReporterNG;

public class Listeners extends testBase implements ITestListener {
//	ExtentReports extents= new ExtentReports(); we can create object here or we import ExtentReporter  by calling classname.method
	ExtentReports extents=	ExtentReporterNG.getReporter();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal();
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	test=	extents.createTest(result.getMethod().getMethodName());
		//ITestListener.super.onTestStart(result);
	extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	//	ITestListener.super.onTestSuccess(result);
		
		
		//test.log(Status.PASS, "Passed");
	extentTest.get().log(Status.PASS, "passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().fail(result.getThrowable());
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
	
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//Taking SS 
		String Name=null;
		try {
			 Name= TakeScreenshot(result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(Name, result.getMethod().getMethodName());
		//attaching the SS to reports
		
		//ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	//	ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	//	ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	//	ITestListener.super.onFinish(context);
		extents.flush();
	}
	

}
