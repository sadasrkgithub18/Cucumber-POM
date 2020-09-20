package com.naveen.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveen.base.BaseEngine;

public class AddNewCustomerPage extends BaseEngine
{
	@FindBy(name="name")
	private WebElement customerNameTextField;
	
	@FindBy(xpath="//input[@value='Create Customer']")
	private WebElement  createCustomerButton;
	
	
	public AddNewCustomerPage()
	{
		PageFactory.initElements(getDriver(), this);
		
	}
	
	public void enterCustomername(String customerName)
	{
		customerNameTextField.sendKeys(customerName);
	}
	
	public void clickOnCreateCustomerButton()
	{
		createCustomerButton.click();
	}
	
	
}
