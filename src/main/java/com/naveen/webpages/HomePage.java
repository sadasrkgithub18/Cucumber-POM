package com.naveen.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveen.base.BaseEngine;

public class HomePage extends BaseEngine
{
	@FindBy(className="logoutImg")
	private WebElement logoutButton;
	
		
	public HomePage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public String getHomePageTitle()
	{
		return getDriver().getTitle();
	}
}
