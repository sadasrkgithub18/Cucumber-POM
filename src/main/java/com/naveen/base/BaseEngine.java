package com.naveen.base;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


import com.naveen.supporters.PropertiesReader;
import com.naveen.util.DriverPaths;
import com.naveen.util.FilePaths;



public class BaseEngine 
{
	
	private static WebDriver driver;
    private static String curDir;
    private static PropertiesReader prOr; 
    
	
	
	public void openBrowser() throws IOException
	{
		curDir = System.getProperty("user.dir");
		prOr = new PropertiesReader(FilePaths.configPath);
		
		
	if(driver == null)
	{	
		if(prOr.getPropertyValue("browser").equalsIgnoreCase("ie"))
		{
	      System.setProperty(DriverPaths.ieKey, DriverPaths.ieValue);
	      //System.setProperty("webdriver.ie.driver","C:\\Users\\K SADA SIVA REDDY\\eclipse-workspaceE\\FrameworksSelenium\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			enterURL();
		}
		
		else if(prOr.getPropertyValue("browser").equalsIgnoreCase("chrome"))
		{
			
			System.setProperty(DriverPaths.chromeKey, DriverPaths.chromeValue);
		//	System.setProperty("webdriver.chrome.driver","C:\\Users\\K SADA SIVA REDDY\\eclipse-workspaceE\\FrameworksSelenium\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver(); 
			enterURL();
		}
		
		else if(prOr.getPropertyValue("browser").equalsIgnoreCase("firefox"))
		{
		 	System.setProperty(DriverPaths.firefoxKey, DriverPaths.firefoxValue);		
		//	System.setProperty("webdriver.gecko.driver","C:\\Users\\K SADA SIVA REDDY\\eclipse-workspaceE\\FrameworksSelenium\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();	
			enterURL();
		}
	 }
		
   }
    
       
       public static void enterURL()
	   {
    	   try 
    	   {
			prOr = new PropertiesReader(FilePaths.configPath);
	       } 
    	   catch (IOException e) 
    	   {
			e.printStackTrace();
		   }
    	  
		   getDriver().get(prOr.getPropertyValue("gmail_url"));
		   init();
		   
	   }
       
       private static void init()
   	  {
   		driver.manage().window().maximize();
   		driver.manage().timeouts().pageLoadTimeout(18, TimeUnit.SECONDS);
   		driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
   		driver.manage().deleteAllCookies();
   			
   	  }
       
       public void closeBroswer() 
   	  {
   		Optional<WebDriver> optional = Optional.ofNullable(driver);
   		if(optional.isPresent())
   		{
   			driver.quit();
   			driver = null;
   		}
   		
   		else
   		{
   		
   			System.out.println("Driver is pointing to NULL");
   		}
   	  }
       
       public static WebDriver getDriver()
      {
   		return driver;
   	  }
       
       public static String getCurDir()
   	  {
   		return curDir;
   	  }
}
