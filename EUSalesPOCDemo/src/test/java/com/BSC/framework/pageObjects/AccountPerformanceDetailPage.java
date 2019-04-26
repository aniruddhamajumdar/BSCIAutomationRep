package com.BSC.framework.pageObjects;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.BSC.framework.DriverScript;
import com.BSC.framework.action.BaseTest;
import com.BSC.framework.utilities.Constants;
import com.BSC.framework.utilities.Log;

public class AccountPerformanceDetailPage extends BaseTest {

	public AccountPerformanceDetailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "(//iframe)[6]")

	WebElement accountPreferenceInfoFrame;

	@FindBy(how = How.XPATH, using = "//div/div/table/tbody/tr[1]/td[3]/span/button")

	WebElement clickEditButton;

	@FindBy(how = How.XPATH, using = "(//td[@class='slds-cell-edit']/span)[1]")

	WebElement changeData;

	@FindBy(how = How.XPATH, using = "//div/div/table/tbody/tr[1]/td[2]/div/span/a")

	WebElement potentialsClick;

	@FindBy(how = How.XPATH, using = "//span[text()='Related']")

	WebElement relatedTabClick;

	public void switchToAccountPrefPageAndClickPotential() throws InterruptedException {
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(accountPreferenceInfoFrame);
		Thread.sleep(6000);
		//clickEditButton.click();
		potentialsClick.click();
		Thread.sleep(8000);
		
	}

	public String copyUrlLink() throws InterruptedException {
		String url = driver.getCurrentUrl();
		return url;

	}

}
