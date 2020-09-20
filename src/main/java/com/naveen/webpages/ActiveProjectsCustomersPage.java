package com.naveen.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveen.base.BaseEngine;

public class ActiveProjectsCustomersPage extends BaseEngine
{
	@FindBy(linkText="Projects & Customers")
	private WebElement ProjectsAndCutomers;
	
	@FindBy(xpath="//input[@value='Add New Customer']")
	private WebElement clickOnAddNewCustomer;
	
	
	@FindBy(className="successmsg")
	private WebElement customerCreatedSuccessfuly;
	
	@FindBy(linkText="OLAM")
	private WebElement cutomerOLAM;
	
	
	public ActiveProjectsCustomersPage()
	{
		PageFactory.initElements(getDriver(), this);
		
	}
  
	public void clickOnProjectsAndCutomers()
	{
		ProjectsAndCutomers.click();
	}
	
	public void clickOnAddNewCutomer()
	{
		clickOnAddNewCustomer.click();
	}
	
	public void clickonOLAMCustomer() 
	{
		cutomerOLAM.click();
	}
	
	
	public String retrieveSuccessMessage()
	{
	
		String data = customerCreatedSuccessfuly.getText();
		return data;
	}
	
	 
	
}
