package com.BSC.framework;

import java.io.File;
import java.lang.reflect.Method;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.testng.annotations.Test;
//import org.junit.Test;

import com.BSC.framework.action.WebDriverActionKeywords;
import com.BSC.framework.manager.BrowserManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DriverScript {
	public static WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;

	public static Method method[];
	public static String TCName;
	// public WebDriverActionKeywords actionKeywords=new WebDriverActionKeywords();
	// actionKeywords = new WebDriverActionKeywords();
	static ExtentTest test;
	static ExtentReports report;
	public static boolean bResult = true;
	public static boolean flag;

	@BeforeClass
	public static void startTest() {
		DOMConfigurator.configure("log4j.xml");
		driver = BrowserManager.getBrowser("Chrome");
		System.out.println("Launching Chrome Browser");
		report = new ExtentReports("C:\\Users\\aniruddha.majumdar\\BSC\\BSCAutomation\\ExtentReportResults.html");
		test = report.startTest("Automation-Demo");
		report.loadConfig(new File("C:\\Users\\aniruddha.majumdar\\BSC\\BSCAutomation\\extent-config.xml"));
	}

	/// Payload process through WORKBENCH
	@Test(priority = 0)
	public void workbenchPayload() throws Exception {
		try {
			WebDriverActionKeywords.payloadProcess();
			test.log(LogStatus.PASS, "Test Case Passed:" + "WorkBench Payload Process");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Test Case Failed:" + "WorkBench Payload Process");
			
		}
	}
	

	// UserID Verification in UI
	@Test(priority = 1,enabled=false)
	public void verifyUserUI() throws Exception {
		Thread.sleep(4000);
		String expected_user = null;
		/*
		try {
			String userID = WebDriverActionKeywords.payloadUser();
			SalesforceLogin.navigateToURL();
			expected_user = WebDriverActionKeywords.launchURLwithUserID(userID);
			WebDriverActionKeywords.validateUser(expected_user);
			test.log(LogStatus.PASS, "Test Case Passed:" + "UserName" + expected_user
					+ " validated succesfully in CycleCount Details page");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Test Case Failed:" + "UserName" + expected_user
					+ " not validated succesfully in CycleCount Details page");
		}
*/
	}

	// VARIANCE REPORT VALIDATIONS
	// VALIDATE ERROR MSG ON ONLY SUBMIT
	@Test(dependsOnMethods="workbenchPayload",alwaysRun=true)
	public void VR_SalesUser_OnlySubmit() throws Exception {
		Thread.sleep(8000);
		String actual_errormsg = null;
		try {
			actual_errormsg = WebDriverActionKeywords.VROnlySubmit();
			String expected_errormsg = "All lines must have a reconciliation action selected prior to submitting";
			Assert.assertEquals(expected_errormsg, actual_errormsg);
			//Assert.assertTrue(caseDetailsPage.getCaseTaskStatusByTaskName(driver, wait, "Approve Employment Info Change").contains("Approve"));
			test.log(LogStatus.PASS, "Test Case Passed:" + "Error message in VARIANCE REPORT:" + actual_errormsg
					+ "validated succesfully");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					"Test Case Failed:" + "Error message in VARIANCE REPORT:" + actual_errormsg + " not validated");
		}

	}
	//VARIANCE REPORT VALIDATIONS
		// Validate Error message on RECONCILE ACTION AS OTHER AND SUBMIT
		@Test(dependsOnMethods="VR_SalesUser_OnlySubmit",alwaysRun=true)
		public void VR_SalesUser_OtherActionSubmit() throws Exception {
			Thread.sleep(8000);
			String actual_errormsg = null;
			try {
				String expected_error_msg = "Comments are required when Reconcile Action is selected as Other";
				actual_errormsg = WebDriverActionKeywords.VROtherActionSubmit();
				Assert.assertEquals(expected_error_msg, actual_errormsg);

				test.log(LogStatus.PASS, "Test Case Passed:" + "Error message in VARIANCE REPORT:" + actual_errormsg
						+ "validated succesfully");
			} catch (Exception e) {
				test.log(LogStatus.FAIL,
						"Test Case Failed:" + "Error message in VARIANCE REPORT:" + actual_errormsg + " not validated");
			}

		}
		
