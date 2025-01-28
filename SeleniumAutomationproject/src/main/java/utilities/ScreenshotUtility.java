package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {
	
	public void getScreenshot(WebDriver driver, String failedTestcases) throws IOException
	{
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File screenShot = screenshot.getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");
		
		if (!f1.exists()) {
			f1.mkdirs();
		}
		
		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestcases + timeStamp
				+ ".png";
		File finalDestination = new File(destination);
		FileHandler.copy(screenShot, finalDestination);
	}
	}


