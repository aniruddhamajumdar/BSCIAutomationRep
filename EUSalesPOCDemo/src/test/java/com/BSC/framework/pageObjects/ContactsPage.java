package com.BSC.framework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.BSC.framework.DriverScript;
import com.BSC.framework.action.BaseTest;
import com.BSC.framework.action.Randomizer;
import com.BSC.framework.utilities.Log;

public class ContactsPage extends BaseTest {

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[@title='New']")
	public WebElement new_Contact;

	@FindBy(how = How.XPATH, using = "(//div/a[@class='select'])[1]")

	WebElement select_Salutation;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='First Name']")

	WebElement first_Name;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Last Name']")

	WebElement last_Name;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Search Accounts...']")

	WebElement account_Name;

	@FindBy(how = How.XPATH, using = "//div[contains(@title ,'ADD')]")

	WebElement select_Account;

	@FindBy(how = How.XPATH, using = "(//div/a[@class='select'])[2]")

	WebElement select_Gender;

	@FindBy(how = How.XPATH, using = "//input[@type='email']")

	WebElement email_Address;
	
	@FindBy(how = How.XPATH, using = "//div/div/div/input[@type='checkbox']")

	WebElement check_Box;

	@FindBy(how = How.XPATH, using = "//button[@title='Save']")

	WebElement save;

	public void createNewContact() throws InterruptedException {

		driver.switchTo().defaultContent();
		new_Contact.click();
		Thread.sleep(3000);
		select_Salutation.click();
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		WebElement salutation = driver.findElement(By.xpath("(//a[@title ='Mr.'])"));
		Thread.sleep(3000);
		actions.moveToElement(salutation).click().perform();
		Thread.sleep(5000);
		String firstName = "Auto" + Randomizer.getRandomAphabeticString(4);
		String lastName = Randomizer.getRandomAphabeticString(4);
		first_Name.sendKeys(firstName);
		Thread.sleep(2000);
		last_Name.sendKeys(lastName);
		Thread.sleep(1000);
		account_Name.click();
		Thread.sleep(5000);
		select_Account.click();
		Thread.sleep(2000);
		select_Gender.click();
		Thread.sleep(5000);
		WebElement gender = driver.findElement(By.xpath("(//a[@title ='Male'])"));
		Thread.sleep(3000);
		actions.moveToElement(gender).click().perform();
		Thread.sleep(5000);
		email_Address.sendKeys("aniruddha.majumdar@accenture.com");
		Thread.sleep(3000);
		check_Box.click();
		Thread.sleep(3000);
		save.click();
		Thread.sleep(3000);
	}

}
