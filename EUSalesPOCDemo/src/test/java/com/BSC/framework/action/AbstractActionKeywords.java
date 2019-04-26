package com.BSC.framework.action;

import org.openqa.selenium.WebElement;

public abstract class AbstractActionKeywords {
	
	public abstract void selectDropdown(WebElement locator,String data);
	 public abstract void click(WebElement locator, String data);
	 public  abstract void input(WebElement locator, String data);

}
