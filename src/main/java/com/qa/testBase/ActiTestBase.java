package com.qa.testBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.pageLayer.ActiLoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActiTestBase {
	public static WebDriver driver;
	public ActiLoginPage lo;
	@BeforeMethod
	public void start()
	{
		String br="chrome";
		if(br.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(br.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else 
		{
			System.out.println("provide correct browser name");
		}
	
		driver.get("http://localhost/login.do");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		lo = new ActiLoginPage();
			
	}
	
       @AfterMethod
       public void tearDown()
       {
    	   driver.quit();
       }
	
}
