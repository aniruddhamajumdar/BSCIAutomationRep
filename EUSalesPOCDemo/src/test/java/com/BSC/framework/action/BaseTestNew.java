package com.BSC.framework.action;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.BSC.framework.manager.BrowserManager;
import com.BSC.framework.utilities.Log;

public abstract class BaseTestNew {

	public static WebDriver driver1;
	public static WebDriverWait wait1;

	public static WebDriver setup() {
		driver1 = BrowserManager.getBrowser("Chrome");
		System.out.println("Launching Chrome Browser");
		driver1.get("https://test.salesforce.com");
		driver1.manage().window().maximize();
		driver1.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		wait1 = new WebDriverWait(driver1, 15);
		return driver1;
	}

	// System.out.println("in method "+ driver.getTitle() );

}
