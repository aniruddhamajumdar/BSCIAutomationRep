package com.BSC.framework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginAs {
	//final WebDriver driver;
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Search Salesforce']")
	 
	 public WebElement txtbox_SearchSalesforce ;

   @FindBy(how = How.XPATH, using = "//span[@title='test automation2']")

   public WebElement menu_searchUser ;
 //*[@id=\"brandBand_1\"]/div[2]/div[1]/div[2]/div[1]/div/div[1]/div/header/div[2]/div/div[1]/div[3]/div[2]/ul/li[3]/a/div
   @FindBy(how = How.XPATH, using = "//*[@id='brandBand_1']/div[2]/div[1]/div[2]/div[1]/div/div[1]/div/header/div[2]/div/div[1]/div[3]/div[2]/ul/li[3]/a/div")

   public WebElement link_UserDetail ;
   
   @FindBy(how = How.XPATH, using = "//table/tbody/tr/td[@id='topButtonRow']/input[@name='login']")

   public WebElement btn_LoginAs;
 
}
