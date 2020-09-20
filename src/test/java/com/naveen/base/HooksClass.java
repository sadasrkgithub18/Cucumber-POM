package com.naveen.base;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.naveen.supporters.ExcelReader;
import com.naveen.util.FilePaths;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class HooksClass extends BaseEngine
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
}
