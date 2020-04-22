package com.api.listener;

import com.api.utils.ExtentReportManager;
import com.api.utils.ExtentReportManager1;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.aopalliance.intercept.MethodInvocation;
import org.testng.*;
import org.testng.internal.InvokedMethod;
import org.testng.internal.invokers.InvokedMethodListenerMethod;

import java.io.File;

public class TestNgListener1 implements ITestListener, IInvokedMethodListener {

    //Extent Report Declarations
    private static ExtentReports extent = ExtentReportManager1.createInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public synchronized void onStart(ITestContext context) {
        System.out.println("Extent Reports Version 3 Test Suite started!");
    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        System.out.println(("Extent Reports Version 3  Test Suite is ending!"));
        extent.flush();
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
        ExtentReportManager1.setTest(extentTest);
        System.out.println((result.getMethod().getMethodName() + " started!"));
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " passed!"));
        ExtentReportManager1.getTest().log(Status.PASS,"Test Pass Successfully!!!!");
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " failed!"));
        ExtentReportManager1.getTest().log(Status.FAIL,result.getThrowable());
    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " skipped!"));
        ExtentReportManager1.getTest().log(Status.SKIP,result.getThrowable());
    }

    @Override
    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
    }

    public synchronized void beforeInvocation(IInvokedMethod method, ITestResult result) {

    }

    public synchronized void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        extent.flush();
    }


}
