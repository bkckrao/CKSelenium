package com.Yours.Selenium.Scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.Bachu.Selenium.Basetest.BaseTest;
import com.Bachu.Selenium.Framework.Lib.Browser;
import com.Bachu.Selenium.Reporting.Reporting;

public class ModuleName extends ModuleName_Library{


private String getdata(String rowheading, String columnHeading) {
	return getdata(sTestdataFile, sTestdataSheet, rowheading, columnHeading);
}

@BeforeSuite
public void initialize() {
	Reporting.startReporting(this.getClass().getSimpleName());
	sTestdataFile = getproperty("testdatafile");
	sTestdataSheet = getproperty("testdatasheet");
}

@BeforeTest
public void setUp() throws Exception {
	//		Browser.openBrowser(Select_Browser.FF);
	Browser.openBrowser();
//	Browser.openBrowser(browser.IE);
	Browser.getURL(BaseTest.sURL);
	maximizethewindow(); deletecookies();
}

@AfterMethod
public void aftermethod() {
	Reporting.endTest();
}

@AfterSuite
public void teardown() {
	driver.quit();
	Reporting.reportflush();
	Reporting.reportclose();
}
// ---------------------------XXXXXXXXXXXXXXXXX      Do NOT CHANGE ABOVE LINES       XXXXXXXXXXXXXXXXX------------------------------------------


/**
 * Start writing methods and scripting from here
 */



}