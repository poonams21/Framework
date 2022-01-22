package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage 
{
	WebDriver driver;
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}

	@FindBy(name="uid") WebElement username;
	@FindBy(name="password") WebElement password;
	@FindBy(name="btnLogin") WebElement loginBtn;
	
	public void loginToGuru99(String uname, String pwd)
		{
		try {
			Thread.sleep(200);
			username.sendKeys(uname);
			Thread.sleep(200);
			password.sendKeys(pwd);
			Thread.sleep(200);
			loginBtn.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
