package gov.dos.TouchWorks.PageFactory.Inbox_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Teams_Screen {
	
	WebDriver driver;
	
	public Teams_Screen(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By TeamsIFrame = By.xpath("//*[@id=\"dialog0\"]/iframe");
	
	public WebElement TeamsIFrame() 
	{
		return driver.findElement(TeamsIFrame);
	}
	
	By TeamsSearchField = By.xpath("//*[@id=\"inSearch\"]");
	By TeamsSearchButton = By.xpath("//*[@id=\"btnSearch1\"]");
	By TeamsSearchResult = By.xpath("//*[@id=\"trRow\"]");
	By TeamsSearchResultParent = By.xpath("//*[@id=\"divSearchResults\"]/div[2]/table/tbody");
	By TeamsOkButton = By.xpath("//*[@id=\"btnOk\"]");
	
	public WebElement TeamsSearchField() 
	{
		return driver.findElement(TeamsSearchField);
	}
	public WebElement TeamsSearchButton() 
	{
		return driver.findElement(TeamsSearchButton);
	}
	public WebElement TeamsSearchResult() 
	{
		return driver.findElement(TeamsSearchResult);
	}
	public WebElement TeamsSearchResultParent() 
	{
		return driver.findElement(TeamsSearchResultParent);
	}
	public WebElement TeamsOkButton() 
	{
		return driver.findElement(TeamsOkButton);
	}
}
