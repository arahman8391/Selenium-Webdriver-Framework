package gov.dos.TouchWorks.PageFactory.Login_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class All_Script_Okta_Login_Page {

WebDriver driver;
	
	public All_Script_Okta_Login_Page(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By UserNameField = By.xpath("//*[@id=\"okta-signin-username\"]");
	By PasswordField = By.xpath("//*[@id=\"okta-signin-password\"]");
	By SignInButton = By.xpath("//*[@id=\"okta-signin-submit\"]");
	
	public WebElement UserNameField() 
	{
		return driver.findElement(UserNameField);
	}
	public WebElement PasswordField() 
	{
		return driver.findElement(PasswordField);
	}
	public WebElement SignInButton() 
	{
		return driver.findElement(SignInButton);
	}
	
}
