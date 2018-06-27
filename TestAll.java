package com.qainfotech.js.TatocJS;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qait.testing.TatocTesting.DragAround;


public class TestAll {
	
	WebDriver driver;
	GridGateClass gridobj;
	FrameDungeonClass frame;
	JavascriptExecutor jsexecutor ;
	
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
		drag=new DragAround(driver);
		WebElement from,to;
		from=drag.getdragboxelement();
		to=drag.getdropboxelement();
		drag.draganddrop(from,from);
		driver.navigate().back();
	}

	@Test(priority=5)
	public void successfuldragwillgotonextpage()
	{
		drag=new DragAround(driver);
		WebElement from,to;
		from=drag.getdragboxelement();
		to=drag.getdropboxelement();
		drag.draganddrop(from,to);
		
	}

	
	@BeforeClass
	public void launchWebsite()
	{   
		System.setProperty("webdriver.chrome.driver","chromedriver");
		driver=new ChromeDriver();
		jsexecutor= (JavascriptExecutor)driver;	
		gridobj=new GridGateClass(jsexecutor,driver);
		frame=new FrameDungeonClass(jsexecutor,driver);
		driver.get("http://10.0.1.86/tatoc/basic/grid/gate");			
	}
	
	
	@AfterClass
	public void closeChrome()
	{   
		driver.quit();
	}

}
