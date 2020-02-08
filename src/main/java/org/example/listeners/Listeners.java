package org.example.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import org.example.utilities.PageBase;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listeners extends TestListenerAdapter {
    public static ExtentReports reports;

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("on test start");
        PageBase.test.log(Status.INFO, iTestResult.getMethod().getMethodName() + "test started");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("on test success");
        PageBase.test.log(Status.PASS, iTestResult.getMethod().getMethodName() + "test passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("on test failure");
        PageBase.test.log(Status.FAIL, iTestResult.getMethod().getMethodName() + "test failed");
        PageBase.test.log(Status.FAIL, iTestResult.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
