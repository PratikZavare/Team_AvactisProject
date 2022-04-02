package testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass;
import dataprovider.DataProviders;
import pageobjects.SignInPage;


public class SignInPageTest extends BaseClass {

	WebDriver driver = null;	

	@BeforeClass
	public void setup()
	{
		driver = launchApp();
	}

	@Test(dataProvider ="signdata",dataProviderClass = DataProviders.class)
	public void test1(String emailID, String pwd)
	{	
		SignInPage signup = PageFactory.initElements(driver,SignInPage.class);
		
		signup.signIn_Tab();
		signup.element_to_email(emailID);
		signup.element_to_passwd(pwd);
		signup.checkBox();
		signup.signInButton();
		
		String actualMsg  = driver.findElement(By.className("note note-danger")).toString();
		String expectedMsg = driver.findElement(By.className("note note-danger")).getText().toString();
		if(emailID.equalsIgnoreCase(null) || emailID.equalsIgnoreCase("") || pwd.equalsIgnoreCase(null) || pwd.equalsIgnoreCase(""))
		{
			System.out.println(actualMsg);
			
			
		}
		
		
		
		
		
	}


	@AfterMethod
	public void tearDown()
	{

	}

}
