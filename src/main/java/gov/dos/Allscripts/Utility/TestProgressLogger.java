package gov.dos.Allscripts.Utility;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestProgressLogger extends BaseTest implements ITestListener {
	
	WebDriver driver = null;
	
	@Override
	public void onTestStart(ITestResult iTestResult) 
	{
		log.info("EXECUTING TEST: " + getTestName(iTestResult));
	}

	@Override
	public void onTestSuccess(ITestResult iTestResult)
	{
		log.info("TEST: " + getTestName(iTestResult) + " has PASSED.");
	}

	@Override
	public void onTestFailure(ITestResult iTestResult)
	{
		log.info("TEST: " + getTestName(iTestResult) + " has FAILED.");
	}

	@Override
	public void onTestSkipped(ITestResult iTestResult)
	{
		log.info("TEST: " + getTestName(iTestResult) + " has SKIPPED.");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) 
	{
		log.info("TEST: " + getTestName(iTestResult) + " has partially PASSED.");	
	}

	@Override
	public void onStart(ITestContext iTestContext) 
	{
		log.info("BEGINNING TEST: " + iTestContext.getName());
		
	}

	@Override
	public void onFinish(ITestContext iTestContext) 
	{
		log.info("ENDING TEST: " + iTestContext.getName());
		
	}

}
