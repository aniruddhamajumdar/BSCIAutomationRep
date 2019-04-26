package com.BSC.framework.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CycleCountDetails {
	
	 @FindBy(how = How.XPATH, using = "//div/div[9]/div[1]/div/div[2]/span/div/a")
		public WebElement txt_actualuser;
	 @FindBy(how = How.XPATH, using = "//div[@title='Change Status']")
		public WebElement link_ChangeStatus;
	 @FindBy(how = How.XPATH, using = "//div[contains(@class, 'slds-form slds-form_stacked cCompleteCycleCount')]/div/div/select")
		public WebElement dropdwn_ChangeStatusMenu;
	 
	
	 @FindBy(how = How.XPATH, using = "//button[text()='Continue']")
		public WebElement btn_Continue_ChangeStatus;
	 @FindBy(how = How.XPATH, using = "//button[@title='Edit Status']/../span/span[1]")
		public WebElement txt_ActualStatus;
	
	}


