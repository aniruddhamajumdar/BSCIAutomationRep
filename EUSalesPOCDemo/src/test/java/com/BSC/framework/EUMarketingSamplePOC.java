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

public class EUMarketingSamplePOC extends WebDriverActionKeywordsGeneric {

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
			WebDriverActionKeywordsGeneric.LoginAndSwitchToLightning(driver);
			test.log(LogStatus.PASS, "Test Case Passed:" + "Salesforce login Process");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Test Case Failed:" + "Salesforce login Process");

		}
	}

	@Test(dependsOnMethods = "loginSalesforce", alwaysRun = true)
	public void searchAndSelect() throws Exception {

		try {
			WebDriverActionKeywordsGeneric.searchContactInAppLauncher(driver);
			WebDriverActionKeywordsGeneric.createNewContact(driver);
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Test Case Failed:" + "Creating New Contact has been failed.");
		}

	}

	
	/*
	@Test(dependsOnMethods = "searchAndSelect", alwaysRun = true)
	public void logOutAndLoginAsAdmin() throws Exception {
		try {
			WebDriverActionKeywordsGeneric.logOut(driver);
			WebDriverActionKeywordsGeneric.getManagerNameAndLogin(driver);
			test.log(LogStatus.PASS, "Test Case Passed:" + "Salesforce login Process");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Test Case Failed:" + "Salesforce login Process");

		}
	}
	*/
	@Test(dependsOnMethods = "searchAndSelect", alwaysRun = true)
	public void searchPotentialsAndApprove() throws Exception {
		try {
			
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
