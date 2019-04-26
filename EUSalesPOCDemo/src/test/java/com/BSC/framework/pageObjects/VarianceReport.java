package com.BSC.framework.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class VarianceReport {
	@FindBy(how = How.XPATH, using = "//div[@title='Variance Report']")
	 
	 public WebElement link_VarianceReport;
	
@FindBy(how = How.XPATH, using = ".//iframe[@title='accessibility title']")
public WebElement txt_accessibilitytitle;

@FindBy(how = How.XPATH, using = "//button[contains(text(),'Submit')]")
public WebElement btn_submit;

@FindBy(how = How.XPATH, using = "//div[@id='errormessageSubmitSave']/span")
public WebElement msg_actual;

@FindBy(how = How.XPATH, using = "//button[contains(text(),'Cancel')]")
public WebElement btn_Cancel;

@FindBy(how = How.XPATH, using = "//*[@id=\"LtngOutBsicInfo\"]/div/section/div/table/thead/tr/th[1]/div/div/label/span[1]")
public WebElement btn_log;

@FindBy(how = How.XPATH, using = "//td[@id='0']/div/div/div/div/child::select")
public WebElement btn_Reconcile_action;

@FindBy(how = How.XPATH, using = "//button[text()='Yes']")
public WebElement btn_Yes;

@FindBy(how = How.XPATH, using = "//button[text()='Continue']")
public WebElement btn_Continue;

@FindBy(how = How.XPATH, using = "//div[@id='errormessageSubmitSave']/span")
public WebElement actual_error_msg1;

@FindBy(how = How.XPATH, using = "//table/tbody")
public WebElement tbl_table;

@FindBy(how = How.XPATH, using = "//td[@data-label='FLAG']/div/div/child::div/a")
public WebElement link_flag;

@FindBy(how = How.CLASS_NAME, using ="slds-spinner_container")
public WebElement spn_spinner;

@FindBy(how = How.XPATH, using = "//button[@title='Edit Status']/../span/span[1]")
public WebElement txt_actualstatus;

@FindBy(how = How.XPATH, using = "//span[contains(text(),'have sufficient access to perform this task')]")
public WebElement SalesUser_changestatusmsg;

//button[@title='Close this window']
@FindBy(how = How.XPATH, using = "//button[@title='Close this window']")
public WebElement btn_SalesUserChangeStatus;
}


