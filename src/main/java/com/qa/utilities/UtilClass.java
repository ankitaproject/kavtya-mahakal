package com.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.qa.TestBase.TestBase;


public class UtilClass extends TestBase {

	
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
		String path="C:\\Users\\kiran\\git\\kavtya-mahakal\\src\\test\\resources\\data\\Book1.xlsx";
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
	public void brokenlinks(String tagname) throws Exception
	{
		List<WebElement> links = driver.findElements(By.tagName(tagname));

		int noOfBrokenLinks=0;
		List<WebElement> broken = null ;//to store link list

		for(int i=0;i<links.size();i++)
		{

			String url = links.get(i).getAttribute("href");
			if(url !=null && (! links.get(i).getAttribute("href").contains("javascript")))
			{
				URL link=new URL(url);
				HttpURLConnection httpconn=(HttpURLConnection)link.openConnection();
				httpconn.connect();
				int rescod=httpconn.getResponseCode();
				if(rescod>=400)
				{
					//					System.err.println(url+"==is broken");
					noOfBrokenLinks++;
					broken=links;
				}
				
			}

		}


		int currectlinks = links.size()-noOfBrokenLinks;
		System.out.println(" Total no of links=="+links.size());
		System.out.println("     Currect links=="+currectlinks);
		System.out.println("No of broken links=="+noOfBrokenLinks);

		if(broken!=null)
		{
			for(WebElement s:broken)
				System.out.println(s.getAttribute("href"));
		}
		else
		System.out.println("No broken link available");
	}
	
	public void loginpage() throws Exception
	{
		log.enterUsername("standard_user");
		log.enterPassword("secret_sauce");
		log.clickOnLoginButton();
	}

}
