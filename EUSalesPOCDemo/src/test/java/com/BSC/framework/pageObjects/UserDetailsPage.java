package com.BSC.framework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.BSC.framework.DriverScript;
import com.BSC.framework.action.BaseTest;
import com.BSC.framework.utilities.Constants;
import com.BSC.framework.utilities.Log;

public class UserDetailsPage extends BaseTest  {
     
	
	public UserDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//nav[@class='appLauncher slds-context-bar__icon-action']")
	public WebElement link_applauncher ;
	
	@FindBy(how = How.XPATH, using = "(//table/tbody/tr[16]/td[2])[1]")
	public WebElement managerProfile ;
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Search apps or items...']")
	     
	 WebElement search;
	
	@FindBy(how = How.XPATH, using = "//html/body/div[5]/div[2]/div/div[2]/div/div[2]/div[2]/div/div[2]/ul/li[3]/a")
	
	WebElement clickAccounts;
	
	@FindBy(how = How.XPATH, using = "//input[@id='phSearchInput']")

	public WebElement txtbox_SearchUser;
	
	@FindBy(how = How.XPATH, using = "//a/span[@class='userMru']")

	public WebElement link_userMenu;
	
	@FindBy(how = How.XPATH, using = "//a[@title='User Action Menu']")

	public WebElement link_UserActionMenu;
	
	@FindBy(how = How.XPATH, using = "//a[@title='User Detail']")

	public WebElement link_UserDetail;

	@FindBy(how = How.XPATH, using = "//*[@id='topButtonRow']/input[4]")

	public WebElement btn_Login;
	
	public void getManagerProfAndSearchText() throws InterruptedException {
		
		String prof=managerProfile.getText();
		txtbox_SearchUser.sendKeys(prof);
		Thread.sleep(2000);
		link_userMenu.click();
		Thread.sleep(5000);
		link_UserActionMenu.click();
		link_UserDetail.click();
		Thread.sleep(2000);
		btn_Login.click();
		Thread.sleep(6000);
		
	}
	 
}
