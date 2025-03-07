package com.CK.Sauce.Scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.Bachu.Selenium.Basetest.BaseTest;
import com.Bachu.Selenium.Reporting.Reporting;
import com.CK.Sauce.Pages.SauceHomePage;

public class SauceLibrary extends BaseTest{

	
	public void sortby(String sort) {
		lib.isElementPresent(By.xpath(SauceHomePage.SortingContainer.getElement()));
		Select sort1 = new Select(getDriver().findElement(By.xpath(SauceHomePage.SortingContainer.getElement())));
		sort1.selectByVisibleText(sort);
		Reporting.pass("System successfully sorted in the order : "+sort);
	}
}
