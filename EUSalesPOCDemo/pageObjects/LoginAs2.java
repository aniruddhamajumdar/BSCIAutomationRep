package com.BSC.framework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginAs2 {
	//final WebDriver driver;
	@FindBy(how = How.XPATH, using = "//span[@class='userProfileCardTriggerRoot oneUserProfileCardTrigger']")
	 
	 public WebElement image_ProfileIcon;

   @FindBy(how = How.XPATH, using = "//a[@class='profile-link-label switch-to-aloha uiOutputURL']")

   public WebElement link_switchToClassic;
 
   @FindBy(how = How.XPATH, using = "//input[@id='phSearchInput']")

   public WebElement txtbox_SearchUser ;
   
   @FindBy(how = How.XPATH, using = "//a/span[@class='userMru']")
   
   public WebElement link_userMenu ;
     
   @FindBy(how = How.XPATH, using = "(//a[contains(text(),'Switch to')])[2]")
   
   public  WebElement check_classicOrLightining;
   
  
 //button[contains(text(),'Log In')]
   @FindBy(how = How.XPATH, using = "//a[@title='User Action Menu']")

   public WebElement link_UserActionMenu;
   
   @FindBy(how = How.XPATH, using = "//a[@title='User Detail']")

   public WebElement link_UserDetail;
   @FindBy(how = How.XPATH, using = "//*[@id='topButtonRow']/input[4]")

   public WebElement btn_Login;
   

   @FindBy(how = How.XPATH, using = "//a[text()='Log out as RFID gfim']")

   public WebElement link_SalesUser;
   
   @FindBy(how = How.XPATH, using = "//*[@id=\"phHeader\"]/tbody/tr/td[3]/div/div[3]/div/a")

   public WebElement link_SwitchLightning;

}

