package com.CK.Scripts;

import org.testng.annotations.Test;

import com.Bachu.Selenium.Basetest.BaseTest;
import com.Bachu.Selenium.Framework.Lib.Util;
import com.Bachu.Selenium.Reporting.Reporting;
import com.CK.Pages.Naukri_Ids;

public class Naukri extends BaseTest{
	
	private String filename = "CK_Devops_Testing.docx";

	
	
	@Test
	public void naukriupdate() {
//		Reporting.startTest(getmethodname(new Object() {}));
		
//		browser.openBrowser();
		browser.getURL(sURL);
		
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
		Naukri_Ids.usernametf.setText(sUsername, "user name text field");

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
		lib.waitfortitleandvalidate("Profile | Mynaukri");
		
		
//		Clicking the Update Resume button and passing the path of the Resume		
		lib.clickButtonAndUploadFile(Naukri_Ids.uploadBtn, sResumePath);

		
//		To wait for 3 seconds
		Util.sleepforseconds(3);
		
//		To see the Uploaded on message	
		String uploadDate = Naukri_Ids.uploadedon.getText();
//		System.out.println("Resume last updated : " + uploadDate.replace("Uploaded on ", ""));
		
		Reporting.pass("Resume last updated : " + uploadDate.replace("Uploaded on ", ""), true);
	}
	
	
}