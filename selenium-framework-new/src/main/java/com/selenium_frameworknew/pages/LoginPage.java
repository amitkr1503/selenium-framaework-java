package com.selenium_frameworknew.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.selenium_frameworknew.pages.HomePage;
import com.selenium_frameworknew.pages.LoginPage;
import com.selenium_framworknew.common.WebDriverFactory;

public class LoginPage {
	
	@FindBy (id="txtUsername") private WebElement userName;
	@FindBy(id="txtPassword")  private WebElement password;
	@FindBy(xpath=("//input[@id='btnLogin']")) private WebElement btnSubmit;

	private WebDriverWait wait;
	
	public LoginPage()
	{
		PageFactory.initElements(WebDriverFactory.getDriver(), this);
		navigateToLoginPage();
		
		//wait= new WebDriverWait(WebDriverFactory.getDriver(),3);
	}
		
	public LoginPage navigateToLoginPage()
	{
		WebDriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/");
		return this;
		
	}
	
	public HomePage login(String strUserName,String strPassword)
	{
		userName.sendKeys(strUserName);
		password.sendKeys(strPassword);
		btnSubmit.click();
		
		return new HomePage().isPageLoaded();
		
	}
	
	public LoginPage ispageLoaded()
	{
		wait.until(ExpectedConditions.visibilityOf(userName));
		wait.until(ExpectedConditions.visibilityOf(password));
		wait.until(ExpectedConditions.visibilityOf(btnSubmit)); 
		return this;
	}

}

