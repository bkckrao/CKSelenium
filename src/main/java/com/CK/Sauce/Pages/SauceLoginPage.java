package com.CK.Sauce.Pages;

import com.Bachu.Selenium.Framework.Lib.Button;
import com.Bachu.Selenium.Framework.Lib.Label;
import com.Bachu.Selenium.Framework.Lib.Textfield;

public class SauceLoginPage {
	
	public static Label title = new Label("Swag Labs");
	
	public static Textfield Username = new Textfield("//input[@id='user-name']");
	public static Textfield password = new Textfield("//input[@id='password']");
	public static Button LoginBtn = new Button("//input[@id='login-button']");
	
	
	
	
	
	

}
