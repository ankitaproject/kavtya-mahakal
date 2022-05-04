package com.qa.pageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testBase.ActiTestBase;

public class ActiWorkSchedulePage extends ActiTestBase {
 
	public ActiWorkSchedulePage()
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//img[@align='middle']")
	private WebElement aprildropd;
	@FindBy(xpath="//tbody/tr[34]/td[2]")
	private WebElement selectaug;
	@FindBy(xpath="(//span[@class='calendarCurrentMonthWeekendDay'])[2]")
	private WebElement clikdate;
	@FindBy(xpath="(//span[@class='calendarCurrentMonthWorkingDay'])[67]")
	private WebElement scrolldesti;
	public void clickAprilDropDown()
	{
		aprildropd.click();
	}
	public void selectmonth()
	{
		selectaug.click();
	}
	public void clickdate()
	{
		clikdate.click();
	}
}
