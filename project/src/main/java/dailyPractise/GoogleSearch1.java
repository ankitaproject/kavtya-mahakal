package dailyPractise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearch1 {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.google.com/");
	driver.findElement(By.tagName("input")).sendKeys("java");
	List<WebElement> data = driver.findElements(By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[2]/div[2]/div[2]/ul[1]"));
	for(int i=0;i<data.size();i++)
	{
		if(data.get(i).getText().contains("java"))
		{System.out.println(data.get(i).getText());
			data.get(i).click();
			break;
		}
	}
	
	Thread.sleep(5000);
	
	driver.quit();
}
}
