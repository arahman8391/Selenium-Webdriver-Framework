package gov.dos.TouchWorks.PageFactory.Schedule_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Touch_Works_Print_Screen {

	WebDriver driver;
	
	public Touch_Works_Print_Screen(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By PrintPageIFrame = By.xpath("//*[@id=\"dialog0\"]/iframe");
	By PrintPreviewButton = By.xpath("//*[@id=\"btnPrintPreview\"]");
	
	public WebElement PrintPageIFrame() 
	{
		return driver.findElement(PrintPageIFrame);
	}
	public WebElement PrintPreviewButton() 
	{
		return driver.findElement(PrintPreviewButton);
	}
	
	By PrintPreviewParentFrame = By.xpath("//*[@id=\"dialog1\"]/iframe");
	By PrintPreviewChildFrame = By.xpath("//*[@id=\"divTWRTF\"]/table/tbody/tr[2]/td/iframe");
	By ScheduleContentText = By.xpath("/html/body/div");
	By DateText = By.xpath("/html/body/div/div[3]/span");
	
	public WebElement PrintPreviewParentFrame() 
	{
		return driver.findElement(PrintPreviewParentFrame);
	}
	public WebElement PrintPreviewChildFrame() 
	{
		return driver.findElement(PrintPreviewChildFrame);
	}
	public WebElement ScheduleContentText() 
	{
		return driver.findElement(ScheduleContentText);
	}
	public WebElement DateText() 
	{
		return driver.findElement(DateText);
	}
	
	By PrintPreviewScreenCloseButton = By.xpath("//*[@id=\"btnClose\"]");
	By PrintScreenCancelButton = By.xpath("//*[@id=\"btnEnvCancel\"]");
	
	public WebElement PrintPreviewScreenCloseButton() 
	{
		return driver.findElement(PrintPreviewScreenCloseButton);
	}
	public WebElement PrintScreenCancelButton() 
	{
		return driver.findElement(PrintScreenCancelButton);
	}
}
