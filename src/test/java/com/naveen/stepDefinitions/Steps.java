package com.naveen.stepDefinitions;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.naveen.base.BaseEngine;
import com.naveen.supporters.ExcelReader;
import com.naveen.supporters.PropertiesReader;
import com.naveen.util.FilePaths;
import com.naveen.webpages.HomePage;
import com.naveen.webpages.LoginPage;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

 

public class Steps extends BaseEngine
{
	
	
	private static ExcelReader excelReader;
	  private static int count = 1;
	  private static int rowCount = 1;
	  String scName;
	  
	  @Before
	  public void setUp(Scenario scenario) throws EncryptedDocumentException, InvalidFormatException, IOException
	  {
		 System.out.println("=======================================");
	     System.out.println("Before Execution");
	     scName = scenario.getName();
	     System.out.println("Currently Executing Scenario Name is: "+scName);
		 
	     excelReader = new ExcelReader(FilePaths.excelPath);
		 excelReader.writeData("Frame",count,0,scName);
		 count++;
	     
	     openBrowser();
		  
	  }
	  
	  @After
	  public void tearDown(Scenario scenario) throws EncryptedDocumentException, InvalidFormatException, IOException
	  {
		  System.out.println("After Executing test case");
		  String status = scenario.getStatus();
		  scName = scenario.getName();
		  System.out.println("Scenario status is: "+status);
		  
		  if(status.equals("passed"))
		  {
			  System.out.println("Scneario passed is: "+scName);
			  excelReader = new ExcelReader(FilePaths.excelPath);
			  excelReader.writeDataTwo("Frame",rowCount,1,"PASS");
		  }
		  
		  else if(status.equals("failed"))
		  {
			  System.out.println("Scneario failed is: "+scName);
			  excelReader = new ExcelReader(FilePaths.excelPath);
			  excelReader.writeDataTwo("Frame",rowCount,1,"FAIL");
			  rowCount++;
		  }
		  
		  
		  else if(status.equals("skipped"))
		  {
			  System.out.println("Scneario skipped is: "+scName);
			  excelReader = new ExcelReader(FilePaths.excelPath);
			  excelReader.writeDataTwo("Frame",rowCount,1,"SKIP");
			  rowCount++;
		  }
		  
		  
		  if (scenario.isFailed()) 
		 {
			   // Take a screenshot...
			   final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
			   
			   // embed it in the report.
			   scenario.embed(screenshot, "image/png"); 
		  }
		  closeBroswer();
		  System.out.println("=======================================");
	  }
	
	
	
	
	
	
	
	
	LoginPage loginPage; 
	PropertiesReader prOr;
	HomePage homePage = new HomePage();
	
	@Given("^when user is on login page$")
	public void when_user_is_on_login_page()
	{
		loginPage = new LoginPage();
		String ltit = loginPage.getLoginTitile();
		Assert.assertEquals("actiTIME - Login", ltit);
	}

	
	
	@When("^user enters valid credentials$") 
	public void user_enters_valid_credentials() throws IOException
	{
		prOr = new PropertiesReader(FilePaths.configPath);
		loginPage = new LoginPage();
		
		loginPage.enterUsername(prOr.getPropertyValue("userName"));
		loginPage.enterPassword(prOr.getPropertyValue("password"));
		
	}

	
	
	@When("^when he clicks on login$") 
	public void when_he_clicks_on_login() throws InterruptedException
	{
		loginPage = new LoginPage();
		loginPage.clickOnLoginButton();
	}
	
	@Then("^login should be successful$") 
	public void login_should_be_successful()
	{
		Assert.assertEquals("actiTIME - Open Tasks",homePage.getHomePageTitle());
	}

}
