package base;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ScreenshotUtility;

public class ProjectBase {

	public WebDriver driver;
	
	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void initializeBrowser(String browser) throws Exception {
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.get("https://groceryapp.uniqassosiates.com/admin/login");
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.get("https://groceryapp.uniqassosiates.com/admin/login");
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			driver.get("https://groceryapp.uniqassosiates.com/admin/login");
			driver.manage().window().maximize();
		} else {
			throw new Exception("invalid browser");
		}
	}

	public void driverQuit(ITestResult iTestResult) throws IOException
	{
	if(iTestResult.getStatus()==ITestResult.FAILURE)
	{
		ScreenshotUtility screenShot=new ScreenshotUtility();
		screenShot.getScreenshot(driver, iTestResult.getName());
	}
		//driver.quit();
		
	}
}
