package com.BSC.framework.pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.BSC.framework.DriverScript;
import com.BSC.framework.utilities.Constants;
import com.BSC.framework.utilities.Log;

public class SalesforceLogin {
	final WebDriver driver;
	@FindBy(how = How.ID, using = "username")

	public WebElement txtbox_SFDCUser;

	@FindBy(how = How.ID, using = "password")

	public WebElement txtbox_SFDCPasswrd;

//input[@type='submit']

	@FindBy(how = How.XPATH, using = "//input[@type='submit']")

	public WebElement btn_SFDCLogin;

	public SalesforceLogin(WebDriver driver) {

		this.driver = driver;

	}

	public static void navigateToURL() {
		try {
			Log.info("Navigating to URL");

			// DriverScript.driver.get("https://test.salesforce.com");
			DriverScript.driver.get("https://www.google.com");
			DriverScript.driver.manage().window().maximize();
			DriverScript.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		} catch (Exception e) {
			Log.info("Not able to navigate --- " + e.getMessage());

		}
	}

	public static void navigateToURLGeneric(WebDriver driver) {
		try {
			Log.info("Navigating to URL");
			driver.get("https://test.salesforce.com");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
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
		} catch (Exception e) {
			e.printStackTrace();
			DriverScript.bResult = false;
		}

	}

}
