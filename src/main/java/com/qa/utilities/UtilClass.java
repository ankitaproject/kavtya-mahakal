package com.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.TestBase.TestBase;


public class UtilClass extends TestBase {

	public UtilClass()
	{
		PageFactory.initElements(driver, this);
	}
	JavascriptExecutor js=(JavascriptExecutor)driver;

	public void explicit(WebElement element)
	{
		WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(element));
	}
	public void screenshot() throws Exception
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("D:\\EclipseDemo2\\SwagLabs\\ss\\sl"+System.currentTimeMillis()+".png");
		FileHandler.copy(src, dest);
	}
	public String parametrization(String  sheetname,int row,int column) throws Exception  
	{ 
		String path="C:\\Users\\ankit\\OneDrive\\Desktop\\Book1.xlsx";
		FileInputStream fis=new FileInputStream(path);
		XSSFWorkbook x= new XSSFWorkbook(fis);
		XSSFSheet sheet = x.getSheet(sheetname);
		String data = sheet.getRow(row).getCell(column).getStringCellValue();
		return data;


	}
	public Object scrolldownByElement(WebElement ele)
	{
		Object sde = js.executeScript("arguments[0].scrollIntoview();", ele);
		return sde;
	}
	public Object scrolldownByOffset(int x,int y)
	{
		Object sdo = js.executeScript("scroll("+x+","+y+")");
		return sdo;
	}
//	public void logincode() throws Exception
//	{
//		//				String validUser = uc.parametrization("Sheet1", 1, 4);
//		//				String validPass = uc.parametrization("Sheet1", 1, 5);
//		//				System.out.println("User name=> "+validUser+"\n"+"Password =>"+validPass);
//		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
//		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
//		driver.findElement(By.xpath("//input[@id='login-button']")).click();
//	}
}
