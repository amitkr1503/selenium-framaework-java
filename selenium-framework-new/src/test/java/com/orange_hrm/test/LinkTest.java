package com.orange_hrm.test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LinkTest {
	
	@Test
	public static void verifyLink() {
		
		System.setProperty("webdriver.gecko.driver", "/Users/amit/Selenium/geckodriver.exe");
		WebDriver dr = new FirefoxDriver();
		dr.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		dr.findElement(By.xpath("//img[@alt='LinkedIn OrangeHRM group']")).click();
		dr.findElement(By.xpath("//img[@alt='OrangeHRM on Facebook']")).click();
		dr.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']")).click();
		dr.findElement(By.xpath("//img[@alt='OrangeHRM on youtube']")).click();
		System.out.println(dr.getTitle());
		
		String ohandle = dr.getWindowHandle();
		Set<String> allHandles= dr.getWindowHandles();
		Iterator<String>  itr= allHandles.iterator();
		
		while(itr.hasNext())
		{
			String currentHandle = itr.next();
			if(!ohandle.contentEquals(currentHandle))
			{
				dr.switchTo().window(currentHandle);
				System.out.println(dr.getTitle());
				dr.close();
			
			}
			
		dr.switchTo().window(ohandle);
		}
		
	}
	

}
