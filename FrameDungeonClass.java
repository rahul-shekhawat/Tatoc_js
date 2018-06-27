package com.qainfotech.js.TatocJS;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FrameDungeonClass {
	
	WebDriver driver;
	JavascriptExecutor js;
	
	public FrameDungeonClass(JavascriptExecutor js,WebDriver driver)
	{
		this.driver=driver;
		this.js=js;
	}
	
	public String getBox1color()
	{   
		String color1;
		String script="return document.getElementById('main').contentWindow.document.getElementById('answer').getAttribute('class')";
		color1= (String) js.executeScript(script);
		return color1;
	}
	
	public String getBox2color()
	{   
		String color2;
		String script="return document.getElementById('main').contentWindow.document.getElementById('child').contentWindow.document.getElementById('answer').getAttribute('class')";
		color2= (String) js.executeScript(script);
		return color2;
	}
	
	public void whentwocolorsmatch()
	{
		String box1color=getBox1color();
		String box2color=getBox2color();
		
		System.out.println(box1color);
		System.out.println(box2color);
		
		Boolean status=true;
		
		while(status)
		{
			if(box1color.equals(box2color))
			{
				status=false;
			}
			else
			{
				js.executeScript("document.getElementById('main').contentWindow.document.getElementsByTagName('a')[0].click();");
				box2color=getBox2color();
			}   
		}
		
		js.executeScript("document.getElementById('main').contentWindow.document.getElementsByTagName('a')[1].click();");
		
		Assert.assertEquals(driver.getCurrentUrl(),"http://10.0.1.86/tatoc/basic/drag");
	
	}

}
