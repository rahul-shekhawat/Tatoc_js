package com.qainfotech.js.TatocJS;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;



public class GridGateClass {
	
	JavascriptExecutor js;
	WebDriver driver;
	
	public GridGateClass(JavascriptExecutor js,WebDriver driver)
	{
		this.js=js;
		this.driver=driver;
	}
	
	public void attemptclickonredbox()
	{
		js.executeScript("document.getElementsByClassName('redbox')[0].click();");
		Assert.assertEquals("http://10.0.1.86/tatoc/error", driver.getCurrentUrl());
	}
	
	public void attemptclickongreenbox()
	{
		js.executeScript("document.getElementsByClassName('greenbox')[0].click();");
		Assert.assertEquals("http://10.0.1.86/tatoc/basic/frame/dungeon", driver.getCurrentUrl());
	
	}

}
