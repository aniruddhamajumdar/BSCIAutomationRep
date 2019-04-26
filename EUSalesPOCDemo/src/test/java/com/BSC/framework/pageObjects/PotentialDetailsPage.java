package com.BSC.framework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.BSC.framework.action.BaseTest;

public class PotentialDetailsPage extends BaseTest {

	public PotentialDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//div/div[2]/div[1]/div/div[2]/button")

	WebElement clickEditButton;

	@FindBy(how = How.XPATH, using = "(//input[@class=' input'])[1]")

	WebElement changeData;

	@FindBy(how = How.XPATH, using = "//div[2]/div/div[2]/div/div/button[2]")

	WebElement saveButton;
	
	@FindBy(how = How.XPATH, using = "//button[@title='Save']")

	WebElement saveButtonNew;
	

	@FindBy(how = How.XPATH, using = "//span[text()='Related']")

	WebElement relatedTabClick;

	@FindBy(how = How.XPATH, using = "(//a[text()='Pending Approval'])")
	WebElement approvalStatus;

	@FindBy(how = How.XPATH, using = "//div[2]/h1/div/span")
	WebElement getPotentialNumber;

	@FindBy(how = How.XPATH, using = "//button[@title='Edit Approval Status']")
	WebElement clickEditApproval;

	@FindBy(how = How.XPATH, using = "(//div/a[@class='select'])[2]")
	WebElement approvalStatusClick;

	public void changeQuantityProposed() throws InterruptedException {

		driver.switchTo().defaultContent();
		clickEditButton.click();
		Thread.sleep(3000);
		changeData.clear();
		Thread.sleep(3000);
		changeData.sendKeys("52");
		saveButton.click();

	}

	public String validationCheck() throws InterruptedException {

		return approvalStatus.getText();

	}

	public String setpotentialNumber() throws InterruptedException {

		return getPotentialNumber.getText();

	}

	public String copyUrlLink() throws InterruptedException {
		String url = driver.getCurrentUrl();
		return url;

	}

	public void EditApprovalStatus() throws InterruptedException {

		driver.switchTo().defaultContent();
		clickEditApproval.click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		approvalStatus.click();
		Thread.sleep(5000);

		Actions actions = new Actions(driver);
		WebElement approval = driver.findElement(By.xpath("(//a[text()='Approved'])"));
		Thread.sleep(3000);
		actions.moveToElement(approval).click().perform();
		Thread.sleep(5000);
		saveButtonNew.click();
		Thread.sleep(10000);
		
		driver.navigate().refresh();
		

	}

}
