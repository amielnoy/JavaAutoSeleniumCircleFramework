package tests.TestCases;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;

import java.io.ByteArrayInputStream;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        // You can add any setup logic here if needed
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // You can add logic for successful tests here if needed
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTest) testClass).setupEnvironmentAndBrowser("CHROME","test");
        if (driver instanceof TakesScreenshot) {
            Allure.addAttachment(
                    result.getName() + "_screenshot",
                    new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES))
            );
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // You can add logic for skipped tests here if needed
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // This method is rarely used, but you can add logic here if needed
    }

    @Override
    public void onStart(ITestContext context) {
        // You can add setup logic for the entire test run here if needed
    }

    @Override
    public void onFinish(ITestContext context) {
        // You can add teardown logic for the entire test run here if needed
    }
}