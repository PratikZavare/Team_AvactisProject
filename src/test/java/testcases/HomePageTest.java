package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseClass;

public class HomePageTest extends BaseClass {
/*
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser)
	{
		launchApp(browser);
	}
*/
	@BeforeMethod
	public void setup()
	{
		launchApp();
	}
	
  @Test
  public void f() {
	  System.out.println("app open");
  }
  
  
  @AfterMethod
  public void tearDown()
  {
//	  driver.close();
  }
  
}
