package com.qa.PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.qa.TestBase.TestBase;

public class Login_swagLab extends TestBase {


	@FindBy(xpath="//input[@id='user-name']")
	private WebElement username ;
	@FindBy(xpath="//input[@id='password']")
	private WebElement password;
	@FindBy(xpath="//input[@id='login-button']")
	private WebElement loginButton ;

	public Login_swagLab()
	{
		PageFactory.initElements(driver,this);
	}
	public void enterUsername(String getuser)
	{
		username.sendKeys(getuser);
	}
	public void enterPassword(String getpass)
	{
		password.sendKeys(getpass);
	}
	public void clickOnLoginButton()
	{
		loginButton.click();
	}
	public void CheckTestCasestatus(String getactual,String getexpected)
	{
		Assert.assertEquals(getactual, getexpected);

	}
}