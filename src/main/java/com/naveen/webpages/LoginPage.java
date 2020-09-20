package com.naveen.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveen.base.BaseEngine;

public class LoginPage extends BaseEngine
{
	@FindBy(name="username")
	private WebElement usernameTextField;
	
	@FindBy(name="pwd")
	private WebElement passwordTextField;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginButton;
	
	
	public LoginPage()
	{
		PageFactory.initElements(getDriver(), this);	
	}
	
	public void enterUsername(String username)
	{
		usernameTextField.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		passwordTextField.sendKeys(password);
	}
	
	public void clickOnLoginButton() throws InterruptedException
	{
		loginButton.click();
		Thread.sleep(3000);
	}
	
	public String getLoginTitile()
	{
		return getDriver().getTitle();
	}
	
}
