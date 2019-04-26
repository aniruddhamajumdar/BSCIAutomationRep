package com.BSC.framework.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.BSC.framework.DriverScript;
import com.BSC.framework.action.WebDriverActionKeywords;
import com.BSC.framework.pageObjects.WorkBench;

public class WorkbenchLocationStrategy extends WebDriverActionKeywords {
public static WorkBench workbench =  PageFactory.initElements(DriverScript.driver, WorkBench.class);
public static WebDriverActionKeywords actions =  PageFactory.initElements(DriverScript.driver, WebDriverActionKeywords.class);


/*

	public static void payloadProcess(String object,String data) {
		
		//HomePage.lnk_MyAccount.click();
		 
		workbench.navigateToURL();
		actions.selectDropdown(workbench.dropdown_Env,"test.salesforce.com");
		actions.click(workbench.checkbox_TermsConditions);
		actions.click(workbench.btn_LoginToSFDC);
		actions.input(workbench.txtbox_SFDCUser, "ipsita.roy@bsci.com.qar1");
		actions.input(workbench.txtbox_SFDCPasswrd, "automation111");
		actions.click(workbench.btn_SFDCLogin);
		 try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
	}
	*/
	public static void loginSalesforce() throws InterruptedException {
        Select environment = new Select(workbench.dropdown_Env);
        environment.selectByValue("test.salesforce.com");
        Thread.sleep(7000);
        workbench.checkbox_TermsConditions.click();
        /*
   WebElement remember_me1 = driver.findElement(By.xpath("//a[text()='I agree to the terms of service']//preceding::input[@type='checkbox'][1]"));
   remember_me1.click();
   WebElement loginsalesforce = driver.findElement(By.id("loginBtn"));
   loginsalesforce.click();
        WebElement username = driver.findElement(By.id("username"));
   username.clear();
   username.sendKeys("ipsita.roy@bsci.com.qar1");
   // enter a valid password in the email textbox
   WebElement password = driver.findElement(By.id("password"));
   password.clear();
   password.sendKeys("automation111");
WebElement login = driver.findElement(By.xpath("//input[@type='submit']"));
   
  // WebElement remember_me = driver.findElement(By.xpath("//input[@type='checkbox']"));
   //remember_me.click();
   login.click();
  Thread.sleep(9000);
   
   System.out.println("Test script executed successfully");
   */
  }
  public static void payloadProcess() throws InterruptedException {
  	loginSalesforce();
  	/*
   String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
   String subWindowHandler = null;
   System.out.println(parentWindowHandler);
   int size = driver.findElements(By.tagName("iframe")).size();
   System.out.println("SIZE IS :"+ size);

   Set<String> handles = driver.getWindowHandles(); // get all window handles
   System.out.println(handles);
   Iterator<String> iterator = handles.iterator();
   while (iterator.hasNext()){
       subWindowHandler = iterator.next();
   }
   driver.switchTo().window(subWindowHandler); // switch to popup window
  try {
        Thread.sleep(2000);
  } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
  }
   
   WebElement api1 = driver.findElement(By.xpath(("//a/span[text()='utilities']")));
   api1.click();
   WebElement api2=driver.findElement(By.xpath(("//a[text()='REST Explorer']")));
   //Select util1 = new Select (driver.findElement(By.xpath(("//a/span[text()='utilities']"))));
   api2.click();
   driver.switchTo().window(parentWindowHandler);
   WebElement api3=driver.findElement(By.xpath("//input[@value='POST']"));
   api3.click();
   WebElement api4= driver.findElement(By.id("urlInput"));
   api4.clear();
   api4.sendKeys("/services/apexrest/v1/CycleCountPath");
  }
 
  public static void readfile() throws IOException {
  	String script=null;
     String fileName = "C:\\Users\\ipsita.a.roy\\Desktop\\payloadnew.txt";
      File file = new File(fileName);
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);
      
      String line;
     JavascriptExecutor js = (JavascriptExecutor)driver;
     String id="requestBodyContainer";
        WebElement requestBody = driver.findElement(By.xpath("//*[@id='requestBodyContainer']/textarea"));
        //List<WebElement> requestBody = driver.findElements(By.xpath("//textarea[1]"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
         wait.until(ExpectedConditions.elementToBeClickable(requestBody));
        Actions builder = new Actions(driver);
        builder.moveToElement(requestBody)
             .build();
builder.click();
           
           //builder.sendKeys("ABC");
           builder.perform();
           
      
           String newline=null;
     
    //mouseOvercreateOrder.perform();
      
        while((line = br.readLine()) != null){
            //process the line
            System.out.println(line);
            newline=line + "\n";
            
           // script= String.format("arguments[0].value='%s';", line);
            requestBody.sendKeys(newline);
            newline=line + "\n";
            
            
           
        }
        */
  }
}
