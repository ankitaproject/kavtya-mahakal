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

public class BrokenLink1 {
public static void main(String[] args) throws IOException,MalformedURLException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.javatpoint.com/traceability-matrix");
	List<WebElement> links = driver.findElements(By.tagName("a"));
	System.out.println(links.size());
	for(int i=0;i<links.size();i++)
	{
		WebElement ele = links.get(i);
		String url = ele.getAttribute("href");
		URL link=new URL(url);
		HttpURLConnection httpconn = (HttpURLConnection) link.openConnection();
	httpconn.connect();
	int rescod=httpconn.getResponseCode();
	if(rescod>=400)
	{
		System.err.println(url+"-- broken link");
	}
	else
	{
		System.out.println(url+"-- not broken link");
	}
	}
	driver.quit();
}
}
