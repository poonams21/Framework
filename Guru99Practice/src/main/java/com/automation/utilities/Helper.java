package com.automation.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	public static String captureScreenshot(WebDriver driver)
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		String screeshotPath = System.getProperty("user.dir")+"/Screenshots/G99"+getCurrentDateTime() +".png";
		try {
			FileHandler.copy(src, new File("./Screenshots/G99"+getCurrentDateTime() +".png"));
			System.out.println("Screenshot captured");
		} catch (Exception e) {
			System.out.println("Unable to capture Screenshot "+e.getMessage());
		}
		return screeshotPath;
	}

	
	public static  String getCurrentDateTime()
	{
		DateFormat customformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customformat.format(currentDate);
		
	}
}
