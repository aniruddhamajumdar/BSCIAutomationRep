package com.BSC.framework.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class VerifyUser {
	@FindBy(how = How.XPATH, using = "//*[@id=\"brandBand_1\"]/div[2]/div[1]/div/div[1]/div/div[1]/div/header/div[2]/div/div[1]/div[2]/div[1]/b/span")
	public WebElement txt_expecteduserID;
}
