package com.Yours.Selenium.Scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.CK.Selenium.Basetest.BaseTest;
import com.CK.Selenium.Browser.*;
import com.CK.Selenium.Reporting.Reporting;

public class ModuleName extends ModuleName_Library{



@BeforeTest
public void setUp() throws Exception {
	//		Browser.openBrowser(Select_Browser.FF);
	Browser.openBrowser();
//	Browser.openBrowser(browser.IE);
	Browser.getURL(BaseTest.sURL);
	maximizethewindow(); deletecookies();
}

// ---------------------------XXXXXXXXXXXXXXXXX      Do NOT CHANGE ABOVE LINES       XXXXXXXXXXXXXXXXX------------------------------------------


/**
 * Start writing methods and scripting from here
 */

@Test
public void test1() {
	
}

}