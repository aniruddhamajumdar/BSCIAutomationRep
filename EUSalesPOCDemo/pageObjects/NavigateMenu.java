package com.BSC.framework.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NavigateMenu {

	@FindBy(how = How.XPATH, using = "//a[@title='Cycle Count &#47; Audits']")
	 
	 public WebElement link_CycleCount;
	 @FindBy(how = How.XPATH, using = "//a[@title='Select List View']")
	 public WebElement listview;
	 @FindBy(how = How.XPATH, using = "//ul[contains(@id,'virtualAutocompleteListbox')]/child::li[position()=2]")
	 public WebElement listselect;
	 @FindBy(how = How.XPATH, using = "//ul[contains(@id,'virtualAutocompleteListbox')]/child::li[position()=4]")
	 public WebElement selectnew;
	// @FindBy(how = How.XPATH, using = "//*[@id=\"brandBand_1\"]/div/div[1]/div[2]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[1]/th/span/a")
	 //public WebElement cycleselect;
	 @FindBy(how = How.XPATH, using = "//table/tbody/tr[1]/th/span/a")
	public WebElement cycleselect;
	
}
