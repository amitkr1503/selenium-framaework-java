package com.orange_hrm.test;

import org.testng.annotations.Test;

import com.selenium_framworknew.common.AbstractSelenium;
import com.selenium_frameworknew.pages.LoginPage;

public class LoginTest extends AbstractSelenium {

	@Test(dataProvider = "ExcelData")
	public void verifyAdminLoginSuccessfully(String userName, String userPassword) {
		LoginPage lp = new LoginPage();

		lp.navigateToLoginPage().login(userName, userPassword).verifyAdminLink();
	}

	@Test(dataProvider = "ExcelData")
	public void verifyAdminLoginSuccessfullyOne(String userName, String userPassword) {
		LoginPage lp = new LoginPage();

		lp.navigateToLoginPage().login(userName, userPassword).verifyAdminLink();
	}

}
