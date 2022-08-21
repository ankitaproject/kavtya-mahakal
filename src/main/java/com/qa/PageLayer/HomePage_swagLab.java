package com.qa.PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.TestBase.TestBase;

public class HomePage_swagLab extends TestBase {
	@FindBy(xpath="//div[text()='Sauce Labs Backpack']")
	private WebElement SauceLabsBackpack ;
	@FindBy(xpath="//div[text()='Sauce Labs Bike Light']")
	private WebElement SauceLabsBikeLight;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")
	private WebElement Cart_LabsBackpack ;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']")
	private WebElement  Cart_LabsBikeLight;
	@FindBy(xpath="//button[@id='back-to-products']")
	private WebElement backToProduct;
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	private WebElement cart;
	@FindBy(xpath="//button[@id='checkout']")
	private WebElement chechout;
	@FindBy(xpath="(//button[contains(@class,'btn btn')])[6]")
	private WebElement bikeLightAddcart;
	@FindBy(xpath="//h2[@class='complete-header']")
	private WebElement Orderconfirm;
	public HomePage_swagLab()
	{
		PageFactory.initElements(driver,this);
	}


	public void clickOn_SauceLabsBackpack()
	{
		SauceLabsBackpack.click();;
	}
	public void clickOn_SauceLabsBikeLight( )
	{
		SauceLabsBikeLight.click();
	}
	public void clickOnCart_backToProduct()
	{
		backToProduct.click();
	}
	public void clickOnCart_LabsBackpack()
	{
		Cart_LabsBackpack.click();
	}
	public void clickOnCart_LabsBikeLight()
	{
		Cart_LabsBikeLight.click();
	}
	public void clickOnCart()
	{
		cart.click();
	}
	public void clickOnchechout()
	{
		chechout.click();
	}
	public void clickOn_BikeLight_Addcart_button()
	{
		bikeLightAddcart.click();
	}
	public String orderConfirm_Text()
	{
		String oct = Orderconfirm.getText();
		return oct;
	}

}
