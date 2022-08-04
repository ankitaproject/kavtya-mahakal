package com.qa.TestLayer;

import org.testng.annotations.Test;

import com.qa.TestBase.TestBase;
import com.qa.utilities.UtilClass;

public class testCasesForPlacingOrder extends TestBase {

	@Test
	public void sauceLabBagPackOrder() throws Exception{
		//uc.logincode();
		home.clickOnCart_LabsBackpack();
		home.clickOnCart();
		chk.clickOnCheckout();
		String fn=uc.parametrization("Sheet1", 1, 8);

		String ln=uc.parametrization("Sheet1", 1, 9);
		String code=uc.parametrization("Sheet1", 1, 10);
		System.out.println(fn+ln+code);
		chk.enterFirstName(fn);
		chk.enterLastName(ln);
		chk.enterzipCode(code);
		chk.clickOnContinueButton();
		uc.scrolldownByOffset(0, 550);
		chk.clickOnFinishButton();


	}

}
