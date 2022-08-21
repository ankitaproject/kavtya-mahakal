package dailyPractise;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowORtab1 {
public static void main(String[] args) throws Exception {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
	
	
    driver.findElement(By.xpath("//button[@id='newWindowBtn']")).click();
    Thread.sleep(5000);
    
    Set<String> handl = driver.getWindowHandles();
    Iterator<String> itr = handl.iterator();
    String wind1=itr.next();
    String wind2 = itr.next();
    
    System.out.println(driver.getTitle());
    driver.switchTo().window(wind2);
    System.out.println(driver.getTitle());
    driver.close();
    
    Thread.sleep(2000);
    driver.switchTo().window(wind1);
    System.out.println(driver.getTitle());













driver.quit();
}
}
