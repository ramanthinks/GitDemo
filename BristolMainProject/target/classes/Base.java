package resources;

import java.io.File;


import org.apache.commons.io.FileUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public WebDriver driver;
	public Properties prop;

		public WebDriver initializeDriver() throws IOException{
			
			// System.getProperty("user.dir")	
			prop=new Properties();
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
			prop.load(fis);
			
			//String browserName=System.getProperty("browser");
			String browserName=prop.getProperty("browser");
			if(browserName.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver","C:\\Work\\chromedriver_win32 83\\chromedriver.exe");	 
				driver=new ChromeDriver();

			}
			else if (browserName.equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver","C:\\Work\\geckodriver.exe");
				driver=new FirefoxDriver();

			}
			//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			driver.manage().window().maximize();
			return driver;
			
		}
		
		public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException{
			TakesScreenshot ts= (TakesScreenshot) driver;	
			File source= ts.getScreenshotAs(OutputType.FILE);	
			String destinationFile = System.getProperty("user.dir")+"\\reports\\"+ testCaseName+".png"; 				
			FileUtils.copyFile(source,new File(destinationFile));	
			return destinationFile;
		}
			
		

}
