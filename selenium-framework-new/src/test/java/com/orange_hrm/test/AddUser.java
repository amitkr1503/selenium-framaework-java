package com.orange_hrm.test;

import org.testng.annotations.Test;

import com.selenium_framworknew.common.AbstractSelenium;
import com.selenium_frameworknew.pages.LoginPage;

public class AddUser extends AbstractSelenium 
{
	@Test
	public void VerifyAddUserSuccessFul()
	{
		LoginPage lp= new LoginPage();
		lp.login("admin", "admin123")
				.verifyAdminLink()
						.navigateToAdminPage()
							.navigateToAddUserPage().adduser("user2", "user2", "user2", "user2")
								.verifyUserInAddUserTable();
		
	}
}
