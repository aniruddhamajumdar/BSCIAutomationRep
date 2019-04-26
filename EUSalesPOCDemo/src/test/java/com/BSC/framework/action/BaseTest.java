package com.BSC.framework.action;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.BSC.framework.manager.BrowserManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public abstract class BaseTest {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static ExtentTest test;
		public static ExtentReports report;

	public static WebDriver setup() {

		driver = BrowserManager.getBrowser("Chrome");
		System.out.println("Launching Chrome Browser");
		driver.get("https://test.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 15);
		return driver;

		// System.out.println("in method "+ driver.getTitle() );

	}

}
