package com.api.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {
    private static ExtentReports reports;
    private static ExtentSparkReporter htmlReporter;
    //private static ExtentTest test;
    private static String resultPath=getResultPath();

    public static ExtentReports getInstance() {
        if (reports == null)
            createInstance();
        return reports;
    }
    //Create an extent report instance
    public static ExtentReports createInstance() {
        String reportLocation="test-output/Report/"+resultPath+"/";
        htmlReporter = new ExtentSparkReporter(reportLocation+"extent.html");
        htmlReporter.config().setDocumentTitle("Title of the Report Comes here ");
        htmlReporter.config().setReportName("API Test Execution Results");
        htmlReporter.config().setTheme(Theme.STANDARD);
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);
        return reports;
    }
    public static String getResultPath(){
        resultPath=new SimpleDateFormat("yyyy-MM-dd hh-mm.ss").format(new Date());
        //resultPath="test";
        if(!new File(resultPath).isDirectory()){
            new File(resultPath);
        }
        return resultPath;
    }

}
