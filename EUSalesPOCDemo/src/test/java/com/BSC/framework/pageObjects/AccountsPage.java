package com.BSC.framework.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.BSC.framework.DriverScript;
import com.BSC.framework.action.BaseTest;
import com.BSC.framework.utilities.Log;

public class AccountsPage extends BaseTest {

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	static AppLauncher appLauncher = new AppLauncher(driver);
	static PI_Potentials PI_pot = new PI_Potentials(driver);
	WebDriverWait wait = new WebDriverWait(driver, 20);

	@FindBy(how = How.XPATH, using = "//div/div[1]/div[2]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr/th/span/a")
	public WebElement account;

	@FindBy(how = How.XPATH, using = "//a/span[contains(@title,'Account Performance')]")

	WebElement account_Performance;

	@FindBy(how = How.XPATH, using = "(//span[contains(@title,'Account Performance')])[1]")

	WebElement account_PerformanceClick;

	@FindBy(how = How.XPATH, using = "//table")
	List<WebElement> account_table;

	@FindBy(how = How.XPATH, using = "//table//tbody//input[@type='checkbox']")
	List<WebElement> account_performance_table;

	@FindBy(how = How.XPATH, using = "//span[text()='Division']/../following-sibling::div[1]/span/span")
	List<WebElement> division_geninfo;

	// @FindBy(how = How.XPATH, using = "(//iframe)[4]")
	@FindBy(how = How.XPATH, using = "//span[text()='Potentials']/../../following-sibling::div//iframe")

	List<WebElement> PotentialInfoFrame;
	
	
	@FindBy(how = How.XPATH, using = "//div/force-aloha-page[@title='EU_AccountDashboardDisplay']/div/iframe")

	List<WebElement> frame_AccDashboard;

	@FindBy(how = How.XPATH, using = "//table//tr")
	List<WebElement> potential_table;

	@FindBy(how = How.XPATH, using = "//span[text()='Related']")

	WebElement relatedTab;

	@FindBy(how = How.XPATH, using = "//span[text()='Details']")

	WebElement detailsTab;

	@FindBy(how = How.XPATH, using = "(//table/tbody/tr/th/span)[1]")
	WebElement procedureName;

	@FindBy(how = How.XPATH, using = "(//table/tbody/tr[1]/td[1]/a)[1]")
	WebElement productName;
	
	@FindBy(how = How.XPATH, using = "//table/tbody/tr/th/span")
	List<WebElement> procedureNameEndo;

	@FindBy(how = How.XPATH, using = "//span[text()='EU Procedure Ratios']/following-sibling::span")
	WebElement euProcedureRatioCount;
	
	@FindBy(how = How.XPATH, using = "//ul/li/a[@title='Details']")
	WebElement link_AccountsDetails;
	
	
	@FindBy(how = How.XPATH, using = "//button/child::span[text()='Account Dashboard']")
	WebElement btn_AccountDashboard;
	

	public void clickAccountandAccountPerf() throws InterruptedException {

		driver.switchTo().defaultContent();
		account.click();// crm

		Thread.sleep(3000);
		account_Performance.click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		account_PerformanceClick.click();
		Thread.sleep(3000);

	}

	public void clickAccountandAccountPerfNew() throws InterruptedException {

		driver.switchTo().defaultContent();
		selectAccountFor("GB");

		Thread.sleep(1000);
	
		wait.until(ExpectedConditions.visibilityOf(account_Performance));
		link_AccountsDetails.click();
		Thread.sleep(3000);
		List<WebElement> iframes=driver.findElements(By.tagName("iframe"));
		System.out.println(iframes.size());
		//driver.switchTo().frame(frame_AccDashboard.get(2));
		driver.switchTo().frame(frame_AccDashboard.get(frame_AccDashboard.size() - 1));
		
		
	}

	public void validateAndClickDivision() throws InterruptedException {
		System.out.println("No of account performance is " + account_performance_table.size());
		// selectDivisionFor("NM");
		List<String> divList = new ArrayList<String>();
		for (int i = 1; i < account_performance_table.size() + 1; i++) {
			String divCol = "(//table)[2]//tr[" + i + "]//td[3]//span/span";
			// if not new cardio, add to list and click on link
			if (!driver.findElement(By.xpath(divCol)).getText().equals("New Cardio")) {
				System.out.println(
						"Account performance found on division " + driver.findElement(By.xpath(divCol)).getText());
				divList.add(driver.findElement(By.xpath(divCol)).getText());
				String acctPerformance = "(//table)[2]//tr[" + i + "]//th[1]//span//a";
				driver.findElement(By.xpath(acctPerformance)).click();
				Thread.sleep(15000);
				// division locator not unique
				// String division=division_geninfo.getText();
				String division = division_geninfo.get(division_geninfo.size() - 1).getText();
				System.out.println("division is " + division);

				if (divList.contains(division)) {
					System.out.println("Division present in General Information section " + division);

				} else {
					System.out.println("Division present in General info section not matches to list data");
				}
				validatePotentialNo();
				clickPotential(division);

			}

		}

	}

