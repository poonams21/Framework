package com.automation.utilities;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserSetup 
{
public static WebDriver StartApplication(WebDriver driver,String browsername,String appURL)
{
	switch(browsername)
	{
	case "chrome":
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		break;
		
	case "IE":
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		break;
		
	case "firefox":
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/geckodriver.exe");
		driver = new FirefoxDriver();
		break;
		
	default :
		System.out.println("browser : "+ browsername + " is invalid, Launching chrome as browser of choice...");
		driver = new ChromeDriver();
	}
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
	driver.manage().window().maximize();
	driver.get(appURL);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	return driver;
	
}

public static void quitBrowser(WebDriver driver)
{
	driver.quit();
}
}
