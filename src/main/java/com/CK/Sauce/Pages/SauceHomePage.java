package com.CK.Sauce.Pages;

import com.Bachu.Selenium.Framework.Lib.Button;
import com.Bachu.Selenium.Framework.Lib.Label;
import com.Bachu.Selenium.Framework.Lib.Link;

public class SauceHomePage {

	public static Label ProductsLabel = new Label("//span[@class='title'][contains(text(),'Products')]");
	public static Button BurgerMenu = new Button("//button[@id='react-burger-menu-btn']");
	
	public static Link AllItems = new Link("//a[@id='inventory_sidebar_link']");
	public static Link About = new Link("//a[@id='about_sidebar_link']");
	public static Link Logout = new Link("//a[@id='logout_sidebar_link']");
	public static Link ResetAppState = new Link("//a[@id='reset_sidebar_link']");
	public static Link Close_BurgerMenu = new Link("//button[@id='react-burger-cross-btn']");
	public static Label Num_of_AddToCart_Btns = new Label("//button[starts-with(@id,'add-to-cart')]");
	public static Link ShoppingCart = new Link("//a[@class='shopping_cart_link']");
	public static Label SortingContainer = new Label("//select[@class='product_sort_container']");
	
	
}
