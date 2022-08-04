package com.qa.PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.TestBase.TestBase;

public class CheckoutPage extends TestBase {
	@FindBy(xpath="//input[@id='first-name']")  //////a
	private WebElement firstName ;
	@FindBy(xpath="//input[@id='last-name']")
	private WebElement lastName;
	@FindBy(xpath="//input[@id='postal-code']")
	private WebElement zipCode ;
	@FindBy(xpath="//input[@id='continue']")
	private WebElement continueButton;
	@FindBy(xpath="//button[@id='cancel']")
	private WebElement cancelButton;
	@FindBy(xpath="//button[@id='checkout']")
	private WebElement checkout;
	@FindBy(xpath="//button[@id='finish']")
	private WebElement finish;
	public CheckoutPage()
	{
		PageFactory.initElements(driver,this);
	}

	public void enterFirstName(String ef)
	{
		firstName.sendKeys(ef);
	}
	public void enterLastName(String el)
	{
		lastName.sendKeys(el);
	}
	public void enterzipCode(String ez)
	{
		zipCode.sendKeys(ez);
	}
	public void clickOnContinueButton()
	{
		continueButton.click();
	}
	public void clickOncancelButton()
	{
		cancelButton.click();
	}
	public void clickOnFinishButton()
	{
		finish.click();
	}
	public void clickOnCheckout()
	{
		checkout.click();
	}
}
