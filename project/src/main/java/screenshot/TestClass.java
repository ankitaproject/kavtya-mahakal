package screenshot;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass {
	public static WebDriver driver;

	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test
	public void hyrtutorials() 
	{
		System.out.println("hyrtutorials");
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.findElement(By.xpath("//button[@id='newWindowBtn']")).click(); 
		WebElement one=driver.findElement(By.xpath("//img[@id='Header1_headerimg']"));
		String expected="hyr";
		String actual=driver.getTitle();
		Assert.assertEquals(actual, expected);
	}
	@Test
	public void facebook()
	{
		System.out.println("facebook");
		driver.get("https://www.facebook.com/login/");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("java");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123");
		driver.findElement(By.xpath("//button[@id='loginbutton']")).click();
		String expected="welcome";
		String actual=driver.getTitle();
		Assert.assertEquals(actual, expected, "if faile take screenshot");
	}
	@Test
	public void google()
	{
		System.out.println("google");
		driver.get("https://www.google.com/");

	}
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}
