package base;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	
	@BeforeSuite
	public void loadConfig()
	{
		prop = new Properties();
		System.out.println("super constructor invoked");
		try {
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/Configuration/config.properties");
			prop.load(ip);
			}
		catch (IOException e) {		//parent exception of "FileNotFoundException"
				e.printStackTrace();
			}
		
	}
	
	public WebDriver launchApp()
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("FireFox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
		driver.get(prop.getProperty("url"));
		return driver;
		
	}
	
	@AfterSuite
	public void endTest()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.quit();	
	}

}
