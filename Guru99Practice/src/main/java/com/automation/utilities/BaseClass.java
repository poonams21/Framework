package com.automation.utilities;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass 
{	
	public WebDriver driver;
	
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupSuite()
	{
		Reporter.log("Setting up reports and test is ready ", true);
		excel = new ExcelDataProvider();
		config= new ConfigDataProvider();
		
		ExtentSparkReporter extent = new ExtentSparkReporter(new File("./Reports/G99report"+Helper.getCurrentDateTime() +".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		Reporter.log("Settings Done ", true);
	}

	@BeforeTest
	public void setup()
	{
		driver= BrowserSetup.StartApplication(driver, config.getBrowser(), config.getAppURL());
		System.out.println(driver.getTitle());
	}
	@AfterTest
	public void teardown()
	{
		BrowserSetup.quitBrowser(driver);
	}

	@AfterMethod
	public void ssOnFailure(ITestResult result)
	{
		Reporter.log("SS for Failure ", true);
		if(result.getStatus()==ITestResult.FAILURE)
		{
			Helper.captureScreenshot(driver);
			logger.fail("Test Failed ",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		Reporter.log("SS Failure method done ", true);
		report.flush();
	}
}
