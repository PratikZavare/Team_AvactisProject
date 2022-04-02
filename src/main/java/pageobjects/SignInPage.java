package pageobjects;

import static org.testng.Assert.assertFalse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SignInPage {

	 WebDriver driver = null;

	public SignInPage(WebDriver driver){
	this.driver=driver;
	}

	@FindBy(xpath="/html/body/div[1]/div/div/div[2]/div/ul/li[1]/span/a")
	WebElement sign_in;
	
	@FindBy (id="account_sign_in_form_email_id")
	WebElement emailId;
 
	@FindBy (id="account_sign_in_form_passwd_id")
	WebElement password;
	
	@FindBy (xpath="/html/body/div[4]/div/div/div[2]/div/div/div[2]/form/div[3]/div/a")
	WebElement forgotPassword;

	@FindBy (xpath="//input[@name='remember_me']")
	WebElement checkbox;

	@FindBy (xpath="//input[@value='Sign In']")
	 WebElement signInbtn;
	
	@FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div/ul/li[1]/span/a")
	WebElement tabsign;

	public void signIn_Tab()
	{
		sign_in.click();
	}
	
	public void element_to_email(String email)
	{
		emailId.sendKeys(email);
	}
	

	public void element_to_passwd(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void forgotPassword()
	{
		forgotPassword.click();
	}
	
	public void checkBox()
	{
		if(checkbox.isSelected())
		{
			checkbox.click();			//uncheck_it
			assertFalse(checkbox.isSelected());
		}
	}
	
	public void signInButton()
	{
		signInbtn.click();
	}

}
