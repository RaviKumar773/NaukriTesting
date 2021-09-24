package com.qa.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports exReports;
	public ExtentTest xTest;
	
	 @Override
	  public void onStart(ITestContext testContext) {
		 
		 String DateStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		 String repName = "Test-Report-"+DateStamp+".html";
		 String dest= System.getProperty("user.dir")+"/Reports/"+ repName;
		 
		 htmlReporter = new ExtentHtmlReporter(dest);
		 exReports = new ExtentReports();
		 
		 exReports.attachReporter(htmlReporter);
		 exReports.setSystemInfo("HostName", "LocalHost");
		 exReports.setSystemInfo("QA", "Jyothi");
		 exReports.setSystemInfo("OS", "Windows10");
		 
		 htmlReporter.config().setDocumentTitle("Test Automation");
		 htmlReporter.config().setReportName("Functional Test Report");
		 htmlReporter.config().setTheme(Theme.DARK);
	   
	  }

	  @Override
	  public void onFinish(ITestContext testContext) {
		  
		  exReports.flush();
		  
	  }
	  
	  @Override
	  public void onTestSuccess(ITestResult tr) {
		  
		  xTest = exReports.createTest(tr.getName());
		  xTest.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		  xTest.log(Status.PASS, "Test is Passed");
		  
	   
	  }

	  @Override
	  public void onTestFailure(ITestResult tr) {
		  
		  xTest = exReports.createTest(tr.getName());
		  xTest.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		  xTest.log(Status.FAIL, "Test is Failed");
	   
	  }

	  @Override
	  public void onTestSkipped(ITestResult tr) {
		  
		  xTest = exReports.createTest(tr.getName());
		  xTest.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
		  xTest.log(Status.SKIP, "Test is Skipped");
	   
	  }

}
