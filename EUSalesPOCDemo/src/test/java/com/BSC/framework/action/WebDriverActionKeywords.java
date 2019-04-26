package com.BSC.framework.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.json.JsonException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.BSC.framework.DriverScript;
import com.BSC.framework.pageObjects.AppLauncher;
import com.BSC.framework.pageObjects.CycleCountDetails;
import com.BSC.framework.pageObjects.LoginAs2;
import com.BSC.framework.pageObjects.NavigateMenu;
import com.BSC.framework.pageObjects.SalesforceLogin;
import com.BSC.framework.pageObjects.VarianceReport;
import com.BSC.framework.pageObjects.VerifyUser;
import com.BSC.framework.pageObjects.WorkBench;
import com.BSC.framework.utilities.Constants;

public class WebDriverActionKeywords {

	public static WorkBench workbench = PageFactory.initElements(DriverScript.driver, WorkBench.class);
	public static AppLauncher applaunch = PageFactory.initElements(DriverScript.driver, AppLauncher.class);

	public static NavigateMenu nav_menu = PageFactory.initElements(DriverScript.driver, NavigateMenu.class);
	public static VarianceReport var_rprt = PageFactory.initElements(DriverScript.driver, VarianceReport.class);
	public static VerifyUser verify_user = PageFactory.initElements(DriverScript.driver, VerifyUser.class);
	public static CycleCountDetails CC_details = PageFactory.initElements(DriverScript.driver, CycleCountDetails.class);

	public static SalesforceLogin SFDC_Login = PageFactory.initElements(DriverScript.driver, SalesforceLogin.class);
	public static LoginAs2 loginAs_User = PageFactory.initElements(DriverScript.driver, LoginAs2.class);

	public static WebDriverActionKeywords actions = PageFactory.initElements(DriverScript.driver,
			WebDriverActionKeywords.class);
	static String json = "...";

	/// Process payload through WorkBench
	public static void payloadProcess() throws InterruptedException {
		try {
			workbench.navigateToURL();
			System.out.println("Select environment details in WorkBench");
			Select environment = new Select(workbench.dropdown_Env);
			environment.selectByValue("test.salesforce.com");
			Thread.sleep(7000);
			System.out.println("Select Terms and conditions checkbox");
			workbench.checkbox_TermsConditions.click();
			System.out.println("Login to Salesforce");
			workbench.btn_LoginToSFDC.click();
			SFDC_Login.loginSalesforce(Constants.BSC_AppUser, Constants.BSC_AppPassword);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Select Utilities menu");
			workbench.link_utilities.click();
			System.out.println("Select RestExplorer menu list");
			workbench.link_RESTExpl.click();
			System.out.println("Select radio button POST");
			workbench.radio_POST.click();
			System.out.println("Enter request header");
			workbench.txt_HeaderPath.clear();
			workbench.txt_HeaderPath.sendKeys("/services/apexrest/v1/CycleCountPath");
			enterRequestBody();
			System.out.println("Click Execute button");
			workbench.btn_execute.click();
		} catch (Exception e) {
			e.printStackTrace();
			DriverScript.bResult = false;
		}

	}

	/// Enter payload file content into RequestBody
	public static void enterRequestBody() {
		System.out.println("Set payload file location");
		BufferedReader br = null;

		try {
			File file = new File(Constants.Payload_filepath);

			br = new BufferedReader(new FileReader(Constants.Payload_filepath));
			System.out.println("Wait for the RequestBody section to be clickable");

			WebDriverWait wait = new WebDriverWait(DriverScript.driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(workbench.txtarea_requestBody));

			String newline = null;

			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println("Enter payload file contents into RequestBody section");

				System.out.println(line);
				newline = line + "\n";

				// script= String.format("arguments[0].value='%s';", line);
				workbench.txtarea_requestBody.sendKeys(newline);
				newline = line + "\n";

			}
		} catch (IOException ex) {
			System.out.println("Problem occured in reading payloadfile : " + ex.getMessage());
			DriverScript.bResult = false;
		}

