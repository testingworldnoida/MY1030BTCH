package com.hcl.base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;

public class CreateDriverInstance {
	public ChromeDriver driver;
	public ExtentReports rep ;
	@BeforeSuite
	public void genReport()
	{
		rep  = new ExtentReports("./Reports/ProjectReport.html");
	}
	
	@AfterSuite
	public void saveReport()
	{
		rep.flush();
		rep.close();
	}
	
	
	@BeforeMethod
	public void startDriverObject()
	{
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver2.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
	}
	
	@AfterMethod
	public  void closeDriver()
	{
		driver.quit();
	}
	
	
	
}
