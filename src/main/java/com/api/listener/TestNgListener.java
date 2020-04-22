package com.api.listener;

import com.api.utils.ExtentReportLogger;
import com.api.utils.ExtentReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNgListener implements ITestListener {
    protected static ExtentReports reports;
    protected static ExtentTest test;

    public void onTestStart(ITestResult result){
        test=reports.createTest(result.getMethod().getMethodName()) ;

        test.log(Status.INFO,result.getMethod().getMethodName());
        test.log(Status.INFO,result.getMethod().getDescription());
        test.log(Status.INFO,"Test Execution Started");
    }
    public void onTestSuccess(ITestResult result)
    {
        test.log(Status.PASS,"Test case Pass Successfully!!!!!");
    }
    public void onTestFailure(ITestResult result)
    {
        test.log(Status.FAIL,result.getThrowable());
        test.log(Status.FAIL,"Test case Failed");
    }
    public void onTestFailedButWithinSuccessPercentage(ITestResult result)
    {
        test.log(Status.FAIL,"Test is Failed");
    }
    public void onStart(ITestContext context) {
        reports = ExtentReportManager.createInstance();
    }
    public void onFinish(ITestContext context) {
        reports.flush();
    }

}
