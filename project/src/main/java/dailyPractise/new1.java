package dailyPractise;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class new1 {
public static void main(String[] args) throws Exception {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.amazon.in/ref=nav_logo");
	Thread.sleep(5000);
	
	WebElement ele=driver.findElement(By.xpath("(//a[contains(@class,'a-link-normal see-more truncate-1line')])[12]"));
	JavascriptExecutor js=((JavascriptExecutor)driver);
    js.executeScript("arguments[0].scrollIntoView();",ele);
    Thread.sleep(5000);

    File src1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    File src2=new File("C:\\Users\\kiran\\eclipse-workspace\\project\\no1.png");
    FileHandler.copy(src1, src2);
 
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(@class,'a-link-normal see-more truncate-1line')])[12]")));
    
    driver.findElement(By.xpath("(//a[contains(@class,'a-link-normal see-more truncate-1line')])[12]")).click();
//    WebDriverWait wait=new WebDriverWait(driver,20);
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(@class,'a-link-normal see-more truncate-1line')])[12]")));

 
    
    driver.quit();





}
}
