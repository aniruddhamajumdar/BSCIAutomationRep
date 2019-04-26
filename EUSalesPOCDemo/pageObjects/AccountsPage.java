package com.BSC.framework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.BSC.framework.DriverScript;
import com.BSC.framework.action.BaseTest;
import com.BSC.framework.utilities.Log;

public class AccountsPage extends BaseTest {

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//div/div[1]/div[2]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr/th/span/a")
	public WebElement account;

	@FindBy(how = How.XPATH, using = "//a/span[contains(@title,'Account Performance')]")

	WebElement account_Performance;
	
	@FindBy(how = How.XPATH, using = "//div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr/th/span/a")
	
	WebElement account_PerformanceClick;
	

	public void clickAccountandAccountPerf() throws InterruptedException {
		
		driver.switchTo().defaultContent();
		account.click();
		Thread.sleep(3000);
		account_Performance.click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		account_PerformanceClick.click();
		Thread.sleep(3000);

	}

}
