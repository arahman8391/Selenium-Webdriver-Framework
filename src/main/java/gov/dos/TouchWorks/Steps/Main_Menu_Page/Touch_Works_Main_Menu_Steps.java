package gov.dos.TouchWorks.Steps.Main_Menu_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import gov.dos.Allscripts.Utility.BaseTest;
import gov.dos.TouchWorks.PageFactory.Main_Menu_Page.Touch_Works_Main_Menu_Bar;

public class Touch_Works_Main_Menu_Steps extends BaseTest {
	
	public Touch_Works_Main_Menu_Steps(WebDriver driver) {
		BaseTest.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void NavigateToPtRegAndApptsModule() {
		Touch_Works_Main_Menu_Bar m = new Touch_Works_Main_Menu_Bar(driver);
		BaseTest.WaitUntilClickable(driver, By.xpath("//*[@id=\"PtReg&Appts_AE\"]"), 60);
		if (m.PtRegAndAppts().isDisplayed()) {
			BaseTest.MoveToElement(driver, m.PtRegAndAppts());
			BaseTest.Wait(3);
			m.PtRegAndAppts().click();
			BaseTest.Wait(3);
			log.info("Successfully Selected Pt Reg & Appts Menu Tab....");
		} else {
			log.error("Unable To Select Pt Reg & Appts Menu Tab....");
		}
	}

	public void NavigateToScheduleModule() 
	{
		Touch_Works_Main_Menu_Bar m = new Touch_Works_Main_Menu_Bar(driver);
		BaseTest.WaitUntilClickable(driver, By.xpath("//*[@id=\"Schedule_AE\"]/div/header/div[2]/div[1]"),60);

		if (m.Schedule().isDisplayed()) {
			BaseTest.MoveToElement(driver, m.Schedule());
			BaseTest.Wait(3);
			m.Schedule().click();
			BaseTest.Wait(3);
			log.info("Successfully Selected Schedule Menu Tab....");
		} 
		else {
			log.error("Unable To Select Schedule Tab....");
		}
	}

	public void SignOutOfTouchWorks() 
	{
		Touch_Works_Main_Menu_Bar m = new Touch_Works_Main_Menu_Bar(driver);
		
		try {
			driver.navigate().refresh();
			driver.switchTo().alert().accept();
		} 
		catch (Exception e) {
			e.printStackTrace();
			log.info("Java Pop Up Is Not Displayed....");
		}
		
		try {
			BaseTest.WaitUntilClickable(driver, By.xpath("/html/body/div/div[1]/div[2]/div[3]/a"),60);
			BaseTest.MoveToElement(driver, m.SignInButton());
			m.SignInButton().click();
		} 
		catch (Exception e) {
			e.printStackTrace();
			log.error("Unable To Click Sign In Button....");
		}
	}
	
	public void NavigateToInbox() {
		Touch_Works_Main_Menu_Bar m = new Touch_Works_Main_Menu_Bar(driver);
		BaseTest.WaitUntilClickable(driver, By.xpath("//*[@id=\"Inbox_AE\"]"), 120);
		
		if (m.Inbox().isDisplayed()) {
			BaseTest.MoveToElement(driver, m.Inbox());
			BaseTest.Wait(3);
			m.Inbox().click();
			BaseTest.Wait(3);
			log.info("Successfully Selected Inbox Menu Tab....");
		} else {
			log.error("Unable To Select Inbox Menu Tab....");
		}
	}
}
