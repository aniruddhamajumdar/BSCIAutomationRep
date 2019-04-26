package com.BSC.framework.pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.BSC.framework.DriverScript;
import com.BSC.framework.utilities.Log;

public class WorkBench {
	WebDriver driver;
	 
	 @FindBy(how = How.XPATH, using = "//select[@name='oauth_host']")
	 
	 public WebElement dropdown_Env;
	 
	 @FindBy(how = How.XPATH, using = "//a[text()='I agree to the terms of service']//preceding::input[@type='checkbox'][1]")
	 
	 public WebElement checkbox_TermsConditions;
	 
	 @FindBy(how = How.ID, using = "loginBtn")
	 
	public WebElement btn_LoginToSFDC ;
	 
    

@FindBy(how = How.XPATH, using = "//a/span[text()='utilities']")

public WebElement link_utilities;

@FindBy(how = How.XPATH, using = "//a[text()='REST Explorer']")

public WebElement link_RESTExpl;

@FindBy(how = How.XPATH, using = "//input[@value='POST']")

public WebElement radio_POST;

@FindBy(how = How.ID, using = "urlInput")

public WebElement txt_HeaderPath;

@FindBy(how = How.XPATH, using = "//*[@id='requestBodyContainer']/textarea")

public WebElement txtarea_requestBody;



@FindBy(how = How.XPATH, using = "//*[@id='execBtn']")

public WebElement btn_execute;





	 
	 
	// This is a constructor, as every page need a base driver to find web elements
	 
	public WorkBench(WebDriver driver){ 
	 
	    this.driver = driver; 
	 
	    } 
	
	public static void navigateToURL(){
		try{
			Log.info("Navigating to URL");
			
			DriverScript.driver.get("https://workbench.developerforce.com");
			System.out.println("abcdefg");
			DriverScript.driver.manage().window().maximize();
			System.out.println("vccvcvc");
			DriverScript.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}catch(Exception e){
			Log.info("Not able to navigate --- " + e.getMessage());
			
			}
		}


}
