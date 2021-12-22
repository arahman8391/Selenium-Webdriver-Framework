package gov.dos.TouchWorks.Steps.Login_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import gov.dos.Allscripts.Utility.BaseTest;

public class All_Script_Okta_Home_Page {

	WebDriver driver;
	
	public All_Script_Okta_Home_Page(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By RemindMeLaterButton = By.xpath("//*[@id=\"remind-me-later-button\"]");
	By StartTouchWorksButton = By.xpath("//*[@id=\"main-content\"]/div/div[2]/ul[2]/li/a");
	By OktaSendPushButton = By.xpath("//*[@value=\"Send Push\"]");
	By DosTouchWorksDevButton = By.xpath("//*[@href=\"https://statedev.okta.com/home/template_wsfed/0oa6wlrh1tutSOQcA297/4263?fromHome=true\"]");
	
	public WebElement RemindMeLaterButton() 
	{
		BaseTest.WaitUntilClickable(driver, RemindMeLaterButton, 20);
		BaseTest.MoveToElement(driver, driver.findElement(RemindMeLaterButton));
		return driver.findElement(RemindMeLaterButton);
	}
	public WebElement StartTouchWorksButton() 
	{
		return driver.findElement(StartTouchWorksButton);
	}
	public WebElement OktaSendPushButton() 
	{
		return driver.findElement(OktaSendPushButton);
	}
	public WebElement DosTouchWorksDevButton() 
	{
		BaseTest.WaitUntilClickable(driver, DosTouchWorksDevButton, 120);
		BaseTest.MoveToElement(driver, driver.findElement(DosTouchWorksDevButton));
		return driver.findElement(DosTouchWorksDevButton);
	}
	
	
	
}
