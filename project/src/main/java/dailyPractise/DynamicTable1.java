package dailyPractise;

import java.time.Duration;
import java.util.List;

import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicTable1 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://chercher.tech/practice/dynamic-table");
		
		List<WebElement> all = driver.findElements(By.xpath("//table[contains(@id,'table')]"));
	
		for(WebElement s:all)
		{
			System.out.println(s.getText());
		}
		System.out.println("===========================================");
		List<WebElement> row1 = driver.findElements(By.xpath("//table//tr[1]"));
		for(WebElement s1:row1)
		{
			System.out.println(s1.getText());
		} 
		System.out.println("===============================================");
		List<WebElement> col1 = driver.findElements(By.xpath("//table//td[3]"));
		for(WebElement s2:col1)
		{
			System.out.println(s2.getText());
		}
		System.out.println("================================================");
		WebElement single1=driver.findElement(By.xpath("//table//tr[2]//td[2]"));
		System.out.println(single1.getText());
		driver.quit();
	}

}
