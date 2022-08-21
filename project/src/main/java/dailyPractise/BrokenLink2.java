package dailyPractise;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLink2 {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.javatpoint.com/traceability-matrix");
		List<WebElement> links=driver.findElements(By.tagName("a"));
		List<WebElement> links1 = driver.findElements(By.tagName("img"));
		System.out.println(links.size());
		System.out.println(links1.size());
		links.addAll(links1);
		System.out.println(links.size());
		for(int i=0;i<links.size();i++)
		{
			//		System.out.println(links.get(i).getText());
			String url = links.get(i).getAttribute("href");
			if(url !=null &&(! links.get(i).getAttribute("href").contains("javascript")))
			{
				URL link=new URL(url);
				HttpURLConnection httpconn=(HttpURLConnection) link.openConnection();
				httpconn.connect();
				int rescod=httpconn.getResponseCode();
				if(rescod>=400)
				{
					System.err.println(url+"--is broken link");
				}
				else
				{
					System.out.println(url+"--is not broken link");
				}
			} 
		}
		driver.quit();
	}
}
