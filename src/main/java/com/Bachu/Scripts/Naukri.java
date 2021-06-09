package com.Bachu.Scripts;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Bachu.Pages.Naukri_Ids;
import com.CK.Selenium.*;
import com.CK.Selenium.Basetest.BaseTest;
import com.CK.Selenium.Browser.Browser;
import com.CK.Selenium.Framework.Lib.FrameLib;
import com.CK.Selenium.Framework.Lib.Util;

public class Naukri extends FrameLib{
	
	private String filename = "CK_Devops_Testing.docx";
/*
	private String getdata(String rowheading, String columnHeading) {
		return getdata(sTestdataFile, sTestdataSheet, rowheading, columnHeading);
	}
*/
/*	@BeforeSuite
	public void initialize() {
		Reporting.startReporting(this.getClass().getSimpleName());
		sTestdataFile = getproperty("testdatafile");
//		sTestdataSheet = getproperty("testdatasheet");
	}
	
	*/

	@BeforeTest
	public void setUp() throws Exception {
		//		Browser.openBrowser(Select_Browser.FF);
		Browser.openBrowser();
//		Browser.openBrowser(browser.IE);
		Browser.getURL(BaseTest.sURL);
		maximizethewindow(); deletecookies();
	}

	
	@Test
	public void naukriupdate() {
//		Reporting.startTest(getmethodname(new Object() {}));
		
		
//		To get the path of resume which is placed in the Testdata folder.
		String sResumePath = sTestdataPath + filename;
		
//		To get the usename from the Excel sheet which is placed in the Testdata folder, name of the sheet is declared in the config.properties
		String sUsername = getdata("Username");
		
//		To get the Password from the Excel sheet which is placed in the Testdata fodler, name of the sheet is declared in the config.proerties
		String sPassword = getdata("Password");

//		Waiting and verifying the presence of Login link
		Naukri_Ids.loginLink.isElementPresent("Login Link element");
		
//		Clicking the Login Link
		Naukri_Ids.loginLink.click("Login Link");
		
//		Waiting and verifying the presence of Username Text field
		Naukri_Ids.usernametf.isElementPresent("Username Text field");
		
//		Entering the username value in the Username text Field
		Naukri_Ids.usernametf.setText(sUsername, "user name text fieeld");

//		Entering the Password value in the Password text Field
		Naukri_Ids.passwordtf.setText(sPassword, "Password text field");
		
//		Clicking the Login button
		Naukri_Ids.loginButton.click("Login Button");
		
//		Waiting and verifying the presence of element My naukkri Link
		Naukri_Ids.myNaukriLink.isElementPresent("My naukri Link");
		
//		Hovering the My naukri Link  and clikcing the Edit Profile Button
//		hovernclick(Naukri_Ids.myNaukriLink.getElement(), Naukri_Ids.editProfileLink.getElement());
		Naukri_Ids.editProfileLink.click("Edit Profile link");
		
//		Waiting for the My Profile  Page and validating the Title
		waitfortitleandvalidate("Profile | Mynaukri");
		
		
//		Clicking the Update Resume button and passing the path of the Resume		
		try {
			driver.findElement(By.xpath("//div[@class='uploadContainer']/input")).sendKeys(sResumePath);
		} catch (Exception e1) {
			System.out.println("Cause : " + e1.getCause());
			System.out.println("Message : "+e1.getMessage());
			e1.printStackTrace();
		}
		
//		To wait for 3 seconds
		Util.sleepforseconds(3);
		
//		To see the Uploaded on message	
		String uploadDate = Naukri_Ids.uploadedon.getText();
		System.out.println("Resume last updated : " + uploadDate.replace("Uploaded on ", ""));
		
	}
	
	
}