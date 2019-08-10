package com.selenium_frameworknew.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.selenium_framworknew.common.WebDriverFactory;
import com.selenium_frameworknew.pages.AdminPage;
import com.selenium_frameworknew.pages.AddUserPage;
import com.selenium_frameworknew.pages.HomePage;

public class HomePage {
	
	@FindBy (id="welcome") private WebElement welComeText;
	
	@FindBy(id = "menu_admin_viewAdminModule") private WebElement adminTab;
	
	public HomePage()
	{
		PageFactory.initElements(WebDriverFactory.getDriver(), this);
	}

	public HomePage verifyAdminLink()
	{
		System.out.println(welComeText.isDisplayed());
		Assert.assertEquals(welComeText.isDisplayed(),true);
		//Assert.assertEquals(welComeText.getText(), "Welcome Admin");
		
		return this;
	}

	public AdminPage navigateToAdminPage()
	{
		adminTab.click();
		
		return new AdminPage();
	}
	
	public HomePage isPageLoaded()
	{
		//Assert.assertTrue(welComeText.getText(), "WelCome Text not loaded");		
		Assert.assertTrue(adminTab.isDisplayed(), "Admin Page not displayed");
		return this;
				
	}
	
}
