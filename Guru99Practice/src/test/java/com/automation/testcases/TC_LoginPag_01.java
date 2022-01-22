package com.automation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.pages.LoginPage;
import com.automation.utilities.BaseClass;
import com.automation.utilities.Helper;

public class TC_LoginPag_01 extends BaseClass
{
	
	@Test(priority=1)
	public void LPValidation()
	{
		logger = report.createTest("Login to App");
		
	LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
	logger.info("Starting Application");
	loginPage.loginToGuru99(excel.getStringData(0, 0, 0), excel.getStringData(0, 0, 1));
	logger.pass("Login done");
	
	System.out.println("After login " + driver.getTitle());
	

	}
	
	@Test(dependsOnMethods = "LPValidation")
	public void validateTitle()
	{
		logger= report.createTest("Title Validation");
		
		try {
			Thread.sleep(200);
			String title = driver.getTitle();
			Assert.assertEquals(title, "GTPL Bank Home Page !");
			logger.pass("Title Validation pass ");
		} catch (Exception e) {
			logger.fail("Title Validation Failed ");
			System.out.println(e.getMessage());
		}
	}
	
	
}
