package com.qa.testCase;

import org.testng.annotations.Test;

import com.qa.testBase.ActiTestBase;

public class LoginTestCase extends ActiTestBase {

	
	@Test
	public void verifyLoginPage()
	{
	 lo.sendkeysUsername();
	}
   @Test
	public void verifyPasswordPage()
	{
	 lo.sendkeysPassword();
	}
	@Test
	public void verifyLoginbuttonPage()
	{
	 lo.clickLoginbutton();
	}
}
