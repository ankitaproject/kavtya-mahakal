package com.qa.pageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testBase.ActiTestBase;


public class ActiLoginPage extends ActiTestBase {
      public ActiLoginPage()
      {
    	  PageFactory.initElements(driver, this);
      }
      @FindBy(xpath="//input[@id='username']")
      private WebElement username;
      
      @FindBy(xpath="(//input[@type='password'])[1]")
      private WebElement password;
      
      @FindBy(xpath="//tbody/tr[1]/td[3]/a[1]/div[1]")
      private WebElement loginbutton;
      
      public void sendkeysUsername()
      {
    	  username.sendKeys("admin");
      }
      public void sendkeysPassword()
      {
    	  password.sendKeys("manager");
      }
      public void clickLoginbutton()
      {
    	  loginbutton.click();
      }
}//
