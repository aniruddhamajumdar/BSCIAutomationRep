package com.BSC.framework.action;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.json.JsonException;
import org.openqa.selenium.support.PageFactory;

import com.BSC.framework.pageObjects.AccountPerformanceDetailPage;
import com.BSC.framework.pageObjects.AccountsPage;
import com.BSC.framework.pageObjects.AppLauncher;
import com.BSC.framework.pageObjects.ContactsPage;
import com.BSC.framework.pageObjects.LoginAs2;
import com.BSC.framework.pageObjects.PotentialDetailsPage;
import com.BSC.framework.pageObjects.SalesforceLogin;
import com.BSC.framework.pageObjects.SalesforceLogin2;
import com.BSC.framework.pageObjects.UserDetailsPage;
import com.BSC.framework.utilities.Constants;

public class WebDriverActionKeywordsGeneric extends BaseTest {
	static SalesforceLogin2 login2 = new SalesforceLogin2(driver);
	static AppLauncher appLauncher = new AppLauncher(driver);
	static AccountsPage accountsPage = new AccountsPage(driver);
	static ContactsPage contactPage = new ContactsPage(driver);
	static AccountPerformanceDetailPage accountPerformanceDetailPage = new AccountPerformanceDetailPage(driver);
	static PotentialDetailsPage potentialDetailsPage = new PotentialDetailsPage(driver);
	static UserDetailsPage userDetailsPage = new UserDetailsPage(driver);

	public static SalesforceLogin SFDC_Login = PageFactory.initElements(driver, SalesforceLogin.class);
	public static LoginAs2 loginAs_User = PageFactory.initElements(driver, LoginAs2.class);
	 JavascriptExecutor js = (JavascriptExecutor) driver;


	static String json = "...";
	static String url;
	static String actualText;
	static String potentialNumber;

