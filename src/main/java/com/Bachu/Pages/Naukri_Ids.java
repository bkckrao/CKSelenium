package com.Bachu.Pages;

import com.CK.Selenium.Framework.Lib.*;
import com.CK.Selenium.Framework.Lib.SimpleLib.Type;

/*
import com.Bachu.Selenium.Framework.Lib.Button;
import com.CK.Selenium.Framework.Lib.Label;
import com.CK.Selenium.Framework.Lib.Link;
import com.CK.Selenium.Framework.Lib.Textfield;
import com.CK.Selenium.Framework.Lib.SimpleLib.Type;
*/



public class Naukri_Ids {

	
	public static Link loginLink = new Link("//div[contains(text(),'Login')]");
	public static Textfield usernametf = new Textfield("//input[@placeholder='Enter your active Email ID / Username']");
	public static Textfield passwordtf = new Textfield("//input[@placeholder='Enter your password']");
	public static Button loginButton = new Button("//button[@class='btn-primary loginButton']");
	
	public static Link myNaukriLink = new Link("//div[contains(text(),'My Naukri')]"); 
	
	public static Link editProfileLink = new Link("//a[contains(text(),'Edit Profile')]");
	
	public static Link logoutLink = new Link("//a[@class='logout-gnb'][@title='Logout']");
//	public static Button updateResumeButton = new Button("//input[@id='attachCV']");
	
	//public static Button updateResumeButton = new Button("//div[@class='uploadContainer']/input[@id='attachCV']");
	public static Button updateResumeButton = new Button("#attachCV", Type.CSS);
	public static Label successmsg = new Label("//span[@id='attachCVMsgBox']");	
	public static Label uploadedon = new Label("//span[@class='updateOn']");
//	public static Label uploadedon = new Label(".updateOn", Type.CSS);
}
