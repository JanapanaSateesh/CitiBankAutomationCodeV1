package com.citibank.utilities;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListner implements ITestListener{
	
	ExtentSparkReporter htmlreport;
	ExtentReports report;
	ExtentTest test;
	public static ThreadLocal<ExtentTest> extentTestThreadLocal=new ThreadLocal<ExtentTest>();
	
	public void ConfigureReport() {
		String timestamp=new SimpleDateFormat("YYYY_dd_MM_hh_mm_ss").format(new Date());
		
		htmlreport=new ExtentSparkReporter("./Reports/Summary_Report"+timestamp+".html");
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Machine", "Test");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("User", "Sateesh");
		
		htmlreport.config().setDocumentTitle("Citi Bank Automation Test Report");
		htmlreport.config().setTheme(Theme.DARK);
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=report.createTest(result.getName());
		extentTestThreadLocal.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("OnTestSuccess Started");
		ExtentTest test=extentTestThreadLocal.get();
		test.log(Status.PASS, result.getName()+" "+"is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("OnTestFailure Started");
		ExtentTest test=extentTestThreadLocal.get();
		
	     WebDriver driver=	(WebDriver)result.getTestContext().getAttribute("driver");
		
		byte[] screenshotBytes= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		String screenshot=Base64.getEncoder().encodeToString(screenshotBytes);
		test.addScreenCaptureFromBase64String(screenshot);
		test.log(Status.FAIL, result.getName()+"is failed");
		test.fail(result.getThrowable().getMessage());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ConfigureReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		report.flush();
	}

	
}
