package com.qa.TestLayer;

import org.testng.annotations.Test;

import com.qa.TestBase.TestBase;

public class TestForBrokenLinks extends TestBase {
@Test
public void loginPageBrokenLinks() throws Exception
{
	uc.brokenlinks("a");
}
@Test
public void productPageBrokenLinks() throws Exception
{
	uc.loginpage();
	uc.brokenlinks("a");
}
@Test
public void cartPageBrokenLinks() throws Exception
{
	uc.loginpage();
	home.clickOnCart();
	uc.brokenlinks("a");
}


}
