package tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.IOException;

public class TestListner implements ITestListener {
    @Override
    public void onFinish(ITestContext Result)
    {

    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Object testClass = iTestResult.getInstance();
        WebDriver webDriver = ((BaseTest) testClass).driver;
        try {
            String ScreenShotPath=utils.utils.CaptureErrorPage(iTestResult.getTestName(),webDriver );
            Reporter.log("<br /><h2>"+iTestResult.getMethod().getDescription()+"</h2><br/><img src='"+ScreenShotPath+"'  /><br>");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext Result)
    {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult Result)
    {

    }
}
