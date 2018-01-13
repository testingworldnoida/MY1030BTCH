package com.hcl.pages;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginPage {

	ChromeDriver driver;
	public LoginPage(ChromeDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void enterUsername(String uname)
	{
		driver.findElementById("email").sendKeys(uname);
	}
	
	public void enterPassword(String password)
	{
		driver.findElementById("pass").sendKeys(password);
	}
	
	public void clickSignin()
	{
		driver.findElementByXPath("//input[@type='submit']").click();
	}
	
}
