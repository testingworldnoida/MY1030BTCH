package com.hcl.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hcl.base.CreateDriverInstance;
import com.hcl.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC_001_Login_Valid_Credentials extends CreateDriverInstance{

	@Test
	public void tc_001() throws InterruptedException
	{
		Logger log = Logger.getLogger(TC_001_Login_Valid_Credentials.class);
		ExtentTest t1 = rep.startTest("TC_002_Login_Logout");
		LoginPage login = new LoginPage(driver);
		login.enterUsername("a");
		login.enterPassword("b");
		login.clickSignin();
		
		System.out.println("Done");
		t1.log(LogStatus.FAIL, "Login Successfully");
		rep.endTest(t1);
		
	}
	
	@DataProvider(name="dp1")
	public Object[][] testData() throws IOException
	{
		File f = new File("E:\\TData.xlsx");
		FileInputStream fs = new FileInputStream(f);
		XSSFWorkbook wk =new XSSFWorkbook(fs);
		XSSFSheet s1 =  wk.getSheet("Sheet1");
		int r = s1.getPhysicalNumberOfRows();
		XSSFRow r2 = s1.getRow(0);
		int c = r2.getPhysicalNumberOfCells();
		Object [][] data = new Object[r][c];
	
		for(int i=0;i<r;i++)
		{
			XSSFRow r1 = s1.getRow(i);
			XSSFCell c1 = r1.getCell(0);
			XSSFCell c2 = r1.getCell(1);
			data[i][0] =  c1.getStringCellValue();
			data[i][1] =  c2.getStringCellValue();
		}
		
		
		return data;
	}
	
}