	public void selectAccountFor(String cntrycode) throws InterruptedException {
		for (int i = 1; i < account_table.size() + 1; i++) {
			String cntyCol = "//table//tr[" + i + "]//td[3]//span";
			if (driver.findElement(By.xpath(cntyCol)).getText().equals(cntrycode)) {
				System.out.println("Account found for country code " + cntrycode);
				String acctName = "//table//tr[" + i + "]//th[1]//span//a";
				driver.findElement(By.xpath(acctName)).click();
				Thread.sleep(2000);

			}
		}
	}

	public void selectDivisionFor(String div) throws InterruptedException {
		for (int i = 1; i < account_performance_table.size() + 1; i++) {
			String divCol = "(//table)[2]//tr[" + i + "]//td[3]//span/span";
			if (driver.findElement(By.xpath(divCol)).getText().equals(div)) {
				System.out.println("Account performance found on division " + div);
				String acctPerformance = "(//table)[2]//tr[" + i + "]//th[1]//span//a";
				driver.findElement(By.xpath(acctPerformance)).click();
				Thread.sleep(3000);
			}
		}

	}

	public void validatePotentialNo() throws InterruptedException {// String division=division_geninfo.getText();
		String division = division_geninfo.get(division_geninfo.size() - 1).getText();
		driver.switchTo().frame(PotentialInfoFrame.get(PotentialInfoFrame.size() - 1));
		System.out.println("Frame size is "+(PotentialInfoFrame.size()-1));
		Thread.sleep(8000);
		if (division.equals("CRM")) {
			System.out.println((potential_table.size() - 1));

			Assert.assertEquals(potential_table.size() - 1, 4);

		}
		if (division.equals("Endo")) {
			Assert.assertEquals(potential_table.size() - 1, 14);

		}
		if (division.equals("PI")) {
			Assert.assertEquals(potential_table.size() - 1, 22);

		}
		if (division.equals("UroPH")) {
			Assert.assertEquals(potential_table.size() - 1, 17);

		}
		driver.switchTo().defaultContent();
	}

