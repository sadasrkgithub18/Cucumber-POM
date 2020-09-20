package com.naveen.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveen.base.BaseEngine;

public class EditCustomerInformationPage extends BaseEngine
{
	@FindBy(xpath="//input[@value='Delete This Customer']")
	private WebElement deleteTheCustomer;
	
	public EditCustomerInformationPage()
	{
		PageFactory.initElements(getDriver(), this);
		
	}
	public void deleteThisCustomer() 
	{
		deleteTheCustomer.click();
	}
}
