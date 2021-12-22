package gov.dos.TouchWorks.PageFactory.Schedule_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import gov.dos.Allscripts.Utility.BaseTest;

public class Touch_Works_Schedule_Customize_Screen {

	WebDriver driver;
	
	public Touch_Works_Schedule_Customize_Screen(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By SwitchToScheduleCustomizeFrame = By.xpath("//*[@id=\"dialog0\"]/iframe");
	By ScheduleCustomizeScreen = By.xpath("/html/body/div[*]");
	By DefaultProviderDropDown = By.xpath("//*[@id=\"selProvider\"]");
	By ScheduleContentDropDown = By.xpath("//*[@id=\"selContents\"]");
	By OkButton = By.xpath("//*[@id=\"btnOK\"]");
	By CancelButton = By.xpath("//*[@id=\"btnCancel\"]");
	
	public WebElement SwitchToScheduleCustomizeFrame() 
	{
		return driver.findElement(SwitchToScheduleCustomizeFrame);
	}
	public WebElement ScheduleCustomizeScreen() 
	{
		return driver.findElement(ScheduleCustomizeScreen);
	}
	public Select DefaultProviderDropDown() 
	{
		driver.findElement(DefaultProviderDropDown).click();
		BaseTest.Wait(1);
		Select s= new Select(driver.findElement(DefaultProviderDropDown));
		BaseTest.Wait(1);
		driver.findElement(DefaultProviderDropDown).click();
		return s;
	}
	public Select ScheduleContentDropDown() 
	{
		driver.findElement(ScheduleContentDropDown).click();
		BaseTest.Wait(1);
		Select s= new Select(driver.findElement(ScheduleContentDropDown));
		BaseTest.Wait(1);
		driver.findElement(ScheduleContentDropDown).click();
		return s;
	}
	public WebElement OkButton() 
	{
		return driver.findElement(OkButton);
	}
	public WebElement CancelButton() 
	{
		return driver.findElement(CancelButton);
	}
}
