package com.selenium_framworknew.common;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;

public class FrameworkListeners implements IInvokedMethodListener {

	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub

		if(method.isTestMethod())

			WebDriverFactory.createWebDriverInstance();
	}

	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
		if(method.isTestMethod())
		WebDriverFactory.getDriver().quit();
	}

}
