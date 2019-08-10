package com.selenium_frameworknew.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.selenium_framworknew.common.WebDriverFactory;
import com.selenium_frameworknew.pages.AddUserPage;
import com.selenium_frameworknew.pages.AdminPage;

public class AddUserPage {
@FindBy (id="systemUser_employeeName_empName") private WebElement empName;

@FindBy (id="systemUser_userName") private WebElement userName;

@FindBy (id="systemUser_password") private WebElement password;

@FindBy (id="systemUser_confirmPassword") private WebElement confirmPassword;

@FindBy (id="btnSave") private WebElement btnSave;

public AddUserPage()
{
	PageFactory.initElements(WebDriverFactory.getDriver(), this);
	
}

public AdminPage adduser(String strempName,String struserName,String strPassword,String strconfirmPassword)
{
	empName.sendKeys(strempName);
	userName.sendKeys(struserName);
	password.sendKeys(strPassword);
	confirmPassword.sendKeys(strconfirmPassword);
	
	return new AdminPage();
	
}

public AddUserPage isPageLoaded()
{
	Assert.assertTrue(empName.isDisplayed(),"Employee name Field not loaded");
	Assert.assertTrue(userName.isDisplayed(), "UserName field not loaded");
	Assert.assertTrue(password.isDisplayed(), "Password field not loaded");
	Assert.assertTrue(btnSave.isDisplayed(), "Save button field not loaded");
	
	return this;
	

}



}