//VARIANCE REPORT VALIDATIONS
	// Validate Error message on select All items and SUBMIT
		@Test(dependsOnMethods="VR_SalesUser_OtherActionSubmit",alwaysRun=true)
	public void VR_CheckAllSubmit() throws Exception {
		Thread.sleep(8000);
		String actual_errormsg = null;
		try {
			//String expected_error_msg = "All items must be reconciled before submission.";
		 WebDriverActionKeywords.VRCheckAllSubmit();
			//Assert.assertEquals(expected_error_msg, actual_errormsg);
			test.log(LogStatus.PASS, "Test Case Passed:" + " VARIANCE REPORT RECONCILED" );
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					"Test Case Failed:" + "VARIANCE REPORT CANT BE RECONCILED");
		}

	}


	//VARIANCE REPORT VALIDATIONS
			// CHANGE STATUS FUNCTIONALITY
		@Test(dependsOnMethods="VR_CheckAllSubmit",alwaysRun=true)
	public void VRSalesUserChangeStatus() throws Exception{
		// String actual_status = null;
		 Thread.sleep(8000);
		 
			try {
				//String expected_status = "Reconciled";
		         WebDriverActionKeywords.VR_SalesUser_ChangeStatus();
				//Assert.assertEquals(expected_status, actual_status);

				test.log(LogStatus.PASS, "Test Case Passed:" + "Change Status disabled for Sales User");
			} catch (Exception e) {
				test.log(LogStatus.FAIL, "Test Case Failed:" + "Change Status enabled for Sales User");
			}
	 }
	//VARIANCE REPORT VALIDATIONS
		// CHECK STATUS FOR USER WITH APPRVR PERMISSION SET
		@Test(priority =6,enabled=false)
		public void VR_SalesUser_CheckStatus() throws Exception {

			String actual_status = null;
			try {
				String expected_status = "Reconciled";
				actual_status = WebDriverActionKeywords.VRCheckStatus();
				Assert.assertEquals(expected_status, actual_status);

				test.log(LogStatus.PASS, "Test Case Passed:" + actual_status + "validated succesfully");
			} catch (Exception e) {
				test.log(LogStatus.FAIL, "Test Case Failed:" + actual_status + " not validated");
			}

		}



		@Test(dependsOnMethods="VRSalesUserChangeStatus",alwaysRun=true)
	public void VR_LogOutSalesUser() throws Exception {
		Thread.sleep(8000);
		try {
			WebDriverActionKeywords.LogOut();
			test.log(LogStatus.PASS,
					"Test Case Passed:" + "LOGGING OUT AS SALES USER");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Test Case Failed:" + "SALES USER STILL LOGGED IN ");
		}

	}

	//Log Out as sales user
		@Test(dependsOnMethods="VR_LogOutSalesUser",alwaysRun=true)
	public void VR_App_ReconcileFlag() throws Exception {
		Thread.sleep(8000);
		try {
			WebDriverActionKeywords.VRReconcileFlag();
			test.log(LogStatus.PASS,
					"Test Case Passed:" + "RECONCILE FLAG SELECTED FOR ALL RECORDS AND SUBMITTED SUCCESSFULLY");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Test Case Failed:" + "RECONCILE FLAG NOT SELECTED FOR ALL RECORDS");
		}

	}
//VARIANCE REPORT VALIDATIONS
	// CHECK STATUS AFTER SELECTING RECONCILE FLAG
	@Test(priority = 9,enabled=false)
	public void VR_App_CheckStatus() throws Exception {
		Thread.sleep(5000);
		String actual_status = null;
		try {
			String expected_status = "Complete";
			actual_status = WebDriverActionKeywords.VRCheckStatus();
			Assert.assertEquals(expected_status, actual_status);

			test.log(LogStatus.PASS, "Test Case Passed:" + "Error message in VARIANCE REPORT:" + actual_status
					+ "validated succesfully");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					"Test Case Failed:" + "Error message in VARIANCE REPORT:" + actual_status + " not validated");
		}

	}




	
	@AfterClass
	public static void endTest() {
		BrowserManager.closeAllDriver();
		report.endTest(test);
		report.flush();

	}

}
