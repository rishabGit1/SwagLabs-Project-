package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import base.TestBase2;

public class Failed_Tests_Screenshot extends TestBase2

{

	public static String getDate()
	{
		return new SimpleDateFormat("dd-MM-YYYY ss-mm-HH").format(new Date());
		
	}
	public static void sc(String nameofMetod) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\risha\\eclipse-workspace\\Selenium_Framework_Practise\\Screenshot\\"+nameofMetod+"--"+getDate()+".jpeg");
		FileHandler.copy(source, dest);
		
	}
	
}
