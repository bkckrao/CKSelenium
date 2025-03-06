package com.CK.Sauce.Scripts;

import org.testng.annotations.Test;
import com.Bachu.Selenium.Reporting.Reporting;
import com.CK.Sauce.Pages.SauceHomePage;
import com.CK.Sauce.Pages.SauceLoginPage;



public class SauceLabs extends SauceLibrary{

	@Test
	public void sauce_Login() {
		browser.getURL();
		lib.maximizethewindow();
		
		String Username =  getdata("Username"); // "standard_user"
		String Password = getdata("Password"); // "secret_sauce"; 
		
		SauceLoginPage.Username.setText(Username, "Username");
		SauceLoginPage.password.setText(Password, "Password");
		
		Reporting.fail("test fail screenshot", true);
		
		SauceLoginPage.LoginBtn.click("Login Btn");
		
		SauceHomePage.ProductsLabel.verifyElementPresent("Products heading");
		SauceHomePage.BurgerMenu.click("Burger Menu");
		SauceHomePage.AllItems.verifyElementPresent("AllItems");
		
		SauceHomePage.ShoppingCart.verifyElementPresent("ShoppingCart");
		SauceHomePage.About.verifyElementPresent("About");
		SauceHomePage.Logout.verifyElementPresent("Logout");
		SauceHomePage.ResetAppState.verifyElementPresent("ResetAppState");
		
		
		sortby("Price (high to low)");
		System.out.println("Num of Add to Cart buttons : " +lib.getXpathsCount(SauceHomePage.Num_of_AddToCart_Btns.getElement()));
        
	
	}
}