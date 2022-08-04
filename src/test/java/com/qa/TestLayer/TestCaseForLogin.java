package com.qa.TestLayer;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.TestBase.TestBase;
import com.qa.utilities.ListenerClass;
@Listeners(ListenerClass.class)
public class TestCaseForLogin extends TestBase{
	@Test(priority=1)
	public void validUser_validPassword() throws Exception
	{
		String validUser = uc.parametrization("Sheet1", 1, 4);
		String validPass = uc.parametrization("Sheet1", 1, 5);
		System.out.println("User name=> "+validUser+"\n"+"Password =>"+validPass);
		log.enterUsername(validUser);
		Thread.sleep(2000);
		log.enterPassword(validPass);
		Thread.sleep(2000);
		log.clickOnLoginButton();
		Thread.sleep(2000);
		String actual=driver.getCurrentUrl();
		String expected="https://www.saucedemo.com/inventory.html";
		System.out.println("actual result=> "+actual+"\n"+"expected result =>"+expected);
		log.CheckTestCasestatus(actual,expected);	
	}
	@Test(priority=2)
	public void validUser_InvalidPassword() throws Exception
	{
		String validUser = uc.parametrization("Sheet1", 2, 4);
		String invalidPass = uc.parametrization("Sheet1", 2, 5);
		System.out.println("User name=> "+validUser+"\n"+"Password =>"+invalidPass);
		log.enterUsername(validUser);
		Thread.sleep(500);
		log.enterPassword(invalidPass);
		Thread.sleep(500);
		log.clickOnLoginButton();
		Thread.sleep(500);
		String actual="https://www.saucedemo.com/inventory.html";
		String expected="https://www.saucedemo.com/";
		System.out.println("actual result=> "+actual+"\n"+"expected result =>"+expected);
		log.CheckTestCasestatus(actual,expected);	

	}
	@Test(priority=3)
	public void InvalidUser_validPassword() throws Exception
	{
		String InvalidUser = uc.parametrization("Sheet1", 3, 4);
		String validPass = uc.parametrization("Sheet1", 3, 5);
		System.out.println("User name=> "+InvalidUser+"\n"+"Password =>"+validPass);
		log.enterUsername(InvalidUser);
		Thread.sleep(2000);
		log.enterPassword(validPass);
		Thread.sleep(2000);
		log.clickOnLoginButton();

		Thread.sleep(2000);
		String actual=driver.getCurrentUrl();
		String expected="https://www.saucedemo.com/";
		System.out.println("actual result=> "+actual+"\n"+"expected result =>"+expected);
		log.CheckTestCasestatus(actual,expected);

	}
	@Test(priority=4)
	public void InvalidUser_InvalidPassword() throws Exception
	{
		String InvalidUser = uc.parametrization("Sheet1", 4, 4);
		String inValidPass = uc.parametrization("Sheet1", 4, 5);
		System.out.println("User name=> "+InvalidUser+"\n"+"Password =>"+inValidPass);
		log.enterUsername(InvalidUser);
		Thread.sleep(2000);
		log.enterPassword(inValidPass);
		Thread.sleep(2000);
		log.clickOnLoginButton();
		Thread.sleep(2000);
		String actual=driver.getCurrentUrl();
		String expected="https://www.saucedemo.com/";
		System.out.println("actual result=> "+actual+"\n"+"expected result =>"+expected);
		log.CheckTestCasestatus(actual,expected);	
	}
}
