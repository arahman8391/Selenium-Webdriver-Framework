package gov.dos.TouchWorks.PageFactory.Main_Menu_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Touch_Works_Main_Menu_Bar {

	WebDriver driver;
	
	public Touch_Works_Main_Menu_Bar(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By SignOutButton = By.xpath("//*[@id=\"headerSignOutIcon\"]");
	By SignOutConfirmationButton = By.xpath("//*[@id=\"button_7_Yes\"]");
	By SignInButton = By.xpath("/html/body/div/div[1]/div[2]/div[3]/a");
	
	public WebElement SignOutButton() 
	{
		return driver.findElement(SignOutButton);
	}
	public WebElement SignOutConfirmationButton() 
	{
		return driver.findElement(SignOutConfirmationButton);
	}
	public WebElement SignInButton() 
	{
		return driver.findElement(SignInButton);
	}
	
	
	By Schedule = By.xpath("//*[@id=\"Schedule_AE\"]/div/header/div[2]/div[1]");
	By PtRegAndAppts = By.xpath("//*[@id=\"PtReg&Appts_AE\"]");
	By Inbox = By.xpath("//*[@id=\"Inbox_AE\"]");
	By DocTaks = By.xpath("//*[@id=\"DocTasks_AE\"]/div/header/div[2]/div[1]");
	By Worklist = By.xpath("//*[@id=\"Worklist_AE\"]/div/header/div[2]/div[1]");
	By Calls = By.xpath("//*[@id=\"Calls_AE\"]/div/header/div[2]/div[1]");
	By PtLists = By.xpath("//*[@id=\"PtLists_AE\"]/div/header/div[2]/div[1]");
	By SiteMap = By.xpath("//*[@id=\"SiteMap_AE\"]/div/header/div[2]/div[1]");
	
	public WebElement Schedule() 
	{
		return driver.findElement(Schedule);
	}
	public WebElement PtRegAndAppts() 
	{
		return driver.findElement(PtRegAndAppts);
	}
	public WebElement Inbox() 
	{
		return driver.findElement(Inbox);
	}
	public WebElement DocTaks() 
	{
		return driver.findElement(DocTaks);
	}
	public WebElement Worklist() 
	{
		return driver.findElement(Worklist);
	}
	public WebElement Calls() 
	{
		return driver.findElement(Calls);
	}
	public WebElement PtLists() 
	{
		return driver.findElement(PtLists);
	}
	public WebElement SiteMap() 
	{
		return driver.findElement(SiteMap);
	}
}
