package dailyPractise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearch {
public static void main(String[] args) throws Exception {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.google.com/");
	driver.findElement(By.xpath("(//input)[1]")).sendKeys("car");
	Thread.sleep(3000);
	List<WebElement> all = driver.findElements(By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[2]"));
	for(int i=0;i<all.size();i++)
	{
		
		System.out.println(all.get(i).getText());
		if(all.get(i).getText().contains("cars24"))
		{
		 all.get(i).click();
		
			break;
		}
		Thread.sleep(5000);
	}
	    
	
	
	
	driver.quit();
}
}
