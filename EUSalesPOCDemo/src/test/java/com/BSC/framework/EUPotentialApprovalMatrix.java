package com.BSC.framework;

import java.io.File;
import java.lang.reflect.Method;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.testng.annotations.Test;
//import org.junit.Test;

import com.BSC.framework.action.WebDriverActionKeywordsGeneric;
import com.BSC.framework.manager.BrowserManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class EUPotentialApprovalMatrix extends WebDriverActionKeywordsGeneric {

	public static Method method[];
	public static String TCName;
	static ExtentTest test;
	static ExtentReports report;
	public static boolean bResult = true;
	public static boolean flag;

	@BeforeClass
	public static void startTest() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		setup();
		report = new ExtentReports("C:\\Users\\aniruddha.majumdar\\BSC\\BSCAutomation\\ExtentReportResults.html");
		test = report.startTest("Automation-DemoNew");
		report.loadConfig(new File("C:\\Users\\aniruddha.majumdar\\BSC\\BSCAutomation\\extent-config.xml"));

	}

	// Login to Salesforce
	@Test(priority = 0)
	public void loginSalesforce() throws Exception {
		Thread.sleep(8000);

		try {
			WebDriverActionKeywordsGeneric.LoginAsParameter(driver);
			test.log(LogStatus.PASS, "Test Case Passed:" + "Salesforce login Process");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Test Case Failed:" + "Salesforce login Process");

		}
	}

	@Test(dependsOnMethods = "loginSalesforce", alwaysRun = true)
	public void searchAndSelect() throws Exception {

		try {
			WebDriverActionKeywordsGeneric.searchTextInAppLauncher(driver);
			WebDriverActionKeywordsGeneric.selectAccountAndAccountPerformance(driver);
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Test Case Failed:" + "Account and Account Performance Selecting Failed");
		}

	}

	@Test(dependsOnMethods = "searchAndSelect", alwaysRun = true)
	public void switchAndClickPotential() throws Exception {

		try {
			WebDriverActionKeywordsGeneric.clickPotentialInAccountPerf(driver);
			WebDriverActionKeywordsGeneric.setQuantityProposed(driver);
			WebDriverActionKeywordsGeneric.checkValidation(driver);

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Test Case Failed:" + "Clicking Potential button Failed");
		}

	}
/*
	@Test(dependsOnMethods = "switchAndClickPotential", alwaysRun = true)
	public void reLoginSalesforce() throws Exception {

		try {
			setup();
			Thread.sleep(8000);
			WebDriverActionKeywordsGeneric.reLoginAsParameter(driver);
			test.log(LogStatus.PASS, "Test Case Passed:" + "Salesforce login Process");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Test Case Failed:" + "Salesforce login Process");

		}
	}

	@Test(dependsOnMethods = "reLoginSalesforce", alwaysRun = true)
	public void getUrlPreviousInstance() throws Exception {
		try {
			WebDriverActionKeywordsGeneric.getUrlAfterReLogin(driver);
			test.log(LogStatus.PASS, "Test Case Passed:" + "Salesforce login Process");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Test Case Failed:" + "Salesforce login Process");

		}
	}

	@Test(dependsOnMethods = "getUrlPreviousInstance", alwaysRun = true)
	public void changePotentialAndSave() throws Exception {
		try {
			WebDriverActionKeywordsGeneric.changeQuantityFieldInPotential(driver);
			;
			test.log(LogStatus.PASS, "Test Case Passed:" + "Salesforce login Process");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Test Case Failed:" + "Salesforce login Process");

		}
	}

	@Test(dependsOnMethods = "changePotentialAndSave", alwaysRun = true)
	public void logOutAndSearchUser() throws Exception {
		try {
			WebDriverActionKeywordsGeneric.logOutAndLoginAsUser(driver);
			;
			test.log(LogStatus.PASS, "Test Case Passed:" + "Salesforce login Process");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Test Case Failed:" + "Salesforce login Process");

		}
	}

	@Test(dependsOnMethods = "logOutAndSearchUser", alwaysRun = true)
	public void navigateToPotentialPageAndCheck() throws Exception {
		try {
			WebDriverActionKeywordsGeneric.searchTextInAppLauncher(driver);
			WebDriverActionKeywordsGeneric.selectAccountAndAccountPerformance(driver);
			WebDriverActionKeywordsGeneric.clickPotentialInAccountPerf(driver);
			WebDriverActionKeywordsGeneric.checkValidation(driver);
			test.log(LogStatus.PASS, "Test Case Passed:" + "Salesforce login Process");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Test Case Failed:" + "Salesforce login Process");

		}
	}
*/	
	@Test(dependsOnMethods = "switchAndClickPotential", alwaysRun = true)
	public void logOutAndLoginAsAdmin() throws Exception {
		try {
			WebDriverActionKeywordsGeneric.logOut(driver);
			WebDriverActionKeywordsGeneric.getManagerNameAndLogin(driver);
			test.log(LogStatus.PASS, "Test Case Passed:" + "Salesforce login Process");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Test Case Failed:" + "Salesforce login Process");

		}
	}
	@Test(dependsOnMethods = "logOutAndLoginAsAdmin", alwaysRun = true)
	public void searchPotentialsAndApprove() throws Exception {
		try {
			WebDriverActionKeywordsGeneric.searchPotentialinAppLauncher(driver);
			WebDriverActionKeywordsGeneric.approvePotentials(driver);
			WebDriverActionKeywordsGeneric.logOut(driver);
			test.log(LogStatus.PASS, "Test Case Passed:" + "Salesforce login Process");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Test Case Failed:" + "Salesforce login Process");

		}
	}

	@AfterClass
	public static void endTest() {
		BrowserManager.closeAllDriver();
		report.endTest(test);
		report.flush();

	}

}