	public void clickPotential(String acctDivision) throws InterruptedException {// driver.switchTo().frame(PotentialInfoFrame);
		driver.switchTo().frame(PotentialInfoFrame.get(PotentialInfoFrame.size() - 1));
		System.out.println("Switched to frame");

		for (int i = 1; i < potential_table.size(); i++) {
			// driver.switchTo().frame(PotentialInfoFrame);

			Thread.sleep(4000);
			System.out.println("Table size is " + potential_table.size());
			String procedurelink = "//table//tr[" + i + "]//td[2]//span//a";
			Thread.sleep(4000);
			driver.findElement(By.xpath(procedurelink)).click();
			Thread.sleep(22000);
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			driver.switchTo().defaultContent();
			relatedTab.click();
			Thread.sleep(7000);
			System.out.println("div is " + acctDivision);
			/*
			 * if(acctDivision.equals("CRM")) {
			 * Assert.assertEquals(euProcedureRatioCount.getText().trim(), "(1)"); }
			 */
			// CRM
			if (procedureName.getText().equals("Pacemaker implants")) {
				Assert.assertEquals(euProcedureRatioCount.getText().trim(), "(1)");
				if (procedureName.getText().equals("Pacemaker implants") && productName.getText().equals("CRM-Brady")) {
					System.out.println(
							"Procedure Name : " + procedureName.getText() + " Product Name : " + productName.getText());
				} else {
					Assert.assertTrue(false, "The Procedure Name and Product Name donot match");
				}
			}
			if (procedureName.getText().equals("CRT-P implants")) {
				Assert.assertEquals(euProcedureRatioCount.getText().trim(), "(1)");

				if (procedureName.getText().equals("CRT-P implants") && productName.getText().equals("CRM-Brady HF")) {
					System.out.println(
							"Procedure Name : " + procedureName.getText() + " Product Name : " + productName.getText());
				} else {
					Assert.assertTrue(false, "The Procedure Name and Product Name donot match");
				}
			}
			if (procedureName.getText().equals("Defibrillator implants inc. S-ICDs")) {
				Assert.assertEquals(euProcedureRatioCount.getText().trim(), "(1)");
				if (procedureName.getText().equals("Defibrillator implants inc. S-ICDs")
						&& productName.getText().equals("CRM-Tachy")) {
					System.out.println(
							"Procedure Name : " + procedureName.getText() + " Product Name : " + productName.getText());
				} else {
					Assert.assertTrue(false, "The Procedure Name and Product Name donot match");
				}
			}
			if (procedureName.getText().equals("CRT-D implants")) {
				Assert.assertEquals(euProcedureRatioCount.getText().trim(), "(1)");
				if (procedureName.getText().equals("CRT-D implants") && productName.getText().equals("CRM-Tachy HF")) {
					System.out.println(
							"Procedure Name : " + procedureName.getText() + " Product Name : " + productName.getText());
				} else {
					Assert.assertTrue(false, "The Procedure Name and Product Name donot match");
				}
			}

			// Endo

			if (procedureName.getText().equals("Airway stent")) {
				Assert.assertEquals(euProcedureRatioCount.getText().trim(), "(1)");
				if (procedureName.getText().equals("Airway stent")
						&& productName.getText().equals("Airway Stent/TBNA")) {
					System.out.println(
							"Procedure Name : " + procedureName.getText() + " Product Name : " + productName.getText());
				} else {
					Assert.assertTrue(false, "The Procedure Name and Product Name donot match");
				}
			}
			if (procedureName.getText().equals("Biliary metal")) {
				Assert.assertEquals(euProcedureRatioCount.getText().trim(), "(1)");
				if (procedureName.getText().equals("Biliary metal")
						&& productName.getText().equals("Biliary Metal Stents")) {
					System.out.println(
							"Procedure Name : " + procedureName.getText() + " Product Name : " + productName.getText());
				} else {
					Assert.assertTrue(false, "The Procedure Name and Product Name donot match");
				}
			}
			
			if (procedureName.getText().equals("Bronchoscopy (incl EBUS)")) {
				Assert.assertEquals(euProcedureRatioCount.getText().trim(), "(5)");
				for (int j = 1; j < procedureNameEndo.size() + 1; j++) {
					String procedureCol="//table/tbody/tr["+i+"]/th/span";
					if(!driver.findElement(By.xpath(procedureCol)).getText().equals("Bronchoscopy (incl EBUS)"))
					{
						Assert.assertTrue(false, "The Procedure Name not proper");
					}
						
				}
				List<String> productList = new ArrayList<String>();
				for (int j = 1; j < procedureNameEndo.size() + 1; j++) {
					String productCol="(//table/tbody/tr["+j+"]/td[1]/a)[1]";
					productList.add(driver.findElement(By.xpath(productCol)).getText());
				}
				for ( i = 0; i < productList.size(); i++) {
					System.out.println(productList.get(i));
				}
				if(!(productList.contains("EBUS")&&productList.contains("ENDO-Biopsy")&&productList.contains("Balloon")&&productList.contains("Wires")&&productList.contains("Airway Stent/TBNA")))
				{
					Assert.assertTrue(false, "The Product Name not proper");
				}
					
			}
			if (procedureName.getText().equals("BT")) {
				Assert.assertEquals(euProcedureRatioCount.getText().trim(), "(1)");
				if (procedureName.getText().equals("BT")
						&& productName.getText().equals("BT Catheter")) {
					System.out.println(
							"Procedure Name : " + procedureName.getText() + " Product Name : " + productName.getText());
				} else {
					Assert.assertTrue(false, "The Procedure Name and Product Name donot match");
				}
			}
              /////////////PI
			if(acctDivision.equals("PI")) {
				 PI_pot.validateProcedure_product();
			}
			
			
			driver.close();
			driver.switchTo().window(tabs2.get(0));
			// driver.switchTo().frame(PotentialInfoFrame);
			driver.switchTo().frame(PotentialInfoFrame.get(PotentialInfoFrame.size() - 1));
			System.out.println("Switched to frame");

		}
		driver.switchTo().defaultContent();
		Thread.sleep(4000);
		appLauncher = new AppLauncher(driver);
		appLauncher.clickAndSearchText();
		clickAccountandAccountPerfNew();
	}

}
