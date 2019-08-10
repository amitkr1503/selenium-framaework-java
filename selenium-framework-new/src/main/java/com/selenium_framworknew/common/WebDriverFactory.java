package com.selenium_framworknew.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

	private static WebDriver dr;

	public static void createWebDriverInstance() {
		System.setProperty("webdriver.gecko.driver", "c:\\Users\\amit\\Selenium\\geckodriver.exe");
		dr = new FirefoxDriver();
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}

	public static WebDriver getDriver() {
		return dr;
	}

}
