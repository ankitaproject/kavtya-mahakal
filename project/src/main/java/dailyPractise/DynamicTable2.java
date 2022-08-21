package dailyPractise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicTable2 {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://seleniumpractise.blogspot.com/2021/08");
	Thread.sleep(5);
	List<WebElement> all = driver.findElements(By.xpath("//table[@id='customers']"));
     System.out.println(all.size());
     for(int i=0;i<all.size();i++)
     {
    	 String data=all.get(i).getText();
    	 System.out.println(data);
     }
     System.out.println("============================================");
     List<WebElement>row1=driver.findElements(By.xpath("//table[@id='customers']//tr[1]"));
     for(int i=0;i<row1.size();i++)
     {
    	 String data1=row1.get(i).getText();
    	 System.out.println(data1);
     }
     System.out.println("=============================================");
     List<WebElement>row2=driver.findElements(By.xpath("//table[@id='customers']//tr[2]"));
     for(int i=0;i<row2.size();i++)
     {
    	 String data2=row2.get(i).getText();
     System.out.println(data2);
     }
     System.out.println("================================================");
     List<WebElement> column = driver.findElements(By.xpath("//table[@id='customers']//tr//td[5]"));
     for(int i=0;i<column.size();i++)
     {
    	 String data3=column.get(i).getText();
     System.out.println(data3);
     }
     System.out.println("==============================================");
     WebElement data4=driver.findElement(By.xpath("//table[@id='customers']//tr[5]//td[2]"));
     System.out.println(data4.getText());
     
     
     
     
     
     
     driver.quit();
     
}
}
