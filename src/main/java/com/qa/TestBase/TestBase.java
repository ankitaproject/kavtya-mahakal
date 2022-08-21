package com.qa.TestBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.PageLayer.CheckoutPage;
import com.qa.PageLayer.HomePage_swagLab;
import com.qa.PageLayer.Login_swagLab;
import com.qa.utilities.ListenerClass;
import com.qa.utilities.UtilClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Login_swagLab log;
	public UtilClass uc;
	public ListenerClass lc;
	public HomePage_swagLab home;
	public CheckoutPage chk;
	
	@BeforeMethod
	public void setup()
	{
		String browser ="chrome";

		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get("https://www.saucedemo.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().deleteAllCookies();
			log= new Login_swagLab();
			uc=new UtilClass();
			lc=new ListenerClass();
			home=new HomePage_swagLab();
			chk=new CheckoutPage();
			
		}
	}
	@AfterMethod
	public void teardown() throws Exception
	{

		Thread.sleep(2000);
		driver.quit();

	}
}
