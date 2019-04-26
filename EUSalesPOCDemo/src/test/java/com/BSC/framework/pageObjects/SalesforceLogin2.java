package com.BSC.framework.pageObjects;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.BSC.framework.DriverScript;
import com.BSC.framework.action.BaseTest;
import com.BSC.framework.utilities.Constants;
import com.BSC.framework.utilities.Log;

public class SalesforceLogin2 extends BaseTest {

	public SalesforceLogin2(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "username")

	public WebElement txtbox_SFDCUser;

	@FindBy(how = How.ID, using = "password")

	public WebElement txtbox_SFDCPasswrd;

	@FindBy(how = How.XPATH, using = "//span[@class='userProfileCardTriggerRoot oneUserProfileCardTrigger']")

	public WebElement image_ProfileIcon;

	@FindBy(how = How.XPATH, using = "//header[@id='oneHeader']/div[1]/div/a")

	public WebElement image_ProfileIconNew;

	@FindBy(how = How.XPATH, using = "//div[1]/div[1]/div/div[2]/div/a[2]")

	public WebElement logOut_Icon;

	@FindBy(how = How.XPATH, using = "//a[@class='profile-link-label switch-to-aloha uiOutputURL']")

	public WebElement link_switchToClassic;

	@FindBy(how = How.XPATH, using = "(//a[contains(text(),'Switch to')])[2]")

	public WebElement check_classicOrLightining;

	@FindBy(how = How.XPATH, using = "//input[@id='phSearchInput']")

	public WebElement txtbox_SearchUser;

	@FindBy(how = How.XPATH, using = "//input[@ title='Search Salesforce']")

	public WebElement txtbox_SearchUser_Lightning;

	@FindBy(how = How.XPATH, using = "//a/span[@class='userMru']")

	public WebElement link_userMenu;

	@FindBy(how = How.XPATH, using = "//a[@title='User Action Menu']")

	public WebElement link_UserActionMenu;

	@FindBy(how = How.XPATH, using = "//a[@title='User Detail']")

	public WebElement link_UserDetail;

	@FindBy(how = How.XPATH, using = "//*[@id='topButtonRow']/input[4]")

	public WebElement btn_Login;

	@FindBy(how = How.XPATH, using = "//input[@type='submit']")

	public WebElement btn_SFDCLogin;

	@FindBy(how = How.XPATH, using = "//div/div[3]/div/a[@class='switch-to-lightning']")

	public WebElement btn_switchToSalesforceLightning;

	@FindBy(how = How.XPATH, using = "(//a[text()='Eamonn Hannon'])[2]")

	public WebElement clickUser;
	
	@FindBy(how = How.XPATH, using = "(//iframe)[1]")

	WebElement accountPreferenceInfoFrame;

	public static void navigateToURL() {
		try {
			Log.info("Navigating to URL");

			DriverScript.driver.get("https://test.salesforce.com");
			DriverScript.driver.manage().window().maximize();
			DriverScript.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		} catch (Exception e) {
			Log.info("Not able to navigate --- " + e.getMessage());

		}
	}

	/// Login to Salesforce
	public void loginSalesforce(String user, String password) throws InterruptedException {
		try {

			txtbox_SFDCUser.sendKeys(user);
			txtbox_SFDCPasswrd.sendKeys(password);
			btn_SFDCLogin.click();
			System.out.println("Login to Salesforce is successful for user:" + user);
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
			DriverScript.bResult = false;
		}

	}

	// Search user
	public void searchUser() throws InterruptedException {
		try {
			boolean checkText;
			System.out.println(checkText = check_classicOrLightining.getText() != null);

			if (checkText = check_classicOrLightining.getText() != null)

			{
				txtbox_SearchUser.sendKeys(Constants.userProfile);
				Thread.sleep(2000);
				link_userMenu.click();
				Thread.sleep(5000);
				link_UserActionMenu.click();
				link_UserDetail.click();
				Thread.sleep(2000);
				btn_Login.click();
			} else {
				System.out.println("Switch to Classic ");
				Thread.sleep(9000);
				image_ProfileIcon.click();
				link_switchToClassic.click();
				Thread.sleep(5000);
				txtbox_SearchUser.sendKeys(Constants.userProfile);
				Thread.sleep(2000);
				link_userMenu.click();
				Thread.sleep(5000);
				link_UserActionMenu.click();
				link_UserDetail.click();
				Thread.sleep(2000);
				btn_Login.click();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void switchToLightning() throws InterruptedException {
		try {
			boolean checkText;
			System.out.println(checkText = check_classicOrLightining.getText() != null);

			if (checkText = check_classicOrLightining.getText() != null)

			{
				txtbox_SearchUser.sendKeys(Constants.userProfileEU);
				Thread.sleep(2000);
				link_userMenu.click();
				Thread.sleep(5000);
				link_UserActionMenu.click();
				link_UserDetail.click();
				Thread.sleep(2000);
				btn_Login.click();

			} else {
				System.out.println("Switch to Classic ");
				Thread.sleep(9000);
				image_ProfileIcon.click();
				link_switchToClassic.click();
				Thread.sleep(5000);
				txtbox_SearchUser.sendKeys(Constants.userProfileEU);
				Thread.sleep(2000);
				link_userMenu.click();
				Thread.sleep(5000);
				link_UserActionMenu.click();
				link_UserDetail.click();
				Thread.sleep(2000);
				btn_Login.click();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void logOutSalesForce() throws InterruptedException {
		try {

			image_ProfileIcon.click();
			logOut_Icon.click();
			System.out.println("Logout to Salesforce is successful for user");
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
			DriverScript.bResult = false;
		}

	}

	public void searchUserAdmin() throws InterruptedException {
		try {
			String checkText = null;
			checkText = check_classicOrLightining.getText();
			if (checkText.equalsIgnoreCase("Switch to Lightning Experience")) {
				txtbox_SearchUser.sendKeys(Constants.userProfileAdmin);
				Thread.sleep(2000);
				link_userMenu.click();
				Thread.sleep(5000);
				link_UserActionMenu.click();
				link_UserDetail.click();
				Thread.sleep(2000);
				btn_Login.click();
			} else {
				System.out.println("Switch to Classic ");
				Thread.sleep(9000);
				image_ProfileIcon.click();
				link_switchToClassic.click();
				Thread.sleep(5000);
				txtbox_SearchUser.sendKeys(Constants.userProfileAdmin);
				Thread.sleep(2000);
				link_userMenu.click();
				Thread.sleep(5000);
				link_UserActionMenu.click();
				link_UserDetail.click();
				Thread.sleep(2000);
				btn_Login.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