		finally {
			try {
				// need to check for null
				if (br != null) {
					br.close();
				}
			} catch (IOException ex) {
				System.out.println("Problem occured. Cannot close reader : " + ex.getMessage());
			}
		}
	}

	/// Read payload file to get userid value
	// READ JSON PAYLOAD FILE
	/*
	 * public static String payloadUser() throws JsonException { String
	 * expected_user = null; JSONParser parser = new JSONParser();
	 * System.out.println("Read the JSON Payload file"); try {
	 * 
	 * Object obj = parser.parse(new
	 * FileReader("C:\\Users\\ipsita.a.roy\\Desktop\\payloadnew.txt"));
	 * 
	 * JSONObject jsonObject = (JSONObject) obj;
	 * 
	 * // String name = (String) jsonObject.get("soldTo"); expected_user = (String)
	 * jsonObject.get("userId"); // String product = (String)
	 * jsonObject.get("pHierarchy"); // JSONArray companyList = (JSONArray)
	 * jsonObject.get("Company List");
	 * 
	 * // System.out.println("Name: " + name); System.out.println("USER ID: " +
	 * expected_user); // System.out.println("PRODUCT: " + product);
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } return expected_user;
	 * 
	 * }
	 */
	public static void LoginAsParameter(WebDriver driver) throws Exception {
		try {
			Thread.sleep(5000);
			System.out.println("Navigate to Salesforce Home Page");
			//SalesforceLogin.navigateToURLGeneric(driver);
			System.out.println(driver);
			SFDC_Login.loginSalesforce(Constants.BSC_AppUser, Constants.BSC_AppPassword);
			System.out.println("Switch to Classic ");
			Thread.sleep(9000);
			loginAs_User.image_ProfileIcon.click();
			loginAs_User.link_switchToClassic.click();
			Thread.sleep(5000);
			loginAs_User.txtbox_SearchUser.sendKeys("rfid gfim");
			;
			// loginAs_User.txtbox_SearchUser.sendKeys("RFID Sales Rep/Approver");;
			Thread.sleep(2000);
			loginAs_User.link_userMenu.click();
			Thread.sleep(5000);

			loginAs_User.link_UserActionMenu.click();
			loginAs_User.link_UserDetail.click();

			loginAs_User.btn_Login.click();
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void LoginAs() throws Exception {
		try {
			Thread.sleep(5000);
			System.out.println("Navigate to Salesforce Home Page");
			SalesforceLogin.navigateToURL();
			SFDC_Login.loginSalesforce(Constants.BSC_AppUser, Constants.BSC_AppPassword);
			System.out.println("Switch to Classic ");
			Thread.sleep(9000);
			loginAs_User.image_ProfileIcon.click();
			loginAs_User.link_switchToClassic.click();
			Thread.sleep(5000);
			loginAs_User.txtbox_SearchUser.sendKeys("rfid gfim");
			;
			// loginAs_User.txtbox_SearchUser.sendKeys("RFID Sales Rep/Approver");;
			Thread.sleep(2000);
			loginAs_User.link_userMenu.click();
			Thread.sleep(5000);

			loginAs_User.link_UserActionMenu.click();
			loginAs_User.link_UserDetail.click();

			loginAs_User.btn_Login.click();
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void LoginAsApprover() throws Exception {
		try {
			Thread.sleep(5000);
			System.out.println("Navigate to Salesforce Home Page");
			SalesforceLogin.navigateToURL();
			SFDC_Login.loginSalesforce(Constants.BSC_AppUser, Constants.BSC_AppPassword);
			System.out.println("Switch to Classic ");
			Thread.sleep(9000);
			loginAs_User.image_ProfileIcon.click();
			loginAs_User.link_switchToClassic.click();
			Thread.sleep(5000);
			loginAs_User.txtbox_SearchUser.sendKeys("RFID Sales Rep/Approver");
			;
			Thread.sleep(2000);
			loginAs_User.link_userMenu.click();
			Thread.sleep(5000);

			loginAs_User.link_UserActionMenu.click();
			loginAs_User.link_UserDetail.click();

			loginAs_User.btn_Login.click();
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/// RETRIEVE USER NAME FROM UI BASED ON PAYLOAD USER ID
	// Parameters: user id from payload
	// RETRIEVE USER NAME FROM UI BASED ON PAYLOAD USERID
	public static String launchURLwithUserID(String userID) throws InterruptedException {
		String expected_user = null;
		System.out.println("Launch URL with the userID parameters");
		try {
			String url = "https://bsci--qar1.lightning.force.com/lightning/r/User__c/" + userID + "/view";
			DriverScript.driver.get(url);
			DriverScript.driver.manage().window().maximize();
			Thread.sleep(6000);

			WebDriverWait wait = new WebDriverWait(DriverScript.driver, 20);
			wait.until(ExpectedConditions.visibilityOf(verify_user.txt_expecteduserID));
			expected_user = verify_user.txt_expecteduserID.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return expected_user;
	}

	public static void navigateCycleCount() throws Exception {
		try {
			LoginAs();
			Thread.sleep(7000);
			DriverScript.driver.navigate().refresh();
			Thread.sleep(4000);
			System.out.println("Navigate to App Launcher Page");
			applaunch.link_applauncher.click();
			String parentWindowHandler = DriverScript.driver.getWindowHandle(); // Store your parent window
			String subWindowHandler = null;

			Set<String> handles = DriverScript.driver.getWindowHandles(); // get all window handles
			System.out.println(handles);
			Iterator<String> iterator = handles.iterator();
			while (iterator.hasNext()) {
				subWindowHandler = iterator.next();
			}
			DriverScript.driver.switchTo().window(subWindowHandler); // switch to popup window
			Thread.sleep(3000);
			System.out.println("Click on CycleCount Audits");

			Actions builder = new Actions(DriverScript.driver);
			Action mouseHoverCyCleCount = builder.moveToElement(nav_menu.link_CycleCount).build();
			mouseHoverCyCleCount.perform();
			nav_menu.link_CycleCount.click();
			// Now you are in the popup window, perform necessary actions here

			DriverScript.driver.switchTo().window(parentWindowHandler); // switch back to parent window
			Thread.sleep(6000);
			nav_menu.listview.click();
			System.out.println("Select List View from Cycle Count page");

			Thread.sleep(3000);
			System.out.println("Select All option from List View");

			nav_menu.listselect.click();
			Thread.sleep(3000);
			System.out.println("Select the record from CycleCount All Lists page");
			builder.moveToElement(nav_menu.cycleselect).build().perform();

			nav_menu.cycleselect.click();
			DriverScript.driver.switchTo().window(parentWindowHandler); // switch back to parent window
			Thread.sleep(8000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/// Check CycleCount Record in UI with user name validation
	public static void validateUser(String expected_user) throws Exception {
		try {

			// WebElement user_app = driver.findElement(arg0)
			navigateCycleCount();
			WebDriverWait wait = new WebDriverWait(DriverScript.driver, 20);
			wait.until(ExpectedConditions.visibilityOf(CC_details.txt_actualuser));
			String actual_user = CC_details.txt_actualuser.getText();
			System.out.println("USERNAME" + expected_user);
			// assertEquals(expected, actual)
			Assert.assertEquals(expected_user, actual_user);
			System.out.println("USER NAME" + actual_user + "VALIDATED SUCCESS IN CC DETAILS PAGE");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// VALIDATION IN VARIANCE REPORT
///Validate error message on only Submit

	public static String VROnlySubmit() throws Exception {
		String actual_error = null;
		try {
			Thread.sleep(3000);
			navigateCycleCount();
			System.out.println("Click on Variance Report link");
			var_rprt.link_VarianceReport.click();
			Thread.sleep(4000);
			System.out.println("Switch to IFRAME IN VR screen");
			List<WebElement> iframes = DriverScript.driver.findElements(By.tagName("iframe"));
			System.out.println("No of Iframes" + iframes.size());
			DriverScript.driver.switchTo().frame(var_rprt.txt_accessibilitytitle);
			Thread.sleep(8000);
			// button[contains(text(),'Submit')]
			System.out.println("Click on SUBMIT button");
			var_rprt.btn_submit.click();

			actual_error = var_rprt.msg_actual.getText();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return actual_error;
	}

	// Validate Error message on RECONCILE ACTION AS OTHER AND SUBMIT
	public static String VROtherActionSubmit() throws Exception {
		String actual_errormsg = null;
		try {
			System.out.println("Click CANCEL from VARIANCE REPORT");
			var_rprt.btn_Cancel.click();

			List<WebElement> iframes = DriverScript.driver.findElements(By.tagName("iframe"));

			System.out.println("No of Iframes" + iframes.size());
			DriverScript.driver.switchTo().defaultContent();
			DriverScript.driver.switchTo().defaultContent();
			List<WebElement> iframes1 = DriverScript.driver.findElements(By.tagName("iframe"));

			System.out.println("No of Iframes1" + iframes1.size());
			Thread.sleep(6000);
			System.out.println("Click on VARIANCE REPORT again");
			var_rprt.link_VarianceReport.click();

			Thread.sleep(3000);
			DriverScript.driver.switchTo().frame(var_rprt.txt_accessibilitytitle);
			Thread.sleep(4000);
			System.out.println("SELECT ALL ITEMS IN VARIANCE REPORT");
			var_rprt.btn_log.click();
			System.out.println("SELECT RECONCILE ACTION FOR THE SELECTED RECORDS");
			Select Reconcile_action = new Select(var_rprt.btn_Reconcile_action);
			Reconcile_action.selectByValue("Other");
			// fruits.selectByIndex(1);
			System.out.println("Click SUBMIT in VARIANCE REPORT");
			var_rprt.btn_submit.click();
			var_rprt.btn_Yes.click();
			var_rprt.btn_Continue.click();

			actual_errormsg = var_rprt.actual_error_msg1.getText();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return actual_errormsg;
	}

//Validate Error message on select All items and SUBMIT
	public static void VRCheckAllSubmit() throws Exception {
		String actual_errormsg = null;
		try {
			System.out.println("Click CANCEL from VARIANCE REPORT");
			var_rprt.btn_Cancel.click();

			List<WebElement> iframes = DriverScript.driver.findElements(By.tagName("iframe"));

			System.out.println("No of Iframes" + iframes.size());
			DriverScript.driver.switchTo().defaultContent();
			DriverScript.driver.switchTo().defaultContent();
			List<WebElement> iframes1 = DriverScript.driver.findElements(By.tagName("iframe"));

			System.out.println("No of Iframes1" + iframes1.size());
			Thread.sleep(6000);
			System.out.println("Click on VARIANCE REPORT again");
			var_rprt.link_VarianceReport.click();

			Thread.sleep(3000);
			DriverScript.driver.switchTo().frame(var_rprt.txt_accessibilitytitle);
			Thread.sleep(4000);
			// System.out.println("SELECT ALL ITEMS IN VARIANCE REPORT");
			var_rprt.btn_log.click();
			System.out.println("SELECT RECONCILE ACTION FOR THE SELECTED RECORDS");
			Select Reconcile_action = new Select(var_rprt.btn_Reconcile_action);
			Reconcile_action.selectByValue("Bill Customer");
			// fruits.selectByIndex(1);
			Thread.sleep(5000);
			System.out.println("Click SUBMIT in VARIANCE REPORT");
			var_rprt.btn_submit.click();
			var_rprt.btn_Yes.click();
			var_rprt.btn_Continue.click();

			// actual_errormsg = var_rprt.actual_error_msg1.getText();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		// return actual_errormsg;
	}

	public static void VR_SalesUser_ChangeStatus() throws Exception {
		String actual_Status = null;
		try {

			/*
			 * System.out.println("Click CANCEL from VARIANCE REPORT");
			 * var_rprt.btn_Cancel.click();
			 */

			List<WebElement> iframes = DriverScript.driver.findElements(By.tagName("iframe"));

			System.out.println("No of Iframes" + iframes.size());
			DriverScript.driver.switchTo().defaultContent();
			DriverScript.driver.switchTo().defaultContent();
			DriverScript.driver.navigate().refresh();
			Thread.sleep(6000);
			System.out.println("Click on CHANGE STATUS menu");
			CC_details.link_ChangeStatus.click();

			Thread.sleep(3000);
			/*
			 * DriverScript.driver.findElement(By.xpath(
			 * "/html/body/div[5]/div[2]/div/div[2]/div/div[2]/div/div/div/div[2]/section/div[2]/div[1]/div"
			 * )).click(); System.out.println("Select updated status from STATUS dropdown");
			 * Select changestatusview = new Select(CC_details.dropdwn_ChangeStatusMenu);
			 * changestatusview.selectByValue("Reconciled");
			 * System.out.println("Click CONTINUE on CHANGE STATUS pane");
			 * CC_details.btn_Continue_ChangeStatus.click();
			 * DriverScript.driver.navigate().refresh();
			 */
			actual_Status = var_rprt.SalesUser_changestatusmsg.getText();
			var_rprt.btn_SalesUserChangeStatus.click();
			Thread.sleep(7000);

			// actual_Status=CC_details.txt_ActualStatus.getText();

		} catch (Exception e) {
			e.printStackTrace();
		}
		// return actual_Status;
	}

	public static void LogOut() throws Exception {
		try {
			loginAs_User.link_SalesUser.click();
			Thread.sleep(10000);
			loginAs_User.link_SwitchLightning.click();
			Thread.sleep(5000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/// CHECK RECONCILE FLAG FOR THE SELECTED RECORDS AND SUBMIT
	public static void VRReconcileFlag() throws Exception {
		String actual_errormsg = null;
		try {
			Thread.sleep(7000);
			LoginAsApprover();
			DriverScript.driver.navigate().refresh();
			Thread.sleep(4000);
			System.out.println("Navigate to App Launcher Page");
			applaunch.link_applauncher.click();
			String parentWindowHandler = DriverScript.driver.getWindowHandle(); // Store your parent window
			String subWindowHandler = null;

			Set<String> handles = DriverScript.driver.getWindowHandles(); // get all window handles
			System.out.println(handles);
			Iterator<String> iterator = handles.iterator();
			while (iterator.hasNext()) {
				subWindowHandler = iterator.next();
			}
			DriverScript.driver.switchTo().window(subWindowHandler); // switch to popup window
			Thread.sleep(3000);
			System.out.println("Click on CycleCount Audits");

			Actions builder = new Actions(DriverScript.driver);
			Action mouseHoverCyCleCount = builder.moveToElement(nav_menu.link_CycleCount).build();
			mouseHoverCyCleCount.perform();
			nav_menu.link_CycleCount.click();
			// Now you are in the popup window, perform necessary actions here

			DriverScript.driver.switchTo().window(parentWindowHandler); // switch back to parent window
			Thread.sleep(6000);
			nav_menu.listview.click();
			System.out.println("Select List View from Cycle Count page");

			Thread.sleep(3000);
			System.out.println("Select All option from List View");

			nav_menu.listselect.click();
			Thread.sleep(3000);
			System.out.println("Select the record from CycleCount All Lists page");
			builder.moveToElement(nav_menu.cycleselect).build().perform();

			nav_menu.cycleselect.click();
			DriverScript.driver.switchTo().window(parentWindowHandler); // switch back to parent window
			Thread.sleep(8000);
			System.out.println("Click on Variance Report link");
			var_rprt.link_VarianceReport.click();
			Thread.sleep(4000);
			System.out.println("Switch to IFRAME IN VR screen");
			List<WebElement> iframes = DriverScript.driver.findElements(By.tagName("iframe"));
			System.out.println("No of Iframes" + iframes.size());
			DriverScript.driver.switchTo().frame(var_rprt.txt_accessibilitytitle);
			Thread.sleep(8000);
			var_rprt.btn_log.click();
			System.out.println("SELECT RECONCILE ACTION FOR THE SELECTED RECORDS");
			Select Reconcile_action = new Select(var_rprt.btn_Reconcile_action);
			Reconcile_action.selectByValue("Bill Customer");

			JavascriptExecutor je = (JavascriptExecutor) DriverScript.driver;

			WebDriverWait wait = new WebDriverWait(DriverScript.driver, 6);
			System.out.println("IDENTIFY VARIANCE REPORT TABLE");

			List<WebElement> rows = var_rprt.tbl_table.findElements(By.tagName("tr"));
			List<WebElement> cols = rows.get(0).findElements(By.tagName("td"));
			for (int i = 1; i <= rows.size(); i++) {
				WebElement flag = var_rprt.tbl_table
						.findElement(By.xpath("//tr[" + i + "]/td[@data-label='FLAG']/div/div/child::div/a"));
				je.executeScript("arguments[0].scrollIntoView(true);", flag);
				System.out.println("Value of i=" + i);

				try {
					flag.click();
					Thread.sleep(4000);
				} catch (Exception e) {
					List<WebElement> spinner = DriverScript.driver.findElements(By.className("slds-spinner_container"));
					wait.until(ExpectedConditions.invisibilityOfAllElements(spinner));
					;

					flag.click();
					System.out.println("Exception is:" + e.getMessage());
				}
			}
			System.out.println("Click SUBMIT in VARIANCE REPORT");
			try {
				var_rprt.btn_submit.click();
			} catch (Exception e) {
				List<WebElement> spinner = DriverScript.driver.findElements(By.className("slds-spinner_container"));
				wait.until(ExpectedConditions.invisibilityOfAllElements(spinner));
				;

				var_rprt.btn_submit.click();
				System.out.println("Exception is:" + e.getMessage());
			}
			var_rprt.btn_Yes.click();
			var_rprt.btn_Continue.click();
			DriverScript.driver.switchTo().defaultContent();
			Thread.sleep(6000);
			DriverScript.driver.navigate().refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/// CHECK STATUS AFTER SELECTING RECONCILE FLAG
	public static String VRCheckStatus() throws Exception {
		String actual_status = null;
		try {
			Thread.sleep(6000);
			DriverScript.driver.navigate().refresh();
			Thread.sleep(6000);
			System.out.println("Check Status on CC Details page");
			actual_status = var_rprt.txt_actualstatus.getText();

		} catch (Exception e) {

		}
		return actual_status;
	}

	// VARIANCE REPORT VALIDATIONS
	// FOR USER WITHOUT APPRVER PERMISSION SET
	public static void NormaluserVRCheckAllSubmit() throws Exception {
		try {
			// DriverScript.driver.close();
			System.out.println("Login as user without APPROVER  permission set");
			// DriverScript.driver = BrowserManager.getBrowser("Chrome");
			SFDC_Login.navigateToURL();
			SFDC_Login.loginSalesforce(Constants.BSC_SalesUser, Constants.BSC_SalesPassword);
			Thread.sleep(25000);
			System.out.println("Navigate to App Launcher Page");
			applaunch.link_applauncher.click();
			String parentWindowHandler = DriverScript.driver.getWindowHandle(); // Store your parent window
			String subWindowHandler = null;

			Set<String> handles = DriverScript.driver.getWindowHandles(); // get all window handles
			System.out.println(handles);
			Iterator<String> iterator = handles.iterator();
			while (iterator.hasNext()) {
				subWindowHandler = iterator.next();
			}
			DriverScript.driver.switchTo().window(subWindowHandler); // switch to popup window
			Thread.sleep(3000);
			System.out.println("Click on CycleCount Audits");

			Actions builder = new Actions(DriverScript.driver);
			Action mouseHoverCyCleCount = builder.moveToElement(nav_menu.link_CycleCount).build();
			mouseHoverCyCleCount.perform();
			nav_menu.link_CycleCount.click();
			// Now you are in the popup window, perform necessary actions here

			DriverScript.driver.switchTo().window(parentWindowHandler); // switch back to parent window
			Thread.sleep(6000);
			nav_menu.listview.click();
			System.out.println("Select List View from Cycle Count page");

			Thread.sleep(3000);
			System.out.println("Select All option from List View");

			nav_menu.listselect.click();
			Thread.sleep(3000);
			System.out.println("Select the record from CycleCount All Lists page");
			builder.moveToElement(nav_menu.cycleselect).build().perform();

			nav_menu.cycleselect.click();
			DriverScript.driver.switchTo().window(parentWindowHandler); // switch back to parent window
			Thread.sleep(6000);
			System.out.println("Click on VARIANCE REPORT again");
			var_rprt.link_VarianceReport.click();

			Thread.sleep(3000);
			DriverScript.driver.switchTo().frame(var_rprt.txt_accessibilitytitle);
			Thread.sleep(4000);
			System.out.println("SELECT ALL ITEMS IN VARIANCE REPORT");
			var_rprt.btn_log.click();
			System.out.println("SELECT RECONCILE ACTION FOR THE SELECTED RECORDS");
			Select Reconcile_action = new Select(var_rprt.btn_Reconcile_action);
			Reconcile_action.selectByValue("Bill Customer");
			System.out.println("Click SUBMIT in VARIANCE REPORT");
			var_rprt.btn_submit.click();
			var_rprt.btn_Yes.click();
			var_rprt.btn_Continue.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
