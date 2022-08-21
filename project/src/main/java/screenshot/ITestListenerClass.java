package screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerClass extends TestClass implements ITestListener {

	public void onTestStart(ITestResult result) {
	System.out.println("successfully execute");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("listener is execute");
		
			
			File ts=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(ts, new File("C:\\Users\\kiran\\eclipse-workspace\\project\\srceen\\"+System.currentTimeMillis()+".png"));
			} catch (IOException e) {
			
				e.printStackTrace();
			}
		

	}

	public void onFinish(ITestContext context) {
		System.out.println("successfully finish");
	}

}
