package seleniumLearning.TestBaseComponent;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retryFailedTests implements IRetryAnalyzer {
int count =1;
int max=2;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<max) {
			count++;
			return true;
		}
		return false;
	}

}