	public static void LoginAsParameter(WebDriver driver) throws Exception {
		try {
			login2 = new SalesforceLogin2(driver);
			Thread.sleep(5000);
			System.out.println("Navigate to Salesforce Home Page");
			// SalesforceLogin.navigateToURLGeneric(driver);
			login2.loginSalesforce(Constants.BSC_AppUser, Constants.BSC_AppPassword);
			login2.searchUser();

			Thread.sleep(4000);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void LoginAndSwitchToLightning(WebDriver driver) throws Exception {
		try {
			login2 = new SalesforceLogin2(driver);
			Thread.sleep(5000);
			System.out.println("Navigate to Salesforce Home Page");
			// SalesforceLogin.navigateToURLGeneric(driver);
			login2.loginSalesforce(Constants.BSC_AppUser, Constants.BSC_AppPassword);
			login2.switchToLightning();
			Thread.sleep(4000);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void reLoginAsParameter(WebDriver driver) {

		try {

			login2 = new SalesforceLogin2(driver);
			Thread.sleep(5000);
			System.out.println("Navigate to Salesforce Home Page");
			// SalesforceLogin.navigateToURLGeneric(driver);
			login2.loginSalesforce(Constants.BSC_AppUser, Constants.BSC_AppPassword);
			login2.searchUserAdmin();
			Thread.sleep(4000);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void searchTextInAppLauncher(WebDriver driver) throws Exception {
		try {
			appLauncher = new AppLauncher(driver);
			Thread.sleep(10000);
			System.out.println("Searching required Text in App Launcher");
			appLauncher.clickAndSearchText();
			System.out.println("Searching required Text in App Launcher done successfully");
			Thread.sleep(4000);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void searchContactInAppLauncher(WebDriver driver) throws Exception {
		try {
			appLauncher = new AppLauncher(driver);
			Thread.sleep(10000);
			System.out.println("Searching required Text in App Launcher");
			appLauncher.clickAndSearchContacts();
			System.out.println("Searching required Text in App Launcher done successfully");
			Thread.sleep(4000);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void selectAccountAndAccountPerformance(WebDriver driver) throws Exception {
		try {
			accountsPage = new AccountsPage(driver);
			Thread.sleep(5000);
			System.out.println("Searching Account Name in Accounts Page");
			accountsPage.clickAccountandAccountPerf();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1900)");
			Thread.sleep(4000);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void createNewContact(WebDriver driver) throws Exception {
		try {
			System.out.println("Creating New Contact");
			contactPage = new ContactsPage(driver);
			Thread.sleep(5000);
			System.out.println("Searching Account Name in Accounts Page");
			contactPage.createNewContact();
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void changeQuantityFieldInPotential(WebDriver driver) throws Exception {
		try {
			potentialDetailsPage = new PotentialDetailsPage(driver);
			Thread.sleep(5000);
			System.out.println("Changing Quantity Proposed Field");
			potentialDetailsPage.changeQuantityProposed();
			Thread.sleep(6000);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void clickPotentialInAccountPerf(WebDriver driver) throws Exception {
		try {
			accountPerformanceDetailPage = new AccountPerformanceDetailPage(driver);
			Thread.sleep(5000);
			System.out.println("Clicking Potential in Account Performance");
			accountPerformanceDetailPage.switchToAccountPrefPageAndClickPotential();
			Thread.sleep(6000);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void setQuantityProposed(WebDriver driver) throws Exception {
		try {
			accountPerformanceDetailPage = new AccountPerformanceDetailPage(driver);
			Thread.sleep(5000);
			System.out.println("setting the Url");
			ArrayList tabs = new ArrayList(driver.getWindowHandles());
			driver.switchTo().window((String) tabs.get(1));
			potentialDetailsPage = new PotentialDetailsPage(driver);
			Thread.sleep(5000);
			System.out.println("Changing Quantity Proposed Field");
			potentialDetailsPage.changeQuantityProposed();
			Thread.sleep(6000);
			
/*
			url = accountPerformanceDetailPage.copyUrlLink();
			System.out.println(url);
			Thread.sleep(5000);
			driver.quit();
*/
			
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void getUrlAfterReLogin(WebDriver driver) throws Exception {
		try {
			System.out.println(url);
			driver.navigate().to(url);
			Thread.sleep(20000);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void logOutAndLoginAsUser(WebDriver driver) throws Exception {
		try {
			login2 = new SalesforceLogin2(driver);
			Thread.sleep(5000);
			login2.logOutSalesForce();
			login2.searchUser();
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void logOut(WebDriver driver) throws Exception {
		try {
			login2 = new SalesforceLogin2(driver);
			Thread.sleep(5000);
			login2.logOutSalesForce();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void checkValidation(WebDriver driver) throws Exception {
		try {
			potentialDetailsPage = new PotentialDetailsPage(driver);
			Thread.sleep(5000);
			//ArrayList tabs = new ArrayList(driver.getWindowHandles());
			//driver.switchTo().window((String) tabs.get(1));
			//System.out.println("Validating Approval Status");
			//actualText = potentialDetailsPage.validationCheck();
			//System.out.println("bbbbbb"+ actualText);
			potentialNumber = potentialDetailsPage.setpotentialNumber();
			//assertEquals(actualText, "Pending Approval");
			Thread.sleep(6000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void getManagerNameAndLogin(WebDriver driver) throws Exception {
		try {
			userDetailsPage = new UserDetailsPage(driver);
			Thread.sleep(5000);
			System.out.println("getting MAnager profile and Logging in to get it approved");
			userDetailsPage.getManagerProfAndSearchText();
			Thread.sleep(6000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void searchPotentialinAppLauncher(WebDriver driver) throws Exception {
		try {
			appLauncher = new AppLauncher(driver);
			Thread.sleep(10000);
			System.out.println("Searching required Text in App Launcher");
			appLauncher.clickAndSearchPotential(potentialNumber);
			System.out.println("Searching required Text in App Launcher done successfully");
			Thread.sleep(4000);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void approvePotentials(WebDriver driver) throws Exception {
		try {
			potentialDetailsPage = new PotentialDetailsPage(driver);
			Thread.sleep(5000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,800)");
			potentialDetailsPage.EditApprovalStatus();
			System.out.println("Searching required Text in App Launcher done successfully");
			Thread.sleep(4000);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
