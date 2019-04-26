package com.BSC.framework.action;

import org.openqa.selenium.WebDriver;

import com.BSC.framework.pageObjects.AccountPerformanceDetailPage;
import com.BSC.framework.pageObjects.SalesforceLogin2;
import com.BSC.framework.utilities.Constants;

public class WebDriverActionKeywordsGenericNew extends BaseTestNew {
	static SalesforceLogin2 login2 = new SalesforceLogin2(driver1);
	static AccountPerformanceDetailPage accountPerformanceDetailPage = new AccountPerformanceDetailPage(driver1);

	static String json = "...";

	public static void LoginAsParameterAdmin() throws Exception {
		try {
			
			login2 = new SalesforceLogin2(driver1);
			Thread.sleep(5000);
			setup();
			System.out.println("Navigate to Salesforce Home Page");
			// SalesforceLogin.navigateToURLGeneric(driver);
			login2.loginSalesforce(Constants.BSC_AppUser, Constants.BSC_AppPassword);
			login2.searchUserAdmin();

			Thread.sleep(4000);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
