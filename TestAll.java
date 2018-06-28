package com.qainfotech.js.TatocJS;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestAll {
	
	WebDriver driver;
	GridGateClass gridobj;
	FrameDungeonClass frame;
	JavascriptExecutor jsexecutor ;
	DragAroundClass drag;
	PopUpWindowClass pop;
	CookiePageClass ck;
	
	@Test(priority=0)
	public void clickonredboxshouldrendererrorpage()
	{   
		gridobj.attemptclickonredbox();
		driver.navigate().back();
	}
	
	@Test(priority=1)
	public void clickongreenboxshouldrendernextpage()
	{
		gridobj.attemptclickongreenbox();
	}
	
	@Test(priority=2)
	public void colormatchwillrendernextpage()
	{
		frame.whentwocolorsmatch();
	}
	
	@Test(priority=3)
	public void unsuccessfuldragwillgotoerrorpage()
	{
		drag.verifyunsuccdraganddrop();
		driver.navigate().back();
	}

	@Test(priority=5)
	public void successfuldragwillgotonextpage()
	{
		drag.verifysuccdraganddrop();	
	}
    
	@Test(priority=6)
	public void leavingthefeildemptywillrendererrorpage()
	{
		pop.submittheform("");
		driver.navigate().back();
	}
	
	@Test(priority=7)
	public void fillingthefeildemptywillrendernextpage()
	{
		pop.submittheform("Rahul");
	}
	
	@Test(priority=8)
	public void properaddingofcookiewillrendernextpage()
	{
		ck.addingthecookie();
	}
	
	@BeforeClass
	public void launchWebsite()
	{   
		System.setProperty("webdriver.chrome.driver","chromedriver");
		driver=new ChromeDriver();
		jsexecutor= (JavascriptExecutor)driver;	
		gridobj=new GridGateClass(jsexecutor,driver);
		frame=new FrameDungeonClass(jsexecutor,driver);
		drag=new DragAroundClass(driver,jsexecutor);
		pop=new PopUpWindowClass(driver,jsexecutor);
		ck=new CookiePageClass(driver,jsexecutor);
		driver.get("http://10.0.1.86/tatoc/basic/grid/gate");			
	}
	
	
	@AfterClass
	public void closeChrome()
	{   
		driver.quit();
	}

}
