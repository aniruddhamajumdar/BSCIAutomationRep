package com.BSC.framework.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.BSC.framework.DriverScript;
import com.BSC.framework.action.BaseTest;
import com.BSC.framework.utilities.Constants;
import com.BSC.framework.utilities.Log;

public class AppLauncher extends BaseTest {

	public AppLauncher(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//nav[@class='appLauncher slds-context-bar__icon-action']")
	public WebElement link_applauncher;

	@FindBy(how = How.XPATH, using = "//input[@class='slds-input input']")

	WebElement search;

	@FindBy(how = How.XPATH, using = "//html/body/div[5]/div[2]/div/div[2]/div/div[2]/div[2]/div/div[2]/ul/li[3]/a")

	WebElement clickAccounts;

	@FindBy(how = How.XPATH, using = "//a[@title='Potentials']")

	WebElement clickPotentials;
	
	@FindBy(how = How.XPATH, using = "//div/div[2]/div/div[2]/div[2]/div/input")

	WebElement searchTextBox;
	
	@FindBy(how = How.XPATH, using = "(//table/tbody/tr/th/span/a)[4]")

	WebElement potentialSearchBox;
	
	

	public void clickAndSearchText() throws InterruptedException {
		link_applauncher.click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		search.sendKeys(Constants.search);
		Thread.sleep(3000);
		clickAccounts.click();
		Thread.sleep(6000);

	}

	public void clickAndSearchPotential(String potentialNumber) throws InterruptedException {
		link_applauncher.click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		search.sendKeys(Constants.searchNew);
		Thread.sleep(3000);
		clickPotentials.click();
		Thread.sleep(3000);
		searchTextBox.sendKeys(potentialNumber);
		Thread.sleep(1000);
		searchTextBox.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		potentialSearchBox.click();
		Thread.sleep(6000);
		

	}

}
